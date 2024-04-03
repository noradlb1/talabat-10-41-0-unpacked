package ox;

import android.view.View;
import com.talabat.verticals.ui.customViewLCAware.adapter.VerticalsSubListItemViewHolder;
import com.talabat.verticals.ui.customViewLCAware.model.Vertical;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VerticalsSubListItemViewHolder f24043b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Vertical f24044c;

    public /* synthetic */ c(VerticalsSubListItemViewHolder verticalsSubListItemViewHolder, Vertical vertical) {
        this.f24043b = verticalsSubListItemViewHolder;
        this.f24044c = vertical;
    }

    public final void onClick(View view) {
        VerticalsSubListItemViewHolder.m5942bindItem$lambda3(this.f24043b, this.f24044c, view);
    }
}
