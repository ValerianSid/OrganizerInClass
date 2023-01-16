package by.itstep.organizaer.web;

import by.itstep.organizaer.model.dto.ContactsDto;
import by.itstep.organizaer.model.entity.Contacts;
import by.itstep.organizaer.service.ContactService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ContactsController {

    ContactService contactService;

    @PostMapping("/createUserContact")
    public ResponseEntity<Long> create(@RequestParam Long userId, @RequestBody @Valid ContactsDto contactsDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(contactService.createUserContact(userId, contactsDto));
    }
}
