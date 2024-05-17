package com.denraxcoding.springDataJpaAlibou;

import com.denraxcoding.springDataJpaAlibou.models.Author;
import com.denraxcoding.springDataJpaAlibou.models.Video;
import com.denraxcoding.springDataJpaAlibou.repositories.AuthorRepository;
import com.denraxcoding.springDataJpaAlibou.repositories.VideoRepository;
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
	){
		return args -> {
//			var author = Author.builder()
//					.firstName( "Dennis")
//					.lastName("Ngari")
//					.age(34)
//					.email("dennis123@gmail.com")
//					.build();
//			repository.save(author);

			var video = Video.builder()
					.name("abc")
					.length(5)
					.build();
			videoRepository.save(video);

		};
	}

}
