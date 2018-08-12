package com.charas.account.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

public class NewNamingConvention extends SpringPhysicalNamingStrategy {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	 @Override
	    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
	        return new Identifier(name.getText(), name.isQuoted());
	    }
}
