package com.talabat.gem.samples;

import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemOfferAcceptance;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.entities.Location;
import com.talabat.gem.ports.data.DataSourcesPort;
import com.talabat.talabatcommon.extentions.Flag;
import com.talabat.talabatcommon.extentions.KotlinResultKt;
import com.talabat.talabatcommon.extentions.RxKt;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016J/\u0010\u001c\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001f0\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001dH\u0016ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010 J\n\u0010!\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\"\u001a\u00020\u0018H\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050$H\u0016J\u000e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050$H\u0016J\u000e\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00140$H\u0016J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020(0$H\u0016J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020*0$H\u0016J\u0016\u0010+\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010,0,0$H\u0016J/\u0010-\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001f0\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001dH\u0016ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010 J/\u0010.\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020/0\u001f0\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001dH\u0016ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010 J/\u00100\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u001f0\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001dH\u0016ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010 J\b\u00102\u001a\u000203H\u0016J7\u00104\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u001f0\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u001d2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u00105J\u0010\u00106\u001a\u0002032\u0006\u00107\u001a\u00020\u001aH\u0016J\u0010\u00108\u001a\u0002032\u0006\u00109\u001a\u00020\u0005H\u0016J\u0018\u0010:\u001a\u0002032\u0006\u0010;\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\u001aH\u0016R)\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u00048BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R7\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rj\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0010\u0010\u0011R)\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00140\u00140\u00048BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0015\u0010\bR\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006="}, d2 = {"Lcom/talabat/gem/samples/SampleDataSourcesAdapter;", "Lcom/talabat/gem/ports/data/DataSourcesPort;", "()V", "expiredOffer", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/talabat/gem/domain/entities/GemOffer;", "kotlin.jvm.PlatformType", "getExpiredOffer", "()Lio/reactivex/subjects/BehaviorSubject;", "expiredOffer$delegate", "Lkotlin/Lazy;", "gemOffer", "inMemoryCache", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getInMemoryCache", "()Ljava/util/HashMap;", "inMemoryCache$delegate", "selectedGemRestaurant", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "getSelectedGemRestaurant", "selectedGemRestaurant$delegate", "triggerExpirationAlertFlag", "Lcom/talabat/talabatcommon/extentions/Flag;", "isOfferAutoTriggered", "", "loadExpiredOffer", "loadGemOffer", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lkotlin/Result;", "()Lkotlin/jvm/functions/Function1;", "loadSelectedGemRestaurant", "loadTriggerExpirationAlertFlag", "observeOnExpiredOffer", "Lio/reactivex/Observable;", "observeOnGemOffer", "observeOnSelectedGemRestaurant", "observeOnSelectedRestaurantId", "", "observeOnUserLocation", "Lcom/talabat/gem/domain/entities/Location;", "observeOnUserName", "", "requestGemOffer", "requestGemOfferAcceptance", "Lcom/talabat/gem/domain/entities/GemOfferAcceptance$Accepted;", "requestGemOfferRejection", "Lcom/talabat/gem/domain/entities/GemOfferAcceptance$Rejected;", "resetTriggerExpirationAlertFlag", "", "saveGemOffer", "(Lcom/talabat/gem/domain/entities/GemOffer;)Lkotlin/jvm/functions/Function1;", "saveOfferAutoTriggered", "triggered", "updateExpiredOffer", "offer", "updateSelectedGemRestaurant", "restaurant", "isGemCollectionRestaurant", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SampleDataSourcesAdapter implements DataSourcesPort {
    @NotNull
    private final Lazy expiredOffer$delegate;
    /* access modifiers changed from: private */
    @NotNull
    public final BehaviorSubject<GemOffer> gemOffer;
    @NotNull
    private final Lazy inMemoryCache$delegate;
    @NotNull
    private final Lazy selectedGemRestaurant$delegate;
    @NotNull
    private Flag triggerExpirationAlertFlag = new Flag(true);

    public SampleDataSourcesAdapter() {
        BehaviorSubject<GemOffer> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<GemOffer>()");
        this.gemOffer = create;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.inMemoryCache$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, SampleDataSourcesAdapter$inMemoryCache$2.INSTANCE);
        this.expiredOffer$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, SampleDataSourcesAdapter$expiredOffer$2.INSTANCE);
        this.selectedGemRestaurant$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, SampleDataSourcesAdapter$selectedGemRestaurant$2.INSTANCE);
    }

    private final BehaviorSubject<GemOffer> getExpiredOffer() {
        return (BehaviorSubject) this.expiredOffer$delegate.getValue();
    }

    private final HashMap<Object, Object> getInMemoryCache() {
        return (HashMap) this.inMemoryCache$delegate.getValue();
    }

    private final BehaviorSubject<GemRestaurant> getSelectedGemRestaurant() {
        return (BehaviorSubject) this.selectedGemRestaurant$delegate.getValue();
    }

    public void clearGemOffer() {
        DataSourcesPort.DefaultImpls.clearGemOffer(this);
    }

    public boolean isExpirationAlertShown() {
        return DataSourcesPort.DefaultImpls.isExpirationAlertShown(this);
    }

    public boolean isOfferAutoTriggered() {
        Object obj = getInMemoryCache().get("OfferAutoTriggered");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    @Nullable
    public GemOffer loadExpiredOffer() {
        BehaviorSubject expiredOffer = getExpiredOffer();
        Intrinsics.checkNotNullExpressionValue(expiredOffer, "expiredOffer");
        return (GemOffer) RxKt.invoke(expiredOffer);
    }

    @NotNull
    public Function1<Continuation<? super Result<GemOffer>>, Object> loadGemOffer() {
        return KotlinResultKt.Either(new SampleDataSourcesAdapter$loadGemOffer$1(this, (Continuation<? super SampleDataSourcesAdapter$loadGemOffer$1>) null));
    }

    @Nullable
    public GemOfferAcceptance loadGemOfferAcceptance() {
        return DataSourcesPort.DefaultImpls.loadGemOfferAcceptance(this);
    }

    @Nullable
    public GemRestaurant loadSelectedGemRestaurant() {
        BehaviorSubject selectedGemRestaurant = getSelectedGemRestaurant();
        Intrinsics.checkNotNullExpressionValue(selectedGemRestaurant, "selectedGemRestaurant");
        return (GemRestaurant) RxKt.invoke(selectedGemRestaurant);
    }

    @NotNull
    public Flag loadTriggerExpirationAlertFlag() {
        return this.triggerExpirationAlertFlag;
    }

    @NotNull
    public Observable<GemOffer> observeOnExpiredOffer() {
        Observable<GemOffer> share = getExpiredOffer().share();
        Intrinsics.checkNotNullExpressionValue(share, "expiredOffer.share()");
        return share;
    }

    @NotNull
    public Observable<GemOffer> observeOnGemOffer() {
        Observable<GemOffer> share = this.gemOffer.share();
        Intrinsics.checkNotNullExpressionValue(share, "gemOffer.share()");
        return share;
    }

    @NotNull
    public Observable<String> observeOnLocalization() {
        return DataSourcesPort.DefaultImpls.observeOnLocalization(this);
    }

    @NotNull
    public Observable<GemRestaurant> observeOnSelectedGemRestaurant() {
        Observable<GemRestaurant> share = getSelectedGemRestaurant().share();
        Intrinsics.checkNotNullExpressionValue(share, "selectedGemRestaurant.share()");
        return share;
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
        Observable<String> just = Observable.just("Mudasir");
        Intrinsics.checkNotNullExpressionValue(just, "just(\"Mudasir\")");
        return just;
    }

    @Nullable
    public Integer openedRestaurantIdFromAllEntryPoint() {
        return DataSourcesPort.DefaultImpls.openedRestaurantIdFromAllEntryPoint(this);
    }

    @NotNull
    public Function1<Continuation<? super Result<GemOffer>>, Object> requestGemOffer() {
        return KotlinResultKt.Either(new SampleDataSourcesAdapter$requestGemOffer$1((Continuation<? super SampleDataSourcesAdapter$requestGemOffer$1>) null));
    }

    @NotNull
    public Function1<Continuation<? super Result<GemOfferAcceptance.Accepted>>, Object> requestGemOfferAcceptance() {
        return KotlinResultKt.Either(new SampleDataSourcesAdapter$requestGemOfferAcceptance$1((Continuation<? super SampleDataSourcesAdapter$requestGemOfferAcceptance$1>) null));
    }

    @NotNull
    public Function1<Continuation<? super Result<GemOffer>>, Object> requestGemOfferFromFlutterHome() {
        return DataSourcesPort.DefaultImpls.requestGemOfferFromFlutterHome(this);
    }

    @NotNull
    public Function1<Continuation<? super Result<GemOfferAcceptance.Rejected>>, Object> requestGemOfferRejection() {
        return KotlinResultKt.Either(new SampleDataSourcesAdapter$requestGemOfferRejection$1((Continuation<? super SampleDataSourcesAdapter$requestGemOfferRejection$1>) null));
    }

    public void resetTriggerExpirationAlertFlag() {
        this.triggerExpirationAlertFlag = new Flag(true);
    }

    @NotNull
    public Function1<Continuation<? super Result<GemOffer>>, Object> saveGemOffer(@NotNull GemOffer gemOffer2) {
        Intrinsics.checkNotNullParameter(gemOffer2, "gemOffer");
        return KotlinResultKt.Either(new SampleDataSourcesAdapter$saveGemOffer$1(this, gemOffer2, (Continuation<? super SampleDataSourcesAdapter$saveGemOffer$1>) null));
    }

    public void saveOfferAutoTriggered(boolean z11) {
        getInMemoryCache().put("OfferAutoTriggered", Boolean.valueOf(z11));
    }

    public void saveRestaurantIdFromAllEntryPoint(@Nullable Integer num) {
        DataSourcesPort.DefaultImpls.saveRestaurantIdFromAllEntryPoint(this, num);
    }

    public void setExpirationAlertShown(boolean z11) {
        DataSourcesPort.DefaultImpls.setExpirationAlertShown(this, z11);
    }

    public void updateExpiredOffer(@NotNull GemOffer gemOffer2) {
        Intrinsics.checkNotNullParameter(gemOffer2, "offer");
        BehaviorSubject<GemOffer> expiredOffer = getExpiredOffer();
        Intrinsics.checkNotNullExpressionValue(expiredOffer, "expiredOffer");
        RxKt.plusAssign(expiredOffer, gemOffer2);
    }

    public void updateGemOfferAcceptance(@Nullable GemOfferAcceptance gemOfferAcceptance) {
        DataSourcesPort.DefaultImpls.updateGemOfferAcceptance(this, gemOfferAcceptance);
    }

    public void updateSelectedGemRestaurant(@NotNull GemRestaurant gemRestaurant, boolean z11) {
        Intrinsics.checkNotNullParameter(gemRestaurant, "restaurant");
        BehaviorSubject<GemRestaurant> selectedGemRestaurant = getSelectedGemRestaurant();
        Intrinsics.checkNotNullExpressionValue(selectedGemRestaurant, "selectedGemRestaurant");
        RxKt.plusAssign(selectedGemRestaurant, gemRestaurant);
    }
}
