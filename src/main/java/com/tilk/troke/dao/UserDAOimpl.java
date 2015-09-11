package com.tilk.troke.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import com.tilf.troke.model.User;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;


public class UserDAOimpl implements UserDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	public UserDAOimpl (DataSource datasource)
	{
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public void saveOrUpdate(User user) {
		if(user.getId()!= null)
		{
			// UPDATE 
			String sql = "UPDATE TUSERS SET FIRSTNAME=?, LASTNAME=?, PASS=?,"
					+ 							"EMAIL=?, TELEPHONE=?, ZIPCODE=?,AVATAR=? WHERE IDUSER=?";
			jdbcTemplate.update(sql,user.getFirstname(),user.getName(), user.getPassword(), user.getEmail(),
									user.getTelephone(), user.getZipcode(), user.getPhoto(), user.getId());
		}
		else
		{
			// INSERT
			String sql = "INSERT INTO TUSERS (FIRSTNAME, LASTNAME, PASS, EMAIL, TELEPHONE, ZIPCODE, AVATAR)"
					+ "VALUES(?,?,?,?,?,?,?)";
			
			jdbcTemplate.update(sql, user.getFirstname(), user.getName(), user.getPassword(), user.getEmail(),
										user.getTelephone(),user.getZipcode(), user.getPhoto());
		}
		
	}

	@Override
	public void delete(int idUser) {
		// delete user
		
		String sql = "DELETE FROM TUSERS WHERE IDUSER=?";
		
		jdbcTemplate.update(sql,idUser);
		
	}

	@Override
	public User get(int idUser) {
		String sql = "SELECT * FROM TUSERS WHERE IDUSER=" + idUser;
		
		return jdbcTemplate.query(sql, new ResultSetExtractor<User>(){
			@Override
				public User extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			if (rs.next()) {
				User user = new User();
				
				user.setId(rs.getString("id"));	
				user.setName(rs.getString("name"));
				user.setFirstname(rs.getString("firstname"));
				user.setEmail(rs.getString("email"));
				user.setPhoto(rs.getString("photo"));
				user.setTelephone(rs.getString("telephone"));
				user.setPassword(rs.getString("password"));
				user.setZipcode(rs.getString("zipcode"));
				user.setState((char) rs.getShort("state"));
				user.setOnline((char)rs.getShort("online"));
				user.setCreationdate(rs.getDate("creationdate"));
				user.setPermissionlevel(rs.getInt("permissionlevel"));
				user.setIsvip((char)rs.getShort("isvip"));
				
				return user;
			}
			
			return null;
		}
		
	});
		
	}

	@Override
	public List<User> listUser() {
		String sql = "SELECT * FROM TUSERS ";
		List<User> listContact = jdbcTemplate.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User aUser = new User();
	
				aUser.setId(rs.getString("IDUSER"));
				aUser.setFirstname(rs.getString("FIRSTNAME"));
				aUser.setName(rs.getString("LASTNAME"));
				aUser.setEmail(rs.getString("EMAIL"));
				aUser.setPhoto(rs.getString("AVATAR"));
				aUser.setTelephone(rs.getString("TELEPHONE"));
				aUser.setZipcode(rs.getString("ZIPCODE"));
				aUser.setState((char)rs.getShort("ISBANNED"));
				aUser.setOnline((char)rs.getShort("ISONLINE"));
				aUser.setCreationdate(rs.getDate("CREATIONDATE"));
				aUser.setPermissionlevel(rs.getInt("PERMISSIONLEVEL"));
				aUser.setIsvip((char)rs.getShort("ISVIP"));

							
				return aUser;
			}
			
		});
		
		return listContact;
	}
	
	
	

}
