package com.talabat.helpers;

import com.adjust.sdk.AdjustAttribution;
import javax.inject.Provider;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0016¨\u0006\u0005"}, d2 = {"Lcom/talabat/helpers/AdjustIdProvider;", "Ljavax/inject/Provider;", "", "()V", "get", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AdjustIdProvider implements Provider<String> {
    @NotNull
    public String get() {
        AdjustAttribution adjustAttribution = GlobalDataModel.adjustAttribution;
        String str = adjustAttribution != null ? adjustAttribution.adid : null;
        return str == null ? "" : str;
    }
}
