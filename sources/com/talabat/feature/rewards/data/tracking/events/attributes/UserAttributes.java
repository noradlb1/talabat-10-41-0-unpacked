package com.talabat.feature.rewards.data.tracking.events.attributes;

import com.talabat.feature.rewards.data.tracking.events.attributes.TrackingAttributes;
import com.talabat.helpers.LoggedInHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tracking.gtm.TalabatGTM;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/feature/rewards/data/tracking/events/attributes/UserAttributes;", "Lcom/talabat/feature/rewards/data/tracking/events/attributes/TrackingAttributes;", "talabatGTM", "Ltracking/gtm/TalabatGTM$Companion;", "(Ltracking/gtm/TalabatGTM$Companion;)V", "getAttributes", "", "", "", "com_talabat_feature_rewards_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserAttributes implements TrackingAttributes {
    @NotNull
    private final TalabatGTM.Companion talabatGTM;

    public UserAttributes() {
        this((TalabatGTM.Companion) null, 1, (DefaultConstructorMarker) null);
    }

    public UserAttributes(@NotNull TalabatGTM.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "talabatGTM");
        this.talabatGTM = companion;
    }

    @NotNull
    public Map<String, Object> getAttributes() {
        String str;
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("userId", this.talabatGTM.getUserId());
        pairArr[1] = TuplesKt.to("userTimeStamp", this.talabatGTM.getCurrentTime());
        if (LoggedInHelper.isLoggedIn()) {
            str = "true";
        } else {
            str = "false";
        }
        pairArr[2] = TuplesKt.to("userLoggedIn", str);
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserAttributes(TalabatGTM.Companion companion, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? TalabatGTM.Companion : companion);
    }
}
