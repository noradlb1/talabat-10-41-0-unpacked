package com.google.android.gms.ads;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.rewarded.RewardItem;

public interface OnUserEarnedRewardListener {
    void onUserEarnedReward(@RecentlyNonNull RewardItem rewardItem);
}
