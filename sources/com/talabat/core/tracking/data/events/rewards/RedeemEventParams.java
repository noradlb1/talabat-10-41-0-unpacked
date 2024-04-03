package com.talabat.core.tracking.data.events.rewards;

import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001\u0011B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/talabat/core/tracking/data/events/rewards/RedeemEventParams;", "", "screenName", "", "points", "title", "screenType", "Lcom/talabat/core/tracking/data/events/rewards/RedeemEventParams$ScreenType;", "offerVoucherId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/core/tracking/data/events/rewards/RedeemEventParams$ScreenType;Ljava/lang/String;)V", "getOfferVoucherId", "()Ljava/lang/String;", "getPoints", "getScreenName", "getScreenType", "()Lcom/talabat/core/tracking/data/events/rewards/RedeemEventParams$ScreenType;", "getTitle", "ScreenType", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemEventParams {
    @NotNull
    private final String offerVoucherId;
    @NotNull
    private final String points;
    @Nullable
    private final String screenName;
    @NotNull
    private final ScreenType screenType;
    @NotNull
    private final String title;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/talabat/core/tracking/data/events/rewards/RedeemEventParams$ScreenType;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "CART", "REWARD", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum ScreenType {
        CART("cart"),
        REWARD("reward");
        
        @NotNull
        private final String type;

        private ScreenType(String str) {
            this.type = str;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }
    }

    public RedeemEventParams(@Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull ScreenType screenType2, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str2, Param.POINTS);
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(screenType2, "screenType");
        Intrinsics.checkNotNullParameter(str4, "offerVoucherId");
        this.screenName = str;
        this.points = str2;
        this.title = str3;
        this.screenType = screenType2;
        this.offerVoucherId = str4;
    }

    @NotNull
    public final String getOfferVoucherId() {
        return this.offerVoucherId;
    }

    @NotNull
    public final String getPoints() {
        return this.points;
    }

    @Nullable
    public final String getScreenName() {
        return this.screenName;
    }

    @NotNull
    public final ScreenType getScreenType() {
        return this.screenType;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
