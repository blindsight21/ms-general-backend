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
import pe.gob.mimp.general.bean.entidades.DepartamentoBean;
import pe.gob.mimp.general.bean.entidades.ProvinciaBean;
import pe.gob.mimp.general.service.ProvinciaService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/provincia")
public class ProvinciaController {

    @Autowired
    private ProvinciaService provinciaService;

    @GetMapping(value = "/obtenerActivos")
    public ResponseEntity<ResponseData<?>> obtenerActivos() throws Exception {

        List<ProvinciaBean> provinciaBeanList = provinciaService.obtenerActivos();

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(provinciaBeanList);

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ResponseData<?>> find(@PathVariable("id") BigDecimal id) throws Exception {

        ProvinciaBean provinciaBean = provinciaService.find(id);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(provinciaBean);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/findAllByField", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> findAllByField(@RequestBody FindAllByFieldBean findAllByFieldBean) throws Exception {

        List<ProvinciaBean> provinciaBeanList = provinciaService.findAllByField(findAllByFieldBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(provinciaBeanList);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/obtenerProvincias", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> obtenerProvincias(@RequestBody DepartamentoBean departamentoBean) throws Exception {

        List<ProvinciaBean> provinciaBeanList = provinciaService.obtenerProvincias(departamentoBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(provinciaBeanList);

        return ResponseEntity.ok(response);

    }

}
