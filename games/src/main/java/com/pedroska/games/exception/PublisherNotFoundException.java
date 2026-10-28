package com.pedroska.games.exception;

import java.util.UUID;

public class PublisherNotFoundException extends RuntimeException {
    public PublisherNotFoundException(UUID id) {
        super("Publisher not found: " + id);
    }
}