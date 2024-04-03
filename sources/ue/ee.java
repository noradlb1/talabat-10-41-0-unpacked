package ue;

import android.view.View;
import com.talabat.SelectCardDialogAdapter;

public final /* synthetic */ class ee implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SelectCardDialogAdapter f57515b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f57516c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SelectCardDialogAdapter.CardListViewHolder f57517d;

    public /* synthetic */ ee(SelectCardDialogAdapter selectCardDialogAdapter, int i11, SelectCardDialogAdapter.CardListViewHolder cardListViewHolder) {
        this.f57515b = selectCardDialogAdapter;
        this.f57516c = i11;
        this.f57517d = cardListViewHolder;
    }

    public final void onClick(View view) {
        SelectCardDialogAdapter.m9492onBindViewHolder$lambda1(this.f57515b, this.f57516c, this.f57517d, view);
    }
}
