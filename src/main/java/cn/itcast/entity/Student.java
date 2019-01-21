package cn.itcast.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class Student implements Serializable{
	private static final long serialVersionUID = 6223505818681222199L;
	private Integer stuId;
	private String sname;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthDate;
	@NumberFormat
	private Double score;
	
	public Integer getStuId() {
		return stuId;
	}
	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", sname=" + sname + ", birthDate=" + birthDate + "]";
	}
	
}
