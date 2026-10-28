package com.pedroska.games.exception;

public class PublisherAlreadyExistsException extends RuntimeException{
        public PublisherAlreadyExistsException(String publisher) {
            super("Publisher already on the system: " + publisher);
        }
}

