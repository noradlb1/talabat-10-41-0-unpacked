package com.talabat.flutter.groceryhome.domain.usecase;

import com.talabat.flutter.groceryhome.domain.model.UserLocation;
import com.talabat.flutter.groceryhome.domain.repository.GroceryHomeVendorRepository;
import datamodels.Restaurant;
import io.reactivex.Single;
import iq.a;
import iq.b;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/flutter/groceryhome/domain/usecase/GetClosestDarkstoreInfoUseCaseImpl;", "Lcom/talabat/flutter/groceryhome/domain/usecase/GetClosestDarkstoreInfoUseCase;", "groceryHomeVendorRepository", "Lcom/talabat/flutter/groceryhome/domain/repository/GroceryHomeVendorRepository;", "getUserLocation", "Lcom/talabat/flutter/groceryhome/domain/usecase/GetUserLocationUseCase;", "(Lcom/talabat/flutter/groceryhome/domain/repository/GroceryHomeVendorRepository;Lcom/talabat/flutter/groceryhome/domain/usecase/GetUserLocationUseCase;)V", "invoke", "Lio/reactivex/Single;", "Ldatamodels/Restaurant;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetClosestDarkstoreInfoUseCaseImpl implements GetClosestDarkstoreInfoUseCase {
    @NotNull
    private final GetUserLocationUseCase getUserLocation;
    @NotNull
    private final GroceryHomeVendorRepository groceryHomeVendorRepository;

    @Inject
    public GetClosestDarkstoreInfoUseCaseImpl(@NotNull GroceryHomeVendorRepository groceryHomeVendorRepository2, @NotNull GetUserLocationUseCase getUserLocationUseCase) {
        Intrinsics.checkNotNullParameter(groceryHomeVendorRepository2, "groceryHomeVendorRepository");
        Intrinsics.checkNotNullParameter(getUserLocationUseCase, "getUserLocation");
        this.groceryHomeVendorRepository = groceryHomeVendorRepository2;
        this.getUserLocation = getUserLocationUseCase;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final UserLocation m10471invoke$lambda0(GetClosestDarkstoreInfoUseCaseImpl getClosestDarkstoreInfoUseCaseImpl) {
        Intrinsics.checkNotNullParameter(getClosestDarkstoreInfoUseCaseImpl, "this$0");
        return getClosestDarkstoreInfoUseCaseImpl.getUserLocation.invoke();
    }

    @NotNull
    public Single<Restaurant> invoke() {
        Single<Restaurant> flatMap = Single.fromCallable(new a(this)).flatMap(new b(this.groceryHomeVendorRepository));
        Intrinsics.checkNotNullExpressionValue(flatMap, "fromCallable { getUserLo…:getClosestDarkstoreInfo)");
        return flatMap;
    }
}
