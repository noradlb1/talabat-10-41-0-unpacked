package com.talabat.darkstores.domain.common;

import androidx.navigation.NavDirections;
import com.talabat.darkstores.domain.products.CheckFlutterCategoryProductsEnabledUseCase;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.CategoryProductsRoute;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qi.n;
import qi.o;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t0\u000f2K\u0010\u0012\u001aG\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t0\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/darkstores/domain/common/BuildCategoryProductsNavigationActionUseCaseImpl;", "Lcom/talabat/darkstores/domain/common/BuildCategoryProductsNavigationActionUseCase;", "checkFlutterCategoryProductsEnabled", "Lcom/talabat/darkstores/domain/products/CheckFlutterCategoryProductsEnabledUseCase;", "getFlutterConfigurationParams", "Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCase;", "(Lcom/talabat/darkstores/domain/products/CheckFlutterCategoryProductsEnabledUseCase;Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCase;)V", "invoke", "Lio/reactivex/Single;", "Landroidx/navigation/NavDirections;", "categoryId", "", "categoryName", "eventOrigin", "buildFlutterAction", "Lkotlin/Function2;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "buildNativeAction", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BuildCategoryProductsNavigationActionUseCaseImpl implements BuildCategoryProductsNavigationActionUseCase {
    @NotNull
    private final CheckFlutterCategoryProductsEnabledUseCase checkFlutterCategoryProductsEnabled;
    @NotNull
    private final GetFlutterConfigurationParamsUseCase getFlutterConfigurationParams;

    @Inject
    public BuildCategoryProductsNavigationActionUseCaseImpl(@NotNull CheckFlutterCategoryProductsEnabledUseCase checkFlutterCategoryProductsEnabledUseCase, @NotNull GetFlutterConfigurationParamsUseCase getFlutterConfigurationParamsUseCase) {
        Intrinsics.checkNotNullParameter(checkFlutterCategoryProductsEnabledUseCase, "checkFlutterCategoryProductsEnabled");
        Intrinsics.checkNotNullParameter(getFlutterConfigurationParamsUseCase, "getFlutterConfigurationParams");
        this.checkFlutterCategoryProductsEnabled = checkFlutterCategoryProductsEnabledUseCase;
        this.getFlutterConfigurationParams = getFlutterConfigurationParamsUseCase;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final NavDirections m9757invoke$lambda0(Function2 function2, FlutterConfigurationParams flutterConfigurationParams, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(function2, "$buildFlutterAction");
        Intrinsics.checkNotNullParameter(flutterConfigurationParams, "$configurationParams");
        Intrinsics.checkNotNullParameter(str, "$categoryId");
        Intrinsics.checkNotNullParameter(str2, "$categoryName");
        Intrinsics.checkNotNullParameter(str3, "$eventOrigin");
        return (NavDirections) function2.invoke(flutterConfigurationParams, new CategoryProductsRoute(flutterConfigurationParams.getVendorCode(), str, str2, str3));
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final NavDirections m9758invoke$lambda1(Function3 function3, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(function3, "$buildNativeAction");
        Intrinsics.checkNotNullParameter(str, "$categoryId");
        Intrinsics.checkNotNullParameter(str2, "$categoryName");
        Intrinsics.checkNotNullParameter(str3, "$eventOrigin");
        return (NavDirections) function3.invoke(str, str2, str3);
    }

    @NotNull
    public Single<NavDirections> invoke(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Function2<? super FlutterConfigurationParams, ? super FlutterRoute, ? extends NavDirections> function2, @NotNull Function3<? super String, ? super String, ? super String, ? extends NavDirections> function3) {
        Intrinsics.checkNotNullParameter(str, "categoryId");
        Intrinsics.checkNotNullParameter(str2, "categoryName");
        Intrinsics.checkNotNullParameter(str3, "eventOrigin");
        Intrinsics.checkNotNullParameter(function2, "buildFlutterAction");
        Intrinsics.checkNotNullParameter(function3, "buildNativeAction");
        if (this.checkFlutterCategoryProductsEnabled.invoke()) {
            Single<NavDirections> fromCallable = Single.fromCallable(new n(function2, this.getFlutterConfigurationParams.invoke(), str, str2, str3));
            Intrinsics.checkNotNullExpressionValue(fromCallable, "{\n            val config…)\n            }\n        }");
            return fromCallable;
        }
        Single<NavDirections> fromCallable2 = Single.fromCallable(new o(function3, str, str2, str3));
        Intrinsics.checkNotNullExpressionValue(fromCallable2, "{\n            Single.fro… eventOrigin) }\n        }");
        return fromCallable2;
    }
}
