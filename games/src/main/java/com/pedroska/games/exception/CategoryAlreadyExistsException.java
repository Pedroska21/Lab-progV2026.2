package com.pedroska.games.exception;

public class CategoryAlreadyExistsException extends RuntimeException{
        public CategoryAlreadyExistsException(String category) {
            super("Category already on the system: " + category);
        }
}

