package bf;

import android.view.View;
import com.talabat.adapters.restaurantslist.InstanceSearchAdapter;
import datamodels.Restaurant;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InstanceSearchAdapter f50841b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Restaurant f50842c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f50843d;

    public /* synthetic */ a(InstanceSearchAdapter instanceSearchAdapter, Restaurant restaurant, int i11) {
        this.f50841b = instanceSearchAdapter;
        this.f50842c = restaurant;
        this.f50843d = i11;
    }

    public final void onClick(View view) {
        this.f50841b.lambda$onBindViewHolder$0(this.f50842c, this.f50843d, view);
    }
}
