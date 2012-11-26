/***
 * Copyright (c) 2009 Caelum - www.caelum.com.br/opensource
 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.com.musicbar.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.musicbar.model.Catalogo;
import br.com.musicbar.model.Estabelecimento;
import br.com.musicbar.model.Music;
import br.com.musicbar.service.CatalogoService;
import br.com.musicbar.service.MusicService;

@Resource
public class IndexController {

	private final Result result;
	private final CatalogoService catalogoService;
	private final MusicService musicService;
	private final Estabelecimento estab;

	public IndexController(Result result, CatalogoService catalogoService, MusicService musicService, Estabelecimento estab) {
		this.result = result;
		this.catalogoService = catalogoService;
		this.musicService = musicService;
		this.estab = estab;
	}

	@Path("/acervo")
	public void index() {
		this.list(null);
	}
	
	@Post
	@Path("/acervo/salvar")
	public void save(Long[] ids){
		catalogoService.save(ids);
		result.redirectTo(this).index();
	}
	
	@Post("/acervo/search")
	public void search(Music musicFilter){
		this.list(musicFilter);
	}
	
	private void list(Music musicFilter){
		result.include("musicList",musicService.search(musicFilter));
	}
	
	@Post("/acervo/delete")
	public void delete(Catalogo catalogo){
		catalogoService.delete(catalogo);
		result.redirectTo(this).index();
	}
	
	@Get("/acervo/player")
	public void player(){
		
	}

}
