package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

public class UnitTest {
    public static int number = 0;

    @BeforeEach
    public void beforeEach(){
        number = 1;
        System.out.println("beforeEach");
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("beforeAll");
    }

    @Test
    public void testing() throws InterruptedException {
        System.out.println("testing");
        Thread.sleep(100);
        number++;
    }

    @Test
    public void testing2(){
        System.out.println("testing2");
        Assertions.assertThat(number).isEqualTo(1);
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("afterAll");
    }

    @AfterEach
    public void afterEach(){
        System.out.println("afterEach");
    }
}
