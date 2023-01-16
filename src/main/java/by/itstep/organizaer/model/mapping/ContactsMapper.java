package by.itstep.organizaer.model.mapping;


import by.itstep.organizaer.model.dto.ContactsDto;
import by.itstep.organizaer.model.entity.Contacts;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContactsMapper {

    ContactsDto toDto(Contacts contacts);

    Contacts toEntity(ContactsDto contactsDto);
}
