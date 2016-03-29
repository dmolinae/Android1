<?php
  $nombre=$_REQUEST["nombre"];
  $apellido=$_REQUEST["apellido"];
  $edad=$_REQUEST["edad"];
  $modo = $_REQUEST["modo"];
   if ($nombre!="" || $apellido!="" || $edad!=""){
     $con = mysql_connect("localhost","root","") or die("Sin conexion");
	 mysql_select_db("mybase");
    echo $sql="insert into personas(nombre, apellido, edad, modo) 
	     values('$nombre','$apellido',$edad, '$modo')";
	 $result=mysql_query($sql,$con);
	 echo $result;
  }else{
     echo "-1";
   }
?>