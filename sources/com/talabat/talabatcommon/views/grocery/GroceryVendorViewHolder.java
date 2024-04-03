package com.talabat.talabatcommon.views.grocery;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.R;
import datamodels.Restaurant;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlinx.android.extensions.LayoutContainer;
import nv.a;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00128\u0010\u0005\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bRC\u0010\u0005\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatcommon/views/grocery/GroceryVendorViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "clickListener", "Lkotlin/Function2;", "Ldatamodels/Restaurant;", "Lkotlin/ParameterName;", "name", "restaurant", "", "position", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function2;)V", "getClickListener", "()Lkotlin/jvm/functions/Function2;", "getContainerView", "()Landroid/view/View;", "bind", "vendor", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GroceryVendorViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
    @NotNull
    private final Function2<Restaurant, Integer, Unit> clickListener;
    @NotNull
    private final View containerView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GroceryVendorViewHolder(@NotNull View view, @NotNull Function2<? super Restaurant, ? super Integer, Unit> function2) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "containerView");
        Intrinsics.checkNotNullParameter(function2, "clickListener");
        this.containerView = view;
        this.clickListener = function2;
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-0  reason: not valid java name */
    public static final void m5767bind$lambda0(GroceryVendorViewHolder groceryVendorViewHolder, Restaurant restaurant, int i11, View view) {
        Intrinsics.checkNotNullParameter(groceryVendorViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(restaurant, "$vendor");
        groceryVendorViewHolder.clickListener.invoke(restaurant, Integer.valueOf(i11));
    }

    public final void bind(@NotNull Restaurant restaurant, int i11) {
        Intrinsics.checkNotNullParameter(restaurant, "vendor");
        getContainerView().setOnClickListener(new a(this, restaurant, i11));
        ((TextView) getContainerView().findViewById(R.id.vendorName)).setText(restaurant.f13873name);
        ((TextView) getContainerView().findViewById(R.id.vendorCuisine)).setText(restaurant.getCuisineString());
        ((TextView) getContainerView().findViewById(R.id.deliveryTime)).setText(restaurant.deliveryTime);
        if (restaurant.isNewRestaurant) {
            ((TextView) getContainerView().findViewById(R.id.newTag)).setVisibility(0);
        } else {
            ((TextView) getContainerView().findViewById(R.id.newTag)).setVisibility(8);
        }
        ((VendorLogo) getContainerView().findViewById(R.id.vendorLogo)).setVendorLogo(restaurant.getLogo(), restaurant.statusType);
        if (restaurant.isDiscountAvaialble()) {
            String discountDiscription = restaurant.getDiscountDiscription();
            Intrinsics.checkNotNullExpressionValue(discountDiscription, "vendor.getDiscountDiscription()");
            if (StringsKt__StringsKt.contains$default((CharSequence) discountDiscription, (CharSequence) "%", false, 2, (Object) null)) {
                String discountDiscription2 = restaurant.getDiscountDiscription();
                Intrinsics.checkNotNullExpressionValue(discountDiscription2, "vendor.getDiscountDiscription()");
                Object[] array = new Regex("%").split(discountDiscription2, 0).toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr = (String[]) array;
                if (StringsKt__StringsJVMKt.equals(GlobalDataModel.SelectedLanguage, "en-US", true)) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("%s%% %s", Arrays.copyOf(new Object[]{strArr[0], getContainerView().getContext().getString(com.talabat.localization.R.string.discount_tag)}, 2));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    ((TextView) getContainerView().findViewById(R.id.discountTag)).setText(format);
                } else {
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String format2 = String.format("%s%%", Arrays.copyOf(new Object[]{strArr[0]}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
                    ((TextView) getContainerView().findViewById(R.id.discountTag)).setText(format2);
                }
                ((TextView) getContainerView().findViewById(R.id.discountTag)).setVisibility(0);
            } else {
                ((TextView) getContainerView().findViewById(R.id.discountTag)).setVisibility(8);
            }
        } else {
            ((TextView) getContainerView().findViewById(R.id.discountTag)).setVisibility(8);
        }
        if (restaurant.isPromotionAvailable()) {
            ((TextView) getContainerView().findViewById(R.id.offersTag)).setVisibility(0);
        } else {
            ((TextView) getContainerView().findViewById(R.id.offersTag)).setVisibility(8);
        }
    }

    @NotNull
    public final Function2<Restaurant, Integer, Unit> getClickListener() {
        return this.clickListener;
    }

    @NotNull
    public View getContainerView() {
        return this.containerView;
    }
}
