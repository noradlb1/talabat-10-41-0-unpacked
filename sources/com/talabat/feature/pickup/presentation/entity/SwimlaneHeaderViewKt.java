package com.talabat.feature.pickup.presentation.entity;

import com.talabat.feature.pickup.data.events.swimlanes.SwimlanesTracking;
import com.talabat.feature.pickup.domain.entity.PickupSwimlane;
import datamodels.Strategy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u0002\u001a8\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002\u001a*\u0010\u0011\u001a\u00020\u0012*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"DISTANCE_FORMATTER", "", "mapSwimlaneView", "", "Lcom/talabat/feature/pickup/presentation/entity/SwimlaneView;", "restaurants", "Ldatamodels/Restaurant;", "mapTracking", "Lcom/talabat/feature/pickup/data/events/swimlanes/SwimlanesTracking;", "swimlane", "Lcom/talabat/feature/pickup/domain/entity/PickupSwimlane;", "trackingTitles", "trackingStrategyList", "index", "", "swimlanesTotal", "shopTotal", "toView", "Lcom/talabat/feature/pickup/presentation/entity/SwimlaneHeaderView;", "trackingStrategy", "com_talabat_feature_pickup_presentation_presentation"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneHeaderViewKt {
    @NotNull
    private static final String DISTANCE_FORMATTER = "%.2f";

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0061 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.util.List<com.talabat.feature.pickup.presentation.entity.SwimlaneView> mapSwimlaneView(java.util.List<? extends datamodels.Restaurant> r10) {
        /*
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r10, r1)
            r0.<init>(r1)
            java.util.Iterator r10 = r10.iterator()
        L_0x0011:
            boolean r1 = r10.hasNext()
            if (r1 == 0) goto L_0x0079
            java.lang.Object r1 = r10.next()
            r8 = r1
            datamodels.Restaurant r8 = (datamodels.Restaurant) r8
            java.lang.String r1 = r8.totalRatingNonformatted
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x0026
            r7 = r2
            goto L_0x0027
        L_0x0026:
            r7 = r1
        L_0x0027:
            java.lang.String r1 = r8.getPickupDistanceKm()
            if (r1 == 0) goto L_0x003d
            java.lang.String r3 = "pickupDistanceKm"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            java.lang.Double r1 = kotlin.text.StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(r1)
            if (r1 == 0) goto L_0x003d
            double r3 = r1.doubleValue()
            goto L_0x003f
        L_0x003d:
            r3 = 0
        L_0x003f:
            java.util.Locale r1 = java.util.Locale.ENGLISH
            r5 = 1
            java.lang.Object[] r6 = new java.lang.Object[r5]
            r9 = 0
            java.lang.Double r3 = java.lang.Double.valueOf(r3)
            r6[r9] = r3
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r6, r5)
            java.lang.String r4 = "%.2f"
            java.lang.String r5 = java.lang.String.format(r1, r4, r3)
            java.lang.String r1 = "format(locale, this, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r1)
            com.talabat.feature.pickup.presentation.entity.SwimlaneView r1 = new com.talabat.feature.pickup.presentation.entity.SwimlaneView
            java.lang.String r3 = r8.f13873name
            if (r3 != 0) goto L_0x0061
            r3 = r2
        L_0x0061:
            float r2 = r8.rating
            java.lang.String r4 = java.lang.String.valueOf(r2)
            java.lang.String r6 = r8.getTalabatCoverLogo()
            java.lang.String r2 = "vendor.talabatCoverLogo"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r2)
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8)
            r0.add(r1)
            goto L_0x0011
        L_0x0079:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.pickup.presentation.entity.SwimlaneHeaderViewKt.mapSwimlaneView(java.util.List):java.util.List");
    }

    private static final SwimlanesTracking mapTracking(PickupSwimlane pickupSwimlane, String str, String str2, int i11, int i12, int i13) {
        String str3;
        String str4;
        String str5;
        String str6 = null;
        String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(pickupSwimlane.getRestaurants(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, SwimlaneHeaderViewKt$mapTracking$shopIds$1.INSTANCE, 31, (Object) null);
        Strategy strategy = pickupSwimlane.getStrategy();
        if (strategy != null) {
            str3 = strategy.getRecommendationStrategy();
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str4 = "";
        } else {
            str4 = str3;
        }
        String slug = pickupSwimlane.getSlug();
        Strategy strategy2 = pickupSwimlane.getStrategy();
        if (strategy2 != null) {
            str6 = strategy2.getRequestId();
        }
        if (str6 == null) {
            str5 = "";
        } else {
            str5 = str6;
        }
        return new SwimlanesTracking(str, str2, str4, joinToString$default, i11, slug, i12, i13, str5, 0, (Integer) null, (Integer) null, 3584, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final SwimlaneHeaderView toView(@NotNull PickupSwimlane pickupSwimlane, @NotNull String str, @NotNull String str2, int i11, int i12) {
        Intrinsics.checkNotNullParameter(pickupSwimlane, "<this>");
        Intrinsics.checkNotNullParameter(str, "trackingTitles");
        Intrinsics.checkNotNullParameter(str2, "trackingStrategy");
        return new SwimlaneHeaderView(pickupSwimlane.getTitle(), pickupSwimlane.getSubtitle(), mapSwimlaneView(pickupSwimlane.getRestaurants()), mapTracking(pickupSwimlane, str, str2, i11, i12, pickupSwimlane.getRestaurants().size()));
    }
}
