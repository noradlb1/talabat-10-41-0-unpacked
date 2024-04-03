package com.talabat.feature.tpro.presentation.di;

import android.content.Context;
import android.content.res.Resources;
import buisnessmodels.Customer;
import buisnessmodels.TalabatFormatter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsRemoteConfigurationsKeys;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.tpro.presentation.model.mapper.TProMapperUtility;
import com.talabat.feature.tpro.presentation.model.mapper.TProMultiPlanDisplayModelMapper;
import com.talabat.feature.tpro.presentation.model.mapper.TProPlanDisplayModelMapper;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0012\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0007J\u0012\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\b\u0010\u0017\u001a\u00020\u0014H\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0007J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0007J\b\u0010\u001d\u001a\u00020\u001eH\u0007J\b\u0010\u001f\u001a\u00020 H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/talabat/feature/tpro/presentation/di/TproPresentationModule;", "", "()V", "COUNTRY_ID", "", "IS_BRAND_UPDATES_ENABLED", "IS_TPRO_COFFEE_ENABLED", "IS_TPRO_MULTIPLAN_FLOW_ENABLED", "TPRO_MULTIPLAN_DURATIONS", "provideCountryId", "", "customerLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "provideGlideRequest", "Lcom/bumptech/glide/RequestManager;", "context", "Landroid/content/Context;", "provideResources", "Landroid/content/res/Resources;", "provideTProIsBrandUpdatesEnabled", "", "flagsRepository", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "provideTProIsCoffeeEnabled", "provideTProMultiPlanDisplayModelMapper", "Lcom/talabat/feature/tpro/presentation/model/mapper/TProMultiPlanDisplayModelMapper;", "provideTProMultiPlanDurations", "provideTProPlanDisplayModelMapper", "Lcom/talabat/feature/tpro/presentation/model/mapper/TProPlanDisplayModelMapper;", "provideTalabatFormatter", "Lbuisnessmodels/TalabatFormatter;", "provideTalabatRemoteConfig", "Lcom/talabat/talabatremoteconfiguration/RemoteConfiguration;", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public final class TproPresentationModule {
    @NotNull
    public static final String COUNTRY_ID = "countryId";
    @NotNull
    public static final TproPresentationModule INSTANCE = new TproPresentationModule();
    @NotNull
    public static final String IS_BRAND_UPDATES_ENABLED = "isBrandUpdatesEnabled";
    @NotNull
    public static final String IS_TPRO_COFFEE_ENABLED = "isTproCoffeeEnabled";
    @NotNull
    public static final String IS_TPRO_MULTIPLAN_FLOW_ENABLED = "isTproMultiplanFlowEnabled";
    @NotNull
    public static final String TPRO_MULTIPLAN_DURATIONS = "tProMultiPlanDurations";

    private TproPresentationModule() {
    }

    @Provides
    @Named("countryId")
    public final int provideCountryId(@NotNull ConfigurationLocalRepository configurationLocalRepository) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository, "customerLocalRepository");
        return configurationLocalRepository.selectedCountry().getPhoneCodeISO3166();
    }

    @NotNull
    @Provides
    public final RequestManager provideGlideRequest(@NotNull @Named("context") Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        RequestManager with = Glide.with(context);
        Intrinsics.checkNotNullExpressionValue(with, "with(context)");
        return with;
    }

    @NotNull
    @Provides
    public final Resources provideResources(@NotNull @Named("context") Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        return resources;
    }

    @Provides
    @Named("isBrandUpdatesEnabled")
    public final boolean provideTProIsBrandUpdatesEnabled(@NotNull ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionsFeatureFlagsRepository, "flagsRepository");
        return iSubscriptionsFeatureFlagsRepository.isNewBrandEnabled();
    }

    @Provides
    @Named("isTproCoffeeEnabled")
    public final boolean provideTProIsCoffeeEnabled() {
        Boolean isFreeCoffeeEligible = Customer.getInstance().isFreeCoffeeEligible();
        Intrinsics.checkNotNullExpressionValue(isFreeCoffeeEligible, "getInstance().isFreeCoffeeEligible");
        return isFreeCoffeeEligible.booleanValue();
    }

    @NotNull
    @Provides
    public final TProMultiPlanDisplayModelMapper provideTProMultiPlanDisplayModelMapper() {
        return new TProMultiPlanDisplayModelMapper(new TProMapperUtility());
    }

    @Nullable
    @Provides
    @Named("tProMultiPlanDurations")
    public final String provideTProMultiPlanDurations() {
        String str = (String) RemoteConfiguration.INSTANCE.getRemoteConfiguration(EcosystemsRemoteConfigurationsKeys.TPRO_MULTI_PLAN_DURATION_CONFIG, "", String.class);
        if (str == null) {
            return null;
        }
        if (StringsKt__StringsJVMKt.isBlank(str)) {
            str = null;
        }
        return str;
    }

    @NotNull
    @Provides
    public final TProPlanDisplayModelMapper provideTProPlanDisplayModelMapper() {
        return new TProPlanDisplayModelMapper(new TProMapperUtility());
    }

    @NotNull
    @Provides
    public final TalabatFormatter provideTalabatFormatter() {
        TalabatFormatter instance = TalabatFormatter.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }

    @NotNull
    @Provides
    public final RemoteConfiguration provideTalabatRemoteConfig() {
        return RemoteConfiguration.INSTANCE;
    }
}
