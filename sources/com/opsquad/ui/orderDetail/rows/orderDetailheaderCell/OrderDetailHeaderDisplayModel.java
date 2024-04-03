package com.opsquad.ui.orderDetail.rows.orderDetailheaderCell;

import com.opsquad.ui.orderDetail.rows.RowDisplayModel;
import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/opsquad/ui/orderDetail/rows/orderDetailheaderCell/OrderDetailHeaderDisplayModel;", "Lcom/opsquad/ui/orderDetail/rows/RowDisplayModel;", "headerTitle", "", "(Ljava/lang/String;)V", "getHeaderTitle", "()Ljava/lang/String;", "setHeaderTitle", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderDetailHeaderDisplayModel extends RowDisplayModel {
    @NotNull
    private String headerTitle;

    public OrderDetailHeaderDisplayModel() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public OrderDetailHeaderDisplayModel(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "headerTitle");
        this.headerTitle = str;
    }

    @NotNull
    public final String getHeaderTitle() {
        return this.headerTitle;
    }

    public final void setHeaderTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.headerTitle = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OrderDetailHeaderDisplayModel(String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str);
    }
}
