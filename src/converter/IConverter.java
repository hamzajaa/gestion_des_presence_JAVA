package converter;

import apr.Apr;
import dto.AprDto;

public interface IConverter {

    Apr toEntity(AprDto aprDto);

    AprDto toDto(Apr apr);

}
