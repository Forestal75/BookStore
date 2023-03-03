package com.Gabor.bookstore;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class Controller implements AutoCloseable {

    private HibernateContext model = new HibernateContext();

    public void initBooksAndAuthorsAndStores() {
        Session session = model.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Book book1 = new Book();
            book1.setTitle("The Lord of the Rings");
            book1.setAuthor("J.R.R. Tolkien");
            book1.setIsbn("ISBN: 0-618-51765-0");
            book1.setOnLine(true);
            session.persist(book1);

            Book book2 = new Book();
            book2.setTitle("Game of Thrones");
            book2.setAuthor("George R.R. Martin");
            book2.setIsbn("ISBN: 936-368-676-8");
            book2.setOnLine(true);
            session.persist(book2);

            Book book3 = new Book();
            book3.setTitle("The First Man in Rome");
            book3.setAuthor("Colleen McCullough");
            book3.setIsbn("ISBN: 963-307-196-8");
            book3.setOnLine(false);
            session.persist(book3);

            Book book4 = new Book();
            book4.setTitle("Harry Potter and the Philosopher's Stone");
            book4.setAuthor("J.K. Rowling");
            book4.setIsbn("ISBN: 937-364-466-9");
            book4.setOnLine(true);
            session.persist(book4);

            Book book5 = new Book();
            book5.setTitle("Fortunes of France");
            book5.setAuthor("Robert Merle");
            book5.setIsbn("ISBN: 978-388-976-7");
            book5.setOnLine(false);
            session.persist(book5);

            Author author1 = new Author();
            author1.setNameAuthor("J.R.R. Tolkien");
            author1.setDate("1892");
            session.persist(author1);

            Author author2 = new Author();
            author2.setNameAuthor("George R.R.Martin");
            author2.setDate("1948");
            session.persist(author2);

            Author author3 = new Author();
            author3.setNameAuthor("Colleen McCullough");
            author3.setDate("1937");
            session.persist(author3);

            Author author4 = new Author();
            author4.setNameAuthor("J.K. Rowling");
            author4.setDate("1965");
            session.persist(author4);

            Author author5 = new Author();
            author5.setNameAuthor("Robert Merle");
            author5.setDate("1908");
            session.persist(author5);

            Store store1 = new Store();
            store1.setNetwork("Alexandra");
            session.persist(store1);

            Store store2 = new Store();
            store2.setNetwork("Libri");
            session.persist(store2);

            Store store3 = new Store();
            store3.setNetwork("Lira&Lant");
            session.persist(store3);

            transaction.commit();

        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
    }

    public void addBook(String title, String author, String isbn) {

        Book b = new Book();
        b.setTitle(title);
        b.setAuthor(author);
        b.setIsbn(isbn);
        b.setOnLine(true);

        Session session = model.getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(b);

        session.flush();

        session.getTransaction().commit();

    }

    public void addAuthor(String nameAuthor, String date) {

        Author a = new Author();
        a.setNameAuthor(nameAuthor);
        a.setDate(date);

        Session session = model.getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(a);

        session.flush();

        session.getTransaction().commit();
    }

    public void deleteAuthor(int id) {

        Session session = model.getSession();
        Transaction transaction = null;
        try {

            transaction = session.beginTransaction();
            Author a = session.find(Author.class, id);

            session.remove(a);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void close() throws Exception {
    }
}