package com.talabat.collectiondetails.helpers;

import com.talabat.localization.R;
import com.talabat.talabatcommon.helpers.DynamicLocalizationKt;
import datamodels.Filter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/talabat/collectiondetails/helpers/PopularFilterHelper;", "", "()V", "Companion", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PopularFilterHelper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int FAST_DELIVERY_FILTER_ID = 100000;
    private static final int FREE_DELIVERY_FILTER_ID = 100001;
    private static final int LOW_PRICE_FILTER_ID = 100002;
    private static final int NEWLY_ADDED_FILTER_ID = 100005;
    private static final int NO_MINIMUM_ORDER_FILTER_ID = 100004;
    private static final int TOP_RATED_FILTER_ID = 100003;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\n\u001a\u00020\u000b*\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/collectiondetails/helpers/PopularFilterHelper$Companion;", "", "()V", "FAST_DELIVERY_FILTER_ID", "", "FREE_DELIVERY_FILTER_ID", "LOW_PRICE_FILTER_ID", "NEWLY_ADDED_FILTER_ID", "NO_MINIMUM_ORDER_FILTER_ID", "TOP_RATED_FILTER_ID", "getTranslatedFilterName", "", "Ldatamodels/Filter;", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTranslatedFilterName(@NotNull Filter filter) {
            Intrinsics.checkNotNullParameter(filter, "<this>");
            switch (filter.getId()) {
                case 100000:
                    int i11 = R.string.vl_fast_delivery_filter;
                    String name2 = filter.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "name");
                    return DynamicLocalizationKt.toLocalizedString(i11, name2);
                case PopularFilterHelper.FREE_DELIVERY_FILTER_ID /*100001*/:
                    int i12 = R.string.vl_free_delivery_filter;
                    String name3 = filter.getName();
                    Intrinsics.checkNotNullExpressionValue(name3, "name");
                    return DynamicLocalizationKt.toLocalizedString(i12, name3);
                case PopularFilterHelper.LOW_PRICE_FILTER_ID /*100002*/:
                    int i13 = R.string.vl_low_price_filter;
                    String name4 = filter.getName();
                    Intrinsics.checkNotNullExpressionValue(name4, "name");
                    return DynamicLocalizationKt.toLocalizedString(i13, name4);
                case PopularFilterHelper.TOP_RATED_FILTER_ID /*100003*/:
                    int i14 = R.string.vl_top_rated_filter;
                    String name5 = filter.getName();
                    Intrinsics.checkNotNullExpressionValue(name5, "name");
                    return DynamicLocalizationKt.toLocalizedString(i14, name5);
                case PopularFilterHelper.NO_MINIMUM_ORDER_FILTER_ID /*100004*/:
                    int i15 = R.string.vl_no_minimum_order;
                    String name6 = filter.getName();
                    Intrinsics.checkNotNullExpressionValue(name6, "name");
                    return DynamicLocalizationKt.toLocalizedString(i15, name6);
                case PopularFilterHelper.NEWLY_ADDED_FILTER_ID /*100005*/:
                    int i16 = R.string.vl_newly_added_filter;
                    String name7 = filter.getName();
                    Intrinsics.checkNotNullExpressionValue(name7, "name");
                    return DynamicLocalizationKt.toLocalizedString(i16, name7);
                default:
                    String name8 = filter.getName();
                    if (name8 == null) {
                        return "";
                    }
                    return name8;
            }
        }
    }

    private PopularFilterHelper() {
    }
}
