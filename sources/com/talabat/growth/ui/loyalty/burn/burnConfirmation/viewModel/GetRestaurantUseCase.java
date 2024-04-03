package com.talabat.growth.ui.loyalty.burn.burnConfirmation.viewModel;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.growth.features.loyalty.network.VendorApi;
import com.talabat.growth.features.loyalty.network.VendorService;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.interactor.UseCase;
import com.talabat.talabatcore.platform.NetworkHandler;
import datamodels.Restaurant;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import library.talabat.com.talabatlib.RestaurantListResponsePaginated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0015\u0016\u0017B)\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u0011\u001a\u00020\u0003H\u0002J%\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/GetRestaurantUseCase;", "Lcom/talabat/talabatcore/interactor/UseCase;", "Ldatamodels/Restaurant;", "", "vendorService", "Lcom/talabat/growth/features/loyalty/network/VendorApi;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/talabat/growth/features/loyalty/network/VendorApi;Lcom/talabat/talabatcore/platform/NetworkHandler;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;)V", "executeRequest", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Llibrary/talabat/com/talabatlib/RestaurantListResponsePaginated;", "vendorId", "run", "params", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ThereAreMoreThenOneRestaurants", "ThereAreNoRestaurants", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetRestaurantUseCase extends UseCase<Restaurant, Integer> {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final int MAX_AMOUNT_OF_RESTAURANTS = 1;
    @Deprecated
    public static final int PAGE = 1;
    @Deprecated
    public static final int PAGE_SIZE = 10;
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull
    private final VendorApi vendorService;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/GetRestaurantUseCase$Companion;", "", "()V", "MAX_AMOUNT_OF_RESTAURANTS", "", "PAGE", "PAGE_SIZE", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/GetRestaurantUseCase$ThereAreMoreThenOneRestaurants;", "Lcom/talabat/talabatcore/exception/Failure$FeatureFailure;", "()V", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ThereAreMoreThenOneRestaurants extends Failure.FeatureFailure {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/GetRestaurantUseCase$ThereAreNoRestaurants;", "Lcom/talabat/talabatcore/exception/Failure$FeatureFailure;", "()V", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ThereAreNoRestaurants extends Failure.FeatureFailure {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetRestaurantUseCase(VendorApi vendorApi, NetworkHandler networkHandler2, CoroutineScope coroutineScope, CoroutineDispatcher coroutineDispatcher, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new VendorService(new TalabatAPIBuilder()) : vendorApi, networkHandler2, coroutineScope, (i11 & 8) != 0 ? Dispatchers.getMain() : coroutineDispatcher);
    }

    private final Either<Failure, RestaurantListResponsePaginated> executeRequest(int i11) {
        VendorApi vendorApi = this.vendorService;
        Double latitudeDouble = GlobalDataModel.LATLONGFORAPI.getLatitudeDouble();
        Intrinsics.checkNotNullExpressionValue(latitudeDouble, "getLatitudeDouble()");
        double doubleValue = latitudeDouble.doubleValue();
        Double longitudeDouble = GlobalDataModel.LATLONGFORAPI.getLongitudeDouble();
        Intrinsics.checkNotNullExpressionValue(longitudeDouble, "getLongitudeDouble()");
        return RequestKt.request(vendorApi.getVendors(doubleValue, longitudeDouble.doubleValue(), 1, 10, CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(i11))), GetRestaurantUseCase$executeRequest$1.INSTANCE, new RestaurantListResponsePaginated(0, 0, (List) null, (String) null, (List) null, (List) null, 0, (List) null, 255, (DefaultConstructorMarker) null));
    }

    public /* bridge */ /* synthetic */ Object run(Object obj, Continuation continuation) {
        return run(((Number) obj).intValue(), (Continuation<? super Either<? extends Failure, ? extends Restaurant>>) continuation);
    }

    @Nullable
    public Object run(int i11, @NotNull Continuation<? super Either<? extends Failure, ? extends Restaurant>> continuation) {
        Object obj;
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            Either<Failure, RestaurantListResponsePaginated> executeRequest = executeRequest(i11);
            if (executeRequest instanceof Either.Right) {
                List<Restaurant> vendors = ((RestaurantListResponsePaginated) ((Either.Right) executeRequest).getB()).getVendors();
                Collection collection = vendors;
                if (collection == null || collection.isEmpty()) {
                    return new Either.Left(new ThereAreNoRestaurants());
                }
                if (vendors.size() > 1) {
                    return new Either.Left(new ThereAreMoreThenOneRestaurants());
                }
                obj = new Either.Right(CollectionsKt___CollectionsKt.first(vendors));
            } else if (executeRequest instanceof Either.Left) {
                obj = new Either.Left(((Either.Left) executeRequest).getA());
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return obj;
        } else if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetRestaurantUseCase(@NotNull VendorApi vendorApi, @NotNull NetworkHandler networkHandler2, @NotNull CoroutineScope coroutineScope, @NotNull CoroutineDispatcher coroutineDispatcher) {
        super(coroutineScope, coroutineDispatcher);
        Intrinsics.checkNotNullParameter(vendorApi, "vendorService");
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.vendorService = vendorApi;
        this.networkHandler = networkHandler2;
    }
}
