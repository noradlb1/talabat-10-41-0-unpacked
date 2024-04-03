package com.talabat.darkstores.domain.common;

import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J`\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\t2#\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00040\rH¦\u0002¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/domain/common/BuildVoucherDetailsNavigationUseCase;", "", "invoke", "Lio/reactivex/Single;", "", "voucherId", "", "sku", "buildFlutterAction", "Lkotlin/Function2;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "buildNativeAction", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface BuildVoucherDetailsNavigationUseCase {
    @NotNull
    Single<Unit> invoke(@NotNull String str, @Nullable String str2, @NotNull Function2<? super FlutterConfigurationParams, ? super FlutterRoute, Unit> function2, @NotNull Function1<? super String, Unit> function1);
}
