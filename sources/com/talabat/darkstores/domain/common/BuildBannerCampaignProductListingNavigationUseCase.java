package com.talabat.darkstores.domain.common;

import androidx.navigation.NavDirections;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JT\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00040\b2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00040\fH¦\u0002¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/domain/common/BuildBannerCampaignProductListingNavigationUseCase;", "", "invoke", "Lio/reactivex/Single;", "Landroidx/navigation/NavDirections;", "campaignId", "", "buildFlutterAction", "Lkotlin/Function2;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "buildNativeAction", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "bannerId", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface BuildBannerCampaignProductListingNavigationUseCase {
    @NotNull
    Single<NavDirections> invoke(@NotNull String str, @NotNull Function2<? super FlutterConfigurationParams, ? super FlutterRoute, ? extends NavDirections> function2, @NotNull Function1<? super String, ? extends NavDirections> function1);
}
