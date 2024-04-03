package com.talabat.integration;

import android.app.Activity;
import com.apptimize.Apptimize;
import com.talabat.R;
import com.talabat.components.FiltersRepositoryForPaginationImplementer;
import com.talabat.components.FiltersRepositoryImplementer;
import com.talabat.filters.domain.FiltersRepository;
import com.talabat.helpers.TalabatApplication;
import com.talabat.observability.ObservabilityManager;
import com.talabat.talabatcommon.extentions.SingleAccess;
import com.talabat.talabatcommon.lifecycle.AutoDisposableKt;
import com.talabat.talabatcommon.lifecycle.ContextLifecycleEventsKt;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.SingleSubject;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.SharedPreferencesManager;
import ms.a;
import ms.b;
import ms.c;
import ms.d;
import ms.e;
import ms.f;
import ms.g;
import ms.h;
import ms.i;
import ms.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000g\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u001a\u001a\r\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010\u001b\u001a\b\u0010\u001c\u001a\u00020\u001dH\u0002\u001a\u0016\u0010\u001e\u001a\u00020\u00062\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002\u001a\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$H\u0002\u001a$\u0010%\u001a\u00020\u00062\f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0 2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002\u001a\u001a\u0010(\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0)*\u00020\u0005H\u0002\u001a\f\u0010*\u001a\u00020+*\u00020\u0005H\u0002\u001a\u0018\u0010,\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0)*\u00020\u0005\u001a\n\u0010-\u001a\u00020\u0006*\u00020\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\")\u0010\u0002\u001a\u001d\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007¢\u0006\u0002\b\b0\u0003X\u0004¢\u0006\u0002\n\u0000\")\u0010\t\u001a\u001d\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007¢\u0006\u0002\b\b0\u0003X\u0004¢\u0006\u0002\n\u0000\")\u0010\n\u001a\u001d\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007¢\u0006\u0002\b\b0\u0003X\u0004¢\u0006\u0002\n\u0000\"\u001f\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\")\u0010\u0011\u001a\u001d\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007¢\u0006\u0002\b\b0\u0003X\u0004¢\u0006\u0002\n\u0000\")\u0010\u0012\u001a\u001d\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007¢\u0006\u0002\b\b0\u0003X\u0004¢\u0006\u0002\n\u0000\"/\u0010\u0013\u001a\u001d\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007¢\u0006\u0002\b\b0\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\")\u0010\u0016\u001a\u001d\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007¢\u0006\u0002\b\b0\u0003X\u0004¢\u0006\u0002\n\u0000\")\u0010\u0017\u001a\u001d\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007¢\u0006\u0002\b\b0\u0003X\u0004¢\u0006\u0002\n\u0000\")\u0010\u0018\u001a\u001d\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007¢\u0006\u0002\b\b0\u0003X\u0004¢\u0006\u0002\n\u0000*.\b\u0002\u0010.\"\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\b2\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\b¨\u0006/"}, d2 = {"MAXIMUM_WAIT_FOR_APPTIMIIZE_SECONDS", "", "initialiseInstabug", "Lcom/talabat/talabatcommon/extentions/SingleAccess;", "Lkotlin/Function1;", "Lcom/talabat/helpers/TalabatApplication;", "", "Lcom/talabat/integration/Initializer;", "Lkotlin/ExtensionFunctionType;", "initialiseTalabatNetworkModuleIntegrator", "initialiseTalabatNetworkModuleSafetyIntegrator", "initializationComplete", "Lio/reactivex/subjects/BehaviorSubject;", "", "kotlin.jvm.PlatformType", "getInitializationComplete", "()Lio/reactivex/subjects/BehaviorSubject;", "initializeExperiments", "initializeFiltersComponent", "initializeNewRelic", "getInitializeNewRelic", "()Lcom/talabat/talabatcommon/extentions/SingleAccess;", "initializeTalabatCommon", "initializeTalabatLib", "initializeWithDependencyInjectionComplete", "activityLifecycleCallbacks", "com/talabat/integration/IntegrationsKt$activityLifecycleCallbacks$1", "()Lcom/talabat/integration/IntegrationsKt$activityLifecycleCallbacks$1;", "getFiltersRepository", "Lcom/talabat/filters/domain/FiltersRepository;", "listenToAppStartupComplete", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "logObservabilityError", "it", "", "triggerCallbackAfterOnStart", "listener", "Lcom/talabat/integration/OnAppStartupCompleteListener;", "initializeAll", "Lio/reactivex/Single;", "initializeAllInBackground", "Lio/reactivex/disposables/Disposable;", "initializeApptimize", "initializeInBackground", "Initializer", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class IntegrationsKt {
    private static final long MAXIMUM_WAIT_FOR_APPTIMIIZE_SECONDS = 3;
    @NotNull
    private static final SingleAccess<Function1<TalabatApplication, Unit>> initialiseInstabug = new SingleAccess<>(IntegrationsKt$initialiseInstabug$1.INSTANCE);
    @NotNull
    private static final SingleAccess<Function1<TalabatApplication, Unit>> initialiseTalabatNetworkModuleIntegrator = new SingleAccess<>(IntegrationsKt$initialiseTalabatNetworkModuleIntegrator$1.INSTANCE);
    @NotNull
    private static final SingleAccess<Function1<TalabatApplication, Unit>> initialiseTalabatNetworkModuleSafetyIntegrator = new SingleAccess<>(IntegrationsKt$initialiseTalabatNetworkModuleSafetyIntegrator$1.INSTANCE);
    @NotNull
    private static final BehaviorSubject<Boolean> initializationComplete;
    @NotNull
    private static final SingleAccess<Function1<TalabatApplication, Unit>> initializeExperiments = new SingleAccess<>(IntegrationsKt$initializeExperiments$1.INSTANCE);
    @NotNull
    private static final SingleAccess<Function1<TalabatApplication, Unit>> initializeFiltersComponent = new SingleAccess<>(IntegrationsKt$initializeFiltersComponent$1.INSTANCE);
    @NotNull
    private static final SingleAccess<Function1<TalabatApplication, Unit>> initializeNewRelic = new SingleAccess<>(IntegrationsKt$initializeNewRelic$1.INSTANCE);
    @NotNull
    private static final SingleAccess<Function1<TalabatApplication, Unit>> initializeTalabatCommon = new SingleAccess<>(IntegrationsKt$initializeTalabatCommon$1.INSTANCE);
    @NotNull
    private static final SingleAccess<Function1<TalabatApplication, Unit>> initializeTalabatLib = new SingleAccess<>(IntegrationsKt$initializeTalabatLib$1.INSTANCE);
    @NotNull
    private static final SingleAccess<Function1<TalabatApplication, Unit>> initializeWithDependencyInjectionComplete = new SingleAccess<>(IntegrationsKt$initializeWithDependencyInjectionComplete$1.INSTANCE);

    static {
        BehaviorSubject<Boolean> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<Boolean>()");
        initializationComplete = create;
    }

    private static final IntegrationsKt$activityLifecycleCallbacks$1 activityLifecycleCallbacks() {
        return new IntegrationsKt$activityLifecycleCallbacks$1();
    }

    /* access modifiers changed from: private */
    public static final FiltersRepository getFiltersRepository() {
        if (SharedPreferencesManager.getInstance().getLastFavVerticalId() == 0) {
            return FiltersRepositoryForPaginationImplementer.INSTANCE;
        }
        return FiltersRepositoryImplementer.INSTANCE;
    }

    @NotNull
    public static final BehaviorSubject<Boolean> getInitializationComplete() {
        return initializationComplete;
    }

    @NotNull
    public static final SingleAccess<Function1<TalabatApplication, Unit>> getInitializeNewRelic() {
        return initializeNewRelic;
    }

    private static final Single<Boolean> initializeAll(TalabatApplication talabatApplication) {
        Single<Boolean> fromCallable = Single.fromCallable(new a(talabatApplication));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "fromCallable {\n    initi…?.invoke(this)\n    true\n}");
        return fromCallable;
    }

    /* access modifiers changed from: private */
    /* renamed from: initializeAll$lambda-7  reason: not valid java name */
    public static final Boolean m10665initializeAll$lambda7(TalabatApplication talabatApplication) {
        Intrinsics.checkNotNullParameter(talabatApplication, "$this_initializeAll");
        Function1 value = initializeTalabatLib.getValue();
        if (value != null) {
            value.invoke(talabatApplication);
        }
        Function1 value2 = initializeWithDependencyInjectionComplete.getValue();
        if (value2 != null) {
            value2.invoke(talabatApplication);
        }
        Function1 value3 = initialiseTalabatNetworkModuleIntegrator.getValue();
        if (value3 != null) {
            value3.invoke(talabatApplication);
        }
        Function1 value4 = initialiseTalabatNetworkModuleSafetyIntegrator.getValue();
        if (value4 != null) {
            value4.invoke(talabatApplication);
        }
        Function1 value5 = initializeNewRelic.getValue();
        if (value5 != null) {
            value5.invoke(talabatApplication);
        }
        Function1 value6 = initializeExperiments.getValue();
        if (value6 != null) {
            value6.invoke(talabatApplication);
        }
        Function1 value7 = initializeTalabatCommon.getValue();
        if (value7 != null) {
            value7.invoke(talabatApplication);
        }
        Function1 value8 = initializeFiltersComponent.getValue();
        if (value8 != null) {
            value8.invoke(talabatApplication);
        }
        Function1 value9 = initialiseInstabug.getValue();
        if (value9 != null) {
            value9.invoke(talabatApplication);
        }
        return Boolean.TRUE;
    }

    private static final Disposable initializeAllInBackground(TalabatApplication talabatApplication) {
        Single<R> onErrorReturn = initializeApptimize(talabatApplication).subscribeOn(Schedulers.io()).observeOn(Schedulers.io()).doOnError(new xq.a()).onErrorResumeNext(new b()).flatMap(new c(talabatApplication)).doOnError(new xq.a()).doOnError(new d()).map(new e()).onErrorReturn(new f());
        BehaviorSubject<Boolean> behaviorSubject = initializationComplete;
        Disposable subscribe = onErrorReturn.subscribe(new g(behaviorSubject), new h(behaviorSubject));
        Intrinsics.checkNotNullExpressionValue(subscribe, "initializeApptimize()\n  …izationComplete::onError)");
        return subscribe;
    }

    /* access modifiers changed from: private */
    /* renamed from: initializeAllInBackground$lambda-0  reason: not valid java name */
    public static final SingleSource m10666initializeAllInBackground$lambda0(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        return Single.just(Boolean.FALSE);
    }

    /* access modifiers changed from: private */
    /* renamed from: initializeAllInBackground$lambda-1  reason: not valid java name */
    public static final SingleSource m10667initializeAllInBackground$lambda1(TalabatApplication talabatApplication, Boolean bool) {
        Intrinsics.checkNotNullParameter(talabatApplication, "$this_initializeAllInBackground");
        Intrinsics.checkNotNullParameter(bool, "it");
        return initializeAll(talabatApplication);
    }

    /* access modifiers changed from: private */
    /* renamed from: initializeAllInBackground$lambda-2  reason: not valid java name */
    public static final void m10668initializeAllInBackground$lambda2(Throwable th2) {
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        logObservabilityError(th2);
    }

    /* access modifiers changed from: private */
    /* renamed from: initializeAllInBackground$lambda-3  reason: not valid java name */
    public static final Boolean m10669initializeAllInBackground$lambda3(Boolean bool) {
        Intrinsics.checkNotNullParameter(bool, "it");
        return Boolean.TRUE;
    }

    /* access modifiers changed from: private */
    /* renamed from: initializeAllInBackground$lambda-4  reason: not valid java name */
    public static final Boolean m10670initializeAllInBackground$lambda4(Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "it");
        return Boolean.FALSE;
    }

    @NotNull
    public static final Single<Boolean> initializeApptimize(@NotNull TalabatApplication talabatApplication) {
        Intrinsics.checkNotNullParameter(talabatApplication, "<this>");
        Single<Boolean> defer = Single.defer(new i(talabatApplication));
        Intrinsics.checkNotNullExpressionValue(defer, "defer {\n    val onComple…MIIZE_SECONDS, SECONDS)\n}");
        return defer;
    }

    /* access modifiers changed from: private */
    /* renamed from: initializeApptimize$lambda-6  reason: not valid java name */
    public static final SingleSource m10671initializeApptimize$lambda6(TalabatApplication talabatApplication) {
        Intrinsics.checkNotNullParameter(talabatApplication, "$this_initializeApptimize");
        SingleSubject create = SingleSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<Boolean>()");
        if (!talabatApplication.isRobolectric()) {
            Apptimize.setup(talabatApplication, talabatApplication.getResources().getString(R.string.apptimise));
            Apptimize.setOnApptimizeInitializedListener(new j(create));
        } else {
            create.onSuccess(Boolean.TRUE);
        }
        return create.timeout(3, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: private */
    /* renamed from: initializeApptimize$lambda-6$lambda-5  reason: not valid java name */
    public static final void m10672initializeApptimize$lambda6$lambda5(SingleSubject singleSubject) {
        Intrinsics.checkNotNullParameter(singleSubject, "$onComplete");
        singleSubject.onSuccess(Boolean.TRUE);
    }

    public static final void initializeInBackground(@NotNull TalabatApplication talabatApplication) {
        Intrinsics.checkNotNullParameter(talabatApplication, "<this>");
        initializeAllInBackground(talabatApplication);
        talabatApplication.registerActivityLifecycleCallbacks(activityLifecycleCallbacks());
    }

    /* access modifiers changed from: private */
    public static final void listenToAppStartupComplete(WeakReference<Activity> weakReference) {
        Activity activity = weakReference.get();
        if (activity != null) {
            AutoDisposableKt.withAutoDisposables(activity, new IntegrationsKt$listenToAppStartupComplete$1((OnAppStartupCompleteListener) activity, weakReference));
        }
    }

    private static final void logObservabilityError(Throwable th2) {
        ObservabilityManager.trackUnExpectedScenario("Startup", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("error", th2.toString())));
    }

    /* access modifiers changed from: private */
    public static final void triggerCallbackAfterOnStart(WeakReference<OnAppStartupCompleteListener> weakReference, WeakReference<Activity> weakReference2) {
        Activity activity = weakReference2.get();
        if (activity != null) {
            ContextLifecycleEventsKt.withLifecycleEvents(activity, new IntegrationsKt$triggerCallbackAfterOnStart$1(new SingleAccess(new IntegrationsKt$triggerCallbackAfterOnStart$onAppStartupComplete$1(weakReference))));
        }
    }
}
