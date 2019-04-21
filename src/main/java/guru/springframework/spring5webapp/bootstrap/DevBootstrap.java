package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
    private void initData(){
        Author rob = new Author("Robert","Greene");
        Book laws = new Book("48 laws of power", "1234");
        Publisher viking = new Publisher("Viking Press","New York, United States");
        laws.setPublisher(viking);
        rob.getBooks().add(laws);
        laws.getAuthors().add(rob);
        authorRepository.save(rob);
        bookRepository.save(laws);
        publisherRepository.save(viking);

        Author itz = new Author("Itzhak","Pintosevich");
        Book act = new Book("Act!","11112222");
        Publisher psy = new Publisher("Psychology. System+","Kyiv, Ukraine");
        act.setPublisher(psy);
        itz.getBooks().add(act);
        act.getAuthors().add(itz);
        authorRepository.save(itz);
        bookRepository.save(act);
        publisherRepository.save(psy);

    }
}
