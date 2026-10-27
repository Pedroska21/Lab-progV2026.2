package com.pedroska.games.exception;

public class GameAlreadyExistsException extends RuntimeException{
        public GameAlreadyExistsException(String game) {
            super("Game already on the system: " + game);
        }
}

