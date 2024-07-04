package com.bd.basico.servicio;

import java.util.List;

import com.bd.basico.modelo.TblProductocl3;

public interface IProductoServicio {

	//declaramos los metodos
		public List<TblProductocl3> ListadoProductos();
		public void RegistrarProducto(TblProductocl3 producto);
		public TblProductocl3 BuscarporId(Integer id);
		public void Eliminar (Integer id);
	
}
