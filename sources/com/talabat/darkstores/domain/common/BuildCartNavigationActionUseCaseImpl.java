package com.talabat.darkstores.domain.common;

import androidx.navigation.NavDirections;
import com.talabat.darkstores.domain.cart.IsFlutterCartEnabledUseCase;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.CartRoute;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qi.j;
import qi.k;
import qi.l;
import qi.m;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J7\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/domain/common/BuildCartNavigationActionUseCaseImpl;", "Lcom/talabat/darkstores/domain/common/BuildCartNavigationActionUseCase;", "isFlutterCartEnabled", "Lcom/talabat/darkstores/domain/cart/IsFlutterCartEnabledUseCase;", "getFlutterConfigurationParams", "Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCase;", "(Lcom/talabat/darkstores/domain/cart/IsFlutterCartEnabledUseCase;Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCase;)V", "invoke", "Lio/reactivex/Single;", "Landroidx/navigation/NavDirections;", "buildFlutterAction", "Lkotlin/Function2;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "buildNativeAction", "Lkotlin/Function0;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BuildCartNavigationActionUseCaseImpl implements BuildCartNavigationActionUseCase {
    @NotNull
    private final GetFlutterConfigurationParamsUseCase getFlutterConfigurationParams;
    @NotNull
    private final IsFlutterCartEnabledUseCase isFlutterCartEnabled;

    @Inject
    public BuildCartNavigationActionUseCaseImpl(@NotNull IsFlutterCartEnabledUseCase isFlutterCartEnabledUseCase, @NotNull GetFlutterConfigurationParamsUseCase getFlutterConfigurationParamsUseCase) {
        Intrinsics.checkNotNullParameter(isFlutterCartEnabledUseCase, "isFlutterCartEnabled");
        Intrinsics.checkNotNullParameter(getFlutterConfigurationParamsUseCase, "getFlutterConfigurationParams");
        this.isFlutterCartEnabled = isFlutterCartEnabledUseCase;
        this.getFlutterConfigurationParams = getFlutterConfigurationParamsUseCase;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final Boolean m9753invoke$lambda0(BuildCartNavigationActionUseCaseImpl buildCartNavigationActionUseCaseImpl) {
        Intrinsics.checkNotNullParameter(buildCartNavigationActionUseCaseImpl, "this$0");
        return Boolean.valueOf(buildCartNavigationActionUseCaseImpl.isFlutterCartEnabled.invoke());
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-3  reason: not valid java name */
    public static final SingleSource m9754invoke$lambda3(BuildCartNavigationActionUseCaseImpl buildCartNavigationActionUseCaseImpl, Function0 function0, Function2 function2, Boolean bool) {
        Intrinsics.checkNotNullParameter(buildCartNavigationActionUseCaseImpl, "this$0");
        Intrinsics.checkNotNullParameter(function0, "$buildNativeAction");
        Intrinsics.checkNotNullParameter(function2, "$buildFlutterAction");
        Intrinsics.checkNotNullParameter(bool, "isFlutterCartEnabled");
        if (bool.booleanValue()) {
            return Single.fromCallable(new l(function2, buildCartNavigationActionUseCaseImpl.getFlutterConfigurationParams.invoke()));
        }
        return Single.fromCallable(new m(function0));
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-3$lambda-1  reason: not valid java name */
    public static final NavDirections m9755invoke$lambda3$lambda1(Function2 function2, FlutterConfigurationParams flutterConfigurationParams) {
        Intrinsics.checkNotNullParameter(function2, "$buildFlutterAction");
        Intrinsics.checkNotNullParameter(flutterConfigurationParams, "$configurationParams");
        return (NavDirections) function2.invoke(flutterConfigurationParams, new CartRoute(flutterConfigurationParams.getVendorCode()));
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-3$lambda-2  reason: not valid java name */
    public static final NavDirections m9756invoke$lambda3$lambda2(Function0 function0) {
        Intrinsics.checkNotNullParameter(function0, "$tmp0");
        return (NavDirections) function0.invoke();
    }

    @NotNull
    public Single<NavDirections> invoke(@NotNull Function2<? super FlutterConfigurationParams, ? super FlutterRoute, ? extends NavDirections> function2, @NotNull Function0<? extends NavDirections> function0) {
        Intrinsics.checkNotNullParameter(function2, "buildFlutterAction");
        Intrinsics.checkNotNullParameter(function0, "buildNativeAction");
        Single<NavDirections> flatMap = Single.fromCallable(new j(this)).flatMap(new k(this, function0, function2));
        Intrinsics.checkNotNullExpressionValue(flatMap, "fromCallable { isFlutter…          }\n            }");
        return flatMap;
    }
}
