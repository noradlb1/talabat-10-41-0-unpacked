package com.talabat.talabatcommon.feature.vouchers.loyalty.repository;

import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.BinRestrictedVoucherModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.GuestVoucherDomainModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.GuestWelcomeVoucherDomainModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.RedeemVoucherCodeDomainModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.ReferralSenderCampaignDetailsDomainModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.VoucherDetailDomainModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.ApplyVoucherViewHolderDisplayModel;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import library.talabat.mvp.home.VoucherStateDomainModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H&J\u0019\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J4\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00192\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\bH&J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\bH&J!\u0010#\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J5\u0010%\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0014\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\f0\u0019H&\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepository;", "", "applyPromoCode", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/BinRestrictedVoucherModel;", "customerVoucherId", "", "brandId", "areaId", "", "verticalId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyVoucher", "", "voucherId", "getBinRestrictedVoucher", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGuestVoucher", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/GuestVoucherDomainModel;", "voucherCode", "countryId", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGuestWelcomeVoucher", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/GuestWelcomeVoucherDomainModel;", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMyPossibleVouchers", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/ApplyVoucherViewHolderDisplayModel;", "getReferralSenderCampaignDetails", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/ReferralSenderCampaignDetailsDomainModel;", "getVoucherDetails", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/VoucherDetailDomainModel;", "voucherID", "getVouchersState", "Llibrary/talabat/mvp/home/VoucherStateDomainModel;", "redeemPromoCode", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/RedeemVoucherCodeDomainModel;", "redeemVoucherCode", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unApplyAllVouchers", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VoucherRepository {
    @Nullable
    Object applyPromoCode(@NotNull String str, @Nullable String str2, @Nullable Integer num, int i11, @NotNull Continuation<? super BinRestrictedVoucherModel> continuation);

    boolean applyVoucher(@NotNull String str);

    @Nullable
    Object getBinRestrictedVoucher(@NotNull String str, @NotNull Continuation<? super BinRestrictedVoucherModel> continuation);

    @Nullable
    Object getGuestVoucher(@NotNull String str, int i11, @NotNull Continuation<? super GuestVoucherDomainModel> continuation);

    @Nullable
    Object getGuestWelcomeVoucher(int i11, @NotNull Continuation<? super GuestWelcomeVoucherDomainModel> continuation);

    @NotNull
    Either<Failure, ApplyVoucherViewHolderDisplayModel> getMyPossibleVouchers(int i11, @NotNull String str, int i12, int i13);

    @NotNull
    ReferralSenderCampaignDetailsDomainModel getReferralSenderCampaignDetails(int i11);

    @Nullable
    Object getVoucherDetails(@NotNull String str, @NotNull Continuation<? super VoucherDetailDomainModel> continuation);

    @NotNull
    VoucherStateDomainModel getVouchersState(int i11);

    @Nullable
    Object redeemPromoCode(@NotNull String str, int i11, @NotNull Continuation<? super RedeemVoucherCodeDomainModel> continuation);

    @Nullable
    Object redeemVoucherCode(@NotNull String str, @Nullable String str2, int i11, @Nullable Integer num, @NotNull Continuation<? super RedeemVoucherCodeDomainModel> continuation);

    @NotNull
    Either<Failure, Boolean> unApplyAllVouchers();
}
