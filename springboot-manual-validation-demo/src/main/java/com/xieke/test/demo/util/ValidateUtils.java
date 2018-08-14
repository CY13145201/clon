package com.xieke.test.demo.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 * 参数校验工具类
 * 
 * @author jun hu
 *
 */
public class ValidateUtils {

	private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

	/**
	 * 参数校验
	 * 
	 * @param obj
	 *            校验对象
	 * @return 校验错误信息集合
	 */
	public static <T> List<String> validate(T obj) {
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
		List<String> messageList = new ArrayList<>();
		for (ConstraintViolation<T> constraintViolation : constraintViolations) {
			messageList.add(constraintViolation.getMessage());
		}
		return messageList;
	}

	/**
	 * 参数校验
	 * 
	 * @param obj
	 *            校验对象
	 * @return 校验错误信息（key：字段名称，value：错误信息）集合
	 */
	public static <T> Map<String, String> validParam(T obj) {
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
		Map<String, String> messageList = new HashMap<>();
		for (ConstraintViolation<T> constraintViolation : constraintViolations) {
			messageList.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
		}
		return messageList;
	}

	/**
	 * 参数校验
	 * 
	 * @param obj
	 *            校验对象
	 * @return 随机一条校验错误信息
	 */
	public static <T> String valid(T obj) {
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
		if (constraintViolations.isEmpty()) {
			return null;
		}
		return constraintViolations.iterator().next().getMessage();
	}

	/**
	 * 参数校验
	 * 
	 * @param obj
	 *            校验对象
	 * @return 是否通过校验
	 */
	public static <T> Boolean isValid(T obj) {
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(obj);
		if (constraintViolations.isEmpty()) {
			return true;
		}
		return false;
	}

}