package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}