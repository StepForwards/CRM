package com.forward.tools;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

public class MyBeanUtils {
	
	 static{
	        DateConverter converter = new DateConverter();
	        converter.setPattern("yyyy-MM-dd hh:mm");
	        ConvertUtils.register(converter, Timestamp.class);
	    }
	    public static void populate(Object obj,Map<String,String[]> map) throws IllegalAccessException, InvocationTargetException {
	        
	    	BeanUtils.populate(obj, map);	        
	    }

}
