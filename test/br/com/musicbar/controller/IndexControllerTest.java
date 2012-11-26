package br.com.musicbar.controller;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.BDDMockito.*;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.musicbar.controller.IndexController;
import br.com.musicbar.model.Estabelecimento;
import br.com.musicbar.model.Music;
import br.com.musicbar.service.CatalogoService;
import br.com.musicbar.service.MusicService;

@Resource
public class IndexControllerTest {
	
	private IndexController controller;
	private Result result = new MockResult();
	@Mock
	private CatalogoService catalogoService;
	@Mock
	private MusicService musicService;
	@Mock
	private Estabelecimento estab;

	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		controller = new IndexController(result,catalogoService, musicService,estab);
	}
	
	@Test
	public void shouldCallSaveWithId() {
		Long[] ids = new Long[3];
		ids[0] = 1L;
		ids[1] = 2L;
		ids[2] = 3L;
		controller.save(ids);
		verify(catalogoService).save(ids);
	}
	
	@Test
	public void shouldListAllMusics(){
		controller.index();
		verify(musicService).search(null);
	}


}
