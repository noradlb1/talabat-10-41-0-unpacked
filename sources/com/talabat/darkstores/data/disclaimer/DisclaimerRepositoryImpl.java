package com.talabat.darkstores.data.disclaimer;

import android.content.SharedPreferences;
import com.talabat.feature.darkstores.domain.disclaimer.DisclaimerRepository;
import com.talabat.talabatcommon.feature.disclaimerbanner.Constants;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/darkstores/data/disclaimer/DisclaimerRepositoryImpl;", "Lcom/talabat/feature/darkstores/domain/disclaimer/DisclaimerRepository;", "sharedPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "isDisclaimerDismissed", "", "setDisclaimerDismissed", "", "isDismissed", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DisclaimerRepositoryImpl implements DisclaimerRepository {
    @NotNull
    private final SharedPreferences sharedPreferences;

    @Inject
    public DisclaimerRepositoryImpl(@NotNull SharedPreferences sharedPreferences2) {
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
