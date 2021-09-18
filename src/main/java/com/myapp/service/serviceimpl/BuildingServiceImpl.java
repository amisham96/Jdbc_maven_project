package com.myapp.service.serviceimpl;

import java.util.List;

import com.myapp.dao.daoimpl.BuildingDaoImpl;
import com.myapp.entity.Building;
import com.myapp.exception.daoexception.DaoException;
import com.myapp.exception.serviceexception.BuildingRoomServiceException;
import com.myapp.service.BuildingService;

public class BuildingServiceImpl implements BuildingService {
	static BuildingDaoImpl buildingDao = new BuildingDaoImpl();

	@Override
	public int addBuilding(Building building) throws BuildingRoomServiceException {
		// TODO Auto-generated method stub
		try {
			return buildingDao.addBuilding(building);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new BuildingRoomServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<Building> getAllBuildingWithRooms() throws BuildingRoomServiceException {
		// TODO Auto-generated method stub
		try {
			return buildingDao.getAllBuildingWithRooms();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new BuildingRoomServiceException(e.getMessage(), e);
		}
	}

}
