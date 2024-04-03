package sn;

import android.view.View;
import com.talabat.feature.pickup.presentation.adapters.SwimlanesAdapter;
import com.talabat.feature.pickup.presentation.entity.SwimlaneView;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwimlanesAdapter f62889b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SwimlaneView f62890c;

    public /* synthetic */ a(SwimlanesAdapter swimlanesAdapter, SwimlaneView swimlaneView) {
        this.f62889b = swimlanesAdapter;
        this.f62890c = swimlaneView;
    }

    public final void onClick(View view) {
        SwimlanesAdapter.m10257onBindViewHolder$lambda0(this.f62889b, this.f62890c, view);
    }
}
