<?php
	include 'koneksi.php';
	//print_r($_POST);
	$data = json_decode($_POST['absensi']);
	//$dapat_data = json_decode($test);
	//$data = $dapat_data['absensi'];
	
	//print_r($data);
	$sql1 = "INSERT sesilatihan(hari,tanggal,jam) VALUES (DAYNAME(NOW()),NOW(),NOW())";
	$hasil = mysqli_query($con,$sql1);
	$sql2 = "SELECT LAST_INSERT_ID()";
	$hasil = mysqli_query($con,$sql2);
	$row = mysqli_fetch_assoc($hasil);
	$id_sesi = $row['LAST_INSERT_ID()'];
	//$id_sesi;
	//print_r ($id_sesi);
	if(count($data)>1){
		$sql ="INSERT INTO riwayat_latihan (id_sesi, id_player, keterangan, id_kehadiran)
	VALUES ('{$id_sesi}', '{$data[0]->id}', '{$data[0]->keterangan}','{$data[0]->id_kehadiran}')";
		for($i=1;$i<count($data);$i++){
			$sql = $sql . ",('{$id_sesi}', '{$data[$i]->id}', '{$data[$i]->keterangan}','{$data[$i]->id_kehadiran}')";
		}
		//echo $sql;
		$hasil = mysqli_query($con,$sql);	
	}else{
		$sql ="INSERT INTO riwayat_latihan (id_sesi, id_player, keterangan, id_kehadiran)
	VALUES ('{$id_sesi}', '{$data[0]->id}', '{$data[0]->keterangan}','{$data[0]->id_kehadiran}')";
		$hasil = mysqli_query($con,$sql);
	}
if ($hasil) {
	
	//print_r($semua);
   $response['success'] = 1;
   
   $json = json_encode($response);
   print_r($json);
   

} else {
	$response['success'] = '0';
 
}

?>