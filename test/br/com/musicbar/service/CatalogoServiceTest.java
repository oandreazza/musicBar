package br.com.musicbar.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.musicbar.dao.CatalogoDao;
import br.com.musicbar.model.Catalogo;
import br.com.musicbar.model.Music;
import static org.mockito.BDDMockito.*;

public class CatalogoServiceTest {
	
	private CatalogoService service;
	@Mock
	private CatalogoDao dao;
	@Captor
	private ArgumentCaptor<Catalogo> captor;
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		service = new CatalogoService(dao);
	}

	@Test
	public void shouldSaveWithAListMusic() {		
		Long[] ids = new Long[3];
		ids[0] = 1L;
		ids[1] = 2L;
		ids[2] = 3L;
		service.save(ids);
		verify(dao).incluir(captor.capture());
		List<Music> musics = captor.getValue().getMusic();
		assertNotNull("Should set a list of music",musics);
		assertEquals(ids[0], musics.get(0).getId());
		assertEquals(ids[1], musics.get(1).getId());
		assertEquals(ids[2], musics.get(2).getId());
	}
	
	@Test
	public void shouldDeleteCatalogo(){
		Catalogo catalogo = new Catalogo();
		catalogo.setId(12L);
		service.delete(catalogo);
		
		verify(dao).excluir(captor.capture());
		assertEquals(catalogo.getId(), captor.getValue().getId());
	}

}
