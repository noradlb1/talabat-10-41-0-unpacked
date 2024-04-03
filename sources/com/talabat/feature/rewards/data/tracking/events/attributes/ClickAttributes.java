package com.talabat.feature.rewards.data.tracking.events.attributes;

import com.talabat.feature.rewards.data.tracking.events.attributes.TrackingAttributes;
import com.talabat.feature.rewards.domain.model.MissionClickType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/feature/rewards/data/tracking/events/attributes/ClickAttributes;", "Lcom/talabat/feature/rewards/data/tracking/events/attributes/TrackingAttributes;", "clickType", "Lcom/talabat/feature/rewards/domain/model/MissionClickType;", "(Lcom/talabat/feature/rewards/domain/model/MissionClickType;)V", "getAttributes", "", "", "", "com_talabat_feature_rewards_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ClickAttributes implements TrackingAttributes {
    @NotNull
    private final MissionClickType clickType;

    public ClickAttributes(@NotNull MissionClickType missionClickType) {
        Intrinsics.checkNotNullParameter(missionClickType, "clickType");
        this.clickType = missionClickType;
    }

    @NotNull
    public Map<String, Object> getAttributes() {
        return MapsKt__MapsJVMKt.mapOf(TuplesKt.to("clickType", this.clickType.getValue()));
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
