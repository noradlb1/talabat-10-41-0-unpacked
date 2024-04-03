package com.instabug.featuresrequest.ui.featuresmain;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.instabug.featuresrequest.R;
import com.instabug.featuresrequest.settings.a;
import com.instabug.featuresrequest.utils.i;

class e implements PopupMenu.OnMenuItemClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f46783b;

    public e(f fVar) {
        this.f46783b = fVar;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        if (this.f46783b.f46787h == null) {
            return false;
        }
        menuItem.setChecked(true);
        int itemId = menuItem.getItemId();
        if (itemId == R.id.sortBy_topRated) {
            this.f46783b.f46787h.setText(i.a(this.f46783b.getLocalizedString(R.string.sort_by_top_rated)));
            f fVar = this.f46783b;
            fVar.J = Boolean.TRUE;
            int unused = fVar.f46788j = 0;
        } else if (itemId != R.id.sortBy_recentlyUpdated) {
            return false;
        } else {
            this.f46783b.f46787h.setText(i.a(this.f46783b.getLocalizedString(R.string.sort_by_recently_updated)));
            f fVar2 = this.f46783b;
            fVar2.J = Boolean.FALSE;
            int unused2 = fVar2.f46788j = 1;
        }
        a.a(this.f46783b.f46788j);
        f fVar3 = this.f46783b;
        fVar3.c(fVar3.J.booleanValue());
        return true;
    }
}
