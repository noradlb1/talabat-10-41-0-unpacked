package com.talabat.gem.adapters.data;

import android.content.Context;
import com.talabat.gem.GemIntegrationDsl;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemOfferAcceptance;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.entities.Location;
import com.talabat.gem.ports.data.DataSourcesPort;
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

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007B\u000f\b\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\r\u001a\u00020\u000eH\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u0001J\t\u0010\u0011\u001a\u00020\u0010H\u0001J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0001J0\u0010\u0014\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00170\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0015H\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0001J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u0001J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130!H\u0001J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130!H\u0001J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0!H\u0001J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001d0!H\u0001J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020'0!H\u0001J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020)0!H\u0001J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020$0!H\u0001J\u0010\u0010+\u001a\u0004\u0018\u00010'H\u0001¢\u0006\u0002\u0010,J0\u0010-\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00170\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0015H\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0019J0\u0010.\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\u00170\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0015H\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0019J0\u00100\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00170\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0015H\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0019J0\u00101\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002020\u00170\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0015H\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\t\u00103\u001a\u00020\u000eH\u0001J8\u00104\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00170\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00152\u0006\u00105\u001a\u00020\u0013H\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u00106J\u0011\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u0010H\u0001J\u0018\u00109\u001a\u00020\u000e2\b\u0010:\u001a\u0004\u0018\u00010'H\u0001¢\u0006\u0002\u0010;J\u0011\u0010<\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020\u0010H\u0001J\u0011\u0010>\u001a\u00020\u000e2\u0006\u0010?\u001a\u00020\u0013H\u0001J\u0013\u0010@\u001a\u00020\u000e2\b\u0010A\u001a\u0004\u0018\u00010\u001bH\u0001J\u001b\u0010B\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020\u001d2\b\b\u0002\u0010D\u001a\u00020\u0010H\u0001R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006E"}, d2 = {"Lcom/talabat/gem/adapters/data/GemDataSources;", "Lcom/talabat/gem/ports/data/DataSourcesPort;", "Lcom/talabat/gem/ports/data/GemOfferDataSourcesPort;", "Lcom/talabat/gem/ports/data/RestaurantsDataSourcesPort;", "Lcom/talabat/gem/ports/data/GemAcceptanceDataSourcesPort;", "Lcom/talabat/gem/ports/data/GemExpirationDataSourcesPort;", "Lcom/talabat/gem/ports/data/UserInfoDataSourcesPort;", "Lcom/talabat/gem/ports/data/SessionDataSourcesPort;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext$com_talabat_Components_gem_gem", "()Landroid/content/Context;", "clearGemOffer", "", "isExpirationAlertShown", "", "isOfferAutoTriggered", "loadExpiredOffer", "Lcom/talabat/gem/domain/entities/GemOffer;", "loadGemOffer", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lkotlin/Result;", "", "()Lkotlin/jvm/functions/Function1;", "loadGemOfferAcceptance", "Lcom/talabat/gem/domain/entities/GemOfferAcceptance;", "loadSelectedGemRestaurant", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "loadTriggerExpirationAlertFlag", "Lcom/talabat/talabatcommon/extentions/Flag;", "observeOnExpiredOffer", "Lio/reactivex/Observable;", "observeOnGemOffer", "observeOnLocalization", "", "observeOnSelectedGemRestaurant", "observeOnSelectedRestaurantId", "", "observeOnUserLocation", "Lcom/talabat/gem/domain/entities/Location;", "observeOnUserName", "openedRestaurantIdFromAllEntryPoint", "()Ljava/lang/Integer;", "requestGemOffer", "requestGemOfferAcceptance", "Lcom/talabat/gem/domain/entities/GemOfferAcceptance$Accepted;", "requestGemOfferFromFlutterHome", "requestGemOfferRejection", "Lcom/talabat/gem/domain/entities/GemOfferAcceptance$Rejected;", "resetTriggerExpirationAlertFlag", "saveGemOffer", "gemOffer", "(Lcom/talabat/gem/domain/entities/GemOffer;)Lkotlin/jvm/functions/Function1;", "saveOfferAutoTriggered", "triggered", "saveRestaurantIdFromAllEntryPoint", "id", "(Ljava/lang/Integer;)V", "setExpirationAlertShown", "isAlertShown", "updateExpiredOffer", "offer", "updateGemOfferAcceptance", "acceptance", "updateSelectedGemRestaurant", "restaurant", "isGemCollectionRestaurant", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemDataSources implements DataSourcesPort, GemOfferDataSourcesPort, RestaurantsDataSourcesPort, GemAcceptanceDataSourcesPort, GemExpirationDataSourcesPort, UserInfoDataSourcesPort, SessionDataSourcesPort {
    private final /* synthetic */ GemOfferDataSources $$delegate_0 = new GemOfferDataSources();
    private final /* synthetic */ RestaurantsDataSources $$delegate_1;
    private final /* synthetic */ GemAcceptanceDataSources $$delegate_2;
    private final /* synthetic */ GemExpirationDataSources $$delegate_3;
    private final /* synthetic */ UserInfoDataSources $$delegate_4;
    private final /* synthetic */ SessionDataSources $$delegate_5;
    @NotNull
    private final Context context;

    @GemIntegrationDsl
    public GemDataSources(@NotNull Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        this.$$delegate_1 = new RestaurantsDataSources(context2);
        this.$$delegate_2 = new GemAcceptanceDataSources();
        this.$$delegate_3 = new GemExpirationDataSources();
        this.$$delegate_4 = new UserInfoDataSources();
        this.$$delegate_5 = new SessionDataSources();
    }

    public void clearGemOffer() {
        this.$$delegate_5.clearGemOffer();
    }

    @NotNull
    public final Context getContext$com_talabat_Components_gem_gem() {
        return this.context;
    }

    public boolean isExpirationAlertShown() {
        return this.$$delegate_3.isExpirationAlertShown();
    }

    public boolean isOfferAutoTriggered() {
        return this.$$delegate_0.isOfferAutoTriggered();
    }

    @Nullable
    public GemOffer loadExpiredOffer() {
        return this.$$delegate_3.loadExpiredOffer();
    }

    @NotNull
    public Function1<Continuation<? super Result<GemOffer>>, Object> loadGemOffer() {
        return this.$$delegate_0.loadGemOffer();
    }

    @Nullable
    public GemOfferAcceptance loadGemOfferAcceptance() {
        return this.$$delegate_2.loadGemOfferAcceptance();
    }

    @Nullable
    public GemRestaurant loadSelectedGemRestaurant() {
        return this.$$delegate_1.loadSelectedGemRestaurant();
    }

    @NotNull
    public Flag loadTriggerExpirationAlertFlag() {
        return this.$$delegate_3.loadTriggerExpirationAlertFlag();
    }

    @NotNull
    public Observable<GemOffer> observeOnExpiredOffer() {
        return this.$$delegate_3.observeOnExpiredOffer();
    }

    @NotNull
    public Observable<GemOffer> observeOnGemOffer() {
        return this.$$delegate_0.observeOnGemOffer();
    }

    @NotNull
    public Observable<String> observeOnLocalization() {
        return this.$$delegate_4.observeOnLocalization();
    }

    @NotNull
    public Observable<GemRestaurant> observeOnSelectedGemRestaurant() {
        return this.$$delegate_1.observeOnSelectedGemRestaurant();
    }

    @NotNull
    public Observable<Integer> observeOnSelectedRestaurantId() {
        return this.$$delegate_1.observeOnSelectedRestaurantId();
    }

    @NotNull
    public Observable<Location> observeOnUserLocation() {
        return this.$$delegate_4.observeOnUserLocation();
    }

    @NotNull
    public Observable<String> observeOnUserName() {
        return this.$$delegate_4.observeOnUserName();
    }

    @Nullable
    public Integer openedRestaurantIdFromAllEntryPoint() {
        return this.$$delegate_0.openedRestaurantIdFromAllEntryPoint();
    }

    @NotNull
    public Function1<Continuation<? super Result<GemOffer>>, Object> requestGemOffer() {
        return this.$$delegate_0.requestGemOffer();
    }

    @NotNull
    public Function1<Continuation<? super Result<GemOfferAcceptance.Accepted>>, Object> requestGemOfferAcceptance() {
        return this.$$delegate_2.requestGemOfferAcceptance();
    }

    @NotNull
    public Function1<Continuation<? super Result<GemOffer>>, Object> requestGemOfferFromFlutterHome() {
        return this.$$delegate_0.requestGemOfferFromFlutterHome();
    }

    @NotNull
    public Function1<Continuation<? super Result<GemOfferAcceptance.Rejected>>, Object> requestGemOfferRejection() {
        return this.$$delegate_2.requestGemOfferRejection();
    }

    public void resetTriggerExpirationAlertFlag() {
        this.$$delegate_3.resetTriggerExpirationAlertFlag();
    }

    @NotNull
    public Function1<Continuation<? super Result<GemOffer>>, Object> saveGemOffer(@NotNull GemOffer gemOffer) {
        Intrinsics.checkNotNullParameter(gemOffer, "gemOffer");
        return this.$$delegate_0.saveGemOffer(gemOffer);
    }

    public void saveOfferAutoTriggered(boolean z11) {
        this.$$delegate_0.saveOfferAutoTriggered(z11);
    }

    public void saveRestaurantIdFromAllEntryPoint(@Nullable Integer num) {
        this.$$delegate_0.saveRestaurantIdFromAllEntryPoint(num);
    }

    public void setExpirationAlertShown(boolean z11) {
        this.$$delegate_3.setExpirationAlertShown(z11);
    }

    public void updateExpiredOffer(@NotNull GemOffer gemOffer) {
        Intrinsics.checkNotNullParameter(gemOffer, "offer");
        this.$$delegate_3.updateExpiredOffer(gemOffer);
    }

    public void updateGemOfferAcceptance(@Nullable GemOfferAcceptance gemOfferAcceptance) {
        this.$$delegate_2.updateGemOfferAcceptance(gemOfferAcceptance);
    }

    public void updateSelectedGemRestaurant(@NotNull GemRestaurant gemRestaurant, boolean z11) {
        Intrinsics.checkNotNullParameter(gemRestaurant, "restaurant");
        this.$$delegate_1.updateSelectedGemRestaurant(gemRestaurant, z11);
    }
}
