<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<?php include ('config.php'); ?>
		<title>Cadastro</title>
		<script type="text/javascript" src="src/functions.js"></script>
	</head>
	<body>

	<div class="raca"> <!-- Raça começa -->
	<?php
	if(@$_REQUEST['botao_raca']=='Gravar'){
		$nome_raca = $_POST['nome_raca'];
		$raridade_raca = $_POST['raridade_raca'];
		$desc_raca = $_POST['desc_raca'];
		$longevidade_raca = $_POST['longevidade_raca'];
		$fisio_raca = $_POST['fisio_raca'];
		$cultura_raca = $_POST['cultura_raca'];
		$historia_raca = $_POST['historia_raca'];
		$raca_for = $_POST['raca_for'];
		$raca_con = $_POST['raca_con'];
		$raca_agi = $_POST['raca_agi'];
		$raca_des = $_POST['raca_des'];
		$raca_int = $_POST['raca_int'];
		$raca_sab = $_POST['raca_sab'];
		$raca_car = $_POST['raca_car'];
		$sangue_raca = $_POST['sangue_raca'];
		$vigor_raca = $_POST['vigor_raca'];

		
		
		$query = "INSERT INTO raca(nome,raridade,desc_raca,longevidade,tracos_fisio,cultura,historia,raca_for,raca_con,raca_agi,raca_des,raca_int,raca_sab,raca_car,sangue,vigor) values ('$nome_raca','$raridade_raca','$desc_raca','$longevidade_raca','$fisio_raca','$cultura_raca','$historia_raca','$raca_for','$raca_con','$raca_agi','$raca_des','$raca_int','$raca_sab','$raca_car','$sangue_raca','$vigor_raca')";
		$result = mysqli_query($con, $query);
	}
	?>	
		<form action=#raca method=post>
			<h1>&#10023 Raça </h1>
			Nome: <input type=text name="nome_raca" maxlength=50><br>
			Raridade: <input type=text name="raridade_raca"><br>
			Descrição: <textarea name="desc_raca"> </textarea><br>
			Longevidade: <input type=number name="longevidade_raca"> Anos <br>
			Traços Fisiologicos: <textarea name="fisio_raca"> </textarea><br>
			Cultura: <textarea name="cultura_raca"> </textarea><br>
			História: <textarea name="historia_raca"> </textarea><br>
			Força: <input type=number name="raca_for"><br>
			Constituição: <input type=number name="raca_con"><br>
			Agilidade: <input type=number name="raca_agi"><br>
			Destreza: <input type=number name="raca_des"><br>
			Inteligência: <input type=number name="raca_int"><br>
			Sabedoria: <input type=number name="raca_sab"><br>
			Carisma:  <input type=number name="raca_car"><br>
			Sangue:  <input type=number name="sangue_raca"><br>
			Vigor:  <input type=number name="vigor_raca"><br>
			<input type=submit name="botao_raca" value="Gravar">
		</form>
		
		<form action=#raca method=post>
<?php
	if(@$_REQUEST['raca_habilidade']=='Associar'){
		$HabHabilidade = $_POST['HabHabilidade4'];
		$RaRaca = $_POST['RaRaca'];
		
		$query = "INSERT INTO raca_has_habilidades (idHabilidades,idraca) values ('$HabHabilidade','$RaRaca')";
		$result = mysqli_query($con, $query);
	}
?>
		<h2>Raça-Habilidade</h2>
			<select name="RaRaca">
<?php
	$query = "SELECT idraca,nome FROM raca";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idraca'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>				
			</select>
			<select name="HabHabilidade4">
<?php
	$query ="SELECT idHabilidades,nome FROM habilidades";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idHabilidades'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>
			</select>
			<input type=submit name="raca_habilidade" value="Associar">
			</form>	

		<form action=#raca method=post>
<?php
	if(@$_REQUEST['raca_patrono']=='Associar'){
		$RaRaca = $_POST['RaRaca2'];
		$PaPatrono = $_POST['PaPatrono'];
		
		$query = "INSERT INTO raca_has_patrono (idraca,idpatrono) values ('$RaRaca','$PaPatrono')";
		$result = mysqli_query($con, $query);
	}
