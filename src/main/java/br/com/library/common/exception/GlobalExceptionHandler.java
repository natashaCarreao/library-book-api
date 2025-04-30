package br.com.library.common.exception;

import br.com.library.common.exception.dto.ErrorResponse;
import br.com.library.common.exception.dto.ErrorsMessagesConstants;
import feign.FeignException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.InvalidParameterException;

@ControllerAdvice
public class GlobalExceptionHandler {

    private  static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleGenericThrowable (final Exception ex, final HttpServletRequest request) {

        log.error(ex.getMessage(), ex);

        return ResponseEntity.internalServerError().body(new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                ex.getMessage(), System.currentTimeMillis(), request.getRequestURI()));
    }

    @ExceptionHandler({FeignException.class, FeignException.Unauthorized.class, MissingRequestHeaderException.class})
    @ResponseBody
    public ResponseEntity<ErrorResponse> feignUnauthorizedException(Exception ex, HttpServletRequest request) {

        log.error(ErrorsMessagesConstants.MSG_INTEGRATION_EXTERNAL_API, ex);

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorResponse(HttpStatus.UNAUTHORIZED.value(),
                ex.getMessage(), System.currentTimeMillis(), request.getRequestURI()));
    }

    @ExceptionHandler(InvalidParameterException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> invalidParameterException(InvalidParameterException ex, HttpServletRequest request) {

        log.error(ErrorsMessagesConstants.MSG_INVALID_PARAMETERS, ex);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(), System.currentTimeMillis(), request.getRequestURI()));

    }

    @ExceptionHandler({EntityNotFoundException.class})
    @ResponseBody
    public ResponseEntity<ErrorResponse> entityNotFoundException (EntityNotFoundException ex, HttpServletRequest request){
        log.error(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND.value(),
                ex.getMessage(), System.currentTimeMillis(), request.getRequestURI()));
    }
}
