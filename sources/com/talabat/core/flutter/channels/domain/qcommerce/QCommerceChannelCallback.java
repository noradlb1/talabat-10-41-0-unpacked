package com.talabat.core.flutter.channels.domain.qcommerce;

import android.app.Activity;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JB\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\bH&¨\u0006\u000b"}, d2 = {"Lcom/talabat/core/flutter/channels/domain/qcommerce/QCommerceChannelCallback;", "", "navigateToCheckout", "", "activity", "Landroid/app/Activity;", "vendorMap", "", "", "cartMap", "specialRequest", "com_talabat_core_flutter-channels_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface QCommerceChannelCallback {
    void navigateToCheckout(@NotNull Activity activity, @NotNull Map<String, ? extends Object> map, @NotNull Map<String, ? extends Object> map2, @Nullable String str);
}
