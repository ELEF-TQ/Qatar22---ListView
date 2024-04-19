package com.example.myapplication;

import java.io.Serializable;

public class Team implements Serializable { 
	
	private String name;
	private String nickname ;
	private int icon; 
	private int photo;
	private int participation;
	private int winner;
	private String description="";

	public Team(String name, String nickname, int icon, int photo, int participation, int winner, String description) {
		this.name = name;
		this.nickname = nickname;
		this.icon = icon;
		this.photo = photo;
		this.participation = participation;
		this.winner = winner;
		this.description = description;
	}

	public Team() {

	}


	public String getName() {
		return name;
	}

	public String getNickname() {
		return nickname;
	}

	public int getIcon() {
		return icon;
	}

	public int getPhoto() {
		return photo;
	}

	public int getParticipation() {
		return participation;
	}

	public int getWinner() {
		return winner;
	}

	public String getDescription() {
		return description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public void setPhoto(int photo) {
		this.photo = photo;
	}

	public void setParticipation(int participation) {
		this.participation = participation;
	}

	public void setWinner(int winner) {
		this.winner = winner;
	}

	public void setDescriptionId(String description) {
		this.description = description;
	}
 
	
}
