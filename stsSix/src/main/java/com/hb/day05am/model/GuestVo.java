package com.hb.day05am.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class GuestVo {
	@NotNull
	@Min(1000)
	private int sabun;
	
	@NotNull
	@Email
	@Size(min = 5) //이메일 형식에 맞추려면 최소 5자 이상 필요
	private String name; 
	private String nalja;
	@NotNull
	private int pay;
	
	public GuestVo() {
		// TODO Auto-generated constructor stub
	}

	public GuestVo(int sabun, String name, String nalja, int pay) {
		super();
		this.sabun = sabun;
		this.name = name;
		this.nalja = nalja;
		this.pay = pay;
	}

	public int getSabun() {
		return sabun;
	}

	public int getPay() {
		return pay;
	}

	public String getName() {
		return name;
	}

	public String getNalja() {
		return nalja;
	}

	public void setSabun(int sabun) {
		this.sabun = sabun;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNalja(String nalja) {
		this.nalja = nalja;
	}

	@Override
	public String toString() {
		return "GuestVo [sabun=" + sabun + ", name=" + name + ", nalja=" + nalja + ", pay=" + pay + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nalja == null) ? 0 : nalja.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + pay;
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
		GuestVo other = (GuestVo) obj;
		if (nalja == null) {
			if (other.nalja != null)
				return false;
		} else if (!nalja.equals(other.nalja))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pay != other.pay)
			return false;
		if (sabun != other.sabun)
			return false;
		return true;
	}
	
}
