package com.talabat.restaurants.inlineads;

import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import library.talabat.inlineadsengine.AdsWrapper;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/talabat/restaurants/inlineads/IAdLoader;", "", "loadAds", "Lio/reactivex/Single;", "", "Llibrary/talabat/inlineadsengine/AdsWrapper;", "verticalId", "", "countryId", "areaId", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IAdLoader {
    @NotNull
    Single<List<AdsWrapper>> loadAds(int i11, int i12, @NotNull String str);
}
