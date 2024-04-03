package com.talabat.feature.darkstorescarrierbag.data.datasource;

import android.content.SharedPreferences;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/feature/darkstorescarrierbag/data/datasource/DarkstoresCarrierBagLocalDataSource;", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "isDarkstoresCarrierBagFakeDoorTestShown", "", "setDarkstoresCarrierBagFakeDoorTestShown", "", "shown", "com_talabat_feature_darkstores-carrier-bag_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresCarrierBagLocalDataSource {
    @NotNull
    private final SharedPreferences sharedPreferences;

    @Inject
    public DarkstoresCarrierBagLocalDataSource(@NotNull SharedPreferences sharedPreferences2) {
        Intrinsics.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        this.sharedPreferences = sharedPreferences2;
    }

    public final boolean isDarkstoresCarrierBagFakeDoorTestShown() {
        return this.sharedPreferences.getBoolean("darkstores_carrier_bag_shown", false);
    }

    public final void setDarkstoresCarrierBagFakeDoorTestShown(boolean z11) {
        this.sharedPreferences.edit().putBoolean("darkstores_carrier_bag_shown", z11).apply();
    }
}
