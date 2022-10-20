package com.leanmall.microservicios.app.usuarios.services.impl;

import com.leanmall.microservicios.app.usuarios.models.converters.AlumnosConverter;
import com.leanmall.microservicios.app.usuarios.models.dao.IAlumnosDao;
import com.leanmall.microservicios.app.usuarios.models.dto.AlumnosDTO;
import com.leanmall.microservicios.app.usuarios.models.entity.Alumnos;
import com.leanmall.microservicios.app.usuarios.services.IAlumnosServices;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AlumnoServiceImpl implements IAlumnosServices {

    @Autowired
    public IAlumnosDao alumnosDao;

    @Autowired
    public AlumnosConverter alumnosConverter;

    @Override
    @Transactional(readOnly = true)
    public List<AlumnosDTO> findAll() {
        List<AlumnosDTO> alumnosDTOList = new ArrayList<>();
        for (Alumnos alumnos : IteratorUtils.toList(alumnosDao.findAll().iterator())){
            AlumnosDTO alumnosDTO = alumnosConverter.toDTO(alumnos);
            alumnosDTOList.add(alumnosDTO);
        }
        return alumnosDTOList;
    }

    @Override
    @Transactional
    public AlumnosDTO create(AlumnosDTO alumnosDTO) {
        Alumnos alumno = new Alumnos();
        alumno.setId(alumnosDTO.getId());
        alumno.setNombre(alumnosDTO.getNombre());
        alumno.setApellido(alumnosDTO.getApellido());
        alumno.setEmail(alumnosDTO.getEmail());
        alumno.setMaterias(alumnosDTO.getMaterias());
        alumno.setCreateAt(alumnosDTO.getCreateAt());
        return alumnosConverter.toDTO(alumnosDao.save(alumno));
    }

    @Override
    @Transactional(readOnly = true)
    public AlumnosDTO findById(Long id) {
        return alumnosConverter.toDTO(Objects.requireNonNull(alumnosDao.findById(id).orElse(null)));
    }

    @Override
    @Transactional
    public AlumnosDTO update(Long id, AlumnosDTO actualizado) {
        AlumnosDTO alumnosDTO = findById(id);
        if (alumnosDTO != null){
            alumnosDTO.setNombre(actualizado.getNombre());
            alumnosDTO.setApellido(actualizado.getApellido());
            alumnosDTO.setEmail(actualizado.getEmail());
            alumnosDTO.setCreateAt(actualizado.getCreateAt());

            alumnosDao.save(alumnosConverter.toEntity(alumnosDTO));
        }

        return alumnosDTO;
    }

    @Override
    @Transactional
    public void deleted(Long id) {

        alumnosDao.deleteById(id);
    }
}
