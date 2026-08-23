package com.dormflow.dorm_flow_backend.service;

import com.dormflow.dorm_flow_backend.dto.RoomDto;
import com.dormflow.dorm_flow_backend.entity.Room;

import java.util.List;

public interface RoomService {
    Room createRoom(RoomDto roomDto);

    List<Room> getAllRooms();

    Room getRoomById(String id);

    Room updateRoom(RoomDto roomDto);
}
