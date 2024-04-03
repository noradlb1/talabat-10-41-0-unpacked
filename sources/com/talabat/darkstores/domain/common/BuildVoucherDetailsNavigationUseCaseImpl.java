package com.talabat.darkstores.domain.common;

import com.talabat.darkstores.domain.voucher.IsVoucherBottomSheetNavigationEnabledUseCase;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.VoucherDetailsRoute;
import com.talabat.talabatcommon.feature.vouchers.loyalty.VoucherUrlConstantsKt;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qi.w;
import qi.x;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J`\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u000e2#\u0010\u0011\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\t0\u0012H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/domain/common/BuildVoucherDetailsNavigationUseCaseImpl;", "Lcom/talabat/darkstores/domain/common/BuildVoucherDetailsNavigationUseCase;", "getFlutterConfigurationParams", "Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCase;", "isVoucherBottomSheetNavigationEnabledUseCase", "Lcom/talabat/darkstores/domain/voucher/IsVoucherBottomSheetNavigationEnabledUseCase;", "(Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCase;Lcom/talabat/darkstores/domain/voucher/IsVoucherBottomSheetNavigationEnabledUseCase;)V", "invoke", "Lio/reactivex/Single;", "", "voucherId", "", "sku", "buildFlutterAction", "Lkotlin/Function2;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "buildNativeAction", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BuildVoucherDetailsNavigationUseCaseImpl implements BuildVoucherDetailsNavigationUseCase {
    @NotNull
    private final GetFlutterConfigurationParamsUseCase getFlutterConfigurationParams;
    @NotNull
    private final IsVoucherBottomSheetNavigationEnabledUseCase isVoucherBottomSheetNavigationEnabledUseCase;

    @Inject
    public BuildVoucherDetailsNavigationUseCaseImpl(@NotNull GetFlutterConfigurationParamsUseCase getFlutterConfigurationParamsUseCase, @NotNull IsVoucherBottomSheetNavigationEnabledUseCase isVoucherBottomSheetNavigationEnabledUseCase2) {
        Intrinsics.checkNotNullParameter(getFlutterConfigurationParamsUseCase, "getFlutterConfigurationParams");
        Intrinsics.checkNotNullParameter(isVoucherBottomSheetNavigationEnabledUseCase2, "isVoucherBottomSheetNavigationEnabledUseCase");
        this.getFlutterConfigurationParams = getFlutterConfigurationParamsUseCase;
        this.isVoucherBottomSheetNavigationEnabledUseCase = isVoucherBottomSheetNavigationEnabledUseCase2;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final Unit m9766invoke$lambda0(Function2 function2, FlutterConfigurationParams flutterConfigurationParams, String str) {
        Intrinsics.checkNotNullParameter(function2, "$buildFlutterAction");
        Intrinsics.checkNotNullParameter(flutterConfigurationParams, "$configurationParams");
        Intrinsics.checkNotNullParameter(str, "$voucherId");
        function2.invoke(flutterConfigurationParams, new VoucherDetailsRoute(flutterConfigurationParams.getVendorCode(), str));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final Unit m9767invoke$lambda1(Function1 function1, String str) {
        Intrinsics.checkNotNullParameter(function1, "$buildNativeAction");
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    @NotNull
    public Single<Unit> invoke(@NotNull String str, @Nullable String str2, @NotNull Function2<? super FlutterConfigurationParams, ? super FlutterRoute, Unit> function2, @NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, VoucherUrlConstantsKt.PATH_VOUCHER_ID);
        Intrinsics.checkNotNullParameter(function2, "buildFlutterAction");
        Intrinsics.checkNotNullParameter(function1, "buildNativeAction");
        if (this.isVoucherBottomSheetNavigationEnabledUseCase.invoke()) {
            Single<Unit> fromCallable = Single.fromCallable(new w(function2, this.getFlutterConfigurationParams.invoke(), str));
            Intrinsics.checkNotNullExpressionValue(fromCallable, "{\n            val config…)\n            }\n        }");
            return fromCallable;
        }
        Single<Unit> fromCallable2 = Single.fromCallable(new x(function1, str2));
        Intrinsics.checkNotNullExpressionValue(fromCallable2, "{\n            Single.fro…veAction(sku) }\n        }");
        return fromCallable2;
    }
}
