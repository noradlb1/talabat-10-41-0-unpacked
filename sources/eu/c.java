package eu;

import androidx.lifecycle.Observer;
import com.talabat.sdsquad.ui.collections.CollectionsFragment;

public final /* synthetic */ class c implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CollectionsFragment f62014a;

    public /* synthetic */ c(CollectionsFragment collectionsFragment) {
        this.f62014a = collectionsFragment;
    }

    public final void onChanged(Object obj) {
        CollectionsFragment.m10797onActivityCreated$lambda2(this.f62014a, (Boolean) obj);
    }
}
