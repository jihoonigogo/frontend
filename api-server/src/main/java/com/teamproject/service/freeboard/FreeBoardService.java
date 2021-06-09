package com.teamproject.service.freeboard;

import com.teamproject.domain.freeboard.FreeBoardRepository;
import com.teamproject.dto.freeboard.FreeBoardResponseDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FreeBoardService {

    private final FreeBoardRepository freeBoardRepository;

    @Transactional(readOnly = true)
    public List<FreeBoardResponseDTO> findAll(){
        return freeBoardRepository.findAll().stream().map(FreeBoardResponseDTO::new).collect(Collectors.toList());
    }
}
