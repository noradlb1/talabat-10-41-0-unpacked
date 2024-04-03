package com.talabat.talabatcommon.feature.vouchers.loyalty.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatcommon.feature.vouchers.loyalty.VoucherUrlConstantsKt;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.ApplyPromoCodeRequestModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.RedeemPromoCodeRequestModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.RedeemVoucherCodeRequestModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.ActiveVouchersCountResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.GuestVoucherResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.GuestWelcomeVoucherResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.MyActiveVouchersRootResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.MyPossibleVouchersRootResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.PossibleBinRestrictedVoucherResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.RedeemVoucherCodeResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.ReferralSenderCampaignDetailsResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.VoucherAppliedRootResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.VoucherDetailsResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.VoucherListRootResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.network.VouchersApi;
import com.talabat.talabatnavigation.growthSquad.GrowthNavigatorActions;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0014H\u0016J&\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J&\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u0014H\u0016J>\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u000eH\u0016J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u001e\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u0014H\u0016J>\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020\u000e2\u0006\u00102\u001a\u00020\u0014H\u0016J\u001e\u00103\u001a\b\u0012\u0004\u0012\u0002040\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00105\u001a\u000206H\u0016J&\u00107\u001a\b\u0012\u0004\u0012\u0002040\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u00108\u001a\u000209H\u0016J\u0016\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u001b\u0010\u0005\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006;"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/network/VouchersService;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/network/VouchersApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "api", "getApi", "()Lcom/talabat/talabatcommon/feature/vouchers/loyalty/network/VouchersApi;", "api$delegate", "Lkotlin/Lazy;", "applyPromoCode", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/PossibleBinRestrictedVoucherResponse;", "apiVersion", "", "applyPromoCodeRequestModel", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/ApplyPromoCodeRequestModel;", "applyVoucher", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/VoucherAppliedRootResponse;", "voucherId", "", "getActiveVouchersCount", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/ActiveVouchersCountResponse;", "countryId", "getBinRestrictedVoucher", "customerVoucherId", "getGuestVoucher", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/GuestVoucherResponse;", "voucherCode", "getGuestWelcomeVoucher", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/GuestWelcomeVoucherResponse;", "getMyActiveVouchers", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/MyActiveVouchersRootResponse;", "country", "brandId", "getMyPossibleVouchers", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/MyPossibleVouchersRootResponse;", "areaId", "orderDeliveryMode", "verticalId", "getReferralsSenderCampaign", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/ReferralSenderCampaignDetailsResponse;", "getVoucher", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/VoucherDetailsResponse;", "voucherID", "getVouchersList", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/VoucherListRootResponse;", "voucherStatus", "pageNumber", "pageSize", "source", "redeemPromoCode", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/RedeemVoucherCodeResponse;", "redeemPromoCodeRequestBody", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/RedeemPromoCodeRequestModel;", "redeemVoucherCode", "redeemVoucherCodeRequestBody", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/RedeemVoucherCodeRequestModel;", "unApplyAllVouchers", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VouchersService implements VouchersApi {
    @NotNull
    private final Lazy api$delegate;

    @Inject
    public VouchersService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        this.api$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new VouchersService$api$2(talabatAPIBuilder));
    }

    private final VouchersApi getApi() {
        return (VouchersApi) this.api$delegate.getValue();
    }

    @NotNull
    public Call<PossibleBinRestrictedVoucherResponse> applyPromoCode(int i11, @NotNull ApplyPromoCodeRequestModel applyPromoCodeRequestModel) {
        Intrinsics.checkNotNullParameter(applyPromoCodeRequestModel, "applyPromoCodeRequestModel");
        return getApi().applyPromoCode(i11, applyPromoCodeRequestModel);
    }

    @NotNull
    public Call<VoucherAppliedRootResponse> applyVoucher(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, VoucherUrlConstantsKt.PATH_VOUCHER_ID);
        return getApi().applyVoucher(i11, str);
    }

    @NotNull
    public Call<ActiveVouchersCountResponse> getActiveVouchersCount(int i11, int i12) {
        return getApi().getActiveVouchersCount(i11, i12);
    }

    @NotNull
    public Call<PossibleBinRestrictedVoucherResponse> getBinRestrictedVoucher(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, VoucherUrlConstantsKt.QUERY_CUSTOMER_VOUCHER_ID);
        return getApi().getBinRestrictedVoucher(i11, str);
    }

    @NotNull
    public Call<GuestVoucherResponse> getGuestVoucher(int i11, @NotNull String str, int i12) {
        Intrinsics.checkNotNullParameter(str, "voucherCode");
        return getApi().getGuestVoucher(i11, str, i12);
    }

    @NotNull
    public Call<GuestWelcomeVoucherResponse> getGuestWelcomeVoucher(int i11, int i12) {
        return getApi().getGuestWelcomeVoucher(i11, i12);
    }

    @NotNull
    public Call<MyActiveVouchersRootResponse> getMyActiveVouchers(int i11, int i12, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "brandId");
        return getApi().getMyActiveVouchers(i11, i12, str);
    }

    @NotNull
    public Call<MyPossibleVouchersRootResponse> getMyPossibleVouchers(int i11, int i12, @NotNull String str, int i13, int i14, int i15) {
        Intrinsics.checkNotNullParameter(str, "brandId");
        return getApi().getMyPossibleVouchers(i11, i12, str, i13, i14, i15);
    }

    @NotNull
    public Call<ReferralSenderCampaignDetailsResponse> getReferralsSenderCampaign(int i11, int i12) {
        return getApi().getReferralsSenderCampaign(i11, i12);
    }

    @NotNull
    public Call<VoucherDetailsResponse> getVoucher(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, GrowthNavigatorActions.EXTRA_LOYALTY_VOUCHER_ID);
        return VouchersApi.DefaultImpls.getVoucher$default(getApi(), 0, str, 1, (Object) null);
    }

    @NotNull
    public Call<VoucherListRootResponse> getVouchersList(int i11, int i12, @NotNull String str, int i13, int i14, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, VoucherUrlConstantsKt.QUERY_VOUCHER_STATUS);
        Intrinsics.checkNotNullParameter(str2, "source");
        return getApi().getVouchersList(i11, i12, str, i13, i14, str2);
    }

    @NotNull
    public Call<RedeemVoucherCodeResponse> redeemPromoCode(int i11, @NotNull RedeemPromoCodeRequestModel redeemPromoCodeRequestModel) {
        Intrinsics.checkNotNullParameter(redeemPromoCodeRequestModel, "redeemPromoCodeRequestBody");
        return getApi().redeemPromoCode(i11, redeemPromoCodeRequestModel);
    }

    @NotNull
    public Call<RedeemVoucherCodeResponse> redeemVoucherCode(int i11, @NotNull String str, @NotNull RedeemVoucherCodeRequestModel redeemVoucherCodeRequestModel) {
        Intrinsics.checkNotNullParameter(str, "voucherCode");
        Intrinsics.checkNotNullParameter(redeemVoucherCodeRequestModel, "redeemVoucherCodeRequestBody");
        return getApi().redeemVoucherCode(i11, str, redeemVoucherCodeRequestModel);
    }

    @NotNull
    public Call<VoucherAppliedRootResponse> unApplyAllVouchers(int i11) {
        return getApi().unApplyAllVouchers(i11);
    }
}
