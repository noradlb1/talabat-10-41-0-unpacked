package eu;

import com.google.android.material.appbar.AppBarLayout;
import com.talabat.sdsquad.ui.collections.CollectionsFragment;
import com.talabat.sdsquad.ui.collections.CollectionsFragment$onActivityCreated$2;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CollectionsFragment$onActivityCreated$2 f62019b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f62020c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f62021d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ CollectionsFragment f62022e;

    public /* synthetic */ h(CollectionsFragment$onActivityCreated$2 collectionsFragment$onActivityCreated$2, AppBarLayout appBarLayout, int i11, CollectionsFragment collectionsFragment) {
        this.f62019b = collectionsFragment$onActivityCreated$2;
        this.f62020c = appBarLayout;
        this.f62021d = i11;
        this.f62022e = collectionsFragment;
    }

    public final void run() {
        CollectionsFragment$onActivityCreated$2.m10802onOffsetChanged$lambda0(this.f62019b, this.f62020c, this.f62021d, this.f62022e);
    }
}
