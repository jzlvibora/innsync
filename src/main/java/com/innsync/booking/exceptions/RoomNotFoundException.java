package com.innsync.booking.exceptions;

public class RoomNotFoundException extends RuntimeException{
    public RoomNotFoundException(String message) {
        super("Room not found");
    }
}
