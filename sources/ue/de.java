package ue;

import android.view.View;
import com.talabat.SelectCardDialogAdapter;

public final /* synthetic */ class de implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SelectCardDialogAdapter f57494b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f57495c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ SelectCardDialogAdapter.CardListViewHolder f57496d;

    public /* synthetic */ de(SelectCardDialogAdapter selectCardDialogAdapter, int i11, SelectCardDialogAdapter.CardListViewHolder cardListViewHolder) {
        this.f57494b = selectCardDialogAdapter;
        this.f57495c = i11;
        this.f57496d = cardListViewHolder;
    }

    public final void onClick(View view) {
        SelectCardDialogAdapter.m9491onBindViewHolder$lambda0(this.f57494b, this.f57495c, this.f57496d, view);
    }
}
