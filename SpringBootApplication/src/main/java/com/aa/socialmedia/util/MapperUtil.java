package com.aa.socialmedia.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperUtil {

	@Autowired
	private ModelMapper mapper;

	public <D, T> D convert(T obj, Class<D> modelClass) {
		return mapper.map(obj, modelClass);

	}
}
