package com.deliveryhero.impression.view.viewpager;

import android.os.SystemClock;
import android.view.ViewGroup;
import androidx.annotation.WorkerThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewpager.widget.ViewPager;
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
import j$.util.Map;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q5.a;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001JB[\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0002\u0010\u0015J\u001e\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b4\u00105J\b\u00106\u001a\u00020\u0014H\u0016J\b\u00107\u001a\u000203H\u0003J\u0010\u00108\u001a\u0002032\u0006\u00109\u001a\u00020\u0011H\u0016J \u0010:\u001a\u0002032\u0006\u0010;\u001a\u00020\u00112\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0011H\u0016J\u0010\u0010?\u001a\u0002032\u0006\u0010;\u001a\u00020\u0011H\u0016J\b\u0010@\u001a\u000203H\u0002J\b\u0010A\u001a\u000203H\u0016J\b\u0010B\u001a\u000203H\u0016J\u0010\u0010C\u001a\u0002032\u0006\u0010;\u001a\u00020\u0011H\u0002J\b\u0010D\u001a\u000203H\u0016J%\u0010E\u001a\u0002032\n\b\u0002\u0010F\u001a\u0004\u0018\u00010G2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010GH\u0002¢\u0006\u0002\u0010IR\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020/0.X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006K"}, d2 = {"Lcom/deliveryhero/impression/view/viewpager/ViewPagerTracker;", "Lcom/deliveryhero/impression/view/Tracker;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "visibleItemDetector", "Lcom/deliveryhero/impression/view/ViewVisibleItemDetector;", "Landroidx/viewpager/widget/ViewPager;", "view", "Landroid/view/ViewGroup;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "remote", "Lcom/deliveryhero/impression/ImpressionRemote;", "dataProvider", "Lcom/deliveryhero/impression/ImpressionProvider;", "impressionTrackerCallback", "Lcom/deliveryhero/impression/view/ImpressionTrackerCallback;", "parentPosition", "", "isEnabled", "Lkotlin/Function0;", "", "(Lcom/deliveryhero/impression/view/ViewVisibleItemDetector;Landroid/view/ViewGroup;Landroidx/lifecycle/LifecycleOwner;Lcom/deliveryhero/impression/ImpressionRemote;Lcom/deliveryhero/impression/ImpressionProvider;Lcom/deliveryhero/impression/view/ImpressionTrackerCallback;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "getDataProvider", "()Lcom/deliveryhero/impression/ImpressionProvider;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getImpressionTrackerCallback", "()Lcom/deliveryhero/impression/view/ImpressionTrackerCallback;", "()Lkotlin/jvm/functions/Function0;", "lifecycleObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "setLifecycleOwner", "(Landroidx/lifecycle/LifecycleOwner;)V", "getParentPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRemote", "()Lcom/deliveryhero/impression/ImpressionRemote;", "getView", "()Landroid/view/ViewGroup;", "viewPager", "viewPagerVisibleState", "Lcom/deliveryhero/impression/view/viewpager/ViewPagerTracker$VisibleState;", "visibleItems", "", "Lcom/deliveryhero/impression/view/viewpager/ViewPagerInfo;", "visiblePos", "handleListItems", "Lkotlin/Result;", "", "handleListItems-d1pmJ48", "()Ljava/lang/Object;", "isRegistered", "onListStateUpdate", "onPageScrollStateChanged", "state", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "processUpdate", "reCalculate", "register", "trackImpression", "unregister", "updateCurrentItemVisibility", "updatedShowTime", "", "updatedHideTime", "(Ljava/lang/Long;Ljava/lang/Long;)V", "VisibleState", "impression-tracking_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ViewPagerTracker implements Tracker, ViewPager.OnPageChangeListener {
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
    @Nullable
    private final Integer parentPosition;
    @NotNull
    private final ImpressionRemote remote;
    @NotNull
    private final ViewGroup view;
    /* access modifiers changed from: private */
    @Nullable
    public ViewPager viewPager;
    @NotNull
    private VisibleState viewPagerVisibleState;
    @NotNull
    private final ViewVisibleItemDetector<ViewPager> visibleItemDetector;
    @NotNull
    private final Map<Integer, ViewPagerInfo> visibleItems;
    private int visiblePos;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/impression/view/viewpager/ViewPagerTracker$VisibleState;", "", "(Ljava/lang/String;I)V", "VISIBLE_ON_SCREEN", "INVISIBLE_ON_SCREEN", "impression-tracking_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum VisibleState {
        VISIBLE_ON_SCREEN,
        INVISIBLE_ON_SCREEN
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
            iArr[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ViewPagerTracker(@NotNull ViewVisibleItemDetector<ViewPager> viewVisibleItemDetector, @NotNull ViewGroup viewGroup, @Nullable LifecycleOwner lifecycleOwner2, @NotNull ImpressionRemote impressionRemote, @NotNull ImpressionProvider impressionProvider, @Nullable ImpressionTrackerCallback impressionTrackerCallback2, @Nullable Integer num, @NotNull Function0<Boolean> function0) {
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
        this.viewPager = (ViewPager) getView();
        this.viewPagerVisibleState = VisibleState.INVISIBLE_ON_SCREEN;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.visibleItems = concurrentHashMap;
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            concurrentHashMap.put(0, new ViewPagerInfo(SystemClock.uptimeMillis(), 0, viewVisibleItemDetector.getVisibleItems(viewPager2).get(0)));
        }
        this.lifecycleObserver = new a(this);
        this.exceptionHandler = new ViewPagerTracker$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, this);
    }

    public static /* synthetic */ void b(ViewPagerTracker viewPagerTracker, Long l11, Long l12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            l11 = null;
        }
        if ((i11 & 2) != 0) {
            l12 = null;
        }
        viewPagerTracker.updateCurrentItemVisibility(l11, l12);
    }

    /* renamed from: handleListItems-d1pmJ48  reason: not valid java name */
    private final Object m8234handleListItemsd1pmJ48() {
        Object obj;
        ImpressionTrackerCallback impressionTrackerCallback2;
        boolean z11;
        try {
            Result.Companion companion = Result.Companion;
            if (isRegistered()) {
                ImpressionTrackerCallback impressionTrackerCallback3 = getImpressionTrackerCallback();
                if (impressionTrackerCallback3 != null) {
                    impressionTrackerCallback3.onImpressionDetectionStarted(this);
                }
                for (Map.Entry next : this.visibleItems.entrySet()) {
                    ImpressionValidationRule impressionValidationRule$default = ImpressionProvider.DefaultImpls.getImpressionValidationRule$default(getDataProvider(), ((Number) next.getKey()).intValue(), (Integer) null, 2, (Object) null);
                    boolean z12 = false;
                    if (impressionValidationRule$default == null) {
                        z11 = false;
                    } else {
                        z11 = impressionValidationRule$default.isVisibilitySufficient(((ViewPagerInfo) next.getValue()).getVisibleArea().getPercent());
                    }
                    if (impressionValidationRule$default != null) {
                        z12 = impressionValidationRule$default.isDurationSufficient(((ViewPagerInfo) next.getValue()).getShowTime(), ((ViewPagerInfo) next.getValue()).getHideTime());
                    }
                    if (z11 && z12 && ImpressionProvider.DefaultImpls.getItemType$default(getDataProvider(), ((Number) next.getKey()).intValue(), (Integer) null, 2, (Object) null) == ImpressionItemType.IMPRESSION_CANDIDATE) {
                        trackImpression(((Number) next.getKey()).intValue());
                        Map<Integer, ViewPagerInfo> map = this.visibleItems;
                        Object key = next.getKey();
                        ViewPagerInfo viewPagerInfo = this.visibleItems.get(next.getKey());
                        if (map != null) {
                            Map.EL.remove(TypeIntrinsics.asMutableMap(map), key, viewPagerInfo);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                        }
                    }
                }
                ImpressionTrackerCallback impressionTrackerCallback4 = getImpressionTrackerCallback();
                if (impressionTrackerCallback4 != null) {
                    impressionTrackerCallback4.onImpressionDetectionFinished(this);
                }
            }
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r12 = Result.m6332exceptionOrNullimpl(obj);
        if (!(r12 == null || (impressionTrackerCallback2 = getImpressionTrackerCallback()) == null)) {
            impressionTrackerCallback2.onError(this, r12);
        }
        return obj;
    }

    /* access modifiers changed from: private */
    /* renamed from: lifecycleObserver$lambda-6  reason: not valid java name */
    public static final void m8235lifecycleObserver$lambda6(ViewPagerTracker viewPagerTracker, LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
        long j11;
        Intrinsics.checkNotNullParameter(viewPagerTracker, "this$0");
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "$noName_0");
        Intrinsics.checkNotNullParameter(event, "event");
        if (viewPagerTracker.viewPager != null) {
            int i11 = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
            if (i11 == 1) {
                b(viewPagerTracker, Long.valueOf(SystemClock.uptimeMillis()), (Long) null, 2, (Object) null);
                viewPagerTracker.processUpdate();
            } else if (i11 == 2) {
                ViewPager viewPager2 = viewPagerTracker.viewPager;
                if (viewPager2 != null) {
                    ViewPagerInfo viewPagerInfo = viewPagerTracker.visibleItems.get(Integer.valueOf(viewPager2.getCurrentItem()));
                    if (viewPagerInfo == null) {
                        j11 = 0;
                    } else {
                        j11 = viewPagerInfo.getHideTime();
                    }
                    if (j11 == 0) {
                        b(viewPagerTracker, (Long) null, Long.valueOf(SystemClock.uptimeMillis()), 1, (Object) null);
                    }
                }
                viewPagerTracker.processUpdate();
            }
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void onListStateUpdate() {
        m8234handleListItemsd1pmJ48();
    }

    private final void processUpdate() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new ViewPagerTracker$processUpdate$1(this, (Continuation<? super ViewPagerTracker$processUpdate$1>) null), 2, (Object) null);
    }

    private final void trackImpression(int i11) {
        Impression impression = getDataProvider().getImpression(i11, getParentPosition());
        if (impression != null) {
            getRemote().send(impression);
        }
    }

    private final void updateCurrentItemVisibility(Long l11, Long l12) {
        List<ItemVisibleArea> list;
        long j11;
        long j12;
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            int currentItem = viewPager2.getCurrentItem();
            ItemVisibleArea itemVisibleArea = null;
            if (l11 != null) {
                list = this.visibleItemDetector.getVisibleItems(viewPager2);
            } else {
                list = null;
            }
            ViewPagerInfo viewPagerInfo = this.visibleItems.get(Integer.valueOf(currentItem));
            if (viewPagerInfo != null) {
                if (l11 == null) {
                    j11 = viewPagerInfo.getShowTime();
                } else {
                    j11 = l11.longValue();
                }
                viewPagerInfo.setShowTime(j11);
                if (l12 == null) {
                    j12 = viewPagerInfo.getHideTime();
                } else {
                    j12 = l12.longValue();
                }
                viewPagerInfo.setHideTime(j12);
                if (list != null) {
                    itemVisibleArea = list.get(0);
                }
                if (itemVisibleArea == null) {
                    itemVisibleArea = viewPagerInfo.getVisibleArea();
                }
                viewPagerInfo.setVisibleArea(itemVisibleArea);
            }
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
        return this.viewPager != null;
    }

    public void onPageScrollStateChanged(int i11) {
    }

    public void onPageScrolled(int i11, float f11, int i12) {
        ViewPagerInfo viewPagerInfo;
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null && Float.compare(f11, 0.0f) == 0) {
            if (this.visibleItems.containsKey(Integer.valueOf(this.visiblePos))) {
                ItemVisibleArea itemVisibleArea = this.visibleItemDetector.getVisibleItems(viewPager2).get(0);
                ViewPagerInfo viewPagerInfo2 = this.visibleItems.get(Integer.valueOf(this.visiblePos));
                if (viewPagerInfo2 != null) {
                    viewPagerInfo2.setHideTime(SystemClock.uptimeMillis());
                }
                int i13 = this.visiblePos;
                if (i13 == 0 && (viewPagerInfo = this.visibleItems.get(Integer.valueOf(i13))) != null) {
                    viewPagerInfo.setVisibleArea(itemVisibleArea);
                }
            }
            this.visiblePos = i11 - 1;
            ItemVisibleArea itemVisibleArea2 = this.visibleItemDetector.getVisibleItems(viewPager2).get(0);
            if (this.visibleItems.containsKey(Integer.valueOf(this.visiblePos))) {
                ViewPagerInfo viewPagerInfo3 = this.visibleItems.get(Integer.valueOf(this.visiblePos));
                if (viewPagerInfo3 != null) {
                    viewPagerInfo3.setShowTime(SystemClock.uptimeMillis());
                    viewPagerInfo3.setVisibleArea(itemVisibleArea2);
                }
            } else {
                this.visibleItems.put(Integer.valueOf(this.visiblePos), new ViewPagerInfo(SystemClock.uptimeMillis(), 0, itemVisibleArea2));
            }
            processUpdate();
        }
    }

    public void onPageSelected(int i11) {
    }

    public void reCalculate() {
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 != null) {
            boolean viewPagerIsVisibleEnough = ViewPagerVisibleItemsDetectorKt.viewPagerIsVisibleEnough(viewPager2, ImpressionProvider.DefaultImpls.getImpressionValidationRule$default(getDataProvider(), viewPager2.getCurrentItem(), (Integer) null, 2, (Object) null));
            VisibleState visibleState = this.viewPagerVisibleState;
            VisibleState visibleState2 = VisibleState.INVISIBLE_ON_SCREEN;
            if (visibleState == visibleState2 && viewPagerIsVisibleEnough) {
                b(this, Long.valueOf(SystemClock.uptimeMillis()), (Long) null, 2, (Object) null);
                this.viewPagerVisibleState = VisibleState.VISIBLE_ON_SCREEN;
            } else if (visibleState == VisibleState.VISIBLE_ON_SCREEN && !viewPagerIsVisibleEnough) {
                b(this, (Long) null, Long.valueOf(SystemClock.uptimeMillis()), 1, (Object) null);
                this.viewPagerVisibleState = visibleState2;
            }
        }
    }

    public void register() {
        LifecycleCoroutineScope lifecycleScope;
        Tracker.DefaultImpls.register(this);
        LifecycleOwner lifecycleOwner2 = getLifecycleOwner();
        if (lifecycleOwner2 != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(lifecycleOwner2)) != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(lifecycleScope, Dispatchers.getMain().plus(this.exceptionHandler), (CoroutineStart) null, new ViewPagerTracker$register$1(this, (Continuation<? super ViewPagerTracker$register$1>) null), 2, (Object) null);
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
            Job unused = BuildersKt__Builders_commonKt.launch$default(lifecycleScope, Dispatchers.getMain().plus(this.exceptionHandler), (CoroutineStart) null, new ViewPagerTracker$unregister$1(this, (Continuation<? super ViewPagerTracker$unregister$1>) null), 2, (Object) null);
        }
        this.visibleItems.clear();
        this.viewPager = null;
        setLifecycleOwner((LifecycleOwner) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewPagerTracker(ViewVisibleItemDetector viewVisibleItemDetector, ViewGroup viewGroup, LifecycleOwner lifecycleOwner2, ImpressionRemote impressionRemote, ImpressionProvider impressionProvider, ImpressionTrackerCallback impressionTrackerCallback2, Integer num, Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewVisibleItemDetector, viewGroup, lifecycleOwner2, impressionRemote, impressionProvider, (i11 & 32) != 0 ? null : impressionTrackerCallback2, (i11 & 64) != 0 ? null : num, function0);
    }
}
