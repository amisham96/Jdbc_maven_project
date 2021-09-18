package com.myapp.entity;

import java.util.List;

public class Building {

	public Building() {
		// TODO Auto-generated constructor stub
	}

	private int buildingId;
	private String buildingName;
	private List<Room> room;

	public Building(int buildingId, String buildingName, List<Room> room) {
		super();
		this.buildingId = buildingId;
		this.buildingName = buildingName;
		this.room = room;
	}

	public int getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public List<Room> getRoom() {
		return room;
	}

	public void setRoom(List<Room> room) {
		this.room = room;
	}

	@Override
	public String toString() {
		return "Building [buildingId=" + buildingId + ", buildingName=" + buildingName + ", room=" + room + "]";
	}

}
