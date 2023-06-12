package com.ecommerce.shoes.repository;

import org.springframework.data.repository.CrudRepository;

import com.ecommerce.shoes.model.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	
	Role findByName(String name);

}
