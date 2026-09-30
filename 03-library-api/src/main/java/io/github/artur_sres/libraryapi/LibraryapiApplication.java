package io.github.artur_sres.libraryapi;

import io.github.artur_sres.libraryapi.model.Autor;
import io.github.artur_sres.libraryapi.repository.AutorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class LibraryapiApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(LibraryapiApplication.class, args);

		AutorRepository autorRepository = context.getBean(AutorRepository.class);

		salvarAutor(autorRepository);
	}

	public static void salvarAutor(AutorRepository autorRepository){
		Autor autor = new Autor();

		autor.setNome("José");
		autor.setNacionalidade("Brasileiro");
		autor.setDataNascimento(LocalDate.of(1950, 1, 31));

		System.out.println("Autor salvo: " + autorRepository.save(autor));
	}

}
