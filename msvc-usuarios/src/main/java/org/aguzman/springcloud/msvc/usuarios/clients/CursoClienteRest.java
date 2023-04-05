package org.aguzman.springcloud.msvc.usuarios.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="msvc-cursos", url = "${msvc.cursos.url}")
// ya no usamos el param de URL, porque el servicio ya esta registrado en un Registre por el discovery de Spring Cloud,
// ahora lo va a encontrar solo por el parametro name
@FeignClient(name="msvc-cursos")
public interface CursoClienteRest {

    @DeleteMapping("/eliminar-curso-usuario-by-usuarioid/{id}")
    void eliminarCursoUsuarioPorId(@PathVariable Long id);

}
