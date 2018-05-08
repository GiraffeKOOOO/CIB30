<?php

session_start();

if (isse($_POST['submit'])) {
	include 'db.php';

	$uid = mysqli_real_escape_string($conn, $_POST['uid']);
	$pwd = mysqli_real_escape_string($conn, $_POST['pwd']);

	// error handlers
	// check if inputs are empty

	if (empty($uid) || empty($pwd)){
		header("Location: ../index.php?login=empty");
		exit();
	} else {
		$query = "SELECT * FROM staff WHERE user_ID ='$uid'";
		$result = mysqli_query($conn, $query);
		$resultCheck = mysqli_num_rows($result);
		if($resultCheck < 1) {
			header("Location: ../index.php?login=error");
			exit();
		} else {
			if ($row = mysqli_fetch_assoc($result) {
				// de-hashing the password
				// $hashedPwdCheck = password_verify($pwd, $row['user_pwd']);
				//if($hashedPwdCheck == false){
				//	header("Location: ../index.php?login=error");
				// 	exit();
				//} elseif($hashedPwdCheck == true) {
				//	//log in the user here
				//	$_SESSION['u_id'] = $row['user_id']; 
				//	header("Location: ../index.php?login=success");
				//	exit();
				//}

			} else {
				// log in the user here
				$_SESSION['u_id'] = $row['staff_ID'];
				header("Location: ../index.php?login=success");
				exit();
			}
		}
	}
} else {
	header("Location: ../index.php?login=error");
	exit();
}