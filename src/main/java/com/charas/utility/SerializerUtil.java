package com.charas.utility;

import java.io.IOException;

public interface SerializerUtil {
	
	public byte[] serialize(Object object) throws IOException;
	
	public Object deSerialize(byte[] bytes) throws IOException, ClassNotFoundException;

}
