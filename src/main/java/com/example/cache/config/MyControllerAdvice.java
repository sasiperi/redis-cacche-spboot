package com.example.cache.config;


import java.sql.SQLException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.lettuce.core.RedisCommandExecutionException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;



/**
 * @author sasi.peri
 *
 * <p>This is class/AOP weaving around the rest endpoint exceptions
 *
 * <p>By classpath scanning for all that are {@link Component @Component}.
 *
 * <p>Serves as a excepton handler for any/all excpetions that can be thrown by endpoints and presenting user with more meaning ful errors.
 *  
 */
@ControllerAdvice
@Slf4j
public class MyControllerAdvice 
{
    
    /****
     * 
     * Following are the exceptions turning HTTP-500 server errors to HTTP-400 Bad Request
     * Invalid input
     */
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(value=HttpStatus.NOT_FOUND,reason="SP-ERR001: No data available mathcing the criteria")
    public void handleNoDataAvailable(HttpServletRequest request, Exception ex)
    {
          log.warn("SP-ERR001: No data available mathcing the criteria UR L= "+request.getRequestURL(), ex);
    
    }
    
    /****
     * 
     * Following are the exceptions turning HTTP-500 server errors to HTTP-400 Bad Request
     * Invalid input
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value=HttpStatus.BAD_REQUEST,reason="SP-ERR002: Invalid input")
    public void handleInvalidData(HttpServletRequest request, Exception ex)
    {
          log.warn("SP-ERR002: Invalid input UR L= "+request.getRequestURL(), ex);
    
    }
    
    
    /**
     *  any other invalid sql data
     */
    @ExceptionHandler({ConstraintViolationException.class,  NonUniqueResultException.class, IllegalStateException.class, SQLException.class, InterruptedException.class})
    @ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR,reason="SP-ERR003: Something went wrong while processing the request!")
    public void notValid(HttpServletRequest request, Exception ex)
    {
        log.error("SP-ERR003: SP-ERR003: Something went wrong while processing the request! URL="+request.getRequestURL(), ex);
    }
     
    
    /****
     * 
     * Following are the exceptions turning a HTTP-500 to security (underlying redis access issue)
     * Invalid input
     */
    @ExceptionHandler(RedisCommandExecutionException.class)
    @ResponseStatus(value=HttpStatus.FORBIDDEN,reason="SP-ERR004: Not allowed")
    public void handleRedisAccess(HttpServletRequest request, Exception ex)
    {
          log.warn("SP-ERR004: not allowed UR L= "+request.getRequestURL(), ex);
    
    }
    
    
    
    
}
