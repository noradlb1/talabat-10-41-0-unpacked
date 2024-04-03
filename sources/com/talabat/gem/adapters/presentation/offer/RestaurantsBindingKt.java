package com.talabat.gem.adapters.presentation.offer;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.presentation.ImageViewsKt;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.gem.domain.entities.Rating;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.helpers.DynamicLocalizationKt;
import com.talabat.talabatcommon.views.ratings.SmallStarRatingView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vq.a;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0002\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\u0010\u0005\u001a\u0017\u0010\u0006\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\u0010\u0005\u001a\"\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\rH\u0000\u001a\u0014\u0010\u000e\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u000e\u0010\u000f\u001a\u00020\u0010*\u0004\u0018\u00010\u0011H\u0000\u001a\u000e\u0010\u0012\u001a\u00020\u0001*\u0004\u0018\u00010\u0011H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"NO_MINIMUM_AMOUNT", "", "deliveryCostText", "amount", "", "(Ljava/lang/Double;)Ljava/lang/String;", "minimumOrderAmountText", "bindGemRestaurant", "", "Landroid/view/View;", "restaurant", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "onClick", "Lkotlin/Function0;", "bindRating", "toImageResource", "", "Lcom/talabat/gem/domain/entities/Rating;", "toLabel", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RestaurantsBindingKt {
    @NotNull
    private static final String NO_MINIMUM_AMOUNT = "00.00";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Rating.values().length];
            iArr[Rating.AMAZING.ordinal()] = 1;
            iArr[Rating.VERY_GOOD.ordinal()] = 2;
            iArr[Rating.GOOD.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void bindGemRestaurant(@NotNull View view, @NotNull GemRestaurant gemRestaurant, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(gemRestaurant, "restaurant");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        TextView textView = (TextView) view.findViewById(R.id.vendorName);
        Intrinsics.checkNotNullExpressionValue(textView, "vendorName");
        ViewKt.plusAssign(textView, gemRestaurant.getName());
        TextView textView2 = (TextView) view.findViewById(R.id.textView_cuisines);
        Intrinsics.checkNotNullExpressionValue(textView2, "textView_cuisines");
        ViewKt.plusAssign(textView2, gemRestaurant.getCuisines());
        TextView textView3 = (TextView) view.findViewById(R.id.imageView_newTag);
        Intrinsics.checkNotNullExpressionValue(textView3, "imageView_newTag");
        ViewKt.get(textView3, gemRestaurant.isNew(), 8);
        TextView textView4 = (TextView) view.findViewById(R.id.vendorRateStatus);
        Intrinsics.checkNotNullExpressionValue(textView4, "vendorRateStatus");
        ViewKt.plusAssign(textView4, toLabel(gemRestaurant.getRating()));
        ImageView imageView = (ImageView) view.findViewById(R.id.vendorRateAvatar);
        Intrinsics.checkNotNullExpressionValue(imageView, "vendorRateAvatar");
        ViewKt.plusAssign(imageView, toImageResource(gemRestaurant.getRating()));
        TextView textView5 = (TextView) view.findViewById(R.id.textView_averageDeliveryTime);
        Intrinsics.checkNotNullExpressionValue(textView5, "textView_averageDeliveryTime");
        ViewKt.plusAssign(textView5, gemRestaurant.getDeliveryAverageTime());
        AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R.id.textView_deliveryCost);
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "textView_deliveryCost");
        ViewKt.plusAssign((TextView) appCompatTextView, deliveryCostText(gemRestaurant.getDeliveryCost()));
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) view.findViewById(R.id.minimumAmountTextView);
        Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "minimumAmountTextView");
        ViewKt.plusAssign((TextView) appCompatTextView2, minimumOrderAmountText(gemRestaurant.getMinimumOrderAmount()));
        ImageView imageView2 = (ImageView) view.findViewById(R.id.imageView_restaurantLogo);
        Intrinsics.checkNotNullExpressionValue(imageView2, "imageView_restaurantLogo");
        ImageViewsKt.drawThumbnail$default(imageView2, gemRestaurant.getImageUrl(), 0.0f, 2, (Object) null);
        bindRating(view, gemRestaurant);
        view.setOnClickListener(new a(function0));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindGemRestaurant$lambda-0  reason: not valid java name */
    public static final void m10543bindGemRestaurant$lambda0(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onClick");
        function0.invoke();
    }

    private static final void bindRating(View view, GemRestaurant gemRestaurant) {
        float f11;
        ((TextView) view.findViewById(R.id.vendorRateStatus)).setVisibility(8);
        ((ImageView) view.findViewById(R.id.vendorRateAvatar)).setVisibility(8);
        int i11 = R.id.smallStarRating;
        ((SmallStarRatingView) view.findViewById(i11)).setVisibility(0);
        SmallStarRatingView smallStarRatingView = (SmallStarRatingView) view.findViewById(i11);
        Float ratingRaw = gemRestaurant.getRatingRaw();
        if (ratingRaw != null) {
            f11 = ratingRaw.floatValue();
        } else {
            f11 = 0.0f;
        }
        smallStarRatingView.setRating(f11);
        ((SmallStarRatingView) view.findViewById(i11)).setReviewsAmount(gemRestaurant.getReviews());
        ((SmallStarRatingView) view.findViewById(i11)).setColors(CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(ContextCompat.getColor(view.getContext(), com.designsystem.marshmallow.R.color.ds_alert_100))));
    }

    @NotNull
    public static final String deliveryCostText(@Nullable Double d11) {
        String str;
        String localizedString$default = DynamicLocalizationKt.toLocalizedString$default(com.talabat.localization.R.string.gem_delivery_fee, (String) null, 1, (Object) null);
        if (Intrinsics.areEqual(d11, 0.0d)) {
            str = DynamicLocalizationKt.toLocalizedString$default(com.talabat.localization.R.string.free_caps, (String) null, 1, (Object) null);
        } else if (d11 == null || (str = d11.toString()) == null) {
            str = NO_MINIMUM_AMOUNT;
        }
        return StringsKt__StringsJVMKt.replace$default(localizedString$default, "{amount}", str, false, 4, (Object) null);
    }

    @NotNull
    public static final String minimumOrderAmountText(@Nullable Double d11) {
        String str;
        String localizedString$default = DynamicLocalizationKt.toLocalizedString$default(com.talabat.localization.R.string.min_order_amount, (String) null, 1, (Object) null);
        if (d11 == null || (str = d11.toString()) == null) {
            str = NO_MINIMUM_AMOUNT;
        }
        return StringsKt__StringsJVMKt.replace$default(localizedString$default, "{amount}", str, false, 4, (Object) null);
    }

    public static final int toImageResource(@Nullable Rating rating) {
        int i11;
        if (rating == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[rating.ordinal()];
        }
        if (i11 == 1) {
            return R.drawable.ic_vendor_rate_amazing;
        }
        if (i11 == 2) {
            return R.drawable.ic_vendor_rate_very_good;
        }
        if (i11 != 3) {
            return R.drawable.ic_vendor_rate_ok;
        }
        return R.drawable.ic_vendor_rate_good;
    }

    @NotNull
    public static final String toLabel(@Nullable Rating rating) {
        int i11;
        if (rating == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[rating.ordinal()];
        }
        if (i11 == 1) {
            return DynamicLocalizationKt.toLocalizedString$default(com.talabat.localization.R.string.rating_amazing, (String) null, 1, (Object) null);
        }
        if (i11 == 2) {
            return DynamicLocalizationKt.toLocalizedString$default(com.talabat.localization.R.string.rating_very_good, (String) null, 1, (Object) null);
        }
        if (i11 != 3) {
            return DynamicLocalizationKt.toLocalizedString$default(com.talabat.localization.R.string.rating_ok, (String) null, 1, (Object) null);
        }
        return DynamicLocalizationKt.toLocalizedString$default(com.talabat.localization.R.string.rating_good, (String) null, 1, (Object) null);
    }
}
