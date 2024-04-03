package com.talabat.gem.adapters.presentation.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.presentation.ImageViewsKt;
import com.talabat.gem.adapters.presentation.offer.RestaurantsBindingKt;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.helpers.DynamicLocalizationKt;
import com.talabat.talabatcommon.views.ratings.SmallStarRatingView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import uq.b;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\"\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0000\u001a\u0014\u0010\u000b\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"EMPTY_TEXT", "", "deliveryText", "minutes", "bindGemSwimlaneRestaurant", "", "Landroid/view/View;", "restaurant", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "onClick", "Lkotlin/Function0;", "bindRating", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SwimlanesRestaurantsBindingKt {
    @NotNull
    private static final String EMPTY_TEXT = "";

    public static final void bindGemSwimlaneRestaurant(@NotNull View view, @NotNull GemRestaurant gemRestaurant, @NotNull Function0<Unit> function0) {
        String str;
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(gemRestaurant, "restaurant");
        Intrinsics.checkNotNullParameter(function0, "onClick");
        TextView textView = (TextView) view.findViewById(R.id.vendorName);
        Intrinsics.checkNotNullExpressionValue(textView, "vendorName");
        ViewKt.plusAssign(textView, gemRestaurant.getName());
        TextView textView2 = (TextView) view.findViewById(R.id.textView_cuisines);
        Intrinsics.checkNotNullExpressionValue(textView2, "textView_cuisines");
        ViewKt.plusAssign(textView2, gemRestaurant.getCuisines());
        TextView textView3 = (TextView) view.findViewById(R.id.vendorRateStatus);
        Intrinsics.checkNotNullExpressionValue(textView3, "vendorRateStatus");
        ViewKt.plusAssign(textView3, RestaurantsBindingKt.toLabel(gemRestaurant.getRating()));
        ImageView imageView = (ImageView) view.findViewById(R.id.vendorRateAvatar);
        Intrinsics.checkNotNullExpressionValue(imageView, "vendorRateAvatar");
        ViewKt.plusAssign(imageView, RestaurantsBindingKt.toImageResource(gemRestaurant.getRating()));
        ImageView imageView2 = (ImageView) view.findViewById(R.id.imageView_restaurantLogo);
        Intrinsics.checkNotNullExpressionValue(imageView2, "imageView_restaurantLogo");
        ImageViewsKt.drawThumbnail$default(imageView2, gemRestaurant.getImageUrl(), 0.0f, 2, (Object) null);
        TextView textView4 = (TextView) view.findViewById(R.id.deliveryTextView);
        Intrinsics.checkNotNullExpressionValue(textView4, "deliveryTextView");
        Integer deliveryAverageMinutes = gemRestaurant.getDeliveryAverageMinutes();
        if (deliveryAverageMinutes == null || (str = deliveryAverageMinutes.toString()) == null) {
            str = "";
        }
        ViewKt.plusAssign(textView4, deliveryText(str));
        TextView textView5 = (TextView) view.findViewById(R.id.deliveryCoastTextView);
        Intrinsics.checkNotNullExpressionValue(textView5, "deliveryCoastTextView");
        ViewKt.plusAssign(textView5, gemRestaurant.getDeliveryCostFormatted());
        bindRating(view, gemRestaurant);
        view.setOnClickListener(new b(function0));
    }

    /* access modifiers changed from: private */
    /* renamed from: bindGemSwimlaneRestaurant$lambda-0  reason: not valid java name */
    public static final void m10539bindGemSwimlaneRestaurant$lambda0(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onClick");
        function0.invoke();
    }

    private static final void bindRating(View view, GemRestaurant gemRestaurant) {
        float f11;
        ((TextView) view.findViewById(R.id.vendorRateStatus)).setVisibility(8);
        ((ImageView) view.findViewById(R.id.vendorRateAvatar)).setVisibility(8);
        int i11 = R.id.smallStarRating_gem;
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

    private static final String deliveryText(String str) {
        return StringsKt__StringsJVMKt.replace$default(DynamicLocalizationKt.toLocalizedString$default(com.talabat.localization.R.string.gem_restaurant_delivery_minutes, (String) null, 1, (Object) null), "{minutes}", str, false, 4, (Object) null);
    }
}
