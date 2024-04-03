package com.talabat.darkstores.domain.common;

import androidx.navigation.NavDirections;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import io.reactivex.Maybe;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0006H¦\u0002¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/domain/common/BuildTalabatAiNavigationActionUseCase;", "", "invoke", "Lio/reactivex/Maybe;", "Landroidx/navigation/NavDirections;", "buildFlutterAction", "Lkotlin/Function2;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface BuildTalabatAiNavigationActionUseCase {
    @NotNull
    Maybe<NavDirections> invoke(@NotNull Function2<? super FlutterConfigurationParams, ? super FlutterRoute, ? extends NavDirections> function2);
}
