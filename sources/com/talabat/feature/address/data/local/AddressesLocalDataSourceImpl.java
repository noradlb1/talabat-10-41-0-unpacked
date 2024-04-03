package com.talabat.feature.address.data.local;

import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.Collection;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\f\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/talabat/feature/address/data/local/AddressesLocalDataSourceImpl;", "Lcom/talabat/feature/address/data/local/AddressesLocalDataSource;", "prefs", "Lcom/talabat/feature/address/data/local/AddressSharedPreferences;", "gson", "Lcom/google/gson/Gson;", "(Lcom/talabat/feature/address/data/local/AddressSharedPreferences;Lcom/google/gson/Gson;)V", "cacheCustomerAddresses", "", "customerAddressLocalDataModel", "Lcom/talabat/feature/address/data/local/CustomerAddressLocalDataModel;", "getCustomerAddresses", "invalidateCustomerAddresses", "Companion", "com_talabat_feature_address_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddressesLocalDataSourceImpl implements AddressesLocalDataSource {
    @NotNull
    @Deprecated
    private static final String ADDRESS_PREFERENCE_KEY = "addressPreferenceKey";
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final Gson gson;
    @NotNull
    private final AddressSharedPreferences prefs;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/feature/address/data/local/AddressesLocalDataSourceImpl$Companion;", "", "()V", "ADDRESS_PREFERENCE_KEY", "", "com_talabat_feature_address_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public AddressesLocalDataSourceImpl(@NotNull AddressSharedPreferences addressSharedPreferences, @NotNull Gson gson2) {
        Intrinsics.checkNotNullParameter(addressSharedPreferences, "prefs");
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.prefs = addressSharedPreferences;
        this.gson = gson2;
    }

    public void cacheCustomerAddresses(@NotNull CustomerAddressLocalDataModel customerAddressLocalDataModel) {
        String str;
        Intrinsics.checkNotNullParameter(customerAddressLocalDataModel, "customerAddressLocalDataModel");
        SharedPreferences.Editor edit = this.prefs.getSharedPreferences$com_talabat_feature_address_data_data().edit();
        Gson gson2 = this.gson;
        if (!(gson2 instanceof Gson)) {
            str = gson2.toJson((Object) customerAddressLocalDataModel);
        } else {
            str = GsonInstrumentation.toJson(gson2, (Object) customerAddressLocalDataModel);
        }
        edit.putString(ADDRESS_PREFERENCE_KEY, str);
        edit.apply();
    }

    @Nullable
    public CustomerAddressLocalDataModel getCustomerAddresses() {
        boolean z11;
        Object obj;
        String string = this.prefs.getSharedPreferences$com_talabat_feature_address_data_data().getString(ADDRESS_PREFERENCE_KEY, (String) null);
        boolean z12 = false;
        if (string == null || string.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return null;
        }
        Gson gson2 = this.gson;
        Class cls = CustomerAddressLocalDataModel.class;
        if (!(gson2 instanceof Gson)) {
            obj = gson2.fromJson(string, cls);
        } else {
            obj = GsonInstrumentation.fromJson(gson2, string, cls);
        }
        CustomerAddressLocalDataModel customerAddressLocalDataModel = (CustomerAddressLocalDataModel) obj;
        Collection result = customerAddressLocalDataModel.getResult();
        if (result == null || result.isEmpty()) {
            z12 = true;
        }
        if (!z12) {
            return customerAddressLocalDataModel;
        }
        return null;
    }

    public void invalidateCustomerAddresses() {
        SharedPreferences.Editor edit = this.prefs.getSharedPreferences$com_talabat_feature_address_data_data().edit();
        edit.remove(ADDRESS_PREFERENCE_KEY);
        edit.apply();
    }
}
