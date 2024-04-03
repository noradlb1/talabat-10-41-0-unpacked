package com.talabat.flutter.groceryhome.di;

import com.talabat.flutter.groceryhome.data.repository.GroceryHomeVendorRepositoryImpl;
import com.talabat.flutter.groceryhome.domain.repository.GroceryHomeVendorRepository;
import com.talabat.flutter.groceryhome.domain.usecase.GetClosestDarkstoreInfoUseCase;
import com.talabat.flutter.groceryhome.domain.usecase.GetClosestDarkstoreInfoUseCaseImpl;
import com.talabat.flutter.groceryhome.domain.usecase.GetMigratedVendorInfoUseCase;
import com.talabat.flutter.groceryhome.domain.usecase.GetMigratedVendorInfoUseCaseImpl;
import com.talabat.flutter.groceryhome.domain.usecase.GetUserLocationUseCase;
import com.talabat.flutter.groceryhome.domain.usecase.GetUserLocationUseCaseImpl;
import com.talabat.flutter.groceryhome.presentation.handler.GroceryHomeMethodHandlerFactory;
import com.talabat.flutter.groceryhome.presentation.handler.GroceryHomeMethodHandlerFactoryImpl;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u000eH'J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0011H'¨\u0006\u0012"}, d2 = {"Lcom/talabat/flutter/groceryhome/di/GroceryHomeModule;", "", "bindGetClosestDarkstoreInfoUseCase", "Lcom/talabat/flutter/groceryhome/domain/usecase/GetClosestDarkstoreInfoUseCase;", "impl", "Lcom/talabat/flutter/groceryhome/domain/usecase/GetClosestDarkstoreInfoUseCaseImpl;", "bindGetMigratedVendorInfoUseCase", "Lcom/talabat/flutter/groceryhome/domain/usecase/GetMigratedVendorInfoUseCase;", "Lcom/talabat/flutter/groceryhome/domain/usecase/GetMigratedVendorInfoUseCaseImpl;", "bindGetUserLocationUseCase", "Lcom/talabat/flutter/groceryhome/domain/usecase/GetUserLocationUseCase;", "Lcom/talabat/flutter/groceryhome/domain/usecase/GetUserLocationUseCaseImpl;", "bindGroceryHomeMethodHandlerFactory", "Lcom/talabat/flutter/groceryhome/presentation/handler/GroceryHomeMethodHandlerFactory;", "Lcom/talabat/flutter/groceryhome/presentation/handler/GroceryHomeMethodHandlerFactoryImpl;", "bindGroceryHomeVendorRepository", "Lcom/talabat/flutter/groceryhome/domain/repository/GroceryHomeVendorRepository;", "Lcom/talabat/flutter/groceryhome/data/repository/GroceryHomeVendorRepositoryImpl;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
public interface GroceryHomeModule {
    @NotNull
    @Binds
    GetClosestDarkstoreInfoUseCase bindGetClosestDarkstoreInfoUseCase(@NotNull GetClosestDarkstoreInfoUseCaseImpl getClosestDarkstoreInfoUseCaseImpl);

    @NotNull
    @Binds
    GetMigratedVendorInfoUseCase bindGetMigratedVendorInfoUseCase(@NotNull GetMigratedVendorInfoUseCaseImpl getMigratedVendorInfoUseCaseImpl);

    @NotNull
    @Binds
    GetUserLocationUseCase bindGetUserLocationUseCase(@NotNull GetUserLocationUseCaseImpl getUserLocationUseCaseImpl);

    @NotNull
    @Binds
    GroceryHomeMethodHandlerFactory bindGroceryHomeMethodHandlerFactory(@NotNull GroceryHomeMethodHandlerFactoryImpl groceryHomeMethodHandlerFactoryImpl);

    @NotNull
    @Binds
    GroceryHomeVendorRepository bindGroceryHomeVendorRepository(@NotNull GroceryHomeVendorRepositoryImpl groceryHomeVendorRepositoryImpl);
}