?>
		<h2>Raça-Patrono</h2>
			<select name="RaRaca2">
<?php
	$query = "SELECT idraca,nome FROM raca";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idraca'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>				
			</select>
			<select name="PaPatrono">
<?php
	$query ="SELECT idPatrono,nome FROM patrono";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idPatrono'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>
			</select>
			<input type=submit name="raca_patrono" value="Associar">
			</form>	

		<form action=#raca method=post>
<?php
	if(@$_REQUEST['raca_habito']=='Associar'){
		$RaRaca = $_POST['RaRaca3'];
		$HabHabito = $_POST['HabHabito'];
		$qtd_habito_raca = $_POST['qtd_habito_raca'];
		
		$query = "INSERT INTO raca_has_habitos (idRaca,idHabito,quantidade) values ('$RaRaca','$HabHabito','$qtd_habito_raca')";
		$result = mysqli_query($con, $query);
	}
?>
		<h2>Raça-Habito</h2>
			<select name="RaRaca3">
<?php
	$query = "SELECT idraca,nome FROM raca";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idraca'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>				
			</select>
			<select name="HabHabito">
<?php
	$query ="SELECT idhabitos,nome FROM habito";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idhabitos'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>
			</select>
			Qtd: <input type=number name="qtd_habito_raca">
			<input type=submit name="raca_habito" value="Associar">
			</form>	
			
		<form action=#raca method=post>
<?php
	if(@$_REQUEST['raca_descendencia']=='Associar'){
		$RaRaca = $_POST['RaRaca4'];
		$DeDescendencia = $_POST['DeDescendencia2'];
		
		$query = "INSERT INTO raca_has_descendencia (idRaca,idDescendencia) values ('$RaRaca','$DeDescendencia')";
		$result = mysqli_query($con, $query);
	}
?>
		<h2>Raça-Descendencia</h2>
			<select name="RaRaca4">
<?php
	$query = "SELECT idraca,nome FROM raca";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idraca'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>				
			</select>
			<select name="DeDescendencia2">
