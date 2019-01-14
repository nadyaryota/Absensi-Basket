<?php
include 'koneksi.php';
	$id = $_GET['id'];
 $sql = "DELETE FROM player WHERE id = {$id}";

if (mysqli_query($con, $sql)) {
   $response['success'] = '1';
   $anggota['id']= $id;
   $response['data'] = $anggota;
   
   $json = json_encode($response);
   print_r($json);
   
   // echo "New record created successfully";
} else {
	$response['success'] = '0';
	 
   $json = json_encode($response);
   print_r($json);
   // echo "Error: " . $sql . "<br>" . mysqli_error($con);
}
?>