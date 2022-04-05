package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.Translator;

public interface TranslatorRepository extends JpaRepository<Translator, Long> {
}
