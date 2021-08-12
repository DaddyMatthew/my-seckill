package com.matthew.seckillstage.common.exception;

import com.matthew.seckillstage.common.CodeMessage;
import com.matthew.seckillstage.common.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
@ResponseBody
public class ApplicationExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e) {
        if (e instanceof ApplicationException) {
            ApplicationException aex = (ApplicationException) e;
            return Result.error(aex.getCodeMessage());
        } else if (e instanceof BindException) {
            BindException bex = (BindException) e;
            List<ObjectError> errors = bex.getAllErrors();
            String errorMsg = errors.get(0).getDefaultMessage();
            return Result.error(CodeMessage.BIND_ERROR.fillArgs(errorMsg));
        } else {
            return Result.error(CodeMessage.SERVER_ERROR);
        }
    }
}
