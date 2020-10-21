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
import pe.gob.mimp.general.bean.entidades.DistritoBean;
import pe.gob.mimp.general.bean.entidades.DistritoCoordenadasBean;
import pe.gob.mimp.general.service.DistritoCoordenadasService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/distritocoordenadas")
public class DistritoCoordenadasController {

    @Autowired
    private DistritoCoordenadasService distritoCoordenadasService;

    @PostMapping(value = "/obtenerCoordenadas", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> obtenerCoordenadas(@RequestBody DistritoBean distritoBean) throws Exception {

        List<DistritoCoordenadasBean> distritoCoordenadasBeanList = distritoCoordenadasService.obtenerCoordenadas(distritoBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(distritoCoordenadasBeanList);

        return ResponseEntity.ok(response);

    }

}
