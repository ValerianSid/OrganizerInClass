package by.itstep.organizaer.service;

import by.itstep.organizaer.model.dto.ContactsDto;
import by.itstep.organizaer.model.entity.Contacts;
import by.itstep.organizaer.model.entity.User;
import by.itstep.organizaer.model.mapping.ContactsMapper;
import by.itstep.organizaer.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ContactService {

    UserRepository repository;

    ContactsMapper contactsMapper;

    @Transactional
    public Long createUserContact(Long userId, ContactsDto contactsDto) {
        return repository.findById(userId)
                .map(user -> {
                    user.setContacts(contactsMapper.toEntity(contactsDto));
                    return repository.save(user);
                })
                .map(user -> user.getContacts().getId())
                .orElse(null);
    }

    public Contacts createFriendContact(Long friendId, Contacts contacts) {
        return null;
    }
}
