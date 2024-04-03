package com.talabat.core.flutter.channels.domain.vendormenuinfo;

import android.app.Activity;
import android.content.Intent;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/core/flutter/channels/domain/vendormenuinfo/VendorMenuInfoChannelCallback;", "", "getVendorMenuInfo", "", "", "intent", "Landroid/content/Intent;", "showVendorBusyPopup", "", "arguments", "activity", "Landroid/app/Activity;", "com_talabat_core_flutter-channels_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorMenuInfoChannelCallback {
    @NotNull
    Map<String, Object> getVendorMenuInfo(@Nullable Intent intent);

    void showVendorBusyPopup(@Nullable Object obj, @Nullable Activity activity);
}
