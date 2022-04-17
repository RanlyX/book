package app.validator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import app.property.InputFieldProperty;

public interface InputFieldPropertyChecker<T> {

	default String getGetterName(Field field) {
		String fieldName = field.getName();
		return "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
	}

	default boolean isNull(Object optionalField) throws Exception {
		Class<?> clazz = Optional.class;
		Method isPresent = clazz.getDeclaredMethod("isPresent");
		return ((boolean) isPresent.invoke(optionalField) == false);
	}

	default Object getOptional(Object optionalField) throws Exception {
		Class<?> clazz = Optional.class;
		Method isPresent = clazz.getDeclaredMethod("get");
		return isPresent.invoke(optionalField);
	}

	default Map<Field, Method> getGetterMapper(Class<T> requestClass) {
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

	default Map<Field, InputFieldProperty> getInputFieldPropertyMapper(Class<T> requestClass) {
		Map<Field, InputFieldProperty> getterMapper = new HashMap<>();
		for (Field field : requestClass.getDeclaredFields()) {
			InputFieldProperty dp = field.getAnnotation(InputFieldProperty.class);
			getterMapper.put(field, dp);
		}
		return getterMapper;
	}

	default void checkRange(InputFieldProperty ifp, Object fieldObject) throws Exception {
		switch (ifp.type()) {
		case SHORT:
			Short shortField = ((Short) fieldObject);
			checkNumberRange(ifp, shortField);
			break;
		case INTEGER:
			Integer integerField = ((Integer) fieldObject);
			checkNumberRange(ifp, integerField);
			break;
		case LONG:
			Long longField = ((Long) fieldObject);
			checkNumberRange(ifp, longField);
			break;
		case FLOAT:
			Float floatField = ((Float) fieldObject);
			checkNumberRange(ifp, floatField);
			break;
		case DOUBLE:
			Double doubleField = ((Double) fieldObject);
			checkNumberRange(ifp, doubleField);
			break;
		case STRING:
			String stringField = ((String) fieldObject);
			checkStringLength(ifp, stringField);
			break;
		case LIST:
			List<?> listField = ((List<?>) fieldObject);
			checkListLength(ifp, listField);
			break;
		default:
			break;
		}
	}

	default void checkNumberRange(InputFieldProperty ifp, Object fieldObject) throws Exception {
		Double min = ifp.min();
		Double max = ifp.max();
		InputFieldProperty.Type inputFieldType = ifp.type();
		InputFieldProperty.CheckRange InputFieldCheckRangeType = ifp.checkRange();
		switch (inputFieldType) {
		case SHORT:
			if (fieldObject instanceof Short) {
				Short value = ((Short) fieldObject).shortValue();
				switch (InputFieldCheckRangeType) {
				case BOTH:
					if (value < min.shortValue() || value > max.shortValue())
						throw new Exception("Range Error");
				case LOWER:
					if (value < min.shortValue())
						throw new Exception("Range Error");
				case UPPER:
					if (value > max.shortValue())
						throw new Exception("Range Error");
				default:
					break;
				}
			}
			break;
		case INTEGER:
			if (fieldObject instanceof Integer) {
				Integer value = ((Integer) fieldObject).intValue();
				switch (InputFieldCheckRangeType) {
				case BOTH:
					if (value < min.intValue() || value > max.intValue())
						throw new Exception("Range Error");
				case LOWER:
					if (value < min.intValue())
						throw new Exception("Range Error");
				case UPPER:
					if (value > max.intValue())
						throw new Exception("Range Error");
				default:
					break;
				}
			}
			break;
		case LONG:
			if (fieldObject instanceof Long) {
				Long value = ((Long) fieldObject).longValue();
				switch (InputFieldCheckRangeType) {
				case BOTH:
					if (value < min.longValue() || value > max.longValue())
						throw new Exception("Range Error");
				case LOWER:
					if (value < min.longValue())
						throw new Exception("Range Error");
				case UPPER:
					if (value > max.longValue())
						throw new Exception("Range Error");
				default:
					break;
				}
			}
			break;
		case FLOAT:
			if (fieldObject instanceof Float) {
				Float value = ((Float) fieldObject).floatValue();
				switch (InputFieldCheckRangeType) {
				case BOTH:
					if (value < min.floatValue() || value > max.floatValue())
						throw new Exception("Range Error");
				case LOWER:
					if (value < min.floatValue())
						throw new Exception("Range Error");
				case UPPER:
					if (value > max.floatValue())
						throw new Exception("Range Error");
				default:
					break;
				}
			}
			break;
		case DOUBLE:
			if (fieldObject instanceof Double) {
				Double value = ((Double) fieldObject).doubleValue();
				switch (InputFieldCheckRangeType) {
				case BOTH:
					if (value < min || value > max)
						throw new Exception("Range Error");
				case LOWER:
					if (value < min)
						throw new Exception("Range Error");
				case UPPER:
					if (value > max)
						throw new Exception("Range Error");
				default:
					break;
				}
			}
			break;
		default:
			break;
		}
	}

	default void checkListLength(InputFieldProperty ifp, List<?> list) throws Exception {
		Double min = ifp.min();
		Double max = ifp.max();
		InputFieldProperty.CheckRange inputFieldCheckRangeType = ifp.checkRange();
		int listLength = list.size();
		switch (inputFieldCheckRangeType) {
		case BOTH:
			if (listLength < min.intValue() || listLength > max.intValue())
				throw new Exception("Range Error");
		case LOWER:
			if (listLength < min.intValue())
				throw new Exception("Range Error");
		case UPPER:
			if (listLength > max.intValue())
				throw new Exception("Range Error");
		default:
			break;
		}
	}

	default void checkStringLength(InputFieldProperty ifp, String string) throws Exception {
		Double min = ifp.min();
		Double max = ifp.max();
		InputFieldProperty.CheckRange inputFieldCheckRangeType = ifp.checkRange();
		int stringLength = string.length();
		switch (inputFieldCheckRangeType) {
		case BOTH:
			if (stringLength < min.intValue() || stringLength > max.intValue())
				throw new Exception("Range Error");
		case LOWER:
			if (stringLength < min.intValue())
				throw new Exception("Range Error");
		case UPPER:
			if (stringLength > max.intValue())
				throw new Exception("Range Error");
		default:
			break;
		}
	}

	default void checkInputFieldProperty(T t) throws Exception {
		// Unknown reason cannot use
		// Class<T> clazz = (Class<T>) ((ParameterizedType)
		// getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) this.getGenericClass();
		Constructor<T> constructor = clazz.getDeclaredConstructor(clazz);
		T request = (T) constructor.newInstance(t);
		Field[] fields = clazz.getDeclaredFields();
		Map<Field, Method> getterMapper = getGetterMapper(clazz);
		Map<Field, InputFieldProperty> inputFieldPropertyMapper = getInputFieldPropertyMapper(clazz);
		for (Field field : fields) {
			Method getter = getterMapper.get(field);
			InputFieldProperty ifp = inputFieldPropertyMapper.get(field);
			if (ifp != null && getter != null) {
				Object fieldObject = getter.invoke(request);
				// if property is required, but not found
				if (ifp.required() && fieldObject == null) {
					throw new Exception("Missing " + field.getName() + ", the property is required.");
				} else {
					// if property existed and wasn't nullable, but value is
					// null
					if (fieldObject != null && !ifp.nullable() && this.isNull(fieldObject)) {
						throw new Exception(field.getName() + " is null, the property cannot be null.");
					}
				}
				if (fieldObject != null) {
					if (!this.isNull(fieldObject))
						this.checkRange(ifp, getOptional(fieldObject));
				}
			}
		}
	}

	Class<?> getGenericClass();

}
