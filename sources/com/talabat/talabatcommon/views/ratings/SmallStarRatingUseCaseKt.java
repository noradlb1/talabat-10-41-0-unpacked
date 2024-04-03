package com.talabat.talabatcommon.views.ratings;

import com.talabat.talabatcommon.extentions.CoroutinesKt;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0005\u001a\u000e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0001\u001a*\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013\u001a\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u001a*\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00132\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0013H\u0002\u001a\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u0005H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"HUNDRED_LIMIT", "", "MORE_THAN_HUNDRED", "", "RANGE_AMAZING_END", "", "RANGE_AMAZING_START", "RANGE_FAIR_END", "RANGE_FAIR_START", "RANGE_GOOD_END", "RANGE_GOOD_START", "RANGE_VERY_GOOD_END", "RANGE_VERY_GOOD_START", "formatRating", "rating", "formatReviews", "reviews", "getColorFromRating", "ratingRanges", "", "Lcom/talabat/talabatcommon/views/ratings/RatingRange;", "colors", "getDefaultRatings", "mapRatingRange", "Lcom/talabat/talabatcommon/views/ratings/RatingRangeWithColor;", "isInRange", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SmallStarRatingUseCaseKt {
    public static final int HUNDRED_LIMIT = 100;
    @NotNull
    public static final String MORE_THAN_HUNDRED = "(100+)";
    public static final float RANGE_AMAZING_END = 5.0f;
    public static final float RANGE_AMAZING_START = 4.7f;
    public static final float RANGE_FAIR_END = 2.7f;
    public static final float RANGE_FAIR_START = 0.0f;
    public static final float RANGE_GOOD_END = 3.7f;
    public static final float RANGE_GOOD_START = 2.8f;
    public static final float RANGE_VERY_GOOD_END = 4.7f;
    public static final float RANGE_VERY_GOOD_START = 3.8f;

    @NotNull
    public static final String formatRating(float f11) {
        String bigDecimal = new BigDecimal(String.valueOf(f11)).setScale(1, RoundingMode.CEILING).toString();
        Intrinsics.checkNotNullExpressionValue(bigDecimal, "rating.toBigDecimal().se…gMode.CEILING).toString()");
        return bigDecimal;
    }

    @NotNull
    public static final String formatReviews(int i11) {
        if (i11 > 100) {
            return MORE_THAN_HUNDRED;
        }
        return "(" + i11 + ")";
    }

    public static final int getColorFromRating(float f11, @NotNull List<RatingRange> list, @NotNull List<Integer> list2) {
        Intrinsics.checkNotNullParameter(list, "ratingRanges");
        Intrinsics.checkNotNullParameter(list2, "colors");
        Integer num = (Integer) CoroutinesKt.returnHandling$default((Function1) null, (Object) null, new SmallStarRatingUseCaseKt$getColorFromRating$1(list, list2, f11), 3, (Object) null);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @NotNull
    public static final List<RatingRange> getDefaultRatings() {
        return CollectionsKt__CollectionsKt.listOf(new RatingRange(0.0f, 2.7f), new RatingRange(2.8f, 3.7f), new RatingRange(3.8f, 4.7f), new RatingRange(4.7f, 5.0f));
    }

    /* access modifiers changed from: private */
    public static final boolean isInRange(RatingRangeWithColor ratingRangeWithColor, float f11) {
        return f11 >= ratingRangeWithColor.getRange().getStart() && f11 <= ratingRangeWithColor.getRange().getEnd();
    }

    /* access modifiers changed from: private */
    public static final List<RatingRangeWithColor> mapRatingRange(List<RatingRange> list, List<Integer> list2) {
        Integer num;
        int i11;
        Iterable iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        int i12 = 0;
        for (Object next : iterable) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            RatingRange ratingRange = (RatingRange) next;
            if (i12 < 0 || i12 > CollectionsKt__CollectionsKt.getLastIndex(list2)) {
                Integer num2 = (Integer) CollectionsKt___CollectionsKt.lastOrNull(list2);
                if (num2 != null) {
                    i11 = num2.intValue();
                } else {
                    i11 = 0;
                }
                num = Integer.valueOf(i11);
            } else {
                num = list2.get(i12);
            }
            arrayList.add(new RatingRangeWithColor(ratingRange, num.intValue()));
            i12 = i13;
        }
        return arrayList;
    }
}
