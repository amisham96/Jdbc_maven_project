package com.myapp.service.serviceimpl;

import java.util.List;

import com.myapp.dao.daoimpl.RoomDaoImpl;
import com.myapp.entity.Room;
import com.myapp.exception.daoexception.DaoException;
import com.myapp.exception.serviceexception.BuildingRoomServiceException;
import com.myapp.service.RoomService;

public class RoomServiceImpl implements RoomService {
	static RoomDaoImpl roomDao = new RoomDaoImpl();

	@Override
	public int addRoom(Room room) throws BuildingRoomServiceException {
		// TODO Auto-generated method stub
		try {
			return roomDao.addRoom(room);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new BuildingRoomServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<Room> getRoomByBuildingId(int buildingId) throws BuildingRoomServiceException {
		// TODO Auto-generated method stub
		try {
			return roomDao.getRoomByBuildingId(buildingId);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new BuildingRoomServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<Room> getRoomByBuildingWithMaxCapacity(int buildingId) throws BuildingRoomServiceException {
		// TODO Auto-generated method stub
		try {
			return roomDao.getRoomByBuildingWithMaxCapacity(buildingId);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new BuildingRoomServiceException(e.getMessage(), e);
		}
	}

}
