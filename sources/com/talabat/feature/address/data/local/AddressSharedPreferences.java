package com.talabat.feature.address.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import com.talabat.core.context.domain.ApplicationContext;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/talabat/feature/address/data/local/AddressSharedPreferences;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences$com_talabat_feature_address_data_data", "()Landroid/content/SharedPreferences;", "com_talabat_feature_address_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddressSharedPreferences {
    @NotNull
    private final Context context;
    @NotNull
    private final SharedPreferences sharedPreferences;

    @Inject
    public AddressSharedPreferences(@NotNull @ApplicationContext Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        SharedPreferences sharedPreferences2 = context2.getSharedPreferences("talabat", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "context.getSharedPrefere…xt.MODE_PRIVATE\n        )");
        this.sharedPreferences = sharedPreferences2;
    }

    @NotNull
    public final SharedPreferences getSharedPreferences$com_talabat_feature_address_data_data() {
        return this.sharedPreferences;
    }
}
