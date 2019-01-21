package cn.itcast.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;

public class Teacher implements Serializable {
	private static final long serialVersionUID = 146274999216277403L;
	@NotNull
	private Integer tid;
	@NotEmpty(message="姓名不能为空")
	private String tname;
	// 这是个枚举类型，不知道怎么校验，所以暂时就不写了
	private GenderType gender;
	@DecimalMin(value="0.0", message="非法参数，工资不能低于0.0")
	private Double salary;
	@Past(message="出生日期必须比当前日期早")
	private Date birthDate;

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", gender=" + gender + ", salary=" + salary + ", birthDate="
				+ birthDate + "]";
	}

}
