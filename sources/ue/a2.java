package ue;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.CartScreen;

public final /* synthetic */ class a2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CartScreen.CartRecyclerviewAdapter f57423b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f57424c;

    public /* synthetic */ a2(CartScreen.CartRecyclerviewAdapter cartRecyclerviewAdapter, RecyclerView.ViewHolder viewHolder) {
        this.f57423b = cartRecyclerviewAdapter;
        this.f57424c = viewHolder;
    }

    public final void onClick(View view) {
        this.f57423b.lambda$onBindViewHolder$3(this.f57424c, view);
    }
}