<?php
	$query ="SELECT iddescendencia,nome FROM descendencia";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['iddescendencia'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>
			</select>
			<input type=submit name="raca_descendencia" value="Associar">
		</form>	
			
		<form action=#raca method=post>
<?php
	if(@$_REQUEST['raca_idioma']=='Associar'){
		$RaRaca = $_POST['RaRaca5'];
		$IdiIdiomas = $_POST['IdiIdiomas'];
		
		$query = "INSERT INTO raca_has_idiomas (idRaca,idIdiomas) values ('$RaRaca','$IdiIdiomas')";
		$result = mysqli_query($con, $query);
	}
?>
		<h2>Raça-Idioma</h2>
			<select name="RaRaca5">
<?php
	$query = "SELECT idraca,nome FROM raca";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idraca'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>				
			</select>
			<select name="DeDescendencia2">
<?php
	$query ="SELECT IdIdiomas,nome FROM idioma";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['IdiIdiomas'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>
			</select>
			<input type=submit name="raca_idioma" value="Associar">
		</form>	

		<form action=#raca method=post>
<?php
	if(@$_REQUEST['raca_especializacao']=='Associar'){
		$RaRaca = $_POST['RaRaca6'];
		$EspEspecializacao = $_POST['EspEspecializacao'];
		
		$query = "INSERT INTO raca_has_especializacao (idRaca,idEspecializacao) values ('$RaRaca','$EspEspecializacao')";
		$result = mysqli_query($con, $query);
	}
?>
		<h2>Raça-Especialização</h2>
			<select name="RaRaca6">
<?php
	$query = "SELECT idraca,nome FROM raca";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idraca'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>				
			</select>
			<select name="EspEspecializacao">
<?php
	$query ="SELECT idEspecializacao,nome FROM especializacao";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idEspecializacao'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>
			</select>
			<input type=submit name="raca_especializacao" value="Associar">
		</form>		
	</div> <!-- Raça Termina -->
	
	<div class="tracos_raciais"> <!-- Traços raciais começa -->
	<?php
	if(@$_REQUEST['botao_traco']=='Gravar'){
		$raca_tracoracial = $_POST['raca_tracoracial'];
		$nome_traco = $_POST['nome_traco'];
		$nivel_traco = $_POST['nivel_traco'];
		$desc_traco = $_POST['desc_traco'];
		
		$query = "INSERT INTO tracos_raciais (idraca,nome,nivel,desc_traco) values ('raca_tracoracial','$nome_traco','$nivel_traco','$desc_traco')";
		$result = mysqli_query($con,$query);
	}
	?>
		<form action=#tracos_raciais method=post>
			<h1>&#10023 Traços Raciais </h1>
			Nome:<input type=text maxlength=50 name="nome_traco"><br>
			Raça: <select name="raca_tracoracial">
<?php	
	$result = mysqli_query($con, "SELECT idraca,nome FROM raca");
	while($coluna=mysqli_fetch_array($result)){
?>			
				<option value="<?php echo $coluna['idraca'];?>"><?php echo $coluna['nome'];?></option>
<?php
	}
	
?>
			</select><br>
			Nível: <input type=number name="nivel_traco"><br>
			Descrição: <textarea name="desc_traco"> </textarea><br>
			<input type=submit name="botao_traco" value="Gravar">
		</form>
	</div> <!-- Traços raciais termina -->
	
	<div class="caminho"> <!-- Caminho começa -->
		<form action=#caminho method=post>
			<h1>&#10023 Caminho </h1>
<?php
	if(@$_REQUEST['botao_caminho']=='Gravar'){
		$nome_caminho = $_POST['nome_caminho'];
		$desc_caminho = $_POST['desc_caminho'];
		
		$query = "INSERT INTO caminho (nome,caminho_desc) values ('$nome_caminho','$desc_caminho')";
		$result = mysqli_query($con,$query);
	}
?>
			Nome: <input type=text name="nome_caminho"><br>
			Descrição: <textarea name="desc_caminho"> </textarea><br>
			<input type=submit name='botao_caminho' value="Gravar">
		</form>
		
		<form action=#caminho method=post>
<?php
	if(@$_REQUEST['caminho_patrono']=='Associar'){
		$CaCaminho = $_POST['CaCaminho2'];
		$PaPatrono = $_POST['PaPatrono2'];
		
		$query = "INSERT INTO caminho_has_patrono (idCaminho,idPatrono) values ('$CaCaminho','$PaPatrono2')";
		$result = mysqli_query($con, $query);
	}
?>
		<h2>Caminho-Patrono</h2>
			<select name="CaCaminho2">
<?php
	$query ="SELECT idCaminho,nome FROM caminho";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idCaminho'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>
			</select>
			<select name="PaPatrono2">
<?php
	$query = "SELECT idPatrono,nome FROM patrono";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idPatrono'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>				
			</select>
			<input type=submit name="caminho_patrono" value="Associar">
			</form>

		<form action=#caminho method=post>
<?php
	if(@$_REQUEST['caminho_habito']=='Associar'){
		$CaCaminho = $_POST['CaCaminho3'];
		$HabHabito = $_POST['HabHabito2'];
		$qtd_caminho_habito = $_POST['qtd_caminho_habito'];
		
		$query = "INSERT INTO caminho_has_patrono (idCaminho,idHabitos,quantidade) values ('$CaCaminho','$HabHabito','$qtd_caminho_habito')";
		$result = mysqli_query($con, $query);
	}
?>
		<h2>Caminho-Habito</h2>
			<select name="CaCaminho2">
<?php
	$query ="SELECT idCaminho,nome FROM caminho";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idCaminho'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>
			</select>
			<select name="HabHabito2">
<?php
	$query = "SELECT idHabitos,nome FROM habito";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idHabitos'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>				
			</select>
			Qtd:<input type=number name="qtd_caminho_habito" value="Associar">
			<input type=submit name="caminho_habito" value="Associar">
			</form>

		<form action=#caminho method=post>
<?php
	if(@$_REQUEST['caminho_especializacao']=='Associar'){
		$CaCaminho = $_POST['CaCaminho3'];
		$EspEspecializacao = $_POST['EspEspecializacao2'];
		
		$query = "INSERT INTO especializacao_has_caminho (idCaminho,idEspecializacao) values ('$CaCaminho','$EspEspecializacao')";
		$result = mysqli_query($con, $query);
	}
?>
		<h2>Caminho-Especialização</h2>
			<select name="CaCaminho3">
<?php
	$query ="SELECT idCaminho,nome FROM caminho";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idCaminho'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>
			</select>
			<select name="EspEspecializacao2">
<?php
	$query = "SELECT idEspecializacao,nome FROM especializacao";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idEspecializacao'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>				
			</select>
			<input type=submit name="caminho_especializacao" value="Associar">
			</form>
			
	</div> <!-- caminho termina -->
	
	<div class="habilidades"><!-- Habilidades começa -->
		<form action=#habilidades method=post>
<?php
	if(@$_REQUEST['botao_habilidade']=='Gravar'){
		$nome_habilidade = $_POST['nome_habilidade'];
		$atributo_ataca = $_POST['atributo_ataca'];
		$tipo_habilidade = $_POST['tipo_habilidade'];
		$gasto1_hab = $_POST['gasto1_hab'];
		$gasto2_hab = $_POST['gasto2_hab'];
		$gasto3_hab = $_POST['gasto3_hab'];
		$utilizacao_hab = $_POST['utilizacao_hab'];
		$desc_hab = $_POST['desc_hab'];
		$pre_req = $_POST['pre_req'];
		$nivel_req = $_POST['nivel_req'];
		
		$query = "INSERT INTO habilidades(nome,atributo_ataca,tipo,gasto1,gasto2,gasto3,utilizacao,desc_hab,pre_req,nivel_req) values('$nome_habilidade','$atributo_ataca','$tipo_habilidade','$gasto1_hab','$gasto2_hab','$gasto3_hab','$utilizacao_hab','$desc_hab','$pre_req','$nivel_req')";
		$result = mysqli_query($con, $query);
	}
?>
			<h1>&#10023 Habilidades </h1>
			Nome: <input type=text name="nome_habilidade"><br>
			Atributo Atacante: <select name="atributo_ataca">
				<option value="For">For</option>
				<option value="Con">Con</option>
				<option value="Des">Des</option>
				<option value="Agi">Agi</option>
				<option value="Des">Des</option>
				<option value="Int">Int</option>
				<option value="Sab">Sab</option>
				<option value="Car">Car</option>
			</select><br>
			Tipo: <input type=text name="tipo_habilidade"><br>
			gasto 1: <input type=text name="gasto1_hab"><br>
			gasto 2: <input type=text name="gasto2_hab"><br>
			gasto 3: <input type=text name="gasto3_hab"><br>
			Utilização: <input type=text name="utilizacao_hab"><br>
			Descrição: <textarea name="desc_hab"></textarea><br>
			Pré-Requisito: <input type=text name="pre_req"><br>
			Nível Requisito: <input type=text name="nivel_req"><br>
		</form>
		
		<form action=#habilidades method=post>
<?php
	if(@$_REQUEST['habilidade_caminho']=='Associar'){
		$HabHabilidade = $_POST['HabHabilidade'];
		$CaCaminho = $_POST['CaCaminho'];
		
		$query = "INSERT INTO caminho_has_habilidades (idHabilidades,idCaminho) values ('$HabHabilidade','$CaCaminho')";
		$result = mysqli_query($con, $query);
	}
?>
		<h2> Habilidade-Caminho</h2>
			<select name="HabHabilidade">
<?php
	$query ="SELECT idHabilidades,nome FROM habilidades";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idHabilidades'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>
			</select>
			<select name="CaCaminho">
<?php
	$query = "SELECT idcaminho,nome FROM caminho";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idcaminho'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>				
			</select>
			<input type=submit name="habilidade_caminho" value="Associar">
		</form>
		
		<form action=#habilidades method=post>
<?php
	if(@$_REQUEST['habilidade_descendencia']=='Associar'){
		$HabHabilidade = $_POST['HabHabilidade2'];
		$DeDescendencia = $_POST['DeDescendencia'];
		
		$query = "INSERT INTO descendencia_has_habilidades (idHabilidades,iddescendencia) values ('$HabHabilidade','$DeDescendencia')";
		$result = mysqli_query($con, $query);
	}
?>
		<h2> Habilidade-Descendencia</h2>
			<select name="HabHabilidade2">
<?php
	$query ="SELECT idHabilidades,nome FROM habilidades";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idHabilidades'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>
			</select>
			<select name="DeDescendencia">
<?php
	$query = "SELECT iddescendencia,nome FROM descendencia";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['iddescendencia'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>				
			</select>
			<input type=submit name="habilidade_descendencia" value="Associar">	
		</form>
		
		<form action=#habilidades method=post>
<?php
	if(@$_REQUEST['habilidade_situacao']=='Associar'){
		$HabHabilidade = $_POST['HabHabilidade3'];
		$SiSituacao = $_POST['SiSituacao'];
		
		$query = "INSERT INTO situacao_has_habilidades (idHabilidades,idsituacao) values ('$HabHabilidade','$SiSituacao')";
		$result = mysqli_query($con, $query);
	}
?>
		<h2> Habilidade-Situação</h2>
			<select name="HabHabilidade3">
<?php
	$query ="SELECT idHabilidades,nome FROM habilidades";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idHabilidades'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>
			</select>
			<select name="SiSituacao">
<?php
	$query = "SELECT idsituacao,nome FROM situacao";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idsituacao'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>				
			</select>
			<input type=submit name="habilidade_situacao" value="Associar">
		</form>
			
		<form action=#habilidades method=post>
<?php
	if(@$_REQUEST['habilidade_acao']=='Associar'){
		$HabHabilidade = $_POST['HabHabilidade5'];
		$Acao = $_POST['Acao'];
		
		$query = "INSERT INTO situacao_has_habilidades (idHabilidades,idacao) values ('$HabHabilidade','$Acao')";
		$result = mysqli_query($con, $query);
	}
?>
		<h2> Habilidade-Ação</h2>
			<select name="HabHabilidade5">
<?php
	$query ="SELECT idHabilidades,nome FROM habilidades";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idHabilidades'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>
			</select>
			<select name="Acao">
<?php
	$query = "SELECT idacao,nome FROM acao";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idacao'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>				
			</select>
			<input type=submit name="habilidade_acao" value="Associar">
			</form>
	</div> <!-- Habilidades termina -->
	
	<div class="especializacao"><!-- Especialização começa -->
		<form action=#especializacao method=post>
		<h1>&#10023 Especializações</h1>
<?php
	if(@$_REQUEST['botao_especializacao']=='Gravar'){
		$nome_esp = $_POST['nome_esp'];
		$desc_esp = $_POST['desc_esp'];
		
		$query = "INSERT INTO especializacao (nome,desc_esp) values ('$nome_esp','$desc_esp')";
		$result = mysqli_query($con, $query);
	}
?>
			Nome: <input type="text" name="nome_esp"><br>
			Descrição: <textarea name="desc_esp"></textarea><br>
			<input type=submit name="botao_especializacao" value="Gravar">
		</form>
	</div><!-- Especialização termina -->
	
	<div class="idioma"> <!-- Idiomas começa -->
		<form action=#idioma method=post>
		<h1>&#10023 Idiomas</h1>
<?php
	if(@$_REQUEST['botao_idiomas']=='Gravar'){
		$nome_idi = $_POST['nome_idi'];
		$desc_idi = $_POST['desc_idi'];
		
		$query = "INSERT INTO especializacao (nome,desc_idioma) values ('$nome_idi','$desc_idi')";
		$result = mysqli_query($con, $query);
	}
?>
			Nome: <input type="text" name="nome_idi"><br>
			Descrição: <textarea name="desc_idi"></textarea><br>
			<input type=submit name="botao_idiomas" value="Gravar">
		</form>
	</div><!-- Idiomas termina -->
	
	<div class="descendencias">
		<form action=#descendencias method=post>
		<h1>&#10023 Descendencias</h1>
<?php
	if(@$_REQUEST['botao_descendencia']=='Gravar'){
		$nome_desc = $_POST['nome_desc'];
		$desc_desc = $_POST['desc_desc'];
		
		$query = "INSERT INTO descendencia (nome,desc_descend) values ('$nome_desc','$desc_desc')";
		$result = mysqli_query($con, $query);
	}
?>
			Nome: <input type="text" name="nome_desc"><br>
			Descrição: <textarea name="desc_desc"></textarea><br>
			<input type=submit name="botao_descendencia" value="Gravar">
		</form>
		
		<form action=#descendencias method=post>
<?php
	if(@$_REQUEST['descendencia_situacao']=='Associar'){
		$DeDescendencia = $_POST['DeDescendencia3'];
		$SiSituacao = $_POST['SiSituacao2'];
		
		$query = "INSERT INTO descendencia_has_situacao (idDescendencia,idSituacao) values ('$DeDescendencia','$SiSituacao')";
		$result = mysqli_query($con, $query);
	}
?>
		<h2>Descendencia-Situação</h2>
			<select name="DeDescendencia3">
<?php
	$query ="SELECT idDescendencia,nome FROM descendencia";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idDescendencia'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>
			</select>
			<select name="EspEspecializacao2">
<?php
	$query = "SELECT idSituacao,nome FROM situacao";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idSituacao'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>				
			</select>
			<input type=submit name="descendencia_situacao" value="Associar">
		</form>
		
		<form action=#descendencias method=post>
<?php
	if(@$_REQUEST['descendencia_sanidade']=='Associar'){
		$DeDescendencia = $_POST['DeDescendencia4'];
		$SaSanidade = $_POST['SaSanidade'];
		
		$query = "INSERT INTO descendencia_has_sanidade (idDescendencia,idSituacao) values ('$DeDescendencia','$SaSanidade')";
		$result = mysqli_query($con, $query);
	}
?>
		<h2>Descendencia-Sanidade</h2>
			<select name="DeDescendencia4">
<?php
	$query ="SELECT idDescendencia,nome FROM descendencia";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idDescendencia'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>
			</select>
			<select name="SaSanidade">
<?php
	$query = "SELECT idSanidade,nome FROM sanidade";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idSanidade'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>				
			</select>
			<input type=submit name="descendencia_sanidade" value="Associar">
		</form>
			
		<form action=#descendencias method=post>
<?php
	if(@$_REQUEST['descendencia_habito']=='Associar'){
		$DeDescendencia = $_POST['DeDescendencia4'];
		$HabHabito = $_POST['HabHabito3'];
		$qtd_descendencia_habito = $_POST['qtd_descendencia_habito'];
		
		$query = "INSERT INTO descendencia_has_sanidade (idDescendencia,idHabitos,quantidade) values ('$DeDescendencia','$HabHabito','$qtd_descendencia_habito')";
		$result = mysqli_query($con, $query);
	}
?>
		<h2>Descendencia-Habito</h2>
			<select name="DeDescendencia4">
<?php
	$query ="SELECT idDescendencia,nome FROM descendencia";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idDescendencia'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>
			</select>
			<select name="HabHabito3">
<?php
	$query = "SELECT idHabitos,nome FROM habito";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idHabitos'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>				
			</select>
			Qtd:<input type=number name="qtd_descendencia_habito">
			<input type=submit name="descendencia_habito" value="Associar">
		</form>
	</div>
	
	<div class="cidades">
		<form action=#cidades method=post>
		<h1>&#10023 Cidade</h1>
<?php
	if(@$_REQUEST['botao_cidade']=='Gravar'){
		$nome_cid = $_POST['nome_cid'];
		$desc_cid = $_POST['desc_cid'];
		$populacao = $_POST['populacao'];
		
		$query = "INSERT INTO cidade (nome,desc_cidade,populacao) values ('$nome_cid','$desc_cid','$populacao')";
		$result = mysqli_query($con, $query);
	}
?>
			Nome: <input type="text" name="nome_cid"><br>
			Descrição: <textarea name="desc_cid"></textarea><br>
			População: <input type="text" name="populacao"><br>
			<input type=submit name="botao_cidade" value="Gravar">
		</form>
	</div>
	
	<div class="situacoes">
		<form action=#situacoes method=post>
		<h1>&#10023 Situação</h1>
<?php
	if(@$_REQUEST['botao_situacao']=='Gravar'){
		$nome_sit = $_POST['nome_sit'];
		$desc_sit = $_POST['desc_sit'];
		
		$query = "INSERT INTO situacao (nome,desc_sit) values ('$nome_sit','$desc_sit')";
		$result = mysqli_query($con, $query);
	}
?>
			Nome: <input type="text" name="nome_sit"><br>
			Descrição: <textarea name="desc_sit"></textarea><br>
			<input type=submit name="botao_situacao" value="Gravar">
		</form>
	</div>

	<div class="patronos">
		<form action=#patronos method=post>
		<h1>&#10023 Patrono</h1>
<?php
	if(@$_REQUEST['botao_patrono']=='Gravar'){
		$nome_pat = $_POST['nome_pat'];
		$desc_pat = $_POST['desc_pat'];
		
		$query = "INSERT INTO patrono (nome,desc_pat) values ('$nome_pat','$desc_pat')";
		$result = mysqli_query($con, $query);
	}
?>
			Nome: <input type="text" name="nome_pat"><br>
			Descrição: <textarea name="desc_pat"></textarea><br>
			<input type=submit name="botao_patrono" value="Gravar">
		</form>
	</div>

	<div class="habito">
		<form action=#habito method=post>
		<h1>&#10023 Habito</h1>
<?php
	if(@$_REQUEST['botao_habito']=='Gravar'){
		$nome_hab = $_POST['nome_hab'];
		$desc_hab = $_POST['desc_hab'];
		
		$query = "INSERT INTO habito (nome,desc_hab) values ('$nome_hab','$desc_hab')";
		$result = mysqli_query($con, $query);
	}
?>
			Nome: <input type="text" name="nome_hab"><br>
			Descrição: <textarea name="desc_hab"></textarea><br>
			<input type=submit name="botao_habito" value="Gravar">
		</form>
	</div>
	
	<div class="itens">
		<form action=#habito method=post>
		<h1>&#10023 Item</h1>
<?php
	if(@$_REQUEST['botao_item']=='Gravar'){
		$nome_item = $_POST['nome_item'];
		$desc_item = $_POST['desc_item'];
		$peso_item = $_POST['peso_item'];
		$valor_magico = $_POST['valor_magico'];
		$valor_item = $_POST['valor_item'];
		$moeda = $_POST['moeda'];
		
		$query = "INSERT INTO habito (nome,desc_item,peso,valor_magico,valor,moeda) values ('$nome_item','$desc_item','$peso_item','$valor_magico','$valor_item','$moeda')";
		$result = mysqli_query($con, $query);
	}
?>
			Nome: <input type="text" name="nome_item"><br>
			Descrição: <textarea name="desc_item"></textarea><br>
			Peso: <input type="text" name="peso_item"><br>
			Valor Magico: <input type="text" name="valor_magico"><br>
			Valor: <input type="text" name="valor_item"><br>
			Moeda: <select name="moeda">
			<option value=0>Não</option>
			<option value=1>Sim</option>
			</select><br>
			<input type=submit name="botao_item" value="Gravar">
		</form>
		
		<form action=#habito method=post>
<?php
	if(@$_REQUEST['habito_especializacao']=='Associar'){
		$HabHabito = $_POST['HabHabito4'];
		$EspEspecializacao = $_POST['EspEspecializacao3'];
		
		$query = "INSERT INTO habitos_has_especializacao (idHabitos,idEspecializacao) values ('$HabHabito','$EspEspecializacao')";
		$result = mysqli_query($con, $query);
	}
?>
		<h2>Habito-Especializacao</h2>
			<select name="HabHabito4">
<?php
	$query ="SELECT idHabitos,nome FROM habito";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idHabitos'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>
			</select>
			<select name="EspEspecializacao3">
<?php
	$query = "SELECT idEspecializacao,nome FROM especializacao";
	$result = mysqli_query($con, $query);
	while($coluna=mysqli_fetch_array($result)){
?>
				<option value="<?php echo $coluna['idEspecializacao'];?>"><?php echo $coluna['nome'];?></option>
<?php	}?>				
			</select>
			<input type=submit name="habito_especializacao" value="Associar">
		</form>
	</div>
	</body>
</html>