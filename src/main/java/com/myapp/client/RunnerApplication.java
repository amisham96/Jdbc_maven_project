package com.myapp.client;

import java.util.List;

import com.myapp.entity.Building;
import com.myapp.entity.Room;
import com.myapp.exception.serviceexception.BuildingRoomServiceException;
import com.myapp.exception.utilityexception.IntegerNotFoundExceeption;
import com.myapp.exception.utilityexception.StringNotFoundException;
import com.myapp.service.serviceimpl.BuildingServiceImpl;
import com.myapp.service.serviceimpl.RoomServiceImpl;
import com.myapp.utility.utilityimpl.KeyBoardUtilityImpl;

public class RunnerApplication {
	static RoomServiceImpl roomService = new RoomServiceImpl();
	static BuildingServiceImpl buildingService = new BuildingServiceImpl();
	static KeyBoardUtilityImpl input = new KeyBoardUtilityImpl();

	public static void main(String[] args) {

		boolean flag = true;
		do {
			System.out.println("1. Add Building");
			System.out.println("2. Add Room. Also throw Exception if building id is not present");
			System.out.println("3. Display list of buildings");
			System.out.println("4. Display all rooms in a perticular building");
			System.out.println("5. Display the room with the maximum capacity, given a building id");
			System.out.println("6. Exit");
			System.out.println("Enter your Choice");
			int choice = 0;
			try {
				choice = input.getInt();
			} catch (IntegerNotFoundExceeption e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			switch (choice) {
			case 1: {
				try {
					int result = buildingService.addBuilding(addBuildingData());
					System.out.println(result + " row affected");
				} catch (BuildingRoomServiceException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			}
			case 2: {
				try {
					int result = roomService.addRoom(addRoomData());
					System.out.println(result + " row affected");
				} catch (BuildingRoomServiceException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			}
			case 3: {
				try {
					List<Building> data = buildingService.getAllBuildingWithRooms();
					for (Building building : data) {
						System.out.println("buildingId=" + building.getBuildingId() + " buildingName="
								+ building.getBuildingName());
					}
				} catch (BuildingRoomServiceException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			}
			case 4: {
				System.out.println("Enter building id to find all rooms");
				try {
					int buildingId = input.getInt();
					List<Room> room = roomService.getRoomByBuildingId(buildingId);
					for (Room room2 : room) {
						System.out.println(room2.toString());
					}
				} catch (IntegerNotFoundExceeption | BuildingRoomServiceException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}

				break;
			}
			case 5: {
				System.out.println("Enter building id to find all rooms");
				try {
					int buildingId = input.getInt();
					List<Room> room = roomService.getRoomByBuildingWithMaxCapacity(buildingId);
					for (Room room2 : room) {
						System.out.println(room2.toString());
					}
				} catch (IntegerNotFoundExceeption | BuildingRoomServiceException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			}
			case 6: {
				flag = false;
				break;
			}

			default: {
				System.err.println("Invalid Input");
				break;
			}
			}
		} while (flag);

	}

	public static Room addRoomData() {
		Room room = new Room();
		try {
			System.out.println("Enter Room Id");
			room.setRoomId(input.getInt());
			System.out.println("Enter Room Name");
			room.setRoomName(input.getString());
			System.out.println("Enter Room Capacity");
			room.setCapacity(input.getInt());
			System.out.println("Enter Building Id");
			room.setBuildingId(input.getInt());
		} catch (IntegerNotFoundExceeption | StringNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return room;
	}

	public static Building addBuildingData() {
		Building building = new Building();
		try {
			System.out.println("Enter Building Id");
			building.setBuildingId(input.getInt());
			System.out.println("Enter Building Name");
			building.setBuildingName(input.getString());
		} catch (IntegerNotFoundExceeption | StringNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return building;
	}

}
