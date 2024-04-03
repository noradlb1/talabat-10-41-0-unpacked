package com.talabat.impressiontracking;

import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.deliveryhero.impression.view.ImpressionTracker;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.core.tracking.domain.TalabatTracker;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u000eJ\u0014\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u0017R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/impressiontracking/TalabatImpressionTracker;", "", "tracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "isEnabled", "", "(Lcom/talabat/core/tracking/domain/TalabatTracker;Z)V", "impressionTracker", "Lcom/deliveryhero/impression/view/ImpressionTracker;", "provider", "Lcom/talabat/impressiontracking/TalabatImpressionProvider;", "talabatImpressionRemote", "Lcom/talabat/impressiontracking/TalabatImpressionRemote;", "reCalculate", "", "register", "viewGroup", "Landroid/view/ViewGroup;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "unregister", "updateItems", "items", "", "com_talabat_ThirdPartyLibs_ImpressionTracking_ImpressionTracking"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatImpressionTracker {
    @NotNull
    private final ImpressionTracker impressionTracker;
    @NotNull
    private final TalabatImpressionProvider provider;
    @NotNull
    private final TalabatImpressionRemote talabatImpressionRemote;

    public TalabatImpressionTracker(@NotNull TalabatTracker talabatTracker, boolean z11) {
        Intrinsics.checkNotNullParameter(talabatTracker, "tracker");
        Provider provider2 = Provider.INSTANCE;
        TalabatImpressionProvider talabatImpressionProvider = provider2.getTalabatImpressionProvider();
        this.provider = talabatImpressionProvider;
        TalabatImpressionRemote talabatImpressionRemote2 = provider2.getTalabatImpressionRemote(talabatTracker);
        this.talabatImpressionRemote = talabatImpressionRemote2;
        this.impressionTracker = provider2.getImpressionTracker(talabatImpressionRemote2, talabatImpressionProvider, new TalabatImpressionTracker$impressionTracker$1(z11));
    }

    public final void reCalculate() {
        this.impressionTracker.reCalculate();
    }

    public final void register(@NotNull ViewGroup viewGroup, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.impressionTracker.register(viewGroup, lifecycleOwner);
    }

    public final void unregister() {
        this.impressionTracker.unRegister();
    }

    public final void updateItems(@NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        this.provider.setImpressionItems(list);
    }
}
