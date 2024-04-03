package com.talabat.core.fwf.data.config;

import android.content.Context;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.fwf.data.FunWithFlags;
import com.talabat.core.fwf.data.FunWithFlagsIntegratorKt;
import com.talabat.core.fwf.domain.FunWithFlagsObservabilityPort;
import com.talabat.core.fwf.domain.FunWithFlagsTrackingPort;
import com.talabat.core.fwf.domain.config.FunWithFlagsConfig;
import com.talabat.core.fwf.domain.config.IFWFManager;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFProject;
import com.talabat.core.fwfprojectskeys.domain.projects.adex.AdExFwfProject;
import com.talabat.core.fwfprojectskeys.domain.projects.deafult.DefaultFwfProject;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsFwfProject;
import com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageFwfProject;
import com.talabat.core.fwfprojectskeys.domain.projects.killswitch.KillSwitchFwfProject;
import com.talabat.core.fwfprojectskeys.domain.projects.menu.MenuFwfProject;
import com.talabat.core.fwfprojectskeys.domain.projects.ordering.OrderingFwfProject;
import com.talabat.core.fwfprojectskeys.domain.projects.platform.PlatformFwfProject;
import com.talabat.core.fwfprojectskeys.domain.projects.poe.PoeFwfProject;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QCommerceFwfProject;
import com.talabat.core.fwfprojectskeys.domain.projects.search.SearchFwfProject;
import com.talabat.core.fwfprojectskeys.domain.projects.user.UserFwfProject;
import com.talabat.core.fwfprojectskeys.domain.projects.vendorlist.VendorListFwfProject;
import com.talabat.core.gms.base.domain.IsGmsAvailable;
import com.talabat.secrets.Secrets;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJS\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/core/fwf/data/config/FWFManagerImpl;", "Lcom/talabat/core/fwf/domain/config/IFWFManager;", "context", "Landroid/content/Context;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "hasGoogleServices", "", "(Landroid/content/Context;Lcom/talabat/configuration/ConfigurationLocalRepository;Z)V", "initialize", "", "customerEmail", "", "customerId", "googleClientId", "featuresKeys", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "observability", "Lcom/talabat/core/fwf/domain/FunWithFlagsObservabilityPort;", "tracker", "Lcom/talabat/core/fwf/domain/FunWithFlagsTrackingPort;", "onFlagsFetched", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;Lcom/talabat/core/fwf/domain/FunWithFlagsObservabilityPort;Lcom/talabat/core/fwf/domain/FunWithFlagsTrackingPort;Lkotlin/jvm/functions/Function0;)V", "com_talabat_core_fwf_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FWFManagerImpl implements IFWFManager {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final Context context;
    private final boolean hasGoogleServices;

    @Inject
    public FWFManagerImpl(@NotNull Context context2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @IsGmsAvailable boolean z11) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.context = context2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.hasGoogleServices = z11;
    }

    public void initialize(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull FWFKey[] fWFKeyArr, @NotNull FunWithFlagsObservabilityPort funWithFlagsObservabilityPort, @NotNull FunWithFlagsTrackingPort funWithFlagsTrackingPort, @Nullable Function0<Unit> function0) {
        FunWithFlagsObservabilityPort funWithFlagsObservabilityPort2 = funWithFlagsObservabilityPort;
        FunWithFlagsTrackingPort funWithFlagsTrackingPort2 = funWithFlagsTrackingPort;
        Intrinsics.checkNotNullParameter(str, "customerEmail");
        Intrinsics.checkNotNullParameter(str2, "customerId");
        String str4 = str3;
        Intrinsics.checkNotNullParameter(str4, "googleClientId");
        Intrinsics.checkNotNullParameter(fWFKeyArr, "featuresKeys");
        Intrinsics.checkNotNullParameter(funWithFlagsObservabilityPort2, "observability");
        Intrinsics.checkNotNullParameter(funWithFlagsTrackingPort2, "tracker");
        FunWithFlagsConfig funWithFlagsConfig = new FunWithFlagsConfig(str, str2, str4, new FWFProject[]{new DefaultFwfProject(), new HomePageFwfProject(), new VendorListFwfProject(), new SearchFwfProject(), new MenuFwfProject(), new OrderingFwfProject(), new QCommerceFwfProject(), new PoeFwfProject(), new EcosystemsFwfProject(), new UserFwfProject(), new AdExFwfProject(), new KillSwitchFwfProject(), new PlatformFwfProject()}, this.configurationLocalRepository.selectedCountry(), this.configurationLocalRepository.selectedLanguage().getLanguageCode(), this.hasGoogleServices);
        FunWithFlagsIntegratorKt.FunWithFlagsIntegration(new FWFManagerImpl$initialize$1(funWithFlagsObservabilityPort2, funWithFlagsTrackingPort2));
        FunWithFlags.setup$default(FunWithFlags.INSTANCE, this.context, funWithFlagsConfig, fWFKeyArr, (Secrets) null, function0, 8, (Object) null);
    }
}
