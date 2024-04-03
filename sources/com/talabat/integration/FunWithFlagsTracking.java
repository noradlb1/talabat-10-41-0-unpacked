package com.talabat.integration;

import com.talabat.core.fwf.domain.FunWithFlagsTrackingPort;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tracking.gtm.TalabatFirebaseWrapper;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/integration/FunWithFlagsTracking;", "Lcom/talabat/core/fwf/domain/FunWithFlagsTrackingPort;", "talabatFirebaseWrapper", "Ltracking/gtm/TalabatFirebaseWrapper;", "(Ltracking/gtm/TalabatFirebaseWrapper;)V", "track", "", "eventName", "", "attributes", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FunWithFlagsTracking implements FunWithFlagsTrackingPort {
    @NotNull
    private final TalabatFirebaseWrapper talabatFirebaseWrapper;

    public FunWithFlagsTracking() {
        this((TalabatFirebaseWrapper) null, 1, (DefaultConstructorMarker) null);
    }

    public FunWithFlagsTracking(@NotNull TalabatFirebaseWrapper talabatFirebaseWrapper2) {
        Intrinsics.checkNotNullParameter(talabatFirebaseWrapper2, "talabatFirebaseWrapper");
        this.talabatFirebaseWrapper = talabatFirebaseWrapper2;
    }

    public void track(@NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        this.talabatFirebaseWrapper.dispatchEvent(str, map);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FunWithFlagsTracking(TalabatFirebaseWrapper talabatFirebaseWrapper2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new TalabatFirebaseWrapper() : talabatFirebaseWrapper2);
    }
}
