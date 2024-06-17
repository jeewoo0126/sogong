package practice_lab1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookPerformanceTest {

    @BeforeEach
    public void setUp() {
        Book.books.clear();
        for (int i = 1; i <= 10000; i++) {
            Book.books.add(new Book(String.valueOf(i), "Title" + i, "Author" + i, 2000 + i));
        }
    }

    @Test
    public void testSearchBookPerformance() {
        int iterations = 10000;
        long totalDuration = 0;

        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            Book.searchBook("5000");
            long endTime = System.nanoTime();
            totalDuration += (endTime - startTime);
        }

        long averageDuration = totalDuration / iterations;
        System.out.println("Average linear search duration: " + averageDuration + " ns");
    }

    @Test
    public void testSearchBsPerformance() {
        int iterations = 10000;
        long totalDuration = 0;

        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            Book.search_bs("5000");
            long endTime = System.nanoTime();
            totalDuration += (endTime - startTime);
        }

        long averageDuration = totalDuration / iterations;
        System.out.println("Average binary search duration: " + averageDuration + " ns");
    }
}