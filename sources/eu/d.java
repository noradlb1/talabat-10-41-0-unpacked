package eu;

import androidx.lifecycle.Observer;
import com.talabat.sdsquad.ui.collections.CollectionsFragment;

public final /* synthetic */ class d implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CollectionsFragment f62015a;

    public /* synthetic */ d(CollectionsFragment collectionsFragment) {
        this.f62015a = collectionsFragment;
    }

    public final void onChanged(Object obj) {
        CollectionsFragment.m10798onActivityCreated$lambda3(this.f62015a, (Boolean) obj);
    }
}
