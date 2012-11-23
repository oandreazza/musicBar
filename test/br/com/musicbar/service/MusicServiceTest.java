package br.com.musicbar.service;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.*;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.musicbar.dao.MusicDao;

public class MusicServiceTest {
	
	private MusicService service;
	@Mock
	private MusicDao dao;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		service = new MusicService(dao);
	}

	@Test
	public void shouldReturnListOfMusic() {
		service.search();
		verify(dao).listar();
	}

}
