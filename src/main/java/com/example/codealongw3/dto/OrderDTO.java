package com.example.codealongw3.dto;
import com.example.codealongw3.models.CustomUser;
import com.example.codealongw3.models.Game;

import java.time.LocalDateTime;
import java.util.List;
public class OrderDTO {

    public List<Long> game_ids;

    public String user_email;

    public OrderDTO(List<Long> game_ids, String user_email) {
        this.game_ids = game_ids;
        this.user_email = user_email;
    }


}
