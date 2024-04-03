package wv;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.CardListAdapter;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CardListAdapter f24163b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f24164c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f24165d;

    public /* synthetic */ a(CardListAdapter cardListAdapter, RecyclerView.ViewHolder viewHolder, int i11) {
        this.f24163b = cardListAdapter;
        this.f24164c = viewHolder;
        this.f24165d = i11;
    }

    public final void onClick(View view) {
        CardListAdapter.m5788onBindViewHolder$lambda0(this.f24163b, this.f24164c, this.f24165d, view);
    }
}
