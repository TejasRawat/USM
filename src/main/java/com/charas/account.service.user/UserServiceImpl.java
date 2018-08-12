package com.charas.account.service.user;

import com.charas.account.models.user.UserRegistrationRequestModel;
import com.charas.account.repository.UserAccountRepository;
import com.charas.account.repository.UserSessionRepository;
import com.charas.account.repository.UserTokenRepository;
import com.charas.account.repository.model.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserAccountRepository userAccountRepository;

	@Autowired
	private UserTokenRepository userTokenRepository;

	@Autowired
	private UserSessionRepository userSessionRepository;

	@Override
	public boolean registerUser(UserRegistrationRequestModel userRegistrationRequestModel) {

		UserSession session = new UserSession();

		try {
			userSessionRepository.save(session);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return true;
	}

}
