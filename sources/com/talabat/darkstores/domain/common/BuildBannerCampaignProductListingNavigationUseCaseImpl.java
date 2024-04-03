package com.talabat.darkstores.domain.common;

import androidx.navigation.NavDirections;
import com.talabat.darkstores.domain.banner.IsFlutterBannerProductListingEnabledUseCase;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.BannerCampaignProductListingRoute;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qi.f;
import qi.g;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JT\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\r2!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\t0\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/domain/common/BuildBannerCampaignProductListingNavigationUseCaseImpl;", "Lcom/talabat/darkstores/domain/common/BuildBannerCampaignProductListingNavigationUseCase;", "isFlutterBannerProductListingEnabled", "Lcom/talabat/darkstores/domain/banner/IsFlutterBannerProductListingEnabledUseCase;", "getFlutterConfigurationParams", "Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCase;", "(Lcom/talabat/darkstores/domain/banner/IsFlutterBannerProductListingEnabledUseCase;Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCase;)V", "invoke", "Lio/reactivex/Single;", "Landroidx/navigation/NavDirections;", "campaignId", "", "buildFlutterAction", "Lkotlin/Function2;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "buildNativeAction", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bannerId", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BuildBannerCampaignProductListingNavigationUseCaseImpl implements BuildBannerCampaignProductListingNavigationUseCase {
    @NotNull
    private final GetFlutterConfigurationParamsUseCase getFlutterConfigurationParams;
    @NotNull
    private final IsFlutterBannerProductListingEnabledUseCase isFlutterBannerProductListingEnabled;

    @Inject
    public BuildBannerCampaignProductListingNavigationUseCaseImpl(@NotNull IsFlutterBannerProductListingEnabledUseCase isFlutterBannerProductListingEnabledUseCase, @NotNull GetFlutterConfigurationParamsUseCase getFlutterConfigurationParamsUseCase) {
        Intrinsics.checkNotNullParameter(isFlutterBannerProductListingEnabledUseCase, "isFlutterBannerProductListingEnabled");
        Intrinsics.checkNotNullParameter(getFlutterConfigurationParamsUseCase, "getFlutterConfigurationParams");
        this.isFlutterBannerProductListingEnabled = isFlutterBannerProductListingEnabledUseCase;
        this.getFlutterConfigurationParams = getFlutterConfigurationParamsUseCase;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final NavDirections m9749invoke$lambda0(Function2 function2, FlutterConfigurationParams flutterConfigurationParams, String str) {
        Intrinsics.checkNotNullParameter(function2, "$buildFlutterAction");
        Intrinsics.checkNotNullParameter(flutterConfigurationParams, "$configurationParams");
        Intrinsics.checkNotNullParameter(str, "$campaignId");
        return (NavDirections) function2.invoke(flutterConfigurationParams, new BannerCampaignProductListingRoute(flutterConfigurationParams.getVendorCode(), str, false, 4, (DefaultConstructorMarker) null));
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final NavDirections m9750invoke$lambda1(Function1 function1, String str) {
        Intrinsics.checkNotNullParameter(function1, "$buildNativeAction");
        Intrinsics.checkNotNullParameter(str, "$campaignId");
        return (NavDirections) function1.invoke(str);
    }

    @NotNull
    public Single<NavDirections> invoke(@NotNull String str, @NotNull Function2<? super FlutterConfigurationParams, ? super FlutterRoute, ? extends NavDirections> function2, @NotNull Function1<? super String, ? extends NavDirections> function1) {
        Intrinsics.checkNotNullParameter(str, "campaignId");
        Intrinsics.checkNotNullParameter(function2, "buildFlutterAction");
        Intrinsics.checkNotNullParameter(function1, "buildNativeAction");
        if (this.isFlutterBannerProductListingEnabled.invoke()) {
            Single<NavDirections> fromCallable = Single.fromCallable(new f(function2, this.getFlutterConfigurationParams.invoke(), str));
            Intrinsics.checkNotNullExpressionValue(fromCallable, "{\n            val config…)\n            }\n        }");
            return fromCallable;
        }
        Single<NavDirections> fromCallable2 = Single.fromCallable(new g(function1, str));
        Intrinsics.checkNotNullExpressionValue(fromCallable2, "{\n            Single.fro…n(campaignId) }\n        }");
        return fromCallable2;
    }
}
