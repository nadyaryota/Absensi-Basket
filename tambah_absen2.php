<?php
	include 'koneksi.php';
	$tanggal = $_GET['tanggal'];
	$nama = $_GET['nama'];
	$keterangan = $_GET['keterangan'];
	
 $sql = "INSERT INTO riwayat_latihan (tanggal, nama, keterangan)
VALUES ('{$tanggal}', '{$nama}', '{$keterangan}')";

if (mysqli_query($con, $sql)) {
   $response['success'] = '1';
   
   $json = json_encode($response);
   print_r($json);
   
   // echo "New record created successfully";
} else {
	$response['success'] = '0';
   // echo "Error: " . $sql . "<br>" . mysqli_error($con);
}

?>