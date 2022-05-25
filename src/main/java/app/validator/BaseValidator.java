package app.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public interface BaseValidator<R, AN extends Annotation> {

    default String getGetterName(Field field) {
		String fieldName = field.getName();
		return "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
	}

    default Map<Field, Method> getGetterMapper(Class<R> requestClass) {
		Map<Field, Method> getterMapper = new HashMap<>();
		for (Field field : requestClass.getDeclaredFields()) {
			Method method;
			try {
				method = requestClass.getDeclaredMethod(this.getGetterName(field));
				getterMapper.put(field, method);
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		}
		return getterMapper;
	}

	default Object getOptional(Object optionalField) throws Exception {
		Class<?> clazz = Optional.class;
		Method isPresent = clazz.getDeclaredMethod("get");
		return isPresent.invoke(optionalField);
	}

	default Map<Field, AN> getInputFieldPropertyMapper(Class<R> requestClass, Class<AN> annotationClass) {
		Map<Field, AN> getterMapper = new HashMap<>();
		for (Field field : requestClass.getDeclaredFields()) {
			AN dp = field.getAnnotation(annotationClass);
			getterMapper.put(field, dp);
		}
		return getterMapper;
	}

}