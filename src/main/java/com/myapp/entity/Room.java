package com.myapp.entity;

public class Room {

	public Room() {
		// TODO Auto-generated constructor stub
	}

	private int roomId;
	private String roomName;
	private int capacity;
	private int buildingId;

	public Room(int roomId, String roomName, int capacity, int buildingId) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
		this.capacity = capacity;
		this.buildingId = buildingId;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomName=" + roomName + ", capacity=" + capacity + ", buildingId="
				+ buildingId + "]";
	}

}
