package com.talabat.components;

import android.content.Context;
import com.talabat.R;
import datamodels.filters.FilterType;
import datamodels.filters.SelectablePopularFilter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u001a\u0010\u0006\u001a\f\u0012\u0004\u0012\u00020\u00010\u0007j\u0002`\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\f"}, d2 = {"fastDeliveryFilter", "Ldatamodels/filters/SelectablePopularFilter;", "context", "Landroid/content/Context;", "freeDeliveryFilter", "lowPriceFilter", "makePopularFilters", "", "Ldatamodels/SelectablePopularFilters;", "newlyAddedFilter", "noMinimumOrderFilter", "topRateFilter", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PopularFilterFactoryKt {
    private static final SelectablePopularFilter fastDeliveryFilter(Context context) {
        String string = context.getString(R.string.vl_fast_delivery_filter);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta….vl_fast_delivery_filter)");
        return new SelectablePopularFilter(new FilterType(string, "fast_delivery(within_30_mins)", PopularFilterFactoryKt$fastDeliveryFilter$1.INSTANCE, 0, 8, (DefaultConstructorMarker) null), false);
    }

    private static final SelectablePopularFilter freeDeliveryFilter(Context context) {
        String string = context.getString(R.string.vl_free_delivery_filter);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta….vl_free_delivery_filter)");
        return new SelectablePopularFilter(new FilterType(string, "free_delivery", PopularFilterFactoryKt$freeDeliveryFilter$1.INSTANCE, 0, 8, (DefaultConstructorMarker) null), false);
    }

    private static final SelectablePopularFilter lowPriceFilter(Context context) {
        String string = context.getString(R.string.vl_low_price_filter);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta…ring.vl_low_price_filter)");
        return new SelectablePopularFilter(new FilterType(string, "price:_$_-_$$", PopularFilterFactoryKt$lowPriceFilter$1.INSTANCE, 0, 8, (DefaultConstructorMarker) null), false);
    }

    @NotNull
    public static final List<SelectablePopularFilter> makePopularFilters(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return CollectionsKt__CollectionsKt.listOf(fastDeliveryFilter(context), freeDeliveryFilter(context), lowPriceFilter(context), topRateFilter(context), noMinimumOrderFilter(context), newlyAddedFilter(context));
    }

    private static final SelectablePopularFilter newlyAddedFilter(Context context) {
        String string = context.getString(R.string.vl_newly_added_filter);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta…ng.vl_newly_added_filter)");
        return new SelectablePopularFilter(new FilterType(string, "newly_added", PopularFilterFactoryKt$newlyAddedFilter$1.INSTANCE, 0, 8, (DefaultConstructorMarker) null), false);
    }

    private static final SelectablePopularFilter noMinimumOrderFilter(Context context) {
        String string = context.getString(R.string.vl_no_minimum_order);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta…ring.vl_no_minimum_order)");
        return new SelectablePopularFilter(new FilterType(string, "no_minimum_order", PopularFilterFactoryKt$noMinimumOrderFilter$1.INSTANCE, 0, 8, (DefaultConstructorMarker) null), false);
    }

    private static final SelectablePopularFilter topRateFilter(Context context) {
        String string = context.getString(R.string.vl_top_rated_filter);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta…ring.vl_top_rated_filter)");
        return new SelectablePopularFilter(new FilterType(string, "top_rated", PopularFilterFactoryKt$topRateFilter$1.INSTANCE, 0, 8, (DefaultConstructorMarker) null), false);
    }
}
