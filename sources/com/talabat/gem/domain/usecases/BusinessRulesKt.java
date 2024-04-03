package com.talabat.gem.domain.usecases;

import androidx.annotation.VisibleForTesting;
import com.talabat.core.experiment.data.Experiments;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.fwfprojectskeys.domain.projects.adex.AdExFeatureFlagsKeys;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemOffer;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.entities.GemTier;
import com.talabat.gem.ports.data.DataSourcesPort;
import com.talabat.gem.ports.data.RestaurantsDataSourcesPort;
import com.talabat.talabatcommon.extentions.DoubleKt;
import com.talabat.talabatcommon.extentions.FloatKt;
import com.talabat.talabatcommon.extentions.KotlinResultKt;
import io.reactivex.Single;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u000b\u001a\u001b\u0010(\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\u0010*\u001a\u0010\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0014\u001a\u0012\u0010.\u001a\u00020\u001b2\b\b\u0002\u0010)\u001a\u00020\tH\u0007\u001a\u0012\u0010/\u001a\u0004\u0018\u00010\u00142\u0006\u00100\u001a\u00020\u000bH\u0007\u001a\u0012\u00101\u001a\u0004\u0018\u00010\u00142\u0006\u00102\u001a\u00020\u000bH\u0007\u001a\u0017\u00103\u001a\u00020\u001b2\b\u00102\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u00104\u001a\b\u00105\u001a\u00020\u001bH\u0007\u001a&\u00106\u001a \u0012\u0004\u0012\u00020\u0014 9*\u0010\u0012\u0004\u0012\u00020\u0014\u0018\u000107j\u0004\u0018\u0001`807j\u0002`8H\u0002\u001a&\u0010:\u001a \u0012\u0004\u0012\u00020; 9*\u0010\u0012\u0004\u0012\u00020;\u0018\u000107j\u0004\u0018\u0001`<07j\u0002`<H\u0002\u001a\b\u0010=\u001a\u00020,H\u0007\u001a\u0016\u0010>\u001a\u0010\u0012\f\u0012\n 9*\u0004\u0018\u00010\u000f0\u000f0?H\u0007\u001a\b\u0010@\u001a\u00020,H\u0007\u001a\u0010\u0010A\u001a\u00020,2\u0006\u00102\u001a\u00020\u000bH\u0007\u001a\u0010\u0010B\u001a\u00020,2\u0006\u0010C\u001a\u00020\u000bH\u0007\u001a7\u0010D\u001a\u0004\u0018\u00010\u000b2\b\u00100\u001a\u0004\u0018\u00010\u000b2\u001c\b\u0002\u0010E\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0014\u0018\u000107j\u0004\u0018\u0001`80FH\u0007¢\u0006\u0002\u0010G\u001a7\u0010H\u001a\u0004\u0018\u00010\u000b2\b\u00102\u001a\u0004\u0018\u00010\u000b2\u001c\b\u0002\u0010E\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0014\u0018\u000107j\u0004\u0018\u0001`80FH\u0007¢\u0006\u0002\u0010G\u001a7\u0010I\u001a\u0004\u0018\u00010\u000b2\b\u0010J\u001a\u0004\u0018\u00010\r2\u001c\b\u0002\u0010K\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020;\u0018\u000107j\u0004\u0018\u0001`<0FH\u0007¢\u0006\u0002\u0010L\u001a$\u0010M\u001a\u0004\u0018\u00010;2\u0010\u0010K\u001a\f\u0012\u0004\u0012\u00020;07j\u0002`<2\u0006\u0010N\u001a\u00020\rH\u0001\u001a\u0014\u0010O\u001a\u00020P*\u00020;2\u0006\u0010N\u001a\u00020\rH\u0007\u001a\u0014\u0010Q\u001a\u00020P*\u00020;2\u0006\u0010N\u001a\u00020\rH\u0007\u001a\u0016\u0010R\u001a\u00020\u001b*\u00020\u000f2\b\b\u0002\u0010)\u001a\u00020\tH\u0007\u001a\n\u0010S\u001a\u00020\u001b*\u00020\u0007\u001a\n\u0010T\u001a\u00020\u001b*\u00020\u0007\u001a\n\u0010U\u001a\u00020\u001b*\u00020\u0007\u001a\u0014\u0010V\u001a\u00020\u001b*\u00020;2\u0006\u0010N\u001a\u00020\rH\u0007\u001a\f\u0010W\u001a\u00020\r*\u00020;H\u0007\u001a!\u0010X\u001a\u00020\u000b*\b\u0012\u0004\u0012\u00020;072\b\u0010J\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010Y\"\u001b\u0010\u0000\u001a\u00020\u00018FX\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000\"\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011\"\u001b\u0010\u0013\u001a\u00020\u00148FX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0015\u0010\u0016\"\u000e\u0010\u0018\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u000bXT¢\u0006\u0002\n\u0000\"$\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\"$\u0010\"\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'*\n\u0010Z\"\u00020,2\u00020,¨\u0006["}, d2 = {"DecimalFormat", "Ljava/text/DecimalFormat;", "getDecimalFormat", "()Ljava/text/DecimalFormat;", "DecimalFormat$delegate", "Lkotlin/Lazy;", "EMPTY_TEXT", "", "MINUTE_AS_SECONDS", "", "NOT_FOUND", "", "NO_AMOUNT", "", "NullGemOffer", "Lcom/talabat/gem/domain/entities/GemOffer;", "getNullGemOffer", "()Lcom/talabat/gem/domain/entities/GemOffer;", "NullGemOffer$delegate", "NullGemRestaurant", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "getNullGemRestaurant", "()Lcom/talabat/gem/domain/entities/GemRestaurant;", "NullGemRestaurant$delegate", "SECOND_AS_MILLIS", "TIMESTAMP_BUFFER_MILLIS", "enableGemWordingFromServer", "", "getEnableGemWordingFromServer$annotations", "()V", "getEnableGemWordingFromServer", "()Z", "setEnableGemWordingFromServer", "(Z)V", "gemPercentageVariant", "getGemPercentageVariant$annotations", "getGemPercentageVariant", "()Ljava/lang/String;", "setGemPercentageVariant", "(Ljava/lang/String;)V", "calculateGemRemainingSeconds", "now", "(Ljava/lang/Long;)Ljava/lang/Long;", "continueSelection", "", "selectedRestaurant", "gemExpired", "getIfRestaurantBranchExist", "branchId", "getIfRestaurantExist", "restaurantId", "isGemActive", "(Ljava/lang/Integer;)Z", "isGemOffersActive", "loadGemRestaurants", "", "Lcom/talabat/gem/domain/entities/GemRestaurants;", "kotlin.jvm.PlatformType", "loadGemTiers", "Lcom/talabat/gem/domain/entities/GemTier;", "Lcom/talabat/gem/domain/entities/GemTiers;", "onSessionChanged", "resetGemOffer", "Lio/reactivex/Single;", "resetSelectedGemRestaurant", "selectIfGemRestaurant", "selectIfGemRestaurantBranch", "branchID", "selectedRestaurantBranchIndex", "loadRestaurants", "Lkotlin/Function0;", "(Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)Ljava/lang/Integer;", "selectedRestaurantIndex", "selectedTierIndex", "subTotal", "tiers", "(Ljava/lang/Double;Lkotlin/jvm/functions/Function0;)Ljava/lang/Integer;", "subTotalTier", "subTotalAmount", "calculatePercentageDiscount", "", "calculatePercentageTotal", "isExpired", "isPercentage", "isPercentageWithProgressBarVariantB", "isPercentageWithoutProgressBarVariantA", "reachPercentage", "savedAmount", "toSubTotalTierIndex", "(Ljava/util/List;Ljava/lang/Double;)I", "BusinessRule", "com_talabat_Components_gem-core_gem-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "BusinessRulesKt")
public final class BusinessRulesKt {
    @NotNull
    private static final Lazy DecimalFormat$delegate;
    @NotNull
    public static final String EMPTY_TEXT = "";
    public static final long MINUTE_AS_SECONDS = 60;
    public static final int NOT_FOUND = -1;
    public static final double NO_AMOUNT = 0.0d;
    @NotNull
    private static final Lazy NullGemOffer$delegate;
    @NotNull
    private static final Lazy NullGemRestaurant$delegate;
    public static final long SECOND_AS_MILLIS = 1000;
    public static final int TIMESTAMP_BUFFER_MILLIS = 100;
    private static boolean enableGemWordingFromServer = IntegrationKt.getFeatureFlags().getFeatureFlag(AdExFeatureFlagsKeys.ENABLE_GEM_WORDING_FROM_SERVER, false);
    @NotNull
    private static String gemPercentageVariant = ((String) Experiments.withSafeExperiment$default(TalabatExperimentConstants.GEM_PERCENTAGE_VARIANT, "", (ITalabatExperiment) null, (Function1) null, 12, (Object) null));

    static {
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        NullGemRestaurant$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, BusinessRulesKt$NullGemRestaurant$2.INSTANCE);
        NullGemOffer$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, BusinessRulesKt$NullGemOffer$2.INSTANCE);
        DecimalFormat$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, BusinessRulesKt$DecimalFormat$2.INSTANCE);
    }

    @BusinessRules
    @Nullable
    @JvmOverloads
    public static final Long calculateGemRemainingSeconds() {
        return calculateGemRemainingSeconds$default((Long) null, 1, (Object) null);
    }

    @BusinessRules
    @Nullable
    @JvmOverloads
    public static final Long calculateGemRemainingSeconds(@Nullable Long l11) {
        return (Long) KotlinResultKt.toMaybe$default(KotlinResultKt.mapNonNull(KotlinResultKt.flatMapNonNull(IntegrationKt.getDataSources().loadGemOffer(), new BusinessRulesKt$calculateGemRemainingSeconds$1(l11, (Continuation<? super BusinessRulesKt$calculateGemRemainingSeconds$1>) null)), new BusinessRulesKt$calculateGemRemainingSeconds$2((Continuation<? super BusinessRulesKt$calculateGemRemainingSeconds$2>) null)), (Function1) null, 1, (Object) null).onErrorComplete().blockingGet();
    }

    public static /* synthetic */ Long calculateGemRemainingSeconds$default(Long l11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            l11 = null;
        }
        return calculateGemRemainingSeconds(l11);
    }

    @BusinessRules
    public static final float calculatePercentageDiscount(@NotNull GemTier gemTier, double d11) {
        Intrinsics.checkNotNullParameter(gemTier, "<this>");
        return (float) RangesKt___RangesKt.coerceAtMost(d11 * ((double) FloatKt.orZero(gemTier.getDiscountPercentage())), savedAmount(gemTier));
    }

    @BusinessRules
    public static final float calculatePercentageTotal(@NotNull GemTier gemTier, double d11) {
        Intrinsics.checkNotNullParameter(gemTier, "<this>");
        return (float) (d11 - ((double) calculatePercentageDiscount(gemTier, d11)));
    }

    public static final void continueSelection(@Nullable GemRestaurant gemRestaurant) {
        if (gemRestaurant != null) {
            IntegrationKt.getDataSources().saveRestaurantIdFromAllEntryPoint(gemRestaurant.getId());
            RestaurantsDataSourcesPort.DefaultImpls.updateSelectedGemRestaurant$default(IntegrationKt.getDataSources(), gemRestaurant, false, 2, (Object) null);
        }
    }

    @BusinessRules
    @JvmOverloads
    public static final boolean gemExpired() {
        return gemExpired$default(0, 1, (Object) null);
    }

    @BusinessRules
    @JvmOverloads
    public static final boolean gemExpired(long j11) {
        Long l11 = (Long) KotlinResultKt.toMaybe$default(KotlinResultKt.mapNonNull(IntegrationKt.getDataSources().loadGemOffer(), new BusinessRulesKt$gemExpired$expirationTimestamp$1((Continuation<? super BusinessRulesKt$gemExpired$expirationTimestamp$1>) null)), (Function1) null, 1, (Object) null).onErrorComplete().blockingGet(0L);
        if (l11 != null && (l11.longValue() + ((long) 100)) - j11 > 0) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean gemExpired$default(long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = System.currentTimeMillis();
        }
        return gemExpired(j11);
    }

    @NotNull
    public static final DecimalFormat getDecimalFormat() {
        return (DecimalFormat) DecimalFormat$delegate.getValue();
    }

    public static final boolean getEnableGemWordingFromServer() {
        return enableGemWordingFromServer;
    }

    @VisibleForTesting
    public static /* synthetic */ void getEnableGemWordingFromServer$annotations() {
    }

    @NotNull
    public static final String getGemPercentageVariant() {
        return gemPercentageVariant;
    }

    @VisibleForTesting
    public static /* synthetic */ void getGemPercentageVariant$annotations() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.talabat.gem.domain.entities.GemRestaurant} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.talabat.gem.domain.entities.GemRestaurant} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.talabat.gem.domain.entities.GemRestaurant} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.talabat.gem.domain.entities.GemRestaurant} */
    /* JADX WARNING: Multi-variable type inference failed */
    @com.talabat.gem.domain.usecases.BusinessRules
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.talabat.gem.domain.entities.GemRestaurant getIfRestaurantBranchExist(int r4) {
        /*
            java.util.List r0 = loadGemRestaurants()
            r1 = 0
            if (r0 == 0) goto L_0x002f
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x000d:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002d
            java.lang.Object r2 = r0.next()
            r3 = r2
            com.talabat.gem.domain.entities.GemRestaurant r3 = (com.talabat.gem.domain.entities.GemRestaurant) r3
            java.lang.Integer r3 = r3.getBranchId()
            if (r3 != 0) goto L_0x0021
            goto L_0x0029
        L_0x0021:
            int r3 = r3.intValue()
            if (r3 != r4) goto L_0x0029
            r3 = 1
            goto L_0x002a
        L_0x0029:
            r3 = 0
        L_0x002a:
            if (r3 == 0) goto L_0x000d
            r1 = r2
        L_0x002d:
            com.talabat.gem.domain.entities.GemRestaurant r1 = (com.talabat.gem.domain.entities.GemRestaurant) r1
        L_0x002f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.gem.domain.usecases.BusinessRulesKt.getIfRestaurantBranchExist(int):com.talabat.gem.domain.entities.GemRestaurant");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.talabat.gem.domain.entities.GemRestaurant} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.talabat.gem.domain.entities.GemRestaurant} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.talabat.gem.domain.entities.GemRestaurant} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.talabat.gem.domain.entities.GemRestaurant} */
    /* JADX WARNING: Multi-variable type inference failed */
    @com.talabat.gem.domain.usecases.BusinessRules
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.talabat.gem.domain.entities.GemRestaurant getIfRestaurantExist(int r4) {
        /*
            java.util.List r0 = loadGemRestaurants()
            r1 = 0
            if (r0 == 0) goto L_0x002f
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x000d:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002d
            java.lang.Object r2 = r0.next()
            r3 = r2
            com.talabat.gem.domain.entities.GemRestaurant r3 = (com.talabat.gem.domain.entities.GemRestaurant) r3
            java.lang.Integer r3 = r3.getId()
            if (r3 != 0) goto L_0x0021
            goto L_0x0029
        L_0x0021:
            int r3 = r3.intValue()
            if (r3 != r4) goto L_0x0029
            r3 = 1
            goto L_0x002a
        L_0x0029:
            r3 = 0
        L_0x002a:
            if (r3 == 0) goto L_0x000d
            r1 = r2
        L_0x002d:
            com.talabat.gem.domain.entities.GemRestaurant r1 = (com.talabat.gem.domain.entities.GemRestaurant) r1
        L_0x002f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.gem.domain.usecases.BusinessRulesKt.getIfRestaurantExist(int):com.talabat.gem.domain.entities.GemRestaurant");
    }

    @NotNull
    public static final GemOffer getNullGemOffer() {
        return (GemOffer) NullGemOffer$delegate.getValue();
    }

    @NotNull
    public static final GemRestaurant getNullGemRestaurant() {
        return (GemRestaurant) NullGemRestaurant$delegate.getValue();
    }

    @BusinessRules
    public static final boolean isExpired(@NotNull GemOffer gemOffer, long j11) {
        Intrinsics.checkNotNullParameter(gemOffer, "<this>");
        if (gemOffer.getExpirationTimestamp() != null && (gemOffer.getExpirationTimestamp().longValue() + ((long) 100)) - j11 > 0) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean isExpired$default(GemOffer gemOffer, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = System.currentTimeMillis();
        }
        return isExpired(gemOffer, j11);
    }

    @BusinessRules
    public static final boolean isGemActive(@Nullable Integer num) {
        Integer num2;
        DataSourcesPort dataSources = IntegrationKt.getDataSources();
        if (num == null || Intrinsics.areEqual((Object) num, (Object) getNullGemRestaurant().getId())) {
            return false;
        }
        if (dataSources.loadExpiredOffer() != null && !Intrinsics.areEqual((Object) dataSources.loadExpiredOffer(), (Object) getNullGemOffer())) {
            return false;
        }
        GemRestaurant loadSelectedGemRestaurant = dataSources.loadSelectedGemRestaurant();
        if (loadSelectedGemRestaurant != null) {
            num2 = loadSelectedGemRestaurant.getId();
        } else {
            num2 = null;
        }
        if (Intrinsics.areEqual((Object) num2, (Object) num)) {
            return true;
        }
        return false;
    }

    @BusinessRules
    public static final boolean isGemOffersActive() {
        if (!gemExpired$default(0, 1, (Object) null)) {
            List<GemRestaurant> loadGemRestaurants = loadGemRestaurants();
            Intrinsics.checkNotNullExpressionValue(loadGemRestaurants, "loadGemRestaurants()");
            if (!loadGemRestaurants.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isPercentage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (StringsKt__StringsJVMKt.equals(str, "percentage_no_progress", true) || StringsKt__StringsJVMKt.equals(str, "percentage_with_progress", true)) {
            return true;
        }
        return false;
    }

    public static final boolean isPercentageWithProgressBarVariantB(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt__StringsJVMKt.equals(str, "percentage_with_progress", true);
    }

    public static final boolean isPercentageWithoutProgressBarVariantA(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt__StringsJVMKt.equals(str, "percentage_no_progress", true);
    }

    /* access modifiers changed from: private */
    public static final List<GemRestaurant> loadGemRestaurants() {
        return (List) KotlinResultKt.toMaybe$default(KotlinResultKt.mapNonNull(IntegrationKt.getDataSources().loadGemOffer(), new BusinessRulesKt$loadGemRestaurants$1((Continuation<? super BusinessRulesKt$loadGemRestaurants$1>) null)), (Function1) null, 1, (Object) null).onErrorComplete().blockingGet();
    }

    /* access modifiers changed from: private */
    public static final List<GemTier> loadGemTiers() {
        return (List) KotlinResultKt.toMaybe$default(KotlinResultKt.mapNonNull(IntegrationKt.getDataSources().loadGemOffer(), new BusinessRulesKt$loadGemTiers$1((Continuation<? super BusinessRulesKt$loadGemTiers$1>) null)), (Function1) null, 1, (Object) null).blockingGet();
    }

    @BusinessRules
    public static final void onSessionChanged() {
        IntegrationKt.getDataSources().clearGemOffer();
        RestaurantsDataSourcesPort.DefaultImpls.updateSelectedGemRestaurant$default(IntegrationKt.getDataSources(), getNullGemRestaurant(), false, 2, (Object) null);
    }

    @BusinessRules
    public static final boolean reachPercentage(@NotNull GemTier gemTier, double d11) {
        Intrinsics.checkNotNullParameter(gemTier, "<this>");
        if (((double) FloatKt.orZero(Float.valueOf(calculatePercentageDiscount(gemTier, d11)))) >= DoubleKt.orZero(gemTier.getOnTotalAmount())) {
            return true;
        }
        return false;
    }

    @NotNull
    @BusinessRules
    public static final Single<GemOffer> resetGemOffer() {
        return KotlinResultKt.toSingle$default(KotlinResultKt.doOnNext(KotlinResultKt.doOnNext(KotlinResultKt.doOnNext(KotlinResultKt.doOnNext(IntegrationKt.getDataSources().loadGemOffer(), new BusinessRulesKt$resetGemOffer$1((Continuation<? super BusinessRulesKt$resetGemOffer$1>) null)), new BusinessRulesKt$resetGemOffer$2((Continuation<? super BusinessRulesKt$resetGemOffer$2>) null)), new BusinessRulesKt$resetGemOffer$3((Continuation<? super BusinessRulesKt$resetGemOffer$3>) null)), new BusinessRulesKt$resetGemOffer$4((Continuation<? super BusinessRulesKt$resetGemOffer$4>) null)), (Function1) null, 1, (Object) null);
    }

    @BusinessRules
    public static final void resetSelectedGemRestaurant() {
        RestaurantsDataSourcesPort.DefaultImpls.updateSelectedGemRestaurant$default(IntegrationKt.getDataSources(), getNullGemRestaurant(), false, 2, (Object) null);
    }

    @BusinessRules
    public static final double savedAmount(@NotNull GemTier gemTier) {
        Intrinsics.checkNotNullParameter(gemTier, "<this>");
        if (gemTier.getOnTotalAmount() == null || gemTier.getPayOnlyAmount() == null) {
            return 0.0d;
        }
        if (isPercentage(gemPercentageVariant)) {
            return gemTier.getOnTotalAmount().doubleValue();
        }
        return gemTier.getOnTotalAmount().doubleValue() - gemTier.getPayOnlyAmount().doubleValue();
    }

    @BusinessRules
    public static final void selectIfGemRestaurant(int i11) {
        continueSelection(getIfRestaurantExist(i11));
    }

    @BusinessRules
    public static final void selectIfGemRestaurantBranch(int i11) {
        continueSelection(getIfRestaurantBranchExist(i11));
    }

    @BusinessRules
    @Nullable
    @JvmOverloads
    public static final Integer selectedRestaurantBranchIndex(@Nullable Integer num) {
        return selectedRestaurantBranchIndex$default(num, (Function0) null, 2, (Object) null);
    }

    @BusinessRules
    @Nullable
    @JvmOverloads
    public static final Integer selectedRestaurantBranchIndex(@Nullable Integer num, @NotNull Function0<? extends List<GemRestaurant>> function0) {
        boolean z11;
        List list;
        Object obj;
        Intrinsics.checkNotNullParameter(function0, "loadRestaurants");
        int i11 = 0;
        if (num != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            function0 = null;
        }
        if (function0 == null || (list = (List) function0.invoke()) == null) {
            return null;
        }
        Iterable iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Object next : iterable) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(TuplesKt.to(Integer.valueOf(i11), (GemRestaurant) next));
            i11 = i12;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((GemRestaurant) ((Pair) obj).getSecond()).getBranchId(), (Object) num)) {
                break;
            }
        }
        Pair pair = (Pair) obj;
        if (pair != null) {
            return (Integer) pair.getFirst();
        }
        return null;
    }

    public static /* synthetic */ Integer selectedRestaurantBranchIndex$default(Integer num, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function0 = BusinessRulesKt$selectedRestaurantBranchIndex$1.INSTANCE;
        }
        return selectedRestaurantBranchIndex(num, function0);
    }

    @BusinessRules
    @Nullable
    @JvmOverloads
    public static final Integer selectedRestaurantIndex(@Nullable Integer num) {
        return selectedRestaurantIndex$default(num, (Function0) null, 2, (Object) null);
    }

    @BusinessRules
    @Nullable
    @JvmOverloads
    public static final Integer selectedRestaurantIndex(@Nullable Integer num, @NotNull Function0<? extends List<GemRestaurant>> function0) {
        boolean z11;
        List list;
        Object obj;
        Intrinsics.checkNotNullParameter(function0, "loadRestaurants");
        int i11 = 0;
        if (num != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            function0 = null;
        }
        if (function0 == null || (list = (List) function0.invoke()) == null) {
            return null;
        }
        Iterable iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Object next : iterable) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(TuplesKt.to(Integer.valueOf(i11), (GemRestaurant) next));
            i11 = i12;
        }
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((GemRestaurant) ((Pair) obj).getSecond()).getId(), (Object) num)) {
                break;
            }
        }
        Pair pair = (Pair) obj;
        if (pair != null) {
            return (Integer) pair.getFirst();
        }
        return null;
    }

    public static /* synthetic */ Integer selectedRestaurantIndex$default(Integer num, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function0 = BusinessRulesKt$selectedRestaurantIndex$1.INSTANCE;
        }
        return selectedRestaurantIndex(num, function0);
    }

    @BusinessRules
    @Nullable
    @JvmOverloads
    public static final Integer selectedTierIndex(@Nullable Double d11) {
        return selectedTierIndex$default(d11, (Function0) null, 2, (Object) null);
    }

    @BusinessRules
    @Nullable
    @JvmOverloads
    public static final Integer selectedTierIndex(@Nullable Double d11, @NotNull Function0<? extends List<GemTier>> function0) {
        boolean z11;
        List list;
        List sortedWith;
        Intrinsics.checkNotNullParameter(function0, BasketDeliveryFeeTiersInfoKeys.KEY_BASKET_DELIVERY_FREE_TIERS);
        boolean z12 = true;
        if (d11 != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            function0 = null;
        }
        if (function0 == null || (list = (List) function0.invoke()) == null || (sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, new BusinessRulesKt$selectedTierIndex$$inlined$sortedBy$1())) == null) {
            return null;
        }
        Integer valueOf = Integer.valueOf(toSubTotalTierIndex(sortedWith, d11));
        if (valueOf.intValue() == -1) {
            z12 = false;
        }
        if (z12) {
            return valueOf;
        }
        return null;
    }

    public static /* synthetic */ Integer selectedTierIndex$default(Double d11, Function0 function0, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function0 = BusinessRulesKt$selectedTierIndex$1.INSTANCE;
        }
        return selectedTierIndex(d11, function0);
    }

    public static final void setEnableGemWordingFromServer(boolean z11) {
        enableGemWordingFromServer = z11;
    }

    public static final void setGemPercentageVariant(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        gemPercentageVariant = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x006c A[EDGE_INSN: B:30:0x006c->B:23:0x006c ?: BREAK  , SYNTHETIC] */
    @com.talabat.gem.domain.usecases.BusinessRules
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.talabat.gem.domain.entities.GemTier subTotalTier(@org.jetbrains.annotations.NotNull java.util.List<com.talabat.gem.domain.entities.GemTier> r6, double r7) {
        /*
            java.lang.String r0 = "tiers"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r6 = r6.iterator()
        L_0x0011:
            boolean r1 = r6.hasNext()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x002d
            java.lang.Object r1 = r6.next()
            r4 = r1
            com.talabat.gem.domain.entities.GemTier r4 = (com.talabat.gem.domain.entities.GemTier) r4
            java.lang.Double r4 = r4.getOnTotalAmount()
            if (r4 == 0) goto L_0x0027
            r2 = r3
        L_0x0027:
            if (r2 == 0) goto L_0x0011
            r0.add(r1)
            goto L_0x0011
        L_0x002d:
            com.talabat.gem.domain.usecases.BusinessRulesKt$subTotalTier$$inlined$sortedBy$1 r6 = new com.talabat.gem.domain.usecases.BusinessRulesKt$subTotalTier$$inlined$sortedBy$1
            r6.<init>()
            java.util.List r6 = kotlin.collections.CollectionsKt___CollectionsKt.sortedWith(r0, r6)
            int r0 = r6.size()
            java.util.ListIterator r6 = r6.listIterator(r0)
        L_0x003e:
            boolean r0 = r6.hasPrevious()
            if (r0 == 0) goto L_0x006b
            java.lang.Object r0 = r6.previous()
            r1 = r0
            com.talabat.gem.domain.entities.GemTier r1 = (com.talabat.gem.domain.entities.GemTier) r1
            java.lang.String r4 = gemPercentageVariant
            boolean r4 = isPercentage(r4)
            if (r4 == 0) goto L_0x0055
        L_0x0053:
            r1 = r3
            goto L_0x0068
        L_0x0055:
            java.lang.Double r1 = r1.getOnTotalAmount()
            if (r1 == 0) goto L_0x0060
            double r4 = r1.doubleValue()
            goto L_0x0062
        L_0x0060:
            r4 = 0
        L_0x0062:
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 < 0) goto L_0x0067
            goto L_0x0053
        L_0x0067:
            r1 = r2
        L_0x0068:
            if (r1 == 0) goto L_0x003e
            goto L_0x006c
        L_0x006b:
            r0 = 0
        L_0x006c:
            com.talabat.gem.domain.entities.GemTier r0 = (com.talabat.gem.domain.entities.GemTier) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.gem.domain.usecases.BusinessRulesKt.subTotalTier(java.util.List, double):com.talabat.gem.domain.entities.GemTier");
    }

    private static final int toSubTotalTierIndex(List<GemTier> list, Double d11) {
        return CollectionsKt___CollectionsKt.indexOf(list, subTotalTier(list, d11 != null ? d11.doubleValue() : 0.0d));
    }
}
