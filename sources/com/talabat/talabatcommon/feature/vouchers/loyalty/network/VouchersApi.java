package com.talabat.talabatcommon.feature.vouchers.loyalty.network;

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
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\fH'J\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'J\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\fH'J,\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0014\u001a\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'J\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'J,\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010\u001a\u001a\u00020\fH'JJ\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010\u001a\u001a\u00020\f2\b\b\u0001\u0010\u001d\u001a\u00020\u00062\b\b\u0001\u0010\u001e\u001a\u00020\u00062\b\b\u0001\u0010\u001f\u001a\u00020\u0006H'J\"\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'J\"\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010$\u001a\u00020\fH'JJ\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\u00062\b\b\u0001\u0010'\u001a\u00020\f2\b\b\u0001\u0010(\u001a\u00020\u00062\b\b\u0001\u0010)\u001a\u00020\u00062\b\b\u0003\u0010*\u001a\u00020\fH'J\"\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010-\u001a\u00020.H'J,\u0010/\u001a\b\u0012\u0004\u0012\u00020,0\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0014\u001a\u00020\f2\b\b\u0001\u00100\u001a\u000201H'J\u0018\u00102\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006H'¨\u00063"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/network/VouchersApi;", "", "applyPromoCode", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/PossibleBinRestrictedVoucherResponse;", "apiVersion", "", "applyPromoCodeRequestModel", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/ApplyPromoCodeRequestModel;", "applyVoucher", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/VoucherAppliedRootResponse;", "voucherId", "", "getActiveVouchersCount", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/ActiveVouchersCountResponse;", "countryId", "getBinRestrictedVoucher", "customerVoucherId", "getGuestVoucher", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/GuestVoucherResponse;", "voucherCode", "getGuestWelcomeVoucher", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/GuestWelcomeVoucherResponse;", "getMyActiveVouchers", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/MyActiveVouchersRootResponse;", "country", "brandId", "getMyPossibleVouchers", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/MyPossibleVouchersRootResponse;", "areaId", "orderDeliveryMode", "verticalId", "getReferralsSenderCampaign", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/ReferralSenderCampaignDetailsResponse;", "getVoucher", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/VoucherDetailsResponse;", "voucherID", "getVouchersList", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/VoucherListRootResponse;", "voucherStatus", "pageNumber", "pageSize", "source", "redeemPromoCode", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/RedeemVoucherCodeResponse;", "redeemPromoCodeRequestBody", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/RedeemPromoCodeRequestModel;", "redeemVoucherCode", "redeemVoucherCodeRequestBody", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/RedeemVoucherCodeRequestModel;", "unApplyAllVouchers", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VouchersApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Call applyPromoCode$default(VouchersApi vouchersApi, int i11, ApplyPromoCodeRequestModel applyPromoCodeRequestModel, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    i11 = 3;
                }
                return vouchersApi.applyPromoCode(i11, applyPromoCodeRequestModel);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyPromoCode");
        }

        public static /* synthetic */ Call applyVoucher$default(VouchersApi vouchersApi, int i11, String str, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    i11 = 1;
                }
                return vouchersApi.applyVoucher(i11, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyVoucher");
        }

        public static /* synthetic */ Call getActiveVouchersCount$default(VouchersApi vouchersApi, int i11, int i12, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 1) != 0) {
                    i11 = 1;
                }
                return vouchersApi.getActiveVouchersCount(i11, i12);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getActiveVouchersCount");
        }

        public static /* synthetic */ Call getBinRestrictedVoucher$default(VouchersApi vouchersApi, int i11, String str, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    i11 = 2;
                }
                return vouchersApi.getBinRestrictedVoucher(i11, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBinRestrictedVoucher");
        }

        public static /* synthetic */ Call getGuestVoucher$default(VouchersApi vouchersApi, int i11, String str, int i12, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 1) != 0) {
                    i11 = 1;
                }
                return vouchersApi.getGuestVoucher(i11, str, i12);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGuestVoucher");
        }

        public static /* synthetic */ Call getGuestWelcomeVoucher$default(VouchersApi vouchersApi, int i11, int i12, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 1) != 0) {
                    i11 = 1;
                }
                return vouchersApi.getGuestWelcomeVoucher(i11, i12);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getGuestWelcomeVoucher");
        }

        public static /* synthetic */ Call getMyActiveVouchers$default(VouchersApi vouchersApi, int i11, int i12, String str, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 1) != 0) {
                    i11 = 1;
                }
                return vouchersApi.getMyActiveVouchers(i11, i12, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMyActiveVouchers");
        }

        public static /* synthetic */ Call getMyPossibleVouchers$default(VouchersApi vouchersApi, int i11, int i12, String str, int i13, int i14, int i15, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 1) != 0) {
                    i11 = 2;
                }
                return vouchersApi.getMyPossibleVouchers(i11, i12, str, i13, i14, i15);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMyPossibleVouchers");
        }

        public static /* synthetic */ Call getReferralsSenderCampaign$default(VouchersApi vouchersApi, int i11, int i12, int i13, Object obj) {
            if (obj == null) {
                if ((i13 & 1) != 0) {
                    i11 = 1;
                }
                return vouchersApi.getReferralsSenderCampaign(i11, i12);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getReferralsSenderCampaign");
        }

        public static /* synthetic */ Call getVoucher$default(VouchersApi vouchersApi, int i11, String str, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    i11 = 1;
                }
                return vouchersApi.getVoucher(i11, str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVoucher");
        }

        public static /* synthetic */ Call getVouchersList$default(VouchersApi vouchersApi, int i11, int i12, String str, int i13, int i14, String str2, int i15, Object obj) {
            if (obj == null) {
                if ((i15 & 1) != 0) {
                    i11 = 2;
                }
                int i16 = i11;
                if ((i15 & 32) != 0) {
                    str2 = "wallet";
                }
                return vouchersApi.getVouchersList(i16, i12, str, i13, i14, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVouchersList");
        }

        public static /* synthetic */ Call redeemPromoCode$default(VouchersApi vouchersApi, int i11, RedeemPromoCodeRequestModel redeemPromoCodeRequestModel, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    i11 = 3;
                }
                return vouchersApi.redeemPromoCode(i11, redeemPromoCodeRequestModel);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: redeemPromoCode");
        }

        public static /* synthetic */ Call redeemVoucherCode$default(VouchersApi vouchersApi, int i11, String str, RedeemVoucherCodeRequestModel redeemVoucherCodeRequestModel, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    i11 = 2;
                }
                return vouchersApi.redeemVoucherCode(i11, str, redeemVoucherCodeRequestModel);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: redeemVoucherCode");
        }

        public static /* synthetic */ Call unApplyAllVouchers$default(VouchersApi vouchersApi, int i11, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    i11 = 1;
                }
                return vouchersApi.unApplyAllVouchers(i11);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unApplyAllVouchers");
        }
    }

    @NotNull
    @PUT("/api/v{version}/me/vouchers/apply")
    Call<PossibleBinRestrictedVoucherResponse> applyPromoCode(@Path("version") int i11, @NotNull @Body ApplyPromoCodeRequestModel applyPromoCodeRequestModel);

    @NotNull
    @PUT("/api/v{version}/me/vouchers/{voucherId}/applied")
    Call<VoucherAppliedRootResponse> applyVoucher(@Path("version") int i11, @NotNull @Path("voucherId") String str);

    @NotNull
    @GET("/api/v{version}/me/vouchers-stats")
    Call<ActiveVouchersCountResponse> getActiveVouchersCount(@Path("version") int i11, @Query("country") int i12);

    @NotNull
    @PUT("/api/v{version}/me/vouchers/apply")
    Call<PossibleBinRestrictedVoucherResponse> getBinRestrictedVoucher(@Path("version") int i11, @NotNull @Query("customerVoucherId") String str);

    @NotNull
    @GET("/api/v{version}/guest/voucher-code-details")
    Call<GuestVoucherResponse> getGuestVoucher(@Path("version") int i11, @NotNull @Query("voucherCode") String str, @Query("country") int i12);

    @NotNull
    @GET("/api/v{version}/guest/welcome-voucher")
    Call<GuestWelcomeVoucherResponse> getGuestWelcomeVoucher(@Path("version") int i11, @Query("country") int i12);

    @NotNull
    @GET("/api/v{version}/me/active-vouchers")
    Call<MyActiveVouchersRootResponse> getMyActiveVouchers(@Path("version") int i11, @Query("country") int i12, @NotNull @Query("brandId") String str);

    @NotNull
    @GET("/api/v{version}/me/possible-vouchers")
    Call<MyPossibleVouchersRootResponse> getMyPossibleVouchers(@Path("version") int i11, @Query("country") int i12, @NotNull @Query("brandId") String str, @Query("areaId") int i13, @Query("orderDeliveryMode") int i14, @Query("verticalId") int i15);

    @NotNull
    @GET("/api/v{version}/referrals/campaign/{countryId}/sender")
    Call<ReferralSenderCampaignDetailsResponse> getReferralsSenderCampaign(@Path("version") int i11, @Path("countryId") int i12);

    @NotNull
    @GET("/api/v{version}/me/vouchers/{voucherId}")
    Call<VoucherDetailsResponse> getVoucher(@Path("version") int i11, @NotNull @Path("voucherId") String str);

    @NotNull
    @GET("/api/v{version}/me/vouchers")
    Call<VoucherListRootResponse> getVouchersList(@Path("version") int i11, @Query("country") int i12, @NotNull @Query("voucherStatus") String str, @Query("Page") int i13, @Query("Size") int i14, @NotNull @Query("source") String str2);

    @NotNull
    @POST("/api/v{version}/me/promo-codes/redeem")
    Call<RedeemVoucherCodeResponse> redeemPromoCode(@Path("version") int i11, @NotNull @Body RedeemPromoCodeRequestModel redeemPromoCodeRequestModel);

    @NotNull
    @POST("/api/v{version}/me/voucher-codes/{voucher-code}/redeem")
    Call<RedeemVoucherCodeResponse> redeemVoucherCode(@Path("version") int i11, @NotNull @Path("voucher-code") String str, @NotNull @Body RedeemVoucherCodeRequestModel redeemVoucherCodeRequestModel);

    @NotNull
    @POST("/api/v{version}/me/vouchers/unapply-all")
    Call<VoucherAppliedRootResponse> unApplyAllVouchers(@Path("version") int i11);
}
