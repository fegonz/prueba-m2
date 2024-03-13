package com.m3.informatica.api.model.services.dtoConversion;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.m3.informatica.api.model.entities.Lenguaje;
import com.m3.informatica.api.model.entities.dto.LenguajeDto;


@Service
public class ConversionServiceDtoImpl implements IConversionServiceDto{
	
	private ModelMapper modelMapper= new ModelMapper();
	private Logger logger = LoggerFactory.getLogger(ConversionServiceDtoImpl.class);
	
	
	@Override
	public LenguajeDto convertToLenguajeDTO(Lenguaje lenguaje) {
	
		
		return this.modelMapper.map(lenguaje, LenguajeDto.class);
		
		
		
		
		
	}

}
