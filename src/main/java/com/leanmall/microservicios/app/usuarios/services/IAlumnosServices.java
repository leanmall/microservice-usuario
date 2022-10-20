package com.leanmall.microservicios.app.usuarios.services;

import com.leanmall.microservicios.app.usuarios.models.dto.AlumnosDTO;

import java.util.List;

public interface IAlumnosServices {

    List<AlumnosDTO> findAll();

    AlumnosDTO create(AlumnosDTO alumnos);

    AlumnosDTO findById(Long id);

    AlumnosDTO update(Long id, AlumnosDTO alumnos);

    void deleted(Long id);
}
