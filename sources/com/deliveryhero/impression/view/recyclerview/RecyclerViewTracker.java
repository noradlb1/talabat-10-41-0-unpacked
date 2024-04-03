package com.deliveryhero.impression.view.recyclerview;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.WorkerThread;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import com.deliveryhero.impression.Impression;
import com.deliveryhero.impression.ImpressionItemType;
import com.deliveryhero.impression.ImpressionProvider;
import com.deliveryhero.impression.ImpressionRemote;
import com.deliveryhero.impression.ImpressionValidationRule;
import com.deliveryhero.impression.view.ImpressionTrackerCallback;
import com.deliveryhero.impression.view.ItemVisibleArea;
import com.deliveryhero.impression.view.Tracker;
import com.deliveryhero.impression.view.ViewVisibleItemDetector;
import com.google.firebase.perf.util.Constants;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p5.a;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\n\u0002\b\u000b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000*\u0002\u0016(\b\u0007\u0018\u00002\u00020\u0001B[\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0002\u0010\u0014J\u0012\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u00020\u0010H\u0002J\u001c\u00107\u001a\u0002082\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002030:H\u0002J\b\u0010;\u001a\u000208H\u0002J\u0016\u0010<\u001a\u0002082\f\u00109\u001a\b\u0012\u0004\u0012\u00020>0=H\u0002J\b\u0010?\u001a\u00020\u0013H\u0016J\u0010\u0010@\u001a\u00020\u00132\u0006\u0010A\u001a\u00020>H\u0002J\u0010\u0010B\u001a\u0002082\u0006\u0010C\u001a\u00020DH\u0003J\u0010\u0010E\u001a\u0002082\u0006\u00106\u001a\u00020\u0010H\u0002J\u0010\u0010F\u001a\u0002082\u0006\u0010A\u001a\u00020>H\u0002J\u0010\u0010G\u001a\u0002082\u0006\u0010C\u001a\u00020DH\u0002J\b\u0010H\u001a\u000208H\u0016J,\u0010I\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002030:2\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00100=2\b\b\u0002\u0010K\u001a\u000203H\u0002J\u0010\u0010L\u001a\u0002082\u0006\u00106\u001a\u00020\u0010H\u0002J\b\u0010M\u001a\u000208H\u0016J\u000e\u0010N\u001a\u0004\u0018\u00010\u0004*\u00020OH\u0002R\u0010\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u001eR\u000e\u0010\u001f\u001a\u00020 X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00000&X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020(X\u0004¢\u0006\u0004\n\u0002\u0010)R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0010\u0010-\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u0002030&X\u0004¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/deliveryhero/impression/view/recyclerview/RecyclerViewTracker;", "Lcom/deliveryhero/impression/view/Tracker;", "visibleItemDetector", "Lcom/deliveryhero/impression/view/ViewVisibleItemDetector;", "Landroidx/recyclerview/widget/RecyclerView;", "view", "Landroid/view/ViewGroup;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "remote", "Lcom/deliveryhero/impression/ImpressionRemote;", "dataProvider", "Lcom/deliveryhero/impression/ImpressionProvider;", "impressionTrackerCallback", "Lcom/deliveryhero/impression/view/ImpressionTrackerCallback;", "parentPosition", "", "isEnabled", "Lkotlin/Function0;", "", "(Lcom/deliveryhero/impression/view/ViewVisibleItemDetector;Landroid/view/ViewGroup;Landroidx/lifecycle/LifecycleOwner;Lcom/deliveryhero/impression/ImpressionRemote;Lcom/deliveryhero/impression/ImpressionProvider;Lcom/deliveryhero/impression/view/ImpressionTrackerCallback;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "dataObserver", "com/deliveryhero/impression/view/recyclerview/RecyclerViewTracker$dataObserver$1", "Lcom/deliveryhero/impression/view/recyclerview/RecyclerViewTracker$dataObserver$1;", "getDataProvider", "()Lcom/deliveryhero/impression/ImpressionProvider;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getImpressionTrackerCallback", "()Lcom/deliveryhero/impression/view/ImpressionTrackerCallback;", "()Lkotlin/jvm/functions/Function0;", "lifecycleObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "nestedTrackers", "", "onScrollListener", "com/deliveryhero/impression/view/recyclerview/RecyclerViewTracker$onScrollListener$1", "Lcom/deliveryhero/impression/view/recyclerview/RecyclerViewTracker$onScrollListener$1;", "getParentPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "recyclerView", "getRemote", "()Lcom/deliveryhero/impression/ImpressionRemote;", "getView", "()Landroid/view/ViewGroup;", "visibleItems", "", "getTrackingValidationRule", "Lcom/deliveryhero/impression/ImpressionValidationRule;", "position", "handleInvisibleItems", "", "items", "", "handleListItems", "handleVisibleItems", "", "Lcom/deliveryhero/impression/view/ItemVisibleArea;", "isRegistered", "isVisibilitySufficient", "item", "onListStateUpdate", "state", "Lcom/deliveryhero/impression/view/Tracker$ListState;", "onNestedListInvisible", "onNestedListVisible", "processUpdate", "register", "replaceVisibleItems", "newVisiblePositions", "time", "trackImpression", "unregister", "findRecyclerView", "Landroid/view/View;", "impression-tracking_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class RecyclerViewTracker implements Tracker {
    public static final int $stable = 8;
    /* access modifiers changed from: private */
    @NotNull
    public final RecyclerViewTracker$dataObserver$1 dataObserver;
    @NotNull
    private final ImpressionProvider dataProvider;
    @NotNull
    private final CoroutineExceptionHandler exceptionHandler;
    @Nullable
    private final ImpressionTrackerCallback impressionTrackerCallback;
    @NotNull
    private final Function0<Boolean> isEnabled;
    /* access modifiers changed from: private */
    @NotNull
    public final LifecycleEventObserver lifecycleObserver;
    @Nullable
    private LifecycleOwner lifecycleOwner;
    /* access modifiers changed from: private */
    @NotNull
    public final Map<Integer, RecyclerViewTracker> nestedTrackers;
    /* access modifiers changed from: private */
    @NotNull
    public final RecyclerViewTracker$onScrollListener$1 onScrollListener;
    @Nullable
    private final Integer parentPosition;
    /* access modifiers changed from: private */
    @Nullable
    public RecyclerView recyclerView;
    @NotNull
    private final ImpressionRemote remote;
    @NotNull
    private final ViewGroup view;
    @NotNull
    private final ViewVisibleItemDetector<RecyclerView> visibleItemDetector;
    @NotNull
    private final Map<Integer, Long> visibleItems;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ImpressionItemType.values().length];
            iArr[ImpressionItemType.IMPRESSION_CANDIDATE.ordinal()] = 1;
            iArr[ImpressionItemType.NESTED_LIST.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Tracker.ListState.values().length];
            iArr2[Tracker.ListState.TO_VISIBLE.ordinal()] = 1;
            iArr2[Tracker.ListState.SCROLL_STOPPED.ordinal()] = 2;
            iArr2[Tracker.ListState.CONTENT_CHANGED.ordinal()] = 3;
            iArr2[Tracker.ListState.TO_INVISIBLE.ordinal()] = 4;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public RecyclerViewTracker(@NotNull ViewVisibleItemDetector<RecyclerView> viewVisibleItemDetector, @NotNull ViewGroup viewGroup, @Nullable LifecycleOwner lifecycleOwner2, @NotNull ImpressionRemote impressionRemote, @NotNull ImpressionProvider impressionProvider, @Nullable ImpressionTrackerCallback impressionTrackerCallback2, @Nullable Integer num, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(viewVisibleItemDetector, "visibleItemDetector");
        Intrinsics.checkNotNullParameter(viewGroup, "view");
        Intrinsics.checkNotNullParameter(impressionRemote, "remote");
        Intrinsics.checkNotNullParameter(impressionProvider, "dataProvider");
        Intrinsics.checkNotNullParameter(function0, Constants.ENABLE_DISABLE);
        this.visibleItemDetector = viewVisibleItemDetector;
        this.view = viewGroup;
        this.lifecycleOwner = lifecycleOwner2;
        this.remote = impressionRemote;
        this.dataProvider = impressionProvider;
        this.impressionTrackerCallback = impressionTrackerCallback2;
        this.parentPosition = num;
        this.isEnabled = function0;
        ViewGroup view2 = getView();
        this.recyclerView = view2 instanceof RecyclerView ? (RecyclerView) view2 : null;
        this.nestedTrackers = new LinkedHashMap();
        this.exceptionHandler = new RecyclerViewTracker$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this);
        this.visibleItems = new ConcurrentHashMap();
        this.lifecycleObserver = new a(this);
        this.dataObserver = new RecyclerViewTracker$dataObserver$1(this);
        this.onScrollListener = new RecyclerViewTracker$onScrollListener$1(this);
    }

    public static /* synthetic */ Map b(RecyclerViewTracker recyclerViewTracker, List list, long j11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = SystemClock.uptimeMillis();
        }
        return recyclerViewTracker.replaceVisibleItems(list, j11);
    }

    private final RecyclerView findRecyclerView(View view2) {
        RecyclerView recyclerView2;
        ViewGroup viewGroup;
        int childCount;
        RecyclerView findRecyclerView;
        if (view2 instanceof RecyclerView) {
            recyclerView2 = (RecyclerView) view2;
        } else {
            recyclerView2 = null;
        }
        if (recyclerView2 != null) {
            return recyclerView2;
        }
        if (view2 instanceof ViewGroup) {
            viewGroup = (ViewGroup) view2;
        } else {
            viewGroup = null;
        }
        if (viewGroup == null || (childCount = viewGroup.getChildCount()) <= 0) {
            return null;
        }
        int i11 = 0;
        while (true) {
            int i12 = i11 + 1;
            View childAt = viewGroup.getChildAt(i11);
            if (childAt instanceof RecyclerView) {
                return (RecyclerView) childAt;
            }
            if ((childAt instanceof ViewGroup) && (findRecyclerView = findRecyclerView(childAt)) != null) {
                return findRecyclerView;
            }
            if (i12 >= childCount) {
                return null;
            }
            i11 = i12;
        }
    }

    private final ImpressionValidationRule getTrackingValidationRule(int i11) {
        return getDataProvider().getImpressionValidationRule(i11, getParentPosition());
    }

    private final void handleInvisibleItems(Map<Integer, Long> map) {
        int i11;
        boolean z11;
        Intrinsics.stringPlus("invisibleItems count is ", Integer.valueOf(map.size()));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            int intValue = ((Number) next.getKey()).intValue();
            long longValue = ((Number) next.getValue()).longValue();
            ImpressionValidationRule trackingValidationRule = getTrackingValidationRule(intValue);
            if (trackingValidationRule == null) {
                z11 = false;
            } else {
                z11 = trackingValidationRule.isDurationSufficient(longValue, SystemClock.uptimeMillis());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Position ");
            sb2.append(intValue);
            sb2.append(" is ");
            sb2.append(z11);
            if (z11) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        for (Map.Entry key : linkedHashMap.entrySet()) {
            int intValue2 = ((Number) key.getKey()).intValue();
            ImpressionItemType itemType = getDataProvider().getItemType(intValue2, getParentPosition());
            if (itemType == null) {
                i11 = -1;
            } else {
                i11 = WhenMappings.$EnumSwitchMapping$0[itemType.ordinal()];
            }
            if (i11 == 1) {
                trackImpression(intValue2);
            } else if (i11 == 2) {
                onNestedListInvisible(intValue2);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void handleListItems() {
        Object obj;
        ArrayList arrayList;
        if (isRegistered()) {
            ImpressionTrackerCallback impressionTrackerCallback2 = getImpressionTrackerCallback();
            if (impressionTrackerCallback2 != null) {
                impressionTrackerCallback2.onImpressionDetectionStarted(this);
            }
            List list = null;
            try {
                Result.Companion companion = Result.Companion;
                RecyclerView recyclerView2 = this.recyclerView;
                if (recyclerView2 == null) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList();
                    for (Object next : this.visibleItemDetector.getVisibleItems(recyclerView2)) {
                        if (isVisibilitySufficient((ItemVisibleArea) next)) {
                            arrayList.add(next);
                        }
                    }
                }
                obj = Result.m6329constructorimpl(arrayList);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable r22 = Result.m6332exceptionOrNullimpl(obj);
            if (r22 != null) {
                ImpressionTrackerCallback impressionTrackerCallback3 = getImpressionTrackerCallback();
                if (impressionTrackerCallback3 != null) {
                    impressionTrackerCallback3.onError(this, r22);
                    return;
                }
                return;
            }
            if (!Result.m6335isFailureimpl(obj)) {
                list = obj;
            }
            List list2 = list;
            if (list2 == null) {
                list2 = CollectionsKt__CollectionsKt.emptyList();
            }
            Iterable<ItemVisibleArea> iterable = list2;
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (ItemVisibleArea position : iterable) {
                arrayList2.add(Integer.valueOf(position.getPosition()));
            }
            Map b11 = b(this, arrayList2, 0, 2, (Object) null);
            handleVisibleItems(list2);
            handleInvisibleItems(b11);
            ImpressionTrackerCallback impressionTrackerCallback4 = getImpressionTrackerCallback();
            if (impressionTrackerCallback4 != null) {
                impressionTrackerCallback4.onImpressionDetectionFinished(this);
            }
        }
    }

    private final void handleVisibleItems(List<ItemVisibleArea> list) {
        for (ItemVisibleArea itemVisibleArea : list) {
            if (getDataProvider().getItemType(itemVisibleArea.getPosition(), getParentPosition()) == ImpressionItemType.NESTED_LIST) {
                onNestedListVisible(itemVisibleArea);
            }
        }
    }

    private final boolean isVisibilitySufficient(ItemVisibleArea itemVisibleArea) {
        ImpressionValidationRule trackingValidationRule = getTrackingValidationRule(itemVisibleArea.getPosition());
        if (trackingValidationRule == null) {
            return false;
        }
        return trackingValidationRule.isVisibilitySufficient(itemVisibleArea.getPercent());
    }

    /* access modifiers changed from: private */
    /* renamed from: lifecycleObserver$lambda-1  reason: not valid java name */
    public static final void m8233lifecycleObserver$lambda1(RecyclerViewTracker recyclerViewTracker, LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(recyclerViewTracker, "this$0");
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "$noName_0");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            recyclerViewTracker.processUpdate(Tracker.ListState.TO_VISIBLE);
        } else if (event == Lifecycle.Event.ON_STOP) {
            recyclerViewTracker.processUpdate(Tracker.ListState.TO_INVISIBLE);
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void onListStateUpdate(Tracker.ListState listState) {
        int i11 = WhenMappings.$EnumSwitchMapping$1[listState.ordinal()];
        if (i11 == 1 || i11 == 2 || i11 == 3) {
            handleListItems();
        } else if (i11 == 4) {
            handleInvisibleItems(this.visibleItems);
        }
    }

    private final void onNestedListInvisible(int i11) {
        RecyclerViewTracker recyclerViewTracker = this.nestedTrackers.get(Integer.valueOf(i11));
        if (recyclerViewTracker != null) {
            recyclerViewTracker.onListStateUpdate(Tracker.ListState.TO_INVISIBLE);
            recyclerViewTracker.unregister();
        }
    }

    private final void onNestedListVisible(ItemVisibleArea itemVisibleArea) {
        RecyclerView recyclerView2;
        View view2 = itemVisibleArea.getView();
        if (view2 == null) {
            recyclerView2 = null;
        } else {
            recyclerView2 = findRecyclerView(view2);
        }
        RecyclerView recyclerView3 = recyclerView2;
        if (recyclerView3 == null) {
            ImpressionTrackerCallback impressionTrackerCallback2 = getImpressionTrackerCallback();
            if (impressionTrackerCallback2 != null) {
                impressionTrackerCallback2.onError(this, new IllegalStateException("View should be instance of RecycleView or contain it"));
                return;
            }
            return;
        }
        Map<Integer, RecyclerViewTracker> map = this.nestedTrackers;
        Integer valueOf = Integer.valueOf(itemVisibleArea.getPosition());
        RecyclerViewTracker recyclerViewTracker = map.get(valueOf);
        if (recyclerViewTracker == null) {
            ImpressionProvider dataProvider2 = getDataProvider();
            int position = itemVisibleArea.getPosition();
            ImpressionRemote remote2 = getRemote();
            recyclerViewTracker = new RecyclerViewTracker(this.visibleItemDetector, recyclerView3, getLifecycleOwner(), remote2, dataProvider2, getImpressionTrackerCallback(), Integer.valueOf(position), isEnabled());
            map.put(valueOf, recyclerViewTracker);
        }
        RecyclerViewTracker recyclerViewTracker2 = recyclerViewTracker;
        recyclerViewTracker2.register();
        recyclerViewTracker2.onListStateUpdate(Tracker.ListState.TO_VISIBLE);
    }

    /* access modifiers changed from: private */
    public final void processUpdate(Tracker.ListState listState) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new RecyclerViewTracker$processUpdate$1(this, listState, (Continuation<? super RecyclerViewTracker$processUpdate$1>) null), 2, (Object) null);
    }

    private final Map<Integer, Long> replaceVisibleItems(List<Integer> list, long j11) {
        Map<Integer, Long> map = this.visibleItems;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            if (!list.contains(Integer.valueOf(((Number) next.getKey()).intValue()))) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        for (Number intValue : linkedHashMap.keySet()) {
            this.visibleItems.remove(Integer.valueOf(intValue.intValue()));
        }
        for (Number intValue2 : list) {
            int intValue3 = intValue2.intValue();
            if (this.visibleItems.get(Integer.valueOf(intValue3)) == null) {
                this.visibleItems.put(Integer.valueOf(intValue3), Long.valueOf(j11));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Position ");
                sb2.append(intValue3);
                sb2.append(" is added");
            }
        }
        return linkedHashMap;
    }

    private final void trackImpression(int i11) {
        Impression impression = getDataProvider().getImpression(i11, getParentPosition());
        if (impression != null) {
            Intrinsics.stringPlus("Sending ", impression.getId());
            getRemote().send(impression);
        }
    }

    @NotNull
    public ImpressionProvider getDataProvider() {
        return this.dataProvider;
    }

    @Nullable
    public ImpressionTrackerCallback getImpressionTrackerCallback() {
        return this.impressionTrackerCallback;
    }

    @Nullable
    public LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    @Nullable
    public Integer getParentPosition() {
        return this.parentPosition;
    }

    @NotNull
    public ImpressionRemote getRemote() {
        return this.remote;
    }

    @NotNull
    public ViewGroup getView() {
        return this.view;
    }

    @NotNull
    public Function0<Boolean> isEnabled() {
        return this.isEnabled;
    }

    public boolean isRegistered() {
        return this.recyclerView != null;
    }

    public void reCalculate() {
        Tracker.DefaultImpls.reCalculate(this);
    }

    public void register() {
        LifecycleCoroutineScope lifecycleScope;
        Tracker.DefaultImpls.register(this);
        LifecycleOwner lifecycleOwner2 = getLifecycleOwner();
        if (lifecycleOwner2 != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner2)) != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(lifecycleScope, Dispatchers.getMain().plus(this.exceptionHandler), (CoroutineStart) null, new RecyclerViewTracker$register$1(this, (Continuation<? super RecyclerViewTracker$register$1>) null), 2, (Object) null);
        }
    }

    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner2) {
        this.lifecycleOwner = lifecycleOwner2;
    }

    public void unregister() {
        LifecycleCoroutineScope lifecycleScope;
        Tracker.DefaultImpls.unregister(this);
        LifecycleOwner lifecycleOwner2 = getLifecycleOwner();
        if (!(lifecycleOwner2 == null || (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner2)) == null)) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(lifecycleScope, Dispatchers.getMain().plus(this.exceptionHandler), (CoroutineStart) null, new RecyclerViewTracker$unregister$1(this, (Continuation<? super RecyclerViewTracker$unregister$1>) null), 2, (Object) null);
        }
        this.recyclerView = null;
        setLifecycleOwner((LifecycleOwner) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RecyclerViewTracker(ViewVisibleItemDetector viewVisibleItemDetector, ViewGroup viewGroup, LifecycleOwner lifecycleOwner2, ImpressionRemote impressionRemote, ImpressionProvider impressionProvider, ImpressionTrackerCallback impressionTrackerCallback2, Integer num, Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewVisibleItemDetector, viewGroup, lifecycleOwner2, impressionRemote, impressionProvider, (i11 & 32) != 0 ? null : impressionTrackerCallback2, (i11 & 64) != 0 ? null : num, function0);
    }
}
