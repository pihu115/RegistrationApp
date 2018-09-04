package com.beuno.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user_details")
public class UserDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5012293988961612590L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id", unique = true, nullable = false)
	private Long userId;
	
	@Column(name="f_name",length=15)
	private String fName;
	
	@Column(name="m_name",length=15)
	private String mName;
	
	@Column(name="l_name",length=15)
	private String lName;
	
	@Column(name="m_no",length=10,nullable = false)
	private String mNo;
	
	@Column(name="gender",length=10)
	private String gender;
	
	@Column(name="email_id",length=30,nullable = false)
	private String emailId;
	
	@Column(name="password",length=30)
	private String password;
	
	@Column(name="country",length=30)
	private String country;
	
	@Column(name="area",length=30)
	private String area;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getmNo() {
		return mNo;
	}

	public void setmNo(String mNo) {
		this.mNo = mNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", fName=" + fName + ", mName=" + mName + ", lName=" + lName + ", mNo="
				+ mNo + ", gender=" + gender + ", emailId=" + emailId + ", password=" + password + ", country="
				+ country + ", area=" + area + "]";
	}
	
	

}