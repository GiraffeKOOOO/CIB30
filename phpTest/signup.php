<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>KITS Home</title>
		<link rel="icon" type="image/png" href="webicon.png" sizes="96x96">
	</head>
<body>
	<link rel="stylesheet" type="text/css" href="style.css">

	<header>
		<h1>Sign Up</h1>
	</header>

	<section>
		<div class="nav-signup">
			<form action="logic/signuplogic.php"  method="POST">
				<input type="text" name="username" placeholder="Staff user ID">
				<input type="text" name="password" placeholder="password">
				<button type="submit" name="submit">Submit</button>
			</form>
		</div>
	</section>

</body>
</html>