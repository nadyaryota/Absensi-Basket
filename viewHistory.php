<?php
include 'koneksi.php';

$sql = "SELECT * FROM sesilatihan";
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