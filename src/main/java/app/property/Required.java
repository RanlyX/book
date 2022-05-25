package app.property;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({ ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
    ElementType.TYPE_PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Required {
    boolean value() default true;
}
