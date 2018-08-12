package com.charas.account.service.user;

import com.charas.account.models.user.UserRegistrationRequestModel;

public interface UserService {

	boolean registerUser(UserRegistrationRequestModel userRegistrationRequestModel);

}
