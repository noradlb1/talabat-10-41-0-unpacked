package androidx.core.view;

import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.internal.view.SupportMenu;

public final class MenuCompat {

    @RequiresApi(28)
    public static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        public static void a(Menu menu, boolean z11) {
            menu.setGroupDividerEnabled(z11);
        }
    }

    private MenuCompat() {
    }

    public static void setGroupDividerEnabled(@NonNull Menu menu, boolean z11) {
        if (menu instanceof SupportMenu) {
            ((SupportMenu) menu).setGroupDividerEnabled(z11);
        } else if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.a(menu, z11);
        }
    }

    @Deprecated
    public static void setShowAsAction(MenuItem menuItem, int i11) {
        menuItem.setShowAsAction(i11);
    }
}
