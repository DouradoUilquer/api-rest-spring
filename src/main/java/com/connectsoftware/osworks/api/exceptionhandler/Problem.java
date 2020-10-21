package com.connectsoftware.osworks.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

public class Problem {

	private Integer status;
	private LocalDateTime data;
	private String title;
	private List<Camp> camp;

	public List<Camp> getCamp() {
		return camp;
	}

	public void setCamp(List<Camp> camp) {
		this.camp = camp;
	}

	public static class Camp {
		private String name;
		private String msg;

		public Camp(String name, String msg) {
			super();
			this.name = name;
			this.msg = msg;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
