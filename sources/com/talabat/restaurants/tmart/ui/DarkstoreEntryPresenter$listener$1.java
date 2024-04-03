package com.talabat.restaurants.tmart.ui;

import com.talabat.restaurants.tmart.data.DarkStoreEntryListener;
import datamodels.Restaurant;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/talabat/restaurants/tmart/ui/DarkstoreEntryPresenter$listener$1", "Lcom/talabat/restaurants/tmart/data/DarkStoreEntryListener;", "onDarkStoresEntryFailure", "", "onDarkStoresEntrySuccess", "result", "Ldatamodels/Restaurant;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoreEntryPresenter$listener$1 implements DarkStoreEntryListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DarkstoreEntryPresenter f61227a;

    public DarkstoreEntryPresenter$listener$1(DarkstoreEntryPresenter darkstoreEntryPresenter) {
        this.f61227a = darkstoreEntryPresenter;
    }

    public void onDarkStoresEntryFailure() {
        this.f61227a.darkStoreView.hideDailyTalabatLoading();
        this.f61227a.darkStoreView.darkstoreFailure();
    }

    public void onDarkStoresEntrySuccess(@Nullable Restaurant restaurant) {
        this.f61227a.darkStoreView.hideDailyTalabatLoading();
        this.f61227a.darkStoreView.darkstoreSuccess(restaurant);
    }
}
