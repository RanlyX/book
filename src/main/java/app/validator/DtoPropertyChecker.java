package app.validator;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import app.property.DtoProperty;

public interface DtoPropertyChecker<T> {

	default String getGetterName(Field field) {
		String fieldName = field.getName();
		return "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
	}

	default boolean isNull(Object optionalField) throws Exception {
		Class<?> clazz = Optional.class;
		Method isPresent = clazz.getDeclaredMethod("isPresent");
		return ((boolean) isPresent.invoke(optionalField, null) == false);
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

	default Map<Field, DtoProperty> getDtoPropertyMapper(Class<T> requestClass) {
		Map<Field, DtoProperty> getterMapper = new HashMap<>();
		for (Field field : requestClass.getDeclaredFields()) {
			DtoProperty dp = field.getAnnotation(DtoProperty.class);
			getterMapper.put(field, dp);
		}
		return getterMapper;
	}

	// TODO: check when compile is better
	default void checkType(DtoProperty dp, Object fieldObject) throws Exception {
		switch (dp.type()) {
			case ANY:
				break;
			case BOOLEAN:
				if (fieldObject instanceof Boolean)
					throw new Exception(
							"DtoProperty type \"" + dp.type().toString() + "\" does not match field type \"Boolean\"");
			case BYTE:
				if (fieldObject instanceof Byte)
					throw new Exception(
							"DtoProperty type \"" + dp.type().toString() + "\" does not match field type \"Byte\"");
			case SHORT:
				if (fieldObject instanceof Short)
					throw new Exception(
							"DtoProperty type \"" + dp.type().toString() + "\" does not match field type \"Short\"");
			case INTEGER:
				if (fieldObject instanceof Integer)
					throw new Exception(
							"DtoProperty type \"" + dp.type().toString() + "\" does not match field type \"Integer\"");
			case LONG:
				if (fieldObject instanceof Long)
					throw new Exception(
							"DtoProperty type \"" + dp.type().toString() + "\" does not match field type \"Long\"");
			case FLOAT:
				if (fieldObject instanceof Float)
					throw new Exception(
							"DtoProperty type \"" + dp.type().toString() + "\" does not match field type \"Float\"");
			case DOUBLE:
				if (fieldObject instanceof Double)
					throw new Exception(
							"DtoProperty type \"" + dp.type().toString() + "\" does not match field type \"Double\"");
			case STRING:
				if (fieldObject instanceof String)
					throw new Exception(
							"DtoProperty type \"" + dp.type().toString() + "\" does not match field type \"String\"");
			case LIST:
				if (fieldObject instanceof List)
					throw new Exception(
							"DtoProperty type \"" + dp.type().toString() + "\" does not match field type \"List\"");
			case ENUM:
				if (fieldObject instanceof Enum)
					throw new Exception(
							"DtoProperty type \"" + dp.type().toString() + "\" does not match field type \"Enum\"");
			case DATE:
				if (fieldObject instanceof Date)
					throw new Exception(
							"DtoProperty type \"" + dp.type().toString() + "\" does not match field type \"Date\"");
			default:
				break;
		}
	}

	default void checkRange(DtoProperty dp, Object fieldObject) throws Exception {
		switch (dp.type()) {
			case SHORT:
				Short shortField = ((Short) fieldObject);
				checkNumberRange(dp, shortField);
				break;
			case INTEGER:
				Integer integerField = ((Integer) fieldObject);
				checkNumberRange(dp, integerField);
				break;
			case LONG:
				Long longField = ((Long) fieldObject);
				checkNumberRange(dp, longField);
				break;
			case FLOAT:
				Float floatField = ((Float) fieldObject);
				checkNumberRange(dp, floatField);
				break;
			case DOUBLE:
				Double doubleField = ((Double) fieldObject);
				checkNumberRange(dp, doubleField);
				break;
			case STRING:
				String stringField = ((String) fieldObject);
				checkStringLength(dp, stringField);
				break;
			case LIST:
				List<?> listField = ((List<?>) fieldObject);
				checkListLength(dp, listField);
				break;
			default:
				break;
		}
	}

	default void checkNumberRange(DtoProperty dp, Object fieldObject) throws Exception {
		Double min = dp.min();
		Double max = dp.max();
		DtoProperty.Type dtoType = dp.type();
		DtoProperty.CheckRange dtoCheckRangeType = dp.checkRange();
		switch (dtoType) {
			case SHORT:
				if (fieldObject instanceof Short) {
					Short value = ((Short) fieldObject).shortValue();
					switch (dtoCheckRangeType) {
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
					switch (dtoCheckRangeType) {
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
					switch (dtoCheckRangeType) {
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
					switch (dtoCheckRangeType) {
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
					switch (dtoCheckRangeType) {
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

	default void checkListLength(DtoProperty dp, List<?> list) throws Exception {
		Double min = dp.min();
		Double max = dp.max();
		DtoProperty.CheckRange dtoCheckRangeType = dp.checkRange();
		int listLength = list.size();
		switch (dtoCheckRangeType) {
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

	default void checkStringLength(DtoProperty dp, String string) throws Exception {
		Double min = dp.min();
		Double max = dp.max();
		DtoProperty.CheckRange dtoCheckRangeType = dp.checkRange();
		int stringLength = string.length();
		switch (dtoCheckRangeType) {
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

	default void checkDtoProperty(T t) throws Exception {
		// Unknown reason cannot use
		// Class<T> clazz = (Class<T>) ((ParameterizedType)
		// getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) this.getGenericClass();
		Constructor<?> constructor = clazz.getDeclaredConstructors()[1];
		@SuppressWarnings("unchecked")
		T request = (T) constructor.newInstance(t);
		Field[] fields = clazz.getDeclaredFields();
		Map<Field, Method> getterMapper = getGetterMapper(clazz);
		Map<Field, DtoProperty> dtoPropertyMapper = getDtoPropertyMapper(clazz);
		for (Field field : fields) {
			Method getter = getterMapper.get(field);
			DtoProperty dp = dtoPropertyMapper.get(field);
			if (dp != null && getter != null) {
				Object fieldObject = getter.invoke(request, null);
				// if property is required, but not found
				if (dp.required() && fieldObject == null) {
					throw new Exception("Missing " + field.getName() + ", the property is required.");
				} else {
					// if property existed and wasn't nullable, but value is
					// null
					if (fieldObject != null && !dp.nullable() && this.isNull(fieldObject)) {
						throw new Exception(field.getName() + " is null, the property cannot be null.");
					}
				}
				if (fieldObject != null) {
					if (!this.isNull(fieldObject))
						this.checkRange(dp, getOptional(fieldObject));
				}
			}
		}
	}

	Class<?> getGenericClass();

}
