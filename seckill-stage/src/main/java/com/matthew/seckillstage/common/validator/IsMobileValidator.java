package com.matthew.seckillstage.common.validator;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsMobileValidator implements ConstraintValidator<IsMobile, String> {

    private boolean required = false;

    @Override
    public void initialize(IsMobile constraintAnnotation) {
        required = constraintAnnotation.required();
    }

    private static final Pattern MOBILE_PATTERN = Pattern.compile("1\\d{10}");

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Matcher matcher = MOBILE_PATTERN.matcher(s);
        if (required) {
            return matcher.matches();
        } else {
            if (StringUtils.isEmpty(s)) {
                return true;
            } else {
                return matcher.matches();
            }
        }
    }
}
