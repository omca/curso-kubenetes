package org.aguzman.springcloud.msvc.cursos.repositories;

import org.aguzman.springcloud.msvc.cursos.models.entity.Curso;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Curso, Long> {

    // esta anotaciones para q realice la accion de update, insert, delete (es para q se realice la operacion)
    @Modifying
    @Query("delete from CursoUsuario cu where cu.usuarioId = ?1")
    void eliminarCursoUsuarioPorId(Long id);
}
