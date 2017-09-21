package com.cas.lock;

import java.util.Date;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * 每隔一段时间，记录下当前的系统时间并保存到文件中。<br>
 * 软件运行时，记录时间。<br>
 * 运行过程中，可以半个小时记录一次。<br>
 * 软件关闭时，记录时间。<br>
 * 
 * @author admin
 *
 */
public class TimerClock implements Runnable {
	private Date fromDate;
	private Date currentDate;
	private Date endDate;

	public TimerClock(Date fromDate, Date endDate) {
		super();
		this.fromDate = fromDate;
		this.endDate = endDate;
	}

	@Override
	public void run() {
		// 即将保存当前时间点
		currentDate.setTime(System.currentTimeMillis());

		// 读取文件中已保存的日期并解密

		// TODO 将当前系统时间保存到文件中
		// 尝试从公司服务器获取时间
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(Consts.BASE_SERVER_URI + "time");
		Long d = target.request().get().readEntity(Long.class);
		if (d != null) {
			// 以公司服务器时间为准。
			currentDate.setTime(d);
		}

		// TODO 读取文件中记录的时间戳
		Date timestamp = null;
		// TODO 将当前时间加密并保存到文件中(ASE加密)

		// 如果当前时间在过期时间之后，则软件运行到期了
		if (currentDate.after(endDate)) {
			// 过期了
			throw new RuntimeException("很抱歉，您的证书已过期！如有需要，请联系我们。");
		} else if (currentDate.before(timestamp)) {
			// 日期被修改了，并提前了
			throw new RuntimeException("很抱歉，软件运行的必要数据被破坏，我们将停止软件的运行！请联系我们。");
		} else {
			// 日期没问题
		}
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getTmpDate() {
		return currentDate;
	}

	public void setTmpDate(Date tmpDate) {
		this.currentDate = tmpDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
