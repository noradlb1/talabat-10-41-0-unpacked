package com.talabat.impressions;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.impressions.ImpressionsItem;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ls.c;
import ls.d;
import ls.e;
import ls.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BY\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t\u0012$\u0010\n\u001a \u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00000\f0\u0007\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\u0002\u0010\u000fJ\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\rH\u0002J\u0018\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020\rH\u0002J\u0012\u0010&\u001a\u00020\u000e2\b\u0010'\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\rH\u0002J\u0018\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020,2\u0006\u0010\"\u001a\u00020\rH\u0002J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\rH\u0002J\u001a\u0010.\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\r2\b\u0010/\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u00100\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\rH\u0002J\b\u00101\u001a\u00020\u000eH\u0016J\b\u00102\u001a\u00020\u000eH\u0016R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R*\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00140\u0013j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0014`\u0015X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0017X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R2\u0010\n\u001a \u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00000\f0\u0007\u0012\u0004\u0012\u00020\u000e0\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\r0\u001fj\b\u0012\u0004\u0012\u00020\r` X\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/talabat/impressions/RecyclerViewImpressionTracker;", "T", "Lcom/talabat/impressions/ImpressionsItem;", "Lcom/talabat/impressions/ImpressionTracker;", "mainRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "gems", "", "impressionRecordable", "Lcom/talabat/impressions/ImpressionRecordable;", "onReachLimit", "Lkotlin/Function1;", "Lkotlin/Pair;", "", "", "(Landroidx/recyclerview/widget/RecyclerView;Ljava/util/List;Lcom/talabat/impressions/ImpressionRecordable;Lkotlin/jvm/functions/Function1;)V", "firstTrackFlag", "", "hashMap", "Ljava/util/HashMap;", "Lio/reactivex/disposables/Disposable;", "Lkotlin/collections/HashMap;", "layoutListener", "Lkotlin/Function0;", "getOnReachLimit", "()Lkotlin/jvm/functions/Function1;", "onScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "timer", "Ljava/util/Timer;", "viewsViewed", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "addViewsViewed", "viewPosition", "analyseAndAddViewData", "firstVisibleItemPosition", "lastVisibleItemPosition", "analyseView", "recyclerView", "clearViewViewed", "position", "onError", "throwable", "", "onStartTimer", "onStopTimer", "disposable", "onSuccess", "startTracking", "stopTracking", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RecyclerViewImpressionTracker<T extends ImpressionsItem> implements ImpressionTracker<T> {
    /* access modifiers changed from: private */
    public boolean firstTrackFlag;
    @Nullable
    private List<? extends T> gems;
    @NotNull
    private final HashMap<Integer, Disposable> hashMap;
    @Nullable
    private ImpressionRecordable<T> impressionRecordable;
    @NotNull
    private final Function0<Unit> layoutListener;
    /* access modifiers changed from: private */
    @Nullable
    public RecyclerView mainRecyclerView;
    @NotNull
    private final Function1<List<? extends Pair<Integer, ? extends T>>, Unit> onReachLimit;
    @NotNull
    private final RecyclerView.OnScrollListener onScrollListener;
    /* access modifiers changed from: private */
    @Nullable
    public Timer timer;
    /* access modifiers changed from: private */
    @NotNull
    public final ArrayList<Integer> viewsViewed;

    public RecyclerViewImpressionTracker(@Nullable RecyclerView recyclerView, @Nullable List<? extends T> list, @Nullable ImpressionRecordable<T> impressionRecordable2, @NotNull Function1<? super List<? extends Pair<Integer, ? extends T>>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onReachLimit");
        this.mainRecyclerView = recyclerView;
        this.gems = list;
        this.impressionRecordable = impressionRecordable2;
        this.onReachLimit = function1;
        this.viewsViewed = new ArrayList<>();
        this.hashMap = new HashMap<>();
        this.layoutListener = new RecyclerViewImpressionTracker$layoutListener$1(this);
        this.onScrollListener = new RecyclerViewImpressionTracker$onScrollListener$1(this);
    }

    private final void addViewsViewed(int i11) {
        this.viewsViewed.add(Integer.valueOf(i11));
        this.hashMap.put(Integer.valueOf(i11), onStartTimer(i11));
    }

    private final void analyseAndAddViewData(int i11, int i12) {
        if (i11 != -1 && i11 <= i12) {
            while (true) {
                addViewsViewed(i11);
                if (i11 != i12) {
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void analyseView(RecyclerView recyclerView) {
        Pair<Integer, Integer> firstAndLastViewedPosition = ImpressionTrackerKt.getFirstAndLastViewedPosition(recyclerView);
        analyseAndAddViewData(firstAndLastViewedPosition.component1().intValue(), firstAndLastViewedPosition.component2().intValue());
    }

    /* access modifiers changed from: private */
    public final void clearViewViewed(int i11) {
        this.viewsViewed.remove(Integer.valueOf(i11));
        onStopTimer(i11, this.hashMap.get(Integer.valueOf(i11)));
    }

    private final void onError(Throwable th2, int i11) {
    }

    private final Disposable onStartTimer(int i11) {
        Disposable subscribe = Observable.timer(300, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, i11), new d(this, i11));
        Intrinsics.checkNotNullExpressionValue(subscribe, "timer(ITEM_VIEWED_TIME_L…wPosition)\n            })");
        return subscribe;
    }

    /* access modifiers changed from: private */
    /* renamed from: onStartTimer$lambda-1  reason: not valid java name */
    public static final void m10661onStartTimer$lambda1(RecyclerViewImpressionTracker recyclerViewImpressionTracker, int i11, Long l11) {
        Intrinsics.checkNotNullParameter(recyclerViewImpressionTracker, "this$0");
        recyclerViewImpressionTracker.onSuccess(i11);
    }

    /* access modifiers changed from: private */
    /* renamed from: onStartTimer$lambda-2  reason: not valid java name */
    public static final void m10662onStartTimer$lambda2(RecyclerViewImpressionTracker recyclerViewImpressionTracker, int i11, Throwable th2) {
        Intrinsics.checkNotNullParameter(recyclerViewImpressionTracker, "this$0");
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        recyclerViewImpressionTracker.onError(th2, i11);
    }

    private final void onStopTimer(int i11, Disposable disposable) {
        if (disposable != null) {
            disposable.dispose();
        }
    }

    private final void onSuccess(int i11) {
        ImpressionsItem impressionsItem;
        ImpressionRecordable<T> impressionRecordable2;
        List<? extends T> list = this.gems;
        if (list != null && (impressionsItem = (ImpressionsItem) list.get(i11)) != null && (impressionRecordable2 = this.impressionRecordable) != null) {
            impressionRecordable2.addScrollSet(impressionsItem, i11);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startTracking$lambda-0  reason: not valid java name */
    public static final void m10663startTracking$lambda0(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }

    /* access modifiers changed from: private */
    /* renamed from: stopTracking$lambda-4  reason: not valid java name */
    public static final void m10664stopTracking$lambda4(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        function0.invoke();
    }

    @NotNull
    public Function1<List<? extends Pair<Integer, ? extends T>>, Unit> getOnReachLimit() {
        return this.onReachLimit;
    }

    public void startTracking() {
        ViewTreeObserver viewTreeObserver;
        if (this.timer == null) {
            RecyclerView recyclerView = this.mainRecyclerView;
            if (!(recyclerView == null || (viewTreeObserver = recyclerView.getViewTreeObserver()) == null)) {
                viewTreeObserver.addOnGlobalLayoutListener(new f(this.layoutListener));
            }
            RecyclerView recyclerView2 = this.mainRecyclerView;
            if (recyclerView2 != null) {
                recyclerView2.addOnScrollListener(this.onScrollListener);
            }
        }
    }

    public void stopTracking() {
        ViewTreeObserver viewTreeObserver;
        ImpressionRecordable<T> impressionRecordable2 = this.impressionRecordable;
        if (impressionRecordable2 != null) {
            impressionRecordable2.sendRecordedData();
        }
        RecyclerView recyclerView = this.mainRecyclerView;
        if (!(recyclerView == null || (viewTreeObserver = recyclerView.getViewTreeObserver()) == null)) {
            viewTreeObserver.removeOnGlobalLayoutListener(new e(this.layoutListener));
        }
        RecyclerView recyclerView2 = this.mainRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.removeOnScrollListener(this.onScrollListener);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RecyclerViewImpressionTracker(androidx.recyclerview.widget.RecyclerView r7, java.util.List r8, com.talabat.impressions.ImpressionRecordable r9, final kotlin.jvm.functions.Function1 r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r6 = this;
            r12 = r11 & 2
            if (r12 == 0) goto L_0x0005
            r8 = 0
        L_0x0005:
            r11 = r11 & 4
            if (r11 == 0) goto L_0x0020
            com.talabat.impressions.ImpressionRecordable r9 = new com.talabat.impressions.ImpressionRecordable
            r1 = 0
            if (r8 == 0) goto L_0x0013
            int r11 = r8.size()
            goto L_0x0014
        L_0x0013:
            r11 = 0
        L_0x0014:
            r2 = r11
            com.talabat.impressions.RecyclerViewImpressionTracker$1 r3 = new com.talabat.impressions.RecyclerViewImpressionTracker$1
            r3.<init>(r10)
            r4 = 1
            r5 = 0
            r0 = r9
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x0020:
            r6.<init>(r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.impressions.RecyclerViewImpressionTracker.<init>(androidx.recyclerview.widget.RecyclerView, java.util.List, com.talabat.impressions.ImpressionRecordable, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
