package com.talabat.talabatcommon.views.ratings;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SmallStarRatingUseCaseKt$getColorFromRating$1 extends Lambda implements Function0<Integer> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ List<RatingRange> f11733g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List<Integer> f11734h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f11735i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SmallStarRatingUseCaseKt$getColorFromRating$1(List<RatingRange> list, List<Integer> list2, float f11) {
        super(0);
        this.f11733g = list;
        this.f11734h = list2;
        this.f11735i = f11;
    }

    @NotNull
    public final Integer invoke() {
        Object obj;
        int i11;
        float f11 = this.f11735i;
        Iterator it = SmallStarRatingUseCaseKt.mapRatingRange(this.f11733g, this.f11734h).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (SmallStarRatingUseCaseKt.isInRange((RatingRangeWithColor) obj, f11)) {
                break;
            }
        }
        RatingRangeWithColor ratingRangeWithColor = (RatingRangeWithColor) obj;
        if (ratingRangeWithColor != null) {
            i11 = ratingRangeWithColor.getColor();
        } else {
            i11 = ((Number) CollectionsKt___CollectionsKt.first(this.f11734h)).intValue();
        }
        return Integer.valueOf(i11);
    }
}
