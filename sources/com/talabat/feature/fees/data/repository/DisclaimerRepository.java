package com.talabat.feature.fees.data.repository;

import android.content.SharedPreferences;
import com.talabat.feature.fees.domain.repository.IDisclaimerRepository;
import com.talabat.talabatcommon.feature.disclaimerbanner.Constants;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/feature/fees/data/repository/DisclaimerRepository;", "Lcom/talabat/feature/fees/domain/repository/IDisclaimerRepository;", "sharedPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "isDisclaimerDismissed", "", "setDisclaimerDismissed", "", "isDismissed", "com_talabat_feature_pricing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DisclaimerRepository implements IDisclaimerRepository {
    @NotNull
    private final SharedPreferences sharedPreferences;

    @Inject
    public DisclaimerRepository(@NotNull @Named("disclaimer_prefs") SharedPreferences sharedPreferences2) {
        Intrinsics.checkNotNullParameter(sharedPreferences2, "sharedPreferences");
        this.sharedPreferences = sharedPreferences2;
    }

    public boolean isDisclaimerDismissed() {
        return this.sharedPreferences.getBoolean(Constants.KEY_IS_DISCLAIMER_DISMISSED, false);
    }

    public void setDisclaimerDismissed(boolean z11) {
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        Intrinsics.checkNotNullExpressionValue(edit, "editor");
        edit.putBoolean(Constants.KEY_IS_DISCLAIMER_DISMISSED, z11);
        edit.apply();
    }
}
