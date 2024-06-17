package practice_lab1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookTest {

    @BeforeEach
    public void setUp() {
        Book.books.clear();
        for (int i = 1; i <= 1000; i++) {
            Book.books.add(new Book(String.valueOf(i), "Title" + i, "Author" + i, 2000 + i));
        }
    }

    @Test
    public void testFindBookByIdExists() {
            String testID = "1";
            String testTitle = "TitleOne";

        for (int i=1; i<=1000; i++){
            testID = Integer.toString(i);
            testTitle = "Title"+ Integer.toString(i);

            Book foundBook = Book.search_bs(testID);
            assertNotNull(foundBook, "Book should be found");
            assertEquals(testID, foundBook.getId(), "Book ID should match");
            assertEquals(testTitle, foundBook.getTitle(), "Book title should match");
        }
       
    }

    @Test
    public void testFindBookByIdNotExists() {
        String testID = "1";

        for (int i=1001; i<=1500; i++){
            testID = Integer.toString(i);
            Book foundBook = Book.search_bs(testID);
            assertNull(foundBook, "Book should not be found");
        }
        
    }

    @Test
    public void testFindBookByIdFirstElement() {
        Book foundBook = Book.search_bs("1");
        assertNotNull(foundBook, "Book should be found");
        assertEquals("1", foundBook.getId(), "Book ID should match");
        assertEquals("Title1", foundBook.getTitle(), "Book title should match");
    }

    @Test
    public void testFindBookByIdLastElement() {
        Book foundBook = Book.search_bs("1000");
        assertNotNull(foundBook, "Book should be found");
        assertEquals("1000", foundBook.getId(), "Book ID should match");
        assertEquals("Title1000", foundBook.getTitle(), "Book title should match");
    }
}