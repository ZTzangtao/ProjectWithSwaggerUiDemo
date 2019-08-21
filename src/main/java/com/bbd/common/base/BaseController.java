package com.bbd.common.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author zangtao
 */
@ControllerAdvice(annotations = RestController.class)
public class BaseController {
    private final Logger logger = LoggerFactory.getLogger(BaseController.class);

    @ExceptionHandler
    @ResponseBody
    public Response handleException(Exception e, HttpServletRequest request) {
        logger.error(request.getRequestURI());
        //参数校验异常
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException) e;
            List<ObjectError> errors = exception.getBindingResult().getAllErrors();
            String errorMsg = ErrorCode.REQUEST_PARAM_MISSING.getErrorName();
            if (!CollectionUtils.isEmpty(errors)) {
                errorMsg = errors.get(0).getDefaultMessage();
            }
            return Response.error(ErrorCode.REQUEST_PARAM_MISSING.getCode(), errorMsg);
        }

        //参数缺失异常
        if (e instanceof MissingServletRequestParameterException) {
            return Response.error(ErrorCode.REQUEST_PARAM_MISSING.getCode(), ErrorCode.REQUEST_PARAM_MISSING.getErrorName());
        }
        //参数缺失异常
        if (e instanceof HttpMessageNotReadableException) {
            return Response.error(ErrorCode.REQUEST_PARAM_MISSING.getCode(), ErrorCode.REQUEST_PARAM_MISSING.getErrorName());
        }

        e.printStackTrace();
        logger.info(e.getMessage());
        //未知异常
        return Response.error(ErrorCode.REQUEST_ERROR.getCode(), ErrorCode.REQUEST_ERROR.getErrorName());
    }
}
