package com.myapp.dao;

import java.util.List;

import com.myapp.entity.Building;
import com.myapp.exception.daoexception.DaoException;

public interface BuildingDao {
	int addBuilding(Building building) throws DaoException;

	List<Building> getAllBuildingWithRooms() throws DaoException;

}
