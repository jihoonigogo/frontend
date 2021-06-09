package com.teamproject.dto.freeboard;

import com.teamproject.domain.freeboard.FreeBoard;
import lombok.Getter;

import java.util.Date;

@Getter
public class FreeBoardResponseDTO {
    private Long free_board_sequence;
    private Date register_date;
    private String title;
    private String content;
    private int hit;
    private String category;
    private String file;
    private int good;
    private int bad;


    public FreeBoardResponseDTO(FreeBoard entity){
        this.free_board_sequence=entity.getFree_board_sequence();
        this.register_date=entity.getRegister_date();
        this.title=entity.getTitle();
        this.content=entity.getContent();
        this.hit=entity.getHit();
        this.category=entity.getCategory();
        this.file = entity.getFile();
        this.good = entity.getGood();
        this.bad = entity.getBad();
    }
}
