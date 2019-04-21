package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPublisher;
    private String name;
    private String address;
    @OneToOne(mappedBy = "publisher")
    private
    Book book;

    public Publisher(){}
    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Publisher(String name, String address, Book book) {
        this.name = name;
        this.address = address;
        this.book = book;
    }

    public Long getIdPublisher() {
        return idPublisher;
    }

    public void setIdPublisher(Long idPublisher) {
        this.idPublisher = idPublisher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publisher)) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(idPublisher, publisher.idPublisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPublisher);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "idPublisher=" + idPublisher +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", book=" + book +
                '}';
    }
}
