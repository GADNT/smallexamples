package com.moelholm;

import com.moelholm.base.UnitTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@Category(UnitTest.class)
public class GreeterResourceTests {

    @Mock
    private GreeterService greeterService;

    private GreeterResource greeterResource;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        greeterResource = new GreeterResource(greeterService);
    }

    @Test
    public void givenNameWithDLetter_whenInvokePerformGreet_thenReturnMessageUpperCased() {
        String name = "GabrielDeaconu";

        when(greeterService.sayHello(anyObject())).thenReturn("Gabi");

        ResponseEntity<String> stringResponseEntity = greeterResource.performGreet(name);

        assertNotNull(stringResponseEntity);
        assertEquals(stringResponseEntity.getBody().contains("Gabi"), true);

    }
}