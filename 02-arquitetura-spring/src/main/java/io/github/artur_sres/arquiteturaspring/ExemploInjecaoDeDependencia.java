//package io.github.artur_sres.arquiteturaspring;
//
//import io.github.artur_sres.arquiteturaspring.montadora.TodoValidator;
//import io.github.artur_sres.arquiteturaspring.todos.MailSender;
//import io.github.artur_sres.arquiteturaspring.todos.TodoEntity;
//import io.github.artur_sres.arquiteturaspring.todos.TodoRepository;
//import io.github.artur_sres.arquiteturaspring.todos.TodoService;
//import jakarta.persistence.EntityManager;
//import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//public class ExemploInjecaoDeDependencia {
//    public static void main(String[] args) throws SQLException {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl("url");
//        dataSource.setUrl("user");
//        dataSource.setPassword("password");
//
//        Connection connection = dataSource.getConnection();
//
//        EntityManager entityManager = null;
//
//        TodoRepository todoRepository = new SimpleJpaRepository<TodoEntity, Integer>();
//        TodoValidator todoValidator = new TodoValidator(todoRepository);
//        MailSender mailSender = new MailSender();
//
//        TodoService todoService = new TodoService(todoRepository, todoValidator, mailSender);
//    }
//}
