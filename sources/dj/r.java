package dj;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.talabat.darkstores.feature.home.HomeFragment;

public final /* synthetic */ class r implements Toolbar.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f56754a;

    public /* synthetic */ r(HomeFragment homeFragment) {
        this.f56754a = homeFragment;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return this.f56754a.onMenuItemClick(menuItem);
    }
}
