package com.talabat.perseus;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.deliveryhero.perseus.PerseusApp;
import com.deliveryhero.perseus.PerseusExecutePolicy;
import com.deliveryhero.perseus.core.session.PerseusRandomIdGenerator;
import com.talabat.core.fwf.data.FunWithFlagsConstants;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import com.talabat.perseus.config.MappersKt;
import com.talabat.perseus.config.PerseusConfig;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u0004H\u0007J\b\u0010\u0014\u001a\u00020\u0004H\u0007J\b\u0010\u0015\u001a\u00020\u0004H\u0007J\b\u0010\u0016\u001a\u00020\u0007H\u0007J$\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u001aH\u0007J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u0004H\u0007J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0004H\u0007J\u0010\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0004H\u0007J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u0004H\u0007J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u0004H\u0007J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R$\u0010\u0006\u001a\u00020\u00078\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006'"}, d2 = {"Lcom/talabat/perseus/PerseusFacade;", "", "()V", "EVENT_ACTION_KEY", "", "TAG", "isInitialized", "", "isInitialized$perseus_analytics_release$annotations", "isInitialized$perseus_analytics_release", "()Z", "setInitialized$perseus_analytics_release", "(Z)V", "configurePerseus", "", "perseusConfig", "Lcom/talabat/perseus/config/PerseusConfig;", "context", "Landroid/content/Context;", "generatePerseusHitMatchId", "getPerseusClientId", "getPerseusSessionId", "isSdkInitialized", "sendEvent", "eventName", "attributes", "", "setAdjustId", "adjustId", "setAdvertisingId", "advertisingId", "setCountry", "countryIsoCode", "setGlobalEntityId", "globalEntityId", "setUserId", "userId", "updateConfig", "updateConfigFields", "perseus_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerseusFacade {
    @NotNull
    private static final String EVENT_ACTION_KEY = "eventAction";
    @NotNull
    public static final PerseusFacade INSTANCE = new PerseusFacade();
    @NotNull
    private static final String TAG = "TalabatPerseus";
    private static boolean isInitialized;

    private PerseusFacade() {
    }

    @JvmStatic
    public static final void configurePerseus(@NotNull PerseusConfig perseusConfig, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(perseusConfig, "perseusConfig");
        Intrinsics.checkNotNullParameter(context, "context");
        if (isInitialized) {
            INSTANCE.updateConfigFields(perseusConfig);
            return;
        }
        PerseusApp.init(context, PerseusExecutePolicy.BATCH, MappersKt.convert(perseusConfig));
        PerseusApp.setBatchDispatchHitsDelay(5);
        isInitialized = true;
    }

    @JvmStatic
    @NotNull
    public static final String generatePerseusHitMatchId() {
        if (isInitialized) {
            return PerseusRandomIdGenerator.createUniqueIdentifier();
        }
        throw new UninitializedException("Perseus SDK needs to be initialized first");
    }

    @JvmStatic
    @NotNull
    public static final String getPerseusClientId() {
        if (isInitialized) {
            return PerseusApp.getClientId();
        }
        throw new UninitializedException("Perseus SDK needs to be initialized first");
    }

    @JvmStatic
    @NotNull
    public static final String getPerseusSessionId() {
        if (isInitialized) {
            return PerseusApp.getSessionId();
        }
        throw new UninitializedException("Perseus SDK needs to be initialized first");
    }

    @VisibleForTesting
    public static /* synthetic */ void isInitialized$perseus_analytics_release$annotations() {
    }

    @JvmStatic
    public static final boolean isSdkInitialized() {
        return isInitialized;
    }

    @JvmStatic
    public static final void sendEvent(@NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        if (isInitialized) {
            HashMap hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(EVENT_ACTION_KEY, str));
            hashMapOf.putAll(map);
            PerseusApp.execute(hashMapOf);
            return;
        }
        throw new UninitializedException("Perseus SDK needs to be initialized first");
    }

    @JvmStatic
    public static final void setAdjustId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "adjustId");
        PerseusApp.setAdjustId(str);
    }

    @JvmStatic
    public static final void setAdvertisingId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, ConstantsKt.GOOGLE_AD_ID);
        PerseusApp.setAdvertisingId(str);
    }

    @JvmStatic
    public static final void setCountry(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "countryIsoCode");
        PerseusApp.setCountryCode(str);
    }

    @JvmStatic
    public static final void setGlobalEntityId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID);
        PerseusApp.setGlobalEntityId(str);
    }

    @JvmStatic
    public static final void setUserId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "userId");
        PerseusApp.setUserId(str);
    }

    @JvmStatic
    public static final void updateConfig(@NotNull PerseusConfig perseusConfig) {
        Intrinsics.checkNotNullParameter(perseusConfig, "perseusConfig");
        if (isInitialized) {
            PerseusApp.updateConfig(MappersKt.convert(perseusConfig));
            return;
        }
        throw new UninitializedException("Perseus SDK needs to be initialized first");
    }

    private final void updateConfigFields(PerseusConfig perseusConfig) {
        boolean z11;
        boolean z12;
        boolean z13 = true;
        if (perseusConfig.getUserId().length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            PerseusApp.setUserId(perseusConfig.getUserId());
        }
        if (perseusConfig.getAdjustId().length() > 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            PerseusApp.setUserId(perseusConfig.getAdjustId());
        }
        if (perseusConfig.getAdvertisingId().length() <= 0) {
            z13 = false;
        }
        if (z13) {
            PerseusApp.setAdvertisingId(perseusConfig.getAdvertisingId());
        }
    }

    public final boolean isInitialized$perseus_analytics_release() {
        return isInitialized;
    }

    public final void setInitialized$perseus_analytics_release(boolean z11) {
        isInitialized = z11;
    }
}
