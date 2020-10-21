/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.general.ws.rest;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.mimp.general.bean.FindAllByFieldBean;

import pe.gob.mimp.general.bean.ResponseData;
import pe.gob.mimp.general.bean.entidades.DistritoBean;
import pe.gob.mimp.general.bean.entidades.ProvinciaBean;
import pe.gob.mimp.general.service.DistritoService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/distrito")
public class DistritoController {

    @Autowired
    private DistritoService distritoService;

    @GetMapping(value = "/obtenerActivos")
    public ResponseEntity<ResponseData<?>> obtenerActivos() throws Exception {

        List<DistritoBean> distritoBeanList = distritoService.obtenerActivos();

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(distritoBeanList);

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ResponseData<?>> find(@PathVariable("id") BigDecimal id) throws Exception {

        DistritoBean distritoBean = distritoService.find(id);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(distritoBean);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/findAllByField", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> findAllByField(@RequestBody FindAllByFieldBean findAllByFieldBean) throws Exception {

        List<DistritoBean> distritoBeanList = distritoService.findAllByField(findAllByFieldBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(distritoBeanList);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/obtenerDistritos", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> obtenerDistritos(@RequestBody ProvinciaBean provinciaBean) throws Exception {

        List<DistritoBean> distritoBeanList = distritoService.obtenerDistritos(provinciaBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(distritoBeanList);

        return ResponseEntity.ok(response);

    }

}
