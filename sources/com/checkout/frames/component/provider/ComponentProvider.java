package com.checkout.frames.component.provider;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import com.checkout.frames.style.component.CardNumberComponentStyle;
import com.checkout.frames.style.component.CardSchemeComponentStyle;
import com.checkout.frames.style.component.CvvComponentStyle;
import com.checkout.frames.style.component.ExpiryDateComponentStyle;
import com.checkout.frames.style.component.PayButtonComponentStyle;
import com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H'¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\nH'¢\u0006\u0002\u0010\u000bJ\u0015\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\rH'¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0010H'¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0013H'¢\u0006\u0002\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0016H'¢\u0006\u0002\u0010\u0017¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lcom/checkout/frames/component/provider/ComponentProvider;", "", "AddressSummary", "", "style", "Lcom/checkout/frames/style/component/addresssummary/AddressSummaryComponentStyle;", "goToBillingAddressForm", "Lkotlin/Function0;", "(Lcom/checkout/frames/style/component/addresssummary/AddressSummaryComponentStyle;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "CardNumber", "Lcom/checkout/frames/style/component/CardNumberComponentStyle;", "(Lcom/checkout/frames/style/component/CardNumberComponentStyle;Landroidx/compose/runtime/Composer;I)V", "CardScheme", "Lcom/checkout/frames/style/component/CardSchemeComponentStyle;", "(Lcom/checkout/frames/style/component/CardSchemeComponentStyle;Landroidx/compose/runtime/Composer;I)V", "Cvv", "Lcom/checkout/frames/style/component/CvvComponentStyle;", "(Lcom/checkout/frames/style/component/CvvComponentStyle;Landroidx/compose/runtime/Composer;I)V", "ExpiryDate", "Lcom/checkout/frames/style/component/ExpiryDateComponentStyle;", "(Lcom/checkout/frames/style/component/ExpiryDateComponentStyle;Landroidx/compose/runtime/Composer;I)V", "PayButton", "Lcom/checkout/frames/style/component/PayButtonComponentStyle;", "(Lcom/checkout/frames/style/component/PayButtonComponentStyle;Landroidx/compose/runtime/Composer;I)V", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface ComponentProvider {
    @Composable
    void AddressSummary(@NotNull AddressSummaryComponentStyle addressSummaryComponentStyle, @NotNull Function0<Unit> function0, @Nullable Composer composer, int i11);

    @Composable
    void CardNumber(@NotNull CardNumberComponentStyle cardNumberComponentStyle, @Nullable Composer composer, int i11);

    @Composable
    void CardScheme(@NotNull CardSchemeComponentStyle cardSchemeComponentStyle, @Nullable Composer composer, int i11);

    @Composable
    void Cvv(@NotNull CvvComponentStyle cvvComponentStyle, @Nullable Composer composer, int i11);

    @Composable
    void ExpiryDate(@NotNull ExpiryDateComponentStyle expiryDateComponentStyle, @Nullable Composer composer, int i11);

    @Composable
    void PayButton(@NotNull PayButtonComponentStyle payButtonComponentStyle, @Nullable Composer composer, int i11);
}
