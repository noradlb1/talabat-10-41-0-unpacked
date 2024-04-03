package com.talabat.core.hms.push.presentation;

import android.app.Application;
import android.content.Context;
import com.braze.Braze;
import com.braze.push.BrazeHuaweiPushHandler;
import com.google.gson.Gson;
import com.huawei.hms.push.HmsMessageService;
import com.huawei.hms.push.RemoteMessage;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.gms.base.domain.GmsBaseCoreLibApi;
import com.talabat.core.gms.base.domain.IsGmsAvailable;
import com.talabat.core.hms.push.domain.model.OrderTrackingWatchUpdate;
import com.talabat.core.hms.push.presentation.di.DaggerHmsPushServiceComponent;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.wearable.huawei.domain.HuaweiWatchCoreLibApi;
import com.talabat.core.wearable.huawei.domain.TalabatHuaweiWatch;
import com.talabat.talabatcommon.extentions.GsonKt;
import com.talabat.talabatcore.logger.LogManager;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H\u0002J\u0012\u0010&\u001a\u00020\u001f2\b\u0010)\u001a\u0004\u0018\u00010%H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006*"}, d2 = {"Lcom/talabat/core/hms/push/presentation/HmsPushService;", "Lcom/huawei/hms/push/HmsMessageService;", "()V", "braze", "Lcom/braze/Braze;", "getBraze", "()Lcom/braze/Braze;", "setBraze", "(Lcom/braze/Braze;)V", "isGmsAvailable", "", "isGmsAvailable$annotations", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "getObservabilityManager", "()Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "setObservabilityManager", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "talabatHuaweiWatch", "Lcom/talabat/core/wearable/huawei/domain/TalabatHuaweiWatch;", "getTalabatHuaweiWatch", "()Lcom/talabat/core/wearable/huawei/domain/TalabatHuaweiWatch;", "setTalabatHuaweiWatch", "(Lcom/talabat/core/wearable/huawei/domain/TalabatHuaweiWatch;)V", "uiScope", "Lkotlinx/coroutines/CoroutineScope;", "getUiScope", "()Lkotlinx/coroutines/CoroutineScope;", "setUiScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "onCreate", "", "onMessageReceived", "remoteMessage", "Lcom/huawei/hms/push/RemoteMessage;", "onNewToken", "token", "", "sendOrderStatusUpdateToWatch", "newState", "Lcom/talabat/core/hms/push/domain/model/OrderTrackingWatchUpdate;", "message", "com_talabat_core_hms_push_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HmsPushService extends HmsMessageService {
    @Inject
    public Braze braze;
    @Inject
    @JvmField
    public boolean isGmsAvailable;
    @Inject
    public IObservabilityManager observabilityManager;
    @Inject
    public TalabatHuaweiWatch talabatHuaweiWatch;
    @Inject
    public CoroutineScope uiScope;

    @IsGmsAvailable
    public static /* synthetic */ void isGmsAvailable$annotations() {
    }

    private final void sendOrderStatusUpdateToWatch(String str) {
        LogManager.debug("sendOrderStatusUpdateToWatch::message: " + str);
        if (str != null) {
            sendOrderStatusUpdateToWatch(new OrderTrackingWatchUpdate((List) null, str, 1, (DefaultConstructorMarker) null));
        }
    }

    @NotNull
    public final Braze getBraze() {
        Braze braze2 = this.braze;
        if (braze2 != null) {
            return braze2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("braze");
        return null;
    }

    @NotNull
    public final IObservabilityManager getObservabilityManager() {
        IObservabilityManager iObservabilityManager = this.observabilityManager;
        if (iObservabilityManager != null) {
            return iObservabilityManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("observabilityManager");
        return null;
    }

    @NotNull
    public final TalabatHuaweiWatch getTalabatHuaweiWatch() {
        TalabatHuaweiWatch talabatHuaweiWatch2 = this.talabatHuaweiWatch;
        if (talabatHuaweiWatch2 != null) {
            return talabatHuaweiWatch2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("talabatHuaweiWatch");
        return null;
    }

    @NotNull
    public final CoroutineScope getUiScope() {
        CoroutineScope coroutineScope = this.uiScope;
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Intrinsics.throwUninitializedPropertyAccessException("uiScope");
        return null;
    }

    public void onCreate() {
        super.onCreate();
        Application application = getApplication();
        if (application != null) {
            ApiContainer apiContainer = (ApiContainer) application;
            DaggerHmsPushServiceComponent.factory().create((ContextCoreLibApi) apiContainer.getFeature(ContextCoreLibApi.class), (GmsBaseCoreLibApi) apiContainer.getFeature(GmsBaseCoreLibApi.class), (DispatcherCoreLibApi) apiContainer.getFeature(DispatcherCoreLibApi.class), (ObservabilityCoreLibApi) apiContainer.getFeature(ObservabilityCoreLibApi.class), (HuaweiWatchCoreLibApi) apiContainer.getFeature(HuaweiWatchCoreLibApi.class)).inject(this);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.core.di.ApiContainer");
    }

    public void onMessageReceived(@NotNull RemoteMessage remoteMessage) {
        Intrinsics.checkNotNullParameter(remoteMessage, "remoteMessage");
        super.onMessageReceived(remoteMessage);
        Map<String, String> dataOfMap = remoteMessage.getDataOfMap();
        LogManager.debug("onMessageReceived::remoteMessage: " + dataOfMap);
        sendOrderStatusUpdateToWatch(dataOfMap.get("a"));
        BrazeHuaweiPushHandler brazeHuaweiPushHandler = BrazeHuaweiPushHandler.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        brazeHuaweiPushHandler.handleHmsRemoteMessageData(applicationContext, dataOfMap);
    }

    public void onNewToken(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, LegacyTokenLocalDataSourceImpl.KEY);
        super.onNewToken(str);
        if (!this.isGmsAvailable) {
            getBraze().setRegisteredPushToken(str);
        } else {
            LogManager.info("Got Huawei token, but current device is registered with Google Services");
        }
    }

    public final void setBraze(@NotNull Braze braze2) {
        Intrinsics.checkNotNullParameter(braze2, "<set-?>");
        this.braze = braze2;
    }

    public final void setObservabilityManager(@NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "<set-?>");
        this.observabilityManager = iObservabilityManager;
    }

    public final void setTalabatHuaweiWatch(@NotNull TalabatHuaweiWatch talabatHuaweiWatch2) {
        Intrinsics.checkNotNullParameter(talabatHuaweiWatch2, "<set-?>");
        this.talabatHuaweiWatch = talabatHuaweiWatch2;
    }

    public final void setUiScope(@NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<set-?>");
        this.uiScope = coroutineScope;
    }

    private final void sendOrderStatusUpdateToWatch(OrderTrackingWatchUpdate orderTrackingWatchUpdate) {
        Gson gson = GsonKt.getGson();
        String json = !(gson instanceof Gson) ? gson.toJson((Object) orderTrackingWatchUpdate) : GsonInstrumentation.toJson(gson, (Object) orderTrackingWatchUpdate);
        LogManager.debug("sendOrderStatusUpdateToWatch: " + json);
        getObservabilityManager().track("sendOrderStatusUpdateToWatch", "HuaweiWatchIntegration", MapsKt__MapsJVMKt.mapOf(TuplesKt.to("message", json)));
        Job unused = BuildersKt__Builders_commonKt.launch$default(getUiScope(), (CoroutineContext) null, (CoroutineStart) null, new HmsPushService$sendOrderStatusUpdateToWatch$2(this, json, (Continuation<? super HmsPushService$sendOrderStatusUpdateToWatch$2>) null), 3, (Object) null);
    }
}
