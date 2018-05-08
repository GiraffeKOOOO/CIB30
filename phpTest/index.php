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
			<h1>Home Page</h1>
		</header>

		<section>
			<div class="nav-login">
				<form action="logic/login.php" method="POST">
					<input type="text" name="username" placeholder="Staff user ID">
					 <input type="text" name="password" placeholder="password">
					 <button type="submit" name="submit">Login</button>
					 <a href="signup.php">Sign Up</a>
				</form>
			</div>
			
		</section>

	</body>

</html>