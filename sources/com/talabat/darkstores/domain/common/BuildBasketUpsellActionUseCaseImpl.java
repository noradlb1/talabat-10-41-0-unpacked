package com.talabat.darkstores.domain.common;

import com.talabat.darkstores.domain.basket.IsBasketUpsellBottomSheetShownUseCase;
import com.talabat.darkstores.domain.basket.IsBasketUpsellExperimentEnabledUseCase;
import com.talabat.feature.foodcart2.data.datasources.FoodCartFlutterDataSourceImpl;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.BasketUpsellRoute;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qi.h;
import qi.i;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ?\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u000b0\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/darkstores/domain/common/BuildBasketUpsellActionUseCaseImpl;", "Lcom/talabat/darkstores/domain/common/BuildBasketUpsellActionUseCase;", "isBasketUpsellEnabled", "Lcom/talabat/darkstores/domain/basket/IsBasketUpsellExperimentEnabledUseCase;", "isBasketUpsellBottomSheetShown", "Lcom/talabat/darkstores/domain/basket/IsBasketUpsellBottomSheetShownUseCase;", "getFlutterConfigurationParams", "Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCase;", "(Lcom/talabat/darkstores/domain/basket/IsBasketUpsellExperimentEnabledUseCase;Lcom/talabat/darkstores/domain/basket/IsBasketUpsellBottomSheetShownUseCase;Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCase;)V", "invoke", "Lio/reactivex/Single;", "", "cartId", "", "navigateToFlutterBottomSheet", "Lkotlin/Function2;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "navigateToCheckout", "Lkotlin/Function0;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BuildBasketUpsellActionUseCaseImpl implements BuildBasketUpsellActionUseCase {
    @NotNull
    private final GetFlutterConfigurationParamsUseCase getFlutterConfigurationParams;
    @NotNull
    private final IsBasketUpsellBottomSheetShownUseCase isBasketUpsellBottomSheetShown;
    @NotNull
    private final IsBasketUpsellExperimentEnabledUseCase isBasketUpsellEnabled;

    @Inject
    public BuildBasketUpsellActionUseCaseImpl(@NotNull IsBasketUpsellExperimentEnabledUseCase isBasketUpsellExperimentEnabledUseCase, @NotNull IsBasketUpsellBottomSheetShownUseCase isBasketUpsellBottomSheetShownUseCase, @NotNull GetFlutterConfigurationParamsUseCase getFlutterConfigurationParamsUseCase) {
        Intrinsics.checkNotNullParameter(isBasketUpsellExperimentEnabledUseCase, "isBasketUpsellEnabled");
        Intrinsics.checkNotNullParameter(isBasketUpsellBottomSheetShownUseCase, "isBasketUpsellBottomSheetShown");
        Intrinsics.checkNotNullParameter(getFlutterConfigurationParamsUseCase, "getFlutterConfigurationParams");
        this.isBasketUpsellEnabled = isBasketUpsellExperimentEnabledUseCase;
        this.isBasketUpsellBottomSheetShown = isBasketUpsellBottomSheetShownUseCase;
        this.getFlutterConfigurationParams = getFlutterConfigurationParamsUseCase;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final Unit m9751invoke$lambda0(Function2 function2, FlutterConfigurationParams flutterConfigurationParams) {
        Intrinsics.checkNotNullParameter(function2, "$navigateToFlutterBottomSheet");
        Intrinsics.checkNotNullParameter(flutterConfigurationParams, "$configurationParams");
        function2.invoke(flutterConfigurationParams, new BasketUpsellRoute(flutterConfigurationParams.getVendorCode()));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final Unit m9752invoke$lambda1(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$navigateToCheckout");
        function0.invoke();
        return Unit.INSTANCE;
    }

    @NotNull
    public Single<Unit> invoke(@NotNull String str, @NotNull Function2<? super FlutterConfigurationParams, ? super FlutterRoute, Unit> function2, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, FoodCartFlutterDataSourceImpl.cartIdKey);
        Intrinsics.checkNotNullParameter(function2, "navigateToFlutterBottomSheet");
        Intrinsics.checkNotNullParameter(function0, "navigateToCheckout");
        if (this.isBasketUpsellBottomSheetShown.invoke(str) || !this.isBasketUpsellEnabled.invoke()) {
            Single<Unit> fromCallable = Single.fromCallable(new i(function0));
            Intrinsics.checkNotNullExpressionValue(fromCallable, "{\n            Single.fro…eToCheckout() }\n        }");
            return fromCallable;
        }
        Single<Unit> fromCallable2 = Single.fromCallable(new h(function2, this.getFlutterConfigurationParams.invoke()));
        Intrinsics.checkNotNullExpressionValue(fromCallable2, "{\n            val config…)\n            }\n        }");
        return fromCallable2;
    }
}
