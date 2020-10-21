/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.general.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.mimp.general.bean.ResponseData;
import pe.gob.mimp.general.bean.entidades.DepartamentoBean;
import pe.gob.mimp.general.bean.entidades.DepartamentoCoordenadasBean;
import pe.gob.mimp.general.service.DepartamentoCoordenadasService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/departamentocoordenadas")
public class DepartamentoCoordenadasController {

    @Autowired
    private DepartamentoCoordenadasService departamentoCoordenadasService;

    @PostMapping(value = "/obtenerCoordenadas", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> obtenerCoordenadas(@RequestBody DepartamentoBean departamentoBean) throws Exception {

        List<DepartamentoCoordenadasBean> departamentoCoordenadasBeanList = departamentoCoordenadasService.obtenerCoordenadas(departamentoBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(departamentoCoordenadasBeanList);

        return ResponseEntity.ok(response);

    }

}
