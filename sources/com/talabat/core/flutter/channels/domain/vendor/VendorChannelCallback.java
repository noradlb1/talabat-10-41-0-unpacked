package com.talabat.core.flutter.channels.domain.vendor;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003H&J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H&¨\u0006\b"}, d2 = {"Lcom/talabat/core/flutter/channels/domain/vendor/VendorChannelCallback;", "", "getVendor", "", "", "updateVendor", "", "arguments", "com_talabat_core_flutter-channels_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorChannelCallback {
    @Nullable
    Map<String, Object> getVendor();

    void updateVendor(@Nullable Object obj);
}
