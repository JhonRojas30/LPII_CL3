package com.bd.basico.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bd.basico.modelo.TblProductocl3;
import com.bd.basico.repositorio.IProductoRepositorio;

@Service
public class ClassProductoImp implements IProductoServicio{

	//APLICAMOS LA INYECCION DE DEPENDENCIA
		@Autowired
		private IProductoRepositorio iproductorepository;	

	
	@Override
	public List<TblProductocl3> ListadoProductos() {
		// TODO Auto-generated method stub
		// DEVUELVE LISTADO
				return (List<TblProductocl3>)iproductorepository.findAll();
	}

	@Override
	public void RegistrarProducto(TblProductocl3 producto) {
		// REGISTRAR LOS DATOS
		iproductorepository.save(producto);
	}

	@Override
	public TblProductocl3 BuscarporId(Integer id) {
		// BUSCAR POR CODIGO, SI NO ENCUENTRA DEVUELVE NULO...
		return iproductorepository.findById(id).orElse(null);
	}

	@Override
	public void Eliminar(Integer id) {
		// ELIMINAR POR CODIGO
	iproductorepository.deleteById(id);	
	}

}
