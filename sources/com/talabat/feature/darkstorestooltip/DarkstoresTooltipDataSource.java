package com.talabat.feature.darkstorestooltip;

import android.content.SharedPreferences;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/feature/darkstorestooltip/DarkstoresTooltipDataSource;", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "getPreferenceKey", "", "key", "setTooltipShown", "", "isShown", "", "wasTooltipAlreadyShown", "com_talabat_feature_darkstores-tooltip_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresTooltipDataSource {
    @NotNull
    private final SharedPreferences sharedPreferences;

    @Inject
    public DarkstoresTooltipDataSource(@NotNull SharedPreferences sharedPreferences2) {
        Intrinsics.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        this.sharedPreferences = sharedPreferences2;
    }

    private final String getPreferenceKey(String str) {
        return "darkstores_tooltip_" + str;
    }

    public final void setTooltipShown(@NotNull String str, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.sharedPreferences.edit().putBoolean(getPreferenceKey(str), z11).apply();
    }

    public final boolean wasTooltipAlreadyShown(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.sharedPreferences.getBoolean(getPreferenceKey(str), false);
    }
}
