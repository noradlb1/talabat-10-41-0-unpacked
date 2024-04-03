package rt;

import android.view.View;
import com.talabat.restaurants.v2.ui.adapters.viewholders.FeatureProductItemViewHolder;
import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductDisplayModel;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FeatureProductItemViewHolder f62880b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f62881c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f62882d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ FeatureProductDisplayModel f62883e;

    public /* synthetic */ a(FeatureProductItemViewHolder featureProductItemViewHolder, int i11, int i12, FeatureProductDisplayModel featureProductDisplayModel) {
        this.f62880b = featureProductItemViewHolder;
        this.f62881c = i11;
        this.f62882d = i12;
        this.f62883e = featureProductDisplayModel;
    }

    public final void onClick(View view) {
        FeatureProductItemViewHolder.m10756bind$lambda0(this.f62880b, this.f62881c, this.f62882d, this.f62883e, view);
    }
}
