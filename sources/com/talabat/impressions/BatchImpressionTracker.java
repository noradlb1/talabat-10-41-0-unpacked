package com.talabat.impressions;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.impressions.ImpressionsItem;
import java.util.List;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ls.a;
import ls.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003Ba\b\u0007\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012$\u0010\n\u001a \u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\f0\u0007\u0012\u0004\u0012\u00020\r0\u000b\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0002\u0010\u0010J\u0018\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tH\u0002J\u0012\u0010\u001e\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\tH\u0002J\b\u0010#\u001a\u00020\rH\u0016J\b\u0010$\u001a\u00020\rH\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R2\u0010\n\u001a \u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\f0\u0007\u0012\u0004\u0012\u00020\r0\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u001aX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/talabat/impressions/BatchImpressionTracker;", "T", "Lcom/talabat/impressions/ImpressionsItem;", "Lcom/talabat/impressions/ImpressionTracker;", "mainRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "listItems", "", "batchLimit", "", "onReachLimit", "Lkotlin/Function1;", "Lkotlin/Pair;", "", "impressionRecordable", "Lcom/talabat/impressions/ImpressionRecordable;", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;ILkotlin/jvm/functions/Function1;Lcom/talabat/impressions/ImpressionRecordable;)V", "firstTrackFlag", "", "layoutListener", "Lkotlin/Function0;", "getOnReachLimit", "()Lkotlin/jvm/functions/Function1;", "onScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "trackedPosition", "Ljava/util/TreeSet;", "addItemsToTrack", "firstVisibleItemPosition", "lastVisibleItemPosition", "analyseView", "recyclerView", "fillInGaps", "firstInGap", "lastInGap", "startTracking", "stopTracking", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BatchImpressionTracker<T extends ImpressionsItem> implements ImpressionTracker<T> {
    private int batchLimit;
    /* access modifiers changed from: private */
    public boolean firstTrackFlag;
    @NotNull
    private ImpressionRecordable<T> impressionRecordable;
    @NotNull
    private final Function0<Unit> layoutListener;
    @NotNull
    private List<? extends T> listItems;
    /* access modifiers changed from: private */
    @Nullable
    public RecyclerView mainRecyclerView;
    @NotNull
    private final Function1<List<? extends Pair<Integer, ? extends T>>, Unit> onReachLimit;
    @NotNull
    private final RecyclerView.OnScrollListener onScrollListener;
    @NotNull
    private TreeSet<Integer> trackedPosition;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BatchImpressionTracker(@Nullable RecyclerView recyclerView, @NotNull List<? extends T> list, int i11, @NotNull Function1<? super List<? extends Pair<Integer, ? extends T>>, Unit> function1) {
        this(recyclerView, list, i11, function1, (ImpressionRecordable) null, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(list, "listItems");
        Intrinsics.checkNotNullParameter(function1, "onReachLimit");
    }

    @JvmOverloads
    public BatchImpressionTracker(@Nullable RecyclerView recyclerView, @NotNull List<? extends T> list, int i11, @NotNull Function1<? super List<? extends Pair<Integer, ? extends T>>, Unit> function1, @NotNull ImpressionRecordable<T> impressionRecordable2) {
        Intrinsics.checkNotNullParameter(list, "listItems");
        Intrinsics.checkNotNullParameter(function1, "onReachLimit");
        Intrinsics.checkNotNullParameter(impressionRecordable2, "impressionRecordable");
        this.mainRecyclerView = recyclerView;
        this.listItems = list;
        this.batchLimit = i11;
        this.onReachLimit = function1;
        this.impressionRecordable = impressionRecordable2;
        this.trackedPosition = new TreeSet<>();
        this.layoutListener = new BatchImpressionTracker$layoutListener$1(this);
        this.onScrollListener = new BatchImpressionTracker$onScrollListener$1(this);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BatchImpressionTracker(@Nullable RecyclerView recyclerView, @NotNull List<? extends T> list, @NotNull Function1<? super List<? extends Pair<Integer, ? extends T>>, Unit> function1) {
        this(recyclerView, list, 0, function1, (ImpressionRecordable) null, 20, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(list, "listItems");
        Intrinsics.checkNotNullParameter(function1, "onReachLimit");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BatchImpressionTracker(@Nullable RecyclerView recyclerView, @NotNull Function1<? super List<? extends Pair<Integer, ? extends T>>, Unit> function1) {
        this(recyclerView, (List) null, 0, function1, (ImpressionRecordable) null, 22, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(function1, "onReachLimit");
    }

    private final void addItemsToTrack(int i11, int i12) {
        if (i11 != -1 && i12 != -1 && i11 < this.listItems.size()) {
            if (this.firstTrackFlag) {
                i11 = i12;
            }
            if (!this.trackedPosition.isEmpty()) {
                Integer last = this.trackedPosition.last();
                Intrinsics.checkNotNullExpressionValue(last, "trackedPosition.last()");
                if (i11 - last.intValue() > 1) {
                    Integer last2 = this.trackedPosition.last();
                    Intrinsics.checkNotNullExpressionValue(last2, "trackedPosition.last()");
                    fillInGaps(last2.intValue(), i11);
                }
            }
            int i13 = 0;
            while (i13 < this.batchLimit) {
                ImpressionsItem impressionsItem = (ImpressionsItem) CollectionsKt___CollectionsKt.getOrNull(this.listItems, i11);
                if (!(impressionsItem == null || impressionsItem.getId() == null)) {
                    this.impressionRecordable.addScrollSet(impressionsItem, i11);
                    i13++;
                }
                this.trackedPosition.add(Integer.valueOf(i11));
                i11++;
                if (i11 >= this.listItems.size()) {
                    this.impressionRecordable.sendRecordedDataAndUpdateSets();
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void analyseView(RecyclerView recyclerView) {
        Pair<Integer, Integer> firstAndLastViewedPosition = ImpressionTrackerKt.getFirstAndLastViewedPosition(recyclerView);
        addItemsToTrack(firstAndLastViewedPosition.component1().intValue(), firstAndLastViewedPosition.component2().intValue());
    }

    private final void fillInGaps(int i11, int i12) {
        if (i11 <= i12) {
            while (true) {
                ImpressionsItem impressionsItem = (ImpressionsItem) CollectionsKt___CollectionsKt.getOrNull(this.listItems, i11);
                if (!(impressionsItem == null || impressionsItem.getId() == null)) {
                    this.impressionRecordable.addScrollSet(impressionsItem, i11);
                }
                if (i11 != i12) {
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startTracking$lambda-0  reason: not valid java name */
    public static final void m10659startTracking$lambda0(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: stopTracking$lambda-3  reason: not valid java name */
    public static final void m10660stopTracking$lambda3(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }

    @NotNull
    public Function1<List<? extends Pair<Integer, ? extends T>>, Unit> getOnReachLimit() {
        return this.onReachLimit;
    }

    public void startTracking() {
        ViewTreeObserver viewTreeObserver;
        RecyclerView recyclerView = this.mainRecyclerView;
        if (!(recyclerView == null || (viewTreeObserver = recyclerView.getViewTreeObserver()) == null)) {
            viewTreeObserver.addOnGlobalLayoutListener(new b(this.layoutListener));
        }
        RecyclerView recyclerView2 = this.mainRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.addOnScrollListener(this.onScrollListener);
        }
    }

    public void stopTracking() {
        ViewTreeObserver viewTreeObserver;
        RecyclerView recyclerView = this.mainRecyclerView;
        if (!(recyclerView == null || (viewTreeObserver = recyclerView.getViewTreeObserver()) == null)) {
            viewTreeObserver.removeOnGlobalLayoutListener(new a(this.layoutListener));
        }
        RecyclerView recyclerView2 = this.mainRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(this.onScrollListener);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BatchImpressionTracker(androidx.recyclerview.widget.RecyclerView r7, java.util.List r8, int r9, final kotlin.jvm.functions.Function1 r10, com.talabat.impressions.ImpressionRecordable r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r13 = r12 & 2
            if (r13 == 0) goto L_0x0008
            java.util.List r8 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0008:
            r2 = r8
            r8 = r12 & 4
            if (r8 == 0) goto L_0x000e
            r9 = 5
        L_0x000e:
            r3 = r9
            r8 = r12 & 16
            if (r8 == 0) goto L_0x0021
            com.talabat.impressions.ImpressionRecordable r11 = new com.talabat.impressions.ImpressionRecordable
            int r8 = r2.size()
            com.talabat.impressions.BatchImpressionTracker$1 r9 = new com.talabat.impressions.BatchImpressionTracker$1
            r9.<init>(r10)
            r11.<init>(r3, r8, r9)
        L_0x0021:
            r5 = r11
            r0 = r6
            r1 = r7
            r4 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.impressions.BatchImpressionTracker.<init>(androidx.recyclerview.widget.RecyclerView, java.util.List, int, kotlin.jvm.functions.Function1, com.talabat.impressions.ImpressionRecordable, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
