package com.myapp.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myapp.dao.BuildingDao;
import com.myapp.entity.Building;
import com.myapp.exception.daoexception.DaoException;
import com.myapp.utility.utilityimpl.DBConnectionImpl;

public class BuildingDaoImpl implements BuildingDao {
	static DBConnectionImpl dbconnection = new DBConnectionImpl();

	@Override
	public int addBuilding(Building building) throws DaoException {
		// TODO Auto-generated method stub
		int result = 0;
		String query = "INSERT INTO building VALUES(?, ?)";
		try {
			Connection connection = dbconnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, building.getBuildingId());
			pstmt.setString(2, building.getBuildingName());
			result = pstmt.executeUpdate();
		} catch (DaoException | SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException(e.getMessage(), e);
		}

		return result;
	}

	@Override
	public List<Building> getAllBuildingWithRooms() throws DaoException {
		// TODO Auto-generated method stub
		List<Building> building = new ArrayList<>();
		String query = "SELECT * FROM room r INNER JOIN building b on r.buildingId=b.buildingId";
		try {
			Connection connection = dbconnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Building data = new Building();
				data.setBuildingId(result.getInt(1));
				data.setBuildingName(result.getString(2));
				building.add(data);
			}
		} catch (DaoException | SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException(e.getMessage(), e);
		}
		return building;
	}

}
