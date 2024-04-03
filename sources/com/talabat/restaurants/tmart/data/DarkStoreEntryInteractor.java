package com.talabat.restaurants.tmart.data;

import com.talabat.helpers.AppUrls;
import com.talabat.helpers.GlobalDataModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.CreateApiUrl;
import org.jetbrains.annotations.NotNull;
import service.ApiHandler;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/restaurants/tmart/data/DarkStoreEntryInteractor;", "Lcom/talabat/restaurants/tmart/data/IDarkStoreEntryInteractor;", "()V", "getDarkStoresInfo", "", "darkStoreListener", "Lcom/talabat/restaurants/tmart/data/DarkStoreEntryListener;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkStoreEntryInteractor implements IDarkStoreEntryInteractor {
    public void getDarkStoresInfo(@NotNull DarkStoreEntryListener darkStoreEntryListener) {
        Intrinsics.checkNotNullParameter(darkStoreEntryListener, "darkStoreListener");
        int i11 = GlobalDataModel.SelectedAreaId;
        String latitude = GlobalDataModel.LATLONGFORAPI.getLatitude();
        String longitude = GlobalDataModel.LATLONGFORAPI.getLongitude();
        ApiHandler.Services services = ApiHandler.getInstance().getServices();
        String str = AppUrls.DARKSTORES_URL;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11);
        services.getDarkStoresInfo(CreateApiUrl.createWithParameters(str, new String[]{"{areaId}", sb2.toString(), "{latitude}", latitude, "{longitude}", longitude})).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new DarkStoreEntryInteractor$getDarkStoresInfo$1(darkStoreEntryListener));
    }
}
