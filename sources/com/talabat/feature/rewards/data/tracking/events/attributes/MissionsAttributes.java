package com.talabat.feature.rewards.data.tracking.events.attributes;

import com.talabat.feature.rewards.data.tracking.events.attributes.TrackingAttributes;
import com.talabat.feature.rewards.domain.model.Mission;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0016J(\u0010\n\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/rewards/data/tracking/events/attributes/MissionsAttributes;", "Lcom/talabat/feature/rewards/data/tracking/events/attributes/TrackingAttributes;", "missions", "", "Lcom/talabat/feature/rewards/domain/model/Mission;", "(Ljava/util/List;)V", "getAttributes", "", "", "", "joinToString", "transform", "Lkotlin/Function1;", "", "com_talabat_feature_rewards_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MissionsAttributes implements TrackingAttributes {
    @NotNull
    private final List<Mission> missions;

    public MissionsAttributes(@NotNull List<Mission> list) {
        Intrinsics.checkNotNullParameter(list, "missions");
        this.missions = list;
    }

    private final String joinToString(List<Mission> list, Function1<? super Mission, Integer> function1) {
        return CollectionsKt___CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new MissionsAttributes$joinToString$1(this, function1), 30, (Object) null);
    }

    @NotNull
    public Map<String, Object> getAttributes() {
        return MapsKt__MapsKt.mapOf(TuplesKt.to("missionIds", joinToString(this.missions, MissionsAttributes$getAttributes$1.INSTANCE)), TuplesKt.to("missionStatusIds", joinToString(this.missions, MissionsAttributes$getAttributes$2.INSTANCE)));
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
