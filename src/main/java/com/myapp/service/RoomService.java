package com.myapp.service;

import java.util.List;

import com.myapp.entity.Room;
import com.myapp.exception.serviceexception.BuildingRoomServiceException;

public interface RoomService {
	int addRoom(Room room) throws BuildingRoomServiceException;

	List<Room> getRoomByBuildingId(int buildingId) throws BuildingRoomServiceException;

	List<Room> getRoomByBuildingWithMaxCapacity(int buildingId) throws BuildingRoomServiceException;

}
