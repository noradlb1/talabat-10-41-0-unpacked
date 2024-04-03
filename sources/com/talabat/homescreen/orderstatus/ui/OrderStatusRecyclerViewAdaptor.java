package com.talabat.homescreen.orderstatus.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import com.talabat.homescreen.R;
import com.talabat.homescreen.orderstatus.presentation.displaymodel.OrderStatus;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.adapter.HeadlinesAdapterKt;
import is.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0015\u0016B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/talabat/homescreen/orderstatus/ui/OrderStatusRecyclerViewAdaptor;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/homescreen/orderstatus/ui/OrderStatusRecyclerViewAdaptor$ViewHolder;", "orderStatuses", "", "Lcom/talabat/homescreen/orderstatus/presentation/displaymodel/OrderStatus;", "onClick", "Lkotlin/Function1;", "", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "ViewHolder", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderStatusRecyclerViewAdaptor extends RecyclerView.Adapter<ViewHolder> {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final int VIEW_TYPE_MULTIPLE = 1;
    @Deprecated
    public static final int VIEW_TYPE_SINGLE = 0;
    @NotNull
    private final Function1<String, Unit> onClick;
    @NotNull
    private final List<OrderStatus> orderStatuses;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/homescreen/orderstatus/ui/OrderStatusRecyclerViewAdaptor$Companion;", "", "()V", "VIEW_TYPE_MULTIPLE", "", "VIEW_TYPE_SINGLE", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/talabat/homescreen/orderstatus/ui/OrderStatusRecyclerViewAdaptor$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "itemContainer", "Lcom/google/android/material/card/MaterialCardView;", "getItemContainer", "()Lcom/google/android/material/card/MaterialCardView;", "restaurantNameTextView", "Landroid/widget/TextView;", "getRestaurantNameTextView", "()Landroid/widget/TextView;", "statusTextView", "getStatusTextView", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private final MaterialCardView itemContainer;
        @NotNull
        private final TextView restaurantNameTextView;
        @NotNull
        private final TextView statusTextView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            View findViewById = view.findViewById(R.id.itemContainer);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.itemContainer)");
            this.itemContainer = (MaterialCardView) findViewById;
            View findViewById2 = view.findViewById(R.id.txtStatus);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.txtStatus)");
            this.statusTextView = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.txtRestaurantName);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.txtRestaurantName)");
            this.restaurantNameTextView = (TextView) findViewById3;
        }

        @NotNull
        public final MaterialCardView getItemContainer() {
            return this.itemContainer;
        }

        @NotNull
        public final TextView getRestaurantNameTextView() {
            return this.restaurantNameTextView;
        }

        @NotNull
        public final TextView getStatusTextView() {
            return this.statusTextView;
        }
    }

    public OrderStatusRecyclerViewAdaptor(@NotNull List<? extends OrderStatus> list, @NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "orderStatuses");
        Intrinsics.checkNotNullParameter(function1, "onClick");
        this.orderStatuses = list;
        this.onClick = function1;
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-1$lambda-0  reason: not valid java name */
    public static final void m10652onBindViewHolder$lambda1$lambda0(OrderStatusRecyclerViewAdaptor orderStatusRecyclerViewAdaptor, OrderStatus orderStatus, View view) {
        Intrinsics.checkNotNullParameter(orderStatusRecyclerViewAdaptor, "this$0");
        Intrinsics.checkNotNullParameter(orderStatus, "$orderStatus");
        orderStatusRecyclerViewAdaptor.onClick.invoke(orderStatus.getOrderId());
    }

    public int getItemCount() {
        return this.orderStatuses.size();
    }

    public int getItemViewType(int i11) {
        OrderStatus orderStatus = this.orderStatuses.get(i11);
        if (orderStatus instanceof OrderStatus.Multiple) {
            return 1;
        }
        if (orderStatus instanceof OrderStatus.Single) {
            return 0;
        }
        throw new NoWhenBranchMatchedException();
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        OrderStatus orderStatus = this.orderStatuses.get(i11);
        viewHolder.getStatusTextView().setText(orderStatus.getStatus());
        viewHolder.getRestaurantNameTextView().setText(orderStatus.getRestaurantName());
        if (orderStatus.getWithAlertBackground()) {
            viewHolder.getItemContainer().setCardBackgroundColor(HeadlinesAdapterKt.getColor(com.designsystem.marshmallow.R.color.ds_alert_100));
        }
        viewHolder.itemView.setOnClickListener(new c(this, orderStatus));
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        int i12;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (i11 == 0) {
            i12 = R.layout.list_item_order_status_single;
        } else if (i11 != 1) {
            i12 = R.layout.list_item_order_status_single;
        } else {
            i12 = R.layout.list_item_order_status_multiple;
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i12, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new ViewHolder(inflate);
    }
}
