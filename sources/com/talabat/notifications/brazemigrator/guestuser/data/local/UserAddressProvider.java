package com.talabat.notifications.brazemigrator.guestuser.data.local;

import android.content.SharedPreferences;
import buisnessmodels.Customer;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalDataModel;
import datamodels.QuickOrderInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/notifications/brazemigrator/guestuser/data/local/UserAddressProvider;", "", "preferences", "Landroid/content/SharedPreferences;", "gson", "Lcom/google/gson/Gson;", "customer", "Lbuisnessmodels/Customer;", "(Landroid/content/SharedPreferences;Lcom/google/gson/Gson;Lbuisnessmodels/Customer;)V", "getSavedQuickOrderAddress", "Lcom/talabat/domain/address/Address;", "getUserAddress", "com_talabat_notifications_notifications"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserAddressProvider {
    @NotNull
    private final Customer customer;
    @NotNull
    private final Gson gson;
    @NotNull
    private final SharedPreferences preferences;

    public UserAddressProvider(@NotNull SharedPreferences sharedPreferences, @NotNull Gson gson2, @NotNull Customer customer2) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "preferences");
        Intrinsics.checkNotNullParameter(gson2, "gson");
        Intrinsics.checkNotNullParameter(customer2, "customer");
        this.preferences = sharedPreferences;
        this.gson = gson2;
        this.customer = customer2;
    }

    private final Address getSavedQuickOrderAddress() {
        boolean z11;
        Object obj;
        String string = this.preferences.getString(String.valueOf(GlobalDataModel.SelectedAreaId), "");
        if (string == null || string.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return null;
        }
        Gson gson2 = this.gson;
        Class cls = QuickOrderInfo.class;
        if (!(gson2 instanceof Gson)) {
            obj = gson2.fromJson(string, cls);
        } else {
            obj = GsonInstrumentation.fromJson(gson2, string, cls);
        }
        return ((QuickOrderInfo) obj).address;
    }

    @Nullable
    public final Address getUserAddress() {
        if (this.customer.isLoggedIn()) {
            return this.customer.getSelectedCustomerAddress();
        }
        return getSavedQuickOrderAddress();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UserAddressProvider(android.content.SharedPreferences r1, com.google.gson.Gson r2, buisnessmodels.Customer r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
        /*
            r0 = this;
            r5 = r4 & 2
            if (r5 == 0) goto L_0x0009
            com.google.gson.Gson r2 = new com.google.gson.Gson
            r2.<init>()
        L_0x0009:
            r4 = r4 & 4
            if (r4 == 0) goto L_0x0016
            buisnessmodels.Customer r3 = buisnessmodels.Customer.getInstance()
            java.lang.String r4 = "getInstance()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
        L_0x0016:
            r0.<init>(r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.notifications.brazemigrator.guestuser.data.local.UserAddressProvider.<init>(android.content.SharedPreferences, com.google.gson.Gson, buisnessmodels.Customer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
