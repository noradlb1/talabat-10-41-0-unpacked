package com.talabat.sdsquad.ui.filters.mappers;

import com.talabat.sdsquad.core.DisplayModelMapper;
import com.talabat.sdsquad.data.vendorslist.response.Filter;
import com.talabat.sdsquad.ui.filters.displaymodels.FilterDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/sdsquad/ui/filters/mappers/FilterDisplayMapper;", "Lcom/talabat/sdsquad/core/DisplayModelMapper;", "Lcom/talabat/sdsquad/ui/filters/displaymodels/FilterDisplayModel;", "Lcom/talabat/sdsquad/data/vendorslist/response/Filter;", "()V", "mapToView", "type", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FilterDisplayMapper implements DisplayModelMapper<FilterDisplayModel, Filter> {
    @NotNull
    public FilterDisplayModel mapToView(@NotNull Filter filter) {
        Intrinsics.checkNotNullParameter(filter, "type");
        Integer id2 = filter.getId();
        int intValue = id2 != null ? id2.intValue() : 0;
        String nm2 = filter.getNm();
        if (nm2 == null) {
            nm2 = "";
        }
        return new FilterDisplayModel(intValue, nm2, false);
    }
}
