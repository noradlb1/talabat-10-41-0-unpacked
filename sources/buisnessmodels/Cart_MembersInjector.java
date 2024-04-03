package buisnessmodels;

import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;
import library.talabat.mvp.cart.CartUtility;

@QualifierMetadata
@DaggerGenerated
public final class Cart_MembersInjector implements MembersInjector<Cart> {
    private final Provider<CartUtility> cartUtilityProvider;
    private final Provider<ITalabatFeatureFlag> talabatFeatureFlagProvider;

    public Cart_MembersInjector(Provider<ITalabatFeatureFlag> provider, Provider<CartUtility> provider2) {
        this.talabatFeatureFlagProvider = provider;
        this.cartUtilityProvider = provider2;
    }

    public static MembersInjector<Cart> create(Provider<ITalabatFeatureFlag> provider, Provider<CartUtility> provider2) {
        return new Cart_MembersInjector(provider, provider2);
    }

    @InjectedFieldSignature("buisnessmodels.Cart.cartUtility")
    public static void injectCartUtility(Cart cart, CartUtility cartUtility) {
        cart.cartUtility = cartUtility;
    }

    @InjectedFieldSignature("buisnessmodels.Cart.talabatFeatureFlag")
    public static void injectTalabatFeatureFlag(Cart cart, ITalabatFeatureFlag iTalabatFeatureFlag) {
        cart.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    public void injectMembers(Cart cart) {
        injectTalabatFeatureFlag(cart, this.talabatFeatureFlagProvider.get());
        injectCartUtility(cart, this.cartUtilityProvider.get());
    }
}
