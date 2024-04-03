package com.talabat.core.tracking.data.migration;

import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.newrelic.agent.android.agentdata.HexAttribute;
import com.talabat.core.fwf.data.FunWithFlags;
import com.talabat.core.fwfprojectskeys.domain.projects.platform.PlatformRemoteConfigurationsKeys;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.tracking.domain.migration.FlutterMigrationTools;
import com.talabat.talabatremoteconfiguration.datasource.IRemoteConfigurationDataSource;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J8\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\rH\u0016J,\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100\bH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J&\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\t2\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00100\rH\u0016J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J4\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00100\r2\u0006\u0010\u000b\u001a\u00020\t2\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00100\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/core/tracking/data/migration/DefaultFlutterMigrationTools;", "Lcom/talabat/core/tracking/domain/migration/FlutterMigrationTools;", "observability", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "remoteConfig", "Lcom/talabat/talabatremoteconfiguration/datasource/IRemoteConfigurationDataSource;", "(Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;Lcom/talabat/talabatremoteconfiguration/datasource/IRemoteConfigurationDataSource;)V", "addMigrationParameters", "", "", "methodName", "eventName", "input", "", "", "props", "", "getProductionValidationConfig", "Lcom/talabat/core/tracking/data/migration/TrackingProductionEventsValidation;", "logGaEvent", "params", "Landroid/os/Bundle;", "removeMigrationParameters", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultFlutterMigrationTools implements FlutterMigrationTools {
    @NotNull
    private final IObservabilityManager observability;
    @NotNull
    private final IRemoteConfigurationDataSource remoteConfig;

    @Inject
    public DefaultFlutterMigrationTools(@NotNull IObservabilityManager iObservabilityManager, @NotNull IRemoteConfigurationDataSource iRemoteConfigurationDataSource) {
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observability");
        Intrinsics.checkNotNullParameter(iRemoteConfigurationDataSource, "remoteConfig");
        this.observability = iObservabilityManager;
        this.remoteConfig = iRemoteConfigurationDataSource;
    }

    private final TrackingProductionEventsValidation getProductionValidationConfig() {
        return (TrackingProductionEventsValidation) this.remoteConfig.getRemoteConfiguration(PlatformRemoteConfigurationsKeys.TRACKING_PRODUCTION_EVENT_VALIDATION, TrackingProductionEventsValidation.Companion.defaultRemoteConfigObject(), TrackingProductionEventsValidation.class);
    }

    /* renamed from: addMigrationParameters  reason: collision with other method in class */
    public void m9612addMigrationParameters(@NotNull String str, @NotNull String str2, @NotNull Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(str, HexAttribute.HEX_ATTR_METHOD_NAME);
        Intrinsics.checkNotNullParameter(str2, "eventName");
        Intrinsics.checkNotNullParameter(map, "props");
        if (!(!getProductionValidationConfig().shouldEventBeValidatedInProduction(str2))) {
            map.put(FunWithFlags.FLUTTER_MIGRATION_VERIFY_KEY, FunWithFlags.FLUTTER_MIGRATION_VERIFY_VALUE);
            map.put("flutter_channel_method", str);
        }
    }

    public void logGaEvent(@NotNull String str, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(bundle, NativeProtocol.WEB_DIALOG_PARAMS);
        TrackingProductionEventsValidation productionValidationConfig = getProductionValidationConfig();
        if (!(!productionValidationConfig.shouldEventBeValidatedInProduction(str)) && productionValidationConfig.getLogToNewRelic() && bundle.getString(FunWithFlags.FLUTTER_MIGRATION_VERIFY_KEY) != null) {
            Map access$convertBundleToMap = DefaultFlutterMigrationToolsKt.convertBundleToMap(bundle);
            access$convertBundleToMap.put("gaEventName", str);
            access$convertBundleToMap.put("android_tracking_way", "legacy");
            this.observability.trackEvent("new_flutter_tracking_validation_event_pushed", "android_tracking_validation_discrepancy_table", (Map<String, String>) access$convertBundleToMap);
        }
    }

    public void removeMigrationParameters(@NotNull String str, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(bundle, NativeProtocol.WEB_DIALOG_PARAMS);
        if (!getProductionValidationConfig().shouldEventBeValidatedInProduction(str)) {
            bundle.remove(FunWithFlags.FLUTTER_MIGRATION_VERIFY_KEY);
        }
        bundle.remove("eventTimestampDifferentiator");
        bundle.remove("flutter_channel_method");
    }

    @NotNull
    public Map<String, String> addMigrationParameters(@NotNull String str, @NotNull String str2, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, HexAttribute.HEX_ATTR_METHOD_NAME);
        Intrinsics.checkNotNullParameter(str2, "eventName");
        Intrinsics.checkNotNullParameter(map, "input");
        Map<String, String> mutableMap = MapsKt__MapsKt.toMutableMap(map);
        if (!getProductionValidationConfig().shouldEventBeValidatedInProduction(str2)) {
            return mutableMap;
        }
        mutableMap.put(FunWithFlags.FLUTTER_MIGRATION_VERIFY_KEY, FunWithFlags.FLUTTER_MIGRATION_VERIFY_VALUE);
        mutableMap.put("flutter_channel_method", str);
        return mutableMap;
    }

    @NotNull
    public Map<String, Object> removeMigrationParameters(@NotNull String str, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        Map<String, Object> mutableMap = MapsKt__MapsKt.toMutableMap(map);
        if (!getProductionValidationConfig().shouldEventBeValidatedInProduction(str)) {
            mutableMap.remove(FunWithFlags.FLUTTER_MIGRATION_VERIFY_KEY);
            return mutableMap;
        }
        mutableMap.remove("eventTimestampDifferentiator");
        mutableMap.remove("flutter_channel_method");
        return mutableMap;
    }

    public void logGaEvent(@NotNull String str, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        TrackingProductionEventsValidation productionValidationConfig = getProductionValidationConfig();
        if (!(!productionValidationConfig.shouldEventBeValidatedInProduction(str)) && productionValidationConfig.getLogToNewRelic() && map.get(FunWithFlags.FLUTTER_MIGRATION_VERIFY_KEY) != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(map.size()));
            for (Map.Entry entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.toString());
            }
            Map mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap);
            mutableMap.put("gaEventName", str);
            mutableMap.put("android_tracking_way", "corelib");
            this.observability.trackEvent("new_flutter_tracking_validation_event_pushed", "android_tracking_validation_discrepancy_table", (Map<String, String>) mutableMap);
        }
    }
}
