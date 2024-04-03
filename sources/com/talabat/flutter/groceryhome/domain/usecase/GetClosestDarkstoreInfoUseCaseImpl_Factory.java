package com.talabat.flutter.groceryhome.domain.usecase;

import com.talabat.flutter.groceryhome.domain.repository.GroceryHomeVendorRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@DaggerGenerated
@QualifierMetadata
public final class GetClosestDarkstoreInfoUseCaseImpl_Factory implements Factory<GetClosestDarkstoreInfoUseCaseImpl> {
    private final Provider<GetUserLocationUseCase> getUserLocationProvider;
    private final Provider<GroceryHomeVendorRepository> groceryHomeVendorRepositoryProvider;

    public GetClosestDarkstoreInfoUseCaseImpl_Factory(Provider<GroceryHomeVendorRepository> provider, Provider<GetUserLocationUseCase> provider2) {
        this.groceryHomeVendorRepositoryProvider = provider;
        this.getUserLocationProvider = provider2;
    }

    public static GetClosestDarkstoreInfoUseCaseImpl_Factory create(Provider<GroceryHomeVendorRepository> provider, Provider<GetUserLocationUseCase> provider2) {
        return new GetClosestDarkstoreInfoUseCaseImpl_Factory(provider, provider2);
    }

    public static GetClosestDarkstoreInfoUseCaseImpl newInstance(GroceryHomeVendorRepository groceryHomeVendorRepository, GetUserLocationUseCase getUserLocationUseCase) {
        return new GetClosestDarkstoreInfoUseCaseImpl(groceryHomeVendorRepository, getUserLocationUseCase);
    }

    public GetClosestDarkstoreInfoUseCaseImpl get() {
        return newInstance(this.groceryHomeVendorRepositoryProvider.get(), this.getUserLocationProvider.get());
    }
}
