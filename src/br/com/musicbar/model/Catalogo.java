package br.com.musicbar.model;

import java.util.List;

public class Catalogo {

	private List<Music> musics;
	private Long id;

	public List<Music> getMusic() {
		return this.musics;
	}

	public void setMusic(List<Music> musicList) {
		this.musics = musicList;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

}
