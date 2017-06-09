package com.hb.day02.user.model;

import java.sql.Date;

public class GuestUserVo {
	private int num;
	private int sabun;
	private String name;
	private Date nalja;
	
	public GuestUserVo() {
	}

	public GuestUserVo(int num, int sabun, String name, Date nalja) {
		super();
		this.num = num;
		this.sabun = sabun;
		this.name = name;
		this.nalja = nalja;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getSabun() {
		return sabun;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getNalja() {
		return nalja;
	}

	public void setNalja(Date nalja) {
		this.nalja = nalja;
	}

	@Override
	public String toString() {
		return "GuestUserVo [num=" + num + ", sabun=" + sabun + ", name=" + name + ", nalja=" + nalja + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + num;
		result = prime * result + sabun;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GuestUserVo other = (GuestUserVo) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (num != other.num)
			return false;
		if (sabun != other.sabun)
			return false;
		return true;
	}
	

}