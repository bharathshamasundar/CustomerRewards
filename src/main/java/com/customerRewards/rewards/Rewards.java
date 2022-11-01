package com.customerRewards.rewards;

import java.util.HashMap;

public class Rewards {

    private String name;

    private String email;

    public Long getTotalRewardPoints() {
        return totalRewardPoints;
    }

    private Long totalRewardPoints;


    public void setName(String name) {
        this.name = name;
    }

    public void setTotalRewardPoints(Long totalRewardPoints) {
        this.totalRewardPoints = totalRewardPoints;
    }


    public void setEmail(String email) {
        this.email = email;
    }

}
