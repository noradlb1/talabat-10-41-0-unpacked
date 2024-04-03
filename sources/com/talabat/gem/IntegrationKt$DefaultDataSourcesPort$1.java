package com.talabat.gem;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemOfferAcceptance;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.entities.Location;
import com.talabat.gem.ports.data.DataSourcesPort;
import com.talabat.talabatcommon.extentions.Flag;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/talabat/gem/IntegrationKt$DefaultDataSourcesPort$1", "Lcom/talabat/gem/ports/data/DataSourcesPort;", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IntegrationKt$DefaultDataSourcesPort$1 implements DataSourcesPort {
    public void clearGemOffer() {
        DataSourcesPort.DefaultImpls.clearGemOffer(this);
    }

    public boolean isExpirationAlertShown() {
        return DataSourcesPort.DefaultImpls.isExpirationAlertShown(this);
    }

    public boolean isOfferAutoTriggered() {
        return DataSourcesPort.DefaultImpls.isOfferAutoTriggered(this);
    }

    @Nullable
    public GemOffer loadExpiredOffer() {
        return DataSourcesPort.DefaultImpls.loadExpiredOffer(this);
    }

    @NotNull
    public Function1<Continuation<? super Result<GemOffer>>, Object> loadGemOffer() {
        return DataSourcesPort.DefaultImpls.loadGemOffer(this);
    }

    @Nullable
    public GemOfferAcceptance loadGemOfferAcceptance() {
        return DataSourcesPort.DefaultImpls.loadGemOfferAcceptance(this);
    }

    @Nullable
    public GemRestaurant loadSelectedGemRestaurant() {
        return DataSourcesPort.DefaultImpls.loadSelectedGemRestaurant(this);
    }

    @NotNull
    public Flag loadTriggerExpirationAlertFlag() {
        return DataSourcesPort.DefaultImpls.loadTriggerExpirationAlertFlag(this);
    }

    @NotNull
    public Observable<GemOffer> observeOnExpiredOffer() {
        return DataSourcesPort.DefaultImpls.observeOnExpiredOffer(this);
    }

    @NotNull
    public Observable<GemOffer> observeOnGemOffer() {
        return DataSourcesPort.DefaultImpls.observeOnGemOffer(this);
    }

    @NotNull
    public Observable<String> observeOnLocalization() {
        return DataSourcesPort.DefaultImpls.observeOnLocalization(this);
    }

    @NotNull
    public Observable<GemRestaurant> observeOnSelectedGemRestaurant() {
        return DataSourcesPort.DefaultImpls.observeOnSelectedGemRestaurant(this);
    }

    @NotNull
    public Observable<Integer> observeOnSelectedRestaurantId() {
        return DataSourcesPort.DefaultImpls.observeOnSelectedRestaurantId(this);
    }

    @NotNull
    public Observable<Location> observeOnUserLocation() {
        return DataSourcesPort.DefaultImpls.observeOnUserLocation(this);
    }

    @NotNull
    public Observable<String> observeOnUserName() {
        return DataSourcesPort.DefaultImpls.observeOnUserName(this);
    }

    @Nullable
    public Integer openedRestaurantIdFromAllEntryPoint() {
        return DataSourcesPort.DefaultImpls.openedRestaurantIdFromAllEntryPoint(this);
    }

    @NotNull
    public Function1<Continuation<? super Result<GemOffer>>, Object> requestGemOffer() {
        return DataSourcesPort.DefaultImpls.requestGemOffer(this);
    }

    @NotNull
    public Function1<Continuation<? super Result<GemOfferAcceptance.Accepted>>, Object> requestGemOfferAcceptance() {
        return DataSourcesPort.DefaultImpls.requestGemOfferAcceptance(this);
    }

    @NotNull
    public Function1<Continuation<? super Result<GemOffer>>, Object> requestGemOfferFromFlutterHome() {
        return DataSourcesPort.DefaultImpls.requestGemOfferFromFlutterHome(this);
    }

    @NotNull
    public Function1<Continuation<? super Result<GemOfferAcceptance.Rejected>>, Object> requestGemOfferRejection() {
        return DataSourcesPort.DefaultImpls.requestGemOfferRejection(this);
    }

    public void resetTriggerExpirationAlertFlag() {
        DataSourcesPort.DefaultImpls.resetTriggerExpirationAlertFlag(this);
    }

    @NotNull
    public Function1<Continuation<? super Result<GemOffer>>, Object> saveGemOffer(@NotNull GemOffer gemOffer) {
        return DataSourcesPort.DefaultImpls.saveGemOffer(this, gemOffer);
    }

    public void saveOfferAutoTriggered(boolean z11) {
        DataSourcesPort.DefaultImpls.saveOfferAutoTriggered(this, z11);
    }

    public void saveRestaurantIdFromAllEntryPoint(@Nullable Integer num) {
        DataSourcesPort.DefaultImpls.saveRestaurantIdFromAllEntryPoint(this, num);
    }

    public void setExpirationAlertShown(boolean z11) {
        DataSourcesPort.DefaultImpls.setExpirationAlertShown(this, z11);
    }

    public void updateExpiredOffer(@NotNull GemOffer gemOffer) {
        DataSourcesPort.DefaultImpls.updateExpiredOffer(this, gemOffer);
    }

    public void updateGemOfferAcceptance(@Nullable GemOfferAcceptance gemOfferAcceptance) {
        DataSourcesPort.DefaultImpls.updateGemOfferAcceptance(this, gemOfferAcceptance);
    }

    public void updateSelectedGemRestaurant(@NotNull GemRestaurant gemRestaurant, boolean z11) {
        DataSourcesPort.DefaultImpls.updateSelectedGemRestaurant(this, gemRestaurant, z11);
    }
}
