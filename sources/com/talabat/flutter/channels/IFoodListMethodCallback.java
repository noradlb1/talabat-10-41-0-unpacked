package com.talabat.flutter.channels;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&¨\u0006\f"}, d2 = {"Lcom/talabat/flutter/channels/IFoodListMethodCallback;", "", "navigateToCollection", "", "deeplink", "", "navigateToMenu", "branchId", "", "navigateToPickup", "navigateToSearch", "onBackPressed", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IFoodListMethodCallback {
    void navigateToCollection(@NotNull String str);

    void navigateToMenu(int i11);

    void navigateToPickup();

    void navigateToSearch();

    void onBackPressed();
}
