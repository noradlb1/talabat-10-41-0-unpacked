package com.talabat.homescreen.orderstatus.presentation.provider.impl;

import android.content.res.Resources;
import com.talabat.homescreen.orderstatus.presentation.provider.StringProvider;
import com.talabat.localization.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/homescreen/orderstatus/presentation/provider/impl/StringProviderImpl;", "Lcom/talabat/homescreen/orderstatus/presentation/provider/StringProvider;", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "getChainName", "", "chainName", "orderType", "", "getOrderStatusDescription", "orderStatus", "isOrderSuccess", "", "getReplacement", "toText", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class StringProviderImpl implements StringProvider {
    @NotNull
    private final Resources resources;

    public StringProviderImpl(@NotNull Resources resources2) {
        Intrinsics.checkNotNullParameter(resources2, "resources");
        this.resources = resources2;
    }

    private final String toText(int i11, boolean z11) {
        String str;
        if (i11 == 1) {
            str = this.resources.getString(R.string.ordered_status);
        } else if (i11 == 2) {
            str = this.resources.getString(R.string.preparing_status);
        } else if (i11 == 3) {
            str = this.resources.getString(R.string.delivering_status);
        } else if (i11 == 4) {
            str = this.resources.getString(R.string.delivered_status);
        } else if (i11 == 6) {
            str = this.resources.getString(R.string.replacement);
        } else if (z11) {
            str = this.resources.getString(R.string.successful_status);
        } else {
            str = this.resources.getString(R.string.cancelled_status);
        }
        Intrinsics.checkNotNullExpressionValue(str, "when (orderStatus) {\n   …s\n            )\n        }");
        return str;
    }

    @NotNull
    public String getChainName(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "chainName");
        if (i11 == 1) {
            return str;
        }
        String string = this.resources.getString(R.string.home_order_status_chain_name, new Object[]{str});
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…us_chain_name, chainName)");
        return string;
    }

    @NotNull
    public String getOrderStatusDescription(int i11, boolean z11, int i12) {
        if (i12 == 1) {
            String string = this.resources.getString(R.string.home_order_pickup_status_description);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…ickup_status_description)");
            return string;
        } else if (i11 == 6) {
            return toText(i11, z11);
        } else {
            String string2 = this.resources.getString(R.string.home_order_status_decription, new Object[]{toText(i11, z11)});
            Intrinsics.checkNotNullExpressionValue(string2, "{\n                resour…          )\n            }");
            return string2;
        }
    }

    @NotNull
    public String getReplacement(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "chainName");
        String string = this.resources.getString(R.string.home_order_status_replacement, new Object[]{str});
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…s_replacement, chainName)");
        return string;
    }
}
