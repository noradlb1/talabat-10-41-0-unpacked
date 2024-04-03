package com.talabat.darkstores.feature.product;

import com.talabat.darkstores.feature.product.ProductFragmentViewModel;
import com.talabat.feature.darkstorescart.data.model.Product;
import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import javax.inject.Provider;

@DaggerGenerated
public final class ProductFragmentViewModel_Factory_Impl implements ProductFragmentViewModel.Factory {
    private final C0477ProductFragmentViewModel_Factory delegateFactory;

    public ProductFragmentViewModel_Factory_Impl(C0477ProductFragmentViewModel_Factory productFragmentViewModel_Factory) {
        this.delegateFactory = productFragmentViewModel_Factory;
    }

    public ProductFragmentViewModel create(Product product) {
        return this.delegateFactory.get(product);
    }

    public static Provider<ProductFragmentViewModel.Factory> create(C0477ProductFragmentViewModel_Factory productFragmentViewModel_Factory) {
        return InstanceFactory.create(new ProductFragmentViewModel_Factory_Impl(productFragmentViewModel_Factory));
    }
}
