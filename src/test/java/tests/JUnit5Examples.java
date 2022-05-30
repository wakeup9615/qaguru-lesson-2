package tests;

import org.junit.jupiter.api.*;

public class JUnit5Examples {

    @BeforeAll // выполняется 1 раз перед всеми тестами
    static void beforeAll() {
        System.out.println("===== Starting before All tests");
    }

    @BeforeAll // выполняется 1 раз перед всеми тестами
    static void beforeAll1() {
        System.out.println("===== Starting 1 before All tests");
    }

    @BeforeEach// выполняется 1 раз перед каждыми тестами
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
