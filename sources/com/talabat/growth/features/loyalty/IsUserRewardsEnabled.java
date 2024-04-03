package com.talabat.growth.features.loyalty;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.growth.features.loyalty.models.responses.isUserEnabled.IsUserEnabledRootResponse;
import com.talabat.growth.features.loyalty.network.GetPointsService;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.exception.SystemError;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.interactor.UseCase;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatcore.platform.NetworkHandler;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.Response;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00020\u0010H\u0002J%\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/talabat/growth/features/loyalty/IsUserRewardsEnabled;", "Lcom/talabat/talabatcore/interactor/UseCase;", "", "", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "service", "Lcom/talabat/growth/features/loyalty/network/GetPointsService;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/growth/features/loyalty/network/GetPointsService;Lcom/talabat/configuration/ConfigurationLocalRepository;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;)V", "callIsUserEnabled", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "run", "params", "(Lkotlin/Unit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IsUserRewardsEnabled extends UseCase<Boolean, Unit> {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull

    /* renamed from: service  reason: collision with root package name */
    private final GetPointsService f60563service;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public IsUserRewardsEnabled(@NotNull NetworkHandler networkHandler2, @NotNull GetPointsService getPointsService, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull CoroutineScope coroutineScope, @NotNull CoroutineDispatcher coroutineDispatcher) {
        super(coroutineScope, coroutineDispatcher);
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(getPointsService, "service");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        this.networkHandler = networkHandler2;
        this.f60563service = getPointsService;
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    private final Either<Failure, Boolean> callIsUserEnabled() {
        Either<Failure, Boolean> either;
        Call<IsUserEnabledRootResponse> isUserEnabled = this.f60563service.isUserEnabled(this.configurationLocalRepository.selectedCountry().getCountryId());
        if (isUserEnabled == null) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        IsUserRewardsEnabled$callIsUserEnabled$transform$1 isUserRewardsEnabled$callIsUserEnabled$transform$1 = IsUserRewardsEnabled$callIsUserEnabled$transform$1.INSTANCE;
        IsUserEnabledRootResponse isUserEnabledRootResponse = new IsUserEnabledRootResponse();
        try {
            Response<IsUserEnabledRootResponse> execute = isUserEnabled.clone().execute();
            boolean isSuccessful = execute.isSuccessful();
            if (isSuccessful) {
                IsUserEnabledRootResponse body = execute.body();
                if (body != null) {
                    isUserEnabledRootResponse = body;
                }
                either = new Either.Right<>(isUserRewardsEnabled$callIsUserEnabled$transform$1.invoke(isUserEnabledRootResponse));
            } else if (!isSuccessful) {
                Intrinsics.checkNotNullExpressionValue(execute, "response");
                either = new Either.Left<>(RequestKt.parseTheServerError(execute));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } catch (Failure e11) {
            LogManager.logException(e11);
            either = new Either.Left<>(e11);
        } catch (Throwable th2) {
            LogManager.logException(th2);
            String message = th2.getMessage();
            if (message == null) {
                message = "";
            }
            either = new Either.Left<>(new SystemError(message));
        }
        if (either instanceof Either.Right) {
            GlobalDataModel.isLoyaltyEnabledForThisUser = (Boolean) ((Either.Right) either).getB();
        }
        return either;
    }

    @Nullable
    public Object run(@NotNull Unit unit, @NotNull Continuation<? super Either<? extends Failure, Boolean>> continuation) {
        Boolean bool = GlobalDataModel.isLoyaltyEnabledForThisUser;
        if (bool != null) {
            return new Either.Right(bool);
        }
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return callIsUserEnabled();
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
