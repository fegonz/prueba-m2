package com.m3.informatica.api.model.services.dtoConversion;

import com.m3.informatica.api.model.entities.Lenguaje;
import com.m3.informatica.api.model.entities.dto.LenguajeDto;

public interface IConversionServiceDto {
	public LenguajeDto convertToLenguajeDTO(Lenguaje lenguaje);
}
