package com.talabat.gem.adapters.data;

import androidx.annotation.RestrictTo;
import buisnessmodels.Customer;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemOfferAcceptance;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.entities.Location;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.extentions.CoroutinesKt;
import com.talabat.talabatcommon.extentions.Flag;
import com.talabat.talabatcommon.extentions.Nullable;
import com.talabat.talabatcommon.extentions.RxDelegatesKt;
import datamodels.CustomerInfo;
import io.reactivex.Scheduler;
import io.reactivex.subjects.BehaviorSubject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u000f\u0010<\u001a\u0004\u0018\u000102H\u0002¢\u0006\u0002\u00104\u001a\n\u0010=\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0010\u0010>\u001a\n \f*\u0004\u0018\u00010\u00010\u0001H\u0002\u001a\b\u0010?\u001a\u00020@H\u0002\u001a\b\u0010A\u001a\u00020\u0001H\u0002\u001a\b\u0010B\u001a\u00020CH\u0007\u001a\b\u0010D\u001a\u00020@H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038@X\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\"X\u0010\r\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000b \f*\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\n0\u00032 \u0010\t\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000b \f*\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\n0\u0003@AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\u0010\"\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\"\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\"\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\"@\u0010\"\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\u00032\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\u0003@AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\u0010\"\u001a\u0010%\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001b\"\u001c\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\"\u001a\u0010.\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001b\"\u001e\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106\"@\u00109\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u000108080\u00032\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u000108080\u0003@AX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\u0010¨\u0006E"}, d2 = {"NO_NAME", "", "cacheObservable", "Lio/reactivex/subjects/BehaviorSubject;", "Lcom/talabat/gem/adapters/data/ObservedData;", "getCacheObservable", "()Lio/reactivex/subjects/BehaviorSubject;", "cacheObservable$delegate", "Lkotlin/properties/ReadOnlyProperty;", "<set-?>", "Lcom/talabat/talabatcommon/extentions/Nullable;", "Lcom/talabat/gem/domain/entities/GemOffer;", "kotlin.jvm.PlatformType", "cachedOffer", "getCachedOffer", "setCachedOffer", "(Lio/reactivex/subjects/BehaviorSubject;)V", "checkoutTransactionId", "getCheckoutTransactionId", "()Ljava/lang/String;", "setCheckoutTransactionId", "(Ljava/lang/String;)V", "expirationAlertShown", "", "getExpirationAlertShown", "()Z", "setExpirationAlertShown", "(Z)V", "expirationTrigger", "Lcom/talabat/talabatcommon/extentions/Flag;", "getExpirationTrigger", "()Lcom/talabat/talabatcommon/extentions/Flag;", "setExpirationTrigger", "(Lcom/talabat/talabatcommon/extentions/Flag;)V", "expiredOffer", "getExpiredOffer", "setExpiredOffer", "gemCollectionRestaurant", "getGemCollectionRestaurant", "setGemCollectionRestaurant", "gemOfferAcceptance", "Lcom/talabat/gem/domain/entities/GemOfferAcceptance;", "getGemOfferAcceptance", "()Lcom/talabat/gem/domain/entities/GemOfferAcceptance;", "setGemOfferAcceptance", "(Lcom/talabat/gem/domain/entities/GemOfferAcceptance;)V", "offerTrigger", "getOfferTrigger", "setOfferTrigger", "openedRestaurantFromEntryPoint", "", "getOpenedRestaurantFromEntryPoint", "()Ljava/lang/Integer;", "setOpenedRestaurantFromEntryPoint", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "selectedGemRestaurant", "getSelectedGemRestaurant", "setSelectedGemRestaurant", "cachedSelectedRestaurantId", "customerName", "localization", "location", "Lcom/talabat/gem/domain/entities/Location;", "name", "resetGemCache", "", "validLocation", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CacheKt {
    @NotNull
    private static final String NO_NAME = "";

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f59867a = {Reflection.property0(new PropertyReference0Impl(CacheKt.class, "cacheObservable", "getCacheObservable()Lio/reactivex/subjects/BehaviorSubject;", 1))};
    @NotNull
    private static final ReadOnlyProperty cacheObservable$delegate = RxDelegatesKt.observe$default(Delegates.INSTANCE, (Scheduler) null, CacheKt$cacheObservable$2.INSTANCE, 1, (Object) null);
    @NotNull
    private static BehaviorSubject<Nullable<GemOffer>> cachedOffer;
    @org.jetbrains.annotations.Nullable
    private static String checkoutTransactionId;
    private static boolean expirationAlertShown;
    @NotNull
    private static Flag expirationTrigger = new Flag(true);
    @NotNull
    private static BehaviorSubject<GemOffer> expiredOffer;
    private static boolean gemCollectionRestaurant;
    @org.jetbrains.annotations.Nullable
    private static GemOfferAcceptance gemOfferAcceptance;
    private static boolean offerTrigger;
    @org.jetbrains.annotations.Nullable
    private static Integer openedRestaurantFromEntryPoint;
    @NotNull
    private static BehaviorSubject<GemRestaurant> selectedGemRestaurant;

    static {
        BehaviorSubject<GemOffer> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<GemOffer>()");
        expiredOffer = create;
        BehaviorSubject<GemRestaurant> create2 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create<GemRestaurant>()");
        selectedGemRestaurant = create2;
        BehaviorSubject<Nullable<GemOffer>> create3 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create3, "create<Nullable<GemOffer>>()");
        cachedOffer = create3;
    }

    /* access modifiers changed from: private */
    public static final Integer cachedSelectedRestaurantId() {
        return (Integer) CoroutinesKt.returnHandling$default((Function1) null, (Object) null, CacheKt$cachedSelectedRestaurantId$1.INSTANCE, 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final String customerName() {
        CustomerInfo customerInfo;
        Customer instance = Customer.getInstance();
        if (instance == null || (customerInfo = instance.getCustomerInfo()) == null) {
            return null;
        }
        return customerInfo.firstName;
    }

    @NotNull
    public static final BehaviorSubject<ObservedData> getCacheObservable() {
        return (BehaviorSubject) cacheObservable$delegate.getValue(null, f59867a[0]);
    }

    @NotNull
    public static final BehaviorSubject<Nullable<GemOffer>> getCachedOffer() {
        return cachedOffer;
    }

    @org.jetbrains.annotations.Nullable
    public static final String getCheckoutTransactionId() {
        return checkoutTransactionId;
    }

    public static final boolean getExpirationAlertShown() {
        return expirationAlertShown;
    }

    @NotNull
    public static final Flag getExpirationTrigger() {
        return expirationTrigger;
    }

    @NotNull
    public static final BehaviorSubject<GemOffer> getExpiredOffer() {
        return expiredOffer;
    }

    public static final boolean getGemCollectionRestaurant() {
        return gemCollectionRestaurant;
    }

    @org.jetbrains.annotations.Nullable
    public static final GemOfferAcceptance getGemOfferAcceptance() {
        return gemOfferAcceptance;
    }

    public static final boolean getOfferTrigger() {
        return offerTrigger;
    }

    @org.jetbrains.annotations.Nullable
    public static final Integer getOpenedRestaurantFromEntryPoint() {
        return openedRestaurantFromEntryPoint;
    }

    @NotNull
    public static final BehaviorSubject<GemRestaurant> getSelectedGemRestaurant() {
        return selectedGemRestaurant;
    }

    /* access modifiers changed from: private */
    public static final String localization() {
        return GlobalDataModel.SelectedLanguage;
    }

    /* access modifiers changed from: private */
    public static final Location location() {
        Location location = (Location) CoroutinesKt.returnHandling$default((Function1) null, (Object) null, CacheKt$location$1.INSTANCE, 3, (Object) null);
        return location == null ? new Location((Double) null, (Double) null, 3, (DefaultConstructorMarker) null) : location;
    }

    /* access modifiers changed from: private */
    public static final String name() {
        String str = (String) CoroutinesKt.returnHandling$default((Function1) null, (Object) null, CacheKt$name$1.INSTANCE, 3, (Object) null);
        return str == null ? "" : str;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public static final void resetGemCache() {
        BehaviorSubject<GemOffer> create = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create()");
        expiredOffer = create;
        BehaviorSubject<GemRestaurant> create2 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create2, "create()");
        selectedGemRestaurant = create2;
        BehaviorSubject<Nullable<GemOffer>> create3 = BehaviorSubject.create();
        Intrinsics.checkNotNullExpressionValue(create3, "create()");
        cachedOffer = create3;
        offerTrigger = false;
        expirationTrigger = new Flag(true);
        checkoutTransactionId = null;
        gemOfferAcceptance = null;
        expirationAlertShown = false;
        getCacheObservable().onNext(new ObservedData("", new Location((Double) null, (Double) null, 3, (DefaultConstructorMarker) null), (String) null, (Integer) null));
        gemCollectionRestaurant = false;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public static final void setCachedOffer(@NotNull BehaviorSubject<Nullable<GemOffer>> behaviorSubject) {
        Intrinsics.checkNotNullParameter(behaviorSubject, "<set-?>");
        cachedOffer = behaviorSubject;
    }

    public static final void setCheckoutTransactionId(@org.jetbrains.annotations.Nullable String str) {
        checkoutTransactionId = str;
    }

    public static final void setExpirationAlertShown(boolean z11) {
        expirationAlertShown = z11;
    }

    public static final void setExpirationTrigger(@NotNull Flag flag) {
        Intrinsics.checkNotNullParameter(flag, "<set-?>");
        expirationTrigger = flag;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public static final void setExpiredOffer(@NotNull BehaviorSubject<GemOffer> behaviorSubject) {
        Intrinsics.checkNotNullParameter(behaviorSubject, "<set-?>");
        expiredOffer = behaviorSubject;
    }

    public static final void setGemCollectionRestaurant(boolean z11) {
        gemCollectionRestaurant = z11;
    }

    public static final void setGemOfferAcceptance(@org.jetbrains.annotations.Nullable GemOfferAcceptance gemOfferAcceptance2) {
        gemOfferAcceptance = gemOfferAcceptance2;
    }

    public static final void setOfferTrigger(boolean z11) {
        offerTrigger = z11;
    }

    public static final void setOpenedRestaurantFromEntryPoint(@org.jetbrains.annotations.Nullable Integer num) {
        openedRestaurantFromEntryPoint = num;
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public static final void setSelectedGemRestaurant(@NotNull BehaviorSubject<GemRestaurant> behaviorSubject) {
        Intrinsics.checkNotNullParameter(behaviorSubject, "<set-?>");
        selectedGemRestaurant = behaviorSubject;
    }

    /* access modifiers changed from: private */
    public static final Location validLocation() {
        String latitude = GlobalDataModel.LATLONGFORAPI.getLatitude();
        Intrinsics.checkNotNullExpressionValue(latitude, "getLatitude()");
        Double doubleOrNull = StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(latitude);
        String longitude = GlobalDataModel.LATLONGFORAPI.getLongitude();
        Intrinsics.checkNotNullExpressionValue(longitude, "getLongitude()");
        return new Location(doubleOrNull, StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(longitude));
    }
}
