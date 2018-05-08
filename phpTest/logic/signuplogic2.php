<?php

if (isset($_POST['submit'])) {
	include_once 'db.php';

	$username = mysqli_real_escape_string($conn, $_POST['username']);

	// error handlers
	// check for empty fields
	if (empty($username)) {
		header("Location: ../signup.php?signup=empty")
		exit();
	} esle {
		// check if input characters are valid
		if (!preg_match("/^[a-zA-Z]*$", $username)) {
			header("Location: ../signup.php?signup=invalid");
			exit();
		} else {
			//check for email
			if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
			header("Location: ../signup.php?signup=invalid_email");
			exit();
		 	} else {
		 		$sql = "SELECT * FROM staff WHERE user";
		 	}
		}
	}

} else {
	header("Location: ../signup.php");
	exit();
}