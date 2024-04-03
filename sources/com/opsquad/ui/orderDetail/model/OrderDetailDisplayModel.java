package com.opsquad.ui.orderDetail.model;

import com.opsquad.ui.orderDetail.rows.RowDisplayModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/opsquad/ui/orderDetail/model/OrderDetailDisplayModel;", "", "()V", "rows", "", "Lcom/opsquad/ui/orderDetail/rows/RowDisplayModel;", "getRows", "()Ljava/util/List;", "setRows", "(Ljava/util/List;)V", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderDetailDisplayModel {
    @NotNull
    private List<RowDisplayModel> rows = new ArrayList();

    @NotNull
    public final List<RowDisplayModel> getRows() {
        return this.rows;
    }

    public final void setRows(@NotNull List<RowDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.rows = list;
    }
}
