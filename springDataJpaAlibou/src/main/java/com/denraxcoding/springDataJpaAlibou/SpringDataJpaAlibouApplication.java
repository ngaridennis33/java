package com.denraxcoding.springDataJpaAlibou;

import com.denraxcoding.springDataJpaAlibou.models.Author;
import com.denraxcoding.springDataJpaAlibou.models.Video;
import com.denraxcoding.springDataJpaAlibou.repositories.AuthorRepository;
import com.denraxcoding.springDataJpaAlibou.repositories.VideoRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaAlibouApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaAlibouApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthorRepository repository,
            VideoRepository videoRepository
    ) {
        return args -> {
//			Faker faker = new Faker();
//			for(int i = 0; i < 50; i++){
//				var author = Author.builder()
//						.firstName( faker.name().firstName())
//						.lastName(faker.name().lastName())
//						.age(faker.number().numberBetween(19, 50))
//						.email("contact"+ i + "dennis123@gmail.com")
//						.build();
//				repository.save(author);
//			}

//			Update Author a set a.age = 22 where a.id = 1
//            repository.updateAuthor(22, 1);

//			Find by named query
            repository.findByNamedQuery(60)
                    .forEach(System.out::println);

//            Multiple Updates
//            repository.updateAllAuthorSAges(99);


//			var video = Video.builder()
//					.name("abc")
//					.length(5)
//					.build();
//			videoRepository.save(video);

        };
    }

}
