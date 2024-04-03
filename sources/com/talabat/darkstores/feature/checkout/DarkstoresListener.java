package com.talabat.darkstores.feature.checkout;

import android.app.Activity;
import com.talabat.core.navigation.domain.screen.checkout.ExitPointData;
import datamodels.Restaurant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\"\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/darkstores/feature/checkout/DarkstoresListener;", "", "onBackFromDSAfterDeepLink", "", "activity", "Landroid/app/Activity;", "onBackPressed", "onCheckout", "exitPointData", "Lcom/talabat/core/navigation/domain/screen/checkout/ExitPointData;", "restaurant", "Ldatamodels/Restaurant;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DarkstoresListener {
    void onBackFromDSAfterDeepLink(@NotNull Activity activity);

    void onBackPressed(@NotNull Activity activity);

    void onCheckout(@NotNull Activity activity, @Nullable ExitPointData exitPointData, @NotNull Restaurant restaurant);
}
