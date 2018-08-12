package com.charas.account.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.charas.account.models.UserToken;

@Repository
public interface UserTokenRepository extends CrudRepository<UserToken, Integer> {

}
