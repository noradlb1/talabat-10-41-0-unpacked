package com.deliveryhero.impression.view;

import android.view.ViewGroup;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/deliveryhero/impression/view/ViewVisibleItemDetector;", "T", "Landroid/view/ViewGroup;", "", "getVisibleItems", "", "Lcom/deliveryhero/impression/view/ItemVisibleArea;", "viewGroup", "(Landroid/view/ViewGroup;)Ljava/util/List;", "impression-tracking_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface ViewVisibleItemDetector<T extends ViewGroup> {
    @NotNull
    List<ItemVisibleArea> getVisibleItems(@NotNull T t11);
}
