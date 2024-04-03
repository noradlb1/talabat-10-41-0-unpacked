package com.deliveryhero.fluid.widgets.collections;

import com.deliveryhero.fluid.template.data.TemplateUiData;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lcom/deliveryhero/fluid/widgets/collections/OnCollectionScrollListener;", "", "onScrollTo", "", "position", "", "cells", "", "Lcom/deliveryhero/fluid/widgets/collections/Cell;", "collectionData", "Lcom/deliveryhero/fluid/template/data/TemplateUiData;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface OnCollectionScrollListener {
    void onScrollTo(int i11, @NotNull List<? extends Cell> list, @NotNull TemplateUiData templateUiData);
}
