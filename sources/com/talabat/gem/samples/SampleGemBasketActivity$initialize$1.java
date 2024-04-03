package com.talabat.gem.samples;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.presentation.GemCheckoutDiscountConfigurations;
import com.talabat.gem.adapters.presentation.GemCheckoutFooterConfigurations;
import com.talabat.gem.adapters.presentation.checkout.GemCheckoutDiscountView;
import com.talabat.gem.adapters.presentation.checkout.GemCheckoutFooterView;
import com.talabat.talabatcommon.extension.ViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/appcompat/app/AppCompatActivity;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SampleGemBasketActivity$initialize$1 extends Lambda implements Function1<AppCompatActivity, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SampleGemBasketActivity f60502g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SampleGemBasketActivity$initialize$1(SampleGemBasketActivity sampleGemBasketActivity) {
        super(1);
        this.f60502g = sampleGemBasketActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AppCompatActivity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull final AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "$this$withLayout");
        final SampleGemBasketActivity sampleGemBasketActivity = this.f60502g;
        RouterKt.withNavigationData(appCompatActivity, new Function1<NavigationData, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((NavigationData) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull final NavigationData navigationData) {
                Intrinsics.checkNotNullParameter(navigationData, "$this$withNavigationData");
                sampleGemBasketActivity.calculatedSubTotal = navigationData.getSubTotal();
                TextView textView = (TextView) appCompatActivity.findViewById(R.id.restaurantIdTextView);
                Intrinsics.checkNotNullExpressionValue(textView, "restaurantIdTextView");
                int restaurantId = navigationData.getRestaurantId();
                ViewKt.plusAssign(textView, "Restaurant Id : " + restaurantId);
                AppCompatActivity appCompatActivity = appCompatActivity;
                int i11 = R.id.basketSubTotalEditText;
                EditText editText = (EditText) appCompatActivity.findViewById(i11);
                Intrinsics.checkNotNullExpressionValue(editText, "basketSubTotalEditText");
                ViewKt.plusAssign((TextView) editText, String.valueOf(navigationData.getSubTotal()));
                EditText editText2 = (EditText) appCompatActivity.findViewById(i11);
                Intrinsics.checkNotNullExpressionValue(editText2, "basketSubTotalEditText");
                editText2.addTextChangedListener(new SampleGemBasketActivity$initialize$1$1$invoke$$inlined$addTextChangedListener$default$1(sampleGemBasketActivity, appCompatActivity));
                Button button = (Button) appCompatActivity.findViewById(R.id.openCheckoutButton);
                Intrinsics.checkNotNullExpressionValue(button, "openCheckoutButton");
                final AppCompatActivity appCompatActivity2 = appCompatActivity;
                final SampleGemBasketActivity sampleGemBasketActivity = sampleGemBasketActivity;
                ViewKt.invoke(button, new Function1<View, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((View) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$invoke");
                        RouterKt.navigate(appCompatActivity2, Reflection.getOrCreateKotlinClass(SampleGemCheckoutActivity.class), navigationData.getRestaurantId(), sampleGemBasketActivity.calculatedSubTotal);
                    }
                });
                final SampleGemBasketActivity sampleGemBasketActivity2 = sampleGemBasketActivity;
                ((GemCheckoutDiscountView) appCompatActivity.findViewById(R.id.gemBasketDiscountView)).invoke(new Function1<GemCheckoutDiscountConfigurations, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GemCheckoutDiscountConfigurations) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull GemCheckoutDiscountConfigurations gemCheckoutDiscountConfigurations) {
                        Intrinsics.checkNotNullParameter(gemCheckoutDiscountConfigurations, "$this$invoke");
                        gemCheckoutDiscountConfigurations.getWith().restaurantId(Integer.valueOf(navigationData.getRestaurantId()));
                        gemCheckoutDiscountConfigurations.getWith().subTotal(Double.valueOf(sampleGemBasketActivity2.calculatedSubTotal));
                    }
                });
                ((GemCheckoutFooterView) appCompatActivity.findViewById(R.id.gemBasketFooterView)).invoke(new Function1<GemCheckoutFooterConfigurations, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GemCheckoutFooterConfigurations) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull GemCheckoutFooterConfigurations gemCheckoutFooterConfigurations) {
                        Intrinsics.checkNotNullParameter(gemCheckoutFooterConfigurations, "$this$invoke");
                        gemCheckoutFooterConfigurations.getWith().restaurantId(Integer.valueOf(navigationData.getRestaurantId()));
                    }
                });
            }
        });
    }
}
