package com.cas.authority.javafx.controller;

import com.cas.authority.action.RegisterAction;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UserRegistController {
	private Stage stage;

	@FXML
	private TextField username;
	@FXML
	private TextArea code;

	@FXML
	public void cancel() {
		System.exit(0);
	}

	@FXML
	public void register() {
		new RegisterAction() {
			@Override
			protected String getRegistCode() {
				return code.getText();
			}

			protected String getUserName() {
				return username.getText();
			}

			@Override
			protected boolean reRegistration() {
				return true;
			}

			protected void onRegistResult(boolean success) {
				if (success) {
					f_alert_informationDialog("注册成功", "恭喜你，产品注册成功，开始使用吧");
				} else {
					f_alert_informationDialog("注册失败", "很抱歉，产品尚未激活，请联系我们");
				}
			}
		}.execute();
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

//  弹出一个信息对话框
	public void f_alert_informationDialog(String p_header, String p_message) {
		Alert _alert = new Alert(Alert.AlertType.INFORMATION);
		_alert.setTitle("提示消息");
		_alert.setHeaderText(p_header);
		_alert.setContentText(p_message);
		_alert.initOwner(stage);
		_alert.show();
	}
}
