package com.curd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curd.entities.User;

public interface UserRepository extends JpaRepository<User, Long>
{

}
