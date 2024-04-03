package com.talabat.collectiondetails.ui.quickfilter;

import datamodels.Restaurant;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lcom/talabat/collectiondetails/ui/quickfilter/QuickFilterRestaurantsListener;", "", "onDarkStoresEntryFailure", "", "onDarkStoresEntrySuccess", "result", "Ldatamodels/Restaurant;", "onResponseError", "onResponseSuccess", "terms", "", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface QuickFilterRestaurantsListener {
    void onDarkStoresEntryFailure();

    void onDarkStoresEntrySuccess(@Nullable Restaurant restaurant);

    void onResponseError();

    void onResponseSuccess(@Nullable String str);
}
