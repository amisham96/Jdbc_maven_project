package com.myapp.dao.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.myapp.dao.RoomDao;
import com.myapp.entity.Room;
import com.myapp.exception.daoexception.DaoException;
import com.myapp.utility.utilityimpl.DBConnectionImpl;

public class RoomDaoImpl implements RoomDao {
	static DBConnectionImpl dbconnection = new DBConnectionImpl();

	@Override
	public int addRoom(Room room) throws DaoException {
		// TODO Auto-generated method stub
		int result = 0;
		String query = "INSERT INTO room VALUES(?, ?, ?, ?)";

		try {
			Connection connection = dbconnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, room.getRoomId());
			pstmt.setString(2, room.getRoomName());
			pstmt.setInt(3, room.getCapacity());
			pstmt.setInt(4, room.getBuildingId());
			result = pstmt.executeUpdate();
		} catch (DaoException | SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException(e.getMessage(), e);
		}
		return result;
	}

	@Override
	public List<Room> getRoomByBuildingId(int buildingId) throws DaoException {
		// TODO Auto-generated method stub
		List<Room> room = new ArrayList<>();
		String query = "SELECT * FROM room Where buildingId=?";
		try {
			Connection connection = dbconnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, buildingId);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Room data = new Room();
				data.setRoomId(result.getInt(1));
				data.setRoomName(result.getString(2));
				data.setCapacity(result.getInt(3));
				data.setBuildingId(result.getInt(4));
				room.add(data);
			}
		} catch (DaoException | SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException(e.getMessage(), e);
		}
		return room;
	}

	@Override
	public List<Room> getRoomByBuildingWithMaxCapacity(int buildingId) throws DaoException {
		// TODO Auto-generated method stub
		List<Room> room = new ArrayList<>();
		String query = "SELECT * FROM room Where buildingId=? ORDER BY (capacity) desc limit 1";
		try {
			Connection connection = dbconnection.getConnection();
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, buildingId);
			ResultSet result = pstmt.executeQuery();
			while (result.next()) {
				Room data = new Room();
				data.setRoomId(result.getInt(1));
				data.setRoomName(result.getString(2));
				data.setCapacity(result.getInt(3));
				data.setBuildingId(result.getInt(4));
				room.add(data);
			}
		} catch (DaoException | SQLException e) {
			// TODO Auto-generated catch block
			throw new DaoException(e.getMessage(), e);
		}
		return room;
	}

}
