package com.talabat.core.tracking.data.common;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0001H\u0000¨\u0006\u0002"}, d2 = {"value", "", "com_talabat_core_tracking_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class HelperKt {
    @NotNull
    public static final String value(@Nullable String str) {
        return str == null || str.length() == 0 ? "N/A" : str;
    }
}
