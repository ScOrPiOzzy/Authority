package com.cas.lock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import com.cas.lock.entiry.AuthorityEntity;

public class AuthorityApp {
	private static ScheduledExecutorService timerClockPool = Executors.newSingleThreadScheduledExecutor();

	public static void main(String[] args) {

		// FutureTask<Integer> futureTask = new FutureTask<>(new
		// ValidateThread("com.cas.s0001-V1.0.0"));
		ValidateThread v = new ValidateThread("555");
		FutureTask<Integer> futureTask = new FutureTask<>(v);
		new Thread(futureTask).start();
		int result = -1;
		try {
			result = futureTask.get(20, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);

		if (result == Consts.AUTHORITY_FILE_AVAILABLE) {
			AuthorityEntity entity = v.getEntity();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date fromDate = format.parse(entity.getFromDate());
				Date endDate = format.parse(entity.getEndDate());
				Thread t = new Thread(new TimerClock(fromDate, endDate));
				// 设置未守护线程
				t.setDaemon(true);
				ScheduledFuture<?> scheduleTask = timerClockPool.scheduleAtFixedRate(t, 0, 30, TimeUnit.MINUTES);
				scheduleTask.get();
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
