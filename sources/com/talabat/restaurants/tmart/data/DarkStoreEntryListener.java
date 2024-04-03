package com.talabat.restaurants.tmart.data;

import datamodels.Restaurant;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/restaurants/tmart/data/DarkStoreEntryListener;", "", "onDarkStoresEntryFailure", "", "onDarkStoresEntrySuccess", "result", "Ldatamodels/Restaurant;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DarkStoreEntryListener {
    void onDarkStoresEntryFailure();

    void onDarkStoresEntrySuccess(@Nullable Restaurant restaurant);
}
