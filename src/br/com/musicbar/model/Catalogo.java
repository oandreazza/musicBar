package br.com.musicbar.model;

import java.util.List;

public class Catalogo {

	private List<Music> musics;

	public List<Music> getMusic() {
		return this.musics;
	}

	public void setMusic(List<Music> musicList) {
		this.musics = musicList;
	}

}
