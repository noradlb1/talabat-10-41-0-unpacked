package com.talabat.gem.integration;

import android.app.Application;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.gem.GemCoreIntegrator;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.adapters.analytics.GemAnalytics;
import com.talabat.gem.adapters.analytics.GemPageTypeScannerKt;
import com.talabat.gem.adapters.data.GemDataSources;
import com.talabat.gem.adapters.flags.GemFeatureFlags;
import com.talabat.gem.adapters.logger.GemLogger;
import com.talabat.talabatcommon.adapters.special.item.SpecialItemRecyclerViewIntegrationKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/talabat/gem/GemCoreIntegrator;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class Gem$GemIntegration$1 extends Lambda implements Function1<GemCoreIntegrator, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Application f60467g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ TrackingCoreLibApi f60468h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FeatureFlagCoreLibApi f60469i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ConfigurationRemoteCoreLibApi f60470j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ NavigationCoreLibApi f60471k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Gem$GemIntegration$1(Application application, TrackingCoreLibApi trackingCoreLibApi, FeatureFlagCoreLibApi featureFlagCoreLibApi, ConfigurationRemoteCoreLibApi configurationRemoteCoreLibApi, NavigationCoreLibApi navigationCoreLibApi) {
        super(1);
        this.f60467g = application;
        this.f60468h = trackingCoreLibApi;
        this.f60469i = featureFlagCoreLibApi;
        this.f60470j = configurationRemoteCoreLibApi;
        this.f60471k = navigationCoreLibApi;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GemCoreIntegrator) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GemCoreIntegrator gemCoreIntegrator) {
        Intrinsics.checkNotNullParameter(gemCoreIntegrator, "$this$GemCoreIntegration");
        IntegrationKt.logger(IntegrationKt.getSet(gemCoreIntegrator), GemLogger.INSTANCE);
        IntegrationKt.dataSources(IntegrationKt.getSet(gemCoreIntegrator), new GemDataSources(Gem.getAppContext()));
        IntegrationKt.analytics(IntegrationKt.getSet(gemCoreIntegrator), new GemAnalytics(Gem.getAppContext(), GemPageTypeScannerKt.GemPageTypeScanner(this.f60467g), this.f60468h.getTalabatTracker()));
        IntegrationKt.featureFlags(IntegrationKt.getSet(gemCoreIntegrator), new GemFeatureFlags(this.f60469i.getTalabatFeatureFlag()));
        IntegrationKt.locationConfig(IntegrationKt.getSet(gemCoreIntegrator), this.f60470j.getLocationConfigurationRepository());
        IntegrationKt.navigator(IntegrationKt.getSet(gemCoreIntegrator), this.f60471k.getNavigator());
        SpecialItemRecyclerViewIntegrationKt.SpecialItemRecyclerView(this.f60467g, AnonymousClass1.INSTANCE);
    }
}
