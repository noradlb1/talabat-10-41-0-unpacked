package com.talabat.darkstores.feature.categories.subcategories.experiment;

import com.talabat.darkstores.data.tracking.EventOrigin;
import com.talabat.darkstores.feature.categories.subcategories.experiment.SubcategoriesFragmentViewModelNew;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

@DaggerGenerated
public final class SubcategoriesFragmentViewModelNew_Factory_Impl implements SubcategoriesFragmentViewModelNew.Factory {
    private final C0476SubcategoriesFragmentViewModelNew_Factory delegateFactory;

    public SubcategoriesFragmentViewModelNew_Factory_Impl(C0476SubcategoriesFragmentViewModelNew_Factory subcategoriesFragmentViewModelNew_Factory) {
        this.delegateFactory = subcategoriesFragmentViewModelNew_Factory;
    }

    public SubcategoriesFragmentViewModelNew create(String str, String str2, EventOrigin eventOrigin) {
        return this.delegateFactory.get(str, str2, eventOrigin);
    }

    public static Provider<SubcategoriesFragmentViewModelNew.Factory> create(C0476SubcategoriesFragmentViewModelNew_Factory subcategoriesFragmentViewModelNew_Factory) {
        return InstanceFactory.create(new SubcategoriesFragmentViewModelNew_Factory_Impl(subcategoriesFragmentViewModelNew_Factory));
    }
}
