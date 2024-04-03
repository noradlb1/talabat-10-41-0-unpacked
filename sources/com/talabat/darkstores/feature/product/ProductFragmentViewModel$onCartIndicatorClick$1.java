package com.talabat.darkstores.feature.product;

import androidx.navigation.NavDirections;
import com.talabat.darkstores.feature.product.ProductFragmentDirections;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.feature.nfvinvendorsearch.presentation.navigation.FlutterRoute;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class ProductFragmentViewModel$onCartIndicatorClick$1 extends FunctionReferenceImpl implements Function2<FlutterConfigurationParams, FlutterRoute, NavDirections> {
    public ProductFragmentViewModel$onCartIndicatorClick$1(Object obj) {
        super(2, obj, ProductFragmentDirections.Companion.class, "actionProductFragmentToFlutterSearchFragment", "actionProductFragmentToFlutterSearchFragment(Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;)Landroidx/navigation/NavDirections;", 0);
    }

    @NotNull
    public final NavDirections invoke(@NotNull FlutterConfigurationParams flutterConfigurationParams, @NotNull FlutterRoute flutterRoute) {
        Intrinsics.checkNotNullParameter(flutterConfigurationParams, "p0");
        Intrinsics.checkNotNullParameter(flutterRoute, "p1");
        return ((ProductFragmentDirections.Companion) this.receiver).actionProductFragmentToFlutterSearchFragment(flutterConfigurationParams, flutterRoute);
    }
}
