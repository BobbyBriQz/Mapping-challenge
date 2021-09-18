package com.mhp.coding.challenges.mapping;

import com.mhp.coding.challenges.mapping.exceptions.ArticleServiceException;
import com.mhp.coding.challenges.mapping.exceptions.ResourceNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;


public class ExceptionTest {

    ArticleServiceException articleServiceException;
    ResourceNotFoundException resourceNotFoundException;


    @Before
    public void setUp(){
        articleServiceException = new ArticleServiceException("Test Exception");
        resourceNotFoundException = new ResourceNotFoundException("Test Exception");
    }

    @Test
    @DisplayName("Test to confirm that the default status of a thrown custom exception is false")
    public void testDefaultExceptionStatus(){

        assertFalse(articleServiceException.isStatus());
        assertFalse(resourceNotFoundException.isStatus());
    }
}
