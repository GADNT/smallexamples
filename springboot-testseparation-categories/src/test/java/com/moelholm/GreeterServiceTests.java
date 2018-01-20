package com.moelholm;

import com.moelholm.base.UnitTest;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@Category(UnitTest.class)
@RunWith(MockitoJUnitRunner.class)
public class GreeterServiceTests {

    private static GreeterService greeterService;

    @BeforeClass
    public static void setUp() {
        greeterService = new GreeterService();
    }


    @Test
    public void sayHello_whenInvokedWithDuke_thenSaysHelloWorldDuke() {

        // When
        String greeting = greeterService.sayHello("Duke");

        // Then
        assertThat(greeting).isEqualTo("Hello World, Duke");

    }

}