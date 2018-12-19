<?php
include "koneksi.php";

$username = $_GET["username"];
$password = $_GET["password"];

$query = "select * from user where username = '$username' and password = '$password'";

$hasil = mysqli_query($con,$query);
if (mysqli_num_rows($hasil) > 0) {
$response = array();
$response["login"] = array();
while ($data = mysqli_fetch_array($hasil))
{
$h['id'] = $data['id'] ;
$h['username'] = $data['username'] ;
$h['password'] = $data['password'];
 array_push($response["login"], $h);
}
$response["success"] = "1";
echo json_encode($response);
}
else {
 $response["success"] = "0";
 $response["message"] = "Tidak ada data";
echo json_encode($response);
}

?>