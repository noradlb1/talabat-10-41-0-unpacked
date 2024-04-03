package com.talabat.gem.samples;

import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.entities.GemTier;
import com.talabat.gem.domain.entities.Rating;
import com.visa.checkout.PurchaseInfo;
import gateways.DataSourcesDelegateKt;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0000\u001a\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002\u001a\b\u0010\u001a\u001a\u00020\u001bH\u0002\u001a\b\u0010\u001c\u001a\u00020\u001dH\u0002\u001a\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0002\u001a\b\u0010\u000f\u001a\u00020\u0019H\u0002\u001a\b\u0010\u001f\u001a\u00020 H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"/\u0010\b\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00018@@@X\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\"/\u0010\u000f\u001a\u0004\u0018\u00010\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00018@@@X\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\f¨\u0006!"}, d2 = {"DEFAULT_TIERS_COUNT", "", "MINUTE_AS_SECONDS", "NO_EXPIRATION_MINUTES", "ON_TOTAL_AMOUNT_MODIFIER", "PAY_ONLY_MODIFIER", "SECOND_AS_MILLIS", "<set-?>", "expireAfterMinutes", "getExpireAfterMinutes", "()Ljava/lang/Double;", "setExpireAfterMinutes", "(Ljava/lang/Double;)V", "expireAfterMinutes$delegate", "Lkotlin/properties/ReadWriteProperty;", "tiersCount", "getTiersCount", "setTiersCount", "tiersCount$delegate", "Restaurants", "", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "Tier", "Lcom/talabat/gem/domain/entities/GemTier;", "id", "", "color", "", "expirationTimestamp", "", "gemRestaurant", "updateDataSources", "", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SampleDataSourcesKt {
    private static final double DEFAULT_TIERS_COUNT = 4.0d;
    private static final double MINUTE_AS_SECONDS = 60.0d;
    private static final double NO_EXPIRATION_MINUTES = 0.0d;
    private static final double ON_TOTAL_AMOUNT_MODIFIER = 2.5d;
    private static final double PAY_ONLY_MODIFIER = 1.75d;
    private static final double SECOND_AS_MILLIS = 1000.0d;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f60492a;
    @NotNull
    private static final ReadWriteProperty expireAfterMinutes$delegate;
    @NotNull
    private static final ReadWriteProperty tiersCount$delegate;

    static {
        Class<SampleDataSourcesKt> cls = SampleDataSourcesKt.class;
        f60492a = new KProperty[]{Reflection.mutableProperty0(new MutablePropertyReference0Impl(cls, "expireAfterMinutes", "getExpireAfterMinutes()Ljava/lang/Double;", 1)), Reflection.mutableProperty0(new MutablePropertyReference0Impl(cls, "tiersCount", "getTiersCount()Ljava/lang/Double;", 1))};
        Delegates delegates = Delegates.INSTANCE;
        expireAfterMinutes$delegate = DataSourcesDelegateKt.preferences$default(delegates, "expireAfterMinutes", (Object) null, SampleDataSourcesKt$expireAfterMinutes$2.INSTANCE, 2, (Object) null);
        tiersCount$delegate = DataSourcesDelegateKt.preferences$default(delegates, "tiersCount", (Object) null, SampleDataSourcesKt$tiersCount$2.INSTANCE, 2, (Object) null);
    }

    @NotNull
    public static final List<GemRestaurant> Restaurants() {
        IntRange intRange = new IntRange(1, 200);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRange, 10));
        Iterator it = intRange.iterator();
        while (it.hasNext()) {
            arrayList.add(gemRestaurant(((IntIterator) it).nextInt()));
        }
        return CollectionsKt___CollectionsKt.toList(arrayList);
    }

    /* access modifiers changed from: private */
    public static final GemTier Tier(int i11) {
        double d11 = (double) i11;
        return new GemTier(Double.valueOf(PAY_ONLY_MODIFIER * d11), Double.valueOf(d11 * ON_TOTAL_AMOUNT_MODIFIER), PurchaseInfo.Currency.AED, color(), (Float) null, 16, (DefaultConstructorMarker) null);
    }

    private static final String color() {
        return (String) CollectionsKt___CollectionsKt.first(CollectionsKt__CollectionsJVMKt.shuffled(CollectionsKt__CollectionsKt.listOf("#FF0000", "#00FF00", "#0000FF", "#000000", "#000fff", "#ff5a00", "#4285f4", "#f4b9b4", "#9D2687")));
    }

    /* access modifiers changed from: private */
    public static final long expirationTimestamp() {
        double d11;
        double time = (double) new Date().getTime();
        Double expireAfterMinutes = getExpireAfterMinutes();
        if (expireAfterMinutes != null) {
            d11 = expireAfterMinutes.doubleValue();
        } else {
            d11 = 0.0d;
        }
        return (long) (time + (d11 * MINUTE_AS_SECONDS * 1000.0d));
    }

    private static final GemRestaurant gemRestaurant(int i11) {
        boolean z11;
        Rating rating;
        int i12 = i11;
        String str = "Restaurant " + i12;
        String str2 = "Cuisines " + i12;
        int i13 = i12 % 2;
        if (i13 == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (i12 % 4 == 0) {
            rating = Rating.AMAZING;
        } else if (i12 % 3 == 0) {
            rating = Rating.VERY_GOOD;
        } else if (i13 == 0) {
            rating = Rating.GOOD;
        } else {
            rating = Rating.OK;
        }
        Rating rating2 = rating;
        SampleDataSourcesKt$gemRestaurant$1 sampleDataSourcesKt$gemRestaurant$1 = r1;
        SampleDataSourcesKt$gemRestaurant$1 sampleDataSourcesKt$gemRestaurant$12 = new SampleDataSourcesKt$gemRestaurant$1(i12);
        return new GemRestaurant(Integer.valueOf(i11), str, (String) null, Boolean.valueOf(z11), str2, rating2, (Float) null, 0, "Avg. 20 Min.", (Integer) null, Double.valueOf(MINUTE_AS_SECONDS), (String) null, sampleDataSourcesKt$gemRestaurant$1, (Integer) null, (Double) null, (Integer) null, (Float) null, (String) null, 256708, (DefaultConstructorMarker) null);
    }

    @Nullable
    public static final Double getExpireAfterMinutes() {
        return (Double) expireAfterMinutes$delegate.getValue(null, f60492a[0]);
    }

    @Nullable
    public static final Double getTiersCount() {
        return (Double) tiersCount$delegate.getValue(null, f60492a[1]);
    }

    public static final void setExpireAfterMinutes(@Nullable Double d11) {
        expireAfterMinutes$delegate.setValue(null, f60492a[0], d11);
    }

    public static final void setTiersCount(@Nullable Double d11) {
        tiersCount$delegate.setValue(null, f60492a[1], d11);
    }

    /* access modifiers changed from: private */
    public static final int tiersCount() {
        Double tiersCount = getTiersCount();
        return (int) (tiersCount != null ? tiersCount.doubleValue() : DEFAULT_TIERS_COUNT);
    }

    public static final void updateDataSources() {
        IntegrationKt.GemCoreIntegration(SampleDataSourcesKt$updateDataSources$1.INSTANCE);
    }
}
