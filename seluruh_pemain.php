<?php
include 'koneksi.php';

$sql = "SELECT * FROM player";
$result = mysqli_query($con, $sql);
//print_r($result);
if (mysqli_num_rows($result) > 0) {
    // output data of each row
	//$row = mysqli_fetch_row($result);
	//print_r($row);
	
	while($row = mysqli_fetch_assoc($result)) {
      //print_r($row);
		$data[] = $row;
    }
	//print_r($data);
	$success = "1";
	$response['success'] = $success;
	$response['data'] = $data;
	print_r(json_encode($response));
   
} else {
    echo "0 results";
}


?>