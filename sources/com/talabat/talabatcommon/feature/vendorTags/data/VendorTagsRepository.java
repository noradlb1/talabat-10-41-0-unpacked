package com.talabat.talabatcommon.feature.vendorTags.data;

import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import library.talabat.com.talabatlib.VendorTagsResponse;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\nH&¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/feature/vendorTags/data/VendorTagsRepository;", "", "getVendorTags", "Lio/reactivex/Single;", "Llibrary/talabat/com/talabatlib/VendorTagsResponse;", "latitude", "", "longitude", "verticalIds", "", "", "countryId", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorTagsRepository {
    @NotNull
    Single<VendorTagsResponse> getVendorTags(@NotNull String str, @NotNull String str2, @NotNull List<Integer> list, int i11);
}
