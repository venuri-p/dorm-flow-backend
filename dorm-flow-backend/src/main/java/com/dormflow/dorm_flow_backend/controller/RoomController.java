package com.dormflow.dorm_flow_backend.controller;

import com.dormflow.dorm_flow_backend.dto.RoomDto;
import com.dormflow.dorm_flow_backend.entity.Room;
import com.dormflow.dorm_flow_backend.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public ResponseEntity<Room> createRoom(@RequestBody RoomDto roomDto) {
        Room createdRoom = roomService.createRoom(roomDto);
        return new ResponseEntity<>(createdRoom, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable String id){
        Room room = roomService.getRoomById(id);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @PatchMapping("/update")
    public ResponseEntity<Room> updateRoom(@RequestBody RoomDto roomDto){
        Room updatedRoom = roomService.updateRoom(roomDto);
        return new ResponseEntity<>(updatedRoom, HttpStatus.OK);
    }

    
}
