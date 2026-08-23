package com.dormflow.dorm_flow_backend.service.impl;

import com.dormflow.dorm_flow_backend.dto.RoomDto;
import com.dormflow.dorm_flow_backend.entity.Room;
import com.dormflow.dorm_flow_backend.repository.RoomRepository;
import com.dormflow.dorm_flow_backend.service.RoomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    @Transactional
    public Room createRoom(RoomDto roomDto) {
        if (roomRepository.existsById(roomDto.getRoomNumber())) {
            throw new IllegalArgumentException("Room with number " + roomDto.getRoomNumber() + " already exists.");
        }

        Room room = new Room();
        room.setRoomNumber(roomDto.getRoomNumber());
        room.setBlockName(roomDto.getBlockName());
        room.setCapacity(roomDto.getCapacity());
        room.setCurrentOccupancy(0);

        return roomRepository.save(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(String id) {
        return roomRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Room not found"));
    }

    @Override
    @Transactional
    public Room updateRoom(RoomDto roomDto) {
        Room room = roomRepository.findById(roomDto.getRoomNumber())
        .orElseThrow(() -> new IllegalArgumentException("Room not found"));

        if (roomDto.getRoomNumber() != null) {
            room.setRoomNumber(roomDto.getRoomNumber());
        }
        if (roomDto.getBlockName() != null) {
            room.setBlockName(roomDto.getBlockName());
        }
        if (roomDto.getCapacity() != null) {
            room.setCapacity(roomDto.getCapacity());
        }
        return roomRepository.save(room);
    }

    
}
