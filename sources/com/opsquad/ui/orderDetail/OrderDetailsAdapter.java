package com.opsquad.ui.orderDetail;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.opsquad.ui.orderDetail.model.enums.CellType;
import com.opsquad.ui.orderDetail.rows.BaseRowViewHolder;
import com.opsquad.ui.orderDetail.rows.RowDisplayModel;
import com.opsquad.ui.orderDetail.rows.deliveryAddressCell.DeliveryAddressDisplayModel;
import com.opsquad.ui.orderDetail.rows.deliveryAddressCell.DeliveryAddressViewHolder;
import com.opsquad.ui.orderDetail.rows.orderDetailheaderCell.OrderDetailHeaderDisplayModel;
import com.opsquad.ui.orderDetail.rows.orderDetailheaderCell.OrderDetailsHeaderViewHolder;
import com.opsquad.ui.orderDetail.rows.orderSummaryCell.OrderSummaryDisplayModel;
import com.opsquad.ui.orderDetail.rows.orderSummaryCell.OrderSummaryViewHolder;
import com.opsquad.ui.orderDetail.rows.paymentItemCell.PaymentItemDisplayModel;
import com.opsquad.ui.orderDetail.rows.paymentItemCell.PaymentItemViewHolder;
import com.opsquad.ui.orderDetail.rows.vendorInfoCell.VendorInfoRowDisplayModel;
import com.opsquad.ui.orderDetail.rows.vendorInfoCell.VendorInfoViewHolder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0014\u0010\u0012\u001a\u00020\f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/opsquad/ui/orderDetail/OrderDetailsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "orderDetailsRows", "", "Lcom/opsquad/ui/orderDetail/rows/RowDisplayModel;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateOrderDetailsScreen", "rows", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderDetailsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NotNull
    private List<RowDisplayModel> orderDetailsRows = new ArrayList();

    public int getItemCount() {
        return this.orderDetailsRows.size();
    }

    public int getItemViewType(int i11) {
        RowDisplayModel rowDisplayModel = this.orderDetailsRows.get(i11);
        if (rowDisplayModel instanceof VendorInfoRowDisplayModel) {
            return CellType.VENDORINFO.ordinal();
        }
        if (rowDisplayModel instanceof DeliveryAddressDisplayModel) {
            return CellType.DELIVERYADDRESS.ordinal();
        }
        if (rowDisplayModel instanceof OrderDetailHeaderDisplayModel) {
            return CellType.HEADER.ordinal();
        }
        if (rowDisplayModel instanceof OrderSummaryDisplayModel) {
            return CellType.ORDERSUMMARY.ordinal();
        }
        if (rowDisplayModel instanceof PaymentItemDisplayModel) {
            return CellType.PAYMENTMETHODS.ordinal();
        }
        return CellType.PAYMENTMETHODS.ordinal();
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        BaseRowViewHolder baseRowViewHolder;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        int itemViewType = getItemViewType(i11);
        if (itemViewType == CellType.VENDORINFO.ordinal()) {
            baseRowViewHolder = (VendorInfoViewHolder) viewHolder;
        } else if (itemViewType == CellType.DELIVERYADDRESS.ordinal()) {
            baseRowViewHolder = (DeliveryAddressViewHolder) viewHolder;
        } else if (itemViewType == CellType.HEADER.ordinal()) {
            baseRowViewHolder = (OrderDetailsHeaderViewHolder) viewHolder;
        } else if (itemViewType == CellType.ORDERSUMMARY.ordinal()) {
            baseRowViewHolder = (OrderSummaryViewHolder) viewHolder;
        } else if (itemViewType == CellType.PAYMENTMETHODS.ordinal()) {
            baseRowViewHolder = (PaymentItemViewHolder) viewHolder;
        } else {
            baseRowViewHolder = null;
        }
        if (baseRowViewHolder != null) {
            baseRowViewHolder.bindView(this.orderDetailsRows.get(i11));
        }
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i11 == CellType.VENDORINFO.ordinal()) {
            return new VendorInfoViewHolder(viewGroup);
        }
        if (i11 == CellType.DELIVERYADDRESS.ordinal()) {
            return new DeliveryAddressViewHolder(viewGroup);
        }
        if (i11 == CellType.ORDERSUMMARY.ordinal()) {
            return new OrderSummaryViewHolder(viewGroup);
        }
        if (i11 == CellType.HEADER.ordinal()) {
            return new OrderDetailsHeaderViewHolder(viewGroup);
        }
        if (i11 == CellType.PAYMENTMETHODS.ordinal()) {
            return new PaymentItemViewHolder(viewGroup);
        }
        return new VendorInfoViewHolder(viewGroup);
    }

    public final void updateOrderDetailsScreen(@NotNull List<RowDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "rows");
        this.orderDetailsRows = list;
        notifyDataSetChanged();
    }
}
