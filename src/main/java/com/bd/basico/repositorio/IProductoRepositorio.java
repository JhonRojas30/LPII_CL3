package com.bd.basico.repositorio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.bd.basico.modelo.TblProductocl3;

@Repository
public interface IProductoRepositorio extends CrudRepository<TblProductocl3,Integer> {

}
