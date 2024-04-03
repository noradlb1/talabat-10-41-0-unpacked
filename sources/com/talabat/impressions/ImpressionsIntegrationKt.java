package com.talabat.impressions;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a\"\u0010\u0006\u001a\u00020\u0007\"\b\b\u0000\u0010\b*\u00020\t*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\u001aJ\u0010\u0006\u001a\u00020\u0007\"\b\b\u0000\u0010\b*\u00020\t*\u00020\n2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u0002H\b\u0018\u00010\r2$\u0010\u000e\u001a \u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002H\b0\u00100\r\u0012\u0004\u0012\u00020\u00070\u000f\u001a\"\u0010\u0012\u001a\u00020\u0007\"\b\b\u0000\u0010\b*\u00020\t*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0014\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u0014\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"impressionTrackerLocal", "Lcom/talabat/impressions/ImpressionTracker;", "impressionTrackerRecyclerView", "lifecycleObserver", "Landroidx/lifecycle/LifecycleObserver;", "recyclerViewLifecycleObserver", "trackImpressions", "", "T", "Lcom/talabat/impressions/ImpressionsItem;", "Landroidx/recyclerview/widget/RecyclerView;", "impressionTracker", "listOfImpression", "", "onReachedLimit", "Lkotlin/Function1;", "Lkotlin/Pair;", "", "trackImpressionsExclusively", "com_talabat_talabatlib_talabatlib"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ImpressionsIntegrationKt {
    /* access modifiers changed from: private */
    @Nullable
    public static ImpressionTracker<?> impressionTrackerLocal;
    /* access modifiers changed from: private */
    @Nullable
    public static ImpressionTracker<?> impressionTrackerRecyclerView;
    @NotNull
    private static final LifecycleObserver lifecycleObserver = new ImpressionsIntegrationLifecycleObserver();
    @NotNull
    private static final LifecycleObserver recyclerViewLifecycleObserver = new RecyclerViewLifecycleObserver();

    public static final <T extends ImpressionsItem> void trackImpressions(@NotNull RecyclerView recyclerView, @Nullable List<? extends T> list, @NotNull Function1<? super List<? extends Pair<Integer, ? extends T>>, Unit> function1) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        Intrinsics.checkNotNullParameter(function1, "onReachedLimit");
        trackImpressions(recyclerView, new RecyclerViewImpressionTracker(recyclerView, list, (ImpressionRecordable) null, function1, 4, (DefaultConstructorMarker) null));
    }

    public static final <T extends ImpressionsItem> void trackImpressionsExclusively(@NotNull RecyclerView recyclerView, @NotNull ImpressionTracker<T> impressionTracker) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        Intrinsics.checkNotNullParameter(impressionTracker, "impressionTracker");
        ImpressionTracker<?> impressionTracker2 = impressionTrackerLocal;
        if (impressionTracker2 != null) {
            impressionTracker2.stopTracking();
        }
        impressionTrackerLocal = impressionTracker;
        Context context = recyclerView.getContext();
        Lifecycle lifecycle = null;
        if (!(context instanceof LifecycleOwner)) {
            context = null;
        }
        if (context != null) {
            lifecycle = ((LifecycleOwner) context).getLifecycle();
        }
        if (lifecycle != null) {
            lifecycle.removeObserver(lifecycleObserver);
        }
        if (lifecycle != null) {
            lifecycle.addObserver(lifecycleObserver);
        }
    }

    public static final <T extends ImpressionsItem> void trackImpressions(@NotNull RecyclerView recyclerView, @NotNull ImpressionTracker<T> impressionTracker) {
        Intrinsics.checkNotNullParameter(recyclerView, "<this>");
        Intrinsics.checkNotNullParameter(impressionTracker, "impressionTracker");
        ImpressionTracker<?> impressionTracker2 = impressionTrackerRecyclerView;
        if (impressionTracker2 != null) {
            impressionTracker2.stopTracking();
        }
        impressionTrackerRecyclerView = impressionTracker;
        Context context = recyclerView.getContext();
        Lifecycle lifecycle = null;
        if (!(context instanceof LifecycleOwner)) {
            context = null;
        }
        if (context != null) {
            lifecycle = ((LifecycleOwner) context).getLifecycle();
        }
        if (lifecycle != null) {
            lifecycle.removeObserver(recyclerViewLifecycleObserver);
        }
        if (lifecycle != null) {
            lifecycle.addObserver(recyclerViewLifecycleObserver);
        }
    }
}
