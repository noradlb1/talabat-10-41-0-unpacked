package com.talabat.darkstores.domain.common;

import androidx.navigation.NavDirections;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J»\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00040\f2d\u0010\u000f\u001a`\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00040\u0010H¦\u0002¨\u0006\u0014"}, d2 = {"Lcom/talabat/darkstores/domain/common/BuildSwimlanesSearchResultNavigationActionUseCase;", "", "invoke", "Lio/reactivex/Single;", "Landroidx/navigation/NavDirections;", "swimlanesId", "", "headline", "eventOrigin", "categoryId", "tag", "buildFlutterAction", "Lkotlin/Function2;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "buildNativeAction", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "swimlaneId", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface BuildSwimlanesSearchResultNavigationActionUseCase {
    @NotNull
    Single<NavDirections> invoke(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @NotNull Function2<? super FlutterConfigurationParams, ? super FlutterRoute, ? extends NavDirections> function2, @NotNull Function4<? super String, ? super String, ? super String, ? super String, ? extends NavDirections> function4);
}
