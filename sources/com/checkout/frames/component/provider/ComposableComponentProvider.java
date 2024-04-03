package com.checkout.frames.component.provider;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import com.checkout.frames.component.addresssummary.AddressSummaryComponentKt;
import com.checkout.frames.component.cardnumber.CardNumberComponentKt;
import com.checkout.frames.component.cardscheme.CardSchemeComponentKt;
import com.checkout.frames.component.cvv.CvvComponentKt;
import com.checkout.frames.component.expirydate.ExpiryDateComponentKt;
import com.checkout.frames.component.paybutton.PayButtonComponentKt;
import com.checkout.frames.di.base.Injector;
import com.checkout.frames.style.component.CardNumberComponentStyle;
import com.checkout.frames.style.component.CardSchemeComponentStyle;
import com.checkout.frames.style.component.CvvComponentStyle;
import com.checkout.frames.style.component.ExpiryDateComponentStyle;
import com.checkout.frames.style.component.PayButtonComponentStyle;
import com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH\u0017¢\u0006\u0002\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\rH\u0017¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0010H\u0017¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0013H\u0017¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0016H\u0017¢\u0006\u0002\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0019H\u0017¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/checkout/frames/component/provider/ComposableComponentProvider;", "Lcom/checkout/frames/component/provider/ComponentProvider;", "injector", "Lcom/checkout/frames/di/base/Injector;", "(Lcom/checkout/frames/di/base/Injector;)V", "AddressSummary", "", "style", "Lcom/checkout/frames/style/component/addresssummary/AddressSummaryComponentStyle;", "goToBillingAddressForm", "Lkotlin/Function0;", "(Lcom/checkout/frames/style/component/addresssummary/AddressSummaryComponentStyle;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "CardNumber", "Lcom/checkout/frames/style/component/CardNumberComponentStyle;", "(Lcom/checkout/frames/style/component/CardNumberComponentStyle;Landroidx/compose/runtime/Composer;I)V", "CardScheme", "Lcom/checkout/frames/style/component/CardSchemeComponentStyle;", "(Lcom/checkout/frames/style/component/CardSchemeComponentStyle;Landroidx/compose/runtime/Composer;I)V", "Cvv", "Lcom/checkout/frames/style/component/CvvComponentStyle;", "(Lcom/checkout/frames/style/component/CvvComponentStyle;Landroidx/compose/runtime/Composer;I)V", "ExpiryDate", "Lcom/checkout/frames/style/component/ExpiryDateComponentStyle;", "(Lcom/checkout/frames/style/component/ExpiryDateComponentStyle;Landroidx/compose/runtime/Composer;I)V", "PayButton", "Lcom/checkout/frames/style/component/PayButtonComponentStyle;", "(Lcom/checkout/frames/style/component/PayButtonComponentStyle;Landroidx/compose/runtime/Composer;I)V", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ComposableComponentProvider implements ComponentProvider {
    @NotNull
    private final Injector injector;

    public ComposableComponentProvider(@NotNull Injector injector2) {
        Intrinsics.checkNotNullParameter(injector2, "injector");
        this.injector = injector2;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public void AddressSummary(@NotNull AddressSummaryComponentStyle addressSummaryComponentStyle, @NotNull Function0<Unit> function0, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(addressSummaryComponentStyle, "style");
        Intrinsics.checkNotNullParameter(function0, "goToBillingAddressForm");
        Composer startRestartGroup = composer.startRestartGroup(2121278567);
        AddressSummaryComponentKt.AddressSummaryComponent(addressSummaryComponentStyle, this.injector, function0, startRestartGroup, ((i11 << 3) & 896) | 8);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ComposableComponentProvider$AddressSummary$1(this, addressSummaryComponentStyle, function0, i11));
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public void CardNumber(@NotNull CardNumberComponentStyle cardNumberComponentStyle, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(cardNumberComponentStyle, "style");
        Composer startRestartGroup = composer.startRestartGroup(186504443);
        CardNumberComponentKt.CardNumberComponent(cardNumberComponentStyle, this.injector, startRestartGroup, 8);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ComposableComponentProvider$CardNumber$1(this, cardNumberComponentStyle, i11));
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public void CardScheme(@NotNull CardSchemeComponentStyle cardSchemeComponentStyle, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(cardSchemeComponentStyle, "style");
        Composer startRestartGroup = composer.startRestartGroup(-898251909);
        CardSchemeComponentKt.CardSchemeComponent(cardSchemeComponentStyle, this.injector, startRestartGroup, 8);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ComposableComponentProvider$CardScheme$1(this, cardSchemeComponentStyle, i11));
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public void Cvv(@NotNull CvvComponentStyle cvvComponentStyle, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(cvvComponentStyle, "style");
        Composer startRestartGroup = composer.startRestartGroup(-613622063);
        CvvComponentKt.CvvComponent(cvvComponentStyle, this.injector, startRestartGroup, 8);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ComposableComponentProvider$Cvv$1(this, cvvComponentStyle, i11));
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public void ExpiryDate(@NotNull ExpiryDateComponentStyle expiryDateComponentStyle, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(expiryDateComponentStyle, "style");
        Composer startRestartGroup = composer.startRestartGroup(63692795);
        ExpiryDateComponentKt.ExpiryDateComponent(expiryDateComponentStyle, this.injector, startRestartGroup, 8);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ComposableComponentProvider$ExpiryDate$1(this, expiryDateComponentStyle, i11));
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public void PayButton(@NotNull PayButtonComponentStyle payButtonComponentStyle, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(payButtonComponentStyle, "style");
        Composer startRestartGroup = composer.startRestartGroup(-285506817);
        PayButtonComponentKt.PayButtonComponent(payButtonComponentStyle, this.injector, startRestartGroup, 8);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ComposableComponentProvider$PayButton$1(this, payButtonComponentStyle, i11));
        }
    }
}
