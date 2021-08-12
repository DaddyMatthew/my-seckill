package com.matthew.seckillstage.common.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Documented
@Constraint(validatedBy = {IsMobileValidator.class})
@Retention(RetentionPolicy.RUNTIME)
public @interface IsMobile {
    boolean required() default false;

    String message() default "手机号码格式错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
