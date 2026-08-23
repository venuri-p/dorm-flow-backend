package com.dormflow.dorm_flow_backend.dto;

public class RoomDto {
    private String roomNumber;
    private String blockName;
    private Integer capacity;

    public RoomDto() {}

    public RoomDto(String roomNumber, String blockName, Integer capacity) {
        this.roomNumber = roomNumber;
        this.blockName = blockName;
        this.capacity = capacity;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
}
