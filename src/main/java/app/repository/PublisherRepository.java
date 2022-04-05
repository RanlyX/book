package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
