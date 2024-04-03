package com.talabat.core.flutter.channels.domain.cart;

import android.content.Context;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001a\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tH&J\b\u0010\u000b\u001a\u00020\u0003H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&J\u001a\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001a\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&J\u0012\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&¨\u0006\u0013"}, d2 = {"Lcom/talabat/core/flutter/channels/domain/cart/CartChannelCallback;", "", "addToCart", "", "arguments", "context", "Landroid/content/Context;", "applyVoucher", "getCartInformation", "", "", "removeAppliedVoucher", "resetCart", "updateCutlery", "updateDeliveryTimeValue", "updateItemFromCart", "updateQuantity", "updateSelectedMenuDiscount", "updateSpecialRequest", "com_talabat_core_flutter-channels_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CartChannelCallback {
    void addToCart(@Nullable Object obj, @NotNull Context context);

    void applyVoucher(@Nullable Object obj, @NotNull Context context);

    @NotNull
    Map<String, Object> getCartInformation();

    void removeAppliedVoucher();

    void resetCart(@NotNull Context context);

    void updateCutlery(@Nullable Object obj);

    void updateDeliveryTimeValue(@Nullable Object obj);

    void updateItemFromCart(@Nullable Object obj, @NotNull Context context);

    void updateQuantity(@Nullable Object obj, @NotNull Context context);

    void updateSelectedMenuDiscount(@Nullable Object obj);

    void updateSpecialRequest(@Nullable Object obj);
}
