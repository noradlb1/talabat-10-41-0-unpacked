package com.talabat.darkstores.feature.home;

import androidx.navigation.NavDirections;
import com.talabat.darkstores.feature.home.HomeFragmentDirections;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class HomeFragmentViewModel$onLifestyleMissionControlV2Clicked$1 extends FunctionReferenceImpl implements Function2<FlutterConfigurationParams, FlutterRoute, NavDirections> {
    public HomeFragmentViewModel$onLifestyleMissionControlV2Clicked$1(Object obj) {
        super(2, obj, HomeFragmentDirections.Companion.class, "actionHomeFragmentToFlutterSearchFragment", "actionHomeFragmentToFlutterSearchFragment(Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;)Landroidx/navigation/NavDirections;", 0);
    }

    @NotNull
    public final NavDirections invoke(@NotNull FlutterConfigurationParams flutterConfigurationParams, @NotNull FlutterRoute flutterRoute) {
        Intrinsics.checkNotNullParameter(flutterConfigurationParams, "p0");
        Intrinsics.checkNotNullParameter(flutterRoute, "p1");
        return ((HomeFragmentDirections.Companion) this.receiver).actionHomeFragmentToFlutterSearchFragment(flutterConfigurationParams, flutterRoute);
    }
}
