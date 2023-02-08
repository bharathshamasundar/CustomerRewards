package com.customerRewards.rewards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RewardsUtil {

    public static List<Rewards> getTotalRewardsForTesting(){
        List<Rewards> rewardsList = new ArrayList<>();
        Rewards rewards = new Rewards();

        rewards.setEmail("bharathxyz@gmail.com");
        rewards.setName("Bharath");
        rewards.setTotalRewardPoints(50L);

        rewardsList.add(rewards);

        return rewardsList;

    }

    public static RewardsMonthly getMonthlyRewardsForTesting(){
        RewardsMonthly rewardsMonthly = new RewardsMonthly();
        HashMap<String,Long> rewardsMap = new HashMap<>();

        rewardsMonthly.setEmail("bharathxyz@gmail.com");
        rewardsMonthly.setName("Bharath");

        rewardsMap.put("MAY",50L);
        rewardsMap.put("JUNE",50L);
        rewardsMap.put("JULY",50L);

        rewardsMonthly.setRewardsMap(rewardsMap);

        return rewardsMonthly;
    }
}
