package tests;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JUnit5Examples {

    @BeforeAll // выполняется 1 раз перед всеми тестами
    static void beforeAll() {
        System.out.println("===== Starting before All tests");
    }

    @BeforeAll // выполняется 1 раз перед всеми тестами
    static void beforeAll1() {
        System.out.println("===== Starting 1 before All tests");
    }

    @BeforeEach// выполняется 1 раз перед каждым тестом
    void beforeEach() {
        System.out.println("======== Starting 1 before Every test");
    }

    @Test
    void firstTest() {
        System.out.println("========== Started firstTest");
    }

    @Test
    void secondTest() {
        System.out.println("========== Started secondTest");
        assertEquals(2,3); // сравнение в junit5
    }

    @AfterEach // выполняется 1 раз после каждого теста
    void afterEach() {
        System.out.println("======== Starting 1 after Every test");
    }

    @AfterAll // выполняется 1 раз после всех тестов
    static void afterAll() {
        System.out.println("===== Starting after All tests");
    }

}