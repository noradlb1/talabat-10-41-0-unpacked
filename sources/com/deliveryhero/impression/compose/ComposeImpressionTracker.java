package com.deliveryhero.impression.compose;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Rect;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.deliveryhero.impression.Impression;
import com.deliveryhero.impression.ImpressionProvider;
import com.deliveryhero.impression.ImpressionRemote;
import com.deliveryhero.impression.ImpressionValidationRule;
import com.google.firebase.perf.util.Constants;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import o5.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tB;\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010\u001f\u001a\u00020\u0015H\u0002J1\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010%\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020\bH\u0002J'\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020#2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0002\u0010*J!\u0010+\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010#H\u0000¢\u0006\u0004\b,\u0010-J?\u0010.\u001a\u00020\u00152\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002022\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010#H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105J\u000e\u00106\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012J)\u00107\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010#2\b\b\u0002\u00108\u001a\u00020\bH\u0002¢\u0006\u0002\u00109J\u0006\u0010:\u001a\u00020\u0015J\u0012\u0010;\u001a\u00020\u00152\b\b\u0002\u0010<\u001a\u00020\u000bH\u0002R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R/\u0010\u0013\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00150\u0007¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"Lcom/deliveryhero/impression/compose/ComposeImpressionTracker;", "", "remote", "Lcom/deliveryhero/impression/ImpressionRemote;", "dataProvider", "Lcom/deliveryhero/impression/ImpressionProvider;", "isEnabled", "Lkotlin/Function0;", "", "(Lcom/deliveryhero/impression/ImpressionRemote;Lcom/deliveryhero/impression/ImpressionProvider;Lkotlin/jvm/functions/Function0;)V", "currentTime", "", "visibleAreaDetector", "Lcom/deliveryhero/impression/compose/VisibleAreaDetector;", "(Lcom/deliveryhero/impression/ImpressionRemote;Lcom/deliveryhero/impression/ImpressionProvider;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lcom/deliveryhero/impression/compose/VisibleAreaDetector;)V", "lifecycleObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "runIfEnabled", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "block", "visibleItems", "Lcom/deliveryhero/impression/compose/TwoDimenMap;", "getVisibleItems", "()Lcom/deliveryhero/impression/compose/TwoDimenMap;", "visibleItems$delegate", "Lkotlin/Lazy;", "checkIfVisibleItemsCanBeTracked", "isDurationSufficient", "timeAdded", "position", "", "parentPosition", "timeRemoved", "(JILjava/lang/Integer;J)Z", "isRegistered", "isVisibilitySufficient", "percent", "(IILjava/lang/Integer;)Z", "onItemDisposed", "onItemDisposed$impression_tracking_release", "(ILjava/lang/Integer;)V", "onItemLayoutCoordinatesChange", "itemSize", "Landroidx/compose/ui/unit/IntSize;", "boundsRect", "Landroidx/compose/ui/geometry/Rect;", "composeViewRect", "onItemLayoutCoordinatesChange-03bzQGs$impression_tracking_release", "(JLandroidx/compose/ui/geometry/Rect;Landroidx/compose/ui/geometry/Rect;ILjava/lang/Integer;)V", "register", "sendImpressionIfDurationSufficient", "removeAfter", "(ILjava/lang/Integer;Z)V", "unregister", "updateStartTimeForVisibleItems", "time", "impression-tracking_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ComposeImpressionTracker {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    @NotNull
    public final Function0<Long> currentTime;
    @NotNull
    private final ImpressionProvider dataProvider;
    /* access modifiers changed from: private */
    @NotNull
    public final Function0<Boolean> isEnabled;
    @NotNull
    private final LifecycleEventObserver lifecycleObserver;
    @Nullable
    private LifecycleOwner lifecycleOwner;
    @NotNull
    private final ImpressionRemote remote;
    @NotNull
    private final Function1<Function0<Unit>, Unit> runIfEnabled;
    /* access modifiers changed from: private */
    @NotNull
    public final VisibleAreaDetector visibleAreaDetector;
    @NotNull
    private final Lazy visibleItems$delegate;

    public ComposeImpressionTracker(@NotNull ImpressionRemote impressionRemote, @NotNull ImpressionProvider impressionProvider, @NotNull Function0<Boolean> function0, @NotNull Function0<Long> function02, @NotNull VisibleAreaDetector visibleAreaDetector2) {
        Intrinsics.checkNotNullParameter(impressionRemote, "remote");
        Intrinsics.checkNotNullParameter(impressionProvider, "dataProvider");
        Intrinsics.checkNotNullParameter(function0, Constants.ENABLE_DISABLE);
        Intrinsics.checkNotNullParameter(function02, "currentTime");
        Intrinsics.checkNotNullParameter(visibleAreaDetector2, "visibleAreaDetector");
        this.remote = impressionRemote;
        this.dataProvider = impressionProvider;
        this.isEnabled = function0;
        this.currentTime = function02;
        this.visibleAreaDetector = visibleAreaDetector2;
        this.lifecycleObserver = new a(this);
        this.runIfEnabled = new ComposeImpressionTracker$runIfEnabled$1(this);
        this.visibleItems$delegate = LazyKt__LazyJVMKt.lazy(ComposeImpressionTracker$visibleItems$2.INSTANCE);
    }

    public static /* synthetic */ boolean b(ComposeImpressionTracker composeImpressionTracker, long j11, int i11, Integer num, long j12, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            j12 = composeImpressionTracker.currentTime.invoke().longValue();
        }
        return composeImpressionTracker.isDurationSufficient(j11, i11, num, j12);
    }

    public static /* synthetic */ void c(ComposeImpressionTracker composeImpressionTracker, int i11, Integer num, boolean z11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            z11 = true;
        }
        composeImpressionTracker.sendImpressionIfDurationSufficient(i11, num, z11);
    }

    /* access modifiers changed from: private */
    public final void checkIfVisibleItemsCanBeTracked() {
        for (Map.Entry next : getVisibleItems().entrySet()) {
            sendImpressionIfDurationSufficient(((Number) ((Pair) next.getKey()).getFirst()).intValue(), (Integer) ((Pair) next.getKey()).getSecond(), false);
        }
    }

    public static /* synthetic */ void d(ComposeImpressionTracker composeImpressionTracker, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = composeImpressionTracker.currentTime.invoke().longValue();
        }
        composeImpressionTracker.updateStartTimeForVisibleItems(j11);
    }

    /* access modifiers changed from: private */
    public final TwoDimenMap<Long> getVisibleItems() {
        return (TwoDimenMap) this.visibleItems$delegate.getValue();
    }

    private final boolean isDurationSufficient(long j11, int i11, Integer num, long j12) {
        ImpressionValidationRule impressionValidationRule = this.dataProvider.getImpressionValidationRule(i11, num);
        if (impressionValidationRule == null) {
            return false;
        }
        return impressionValidationRule.isDurationSufficient(j11, j12);
    }

    private final boolean isRegistered() {
        return this.lifecycleOwner != null;
    }

    /* access modifiers changed from: private */
    public final boolean isVisibilitySufficient(int i11, int i12, Integer num) {
        ImpressionValidationRule impressionValidationRule = this.dataProvider.getImpressionValidationRule(i12, num);
        if (impressionValidationRule == null) {
            return false;
        }
        return impressionValidationRule.isVisibilitySufficient(i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: lifecycleObserver$lambda-0  reason: not valid java name */
    public static final void m8229lifecycleObserver$lambda0(ComposeImpressionTracker composeImpressionTracker, LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(composeImpressionTracker, "this$0");
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "$noName_0");
        Intrinsics.checkNotNullParameter(event, "event");
        composeImpressionTracker.runIfEnabled.invoke(new ComposeImpressionTracker$lifecycleObserver$1$1(event, composeImpressionTracker));
    }

    private final void sendImpressionIfDurationSufficient(int i11, Integer num, boolean z11) {
        Impression impression;
        Long l11 = getVisibleItems().get(i11, num);
        if (l11 != null) {
            if (b(this, l11.longValue(), i11, num, 0, 8, (Object) null) && (impression = this.dataProvider.getImpression(i11, num)) != null) {
                this.remote.send(impression);
            }
            if (z11) {
                getVisibleItems().remove(i11, num);
            }
        }
    }

    private final void updateStartTimeForVisibleItems(long j11) {
        for (Map.Entry<K, V> key : getVisibleItems().entrySet()) {
            Pair pair = (Pair) key.getKey();
            getVisibleItems().set(((Number) pair.component1()).intValue(), (Integer) pair.component2(), Long.valueOf(j11));
        }
    }

    public final void onItemDisposed$impression_tracking_release(int i11, @Nullable Integer num) {
        this.runIfEnabled.invoke(new ComposeImpressionTracker$onItemDisposed$1(this, i11, num));
    }

    /* renamed from: onItemLayoutCoordinatesChange-03bzQGs$impression_tracking_release  reason: not valid java name */
    public final void m8230onItemLayoutCoordinatesChange03bzQGs$impression_tracking_release(long j11, @NotNull Rect rect, @NotNull Rect rect2, int i11, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(rect, "boundsRect");
        Intrinsics.checkNotNullParameter(rect2, "composeViewRect");
        this.runIfEnabled.invoke(new ComposeImpressionTracker$onItemLayoutCoordinatesChange$1(this, j11, rect, rect2, i11, num));
    }

    public final void register(@NotNull LifecycleOwner lifecycleOwner2) {
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "lifecycleOwner");
        if (this.isEnabled.invoke().booleanValue() && !isRegistered()) {
            this.lifecycleOwner = lifecycleOwner2;
            lifecycleOwner2.getLifecycle().addObserver(this.lifecycleObserver);
        }
    }

    public final void unregister() {
        Lifecycle lifecycle;
        if (this.isEnabled.invoke().booleanValue() && isRegistered()) {
            LifecycleOwner lifecycleOwner2 = this.lifecycleOwner;
            if (!(lifecycleOwner2 == null || (lifecycle = lifecycleOwner2.getLifecycle()) == null)) {
                lifecycle.removeObserver(this.lifecycleObserver);
            }
            this.lifecycleOwner = null;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ComposeImpressionTracker(@NotNull ImpressionRemote impressionRemote, @NotNull ImpressionProvider impressionProvider, @NotNull Function0<Boolean> function0) {
        this(impressionRemote, impressionProvider, function0, AnonymousClass1.INSTANCE, DefaultVisibleAreaDetector.INSTANCE);
        Intrinsics.checkNotNullParameter(impressionRemote, "remote");
        Intrinsics.checkNotNullParameter(impressionProvider, "dataProvider");
        Intrinsics.checkNotNullParameter(function0, Constants.ENABLE_DISABLE);
    }
}
