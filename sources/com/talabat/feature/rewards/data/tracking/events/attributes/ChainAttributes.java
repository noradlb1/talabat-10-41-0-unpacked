package com.talabat.feature.rewards.data.tracking.events.attributes;

import com.talabat.feature.rewards.data.tracking.events.attributes.TrackingAttributes;
import datamodels.Restaurant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/feature/rewards/data/tracking/events/attributes/ChainAttributes;", "Lcom/talabat/feature/rewards/data/tracking/events/attributes/TrackingAttributes;", "restaurant", "Ldatamodels/Restaurant;", "(Ldatamodels/Restaurant;)V", "getAttributes", "", "", "", "com_talabat_feature_rewards_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChainAttributes implements TrackingAttributes {
    @Nullable
    private final Restaurant restaurant;

    public ChainAttributes(@Nullable Restaurant restaurant2) {
        this.restaurant = restaurant2;
    }

    @NotNull
    public Map<String, Object> getAttributes() {
        Integer num;
        Pair[] pairArr = new Pair[3];
        Restaurant restaurant2 = this.restaurant;
        String str = null;
        if (restaurant2 != null) {
            num = Integer.valueOf(restaurant2.f13872id);
        } else {
            num = null;
        }
        pairArr[0] = TuplesKt.to("chainId", or0(num));
        Restaurant restaurant3 = this.restaurant;
        if (restaurant3 != null) {
            str = restaurant3.f13873name;
        }
        pairArr[1] = TuplesKt.to("chainName", orNA(str));
        pairArr[2] = TuplesKt.to("chainShops", 1);
        return MapsKt__MapsKt.mapOf(pairArr);
    }

    @NotNull
    public Number or0(@Nullable Number number) {
        return TrackingAttributes.DefaultImpls.or0(this, number);
    }

    public boolean orFalse(@Nullable Boolean bool) {
        return TrackingAttributes.DefaultImpls.orFalse(this, bool);
    }

    @NotNull
    public String orNA(@Nullable String str) {
        return TrackingAttributes.DefaultImpls.orNA(this, str);
    }
}
