package com.talabat.feature.rewards.domain.model;

import com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardFragment;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/rewards/domain/model/MissionOrigin;", "", "screenName", "", "screenType", "screen", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getScreen", "()Ljava/lang/String;", "getScreenName", "getScreenType", "REWARDS", "HOME_OF_FOOD", "T_MART", "com_talabat_feature_rewards_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum MissionOrigin {
    REWARDS(LoyaltyDashboardFragment.GA_SCREEN_NAME, "rewards", "rewards"),
    HOME_OF_FOOD("Restaurant List Screen", "shop_list", "hof"),
    T_MART("Talabat Mart Screen", "t_mart", "tmart");
    
    @NotNull
    private final String screen;
    @NotNull
    private final String screenName;
    @NotNull
    private final String screenType;

    private MissionOrigin(String str, String str2, String str3) {
        this.screenName = str;
        this.screenType = str2;
        this.screen = str3;
    }

    @NotNull
    public final String getScreen() {
        return this.screen;
    }

    @NotNull
    public final String getScreenName() {
        return this.screenName;
    }

    @NotNull
    public final String getScreenType() {
        return this.screenType;
    }
}
