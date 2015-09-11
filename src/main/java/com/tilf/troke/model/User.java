package com.tilf.troke.model;
import java.sql.Date;

public class User {

	private String id;
	private String name;
	private String firstname;
	private String email;
	private String photo;
	private String telephone;
	private String password;
	private String zipcode;
	private char state;
	private char online;
	private Date creationdate;
	private int permissionlevel;
	private char isvip;



	public User()
	{

	}
	
	public User(String name, String firstname,String id,String email, String photo, String telephone,
				String zipcode, char state, char online,Date creationdate, int permissionlevel,char isvip, String password )
	{
		this.name = name;
		this.firstname = firstname;
		this.id = id;
		this.email = email;
		this.photo = photo;
		this.telephone = telephone;
		this.zipcode = zipcode;
		this.setState(state); // ISBANNED
		this.setOnline(online);
		this.creationdate = creationdate;
		this.permissionlevel = permissionlevel;
		this.isvip = isvip;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public Date getCreationdate() {
		return creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public int getPermissionlevel() {
		return permissionlevel;
	}

	public void setPermissionlevel(int permissionlevel) {
		this.permissionlevel = permissionlevel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public char getState() {
		return state;
	}

	public void setState(char state) {
		this.state = state;
	}

	public char getOnline() {
		return online;
	}

	public void setOnline(char online) {
		this.online = online;
	}

	public char getIsvip() {
		return isvip;
	}

	public void setIsvip(char isvip) {
		this.isvip = isvip;
	}
}
