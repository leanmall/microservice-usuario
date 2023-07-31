package com.leanmall.microservicios.app.usuarios.services;

import com.leanmall.microservicios.app.usuarios.models.dto.AlumnosDTO;
import com.leanmall.microservicios.app.usuarios.models.dto.AlumnosRecord;

import java.util.List;

public interface IAlumnosServices {

    List<AlumnosRecord> findAll();

    AlumnosDTO create(AlumnosDTO alumnos);

    AlumnosDTO findById(Long id);

    AlumnosDTO update(Long id, AlumnosDTO alumnos);

    void deleted(Long id);
}
