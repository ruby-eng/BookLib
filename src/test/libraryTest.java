import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;
    private User teacher;
    private User seniorStudent;
    private User juniorStudent;

    @BeforeEach
    void setUp() {
        library = new Library(true); // Priority-based library
        library.addBook("Java Programming", 1);

        teacher = new Teacher("Mr. Smith");
        seniorStudent = new Student("John", 3);
        juniorStudent = new Student("Alice", 1);
    }

    @Test
    void testTeacherGetsBookFirst() {
        library.requestBook(seniorStudent, "Java Programming");
        library.requestBook(teacher, "Java Programming");
        library.processRequests();

        // Teacher should get the book since they have higher priority
        assertFalse(library.books.get("Java Programming").isAvailable());
    }

    @Test
    void testSeniorGetsBeforeJunior() {
        library.requestBook(juniorStudent, "Java Programming");
        library.requestBook(seniorStudent, "Java Programming");
        library.processRequests();

        // Senior student should get the book before junior
        assertFalse(library.books.get("Java Programming").isAvailable());
    }

    @Test
    void testFIFOImplementation() {
        Library fifoLibrary = new Library(false); // FIFO-based library
        fifoLibrary.addBook("Python Basics", 1);

        fifoLibrary.requestBook(juniorStudent, "Python Basics");
        fifoLibrary.requestBook(seniorStudent, "Python Basics");
        fifoLibrary.processRequests();

        // First requester (junior) should get the book
        assertFalse(fifoLibrary.books.get("Python Basics").isAvailable());
    }

    @Test
    void testBookNotAvailableException() {
        library.requestBook(teacher, "Java Programming");
        library.requestBook(seniorStudent, "Java Programming");
        library.processRequests();

        Exception exception = assertThrows(Exception.class, () -> {
            library.books.get("Java Programming").borrowBook();
        });

        assertEquals("Book taken", exception.getMessage());
    }
}
