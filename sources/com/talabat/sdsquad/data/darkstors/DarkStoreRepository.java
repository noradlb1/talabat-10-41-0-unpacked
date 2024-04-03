package com.talabat.sdsquad.data.darkstors;

import com.talabat.sdsquad.data.darkstors.responses.DarkStoreResponse;
import com.talabat.sdsquad.data.vendorslist.response.Vendor;
import io.reactivex.Flowable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\n\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u000e"}, d2 = {"Lcom/talabat/sdsquad/data/darkstors/DarkStoreRepository;", "", "getDarkStore", "Lio/reactivex/Flowable;", "Lcom/talabat/sdsquad/data/darkstors/responses/DarkStoreResponse;", "isForceUpdate", "", "areaId", "", "latitude", "", "longitude", "getDarkStoreObject", "Lcom/talabat/sdsquad/data/vendorslist/response/Vendor;", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DarkStoreRepository {
    @NotNull
    Flowable<DarkStoreResponse> getDarkStore(boolean z11, int i11, @NotNull String str, @NotNull String str2);

    @Nullable
    Vendor getDarkStoreObject();
}
