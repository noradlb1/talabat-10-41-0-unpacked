package com.talabat.gem.samples;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.talabat.gem.adapters.R;
import com.talabat.gem.adapters.presentation.GemBasketCallbacks;
import com.talabat.gem.adapters.presentation.GemMenuFooterConfigurations;
import com.talabat.gem.adapters.presentation.menu.GemMenuFooterView;
import com.talabat.talabatcommon.extension.ViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/appcompat/app/AppCompatActivity;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SampleGemMenuActivity$initialize$1 extends Lambda implements Function1<AppCompatActivity, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SampleGemMenuActivity f60520g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SampleGemMenuActivity$initialize$1(SampleGemMenuActivity sampleGemMenuActivity) {
        super(1);
        this.f60520g = sampleGemMenuActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AppCompatActivity) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull final AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "$this$withLayout");
        final SampleGemMenuActivity sampleGemMenuActivity = this.f60520g;
        RouterKt.withNavigationData(appCompatActivity, new Function1<NavigationData, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((NavigationData) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull final NavigationData navigationData) {
                Intrinsics.checkNotNullParameter(navigationData, "$this$withNavigationData");
                sampleGemMenuActivity.calculatedSubTotal = navigationData.getSubTotal();
                TextView textView = (TextView) appCompatActivity.findViewById(R.id.restaurantIdTextView);
                Intrinsics.checkNotNullExpressionValue(textView, "restaurantIdTextView");
                int restaurantId = navigationData.getRestaurantId();
                ViewKt.plusAssign(textView, "Restaurant Id : " + restaurantId);
                AppCompatActivity appCompatActivity = appCompatActivity;
                int i11 = R.id.menuSubTotalEditText;
                EditText editText = (EditText) appCompatActivity.findViewById(i11);
                Intrinsics.checkNotNullExpressionValue(editText, "menuSubTotalEditText");
                ViewKt.plusAssign((TextView) editText, String.valueOf(sampleGemMenuActivity.calculatedSubTotal));
                EditText editText2 = (EditText) appCompatActivity.findViewById(i11);
                Intrinsics.checkNotNullExpressionValue(editText2, "menuSubTotalEditText");
                editText2.addTextChangedListener(new SampleGemMenuActivity$initialize$1$1$invoke$$inlined$addTextChangedListener$default$1(sampleGemMenuActivity, appCompatActivity));
                Button button = (Button) appCompatActivity.findViewById(R.id.openItemButton);
                Intrinsics.checkNotNullExpressionValue(button, "openItemButton");
                final AppCompatActivity appCompatActivity2 = appCompatActivity;
                final SampleGemMenuActivity sampleGemMenuActivity = sampleGemMenuActivity;
                ViewKt.invoke(button, new Function1<View, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((View) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$invoke");
                        RouterKt.navigate(appCompatActivity2, Reflection.getOrCreateKotlinClass(SampleGemItemActivity.class), navigationData.getRestaurantId(), sampleGemMenuActivity.calculatedSubTotal);
                    }
                });
                Button button2 = (Button) appCompatActivity.findViewById(R.id.openBasketButton);
                Intrinsics.checkNotNullExpressionValue(button2, "openBasketButton");
                final AppCompatActivity appCompatActivity3 = appCompatActivity;
                final SampleGemMenuActivity sampleGemMenuActivity2 = sampleGemMenuActivity;
                ViewKt.invoke(button2, new Function1<View, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((View) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull View view) {
                        Intrinsics.checkNotNullParameter(view, "$this$invoke");
                        RouterKt.navigate(appCompatActivity3, Reflection.getOrCreateKotlinClass(SampleGemBasketActivity.class), navigationData.getRestaurantId(), sampleGemMenuActivity2.calculatedSubTotal);
                    }
                });
                final AppCompatActivity appCompatActivity4 = appCompatActivity;
                final SampleGemMenuActivity sampleGemMenuActivity3 = sampleGemMenuActivity;
                ((GemMenuFooterView) appCompatActivity.findViewById(R.id.gemMenuFooterView)).invoke(new Function1<GemMenuFooterConfigurations, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GemMenuFooterConfigurations) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull GemMenuFooterConfigurations gemMenuFooterConfigurations) {
                        Intrinsics.checkNotNullParameter(gemMenuFooterConfigurations, "$this$invoke");
                        gemMenuFooterConfigurations.getWith().restaurantId(Integer.valueOf(navigationData.getRestaurantId()));
                        GemBasketCallbacks on2 = gemMenuFooterConfigurations.getOn();
                        final AppCompatActivity appCompatActivity = appCompatActivity4;
                        final NavigationData navigationData = navigationData;
                        final SampleGemMenuActivity sampleGemMenuActivity = sampleGemMenuActivity3;
                        on2.viewBasket(new Function0<Unit>() {
                            public final void invoke() {
                                RouterKt.navigate(appCompatActivity, Reflection.getOrCreateKotlinClass(SampleGemBasketActivity.class), navigationData.getRestaurantId(), sampleGemMenuActivity.calculatedSubTotal);
                            }
                        });
                    }
                });
            }
        });
    }
}
