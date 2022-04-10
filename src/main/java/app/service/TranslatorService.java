package app.service;

import org.springframework.stereotype.Service;

import app.model.Translator;
import app.model.render.TranslatorRender;
import app.repository.TranslatorRepository;

@Service
public class TranslatorService {

	private final TranslatorRepository translatorRepository;
	private final TranslatorRender translatorRender;

	public TranslatorService(TranslatorRepository translatorRepository, TranslatorRender translatorRender) {
		this.translatorRepository = translatorRepository;
		this.translatorRender = translatorRender;
	}

	public app.model.view.Translator addTranslator(Translator translator) {
		Translator dbTranslator = this.translatorRepository.findByName(translator.getName());
		if (dbTranslator != null)
			return this.translatorRender.render(dbTranslator);
		return this.translatorRender.render(this.translatorRepository.save(translator));
	}

}
