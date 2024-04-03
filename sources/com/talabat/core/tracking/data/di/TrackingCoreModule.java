package com.talabat.core.tracking.data.di;

import android.content.Context;
import com.huawei.hms.analytics.HiAnalyticsInstance;
import com.talabat.adjust.Adjust;
import com.talabat.braze.BrazeTracker;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.gms.base.domain.IsGmsAvailable;
import com.talabat.core.hms.base.domain.IsHmsAvailable;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.perseus.domain.TalabatPerseusRepository;
import com.talabat.core.tracking.data.TalabatTrackerImpl;
import com.talabat.core.tracking.data.common.CommonAttributesImpl;
import com.talabat.core.tracking.data.common.DefaultTestingUtils;
import com.talabat.core.tracking.data.platform.impl.AdjustTrackingPlatform;
import com.talabat.core.tracking.data.platform.impl.BrazeTrackingPlatform;
import com.talabat.core.tracking.data.platform.impl.GoogleAnalyticsTrackingPlatform;
import com.talabat.core.tracking.data.platform.impl.HiAnalyticsTrackingPlatform;
import com.talabat.core.tracking.data.platform.impl.NewRelicTrackingPlatform;
import com.talabat.core.tracking.data.platform.impl.PerseusTrackingPlatform;
import com.talabat.core.tracking.domain.AnalyticsType;
import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.migration.FlutterMigrationTools;
import com.talabat.core.tracking.domain.perseus.PerseusEventTools;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.firebase.Firebase;
import com.talabat.newrelic.NewRelic;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0002J \u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000bH\u0002J0\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002JH\u0010\u001f\u001a\u00020 2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007¨\u0006#"}, d2 = {"Lcom/talabat/core/tracking/data/di/TrackingCoreModule;", "", "()V", "analyticsType", "Lcom/talabat/core/tracking/domain/AnalyticsType;", "isGmsAvailable", "", "isHmsAvailable", "getAppVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "context", "Landroid/content/Context;", "getConfigurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "initAdjustTrackingPlatform", "Lcom/talabat/core/tracking/data/platform/impl/AdjustTrackingPlatform;", "initGoogleAnalyticsTrackingPlatform", "Lcom/talabat/core/tracking/data/platform/impl/GoogleAnalyticsTrackingPlatform;", "migrationTools", "Lcom/talabat/core/tracking/domain/migration/FlutterMigrationTools;", "perseusRepository", "Lcom/talabat/core/perseus/domain/TalabatPerseusRepository;", "initHiAnalyticsTrackingPlatform", "Lcom/talabat/core/tracking/data/platform/impl/HiAnalyticsTrackingPlatform;", "initPerseusTrackingPlatform", "Lcom/talabat/core/tracking/data/platform/impl/PerseusTrackingPlatform;", "configurationLocalRepository", "perseusEventTools", "Lcom/talabat/core/tracking/domain/perseus/PerseusEventTools;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "provideTalabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "talabatFeatureFlags", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class TrackingCoreModule {
    @NotNull
    public static final TrackingCoreModule INSTANCE = new TrackingCoreModule();

    private TrackingCoreModule() {
    }

    private final AppVersionProvider getAppVersionProvider(Context context) {
        return ((ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer(context).getFeature(ConfigurationRemoteCoreLibApi.class)).getAppVersionProvider();
    }

    private final ConfigurationLocalRepository getConfigurationLocalRepository(Context context) {
        return ((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer(context).getFeature(ConfigurationLocalCoreLibApi.class)).getRepository();
    }

    private final AdjustTrackingPlatform initAdjustTrackingPlatform(Context context) {
        return new AdjustTrackingPlatform(context, new CommonAttributesImpl(getAppVersionProvider(context), getConfigurationLocalRepository(context)), (Adjust) null, 4, (DefaultConstructorMarker) null);
    }

    private final GoogleAnalyticsTrackingPlatform initGoogleAnalyticsTrackingPlatform(Context context, FlutterMigrationTools flutterMigrationTools, TalabatPerseusRepository talabatPerseusRepository) {
        return new GoogleAnalyticsTrackingPlatform(context, new CommonAttributesImpl(getAppVersionProvider(context), getConfigurationLocalRepository(context)), new DefaultTestingUtils(), (Firebase) null, flutterMigrationTools, talabatPerseusRepository, 8, (DefaultConstructorMarker) null);
    }

    private final HiAnalyticsTrackingPlatform initHiAnalyticsTrackingPlatform(Context context) {
        return new HiAnalyticsTrackingPlatform(context, new CommonAttributesImpl(getAppVersionProvider(context), getConfigurationLocalRepository(context)), new DefaultTestingUtils(), (HiAnalyticsInstance) null, 8, (DefaultConstructorMarker) null);
    }

    private final PerseusTrackingPlatform initPerseusTrackingPlatform(ConfigurationLocalRepository configurationLocalRepository, Context context, PerseusEventTools perseusEventTools, IObservabilityManager iObservabilityManager, TalabatPerseusRepository talabatPerseusRepository) {
        return new PerseusTrackingPlatform(context, new CommonAttributesImpl(getAppVersionProvider(context), getConfigurationLocalRepository(context)), configurationLocalRepository, perseusEventTools, talabatPerseusRepository, iObservabilityManager);
    }

    @NotNull
    @Reusable
    @Provides
    public final AnalyticsType analyticsType(@IsGmsAvailable boolean z11, @IsHmsAvailable boolean z12) {
        if (!z12 || z11) {
            return AnalyticsType.GOOGLE;
        }
        return AnalyticsType.HUAWEI;
    }

    @NotNull
    @Reusable
    @Provides
    public final TalabatTracker provideTalabatTracker(@NotNull Context context, @NotNull AnalyticsType analyticsType, @NotNull IObservabilityManager iObservabilityManager, @NotNull PerseusEventTools perseusEventTools, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull TalabatPerseusRepository talabatPerseusRepository, @NotNull ConfigurationLocalRepository configurationLocalRepository, @NotNull FlutterMigrationTools flutterMigrationTools) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(analyticsType, "analyticsType");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(perseusEventTools, "perseusEventTools");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlags");
        Intrinsics.checkNotNullParameter(talabatPerseusRepository, "perseusRepository");
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(flutterMigrationTools, "migrationTools");
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to(PlatformName.NEW_RELIC, new NewRelicTrackingPlatform((NewRelic) null, 1, (DefaultConstructorMarker) null));
        PlatformName platformName = PlatformName.GOOGLE_ANALYTICS;
        if (analyticsType == AnalyticsType.HUAWEI) {
            obj = initHiAnalyticsTrackingPlatform(context);
        } else {
            obj = initGoogleAnalyticsTrackingPlatform(context, flutterMigrationTools, talabatPerseusRepository);
        }
        pairArr[1] = TuplesKt.to(platformName, obj);
        pairArr[2] = TuplesKt.to(PlatformName.BRAZE, new BrazeTrackingPlatform(context, (BrazeTracker) null, 2, (DefaultConstructorMarker) null));
        pairArr[3] = TuplesKt.to(PlatformName.ADJUST, initAdjustTrackingPlatform(context));
        Map mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        mutableMapOf.put(PlatformName.PERSEUS, initPerseusTrackingPlatform(configurationLocalRepository, context, perseusEventTools, iObservabilityManager, talabatPerseusRepository));
        return new TalabatTrackerImpl(mutableMapOf);
    }
}
