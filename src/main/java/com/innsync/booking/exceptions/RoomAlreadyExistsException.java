package com.innsync.booking.exceptions;

public class RoomAlreadyExistsException extends RuntimeException {
    public RoomAlreadyExistsException(String message) {
        super("Room already exists");
    }
}
