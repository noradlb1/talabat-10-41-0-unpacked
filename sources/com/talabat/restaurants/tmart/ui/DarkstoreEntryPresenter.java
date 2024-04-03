package com.talabat.restaurants.tmart.ui;

import com.talabat.restaurants.tmart.data.DarkStoreEntryInteractor;
import com.talabat.restaurants.tmart.data.IDarkStoreEntryInteractor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0001\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\f"}, d2 = {"Lcom/talabat/restaurants/tmart/ui/DarkstoreEntryPresenter;", "Lcom/talabat/restaurants/tmart/ui/IDarkstoreEntryPresenter;", "darkStoreView", "Lcom/talabat/restaurants/tmart/ui/IDarkStoreEntryView;", "darkStoreInteractor", "Lcom/talabat/restaurants/tmart/data/IDarkStoreEntryInteractor;", "(Lcom/talabat/restaurants/tmart/ui/IDarkStoreEntryView;Lcom/talabat/restaurants/tmart/data/IDarkStoreEntryInteractor;)V", "listener", "com/talabat/restaurants/tmart/ui/DarkstoreEntryPresenter$listener$1", "Lcom/talabat/restaurants/tmart/ui/DarkstoreEntryPresenter$listener$1;", "getDarkStoresInfo", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoreEntryPresenter implements IDarkstoreEntryPresenter {
    @NotNull
    private final IDarkStoreEntryInteractor darkStoreInteractor;
    /* access modifiers changed from: private */
    @NotNull
    public final IDarkStoreEntryView darkStoreView;
    @NotNull
    private final DarkstoreEntryPresenter$listener$1 listener;

    public DarkstoreEntryPresenter(@NotNull IDarkStoreEntryView iDarkStoreEntryView, @NotNull IDarkStoreEntryInteractor iDarkStoreEntryInteractor) {
        Intrinsics.checkNotNullParameter(iDarkStoreEntryView, "darkStoreView");
        Intrinsics.checkNotNullParameter(iDarkStoreEntryInteractor, "darkStoreInteractor");
        this.darkStoreView = iDarkStoreEntryView;
        this.darkStoreInteractor = iDarkStoreEntryInteractor;
        this.listener = new DarkstoreEntryPresenter$listener$1(this);
    }

    public void getDarkStoresInfo() {
        this.darkStoreView.showDailyTalabatLoading();
        this.darkStoreInteractor.getDarkStoresInfo(this.listener);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DarkstoreEntryPresenter(IDarkStoreEntryView iDarkStoreEntryView, IDarkStoreEntryInteractor iDarkStoreEntryInteractor, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(iDarkStoreEntryView, (i11 & 2) != 0 ? new DarkStoreEntryInteractor() : iDarkStoreEntryInteractor);
    }
}
