package wv;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.CardListAdapter;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CardListAdapter f24166b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f24167c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f24168d;

    public /* synthetic */ b(CardListAdapter cardListAdapter, RecyclerView.ViewHolder viewHolder, int i11) {
        this.f24166b = cardListAdapter;
        this.f24167c = viewHolder;
        this.f24168d = i11;
    }

    public final void onClick(View view) {
        CardListAdapter.m5789onBindViewHolder$lambda1(this.f24166b, this.f24167c, this.f24168d, view);
    }
}
