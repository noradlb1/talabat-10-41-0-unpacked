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
public final class GetMigratedVendorInfoUseCaseImpl_Factory implements Factory<GetMigratedVendorInfoUseCaseImpl> {
    private final Provider<GetUserLocationUseCase> getUserLocationProvider;
    private final Provider<GroceryHomeVendorRepository> groceryHomeVendorRepositoryProvider;

    public GetMigratedVendorInfoUseCaseImpl_Factory(Provider<GroceryHomeVendorRepository> provider, Provider<GetUserLocationUseCase> provider2) {
        this.groceryHomeVendorRepositoryProvider = provider;
        this.getUserLocationProvider = provider2;
    }

    public static GetMigratedVendorInfoUseCaseImpl_Factory create(Provider<GroceryHomeVendorRepository> provider, Provider<GetUserLocationUseCase> provider2) {
        return new GetMigratedVendorInfoUseCaseImpl_Factory(provider, provider2);
    }

    public static GetMigratedVendorInfoUseCaseImpl newInstance(GroceryHomeVendorRepository groceryHomeVendorRepository, GetUserLocationUseCase getUserLocationUseCase) {
        return new GetMigratedVendorInfoUseCaseImpl(groceryHomeVendorRepository, getUserLocationUseCase);
    }

    public GetMigratedVendorInfoUseCaseImpl get() {
        return newInstance(this.groceryHomeVendorRepositoryProvider.get(), this.getUserLocationProvider.get());
    }
}
