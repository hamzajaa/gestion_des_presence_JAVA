package converter.impl;

import apr.Apr;
import converter.IConverter;
import dto.AprDto;

public class AprConverter implements IConverter {
    @Override
    public Apr toEntity(AprDto aprDto) {
        Apr apr = new Apr();
        apr.setName(aprDto.getFirstName() + " " + aprDto.getLastName());
        apr.setYearOfBirth(aprDto.getYearOfBirth());
        apr.setType(aprDto.getType());

        return apr;
    }

    @Override
    public AprDto toDto(Apr apr) {
        return null;
    }
}
