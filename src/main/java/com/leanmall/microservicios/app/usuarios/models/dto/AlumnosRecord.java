package com.leanmall.microservicios.app.usuarios.models.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public record AlumnosRecord(Long id, String nombre,
                            String apellido, String email,
                            List<String> materias, Date createAt) {


}
