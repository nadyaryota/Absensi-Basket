<?php 
include 'koneksi.php';
	$nama = $_GET['nama'];
	$ttl = $_GET['ttl'];
	$jk = $_GET['jk'];
	$posisi = $_GET['posisi'];
	$angkatan = $_GET['angkatan'];
	$id = $_GET['id'];

	$sql = "UPDATE player set nama = '{$nama}', ttl = '{$ttl}', jk = '{$jk}', posisi = '{$posisi}', angkatan = '{$angkatan}'
	where id = {$id}";

	echo $sql;
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