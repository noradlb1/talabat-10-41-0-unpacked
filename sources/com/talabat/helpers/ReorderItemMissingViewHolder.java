package com.talabat.helpers;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.Cart;
import com.talabat.R;
import library.talabat.mvp.cart.CartAdapterListener;
import zr.p;

public class ReorderItemMissingViewHolder extends RecyclerView.ViewHolder {
    private final View closeReorderStatus;
    private final TextView reorderItemMissingContent;

    public ReorderItemMissingViewHolder(View view) {
        super(view);
        this.closeReorderStatus = view.findViewById(R.id.close_reorder_status);
        this.reorderItemMissingContent = (TextView) view.findViewById(R.id.reorder_item_missing_content);
    }

    private void bindCloseButton(CartAdapterListener cartAdapterListener) {
        this.closeReorderStatus.setOnClickListener(new p(cartAdapterListener));
    }

    private void bindContent(CartAdapterListener cartAdapterListener) {
        this.reorderItemMissingContent.setText(cartAdapterListener.getReorderStatusContent());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$bindCloseButton$0(CartAdapterListener cartAdapterListener, View view) {
        cartAdapterListener.closeReorderStatusView();
        cartAdapterListener.notifyItemRemoved(Cart.getInstance().getCouponsAndPromotionsCount());
    }

    public void bind(CartAdapterListener cartAdapterListener) {
        bindCloseButton(cartAdapterListener);
        bindContent(cartAdapterListener);
    }
}
