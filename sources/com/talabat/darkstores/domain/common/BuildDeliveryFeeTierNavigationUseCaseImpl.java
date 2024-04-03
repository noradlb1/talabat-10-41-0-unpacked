package com.talabat.darkstores.domain.common;

import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.DeliveryFeeTiersRoute;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qi.p;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/darkstores/domain/common/BuildDeliveryFeeTierNavigationUseCaseImpl;", "Lcom/talabat/darkstores/domain/common/BuildDeliveryFeeTierNavigationUseCase;", "getFlutterConfigurationParams", "Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCase;", "(Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCase;)V", "invoke", "Lio/reactivex/Single;", "", "buildFlutterActionWithRoute", "Lkotlin/Function2;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BuildDeliveryFeeTierNavigationUseCaseImpl implements BuildDeliveryFeeTierNavigationUseCase {
    @NotNull
    private final GetFlutterConfigurationParamsUseCase getFlutterConfigurationParams;

    @Inject
    public BuildDeliveryFeeTierNavigationUseCaseImpl(@NotNull GetFlutterConfigurationParamsUseCase getFlutterConfigurationParamsUseCase) {
        Intrinsics.checkNotNullParameter(getFlutterConfigurationParamsUseCase, "getFlutterConfigurationParams");
        this.getFlutterConfigurationParams = getFlutterConfigurationParamsUseCase;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final Unit m9759invoke$lambda0(Function2 function2, FlutterConfigurationParams flutterConfigurationParams) {
        Intrinsics.checkNotNullParameter(function2, "$buildFlutterActionWithRoute");
        Intrinsics.checkNotNullParameter(flutterConfigurationParams, "$configurationParams");
        function2.invoke(flutterConfigurationParams, new DeliveryFeeTiersRoute(flutterConfigurationParams.getVendorCode()));
        return Unit.INSTANCE;
    }

    @NotNull
    public Single<Unit> invoke(@NotNull Function2<? super FlutterConfigurationParams, ? super FlutterRoute, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "buildFlutterActionWithRoute");
        Single<Unit> fromCallable = Single.fromCallable(new p(function2, this.getFlutterConfigurationParams.invoke()));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "fromCallable {\n         …)\n            )\n        }");
        return fromCallable;
    }
}
