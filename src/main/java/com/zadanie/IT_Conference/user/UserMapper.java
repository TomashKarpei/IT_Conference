package com.zadanie.IT_Conference.user;

import org.mapstruct.Mapping;

public interface UserMapper {

    @Mapping(target="userId", source="entity.id")
    @Mapping(target="userFirstName", source="entity.firstName")
    @Mapping(target="userLastName", source="entity.lastName")
    @Mapping(target="userLogin", source="entity.login")
    @Mapping(target="userEmail", source="entity.email")
    UserDTO userToUserDTO(User entity);

    @Mapping(target="id", source="dto.userId")
    @Mapping(target="firstName", source="dto.userFirstName")
    @Mapping(target="lastName", source="dto.userLastName")
    @Mapping(target="login", source="dto.userLogin")
    @Mapping(target="email", source="dto.userEmail")
    User userDTOtoUser(UserDTO dto);
}
