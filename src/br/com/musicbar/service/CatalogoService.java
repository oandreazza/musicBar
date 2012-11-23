package br.com.musicbar.service;


import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.musicbar.dao.CatalogoDao;
import br.com.musicbar.model.Catalogo;
import br.com.musicbar.model.Music;

@Component
public class CatalogoService {

	private CatalogoDao dao;
	
	public CatalogoService(CatalogoDao dao){
		this.dao = dao;
	}

	public void save(Long[] ids) {
		Catalogo catalogo = new Catalogo();
		List<Music> musicList = new ArrayList<Music>();
		for (int i = 0; i < ids.length; i++) {
			Music music = new Music();
			music.setId(ids[i]);
			musicList.add(music);
		}
		catalogo.setMusic(musicList);
		dao.incluir(catalogo);
	}

	public void delete(Catalogo catalogo) {
		dao.excluir(catalogo);
	}

}
