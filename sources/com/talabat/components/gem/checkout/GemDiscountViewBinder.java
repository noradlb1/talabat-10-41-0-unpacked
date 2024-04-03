package com.talabat.components.gem.checkout;

import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.talabat.gem.adapters.presentation.checkout.GemCheckoutDiscountView;
import com.talabat.gem.integration.Gem;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/components/gem/checkout/GemDiscountViewBinder;", "Lio/reactivex/functions/Consumer;", "Landroidx/appcompat/app/AppCompatActivity;", "gemCheckoutDiscountView", "Lcom/talabat/gem/adapters/presentation/checkout/GemCheckoutDiscountView;", "gemDiscountViewLayout", "Landroid/view/View;", "(Lcom/talabat/gem/adapters/presentation/checkout/GemCheckoutDiscountView;Landroid/view/View;)V", "accept", "", "activity", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemDiscountViewBinder implements Consumer<AppCompatActivity> {
    /* access modifiers changed from: private */
    @NotNull
    public final GemCheckoutDiscountView gemCheckoutDiscountView;
    /* access modifiers changed from: private */
    @NotNull
    public final View gemDiscountViewLayout;

    public GemDiscountViewBinder(@NotNull GemCheckoutDiscountView gemCheckoutDiscountView2, @NotNull View view) {
        Intrinsics.checkNotNullParameter(gemCheckoutDiscountView2, "gemCheckoutDiscountView");
        Intrinsics.checkNotNullParameter(view, "gemDiscountViewLayout");
        this.gemCheckoutDiscountView = gemCheckoutDiscountView2;
        this.gemDiscountViewLayout = view;
    }

    public void accept(@NotNull AppCompatActivity appCompatActivity) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "activity");
        Gem.withGemComponent(new GemDiscountViewBinder$accept$1(this, appCompatActivity));
    }
}
