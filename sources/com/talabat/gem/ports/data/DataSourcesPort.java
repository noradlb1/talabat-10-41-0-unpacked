package com.talabat.gem.ports.data;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemOfferAcceptance;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.entities.Location;
import com.talabat.gem.ports.data.GemAcceptanceDataSourcesPort;
import com.talabat.gem.ports.data.GemExpirationDataSourcesPort;
import com.talabat.gem.ports.data.GemOfferDataSourcesPort;
import com.talabat.gem.ports.data.RestaurantsDataSourcesPort;
import com.talabat.gem.ports.data.SessionDataSourcesPort;
import com.talabat.gem.ports.data.UserInfoDataSourcesPort;
import com.talabat.talabatcommon.extentions.Flag;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/gem/ports/data/DataSourcesPort;", "Lcom/talabat/gem/ports/data/GemOfferDataSourcesPort;", "Lcom/talabat/gem/ports/data/RestaurantsDataSourcesPort;", "Lcom/talabat/gem/ports/data/GemAcceptanceDataSourcesPort;", "Lcom/talabat/gem/ports/data/GemExpirationDataSourcesPort;", "Lcom/talabat/gem/ports/data/UserInfoDataSourcesPort;", "Lcom/talabat/gem/ports/data/SessionDataSourcesPort;", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DataSourcesPort extends GemOfferDataSourcesPort, RestaurantsDataSourcesPort, GemAcceptanceDataSourcesPort, GemExpirationDataSourcesPort, UserInfoDataSourcesPort, SessionDataSourcesPort {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void clearGemOffer(@NotNull DataSourcesPort dataSourcesPort) {
            SessionDataSourcesPort.DefaultImpls.clearGemOffer(dataSourcesPort);
        }

        public static boolean isExpirationAlertShown(@NotNull DataSourcesPort dataSourcesPort) {
            return GemExpirationDataSourcesPort.DefaultImpls.isExpirationAlertShown(dataSourcesPort);
        }

        public static boolean isOfferAutoTriggered(@NotNull DataSourcesPort dataSourcesPort) {
            return GemOfferDataSourcesPort.DefaultImpls.isOfferAutoTriggered(dataSourcesPort);
        }

        @Nullable
        public static GemOffer loadExpiredOffer(@NotNull DataSourcesPort dataSourcesPort) {
            return GemExpirationDataSourcesPort.DefaultImpls.loadExpiredOffer(dataSourcesPort);
        }

        @NotNull
        public static Function1<Continuation<? super Result<GemOffer>>, Object> loadGemOffer(@NotNull DataSourcesPort dataSourcesPort) {
            return GemOfferDataSourcesPort.DefaultImpls.loadGemOffer(dataSourcesPort);
        }

        @Nullable
        public static GemOfferAcceptance loadGemOfferAcceptance(@NotNull DataSourcesPort dataSourcesPort) {
            return GemAcceptanceDataSourcesPort.DefaultImpls.loadGemOfferAcceptance(dataSourcesPort);
        }

        @Nullable
        public static GemRestaurant loadSelectedGemRestaurant(@NotNull DataSourcesPort dataSourcesPort) {
            return RestaurantsDataSourcesPort.DefaultImpls.loadSelectedGemRestaurant(dataSourcesPort);
        }

        @NotNull
        public static Flag loadTriggerExpirationAlertFlag(@NotNull DataSourcesPort dataSourcesPort) {
            return GemExpirationDataSourcesPort.DefaultImpls.loadTriggerExpirationAlertFlag(dataSourcesPort);
        }

        @NotNull
        public static Observable<GemOffer> observeOnExpiredOffer(@NotNull DataSourcesPort dataSourcesPort) {
            return GemExpirationDataSourcesPort.DefaultImpls.observeOnExpiredOffer(dataSourcesPort);
        }

        @NotNull
        public static Observable<GemOffer> observeOnGemOffer(@NotNull DataSourcesPort dataSourcesPort) {
            return GemOfferDataSourcesPort.DefaultImpls.observeOnGemOffer(dataSourcesPort);
        }

        @NotNull
        public static Observable<String> observeOnLocalization(@NotNull DataSourcesPort dataSourcesPort) {
            return UserInfoDataSourcesPort.DefaultImpls.observeOnLocalization(dataSourcesPort);
        }

        @NotNull
        public static Observable<GemRestaurant> observeOnSelectedGemRestaurant(@NotNull DataSourcesPort dataSourcesPort) {
            return RestaurantsDataSourcesPort.DefaultImpls.observeOnSelectedGemRestaurant(dataSourcesPort);
        }

        @NotNull
        public static Observable<Integer> observeOnSelectedRestaurantId(@NotNull DataSourcesPort dataSourcesPort) {
            return RestaurantsDataSourcesPort.DefaultImpls.observeOnSelectedRestaurantId(dataSourcesPort);
        }

        @NotNull
        public static Observable<Location> observeOnUserLocation(@NotNull DataSourcesPort dataSourcesPort) {
            return UserInfoDataSourcesPort.DefaultImpls.observeOnUserLocation(dataSourcesPort);
        }

        @NotNull
        public static Observable<String> observeOnUserName(@NotNull DataSourcesPort dataSourcesPort) {
            return UserInfoDataSourcesPort.DefaultImpls.observeOnUserName(dataSourcesPort);
        }

        @Nullable
        public static Integer openedRestaurantIdFromAllEntryPoint(@NotNull DataSourcesPort dataSourcesPort) {
            return GemOfferDataSourcesPort.DefaultImpls.openedRestaurantIdFromAllEntryPoint(dataSourcesPort);
        }

        @NotNull
        public static Function1<Continuation<? super Result<GemOffer>>, Object> requestGemOffer(@NotNull DataSourcesPort dataSourcesPort) {
            return GemOfferDataSourcesPort.DefaultImpls.requestGemOffer(dataSourcesPort);
        }

        @NotNull
        public static Function1<Continuation<? super Result<GemOfferAcceptance.Accepted>>, Object> requestGemOfferAcceptance(@NotNull DataSourcesPort dataSourcesPort) {
            return GemAcceptanceDataSourcesPort.DefaultImpls.requestGemOfferAcceptance(dataSourcesPort);
        }

        @NotNull
        public static Function1<Continuation<? super Result<GemOffer>>, Object> requestGemOfferFromFlutterHome(@NotNull DataSourcesPort dataSourcesPort) {
            return GemOfferDataSourcesPort.DefaultImpls.requestGemOfferFromFlutterHome(dataSourcesPort);
        }

        @NotNull
        public static Function1<Continuation<? super Result<GemOfferAcceptance.Rejected>>, Object> requestGemOfferRejection(@NotNull DataSourcesPort dataSourcesPort) {
            return GemAcceptanceDataSourcesPort.DefaultImpls.requestGemOfferRejection(dataSourcesPort);
        }

        public static void resetTriggerExpirationAlertFlag(@NotNull DataSourcesPort dataSourcesPort) {
            GemExpirationDataSourcesPort.DefaultImpls.resetTriggerExpirationAlertFlag(dataSourcesPort);
        }

        @NotNull
        public static Function1<Continuation<? super Result<GemOffer>>, Object> saveGemOffer(@NotNull DataSourcesPort dataSourcesPort, @NotNull GemOffer gemOffer) {
            Intrinsics.checkNotNullParameter(gemOffer, "gemOffer");
            return GemOfferDataSourcesPort.DefaultImpls.saveGemOffer(dataSourcesPort, gemOffer);
        }

        public static void saveOfferAutoTriggered(@NotNull DataSourcesPort dataSourcesPort, boolean z11) {
            GemOfferDataSourcesPort.DefaultImpls.saveOfferAutoTriggered(dataSourcesPort, z11);
        }

        public static void saveRestaurantIdFromAllEntryPoint(@NotNull DataSourcesPort dataSourcesPort, @Nullable Integer num) {
            GemOfferDataSourcesPort.DefaultImpls.saveRestaurantIdFromAllEntryPoint(dataSourcesPort, num);
        }

        public static void setExpirationAlertShown(@NotNull DataSourcesPort dataSourcesPort, boolean z11) {
            GemExpirationDataSourcesPort.DefaultImpls.setExpirationAlertShown(dataSourcesPort, z11);
        }

        public static void updateExpiredOffer(@NotNull DataSourcesPort dataSourcesPort, @NotNull GemOffer gemOffer) {
            Intrinsics.checkNotNullParameter(gemOffer, "offer");
            GemExpirationDataSourcesPort.DefaultImpls.updateExpiredOffer(dataSourcesPort, gemOffer);
        }

        public static void updateGemOfferAcceptance(@NotNull DataSourcesPort dataSourcesPort, @Nullable GemOfferAcceptance gemOfferAcceptance) {
            GemAcceptanceDataSourcesPort.DefaultImpls.updateGemOfferAcceptance(dataSourcesPort, gemOfferAcceptance);
        }

        public static void updateSelectedGemRestaurant(@NotNull DataSourcesPort dataSourcesPort, @NotNull GemRestaurant gemRestaurant, boolean z11) {
            Intrinsics.checkNotNullParameter(gemRestaurant, "restaurant");
            RestaurantsDataSourcesPort.DefaultImpls.updateSelectedGemRestaurant(dataSourcesPort, gemRestaurant, z11);
        }
    }
}
