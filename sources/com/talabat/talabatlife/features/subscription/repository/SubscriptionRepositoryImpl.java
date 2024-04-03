package com.talabat.talabatlife.features.subscription.repository;

import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.exception.SystemError;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatcore.platform.NetworkHandler;
import com.talabat.talabatlife.features.UrlConstantsKt;
import com.talabat.talabatlife.features.subscription.model.request.SubscriptionPaymentRequestModel;
import com.talabat.talabatlife.features.subscription.model.response.AutoRenewSubscriptionResponse;
import com.talabat.talabatlife.features.subscription.model.response.SubscriptionPaymentResponse;
import com.talabat.talabatlife.features.subscription.model.response.TLifePlansRootResponse;
import com.talabat.talabatlife.features.subscription.model.response.TLifeSubscriptionDetailResponse;
import com.talabat.talabatlife.features.subscription.model.response.TLifeSubscriptionDetailResult;
import com.talabat.talabatlife.features.subscription.network.SubscriptionApi;
import com.talabat.talabatlife.features.subscription.network.SubscriptionService;
import com.talabat.talabatlife.ui.onBoarding.model.TLifeOnBoardingPlanDisplayModel;
import com.talabat.talabatlife.ui.subscription.model.SubscriptionMapper;
import com.talabat.talabatlife.ui.subscription.model.SubscriptionPaymentDisplayModel;
import com.talabat.talabatlife.ui.subscriptionManagement.model.AutoRenewSubscriptionDisplayModel;
import com.talabat.talabatlife.ui.subscriptionManagement.model.TLifeSubscriptionDetailDisplayModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Response;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00130\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00170\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u001c\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00190\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/talabat/talabatlife/features/subscription/repository/SubscriptionRepositoryImpl;", "Lcom/talabat/talabatlife/features/subscription/repository/SubscriptionRepository;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "subscriptionService", "Lcom/talabat/talabatlife/features/subscription/network/SubscriptionService;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/talabatlife/features/subscription/network/SubscriptionService;)V", "autoRenewSubscription", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatlife/ui/subscriptionManagement/model/AutoRenewSubscriptionDisplayModel;", "membershipId", "", "enable", "", "callEnableOrDisable", "Lretrofit2/Call;", "Lcom/talabat/talabatlife/features/subscription/model/response/AutoRenewSubscriptionResponse;", "getTLifeSubscriptionDetail", "Lcom/talabat/talabatlife/ui/subscriptionManagement/model/TLifeSubscriptionDetailDisplayModel;", "country", "", "getUserPlans", "Lcom/talabat/talabatlife/ui/onBoarding/model/TLifeOnBoardingPlanDisplayModel;", "subscribe", "Lcom/talabat/talabatlife/ui/subscription/model/SubscriptionPaymentDisplayModel;", "requestModel", "Lcom/talabat/talabatlife/features/subscription/model/request/SubscriptionPaymentRequestModel;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionRepositoryImpl implements SubscriptionRepository {
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull
    private final SubscriptionService subscriptionService;

    public SubscriptionRepositoryImpl(@NotNull NetworkHandler networkHandler2, @NotNull SubscriptionService subscriptionService2) {
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(subscriptionService2, "subscriptionService");
        this.networkHandler = networkHandler2;
        this.subscriptionService = subscriptionService2;
    }

    private final Call<AutoRenewSubscriptionResponse> callEnableOrDisable(boolean z11, String str) {
        if (z11) {
            return SubscriptionApi.DefaultImpls.enableSubscriptionAutoRenew$default(this.subscriptionService, 0, str, 1, (Object) null);
        }
        return SubscriptionApi.DefaultImpls.disableSubscriptionAutoRenew$default(this.subscriptionService, 0, str, 1, (Object) null);
    }

    @NotNull
    public Either<Failure, AutoRenewSubscriptionDisplayModel> autoRenewSubscription(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, UrlConstantsKt.PATH_MEMBERSHIP_ID);
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(callEnableOrDisable(z11, str), SubscriptionRepositoryImpl$autoRenewSubscription$1.INSTANCE, new AutoRenewSubscriptionResponse((Boolean) null, (List) null, 3, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public Either<Failure, TLifeSubscriptionDetailDisplayModel> getTLifeSubscriptionDetail(int i11) {
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(SubscriptionApi.DefaultImpls.getTLifeSubscriptionDetail$default(this.subscriptionService, i11, 0, 2, (Object) null), SubscriptionRepositoryImpl$getTLifeSubscriptionDetail$1.INSTANCE, new TLifeSubscriptionDetailResponse((TLifeSubscriptionDetailResult) null, (List) null, 3, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public Either<Failure, TLifeOnBoardingPlanDisplayModel> getUserPlans(int i11) {
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(SubscriptionApi.DefaultImpls.getUserPlans$default(this.subscriptionService, i11, 0, 2, (Object) null), SubscriptionRepositoryImpl$getUserPlans$1.INSTANCE, new TLifePlansRootResponse());
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public Either<Failure, SubscriptionPaymentDisplayModel> subscribe(@NotNull SubscriptionPaymentRequestModel subscriptionPaymentRequestModel) {
        Intrinsics.checkNotNullParameter(subscriptionPaymentRequestModel, "requestModel");
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            Call paySubscription$default = SubscriptionApi.DefaultImpls.paySubscription$default(this.subscriptionService, 0, subscriptionPaymentRequestModel, 1, (Object) null);
            Object subscriptionPaymentResponse = new SubscriptionPaymentResponse((SubscriptionPaymentResponse.SubscriptionPaymentResult) null, (List) null, 3, (DefaultConstructorMarker) null);
            try {
                Response execute = paySubscription$default.clone().execute();
                boolean isSuccessful = execute.isSuccessful();
                if (isSuccessful) {
                    Object body = execute.body();
                    if (body != null) {
                        subscriptionPaymentResponse = body;
                    }
                    return new Either.Right(SubscriptionMapper.Companion.mapSubscriptionPayment((SubscriptionPaymentResponse) subscriptionPaymentResponse));
                } else if (!isSuccessful) {
                    Intrinsics.checkNotNullExpressionValue(execute, "response");
                    return new Either.Left(RequestKt.parseTheServerError(execute));
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } catch (Failure e11) {
                LogManager.logException(e11);
                return new Either.Left(e11);
            } catch (Throwable th2) {
                LogManager.logException(th2);
                String message = th2.getMessage();
                if (message == null) {
                    message = "";
                }
                return new Either.Left(new SystemError(message));
            }
        } else if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
