package com.bd.basico.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bd.basico.modelo.TblProductocl3;
import com.bd.basico.servicio.IProductoServicio;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/vistas")
public class ProductoController {

	//inyeccion de dependencia...

	@Autowired
	private IProductoServicio iproductoservicio;

	//creamos el metodo listado..

	@GetMapping("ListadoProductos")

	public String ListadoProducto(Model modelo) {

		//recuperamos el listado de autos..

		List<TblProductocl3> listado=iproductoservicio.ListadoProductos();

		for(TblProductocl3 lis:listado) {

	System.out.println("codigo "+lis.getIdproductocl3()+" "+" nombre "+lis.getNombrecl3());

		}

		//enviamos la data hacia la vista..

		modelo.addAttribute("listado",listado);

		//retornamos

		return "/vistas/ListadoProductos";

		

	}  //fin del metodo listado auto...

	

	//creamos los respectivos para metodos para registrar...

	@GetMapping("/RegistrarProducto")

	public String RegistrarProducto(Model modelo) {

		//realizamos la respectiva instancia...

		TblProductocl3 producto=new TblProductocl3();

		//enviamos a la vista...

		modelo.addAttribute("regproducto",producto);

		//retornamos

		return "/vistas/FmrCrearProducto";

	}  //fin del metodo registrar.

	//realizamos el mapeo con postmapping

	@PostMapping("/GuardarProducto")

	public String GuardarProducto(@ModelAttribute TblProductocl3  producto,Model modelo) {

		iproductoservicio.RegistrarProducto(producto);

		System.out.println("dato registrado en la bd");

		//retornamos al listado...

		return "redirect:/vistas/ListadoProductos";	

	}  //fin del metodo string...

	//*****************crearmos el metodo editar...

	@GetMapping("/editar/{id}")

	public String Editar(@PathVariable("id") Integer idproductoscl3,Model modelo) {

		TblProductocl3 producto=iproductoservicio.BuscarporId(idproductoscl3);

		//enviamos hacia la vista...

		modelo.addAttribute("regproducto",producto);

		//retornamos el frmcrearcliente...

		return "/vistas/FmrCrearProducto";	

	}  //fin del metodo editar...
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable("id") Integer idproductoscl3,Model modelo) {

		//aplicamos inyeccion de dependencia...

		iproductoservicio.Eliminar(idproductoscl3);

		//actulizar el listado

		List<TblProductocl3> listado=iproductoservicio.ListadoProductos();

		//enviamos a la vista

		modelo.addAttribute("listado",listado);

		//redireccionamos

		return "redirect:/vistas/ListadoProductos";		

	}   //fin del metodo eliminar...
	
}
