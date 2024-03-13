package com.example.codealongw3.dto;
import com.example.codealongw3.models.CustomUser;
import com.example.codealongw3.models.Game;

import java.time.LocalDateTime;
import java.util.List;
public class OrderDTO {

    public List<Long> game_ids;

    public Long user_id;

    public OrderDTO(List<Long> game_ids, Long user_id) {
        this.game_ids = game_ids;
        this.user_id = user_id;
    }


}
