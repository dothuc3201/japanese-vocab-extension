package com.thucdozz.japaneseVocabExtension.mapper;

import org.mapstruct.Mapper;

import com.thucdozz.japaneseVocabExtension.dto.request.UserCreationRequest;
import com.thucdozz.japaneseVocabExtension.entities.User;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    User toUser(UserCreationRequest request);
}
