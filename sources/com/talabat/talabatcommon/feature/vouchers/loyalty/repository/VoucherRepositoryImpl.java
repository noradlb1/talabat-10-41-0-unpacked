package com.talabat.talabatcommon.feature.vouchers.loyalty.repository;

import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcommon.feature.vouchers.loyalty.VoucherUrlConstantsKt;
import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.BinRestrictedVoucherModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.GuestVoucherDomainModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.GuestWelcomeVoucherDomainModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.MapperKt;
import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.RedeemVoucherCodeDomainModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.ReferralSenderCampaignDetailsDomainModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.VoucherDetailDomainModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.ApplyPromoCodeRequestModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.RedeemPromoCodeRequestModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.RedeemVoucherCodeRequestModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.ActiveVouchersCount;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.ActiveVouchersCountResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.BinRestrictedVoucherResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.BoundsResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.GuestVoucherResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.GuestVoucherResult;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.GuestWelcomeVoucherResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.GuestWelcomeVoucherResult;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.MyPossibleVouchersRootResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.PossibleBinRestrictedVoucherResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.RedeemVoucherCodeResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.RedeemVoucherCodeResult;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.ReferralSenderCampaignDetailsResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.ReferralSenderCampaignDetailsResult;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.VoucherAppliedRootResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.VoucherDetailsResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.VoucherResponseModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.network.VouchersApi;
import com.talabat.talabatcommon.feature.vouchers.loyalty.network.VouchersService;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.ApplyVoucherViewHolderDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.ApplyVoucherViewModelMapperKt;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.exception.ServerError;
import com.talabat.talabatcore.exception.SystemError;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatcore.platform.NetworkHandler;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.home.VoucherStateDomainModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Call;
import retrofit2.Response;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J5\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH\u0016J\u0019\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J!\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ4\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u001a\u001a\u00020\tH\u0016J!\u0010*\u001a\u00020+2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ5\u0010,\u001a\u00020+2\u0006\u0010\u0019\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001a\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH@ø\u0001\u0000¢\u0006\u0002\u0010-J\u0014\u0010.\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00130 H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepositoryImpl;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepository;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "service", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/network/VouchersService;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/network/VouchersService;)V", "orderDeliveryMode", "Lkotlin/Function0;", "", "applyPromoCode", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/BinRestrictedVoucherModel;", "customerVoucherId", "", "brandId", "areaId", "verticalId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "applyVoucher", "", "voucherId", "getBinRestrictedVoucher", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGuestVoucher", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/GuestVoucherDomainModel;", "voucherCode", "countryId", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGuestWelcomeVoucher", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/GuestWelcomeVoucherDomainModel;", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMyPossibleVouchers", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/ApplyVoucherViewHolderDisplayModel;", "getReferralSenderCampaignDetails", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/ReferralSenderCampaignDetailsDomainModel;", "getVoucherDetails", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/VoucherDetailDomainModel;", "voucherID", "getVouchersState", "Llibrary/talabat/mvp/home/VoucherStateDomainModel;", "redeemPromoCode", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/RedeemVoucherCodeDomainModel;", "redeemVoucherCode", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unApplyAllVouchers", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherRepositoryImpl implements VoucherRepository {
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull
    private final Function0<Integer> orderDeliveryMode = VoucherRepositoryImpl$orderDeliveryMode$1.INSTANCE;
    @NotNull

    /* renamed from: service  reason: collision with root package name */
    private final VouchersService f61647service;

    @Inject
    public VoucherRepositoryImpl(@NotNull NetworkHandler networkHandler2, @NotNull VouchersService vouchersService) {
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(vouchersService, "service");
        this.networkHandler = networkHandler2;
        this.f61647service = vouchersService;
    }

    @Nullable
    public Object applyPromoCode(@NotNull String str, @Nullable String str2, @Nullable Integer num, int i11, @NotNull Continuation<? super BinRestrictedVoucherModel> continuation) throws Failure {
        BinRestrictedVoucherModel domainModel;
        boolean isConnected = this.networkHandler.isConnected();
        boolean z11 = true;
        if (isConnected) {
            BinRestrictedVoucherResponse binRestrictedVoucherResponse = null;
            Object result = ((PossibleBinRestrictedVoucherResponse) RequestKt.requestWithErrorHandle(VouchersApi.DefaultImpls.applyPromoCode$default(this.f61647service, 0, new ApplyPromoCodeRequestModel(str, str2, num, this.orderDeliveryMode.invoke(), Boxing.boxInt(i11)), 1, (Object) null))).getResult();
            if (((BinRestrictedVoucherResponse) result) == null) {
                z11 = false;
            }
            if (z11) {
                binRestrictedVoucherResponse = result;
            }
            BinRestrictedVoucherResponse binRestrictedVoucherResponse2 = binRestrictedVoucherResponse;
            if (binRestrictedVoucherResponse2 != null && (domainModel = MapperKt.toDomainModel(binRestrictedVoucherResponse2)) != null) {
                return domainModel;
            }
            throw new ServerError((Integer) null, "Fail to get user's bin restricted voucher", (String) null, 5, (DefaultConstructorMarker) null);
        } else if (!isConnected) {
            throw Failure.NetworkConnection.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public boolean applyVoucher(@NotNull String str) throws Failure {
        Intrinsics.checkNotNullParameter(str, VoucherUrlConstantsKt.PATH_VOUCHER_ID);
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            Boolean bool = (Boolean) ((VoucherAppliedRootResponse) RequestKt.requestWithErrorHandle(VouchersApi.DefaultImpls.applyVoucher$default(this.f61647service, 0, str, 1, (Object) null))).getResult();
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } else if (!isConnected) {
            throw Failure.NetworkConnection.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Nullable
    public Object getBinRestrictedVoucher(@NotNull String str, @NotNull Continuation<? super BinRestrictedVoucherModel> continuation) throws Failure {
        BinRestrictedVoucherModel domainModel;
        boolean isConnected = this.networkHandler.isConnected();
        boolean z11 = true;
        if (isConnected) {
            BinRestrictedVoucherResponse binRestrictedVoucherResponse = null;
            Object result = ((PossibleBinRestrictedVoucherResponse) RequestKt.requestWithErrorHandle(VouchersApi.DefaultImpls.getBinRestrictedVoucher$default(this.f61647service, 0, str, 1, (Object) null))).getResult();
            if (((BinRestrictedVoucherResponse) result) == null) {
                z11 = false;
            }
            if (z11) {
                binRestrictedVoucherResponse = result;
            }
            BinRestrictedVoucherResponse binRestrictedVoucherResponse2 = binRestrictedVoucherResponse;
            if (binRestrictedVoucherResponse2 != null && (domainModel = MapperKt.toDomainModel(binRestrictedVoucherResponse2)) != null) {
                return domainModel;
            }
            throw new ServerError((Integer) null, "Fail to get user's bin restricted voucher", (String) null, 5, (DefaultConstructorMarker) null);
        } else if (!isConnected) {
            throw Failure.NetworkConnection.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Nullable
    public Object getGuestVoucher(@NotNull String str, int i11, @NotNull Continuation<? super GuestVoucherDomainModel> continuation) {
        GuestVoucherDomainModel domainModel;
        boolean isConnected = this.networkHandler.isConnected();
        boolean z11 = true;
        if (isConnected) {
            Object result = ((GuestVoucherResponse) RequestKt.requestWithErrorHandle(VouchersApi.DefaultImpls.getGuestVoucher$default(this.f61647service, 0, str, i11, 1, (Object) null))).getResult();
            if (((GuestVoucherResult) result) == null) {
                z11 = false;
            }
            if (!z11) {
                result = null;
            }
            GuestVoucherResult guestVoucherResult = (GuestVoucherResult) result;
            if (guestVoucherResult != null && (domainModel = MapperKt.toDomainModel(guestVoucherResult)) != null) {
                return domainModel;
            }
            throw new ServerError((Integer) null, "Fail to get guest voucher", (String) null, 5, (DefaultConstructorMarker) null);
        } else if (!isConnected) {
            throw Failure.NetworkConnection.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Nullable
    public Object getGuestWelcomeVoucher(int i11, @NotNull Continuation<? super GuestWelcomeVoucherDomainModel> continuation) {
        GuestWelcomeVoucherDomainModel domainModel;
        boolean isConnected = this.networkHandler.isConnected();
        boolean z11 = true;
        if (isConnected) {
            GuestWelcomeVoucherResult guestWelcomeVoucherResult = null;
            Object result = ((GuestWelcomeVoucherResponse) RequestKt.requestWithErrorHandle(VouchersApi.DefaultImpls.getGuestWelcomeVoucher$default(this.f61647service, 0, i11, 1, (Object) null))).getResult();
            if (((GuestWelcomeVoucherResult) result) == null) {
                z11 = false;
            }
            if (z11) {
                guestWelcomeVoucherResult = result;
            }
            GuestWelcomeVoucherResult guestWelcomeVoucherResult2 = guestWelcomeVoucherResult;
            if (guestWelcomeVoucherResult2 != null && (domainModel = MapperKt.toDomainModel(guestWelcomeVoucherResult2)) != null) {
                return domainModel;
            }
            throw new ServerError((Integer) null, "Fail to get guest welcome voucher", (String) null, 5, (DefaultConstructorMarker) null);
        } else if (!isConnected) {
            throw Failure.NetworkConnection.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public Either<Failure, ApplyVoucherViewHolderDisplayModel> getMyPossibleVouchers(int i11, @NotNull String str, int i12, int i13) {
        Intrinsics.checkNotNullParameter(str, "brandId");
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            Call myPossibleVouchers$default = VouchersApi.DefaultImpls.getMyPossibleVouchers$default(this.f61647service, 0, i11, str, i12, this.orderDeliveryMode.invoke().intValue(), i13, 1, (Object) null);
            Object myPossibleVouchersRootResponse = new MyPossibleVouchersRootResponse();
            try {
                Response execute = myPossibleVouchers$default.clone().execute();
                boolean isSuccessful = execute.isSuccessful();
                if (isSuccessful) {
                    Object body = execute.body();
                    if (body != null) {
                        myPossibleVouchersRootResponse = body;
                    }
                    ApplyVoucherViewHolderDisplayModel applyVoucherViewHolderDisplayModel = new ApplyVoucherViewHolderDisplayModel();
                    ApplyVoucherViewModelMapperKt.mapToApplyVoucherViewHolderDisplayModel(applyVoucherViewHolderDisplayModel, (MyPossibleVouchersRootResponse) myPossibleVouchersRootResponse);
                    return new Either.Right(applyVoucherViewHolderDisplayModel);
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

    @NotNull
    public ReferralSenderCampaignDetailsDomainModel getReferralSenderCampaignDetails(int i11) throws Failure {
        ReferralSenderCampaignDetailsDomainModel domainModel;
        boolean isConnected = this.networkHandler.isConnected();
        boolean z11 = true;
        if (isConnected) {
            ReferralSenderCampaignDetailsResult referralSenderCampaignDetailsResult = null;
            Object result = ((ReferralSenderCampaignDetailsResponse) RequestKt.requestWithErrorHandle(VouchersApi.DefaultImpls.getReferralsSenderCampaign$default(this.f61647service, 0, i11, 1, (Object) null))).getResult();
            if (((ReferralSenderCampaignDetailsResult) result) == null) {
                z11 = false;
            }
            if (z11) {
                referralSenderCampaignDetailsResult = result;
            }
            ReferralSenderCampaignDetailsResult referralSenderCampaignDetailsResult2 = referralSenderCampaignDetailsResult;
            if (referralSenderCampaignDetailsResult2 != null && (domainModel = MapperKt.toDomainModel(referralSenderCampaignDetailsResult2)) != null) {
                return domainModel;
            }
            throw new ServerError((Integer) null, "Fail to get raf sender campaign", (String) null, 5, (DefaultConstructorMarker) null);
        } else if (!isConnected) {
            throw Failure.NetworkConnection.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Nullable
    public Object getVoucherDetails(@NotNull String str, @NotNull Continuation<? super VoucherDetailDomainModel> continuation) throws Failure {
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            VoucherResponseModel voucherResponseModel = (VoucherResponseModel) ((VoucherDetailsResponse) RequestKt.requestWithErrorHandle(VouchersApi.DefaultImpls.getVoucher$default(this.f61647service, 0, str, 1, (Object) null))).getResult();
            if (voucherResponseModel == null) {
                voucherResponseModel = new VoucherResponseModel((String) null, (Integer) null, (String) null, (List) null, (Float) null, (String) null, (Float) null, (Float) null, (Integer) null, (BoundsResponse) null, (Integer) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 262143, (DefaultConstructorMarker) null);
            }
            return MapperKt.toDomainModel(voucherResponseModel);
        } else if (!isConnected) {
            throw Failure.NetworkConnection.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public VoucherStateDomainModel getVouchersState(int i11) throws Failure {
        VoucherStateDomainModel domainModel;
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            ActiveVouchersCount activeVouchersCount = (ActiveVouchersCount) ((ActiveVouchersCountResponse) RequestKt.requestWithErrorHandle(VouchersApi.DefaultImpls.getActiveVouchersCount$default(this.f61647service, 0, i11, 1, (Object) null))).getResult();
            if (activeVouchersCount != null && (domainModel = MapperKt.toDomainModel(activeVouchersCount)) != null) {
                return domainModel;
            }
            throw new ServerError((Integer) null, "Fail to get user vouchers count", (String) null, 5, (DefaultConstructorMarker) null);
        } else if (!isConnected) {
            throw Failure.NetworkConnection.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Nullable
    public Object redeemPromoCode(@NotNull String str, int i11, @NotNull Continuation<? super RedeemVoucherCodeDomainModel> continuation) {
        RedeemVoucherCodeDomainModel domainModel;
        boolean isConnected = this.networkHandler.isConnected();
        boolean z11 = true;
        if (isConnected) {
            VouchersService vouchersService = this.f61647service;
            RedeemPromoCodeRequestModel redeemPromoCodeRequestModel = new RedeemPromoCodeRequestModel(str, i11);
            RedeemVoucherCodeResult redeemVoucherCodeResult = null;
            Object result = ((RedeemVoucherCodeResponse) RequestKt.requestWithErrorHandle(VouchersApi.DefaultImpls.redeemPromoCode$default(vouchersService, 0, redeemPromoCodeRequestModel, 1, (Object) null))).getResult();
            if (((RedeemVoucherCodeResult) result) == null) {
                z11 = false;
            }
            if (z11) {
                redeemVoucherCodeResult = result;
            }
            RedeemVoucherCodeResult redeemVoucherCodeResult2 = redeemVoucherCodeResult;
            if (redeemVoucherCodeResult2 != null && (domainModel = MapperKt.toDomainModel(redeemVoucherCodeResult2)) != null) {
                return domainModel;
            }
            throw new ServerError((Integer) null, "Fail to redeem promo code", (String) null, 5, (DefaultConstructorMarker) null);
        } else if (!isConnected) {
            throw Failure.NetworkConnection.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Nullable
    public Object redeemVoucherCode(@NotNull String str, @Nullable String str2, int i11, @Nullable Integer num, @NotNull Continuation<? super RedeemVoucherCodeDomainModel> continuation) throws Failure {
        RedeemVoucherCodeDomainModel domainModel;
        boolean isConnected = this.networkHandler.isConnected();
        boolean z11 = true;
        if (isConnected) {
            Object result = ((RedeemVoucherCodeResponse) RequestKt.requestWithErrorHandle(VouchersApi.DefaultImpls.redeemVoucherCode$default(this.f61647service, 0, str, new RedeemVoucherCodeRequestModel(str2, i11, num, this.orderDeliveryMode.invoke().intValue()), 1, (Object) null))).getResult();
            if (((RedeemVoucherCodeResult) result) == null) {
                z11 = false;
            }
            if (!z11) {
                result = null;
            }
            RedeemVoucherCodeResult redeemVoucherCodeResult = (RedeemVoucherCodeResult) result;
            if (redeemVoucherCodeResult != null && (domainModel = MapperKt.toDomainModel(redeemVoucherCodeResult)) != null) {
                return domainModel;
            }
            throw new ServerError((Integer) null, "Fail to redeem promo code", (String) null, 5, (DefaultConstructorMarker) null);
        } else if (!isConnected) {
            throw Failure.NetworkConnection.INSTANCE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public Either<Failure, Boolean> unApplyAllVouchers() {
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            Call unApplyAllVouchers$default = VouchersApi.DefaultImpls.unApplyAllVouchers$default(this.f61647service, 0, 1, (Object) null);
            Object voucherAppliedRootResponse = new VoucherAppliedRootResponse();
            try {
                Response execute = unApplyAllVouchers$default.clone().execute();
                boolean isSuccessful = execute.isSuccessful();
                if (isSuccessful) {
                    Object body = execute.body();
                    if (body != null) {
                        voucherAppliedRootResponse = body;
                    }
                    VoucherAppliedRootResponse voucherAppliedRootResponse2 = (VoucherAppliedRootResponse) voucherAppliedRootResponse;
                    return new Either.Right(Boolean.TRUE);
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
