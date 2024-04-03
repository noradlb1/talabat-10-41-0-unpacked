package com.deliveryhero.perseus.di;

import com.deliveryhero.perseus.core.config.PerseusConfigProvider;
import com.deliveryhero.perseus.core.deviceinfo.DeviceInfoProvider;
import com.deliveryhero.perseus.core.session.AppSessionManager;
import com.deliveryhero.perseus.core.session.ClientIdProvider;
import com.deliveryhero.perseus.utils.RandomValue;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import j$.util.DesugarTimeZone;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.RandomKt;
import org.jetbrains.annotations.NotNull;
import v5.a;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/deliveryhero/perseus/di/CoreModule;", "", "()V", "appSessionManager", "Lcom/deliveryhero/perseus/core/session/AppSessionManager;", "getAppSessionManager", "()Lcom/deliveryhero/perseus/core/session/AppSessionManager;", "appSessionManager$delegate", "Lkotlin/Lazy;", "clientIdProvider", "Lcom/deliveryhero/perseus/core/session/ClientIdProvider;", "getClientIdProvider", "()Lcom/deliveryhero/perseus/core/session/ClientIdProvider;", "clientIdProvider$delegate", "deviceInfoProvider", "Lcom/deliveryhero/perseus/core/deviceinfo/DeviceInfoProvider;", "getDeviceInfoProvider", "()Lcom/deliveryhero/perseus/core/deviceinfo/DeviceInfoProvider;", "deviceInfoProvider$delegate", "perseusConfigProvider", "Lcom/deliveryhero/perseus/core/config/PerseusConfigProvider;", "getPerseusConfigProvider", "()Lcom/deliveryhero/perseus/core/config/PerseusConfigProvider;", "perseusConfigProvider$delegate", "random", "Lcom/deliveryhero/perseus/utils/RandomValue;", "getRandom", "()Lcom/deliveryhero/perseus/utils/RandomValue;", "setRandom", "(Lcom/deliveryhero/perseus/utils/RandomValue;)V", "scheduler", "Lio/reactivex/Scheduler;", "getScheduler", "()Lio/reactivex/Scheduler;", "setScheduler", "(Lio/reactivex/Scheduler;)V", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CoreModule {
    @NotNull
    public static final CoreModule INSTANCE = new CoreModule();
    @NotNull
    private static final Lazy appSessionManager$delegate = LazyKt__LazyJVMKt.lazy(CoreModule$appSessionManager$2.INSTANCE);
    @NotNull
    private static final Lazy clientIdProvider$delegate = LazyKt__LazyJVMKt.lazy(CoreModule$clientIdProvider$2.INSTANCE);
    @NotNull
    private static final Lazy deviceInfoProvider$delegate = LazyKt__LazyJVMKt.lazy(CoreModule$deviceInfoProvider$2.INSTANCE);
    @NotNull
    private static final Lazy perseusConfigProvider$delegate = LazyKt__LazyJVMKt.lazy(CoreModule$perseusConfigProvider$2.INSTANCE);
    @NotNull
    private static RandomValue random = new a();
    @NotNull
    private static Scheduler scheduler;

    static {
        Scheduler io2 = Schedulers.io();
        Intrinsics.checkNotNullExpressionValue(io2, "io()");
        scheduler = io2;
    }

    private CoreModule() {
    }

    /* access modifiers changed from: private */
    public static final double random$lambda$0(double d11, double d12) {
        return RandomKt.Random(Calendar.getInstance(DesugarTimeZone.getTimeZone("UTC")).getTimeInMillis()).nextDouble(d11, d12);
    }

    @NotNull
    public final AppSessionManager getAppSessionManager() {
        return (AppSessionManager) appSessionManager$delegate.getValue();
    }

    @NotNull
    public final ClientIdProvider getClientIdProvider() {
        return (ClientIdProvider) clientIdProvider$delegate.getValue();
    }

    @NotNull
    public final DeviceInfoProvider getDeviceInfoProvider() {
        return (DeviceInfoProvider) deviceInfoProvider$delegate.getValue();
    }

    @NotNull
    public final PerseusConfigProvider getPerseusConfigProvider() {
        return (PerseusConfigProvider) perseusConfigProvider$delegate.getValue();
    }

    @NotNull
    public final RandomValue getRandom() {
        return random;
    }

    @NotNull
    public final Scheduler getScheduler() {
        return scheduler;
    }

    public final void setRandom(@NotNull RandomValue randomValue) {
        Intrinsics.checkNotNullParameter(randomValue, "<set-?>");
        random = randomValue;
    }

    public final void setScheduler(@NotNull Scheduler scheduler2) {
        Intrinsics.checkNotNullParameter(scheduler2, "<set-?>");
        scheduler = scheduler2;
    }
}
