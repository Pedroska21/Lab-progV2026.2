package com.pedroska.games.service;

import com.pedroska.games.model.Publisher;
import java.util.UUID;
import java.util.List;

public interface PublisherService {
    UUID create(Publisher publisher);
    Publisher update(Publisher publisher, UUID uuid);
    List<Publisher> findAll();
    Publisher findById(UUID uuid);
    void delete(UUID uuid);
}