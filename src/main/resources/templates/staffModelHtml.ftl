<!doctype html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>${staff.id}</title>
  <link rel="stylesheet" href="../src/main/resources/staffPage.css">
  <link rel="icon" href="../img/logoIco.ico" />
  <!--<script src="script.js"></script>-->
</head>
<body>
	<header>
		<h2>GO Securi</h2>
	</header>
	<section>
		<article id="desc">
			<table>
				<tr>
					<th colspan=2>${staff.id}</th>
				</tr>
					
				<tr>
					<td>Nom</td>
					<td id=cellStaff2>${staff.firstName}</td>
				</tr>
				<tr>
					<td>Prenom</td>
					<td id=cellStaff2>${staff.name}</td>
				</tr>
				<tr>
					<td>Mission</td>
					<td id=cellStaff2>${staff.mission}</td>
				</tr>
			</table>
		</article>
		<article id="carteID">
			<img src="../${staff.carte}" />
		</article>
	</section>
	<section>
		<article>
			<table id=staffTable2>
				<tr>
					<th>Matériel utilisé pour la mission actuelle</th>
				</tr>
				<#list staff.materiels as materiel>
				<tr>
					<td>${materiel.description}</td>
				</tr>
				</#list>
			</table>
		</article>
	</section>
  <!-- Le reste du contenu -->
  <footer>
  	<a href="../index.html">Retour</a>
  </footer>

</body>
</html>