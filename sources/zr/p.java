package zr;

import android.view.View;
import com.talabat.helpers.ReorderItemMissingViewHolder;
import library.talabat.mvp.cart.CartAdapterListener;

public final /* synthetic */ class p implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartAdapterListener f63116b;

    public /* synthetic */ p(CartAdapterListener cartAdapterListener) {
        this.f63116b = cartAdapterListener;
    }

    public final void onClick(View view) {
        ReorderItemMissingViewHolder.lambda$bindCloseButton$0(this.f63116b, view);
    }
}
