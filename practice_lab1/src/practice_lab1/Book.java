package practice_lab1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Book {
    private String id;
    private String title;
    private String author;
    private int year;

    public static List<Book> books = new ArrayList<>();

    public Book(String id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    
    
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
    
    public static void addBook(String id, String title, String author, int year) {
        Optional<Book> existBook = books.stream()
            .filter(i -> i.getId().equals(id))
            .findFirst();

        if (existBook.isPresent()) {
            System.out.println("해당 ID(" + id + ")는 이미 존재합니다.");
        } else {
            books.add(new Book(id, title, author, year));
            System.out.println("Book{id='" + id + "', title='" + title + "', author='" + author + "', year=" + year + "} 도서가 추가되었습니다.");
        }
    }

    public static void searchBook(String id) {
        System.out.println("검색 결과:");
        books.stream()
            .filter(i -> i.getId().equals(id))
            .forEach(System.out::println);
    }

    public static void searchAllBooks() {
        System.out.println("검색 결과:");
        books.forEach(System.out::println);
    }


	 public static void sortBooksById() {
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getId().compareTo(b2.getId());
            }
        });
    }


    public static Book search_bs(String id) {
        sortBooksById();
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            Book midBook = books.get(mid);
            int comparison = midBook.getId().compareTo(id);

            if (comparison == 0) {
				System.out.println("이진 탐색 결과:");
				System.out.println(midBook);
                return midBook;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
		System.out.println("이진 탐색 결과가 없습니다.");
        return null;
    }

    public static void deleteBook(String id) {
        Optional<Book> deleteBook = books.stream()
            .filter(i -> i.getId().equals(id))
            .findFirst();

        if (deleteBook.isPresent()) {
            books.remove(deleteBook.get());
            System.out.println(deleteBook.get() + " 도서를 삭제하였습니다.");
        } else {
            System.out.println("해당 ID(" + id + ")의 도서를 찾을 수 없습니다.");
        }
    }

    public static void updateBook(String id, String title, String author, int year) {
        Optional<Book> book = books.stream()
            .filter(i -> i.getId().equals(id))
            .findFirst();

        if (book.isPresent()) {
            books.remove(book.get());
            books.add(new Book(id, title, author, year));
            System.out.println("도서 정보가 업데이트 되었습니다.");
        } else {
            System.out.println("해당 ID(" + id + ")의 도서를 찾을 수 없습니다.");
        }
    }
    
    public static void main(String[] args) {
        Book.addBook("1", "자바 기초", "Jane", 2021);
        Book.addBook("1", "자바 기초", "Jane", 2021);
        Book.addBook("2", "소프트웨어 공학", "Tom", 2014);
        Book.addBook("3", "분산 컴퓨팅", "Yoon", 2024);

        Book.searchAllBooks();

        Book.searchBook("1");
        Book.searchBook("2");
        Book.searchBook("6");

        // Book.deleteBook("1");
        // Book.deleteBook("1");
    }
}
