package com.instabug.crash;

import android.content.Context;
import com.deliveryhero.performance.core.logger.TraceLogKt;
import com.instabug.commons.caching.SessionCacheDirectory;
import com.instabug.commons.di.CommonsLocator;
import com.instabug.commons.g;
import com.instabug.crash.utils.CrashReportingUtility;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventSubscriber;
import com.instabug.library.core.plugin.Plugin;
import com.instabug.library.model.common.Session;
import com.instabug.library.sessionV3.providers.FeatureSessionDataController;
import com.instabug.library.sessionV3.providers.FeatureSessionDataControllerHost;
import com.instabug.library.sessionV3.providers.FeatureSessionLazyDataProvider;
import com.instabug.library.util.threading.PoolProvider;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CrashPlugin extends Plugin implements FeatureSessionDataControllerHost, FeatureSessionLazyDataProvider {
    @Nullable
    private Disposable sdkEventsSubscription;

    public static final class a extends Lambda implements Function1 {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ SDKCoreEvent f46366g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SDKCoreEvent sDKCoreEvent) {
            super(1);
            this.f46366g = sDKCoreEvent;
        }

        public final void a(@NotNull g gVar) {
            Intrinsics.checkNotNullParameter(gVar, "$this$onDelegates");
            SDKCoreEvent sDKCoreEvent = this.f46366g;
            Intrinsics.checkNotNullExpressionValue(sDKCoreEvent, "event");
            gVar.a(sDKCoreEvent);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((g) obj);
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1 {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f46367g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            super(1);
            this.f46367g = context;
        }

        public final void a(@NotNull g gVar) {
            Intrinsics.checkNotNullParameter(gVar, "$this$onDelegates");
            gVar.b(this.f46367g);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((g) obj);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final c f46368a = new c();

        public c() {
            super(1, g.class, "sleep", "sleep()V", 0);
        }

        public final void a(@NotNull g gVar) {
            Intrinsics.checkNotNullParameter(gVar, "p0");
            gVar.b();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((g) obj);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1 {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Context f46369g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Context context) {
            super(1);
            this.f46369g = context;
        }

        public final void a(@NotNull g gVar) {
            Intrinsics.checkNotNullParameter(gVar, "$this$onDelegates");
            gVar.a(this.f46369g);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((g) obj);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class e extends FunctionReferenceImpl implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final e f46370a = new e();

        public e() {
            super(1, g.class, TraceLogKt.STOP_PROPERTY_NAME, "stop()V", 0);
        }

        public final void a(@NotNull g gVar) {
            Intrinsics.checkNotNullParameter(gVar, "p0");
            gVar.c();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((g) obj);
            return Unit.INSTANCE;
        }
    }

    public /* synthetic */ class f extends FunctionReferenceImpl implements Function1 {

        /* renamed from: a  reason: collision with root package name */
        public static final f f46371a = new f();

        public f() {
            super(1, g.class, "wake", "wake()V", 0);
        }

        public final void a(@NotNull g gVar) {
            Intrinsics.checkNotNullParameter(gVar, "p0");
            gVar.a();
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((g) obj);
            return Unit.INSTANCE;
        }
    }

    private final Disposable getSDKEventSubscriber() {
        Disposable subscribe = SDKCoreEventSubscriber.subscribe(new fc.a(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe { event -> onD…leSDKCoreEvent(event) } }");
        return subscribe;
    }

    /* access modifiers changed from: private */
    /* renamed from: getSDKEventSubscriber$lambda-0  reason: not valid java name */
    public static final void m9344getSDKEventSubscriber$lambda0(CrashPlugin crashPlugin, SDKCoreEvent sDKCoreEvent) {
        Intrinsics.checkNotNullParameter(crashPlugin, "this$0");
        crashPlugin.onDelegates(new a(sDKCoreEvent));
    }

    private final void onDelegates(Function1<? super g, Unit> function1) {
        for (Object invoke : com.instabug.crash.di.d.e()) {
            function1.invoke(invoke);
        }
    }

    public long getLastActivityTime() {
        return com.instabug.crash.settings.b.a().b();
    }

    @Nullable
    public final Disposable getSdkEventsSubscription() {
        return this.sdkEventsSubscription;
    }

    @NotNull
    public FeatureSessionDataController getSessionDataController() {
        return CommonsLocator.getCrashesSessionDataController();
    }

    public void init(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.init(context);
        onDelegates(new b(context));
    }

    @NotNull
    public Map<String, Boolean> isDataReady(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "sessionIds");
        return CommonsLocator.getSessionLinker().a(list);
    }

    public boolean isFeatureEnabled() {
        return CrashReportingUtility.isCrashReportingEnabled();
    }

    public final void setSdkEventsSubscription(@Nullable Disposable disposable) {
        this.sdkEventsSubscription = disposable;
    }

    public void sleep() {
        onDelegates(c.f46368a);
    }

    public void start(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        onDelegates(new d(context));
        PoolProvider.postIOTaskWithCheck(new fc.b(this));
    }

    public void stop() {
        CommonsLocator.getCrashesCacheDir().setCurrentSessionId((String) null);
        onDelegates(e.f46370a);
        Disposable disposable = this.sdkEventsSubscription;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    public final void subscribeOnSDKEvents() {
        this.sdkEventsSubscription = getSDKEventSubscriber();
    }

    public void wake() {
        String str;
        SessionCacheDirectory crashesCacheDir = CommonsLocator.getCrashesCacheDir();
        Session runningSession = InstabugCore.getRunningSession();
        if (runningSession == null) {
            str = null;
        } else {
            str = runningSession.getId();
        }
        crashesCacheDir.setCurrentSessionId(str);
        onDelegates(f.f46371a);
    }
}
