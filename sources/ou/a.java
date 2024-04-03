package ou;

import android.view.View;
import com.talabat.sdsquad.ui.vendorslist.adapters.viewholders.CollectionCellViewHolder;
import com.talabat.sdsquad.ui.vendorslist.displaymodels.CollectionDisplayModel;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CollectionCellViewHolder f62775b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CollectionDisplayModel f62776c;

    public /* synthetic */ a(CollectionCellViewHolder collectionCellViewHolder, CollectionDisplayModel collectionDisplayModel) {
        this.f62775b = collectionCellViewHolder;
        this.f62776c = collectionDisplayModel;
    }

    public final void onClick(View view) {
        CollectionCellViewHolder.m10889bind$lambda0(this.f62775b, this.f62776c, view);
    }
}
