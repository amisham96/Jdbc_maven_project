package com.myapp.service;

import java.util.List;

import com.myapp.entity.Building;
import com.myapp.exception.serviceexception.BuildingRoomServiceException;;

public interface BuildingService {
	int addBuilding(Building building) throws BuildingRoomServiceException;

	List<Building> getAllBuildingWithRooms() throws BuildingRoomServiceException;

}
