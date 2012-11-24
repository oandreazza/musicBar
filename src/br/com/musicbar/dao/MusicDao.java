package br.com.musicbar.dao;

import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.musicbar.model.Music;


public interface MusicDao {

	List<Music> listar(Music musicFilter);

}
