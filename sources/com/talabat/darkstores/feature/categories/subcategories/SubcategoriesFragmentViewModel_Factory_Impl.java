package com.talabat.darkstores.feature.categories.subcategories;

import com.talabat.darkstores.data.tracking.EventOrigin;
import com.talabat.darkstores.feature.categories.subcategories.SubcategoriesFragmentViewModel;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

@DaggerGenerated
public final class SubcategoriesFragmentViewModel_Factory_Impl implements SubcategoriesFragmentViewModel.Factory {
    private final C0475SubcategoriesFragmentViewModel_Factory delegateFactory;

    public SubcategoriesFragmentViewModel_Factory_Impl(C0475SubcategoriesFragmentViewModel_Factory subcategoriesFragmentViewModel_Factory) {
        this.delegateFactory = subcategoriesFragmentViewModel_Factory;
    }

    public SubcategoriesFragmentViewModel create(String str, String str2, EventOrigin eventOrigin) {
        return this.delegateFactory.get(str, str2, eventOrigin);
    }

    public static Provider<SubcategoriesFragmentViewModel.Factory> create(C0475SubcategoriesFragmentViewModel_Factory subcategoriesFragmentViewModel_Factory) {
        return InstanceFactory.create(new SubcategoriesFragmentViewModel_Factory_Impl(subcategoriesFragmentViewModel_Factory));
    }
}
