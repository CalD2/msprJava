<!doctype html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <title>Index</title>
  <link rel="stylesheet" href="src/main/resources/staffPage.css">
  <link rel="icon" href="img/logoIco.ico" />
  <!--<script src="script.js"></script>-->
</head>
<body>
	<header>
		<h2>GO Securi</h2>
	</header>
	<section>
		<article>
			<div id="divLogo">
				<img src="img/logo.png" >
			</div>
			<table>
				<tr>
					<th colspan=2>Liste des agents</th>
				</tr>
					<#list staffs as string>
						<tr>
							<td><img src="img/perso.png" ></td>
							<td id=name><a id=name href="staffs/${string}.html">${string}</a></td>
						</tr>
					</#list>
			</table>
		</article>
	</section>
  <!-- Le reste du contenu -->

</body>
</html>