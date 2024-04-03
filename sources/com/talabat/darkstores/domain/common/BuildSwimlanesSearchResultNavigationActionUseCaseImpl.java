package com.talabat.darkstores.domain.common;

import androidx.navigation.NavDirections;
import com.talabat.darkstores.domain.swimlanes.CheckFlutterSwimlanesSearchResultEnabledUseCase;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.SwimlanesSearchResultRoute;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qi.t;
import qi.u;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J»\u0001\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u00112d\u0010\u0014\u001a`\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\t0\u0015H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/talabat/darkstores/domain/common/BuildSwimlanesSearchResultNavigationActionUseCaseImpl;", "Lcom/talabat/darkstores/domain/common/BuildSwimlanesSearchResultNavigationActionUseCase;", "checkFlutterSwimlanesSearchResultEnabledUseCase", "Lcom/talabat/darkstores/domain/swimlanes/CheckFlutterSwimlanesSearchResultEnabledUseCase;", "getFlutterConfigurationParams", "Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCase;", "(Lcom/talabat/darkstores/domain/swimlanes/CheckFlutterSwimlanesSearchResultEnabledUseCase;Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCase;)V", "invoke", "Lio/reactivex/Single;", "Landroidx/navigation/NavDirections;", "swimlanesId", "", "headline", "eventOrigin", "categoryId", "tag", "buildFlutterAction", "Lkotlin/Function2;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "buildNativeAction", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "swimlaneId", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BuildSwimlanesSearchResultNavigationActionUseCaseImpl implements BuildSwimlanesSearchResultNavigationActionUseCase {
    @NotNull
    private final CheckFlutterSwimlanesSearchResultEnabledUseCase checkFlutterSwimlanesSearchResultEnabledUseCase;
    @NotNull
    private final GetFlutterConfigurationParamsUseCase getFlutterConfigurationParams;

    @Inject
    public BuildSwimlanesSearchResultNavigationActionUseCaseImpl(@NotNull CheckFlutterSwimlanesSearchResultEnabledUseCase checkFlutterSwimlanesSearchResultEnabledUseCase2, @NotNull GetFlutterConfigurationParamsUseCase getFlutterConfigurationParamsUseCase) {
        Intrinsics.checkNotNullParameter(checkFlutterSwimlanesSearchResultEnabledUseCase2, "checkFlutterSwimlanesSearchResultEnabledUseCase");
        Intrinsics.checkNotNullParameter(getFlutterConfigurationParamsUseCase, "getFlutterConfigurationParams");
        this.checkFlutterSwimlanesSearchResultEnabledUseCase = checkFlutterSwimlanesSearchResultEnabledUseCase2;
        this.getFlutterConfigurationParams = getFlutterConfigurationParamsUseCase;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final NavDirections m9763invoke$lambda0(Function2 function2, FlutterConfigurationParams flutterConfigurationParams, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(function2, "$buildFlutterAction");
        Intrinsics.checkNotNullParameter(flutterConfigurationParams, "$configurationParams");
        Intrinsics.checkNotNullParameter(str, "$swimlanesId");
        Intrinsics.checkNotNullParameter(str2, "$headline");
        Intrinsics.checkNotNullParameter(str3, "$eventOrigin");
        return (NavDirections) function2.invoke(flutterConfigurationParams, new SwimlanesSearchResultRoute(flutterConfigurationParams.getVendorCode(), str, str2, str3));
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final NavDirections m9764invoke$lambda1(Function4 function4, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(function4, "$buildNativeAction");
        Intrinsics.checkNotNullParameter(str, "$swimlanesId");
        Intrinsics.checkNotNullParameter(str2, "$headline");
        return (NavDirections) function4.invoke(str, str2, str3, str4);
    }

    @NotNull
    public Single<NavDirections> invoke(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @NotNull Function2<? super FlutterConfigurationParams, ? super FlutterRoute, ? extends NavDirections> function2, @NotNull Function4<? super String, ? super String, ? super String, ? super String, ? extends NavDirections> function4) {
        Intrinsics.checkNotNullParameter(str, "swimlanesId");
        Intrinsics.checkNotNullParameter(str2, "headline");
        Intrinsics.checkNotNullParameter(str3, "eventOrigin");
        Intrinsics.checkNotNullParameter(function2, "buildFlutterAction");
        Intrinsics.checkNotNullParameter(function4, "buildNativeAction");
        if (this.checkFlutterSwimlanesSearchResultEnabledUseCase.invoke()) {
            Single<NavDirections> fromCallable = Single.fromCallable(new t(function2, this.getFlutterConfigurationParams.invoke(), str, str2, str3));
            Intrinsics.checkNotNullExpressionValue(fromCallable, "{\n            val config…)\n            }\n        }");
            return fromCallable;
        }
        Single<NavDirections> fromCallable2 = Single.fromCallable(new u(function4, str, str2, str4, str5));
        Intrinsics.checkNotNullExpressionValue(fromCallable2, "{\n            Single.fro…egoryId, tag) }\n        }");
        return fromCallable2;
    }
}
