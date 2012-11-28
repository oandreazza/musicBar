<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
    <title>Music Bar</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="<c:url value="/assets/css/bootstrap.css"/>" rel="stylesheet" />
    <link href="<c:url value="/assets/css/bootstrap-responsive.css"/>" rel="stylesheet" />
    <script type="text/javascript" src="<c:url value="/assets/js/jquery-1.7.2.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/assets/js/bootstrap-modal.js"/>"></script>
    
    <script type="text/javascript">
    $(function(){
    	
    	$("#form_music").on('submit',function(){
    		if($('#lista-atual li').length == 0){
    			$("#descriptionError").html('Você deve selecionar ao menos uma música');
    			$('#myModal').modal();
    			return false;
    		}
    		
    		if($('#inputEstabelecimento').val() == 0){
    			$("#descriptionError").html('Você deve selecionar um estabelecimento');
    			$('#myModal').modal();
    			return false;
    		}
    	});
    	
    	$('#lista-disponiveis li a').on('click',function(){
    		var podeTransferir = true;
    		var texto = $(this).parent().find(".nome").text();
    		var id = $(this).parent().attr('id');
    		
    		$('#lista-atual li').each(function(){
    			if($(this).attr('id') == id){
    				podeTransferir = false;
    				return false;
    			}  				
    		});
    		
    		$("#cleanList").on('click',function(){
    			$('#lista-atual li').remove();
    			$('#form-music input[type="hidden"]').remove();
    		});
    		
    		if(podeTransferir){
    			$('#lista-atual').prepend($('<li>',{
    					text: texto,
    					id: id 
    				}));
    			
    			$('#form-music').prepend($('<input>',{
					type: 'hidden',
					value: id,
					name: 'ids[]'
				}));
    		}else{
    			$("#descriptionError").html('Esta música já existe no Acervo!<br>Por favor, escolha outra.');
    			$('#myModal').modal();
    		}
    	});
    	
    	
    });
    </script>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <style type="text/css">
    	.list{
	    	width: 90%;
			border: 1px solid red;
			border-radius: 7px;
			margin-left: 2%;
			height: 350px;
			overflow-y: auto;
    	}
    	
    	.list ul{
    		list-style: none;
			margin: 23px 3px 3px  3px;

    	}
    	
    	.list ul li{
    		border: 1px solid black;
    		padding: 5px;
    		margin-bottom: 3px;
    		display: block;
    	}
    	
    	#header{
    		height: 100px;
    		background-color: #207424;
    		margin-bottom: 20px;
    	}
    	#botoes-form{
    		margin-top: 10px;
    	}
    	.control-label{
    		color: #FFFCFC;
			font-weight: bold;
    	}
    </style>
 </head>
<body>
	
	<div class='row-fluid'>
		<div class="span12" id="header">
			<form class="form-horizontal" style="margin-top:53px">
			  <div class="control-group">
			    <label class="control-label" for="inputEstabelecimento">Estabelecimento</label>
			    <div class="controls">
			      <select id="inputEstabelecimento">
			      	<option value="0">Selecione..</option>
			      	<option>Bar do zé</option>
			      	<option>Botecão</option>
			      </select>
			    </div>
			  </div>
			</form>
		</div>
	</div>
	
	<div class='row-fluid'>
		<div class="span6">
			<div class='row-fluid show-grid'>
				<div class="list">
					<ul id="lista-disponiveis">
						<li id="4">
							<a href="#">+</a> 
							<span class="nome">Musica 1</span>
						</li>
						<li id="3">
							<a href="#">+</a> 
							<span class="nome">Musica 2</span>
						</li>
						<li id="2">
							<a href="#">+</a> 
							<span class="nome">Musica 3</span>
						</li>
						<li id="1">
							<a href="#">+</a> 
							<span class="nome">Musica 4</span>
						</li>
					</ul>
				</div>
			</div>
		</div>
		
		<div class="span6">
			<div class='row-fluid show-grid'>
				<div class="list">
					<ul id="lista-atual">
					</ul>
				</div>
			</div>
			<div class='row-fluid' id="botoes-form">
				<div class="span8">
				</div>
				<div class="span4">	
					<button class="btn"id="cleanList">Limpar a lista</button>
					<form action="<c:url value="/acervo/salvar"/>" method="post"  id="form_music">
						<button class="btn btn-primary">Salvar</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal hide" id="myModal">
		<div class="modal-header">
		  <button type="button" class="close" data-dismiss="modal">X</button>
		  <h3>Atenção!</h3>
		</div>
		<div class="modal-body">
		  <p id="descriptionError"></p>
		</div>
		<div class="modal-footer">
		  <a href="#" class="btn" data-dismiss="modal">OK</a>
		</div>
	</div>
</body>
</html>