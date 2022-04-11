package app.input;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface InputProperty {

	boolean required() default false;

	boolean nullable() default false;

	double min() default 0;

	double max() default 99999999;

	Type type() default Type.ANY;

	public enum Type {
		ANY, BOOLEAN, BYTE, SHORT, INTEGER, LONG, FLOAT, DOUBLE, STRING, LIST, ENUM;
	}

}
