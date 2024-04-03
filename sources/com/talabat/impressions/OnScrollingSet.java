package com.talabat.impressions;

import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J \u0010\u0003\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0006j\b\u0012\u0004\u0012\u00028\u0000`\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/impressions/OnScrollingSet;", "T", "", "onReachLimit", "", "scrollingList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OnScrollingSet<T> {
    void onReachLimit(@NotNull ArrayList<T> arrayList);
}
