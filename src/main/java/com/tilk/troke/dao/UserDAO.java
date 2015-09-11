package com.tilk.troke.dao;
import com.tilf.troke.model.*;
import java.util.List;


/* Interface pour la classe User */


public interface UserDAO {
	
	public void saveOrUpdate(User user);
	public void delete (int idUser);
	public User get (int idUser);
	public List<User> listUser();	

}
