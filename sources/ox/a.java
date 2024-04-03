package ox;

import android.view.View;
import com.talabat.verticals.ui.customViewLCAware.adapter.VerticalsItemSmallViewHolder;
import com.talabat.verticals.ui.customViewLCAware.model.Vertical;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VerticalsItemSmallViewHolder f24039b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Vertical f24040c;

    public /* synthetic */ a(VerticalsItemSmallViewHolder verticalsItemSmallViewHolder, Vertical vertical) {
        this.f24039b = verticalsItemSmallViewHolder;
        this.f24040c = vertical;
    }

    public final void onClick(View view) {
        VerticalsItemSmallViewHolder.m5940bindItem$lambda3(this.f24039b, this.f24040c, view);
    }
}
