package com.customerRewards.rewards;

import java.util.HashMap;

public class RewardsMonthly {

    private String name;

    private String email;


    private HashMap<String,Long> rewardsMap;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public HashMap<String, Long> getRewardsMap() {
        return rewardsMap;
    }

    public void setRewardsMap(HashMap<String, Long> rewardsMap) {
        this.rewardsMap = rewardsMap;
    }
}
