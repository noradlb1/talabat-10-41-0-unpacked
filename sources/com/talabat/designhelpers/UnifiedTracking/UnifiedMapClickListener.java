package com.talabat.designhelpers.UnifiedTracking;

import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/designhelpers/UnifiedTracking/UnifiedMapClickListener;", "", "getContainerArea", "Lkotlin/Pair;", "", "onMapViewClicked", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface UnifiedMapClickListener {
    @NotNull
    Pair<Integer, Integer> getContainerArea();

    void onMapViewClicked();
}
