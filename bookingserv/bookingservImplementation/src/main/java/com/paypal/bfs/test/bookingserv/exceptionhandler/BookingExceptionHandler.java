package com.paypal.bfs.test.bookingserv.exceptionhandler;

import com.paypal.bfs.test.bookingserv.api.model.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class BookingExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookingExceptionHandler.class);


    @ExceptionHandler(ConstraintViolationException.class)
    public final ResponseEntity<ErrorResponse> handleConstraintViolation(
            ConstraintViolationException ex,
            WebRequest request)
    {
        List<String> details = ex.getConstraintViolations()
                .parallelStream()
                .map(e -> e.getMessage())
                .collect(Collectors.toList());

        ErrorResponse error = new ErrorResponse();
        error.setType("BAD_REQUEST");
        error.setErrors(details);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = {HttpClientErrorException.Unauthorized.class})
    public ResponseEntity<ErrorResponse> handleUnauthorizedException(HttpClientErrorException.Unauthorized ex) {
        LOGGER.error("Unauthorized Exception: ",ex.getMessage());
        ErrorResponse error = new ErrorResponse();
        error.setType("BAD_REQUEST");
        error.setErrors(Arrays.asList(ex.getMessage()));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = {BookingSerException.class})
    public ResponseEntity<ErrorResponse> handleBookingSerException(BookingSerException ex) {
        LOGGER.error("BookingSerException: ",ex.getMessage());
        ErrorResponse error = new ErrorResponse();
        error.setType("INTERNAL_SERVER_ERROR");
        error.setErrors(Arrays.asList(ex.getMessage()));
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        LOGGER.error("Exception: ",ex.getMessage());
        ErrorResponse error = new ErrorResponse();
        error.setType("INTERNAL_SERVER_ERROR");
        error.setErrors(Arrays.asList(ex.getMessage()));
        return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
