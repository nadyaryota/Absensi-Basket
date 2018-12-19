<?php
	include 'koneksi.php';
	$nama = $_GET['nama'];
	$ttl = $_GET['ttl'];
	$jk = $_GET['jk'];
	$posisi = $_GET['posisi'];
	$angkatan = $_GET['angkatan'];
	
 $sql = "INSERT INTO player (nama, ttl, jk, posisi, angkatan)
VALUES ('{$nama}', '{$ttl}', '{$jk}', '{$posisi}', '{$angkatan}')";

if (mysqli_query($con, $sql)) {
   $response['sukses'] = '1';
   
   $json = json_encode($response);
   print_r($json);
   
   // echo "New record created successfully";
} else {
	$response['sukses'] = '0';
   // echo "Error: " . $sql . "<br>" . mysqli_error($con);
}

?>