package com.charas.account.repository;

import org.springframework.data.repository.CrudRepository;

import com.charas.account.models.UserSession;

public interface UserSessionRepository extends CrudRepository<UserSession, Integer>{

}
