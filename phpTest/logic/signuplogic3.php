<?php

if (isset($_POST['submit'])) {
	include_once 'db.php';

	$username = mysqli_real_escape_string($conn, $_POST['username']);
	$pwd = mysqli_real_escape_string($conn, $_POST['password']);

	// error handlers
	// check for empty fields
	if (empty($username)) {
		header("Location: ../signup.php?signup=empty")
		exit();
	} esle {
		// check if input characters are valid
		if (!preg_match("/^[a-zA-Z]*$/", $username)) {
			header("Location: ../signup.php?signup=invalid");
			exit();
		} else {
			$query1 = "SELECT * FROM staff WHERE username_ID='$username'";
			$result = mysqli_query($conn, $query1);
			$resultCheck = mysqli_num_rows($result1);

			if ($resultCheck > 0){
			header("Location: ../signup.php?signup=userTaken");
			exit();
			} else {
				// hashing the password
				$hashedpwd = password_hash($pwd, PASSWORD_DEFAULT);
				// insert the user in to the database
				$sqlIn = "INSERT INTO staff VALUES ($username, $hashedpwd)";
				mysqli_query($conn, $sqlIn);
				header("Location: ../signup.php?signup=success");
				exit();
			}
		}
	}

} else {
	header("Location: ../signup.php");
	exit();
}