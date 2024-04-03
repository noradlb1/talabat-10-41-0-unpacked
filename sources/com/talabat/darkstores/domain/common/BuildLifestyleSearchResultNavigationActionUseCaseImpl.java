package com.talabat.darkstores.domain.common;

import androidx.navigation.NavDirections;
import com.huawei.hms.analytics.type.HAParamType;
import com.talabat.darkstores.domain.swimlanes.CheckFlutterSwimlanesSearchResultEnabledUseCase;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.SwimlanesSearchResultRoute;
import com.tekartik.sqflite.Constant;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qi.q;
import qi.r;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006Jy\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t0\u000f26\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\t0\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/domain/common/BuildLifestyleSearchResultNavigationActionUseCaseImpl;", "Lcom/talabat/darkstores/domain/common/BuildLifestyleSearchResultNavigationActionUseCase;", "checkFlutterSwimlanesSearchResultEnabledUseCase", "Lcom/talabat/darkstores/domain/swimlanes/CheckFlutterSwimlanesSearchResultEnabledUseCase;", "getFlutterConfigurationParams", "Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCase;", "(Lcom/talabat/darkstores/domain/swimlanes/CheckFlutterSwimlanesSearchResultEnabledUseCase;Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCase;)V", "invoke", "Lio/reactivex/Single;", "Landroidx/navigation/NavDirections;", "code", "", "headline", "eventOrigin", "buildFlutterAction", "Lkotlin/Function2;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "buildNativeAction", "Lkotlin/ParameterName;", "name", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BuildLifestyleSearchResultNavigationActionUseCaseImpl implements BuildLifestyleSearchResultNavigationActionUseCase {
    @NotNull
    private final CheckFlutterSwimlanesSearchResultEnabledUseCase checkFlutterSwimlanesSearchResultEnabledUseCase;
    @NotNull
    private final GetFlutterConfigurationParamsUseCase getFlutterConfigurationParams;

    @Inject
    public BuildLifestyleSearchResultNavigationActionUseCaseImpl(@NotNull CheckFlutterSwimlanesSearchResultEnabledUseCase checkFlutterSwimlanesSearchResultEnabledUseCase2, @NotNull GetFlutterConfigurationParamsUseCase getFlutterConfigurationParamsUseCase) {
        Intrinsics.checkNotNullParameter(checkFlutterSwimlanesSearchResultEnabledUseCase2, "checkFlutterSwimlanesSearchResultEnabledUseCase");
        Intrinsics.checkNotNullParameter(getFlutterConfigurationParamsUseCase, "getFlutterConfigurationParams");
        this.checkFlutterSwimlanesSearchResultEnabledUseCase = checkFlutterSwimlanesSearchResultEnabledUseCase2;
        this.getFlutterConfigurationParams = getFlutterConfigurationParamsUseCase;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final NavDirections m9760invoke$lambda0(Function2 function2, FlutterConfigurationParams flutterConfigurationParams, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(function2, "$buildFlutterAction");
        Intrinsics.checkNotNullParameter(flutterConfigurationParams, "$configurationParams");
        Intrinsics.checkNotNullParameter(str, HAParamType.CODE);
        Intrinsics.checkNotNullParameter(str2, "$headline");
        Intrinsics.checkNotNullParameter(str3, "$eventOrigin");
        return (NavDirections) function2.invoke(flutterConfigurationParams, new SwimlanesSearchResultRoute(flutterConfigurationParams.getVendorCode(), str, str2, str3));
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final NavDirections m9761invoke$lambda1(Function2 function2, String str, String str2) {
        Intrinsics.checkNotNullParameter(function2, "$buildNativeAction");
        Intrinsics.checkNotNullParameter(str, HAParamType.CODE);
        Intrinsics.checkNotNullParameter(str2, "$headline");
        return (NavDirections) function2.invoke(str, str2);
    }

    @NotNull
    public Single<NavDirections> invoke(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Function2<? super FlutterConfigurationParams, ? super FlutterRoute, ? extends NavDirections> function2, @NotNull Function2<? super String, ? super String, ? extends NavDirections> function22) {
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
        Intrinsics.checkNotNullParameter(str2, "headline");
        Intrinsics.checkNotNullParameter(str3, "eventOrigin");
        Intrinsics.checkNotNullParameter(function2, "buildFlutterAction");
        Intrinsics.checkNotNullParameter(function22, "buildNativeAction");
        if (this.checkFlutterSwimlanesSearchResultEnabledUseCase.invoke()) {
            Single<NavDirections> fromCallable = Single.fromCallable(new q(function2, this.getFlutterConfigurationParams.invoke(), str, str2, str3));
            Intrinsics.checkNotNullExpressionValue(fromCallable, "{\n            val config…)\n            }\n        }");
            return fromCallable;
        }
        Single<NavDirections> fromCallable2 = Single.fromCallable(new r(function22, str, str2));
        Intrinsics.checkNotNullExpressionValue(fromCallable2, "{\n            Single.fro…de, headline) }\n        }");
        return fromCallable2;
    }
}
