package com.talabat.feature.rewards.data.tracking.events.attributes;

import JsonModels.PolygonEvents;
import com.talabat.feature.rewards.data.tracking.events.attributes.TrackingAttributes;
import com.talabat.helpers.GlobalDataModel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/rewards/data/tracking/events/attributes/FloodAttributes;", "Lcom/talabat/feature/rewards/data/tracking/events/attributes/TrackingAttributes;", "()V", "getAttributes", "", "", "", "com_talabat_feature_rewards_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FloodAttributes implements TrackingAttributes {
    @NotNull
    public Map<String, Object> getAttributes() {
        Boolean bool;
        String str;
        String str2;
        PolygonEvents polygonEvents = GlobalDataModel.POLYGON_TRACKING.polygonEvents;
        Pair[] pairArr = new Pair[4];
        Integer num = null;
        if (polygonEvents != null) {
            bool = Boolean.valueOf(polygonEvents.isActive);
        } else {
            bool = null;
        }
        pairArr[0] = TuplesKt.to("floodActive", Boolean.valueOf(orFalse(bool)));
        if (polygonEvents != null) {
            str = polygonEvents.eventMsg;
        } else {
            str = null;
        }
        pairArr[1] = TuplesKt.to("floodMessage", orNA(str));
        if (polygonEvents != null) {
            str2 = polygonEvents.eventType;
        } else {
            str2 = null;
        }
        pairArr[2] = TuplesKt.to("floodType", orNA(str2));
        if (polygonEvents != null) {
            num = Integer.valueOf(polygonEvents.eventValue);
        }
        pairArr[3] = TuplesKt.to("floodValue", or0(num));
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
