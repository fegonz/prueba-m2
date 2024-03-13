package com.m3.informatica.api.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.m3.informatica.api.model.entities.Lenguaje;
import com.m3.informatica.api.model.entities.dto.LenguajeDto;
import com.m3.informatica.api.model.services.ILenguajeService;
import com.m3.informatica.api.model.services.dtoConversion.IConversionServiceDto;

@RestController
@RequestMapping("/api/v1")
public class LenguajeController {
	
	@Autowired
	private ILenguajeService lenguajeService;
	@Autowired
	private IConversionServiceDto conversionServiceEntitiesDto;
    
    @GetMapping("/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		Lenguaje lenguaje = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
            lenguaje  = lenguajeService.findById(id);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if(lenguaje  == null) {
			response.put("mensaje", "El lenguaje ID: ".concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		LenguajeDto lenguajeDto = conversionServiceEntitiesDto.convertToLenguajeDTO(lenguaje);
		return new ResponseEntity<LenguajeDto>(lenguajeDto, HttpStatus.OK);
	}


	@PostMapping("/create")
	public ResponseEntity<?> create( @RequestBody Lenguaje lenguaje, BindingResult result) {


		Lenguaje lenguajeNew = null;
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		try {
			lenguajeNew = lenguajeService.save(lenguaje);
		} catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		LenguajeDto lenguajeDto= conversionServiceEntitiesDto.convertToLenguajeDTO(lenguajeNew);
		response.put("mensaje", "El lenguaje ha sido creado con éxito!");
		response.put("lenguaje", lenguajeDto);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	
    @PutMapping("/{id}")
	public ResponseEntity<?> update( @RequestBody Lenguaje lenguaje, BindingResult result, @PathVariable Long id) {
		Lenguaje lenguajeActual = lenguajeService.findById(id);

		Lenguaje lenguajeUpdated = null;

		Map<String, Object> response = new HashMap<>();

		if(result.hasErrors()) {

			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() +"' "+ err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		if (lenguajeActual == null) {
			response.put("mensaje", "Error: no se pudo editar, el lenguaje ID: "
					.concat(id.toString().concat(" no existe en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			lenguajeActual.setNombre(lenguaje.getNombre());
			lenguajeActual.setCodigo(lenguaje.getCodigo());
			lenguajeActual.setCompilado(lenguaje.isCompilado());
			lenguajeActual.setAnioCreacion(lenguaje.getAnioCreacion());
	
            lenguajeUpdated = lenguajeService.save(lenguajeActual);

			

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el lenguaje en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
        LenguajeDto lenguajeDto= conversionServiceEntitiesDto.convertToLenguajeDTO(lenguajeUpdated);

		response.put("mensaje", "El lenguaje ha sido actualizado con éxito!");
		response.put("lenguaje", lenguajeDto);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	


	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			
			Lenguaje lenguajeActual = lenguajeService.findById(id);
			
		
			
			if (lenguajeActual == null) {
				response.put("mensaje", "Error: no se pudo borrar, el lenguaje ID: "
						.concat(id.toString().concat(" no existe en la base de datos!")));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
			lenguajeService.delete(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el lenguaje de la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El lenguaje ha sido eliminado con éxito!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}


}
