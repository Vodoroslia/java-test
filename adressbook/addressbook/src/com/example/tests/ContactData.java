package com.example.tests;

public class ContactData  implements Comparable <ContactData > {
	private String firstname;
	private String lastname;
	private String address;
	private String home;
	private String mobile;
	private String work;
	private String email;
	private String email2;
	private String bday;
	private String bmonth;
	private String byear;
	private String address2;
	private String phone2;
	public ContactData() {
		
	}
	

	public ContactData(String firstname, String lastname, String address,
			String home, String mobile, String work, String email,
			String email2, String bday, String bmonth, String byear,
			String address2, String phone2) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.home = home;
		this.mobile = mobile;
		this.work = work;
		this.email = email;
		this.email2 = email2;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.address2 = address2;
		this.phone2 = phone2;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
	//	result = prime * result
	//			+ ((firstname == null) ? 0 : firstname.hashCode());
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
		ContactData other = (ContactData) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		return true;
	}


	

	@Override
	public String toString() {
		return "ContactData [firstname=" + firstname + ", lastname=" + lastname
				+ ", address=" + address + "]";
	}


	@Override
	public int compareTo(ContactData other) {
		// TODO Auto-generated method stub
		
		return this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase());
	}


	public ContactData withFirstname(String firstname) {
		this.firstname = firstname;
		// TODO Auto-generated method stub
		return this;
	}


	public ContactData withLastname(String lastname) {
		this.lastname = lastname;
		// TODO Auto-generated method stub
		return this;
	}


	public ContactData withAddress(String address) {
		this.address = address;
		// TODO Auto-generated method stub
		return this;
	}


	public ContactData withHome(String home) {
		this.home = home;
		// TODO Auto-generated method stub
		return this;
	}


	public ContactData withMobile(String mobile) {
		this.mobile = mobile;
		// TODO Auto-generated method stub
		return this;
	}


	public ContactData withWork(String work) {
		
		this.work = work;
		// TODO Auto-generated method stub
		return this;
	}


	public ContactData withEmail(String email) {
		this.email = email;
		// TODO Auto-generated method stub
		return this;
	}


	public ContactData  withEmail2(String email2) {
		this.email2 = email2;
		// TODO Auto-generated method stub
		return this;
	}


	public ContactData withBday(String bday) {
		this.bday = bday;
		// TODO Auto-generated method stub
		return this;
	}


	public ContactData withBmonth(String bmonth) {
		this.bmonth = bmonth;
		// TODO Auto-generated method stub
		return this;
	}


	public ContactData withByear(String byear) {
		this.byear = byear;
		// TODO Auto-generated method stub
		return this;
	}


	public ContactData withAddress2(String address2) {
		this.address2 = address2;
		// TODO Auto-generated method stub
		return this;
	}


	public ContactData withPhone2(String phone2) {
		this.phone2 = phone2;
		// TODO Auto-generated method stub
		return this;
	}


	public String getFirstname() {
		return firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public String getAddress() {
		return address;
	}


	public String getHome() {
		return home;
	}


	public String getMobile() {
		return mobile;
	}


	public String getWork() {
		return work;
	}


	public String getEmail() {
		return email;
	}


	public String getEmail2() {
		return email2;
	}


	public String getBday() {
		return bday;
	}


	public String getBmonth() {
		return bmonth;
	}


	public String getByear() {
		return byear;
	}


	public String getAddress2() {
		return address2;
	}


	public String getPhone2() {
		return phone2;
	}


	
}