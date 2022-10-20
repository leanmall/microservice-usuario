package com.leanmall.microservicios.app.usuarios.models.dao;

import com.leanmall.microservicios.app.usuarios.models.entity.Alumnos;
import org.springframework.data.repository.CrudRepository;

public interface IAlumnosDao extends CrudRepository<Alumnos, Long> {
}
