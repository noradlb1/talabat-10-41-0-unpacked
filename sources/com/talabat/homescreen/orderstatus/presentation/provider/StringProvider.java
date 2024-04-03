package com.talabat.homescreen.orderstatus.presentation.provider;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&¨\u0006\f"}, d2 = {"Lcom/talabat/homescreen/orderstatus/presentation/provider/StringProvider;", "", "getChainName", "", "chainName", "orderType", "", "getOrderStatusDescription", "orderStatus", "isOrderSuccess", "", "getReplacement", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface StringProvider {
    @NotNull
    String getChainName(@NotNull String str, int i11);

    @NotNull
    String getOrderStatusDescription(int i11, boolean z11, int i12);

    @NotNull
    String getReplacement(@NotNull String str);
}
