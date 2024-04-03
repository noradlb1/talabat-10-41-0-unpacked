package com.talabat.gem.adapters.data;

import com.talabat.gem.domain.usecases.BusinessRulesKt;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u0006H'J,\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\b\b\u0003\u0010\t\u001a\u00020\u00062\b\b\u0003\u0010\n\u001a\u00020\u00062\b\b\u0003\u0010\u000b\u001a\u00020\fH'J\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0003\u0010\u000f\u001a\u00020\u0006H'¨\u0006\u0010"}, d2 = {"Lcom/talabat/gem/adapters/data/GemEndPoints;", "", "requestAccept", "Lio/reactivex/Single;", "Lcom/talabat/gem/adapters/data/GemAcceptRawResponse;", "acceptUrl", "", "requestOffersByLocation", "Lcom/talabat/gem/adapters/data/GemOfferRawResponse;", "api", "experimentName", "request", "Lcom/talabat/gem/adapters/data/GemOffersByLocationRequest;", "requestReject", "Lcom/talabat/gem/adapters/data/GemRejectRawResponse;", "rejectUrl", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GemEndPoints {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Single requestAccept$default(GemEndPoints gemEndPoints, String str, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    str = ServerKt.acceptUrl(ServerKt.offerId(), ServerKt.reservationCode());
                }
                return gemEndPoints.requestAccept(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestAccept");
        }

        public static /* synthetic */ Single requestOffersByLocation$default(GemEndPoints gemEndPoints, String str, String str2, GemOffersByLocationRequest gemOffersByLocationRequest, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    str = ServerKt.offersByLocationUrl();
                }
                if ((i11 & 2) != 0) {
                    str2 = "percentage-gem-tier:" + BusinessRulesKt.isPercentage(BusinessRulesKt.getGemPercentageVariant());
                }
                if ((i11 & 4) != 0) {
                    gemOffersByLocationRequest = new GemOffersByLocationRequest((Double) null, (Double) null, false, 0, 15, (DefaultConstructorMarker) null);
                }
                return gemEndPoints.requestOffersByLocation(str, str2, gemOffersByLocationRequest);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestOffersByLocation");
        }

        public static /* synthetic */ Single requestReject$default(GemEndPoints gemEndPoints, String str, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    str = ServerKt.rejectUrl(ServerKt.offerId());
                }
                return gemEndPoints.requestReject(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestReject");
        }
    }

    @NotNull
    @GET
    Single<GemAcceptRawResponse> requestAccept(@NotNull @Url String str);

    @NotNull
    @POST
    Single<GemOfferRawResponse> requestOffersByLocation(@NotNull @Url String str, @NotNull @Header("X-AB-TEST") String str2, @NotNull @Body GemOffersByLocationRequest gemOffersByLocationRequest);

    @NotNull
    @GET
    Single<GemRejectRawResponse> requestReject(@NotNull @Url String str);
}
