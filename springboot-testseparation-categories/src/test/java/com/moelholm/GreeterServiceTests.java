package com.moelholm;

import com.moelholm.base.UnitTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyObject;

@Category(UnitTest.class)
@RunWith(PowerMockRunner.class)
@PrepareForTest(GreeterService.class)
@PowerMockIgnore({ "org.junit.experimental.categories.Category", "com.moelholm.base.UnitTest" })
public class GreeterServiceTests {

    private GreeterService greeterService;

    @Before
    public void setUp() {
        greeterService = PowerMockito.spy(new GreeterService());

    }

    @Test
    public void sayHello_whenInvokedWithDuke_thenSaysHelloWorldDuke() throws Exception {

        PowerMockito.doReturn(true).when(greeterService, "prettyFormat", anyObject());

        // When
        String greeting = greeterService.sayHello("Duke");

        // Then
        assertThat(greeting).isEqualTo("Hello World, Duke".toUpperCase());

    }

}