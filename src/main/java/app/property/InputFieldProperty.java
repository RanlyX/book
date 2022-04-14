package app.property;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
		ElementType.TYPE_PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface InputFieldProperty {

	boolean required() default false;

	boolean nullable() default false;

	double min() default 0;

	double max() default 999999999;

	Type type() default Type.ANY;
	
	CheckRange checkRange() default CheckRange.NONE;

	public enum Type {
		ANY, BOOLEAN, BYTE, SHORT, INTEGER, LONG, FLOAT, DOUBLE, STRING, LIST, ENUM, DATE;
	}
	
	public enum CheckRange {
		NONE, UPPER, LOWER, BOTH;
	}

}
