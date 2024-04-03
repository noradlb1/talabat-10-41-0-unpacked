package com.talabat.talabatlife.features.subscription.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatlife.features.UrlConstantsKt;
import com.talabat.talabatlife.features.subscription.model.request.SubscriptionPaymentRequestModel;
import com.talabat.talabatlife.features.subscription.model.response.AutoRenewSubscriptionResponse;
import com.talabat.talabatlife.features.subscription.model.response.SubscriptionPaymentResponse;
import com.talabat.talabatlife.features.subscription.model.response.TLifePlansRootResponse;
import com.talabat.talabatlife.features.subscription.model.response.TLifeSubscriptionDetailResponse;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u001b\u0010\u0005\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/talabat/talabatlife/features/subscription/network/SubscriptionService;", "Lcom/talabat/talabatlife/features/subscription/network/SubscriptionApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "subscriptionApi", "getSubscriptionApi", "()Lcom/talabat/talabatlife/features/subscription/network/SubscriptionApi;", "subscriptionApi$delegate", "Lkotlin/Lazy;", "disableSubscriptionAutoRenew", "Lretrofit2/Call;", "Lcom/talabat/talabatlife/features/subscription/model/response/AutoRenewSubscriptionResponse;", "version", "", "membershipId", "", "enableSubscriptionAutoRenew", "getTLifeSubscriptionDetail", "Lcom/talabat/talabatlife/features/subscription/model/response/TLifeSubscriptionDetailResponse;", "country", "getUserPlans", "Lcom/talabat/talabatlife/features/subscription/model/response/TLifePlansRootResponse;", "paySubscription", "Lcom/talabat/talabatlife/features/subscription/model/response/SubscriptionPaymentResponse;", "subscriptionPaymentRequestModel", "Lcom/talabat/talabatlife/features/subscription/model/request/SubscriptionPaymentRequestModel;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionService implements SubscriptionApi {
    @NotNull
    private final Lazy subscriptionApi$delegate;

    public SubscriptionService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        this.subscriptionApi$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new SubscriptionService$subscriptionApi$2(talabatAPIBuilder));
    }

    private final SubscriptionApi getSubscriptionApi() {
        return (SubscriptionApi) this.subscriptionApi$delegate.getValue();
    }

    @NotNull
    public Call<AutoRenewSubscriptionResponse> disableSubscriptionAutoRenew(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, UrlConstantsKt.PATH_MEMBERSHIP_ID);
        return getSubscriptionApi().disableSubscriptionAutoRenew(i11, str);
    }

    @NotNull
    public Call<AutoRenewSubscriptionResponse> enableSubscriptionAutoRenew(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, UrlConstantsKt.PATH_MEMBERSHIP_ID);
        return getSubscriptionApi().enableSubscriptionAutoRenew(i11, str);
    }

    @NotNull
    public Call<TLifeSubscriptionDetailResponse> getTLifeSubscriptionDetail(int i11, int i12) {
        return getSubscriptionApi().getTLifeSubscriptionDetail(i11, i12);
    }

    @NotNull
    public Call<TLifePlansRootResponse> getUserPlans(int i11, int i12) {
        return getSubscriptionApi().getUserPlans(i11, i12);
    }

    @NotNull
    public Call<SubscriptionPaymentResponse> paySubscription(int i11, @NotNull SubscriptionPaymentRequestModel subscriptionPaymentRequestModel) {
        Intrinsics.checkNotNullParameter(subscriptionPaymentRequestModel, "subscriptionPaymentRequestModel");
        return getSubscriptionApi().paySubscription(i11, subscriptionPaymentRequestModel);
    }
}
