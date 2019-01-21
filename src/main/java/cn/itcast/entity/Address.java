package cn.itcast.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotBlank;

import cn.itcast.validation.group.CustomerAdd;

public class Address implements Serializable{
	private static final long serialVersionUID = 8456286672834625513L;
	@NotBlank(message="国籍不能为空", groups= {CustomerAdd.class})
	private String nationality;
	@NotBlank(message="省份不能为空", groups= {CustomerAdd.class})
	private String province;
	@NotBlank(message="城市不能为空", groups= {CustomerAdd.class})
	private String city;
	
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [nationality=" + nationality + ", province=" + province + ", city=" + city + "]";
	}
}
