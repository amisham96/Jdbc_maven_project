package com.myapp.dao;

import java.util.List;

import com.myapp.entity.Room;
import com.myapp.exception.daoexception.DaoException;

public interface RoomDao {
	int addRoom(Room room) throws DaoException;

	List<Room> getRoomByBuildingId(int buildingId) throws DaoException;

	List<Room> getRoomByBuildingWithMaxCapacity(int buildingId) throws DaoException;

}
