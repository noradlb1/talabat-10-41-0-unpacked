package com.talabat.impressiontracking;

import com.deliveryhero.impression.view.ImpressionTracker;
import com.deliveryhero.impression.view.ImpressionTrackerCallback;
import com.google.firebase.perf.util.Constants;
import com.talabat.core.tracking.domain.TalabatTracker;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f¨\u0006\u0010"}, d2 = {"Lcom/talabat/impressiontracking/Provider;", "", "()V", "getImpressionTracker", "Lcom/deliveryhero/impression/view/ImpressionTracker;", "talabatImpressionRemote", "Lcom/talabat/impressiontracking/TalabatImpressionRemote;", "provider", "Lcom/talabat/impressiontracking/TalabatImpressionProvider;", "isEnabled", "Lkotlin/Function0;", "", "getTalabatImpressionProvider", "getTalabatImpressionRemote", "tracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "com_talabat_ThirdPartyLibs_ImpressionTracking_ImpressionTracking"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Provider {
    @NotNull
    public static final Provider INSTANCE = new Provider();

    private Provider() {
    }

    @NotNull
    public final ImpressionTracker getImpressionTracker(@NotNull TalabatImpressionRemote talabatImpressionRemote, @NotNull TalabatImpressionProvider talabatImpressionProvider, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(talabatImpressionRemote, "talabatImpressionRemote");
        Intrinsics.checkNotNullParameter(talabatImpressionProvider, "provider");
        Intrinsics.checkNotNullParameter(function0, Constants.ENABLE_DISABLE);
        return new ImpressionTracker(talabatImpressionRemote, talabatImpressionProvider, function0, (ImpressionTrackerCallback) null, (Integer) null, 24, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final TalabatImpressionProvider getTalabatImpressionProvider() {
        return new TalabatImpressionProvider();
    }

    @NotNull
    public final TalabatImpressionRemote getTalabatImpressionRemote(@NotNull TalabatTracker talabatTracker) {
        Intrinsics.checkNotNullParameter(talabatTracker, "tracker");
        return new TalabatImpressionRemote(talabatTracker);
    }
}
