package ox;

import android.view.View;
import com.talabat.verticals.ui.customViewLCAware.adapter.VerticalsItemViewHolder;
import com.talabat.verticals.ui.customViewLCAware.model.Vertical;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VerticalsItemViewHolder f24041b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Vertical f24042c;

    public /* synthetic */ b(VerticalsItemViewHolder verticalsItemViewHolder, Vertical vertical) {
        this.f24041b = verticalsItemViewHolder;
        this.f24042c = vertical;
    }

    public final void onClick(View view) {
        VerticalsItemViewHolder.m5941bindItem$lambda3(this.f24041b, this.f24042c, view);
    }
}
