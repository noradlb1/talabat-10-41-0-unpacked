package com.talabat.adapters.previousorders;

import JsonModels.Response.PreviousOrderList.PreviousOrder;
import af.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.TalabatFormatter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.R;
import com.talabat.homescreen.widget.AspectRatioCardView;
import com.talabat.homescreen.widget.HomeActionLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\n\u001a\u00020\u000b2\n\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/talabat/adapters/previousorders/PreviousOrderAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "LJsonModels/Response/PreviousOrderList/PreviousOrder;", "Lcom/talabat/adapters/previousorders/PreviousOrderAdapter$PreviousOrderViewHolder;", "listener", "Lcom/talabat/adapters/previousorders/PreviousOrderListener;", "(Lcom/talabat/adapters/previousorders/PreviousOrderListener;)V", "getListener", "()Lcom/talabat/adapters/previousorders/PreviousOrderListener;", "setListener", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "PreviousOrderViewHolder", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PreviousOrderAdapter extends ListAdapter<PreviousOrder, PreviousOrderViewHolder> {
    @NotNull
    private PreviousOrderListener listener;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u000b"}, d2 = {"Lcom/talabat/adapters/previousorders/PreviousOrderAdapter$PreviousOrderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/talabat/adapters/previousorders/PreviousOrderAdapter;Landroid/view/View;)V", "bind", "", "previousOrder", "LJsonModels/Response/PreviousOrderList/PreviousOrder;", "setUIActions", "setUpViews", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class PreviousOrderViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ PreviousOrderAdapter f55294h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PreviousOrderViewHolder(@NotNull PreviousOrderAdapter previousOrderAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.f55294h = previousOrderAdapter;
        }

        private final void setUIActions(PreviousOrder previousOrder) {
            ((HomeActionLayout) this.itemView.findViewById(R.id.previous_reorder)).setOnClickListener(new a(this.f55294h, previousOrder));
        }

        /* access modifiers changed from: private */
        /* renamed from: setUIActions$lambda-2$lambda-1  reason: not valid java name */
        public static final void m9505setUIActions$lambda2$lambda1(PreviousOrderAdapter previousOrderAdapter, PreviousOrder previousOrder, View view) {
            Intrinsics.checkNotNullParameter(previousOrderAdapter, "this$0");
            Intrinsics.checkNotNullParameter(previousOrder, "$previousOrder");
            previousOrderAdapter.getListener().onReorderClicked(previousOrder);
        }

        private final void setUpViews(PreviousOrder previousOrder) {
            AspectRatioCardView aspectRatioCardView = (AspectRatioCardView) this.itemView;
            if (this.f55294h.getCurrentList().size() == 1) {
                aspectRatioCardView.setWidthPercent(100.0f);
            }
            ((TextView) aspectRatioCardView.findViewById(R.id.previous_first_item)).setText(aspectRatioCardView.getContext().getString(R.string.order_item_placeholder, new Object[]{Integer.valueOf(previousOrder.getFirstItemQuantity()), previousOrder.getFirstItemName()}));
            ((TextView) aspectRatioCardView.findViewById(R.id.previous_price)).setText(TalabatFormatter.getInstance().getFormattedCurrency((float) previousOrder.getTotal(), true));
            if (previousOrder.getMoreItemsCount() > 0) {
                int i11 = R.id.previous_more_item;
                ((TextView) aspectRatioCardView.findViewById(i11)).setText(aspectRatioCardView.getContext().getResources().getQuantityString(R.plurals.more_item_or_items, previousOrder.getMoreItemsCount(), new Object[]{Integer.valueOf(previousOrder.getMoreItemsCount())}));
                ((TextView) aspectRatioCardView.findViewById(i11)).setVisibility(0);
                return;
            }
            ((TextView) aspectRatioCardView.findViewById(R.id.previous_more_item)).setVisibility(4);
        }

        public final void bind(@NotNull PreviousOrder previousOrder) {
            Intrinsics.checkNotNullParameter(previousOrder, "previousOrder");
            setUpViews(previousOrder);
            setUIActions(previousOrder);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreviousOrderAdapter(@NotNull PreviousOrderListener previousOrderListener) {
        super(new PreviousOrderDiffUtil());
        Intrinsics.checkNotNullParameter(previousOrderListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = previousOrderListener;
    }

    @NotNull
    public final PreviousOrderListener getListener() {
        return this.listener;
    }

    public final void setListener(@NotNull PreviousOrderListener previousOrderListener) {
        Intrinsics.checkNotNullParameter(previousOrderListener, "<set-?>");
        this.listener = previousOrderListener;
    }

    public void onBindViewHolder(@NotNull PreviousOrderViewHolder previousOrderViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(previousOrderViewHolder, "holder");
        Object item = getItem(i11);
        Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
        previousOrderViewHolder.bind((PreviousOrder) item);
    }

    @NotNull
    public PreviousOrderViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.previous_order_list_item, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context)\n   …list_item, parent, false)");
        return new PreviousOrderViewHolder(this, inflate);
    }
}
