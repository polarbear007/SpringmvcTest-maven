package cn.itcast.entity;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import cn.itcast.validation.group.CustomerAdd;
import cn.itcast.validation.group.CustomerUpdate;

public class Customer implements Serializable {
	private static final long serialVersionUID = 3153131970534837980L;
	@NotNull(message = "客户Id不能为空", groups = { CustomerUpdate.class })
	private Integer cid;
	@NotBlank(message = "客户姓名不能为空", groups = { CustomerAdd.class })
	private String cname;
	@NotBlank(message = "客户电话不能为空", groups = { CustomerAdd.class })
	private String phone;
	@Valid
	private Address address;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", phone=" + phone + ", address=" + address + "]";
	}

}
