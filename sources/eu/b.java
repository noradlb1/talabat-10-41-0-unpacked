package eu;

import androidx.lifecycle.Observer;
import com.talabat.sdsquad.ui.collections.CollectionsFragment;
import java.util.List;

public final /* synthetic */ class b implements Observer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CollectionsFragment f62013a;

    public /* synthetic */ b(CollectionsFragment collectionsFragment) {
        this.f62013a = collectionsFragment;
    }

    public final void onChanged(Object obj) {
        CollectionsFragment.m10796onActivityCreated$lambda1(this.f62013a, (List) obj);
    }
}
