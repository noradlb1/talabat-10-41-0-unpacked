package library.talabat.mvp.cart;

import com.talabat.feature.foodcart2.domain.IFoodCartRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineScope;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class CartUtilityImpl_Factory implements Factory<CartUtilityImpl> {
    private final Provider<IFoodCartRepository> foodCartRepositoryProvider;
    private final Provider<CoroutineScope> scopeProvider;

    public CartUtilityImpl_Factory(Provider<IFoodCartRepository> provider, Provider<CoroutineScope> provider2) {
        this.foodCartRepositoryProvider = provider;
        this.scopeProvider = provider2;
    }

    public static CartUtilityImpl_Factory create(Provider<IFoodCartRepository> provider, Provider<CoroutineScope> provider2) {
        return new CartUtilityImpl_Factory(provider, provider2);
    }

    public static CartUtilityImpl newInstance(IFoodCartRepository iFoodCartRepository, CoroutineScope coroutineScope) {
        return new CartUtilityImpl(iFoodCartRepository, coroutineScope);
    }

    public CartUtilityImpl get() {
        return newInstance(this.foodCartRepositoryProvider.get(), this.scopeProvider.get());
    }
}
