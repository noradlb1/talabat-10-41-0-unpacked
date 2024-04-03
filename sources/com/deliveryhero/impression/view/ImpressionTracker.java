package com.deliveryhero.impression.view;

import androidx.compose.runtime.internal.StabilityInferred;
import com.deliveryhero.impression.ImpressionProvider;
import com.deliveryhero.impression.ImpressionRemote;
import com.google.firebase.perf.util.Constants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0012R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/deliveryhero/impression/view/ImpressionTracker;", "", "remote", "Lcom/deliveryhero/impression/ImpressionRemote;", "dataProvider", "Lcom/deliveryhero/impression/ImpressionProvider;", "isEnabled", "Lkotlin/Function0;", "", "callback", "Lcom/deliveryhero/impression/view/ImpressionTrackerCallback;", "parentPosition", "", "(Lcom/deliveryhero/impression/ImpressionRemote;Lcom/deliveryhero/impression/ImpressionProvider;Lkotlin/jvm/functions/Function0;Lcom/deliveryhero/impression/view/ImpressionTrackerCallback;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "tracker", "Lcom/deliveryhero/impression/view/Tracker;", "reCalculate", "", "register", "viewGroup", "Landroid/view/ViewGroup;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "unRegister", "impression-tracking_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ImpressionTracker {
    public static final int $stable = 8;
    @Nullable
    private final ImpressionTrackerCallback callback;
    @NotNull
    private final ImpressionProvider dataProvider;
    @NotNull
    private final Function0<Boolean> isEnabled;
    @Nullable
    private final Integer parentPosition;
    @NotNull
    private final ImpressionRemote remote;
    @Nullable
    private Tracker tracker;

    public ImpressionTracker(@NotNull ImpressionRemote impressionRemote, @NotNull ImpressionProvider impressionProvider, @NotNull Function0<Boolean> function0, @Nullable ImpressionTrackerCallback impressionTrackerCallback, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(impressionRemote, "remote");
        Intrinsics.checkNotNullParameter(impressionProvider, "dataProvider");
        Intrinsics.checkNotNullParameter(function0, Constants.ENABLE_DISABLE);
        this.remote = impressionRemote;
        this.dataProvider = impressionProvider;
        this.isEnabled = function0;
        this.callback = impressionTrackerCallback;
        this.parentPosition = num;
    }

    public final void reCalculate() {
        Tracker tracker2 = this.tracker;
        if (tracker2 != null) {
            tracker2.reCalculate();
        }
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [com.deliveryhero.impression.view.Tracker] */
    /* JADX WARNING: type inference failed for: r1v2, types: [com.deliveryhero.impression.view.viewpager.ViewPagerTracker] */
    /* JADX WARNING: type inference failed for: r1v3, types: [com.deliveryhero.impression.view.recyclerview.RecyclerViewTracker] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void register(@org.jetbrains.annotations.NotNull android.view.ViewGroup r11, @org.jetbrains.annotations.NotNull androidx.lifecycle.LifecycleOwner r12) {
        /*
            r10 = this;
            java.lang.String r0 = "viewGroup"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "lifecycleOwner"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            boolean r0 = r11 instanceof androidx.recyclerview.widget.RecyclerView
            if (r0 == 0) goto L_0x0023
            com.deliveryhero.impression.view.recyclerview.RecyclerViewTracker r0 = new com.deliveryhero.impression.view.recyclerview.RecyclerViewTracker
            com.deliveryhero.impression.view.recyclerview.LinearLayoutVisibleItemDetector r2 = com.deliveryhero.impression.view.recyclerview.LinearLayoutVisibleItemDetector.INSTANCE
            com.deliveryhero.impression.ImpressionRemote r5 = r10.remote
            com.deliveryhero.impression.ImpressionProvider r6 = r10.dataProvider
            com.deliveryhero.impression.view.ImpressionTrackerCallback r7 = r10.callback
            java.lang.Integer r8 = r10.parentPosition
            kotlin.jvm.functions.Function0<java.lang.Boolean> r9 = r10.isEnabled
            r1 = r0
            r3 = r11
            r4 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x003b
        L_0x0023:
            boolean r0 = r11 instanceof androidx.viewpager.widget.ViewPager
            if (r0 == 0) goto L_0x0041
            com.deliveryhero.impression.view.viewpager.ViewPagerTracker r0 = new com.deliveryhero.impression.view.viewpager.ViewPagerTracker
            com.deliveryhero.impression.view.viewpager.ViewPagerVisibleItemsDetector r2 = com.deliveryhero.impression.view.viewpager.ViewPagerVisibleItemsDetector.INSTANCE
            com.deliveryhero.impression.ImpressionRemote r5 = r10.remote
            com.deliveryhero.impression.ImpressionProvider r6 = r10.dataProvider
            com.deliveryhero.impression.view.ImpressionTrackerCallback r7 = r10.callback
            java.lang.Integer r8 = r10.parentPosition
            kotlin.jvm.functions.Function0<java.lang.Boolean> r9 = r10.isEnabled
            r1 = r0
            r3 = r11
            r4 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
        L_0x003b:
            r10.tracker = r0
            r0.register()
            return
        L_0x0041:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.Class r11 = r11.getClass()
            java.lang.String r11 = r11.getName()
            java.lang.String r0 = " is not supported "
            java.lang.String r11 = kotlin.jvm.internal.Intrinsics.stringPlus(r11, r0)
            r12.<init>(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.impression.view.ImpressionTracker.register(android.view.ViewGroup, androidx.lifecycle.LifecycleOwner):void");
    }

    public final void unRegister() {
        Tracker tracker2 = this.tracker;
        if (tracker2 != null) {
            tracker2.unregister();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImpressionTracker(ImpressionRemote impressionRemote, ImpressionProvider impressionProvider, Function0 function0, ImpressionTrackerCallback impressionTrackerCallback, Integer num, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(impressionRemote, impressionProvider, function0, (i11 & 8) != 0 ? null : impressionTrackerCallback, (i11 & 16) != 0 ? null : num);
    }
}
