package com.talk2amareswaran.projects.resourceserver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsersByRoleResourceDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public Object viewUsersByRole(String role_id) {

		Collection<Map<String, Object>> rows3 = jdbcTemplate.queryForList(
				"select u.id,u.first_name, u.last_name, u.email_id, u.country, u.user_type, u.mobile from users u "
						+ "inner join role_users role_u on u.id=role_u.user_id " + "where role_u.role_id=?",
				new Object[] { role_id });
		List<UserModel> usersList = new ArrayList<>();
		rows3.stream().map((row) -> {
			UserModel user = new UserModel();
			user.setCountry((String) row.get("country"));
			user.setEmail_id((String) row.get("email_id"));
			user.setFirst_name((String) row.get("first_name"));
			user.setId(String.valueOf(row.get("id")));
			user.setLast_name((String) row.get("last_name"));
			user.setMobile((String) row.get("mobile"));
			user.setUser_type((String) row.get("user_type"));
			return user;
		}).forEach((ss3) -> {
			usersList.add(ss3);
		});
		return usersList;

	}

	public void assignUsers2Role(String role_id, ArrayList<String> usersList) { 	
		jdbcTemplate.update("delete from role_users where role_id=?", new Object[] {role_id});
		for(String id:usersList) {
			jdbcTemplate.update("insert into role_users (role_id, user_id) values (?,?)", new Object[]{role_id,id});
		}
	}
}