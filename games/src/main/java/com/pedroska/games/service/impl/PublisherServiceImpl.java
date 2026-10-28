package com.pedroska.games.service.impl;

import com.pedroska.games.model.Publisher;
import com.pedroska.games.exception.PublisherAlreadyExistsException;
import com.pedroska.games.exception.PublisherNotFoundException;
import com.pedroska.games.repository.PublisherRepository;
import com.pedroska.games.service.PublisherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PublisherServiceImpl implements PublisherService {

    private final PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public UUID create(Publisher publisher) {
        if (publisherRepository.existsByName(publisher.getName())) {
            throw new PublisherAlreadyExistsException(publisher.getName());
        }
        return publisherRepository.save(publisher).getId();
    }
    @Override
    public Publisher update(Publisher publisher, UUID uuid) {
        Publisher existing = findById(uuid);
        if (!existing.getName().equals(publisher.getName()) && publisherRepository.existsByName(publisher.getName())) {
            throw new PublisherAlreadyExistsException(publisher.getName());
        }
        existing.setName(publisher.getName());
        existing.setGames(publisher.getGames());
        return publisherRepository.save(existing);
    }
    @Override
    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }
    @Override
    public Publisher findById(UUID uuid) {
        return publisherRepository.findById(uuid)
                .orElseThrow(() -> new PublisherNotFoundException(uuid));
    }
    @Override
    public void delete(UUID uuid) {
        if (!publisherRepository.existsById(uuid)) {
            throw new PublisherNotFoundException(uuid);
        }
        publisherRepository.deleteById(uuid);
    }
}

