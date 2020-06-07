package com.talk2amareswaran.projects.resourceserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleResource {

	@Autowired
	RolesDAO rolesDAO;

	@PreAuthorize("hasAnyRole('view_role', 'SUPERADMIN')")
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public ResponseEntity<Object> getListOfRoles() {
		return new ResponseEntity<Object>(rolesDAO.getListOfRoles(), HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('delete_role', 'SUPERADMIN')")
	@RequestMapping(value = "/roles/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteRole(@PathVariable("id") String role_id) {
		rolesDAO.deleteRole(role_id);
		return new ResponseEntity<Object>("Role deleted successfully", HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('edit_role', 'SUPERADMIN')")
	@RequestMapping(value = "/roles/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> deleteRole(@PathVariable("id") String role_id, @RequestBody UserRole role) {
		rolesDAO.updateRole(role_id, role);
		return new ResponseEntity<Object>("Role updated successfully", HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('create_role', 'SUPERADMIN')")
	@RequestMapping(value = "/roles", method = RequestMethod.POST)
	public ResponseEntity<Object> createRole(@RequestBody UserRole role) {
		rolesDAO.createRole(role);
		return new ResponseEntity<Object>("Role created successfully", HttpStatus.OK);
	}
}