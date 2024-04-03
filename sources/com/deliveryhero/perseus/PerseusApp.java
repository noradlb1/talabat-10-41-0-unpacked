package com.deliveryhero.perseus;

import android.app.Application;
import android.content.Context;
import androidx.annotation.Keep;
import com.deliveryhero.perseus.core.session.OnSessionChangedListener;
import com.deliveryhero.perseus.di.CoreModule;
import com.deliveryhero.perseus.di.LoggerModule;
import com.deliveryhero.perseus.di.PerseusAppComponent;
import com.deliveryhero.perseus.hits.usecase.DeleteStaleEventsUseCase;
import com.deliveryhero.perseus.logger.DatabaseInfoLogger;
import com.deliveryhero.perseus.logger.PerseusLogger;
import com.deliveryhero.perseus.optin.ExperimentalPerseusApi;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.core.fwf.data.FunWithFlagsConstants;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u5.a;
import u5.b;
import u5.c;
import u5.d;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u000fH\u0007J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020&H\u0007J\u001e\u0010-\u001a\u00020\u001a2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010/H\u0007J\b\u00100\u001a\u00020\u0004H\u0007J\b\u00101\u001a\u00020\u0004H\u0007J \u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u0002042\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\n\u001a\u00020\tH\u0007J\u0019\u00105\u001a\u00020\u001a2\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0002\u00107J\u0010\u00108\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020&H\u0007J\u0010\u00109\u001a\u00020\u001a2\u0006\u0010:\u001a\u00020\u0004H\u0007J\u0010\u0010;\u001a\u00020\u001a2\u0006\u0010<\u001a\u00020\u0004H\u0007J\u0010\u0010=\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020?H\u0007J\u0010\u0010@\u001a\u00020\u001a2\u0006\u0010A\u001a\u00020\u0018H\u0007J\u0012\u0010B\u001a\u00020\u001a2\b\u0010C\u001a\u0004\u0018\u00010DH\u0007J\u0010\u0010E\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020\u0004H\u0007J\u0010\u0010G\u001a\u00020\u001a2\u0006\u0010H\u001a\u00020\u0004H\u0007J*\u0010I\u001a\u00020\u001a2 \u0010J\u001a\u001c\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001a0\u0012H\u0007J\u0010\u0010K\u001a\u00020\u001a2\u0006\u0010L\u001a\u00020?H\u0007J\u0018\u0010M\u001a\u00020\u001a2\u000e\u0010N\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00160OH\u0007J\u0010\u0010P\u001a\u00020\u001a2\u0006\u0010Q\u001a\u00020\u0004H\u0007J\u0010\u0010R\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX.¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R°\u0001\u0010\u001b\u001aK\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00122O\u0010\b\u001aK\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0012@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006S"}, d2 = {"Lcom/deliveryhero/perseus/PerseusApp;", "", "()V", "PERSEUS_CLIENT_ID", "", "PERSEUS_HIT_MATCH_ID", "PERSEUS_SESSION_ID", "UNINITIALIZED_ERROR_MESSAGE", "<set-?>", "Lcom/deliveryhero/perseus/PerseusParamsConfig;", "config", "getConfig$perseus_release", "()Lcom/deliveryhero/perseus/PerseusParamsConfig;", "interceptors", "", "Lokhttp3/Interceptor;", "getInterceptors$perseus_release", "()Ljava/util/Set;", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "message", "", "throwable", "", "priority", "", "logPrintListener", "getLogPrintListener$perseus_release", "()Lkotlin/jvm/functions/Function3;", "policy", "Lcom/deliveryhero/perseus/PerseusExecutePolicy;", "getPolicy$perseus_release", "()Lcom/deliveryhero/perseus/PerseusExecutePolicy;", "setPolicy$perseus_release", "(Lcom/deliveryhero/perseus/PerseusExecutePolicy;)V", "sessionChangedListeners", "", "Lcom/deliveryhero/perseus/core/session/OnSessionChangedListener;", "getSessionChangedListeners$perseus_release", "()Ljava/util/List;", "addInterceptor", "interceptor", "addOnSessionChangedListener", "listener", "execute", "params", "", "getClientId", "getSessionId", "init", "context", "Landroid/content/Context;", "logBacklogInfo", "numberOfDeletedStaleEvents", "(Ljava/lang/Integer;)V", "removeOnSessionChangedListener", "setAdjustId", "adjustId", "setAdvertisingId", "advertisingId", "setBatchDispatchHitsDelay", "batchDispatchHitsDelay", "", "setBatchSize", "batchSize", "setConsent", "consent", "Lcom/deliveryhero/perseus/Consent;", "setCountryCode", "countryCode", "setGlobalEntityId", "globalEntityId", "setLogPrintCallback", "logPrintCallback", "setRetentionTime", "retentionTime", "setRxJavaPluginsErrorHandler", "handler", "Lio/reactivex/functions/Consumer;", "setUserId", "userId", "updateConfig", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerseusApp {
    @NotNull
    public static final PerseusApp INSTANCE = new PerseusApp();
    @NotNull
    public static final String PERSEUS_CLIENT_ID = "perseusClientId";
    @NotNull
    public static final String PERSEUS_HIT_MATCH_ID = "perseusHitMatchId";
    @NotNull
    public static final String PERSEUS_SESSION_ID = "perseusSessionId";
    @NotNull
    private static final String UNINITIALIZED_ERROR_MESSAGE = "Application context is missing, PerseusApp should be initialized!";
    private static PerseusParamsConfig config;
    @NotNull
    private static final Set<Interceptor> interceptors = new LinkedHashSet();
    @Nullable
    private static Function3<? super String, ? super Throwable, ? super Integer, Unit> logPrintListener;
    public static PerseusExecutePolicy policy;
    @NotNull
    private static final List<OnSessionChangedListener> sessionChangedListeners = new ArrayList();

    private PerseusApp() {
    }

    @JvmStatic
    @ExperimentalPerseusApi
    public static final void addInterceptor(@NotNull Interceptor interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        interceptors.add(interceptor);
    }

    @JvmStatic
    public static final void addOnSessionChangedListener(@NotNull OnSessionChangedListener onSessionChangedListener) {
        Intrinsics.checkNotNullParameter(onSessionChangedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        sessionChangedListeners.add(onSessionChangedListener);
    }

    public static /* synthetic */ void e(PerseusApp perseusApp, Integer num, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = null;
        }
        perseusApp.logBacklogInfo(num);
    }

    @JvmStatic
    @Keep
    public static final void execute(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        PerseusAppComponent perseusAppComponent = PerseusAppComponent.INSTANCE;
        if (perseusAppComponent.isInitialized()) {
            perseusAppComponent.getPerseusSaveHitUseCase().run(map).doOnError(new a(PerseusApp$execute$1.INSTANCE)).onErrorComplete().subscribe();
        } else {
            PerseusLogger.e$default(LoggerModule.INSTANCE.getPerseusLogger(), UNINITIALIZED_ERROR_MESSAGE, (Throwable) null, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void execute$lambda$2(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    @JvmStatic
    @NotNull
    public static final String getClientId() {
        PerseusAppComponent perseusAppComponent = PerseusAppComponent.INSTANCE;
        if (perseusAppComponent.isInitialized()) {
            return perseusAppComponent.getClientIdProvider().getClientId();
        }
        return "null";
    }

    @JvmStatic
    @NotNull
    public static final String getSessionId() {
        PerseusAppComponent perseusAppComponent = PerseusAppComponent.INSTANCE;
        if (perseusAppComponent.isInitialized()) {
            return perseusAppComponent.getAppSessionProvider().getUserSessionId();
        }
        PerseusLogger.e$default(LoggerModule.INSTANCE.getPerseusLogger(), UNINITIALIZED_ERROR_MESSAGE, (Throwable) null, 2, (Object) null);
        return "null";
    }

    @JvmStatic
    public static final void init(@NotNull Context context, @NotNull PerseusExecutePolicy perseusExecutePolicy, @NotNull PerseusParamsConfig perseusParamsConfig) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(perseusExecutePolicy, "policy");
        Intrinsics.checkNotNullParameter(perseusParamsConfig, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        PerseusApp perseusApp = INSTANCE;
        perseusApp.setPolicy$perseus_release(perseusExecutePolicy);
        config = perseusParamsConfig;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type android.app.Application");
        PerseusAppComponent perseusAppComponent = PerseusAppComponent.INSTANCE;
        perseusAppComponent.initializeComponent((Application) applicationContext, perseusParamsConfig);
        DeleteStaleEventsUseCase deleteStaleEventsUseCase = perseusAppComponent.getDeleteStaleEventsUseCase();
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        deleteStaleEventsUseCase.deleteStaleEvents(instance, (int) perseusApp.getConfig$perseus_release().getRetentionTime()).doOnError(new c(PerseusApp$init$1.INSTANCE)).doOnSuccess(new d(PerseusApp$init$2.INSTANCE)).subscribeOn(CoreModule.INSTANCE.getScheduler()).subscribe();
    }

    /* access modifiers changed from: private */
    public static final void init$lambda$0(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final void init$lambda$1(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public final void logBacklogInfo(Integer num) {
        DatabaseInfoLogger.logBacklogInfo$default(PerseusAppComponent.INSTANCE.getDatabaseInfoLogger(), num, (Calendar) null, 2, (Object) null).doOnError(new b(PerseusApp$logBacklogInfo$1.INSTANCE)).onErrorComplete().subscribeOn(CoreModule.INSTANCE.getScheduler()).subscribe();
    }

    /* access modifiers changed from: private */
    public static final void logBacklogInfo$lambda$3(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    @JvmStatic
    public static final void removeOnSessionChangedListener(@NotNull OnSessionChangedListener onSessionChangedListener) {
        Intrinsics.checkNotNullParameter(onSessionChangedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        sessionChangedListeners.remove(onSessionChangedListener);
    }

    @JvmStatic
    public static final void setAdjustId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "adjustId");
        if (config != null) {
            PerseusApp perseusApp = INSTANCE;
            perseusApp.getConfig$perseus_release().setAdjustId(str);
            PerseusAppComponent.INSTANCE.updateConfig(perseusApp.getConfig$perseus_release());
            return;
        }
        PerseusLogger.e$default(LoggerModule.INSTANCE.getPerseusLogger(), UNINITIALIZED_ERROR_MESSAGE, (Throwable) null, 2, (Object) null);
    }

    @JvmStatic
    public static final void setAdvertisingId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ConstantsKt.GOOGLE_AD_ID);
        if (config != null) {
            PerseusApp perseusApp = INSTANCE;
            perseusApp.getConfig$perseus_release().setAdvertisingId(str);
            PerseusAppComponent.INSTANCE.updateConfig(perseusApp.getConfig$perseus_release());
            return;
        }
        PerseusLogger.e$default(LoggerModule.INSTANCE.getPerseusLogger(), UNINITIALIZED_ERROR_MESSAGE, (Throwable) null, 2, (Object) null);
    }

    @JvmStatic
    public static final void setBatchDispatchHitsDelay(long j11) {
        PerseusAppComponent.INSTANCE.updateBatchDispatchHitsDelay(j11);
    }

    @JvmStatic
    public static final void setBatchSize(int i11) {
        PerseusApp perseusApp = INSTANCE;
        perseusApp.getConfig$perseus_release().setBatchSize(i11);
        PerseusAppComponent.INSTANCE.updateConfig(perseusApp.getConfig$perseus_release());
    }

    @JvmStatic
    public static final void setConsent(@Nullable Consent consent) {
        if (config != null) {
            PerseusApp perseusApp = INSTANCE;
            perseusApp.getConfig$perseus_release().setConsent(consent);
            PerseusAppComponent.INSTANCE.updateConfig(perseusApp.getConfig$perseus_release());
            return;
        }
        PerseusLogger.e$default(LoggerModule.INSTANCE.getPerseusLogger(), UNINITIALIZED_ERROR_MESSAGE, (Throwable) null, 2, (Object) null);
    }

    @JvmStatic
    public static final void setCountryCode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "countryCode");
        if (config != null) {
            PerseusApp perseusApp = INSTANCE;
            perseusApp.getConfig$perseus_release().setCountryCode(str);
            PerseusAppComponent.INSTANCE.updateConfig(perseusApp.getConfig$perseus_release());
            return;
        }
        PerseusLogger.e$default(LoggerModule.INSTANCE.getPerseusLogger(), UNINITIALIZED_ERROR_MESSAGE, (Throwable) null, 2, (Object) null);
    }

    @JvmStatic
    public static final void setGlobalEntityId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID);
        if (config != null) {
            PerseusApp perseusApp = INSTANCE;
            perseusApp.getConfig$perseus_release().setGlobalEntityId(str);
            PerseusAppComponent.INSTANCE.updateConfig(perseusApp.getConfig$perseus_release());
            return;
        }
        PerseusLogger.e$default(LoggerModule.INSTANCE.getPerseusLogger(), UNINITIALIZED_ERROR_MESSAGE, (Throwable) null, 2, (Object) null);
    }

    @JvmStatic
    public static final void setLogPrintCallback(@NotNull Function3<? super String, ? super Throwable, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(function3, "logPrintCallback");
        logPrintListener = function3;
    }

    @JvmStatic
    public static final void setRetentionTime(long j11) {
        PerseusApp perseusApp = INSTANCE;
        perseusApp.getConfig$perseus_release().setRetentionTime(j11);
        PerseusAppComponent.INSTANCE.updateConfig(perseusApp.getConfig$perseus_release());
    }

    @JvmStatic
    public static final void setRxJavaPluginsErrorHandler(@NotNull Consumer<? super Throwable> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "handler");
        RxJavaPlugins.setErrorHandler(consumer);
    }

    @JvmStatic
    public static final void setUserId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userId");
        if (config != null) {
            PerseusApp perseusApp = INSTANCE;
            perseusApp.getConfig$perseus_release().setUserId(str);
            PerseusAppComponent.INSTANCE.updateConfig(perseusApp.getConfig$perseus_release());
            return;
        }
        PerseusLogger.e$default(LoggerModule.INSTANCE.getPerseusLogger(), UNINITIALIZED_ERROR_MESSAGE, (Throwable) null, 2, (Object) null);
    }

    @JvmStatic
    public static final void updateConfig(@NotNull PerseusParamsConfig perseusParamsConfig) {
        Intrinsics.checkNotNullParameter(perseusParamsConfig, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        config = perseusParamsConfig;
        PerseusAppComponent.INSTANCE.updateConfig(INSTANCE.getConfig$perseus_release());
    }

    @NotNull
    public final PerseusParamsConfig getConfig$perseus_release() {
        PerseusParamsConfig perseusParamsConfig = config;
        if (perseusParamsConfig != null) {
            return perseusParamsConfig;
        }
        Intrinsics.throwUninitializedPropertyAccessException(DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        return null;
    }

    @NotNull
    public final Set<Interceptor> getInterceptors$perseus_release() {
        return interceptors;
    }

    @Nullable
    public final Function3<String, Throwable, Integer, Unit> getLogPrintListener$perseus_release() {
        return logPrintListener;
    }

    @NotNull
    public final PerseusExecutePolicy getPolicy$perseus_release() {
        PerseusExecutePolicy perseusExecutePolicy = policy;
        if (perseusExecutePolicy != null) {
            return perseusExecutePolicy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("policy");
        return null;
    }

    @NotNull
    public final List<OnSessionChangedListener> getSessionChangedListeners$perseus_release() {
        return sessionChangedListeners;
    }

    public final void setPolicy$perseus_release(@NotNull PerseusExecutePolicy perseusExecutePolicy) {
        Intrinsics.checkNotNullParameter(perseusExecutePolicy, "<set-?>");
        policy = perseusExecutePolicy;
    }
}
