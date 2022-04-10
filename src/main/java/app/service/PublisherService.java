package app.service;

import org.springframework.stereotype.Service;

import app.model.Publisher;
import app.model.render.PublisherRender;
import app.repository.PublisherRepository;

@Service
public class PublisherService {

	private final PublisherRepository publisherRepository;
	private final PublisherRender publisherRender;

	public PublisherService(PublisherRepository publisherRepository, PublisherRender publisherRender) {
		this.publisherRepository = publisherRepository;
		this.publisherRender = publisherRender;
	}

	public app.model.view.Publisher addPublisher(Publisher publisher) {
		Publisher dbPublisher = this.publisherRepository.findByName(publisher.getName());
		if (dbPublisher != null)
			return this.publisherRender.render(dbPublisher);
		return this.publisherRender.render(this.publisherRepository.save(publisher));
	}

}
