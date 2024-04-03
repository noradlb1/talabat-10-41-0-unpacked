package com.talabat.darkstores.data.tracking;

import android.content.Context;
import android.os.Bundle;
import com.talabat.darkstores.di.LibScope;
import com.talabat.darkstores.di.qualifier.IoScheduler;
import io.reactivex.Scheduler;
import io.reactivex.subjects.PublishSubject;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import ni.a;
import org.jetbrains.annotations.NotNull;
import tracking.gtm.ITalabatFirebase;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ!\u0010\u0015\u001a\u00020\u00122\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\"\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0017J'\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00102\u0012\u0010\u001b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\"\u00020\u0012¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000RN\u0010\r\u001aB\u0012>\u0012<\u0012\u0004\u0012\u00020\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011 \u0014*\u001e\u0012\u0004\u0012\u00020\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011\u0018\u00010\u000fj\u0004\u0018\u0001`\u00130\u000fj\u0002`\u00130\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/talabat/darkstores/data/tracking/BaseTracker;", "", "context", "Landroid/content/Context;", "firebase", "Ltracking/gtm/ITalabatFirebase;", "storeInfoTrackingProvider", "Lcom/talabat/darkstores/data/tracking/StoreInfoTrackingProvider;", "locationTrackingProvider", "Lcom/talabat/darkstores/data/tracking/LocationTrackingProvider;", "ioScheduler", "Lio/reactivex/Scheduler;", "(Landroid/content/Context;Ltracking/gtm/ITalabatFirebase;Lcom/talabat/darkstores/data/tracking/StoreInfoTrackingProvider;Lcom/talabat/darkstores/data/tracking/LocationTrackingProvider;Lio/reactivex/Scheduler;)V", "eventQueue", "Lio/reactivex/subjects/PublishSubject;", "Lkotlin/Pair;", "", "", "Landroid/os/Bundle;", "Lcom/talabat/darkstores/data/tracking/Event;", "kotlin.jvm.PlatformType", "combine", "bundles", "([Landroid/os/Bundle;)Landroid/os/Bundle;", "dispatch", "", "eventName", "eventParams", "(Ljava/lang/String;[Landroid/os/Bundle;)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
@LibScope
public final class BaseTracker {
    @NotNull
    private final Context context;
    @NotNull
    private final PublishSubject<Pair<String, Bundle[]>> eventQueue;
    @NotNull

    /* renamed from: firebase  reason: collision with root package name */
    private final ITalabatFirebase f56218firebase;

    @Inject
    public BaseTracker(@NotNull Context context2, @NotNull ITalabatFirebase iTalabatFirebase, @NotNull StoreInfoTrackingProvider storeInfoTrackingProvider, @NotNull LocationTrackingProvider locationTrackingProvider, @IoScheduler @NotNull Scheduler scheduler) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(iTalabatFirebase, "firebase");
        Intrinsics.checkNotNullParameter(storeInfoTrackingProvider, "storeInfoTrackingProvider");
        Intrinsics.checkNotNullParameter(locationTrackingProvider, "locationTrackingProvider");
        Intrinsics.checkNotNullParameter(scheduler, "ioScheduler");
        this.context = context2;
        this.f56218firebase = iTalabatFirebase;
        PublishSubject<Pair<String, Bundle[]>> create = PublishSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<Event>()");
        this.eventQueue = create;
        create.subscribeOn(scheduler).subscribe(new a(this, locationTrackingProvider, storeInfoTrackingProvider));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m9743_init_$lambda1(BaseTracker baseTracker, LocationTrackingProvider locationTrackingProvider, StoreInfoTrackingProvider storeInfoTrackingProvider, Pair pair) {
        Intrinsics.checkNotNullParameter(baseTracker, "this$0");
        Intrinsics.checkNotNullParameter(locationTrackingProvider, "$locationTrackingProvider");
        Intrinsics.checkNotNullParameter(storeInfoTrackingProvider, "$storeInfoTrackingProvider");
        String str = (String) pair.component1();
        Bundle[] bundleArr = (Bundle[]) pair.component2();
        ITalabatFirebase iTalabatFirebase = baseTracker.f56218firebase;
        try {
            Result.Companion companion = Result.Companion;
            Context context2 = baseTracker.context;
            SpreadBuilder spreadBuilder = new SpreadBuilder(3);
            spreadBuilder.add(locationTrackingProvider.getLocationParams());
            spreadBuilder.add(storeInfoTrackingProvider.getStoreInfoParams());
            spreadBuilder.addSpread(bundleArr);
            iTalabatFirebase.dispatchEvent(context2, str, baseTracker.combine((Bundle[]) spreadBuilder.toArray(new Bundle[spreadBuilder.size()])));
            Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
    }

    private final Bundle combine(Bundle... bundleArr) {
        int i11 = 0;
        for (Bundle size : bundleArr) {
            i11 += size.size();
        }
        Bundle bundle = new Bundle(i11);
        for (Bundle putAll : bundleArr) {
            bundle.putAll(putAll);
        }
        return bundle;
    }

    public final void dispatch(@NotNull String str, @NotNull Bundle... bundleArr) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(bundleArr, "eventParams");
        this.eventQueue.onNext(TuplesKt.to(str, bundleArr));
    }
}
