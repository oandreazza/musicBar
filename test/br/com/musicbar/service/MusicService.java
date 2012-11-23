package br.com.musicbar.service;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.musicbar.dao.MusicDao;
import br.com.musicbar.model.Music;

@Component
public class MusicService {

	private final MusicDao dao;

	public MusicService(MusicDao dao) {
		this.dao = dao;
	}

	public List<Music> search(Music musicFilter) {
		return dao.listar(musicFilter);
	}

}
