package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.Translator;

@Repository
public interface TranslatorRepository extends JpaRepository<Translator, Long> {
	Translator findByName(String name);
}
