package com.innsync.booking.controller;

import com.innsync.booking.model.RoomType;
import com.innsync.booking.model.RoomTypeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("innsync/roomtypes")
@CrossOrigin(value = "http://localhost:4200")
public class RoomTypeController {
    @GetMapping
    public List<RoomTypeDetails> getAllRoomTypesDetails(){
        return Arrays.asList(new RoomTypeDetails(RoomType.STANDARD),
                            new RoomTypeDetails(RoomType.DELUXE),
                            new RoomTypeDetails(RoomType.FAMILY),
                            new RoomTypeDetails(RoomType.BUSINESS_SUITE),
                            new RoomTypeDetails(RoomType.HONEYMOON_SUITE),
                            new RoomTypeDetails(RoomType.ACCESSIBLE)
                );
    }

}
