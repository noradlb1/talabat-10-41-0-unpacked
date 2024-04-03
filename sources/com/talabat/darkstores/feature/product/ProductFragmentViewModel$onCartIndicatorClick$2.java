package com.talabat.darkstores.feature.product;

import androidx.navigation.NavDirections;
import com.talabat.darkstores.feature.product.ProductFragmentDirections;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class ProductFragmentViewModel$onCartIndicatorClick$2 extends FunctionReferenceImpl implements Function0<NavDirections> {
    public ProductFragmentViewModel$onCartIndicatorClick$2(Object obj) {
        super(0, obj, ProductFragmentDirections.Companion.class, "actionProductFragmentToCartFragment", "actionProductFragmentToCartFragment()Landroidx/navigation/NavDirections;", 0);
    }

    @NotNull
    public final NavDirections invoke() {
        return ((ProductFragmentDirections.Companion) this.receiver).actionProductFragmentToCartFragment();
    }
}
