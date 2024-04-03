package com.talabat.gem.adapters.presentation;

import android.content.Context;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.adapters.presentation.collections.GemCollectionViewHolder;
import com.talabat.gem.adapters.presentation.home.GemSwimlanesViewHolder;
import com.talabat.gem.adapters.presentation.menu.GemMenuFooterView;
import com.talabat.gem.adapters.presentation.restaurants.GemFloatingView;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.usecases.BusinessRulesKt;
import com.talabat.talabatcommon.extentions.BroadcastsKt;
import com.talabat.talabatcommon.lifecycle.ContextLifecycleEventsKt;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.SubscribersKt;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import rq.a;

@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a(\u0010\u0010\u001a\u00020\u00112\u0010\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014H\u0002\u001a\u001a\u0010\u0015\u001a\u00020\u00162\u0010\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u000fH\u0002\u001a\u001a\u0010\u0017\u001a\u00020\u00162\u0010\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u000fH\u0002\u001a6\u0010\u0018\u001a\u00020\u00042\u0016\u0010\u0019\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00070\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014H\u0000\u001a\u0016\u0010\u001d\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014H\u0002\u001a\u0016\u0010\u001e\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0014H\u0002\u001a:\u0010\u001f\u001a\u00020\u0016*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u00072\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020!0\b2\u0012\b\u0002\u0010\"\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u000fH\u0000\u001a\u0014\u0010#\u001a\u00020\u0011*\u00020!2\u0006\u0010$\u001a\u00020%H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\"=\u0010\u0005\u001a$\u0012 \u0012\u001e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b \t*\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0018\u00010\u00070\u00070\u00068BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\"\u0018\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"ACTION_MENU_TO_HOME", "", "ACTION_MENU_TO_RESTAURANTS", "flowTrackerDisposable", "Lio/reactivex/disposables/Disposable;", "gemFlowTracker", "Lio/reactivex/subjects/BehaviorSubject;", "", "Lkotlin/reflect/KClass;", "kotlin.jvm.PlatformType", "getGemFlowTracker", "()Lio/reactivex/subjects/BehaviorSubject;", "gemFlowTracker$delegate", "Lkotlin/Lazy;", "gemViewHolderTypes", "", "handleResetFlow", "", "transaction", "resetFlow", "Lkotlin/Function0;", "isBackToHome", "", "isBackToRestaurantsList", "observeOnFlowTracker", "flowTracker", "Lio/reactivex/Observable;", "scheduler", "Lio/reactivex/Scheduler;", "onBackToHomeScreen", "onBackToRestaurantsList", "isDuplicateViewHolderEntry", "entryType", "", "viewHoldersTypes", "trackWithGemFlow", "context", "Landroid/content/Context;", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemFlowTrackerKt {
    @NotNull
    public static final String ACTION_MENU_TO_HOME = "com.talabat.gem.adapters.ACTION_MENU_TO_HOME";
    @NotNull
    public static final String ACTION_MENU_TO_RESTAURANTS = "com.talabat.gem.adapters.ACTION_MENU_TO_RESTAURANTS";
    @NotNull
    private static final Disposable flowTrackerDisposable;
    @NotNull
    private static final Lazy gemFlowTracker$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, GemFlowTrackerKt$gemFlowTracker$2.INSTANCE);
    @NotNull
    private static final List<KClass<?>> gemViewHolderTypes = CollectionsKt__CollectionsKt.listOf(Reflection.getOrCreateKotlinClass(GemSwimlanesViewHolder.class), Reflection.getOrCreateKotlinClass(GemCollectionViewHolder.class));

    static {
        Observable<List<KClass<?>>> share = getGemFlowTracker().share();
        Intrinsics.checkNotNullExpressionValue(share, "gemFlowTracker.share()");
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        flowTrackerDisposable = observeOnFlowTracker(share, io2, GemFlowTrackerKt$flowTrackerDisposable$1.INSTANCE);
    }

    /* access modifiers changed from: private */
    public static final BehaviorSubject<List<KClass<?>>> getGemFlowTracker() {
        return (BehaviorSubject) gemFlowTracker$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final void handleResetFlow(List<? extends KClass<?>> list, Function0<Unit> function0) {
        if (isBackToRestaurantsList(list)) {
            onBackToRestaurantsList(function0);
        } else if (isBackToHome(list)) {
            onBackToHomeScreen(function0);
        }
    }

    private static final boolean isBackToHome(List<? extends KClass<?>> list) {
        return Intrinsics.areEqual((Object) list.get(0), (Object) Reflection.getOrCreateKotlinClass(GemMenuFooterView.class)) && Intrinsics.areEqual((Object) list.get(1), (Object) Reflection.getOrCreateKotlinClass(GemSwimlanesViewHolder.class));
    }

    private static final boolean isBackToRestaurantsList(List<? extends KClass<?>> list) {
        return Intrinsics.areEqual((Object) list.get(0), (Object) Reflection.getOrCreateKotlinClass(GemMenuFooterView.class)) && Intrinsics.areEqual((Object) list.get(1), (Object) Reflection.getOrCreateKotlinClass(GemFloatingView.class));
    }

    public static final boolean isDuplicateViewHolderEntry(@NotNull List<KClass<?>> list, @NotNull KClass<? extends Object> kClass, @NotNull List<? extends KClass<?>> list2) {
        String str;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "entryType");
        Intrinsics.checkNotNullParameter(list2, "viewHoldersTypes");
        if (list2.contains(kClass)) {
            KClass kClass2 = (KClass) CollectionsKt___CollectionsKt.lastOrNull(list);
            if (kClass2 != null) {
                str = kClass2.getQualifiedName();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual((Object) str, (Object) kClass.getQualifiedName())) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean isDuplicateViewHolderEntry$default(List list, KClass kClass, List<KClass<?>> list2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            list2 = gemViewHolderTypes;
        }
        return isDuplicateViewHolderEntry(list, kClass, list2);
    }

    @NotNull
    public static final Disposable observeOnFlowTracker(@NotNull Observable<List<KClass<?>>> observable, @NotNull Scheduler scheduler, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(observable, "flowTracker");
        Intrinsics.checkNotNullParameter(scheduler, "scheduler");
        Intrinsics.checkNotNullParameter(function0, "resetFlow");
        Observable<List<KClass<?>>> observeOn = observable.filter(new a()).debounce(5, TimeUnit.MILLISECONDS, scheduler).observeOn(scheduler);
        Intrinsics.checkNotNullExpressionValue(observeOn, "flowTracker\n    .filter …    .observeOn(scheduler)");
        return SubscribersKt.subscribeBy$default((Observable) observeOn, (Function1) new GemFlowTrackerKt$observeOnFlowTracker$2(IntegrationKt.getLogger()), (Function0) null, (Function1) new GemFlowTrackerKt$observeOnFlowTracker$3(function0), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: observeOnFlowTracker$lambda-0  reason: not valid java name */
    public static final boolean m10534observeOnFlowTracker$lambda0(List list) {
        Intrinsics.checkNotNullParameter(list, "it");
        if (list.size() >= 2) {
            return true;
        }
        return false;
    }

    private static final void onBackToHomeScreen(Function0<Unit> function0) {
        function0.invoke();
        BroadcastsKt.sendBroadcast(ACTION_MENU_TO_HOME, new Pair[0]);
    }

    private static final void onBackToRestaurantsList(Function0<Unit> function0) {
        GemRestaurant loadSelectedGemRestaurant = IntegrationKt.getDataSources().loadSelectedGemRestaurant();
        if (loadSelectedGemRestaurant == null) {
            loadSelectedGemRestaurant = BusinessRulesKt.getNullGemRestaurant();
        }
        function0.invoke();
        if (!Intrinsics.areEqual((Object) loadSelectedGemRestaurant, (Object) BusinessRulesKt.getNullGemRestaurant()) && IntegrationKt.getDataSources().openedRestaurantIdFromAllEntryPoint() == null) {
            BroadcastsKt.sendBroadcast(ACTION_MENU_TO_RESTAURANTS, new Pair[0]);
        }
    }

    public static final void trackWithGemFlow(@NotNull Object obj, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        ContextLifecycleEventsKt.withLifecycleEvents(context, new GemFlowTrackerKt$trackWithGemFlow$1(obj));
    }
}
