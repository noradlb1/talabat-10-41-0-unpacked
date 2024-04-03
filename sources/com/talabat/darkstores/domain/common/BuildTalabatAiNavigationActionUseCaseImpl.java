package com.talabat.darkstores.domain.common;

import androidx.navigation.NavDirections;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.TalabatAiChatRoute;
import io.reactivex.Maybe;
import io.reactivex.Single;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qi.v;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/darkstores/domain/common/BuildTalabatAiNavigationActionUseCaseImpl;", "Lcom/talabat/darkstores/domain/common/BuildTalabatAiNavigationActionUseCase;", "getFlutterConfigurationParams", "Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCase;", "(Lcom/talabat/darkstores/domain/common/GetFlutterConfigurationParamsUseCase;)V", "invoke", "Lio/reactivex/Maybe;", "Landroidx/navigation/NavDirections;", "buildFlutterAction", "Lkotlin/Function2;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BuildTalabatAiNavigationActionUseCaseImpl implements BuildTalabatAiNavigationActionUseCase {
    @NotNull
    private final GetFlutterConfigurationParamsUseCase getFlutterConfigurationParams;

    @Inject
    public BuildTalabatAiNavigationActionUseCaseImpl(@NotNull GetFlutterConfigurationParamsUseCase getFlutterConfigurationParamsUseCase) {
        Intrinsics.checkNotNullParameter(getFlutterConfigurationParamsUseCase, "getFlutterConfigurationParams");
        this.getFlutterConfigurationParams = getFlutterConfigurationParamsUseCase;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final NavDirections m9765invoke$lambda0(Function2 function2, FlutterConfigurationParams flutterConfigurationParams) {
        Intrinsics.checkNotNullParameter(function2, "$buildFlutterAction");
        Intrinsics.checkNotNullParameter(flutterConfigurationParams, "$configurationParams");
        return (NavDirections) function2.invoke(flutterConfigurationParams, new TalabatAiChatRoute(flutterConfigurationParams.getVendorCode()));
    }

    @NotNull
    public Maybe<NavDirections> invoke(@NotNull Function2<? super FlutterConfigurationParams, ? super FlutterRoute, ? extends NavDirections> function2) {
        Intrinsics.checkNotNullParameter(function2, "buildFlutterAction");
        Maybe<NavDirections> onErrorComplete = Single.fromCallable(new v(function2, this.getFlutterConfigurationParams.invoke())).toMaybe().onErrorComplete();
        Intrinsics.checkNotNullExpressionValue(onErrorComplete, "fromCallable {\n         …       .onErrorComplete()");
        return onErrorComplete;
    }
}
