package com.talabat.talabatcommon.feature.vouchers.loyalty.repository;

import com.facebook.internal.NativeProtocol;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.RedeemBurnItemRequestModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.RedeemItemResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.RedeemItemRootResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.network.MarketPlaceRedeemBurnOptionService;
import com.talabat.talabatcommon.feature.vouchers.loyalty.network.MarketPlaceRedeemVoucherApi;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType;
import com.talabat.talabatcommon.views.vouchers.models.ConfirmationDisplayModel;
import com.talabat.talabatcommon.views.vouchers.models.OrderNowDirection;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.exception.SystemError;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatcore.platform.NetworkHandler;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Response;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/MarketPlaceRedeemBurnOptionRepositoryImpl;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/MarketPlaceRedeemBurnOptionRepository;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "service", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/network/MarketPlaceRedeemBurnOptionService;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/network/MarketPlaceRedeemBurnOptionService;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "getNetworkHandler", "()Lcom/talabat/talabatcore/platform/NetworkHandler;", "getService", "()Lcom/talabat/talabatcommon/feature/vouchers/loyalty/network/MarketPlaceRedeemBurnOptionService;", "redeemVoucher", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatcommon/views/vouchers/models/ConfirmationDisplayModel;", "params", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/RedeemBurnItemRequestModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class MarketPlaceRedeemBurnOptionRepositoryImpl implements MarketPlaceRedeemBurnOptionRepository {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull

    /* renamed from: service  reason: collision with root package name */
    private final MarketPlaceRedeemBurnOptionService f61646service;

    public MarketPlaceRedeemBurnOptionRepositoryImpl(@NotNull NetworkHandler networkHandler2, @NotNull MarketPlaceRedeemBurnOptionService marketPlaceRedeemBurnOptionService, @NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(marketPlaceRedeemBurnOptionService, "service");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.networkHandler = networkHandler2;
        this.f61646service = marketPlaceRedeemBurnOptionService;
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    @NotNull
    public NetworkHandler getNetworkHandler() {
        return this.networkHandler;
    }

    @NotNull
    public MarketPlaceRedeemBurnOptionService getService() {
        return this.f61646service;
    }

    @NotNull
    public Either<Failure, ConfirmationDisplayModel> redeemVoucher(@NotNull RedeemBurnItemRequestModel redeemBurnItemRequestModel) {
        String str;
        ConfirmationDisplayModel confirmationDisplayModel;
        String str2;
        String str3;
        String str4;
        String str5;
        VoucherOptionType voucherOptionType;
        String str6 = "";
        Intrinsics.checkNotNullParameter(redeemBurnItemRequestModel, NativeProtocol.WEB_DIALOG_PARAMS);
        boolean isConnected = getNetworkHandler().isConnected();
        if (isConnected) {
            int countryId = this.configurationLocalRepository.selectedCountry().getCountryId();
            MarketPlaceRedeemBurnOptionService service2 = getService();
            String itemId = redeemBurnItemRequestModel.getItemId();
            String stringValue = redeemBurnItemRequestModel.getBurnOptionType().getStringValue();
            String stringValue2 = redeemBurnItemRequestModel.getSource().getStringValue();
            if (redeemBurnItemRequestModel.getVoucherOptionType() == VoucherOptionType.NONE || (voucherOptionType = redeemBurnItemRequestModel.getVoucherOptionType()) == null) {
                str = null;
            } else {
                str = voucherOptionType.name();
            }
            Call redeemItem$default = MarketPlaceRedeemVoucherApi.DefaultImpls.redeemItem$default(service2, countryId, 0, itemId, stringValue, stringValue2, str, 2, (Object) null);
            Object redeemItemRootResponse = new RedeemItemRootResponse();
            try {
                Response execute = redeemItem$default.clone().execute();
                boolean isSuccessful = execute.isSuccessful();
                if (isSuccessful) {
                    Object body = execute.body();
                    if (body != null) {
                        redeemItemRootResponse = body;
                    }
                    RedeemItemResponse redeemItemResponse = (RedeemItemResponse) ((RedeemItemRootResponse) redeemItemRootResponse).getResult();
                    if (redeemItemResponse != null) {
                        String customerVoucherId = redeemItemResponse.getCustomerVoucherId();
                        if (customerVoucherId == null) {
                            str2 = str6;
                        } else {
                            str2 = customerVoucherId;
                        }
                        String couponCode = redeemItemResponse.getCouponCode();
                        if (couponCode == null) {
                            str3 = str6;
                        } else {
                            str3 = couponCode;
                        }
                        boolean orFalse = BooleanKt.orFalse(redeemItemResponse.isSuccess());
                        String partnerLink = redeemItemResponse.getPartnerLink();
                        if (partnerLink == null) {
                            str4 = str6;
                        } else {
                            str4 = partnerLink;
                        }
                        String partnerButtonLink = redeemItemResponse.getPartnerButtonLink();
                        if (partnerButtonLink == null) {
                            str5 = str6;
                        } else {
                            str5 = partnerButtonLink;
                        }
                        confirmationDisplayModel = new ConfirmationDisplayModel(str2, str3, str4, str5, orFalse, redeemItemResponse.getBrandId(), redeemItemResponse.getDescription(), (OrderNowDirection) null, 128, (DefaultConstructorMarker) null);
                    } else {
                        confirmationDisplayModel = new ConfirmationDisplayModel((String) null, (String) null, (String) null, (String) null, false, (Integer) null, (String) null, (OrderNowDirection) null, 255, (DefaultConstructorMarker) null);
                    }
                    return new Either.Right(confirmationDisplayModel);
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
                if (message != null) {
                    str6 = message;
                }
                return new Either.Left(new SystemError(str6));
            }
        } else if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
