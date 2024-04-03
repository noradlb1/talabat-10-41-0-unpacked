package bi;

import android.view.View;
import com.talabat.darkstores.common.lists.adapters.compact.CompactSwimlaneAdapter;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CompactSwimlaneAdapter f50857b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f50858c;

    public /* synthetic */ a(CompactSwimlaneAdapter compactSwimlaneAdapter, int i11) {
        this.f50857b = compactSwimlaneAdapter;
        this.f50858c = i11;
    }

    public final void onClick(View view) {
        CompactSwimlaneAdapter.m9636onBindViewHolder$lambda1(this.f50857b, this.f50858c, view);
    }
}
