package com.talabat.core.tracking.data.platform.impl;

import android.content.Context;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.perseus.domain.TalabatPerseusRepository;
import com.talabat.core.tracking.data.platform.TrackingPlatform;
import com.talabat.core.tracking.domain.CommonAttributes;
import com.talabat.core.tracking.domain.perseus.PerseusEventTools;
import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00102\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00112\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/talabat/core/tracking/data/platform/impl/PerseusTrackingPlatform;", "Lcom/talabat/core/tracking/data/platform/TrackingPlatform;", "context", "Landroid/content/Context;", "commonAttributes", "Lcom/talabat/core/tracking/domain/CommonAttributes;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "perseusEventTools", "Lcom/talabat/core/tracking/domain/perseus/PerseusEventTools;", "perseusRepository", "Lcom/talabat/core/perseus/domain/TalabatPerseusRepository;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Landroid/content/Context;Lcom/talabat/core/tracking/domain/CommonAttributes;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/core/tracking/domain/perseus/PerseusEventTools;Lcom/talabat/core/perseus/domain/TalabatPerseusRepository;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "getCommonAttributes", "", "", "", "eventName", "track", "", "attributes", "Companion", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PerseusTrackingPlatform implements TrackingPlatform {
    @NotNull
    private static final String APP_ID = "com.talabat";
    @NotNull
    private static final String APP_NAME = "Talabat";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String ENTITY = "talabat";
    @NotNull
    private static final String PERSEUS_PROD_URL = "https://perseus-productanalytics.deliveryhero.net/";
    @NotNull
    private static final String PERSEUS_STAGING_URL = "https://stg-perseus-productanalytics.deliveryhero.net/";
    @NotNull
    private static final String TALABAT_LIVE_UAID = "UA-60087342-6";
    @NotNull
    private static final String TALABAT_STAGING_UAID = "UA-60087342-12";
    @NotNull
    private final CommonAttributes commonAttributes;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final PerseusEventTools perseusEventTools;
    @NotNull
    private final TalabatPerseusRepository perseusRepository;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/tracking/data/platform/impl/PerseusTrackingPlatform$Companion;", "", "()V", "APP_ID", "", "APP_NAME", "ENTITY", "PERSEUS_PROD_URL", "PERSEUS_STAGING_URL", "TALABAT_LIVE_UAID", "TALABAT_STAGING_UAID", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public PerseusTrackingPlatform(@NotNull Context context, @NotNull CommonAttributes commonAttributes2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull PerseusEventTools perseusEventTools2, @NotNull TalabatPerseusRepository talabatPerseusRepository, @NotNull IObservabilityManager iObservabilityManager) {
        String str;
        String str2;
        CommonAttributes commonAttributes3 = commonAttributes2;
        ConfigurationLocalRepository configurationLocalRepository3 = configurationLocalRepository2;
        PerseusEventTools perseusEventTools3 = perseusEventTools2;
        TalabatPerseusRepository talabatPerseusRepository2 = talabatPerseusRepository;
        IObservabilityManager iObservabilityManager2 = iObservabilityManager;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(commonAttributes3, "commonAttributes");
        Intrinsics.checkNotNullParameter(configurationLocalRepository3, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(perseusEventTools3, "perseusEventTools");
        Intrinsics.checkNotNullParameter(talabatPerseusRepository2, "perseusRepository");
        Intrinsics.checkNotNullParameter(iObservabilityManager2, "observabilityManager");
        this.commonAttributes = commonAttributes3;
        this.configurationLocalRepository = configurationLocalRepository3;
        this.perseusEventTools = perseusEventTools3;
        this.perseusRepository = talabatPerseusRepository2;
        this.observabilityManager = iObservabilityManager2;
        String appVersion = commonAttributes2.getAppVersion();
        boolean z11 = !commonAttributes2.isProdBuild();
        if (commonAttributes2.isProdBuild()) {
            str = PERSEUS_PROD_URL;
        } else {
            str = PERSEUS_STAGING_URL;
        }
        if (commonAttributes2.isProdBuild()) {
            str2 = "UA-60087342-6";
        } else {
            str2 = "UA-60087342-12";
        }
        talabatPerseusRepository.configurePerseus("Talabat", "com.talabat", "talabat", appVersion, z11, str, str2, commonAttributes2.getGoogleAdId(), commonAttributes2.getAdId(), configurationLocalRepository2.selectedCountry(), commonAttributes2.getCustomerCode(), context);
    }

    @NotNull
    public Map<String, Object> getCommonAttributes(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        return this.perseusEventTools.addPerseusParams(str, (Map<String, String>) new LinkedHashMap());
    }

    public void track(@NotNull String str, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(map, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        this.perseusRepository.setUserId(this.commonAttributes.getCustomerCode());
        this.perseusRepository.setAdjustId(this.commonAttributes.getAdId());
        this.perseusRepository.setCountry(this.configurationLocalRepository.selectedCountry());
        this.perseusRepository.setAdvertisingId(this.commonAttributes.getGoogleAdId());
        String adaptEventName = this.perseusEventTools.adaptEventName(str, map);
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), String.valueOf(entry.getValue()));
        }
        Map mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap);
        this.perseusEventTools.addPerseusParams(str, (Map<String, String>) mutableMap);
        this.perseusRepository.sendEvent(adaptEventName, mutableMap);
    }
}
