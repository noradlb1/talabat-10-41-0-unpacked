package yh;

import androidx.navigation.ui.AppBarConfiguration;
import com.talabat.darkstores.common.base.BaseFragment;

public final /* synthetic */ class b implements AppBarConfiguration.OnNavigateUpListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BaseFragment f58022a;

    public /* synthetic */ b(BaseFragment baseFragment) {
        this.f58022a = baseFragment;
    }

    public final boolean onNavigateUp() {
        return BaseFragment.m9632setupToolbar$lambda1(this.f58022a);
    }
}
