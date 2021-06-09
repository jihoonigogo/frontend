package com.teamproject.service.users;

import com.teamproject.domain.Users.UsersRepository;
import com.teamproject.dto.users.UsersJoinRequestDTO;
import com.teamproject.dto.users.UsersListResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersService {
    private final UsersRepository usersRepository;

    @Transactional(readOnly = true)
    public List<UsersListResponseDTO> findAll(){
        return usersRepository.findAll().stream().map(UsersListResponseDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public Long save(UsersJoinRequestDTO requestDTO){
        return usersRepository.save(requestDTO.toEntity()).getUsers_sequence();
    }
}
