package com.talabat.darkstores.feature.categories.subcategories.experiment;

import androidx.navigation.NavDirections;
import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentNewDirections;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class SubcategoriesFragmentViewModelNew$onCartIndicatorClick$2 extends FunctionReferenceImpl implements Function0<NavDirections> {
    public SubcategoriesFragmentViewModelNew$onCartIndicatorClick$2(Object obj) {
        super(0, obj, SubcategoriesFragmentNewDirections.Companion.class, "actionSubcategoriesFragmentNewToCartFragment", "actionSubcategoriesFragmentNewToCartFragment()Landroidx/navigation/NavDirections;", 0);
    }

    @NotNull
    public final NavDirections invoke() {
        return ((SubcategoriesFragmentNewDirections.Companion) this.receiver).actionSubcategoriesFragmentNewToCartFragment();
    }
}
