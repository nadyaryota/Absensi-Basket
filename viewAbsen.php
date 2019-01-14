<?php
include 'koneksi.php';

$id_sesi = $_GET['id'];
$sql = "SELECT
	*
FROM
	riwayat_latihan rw
LEFT JOIN sesilatihan ss ON rw.id_sesi = ss.id
LEFT JOIN player py ON py.id = rw.id_player
WHERE
	rw.id_sesi = {$id_sesi}";
$hasil = mysqli_query($con, $sql);


if ($hasil) {
	while($data = mysqli_fetch_assoc($hasil)){
		//print_r($data);
		$semua[] = $data;
	}
	
	
	//print_r($semua);
   $response['success'] = '1';
   $response['data'] = $semua;
   
   $json = json_encode($response);
   print_r($json);
   

} else {
	$response['success'] = '0';
 
}


?>