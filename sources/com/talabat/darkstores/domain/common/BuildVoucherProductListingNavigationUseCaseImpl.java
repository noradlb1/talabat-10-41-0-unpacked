package com.talabat.darkstores.domain.common;

import androidx.navigation.NavDirections;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.VoucherProductListingRoute;
import com.talabat.talabatcommon.feature.vouchers.loyalty.VoucherUrlConstantsKt;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qi.y;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JA\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/domain/common/BuildVoucherProductListingNavigationUseCaseImpl;", "Lcom/talabat/darkstores/domain/common/BuildVoucherProductListingNavigationUseCase;", "getFlutterConfigurationParams", "Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCase;", "(Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCase;)V", "invoke", "Lio/reactivex/Single;", "Landroidx/navigation/NavDirections;", "voucherId", "", "voucherName", "eventOrigin", "buildFlutterAction", "Lkotlin/Function2;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BuildVoucherProductListingNavigationUseCaseImpl implements BuildVoucherProductListingNavigationUseCase {
    @NotNull
    private final GetFlutterConfigurationParamsUseCase getFlutterConfigurationParams;

    @Inject
    public BuildVoucherProductListingNavigationUseCaseImpl(@NotNull GetFlutterConfigurationParamsUseCase getFlutterConfigurationParamsUseCase) {
        Intrinsics.checkNotNullParameter(getFlutterConfigurationParamsUseCase, "getFlutterConfigurationParams");
        this.getFlutterConfigurationParams = getFlutterConfigurationParamsUseCase;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final NavDirections m9768invoke$lambda0(Function2 function2, FlutterConfigurationParams flutterConfigurationParams, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(function2, "$buildFlutterAction");
        Intrinsics.checkNotNullParameter(flutterConfigurationParams, "$configurationParams");
        Intrinsics.checkNotNullParameter(str, "$voucherId");
        Intrinsics.checkNotNullParameter(str2, "$voucherName");
        Intrinsics.checkNotNullParameter(str3, "$eventOrigin");
        return (NavDirections) function2.invoke(flutterConfigurationParams, new VoucherProductListingRoute(flutterConfigurationParams.getVendorCode(), str, str2, str3));
    }

    @NotNull
    public Single<NavDirections> invoke(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Function2<? super FlutterConfigurationParams, ? super FlutterRoute, ? extends NavDirections> function2) {
        Intrinsics.checkNotNullParameter(str, VoucherUrlConstantsKt.PATH_VOUCHER_ID);
        Intrinsics.checkNotNullParameter(str2, "voucherName");
        Intrinsics.checkNotNullParameter(str3, "eventOrigin");
        Intrinsics.checkNotNullParameter(function2, "buildFlutterAction");
        Single<NavDirections> fromCallable = Single.fromCallable(new y(function2, this.getFlutterConfigurationParams.invoke(), str, str2, str3));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "fromCallable {\n         …)\n            )\n        }");
        return fromCallable;
    }
}
