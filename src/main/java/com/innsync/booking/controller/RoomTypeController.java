package com.innsync.booking.controller;

import com.innsync.booking.model.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("innsync/roomtypes")
@CrossOrigin(value = "http://localhost:4200")
public class RoomTypeController {
    @GetMapping
    public List<RoomType> getAllRoomTypes(){
        return Arrays.asList(RoomType.values());
    }

}
