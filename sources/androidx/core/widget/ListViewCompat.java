package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class ListViewCompat {

    @RequiresApi(19)
    public static class Api19Impl {
        private Api19Impl() {
        }

        @DoNotInline
        public static boolean canScrollList(ListView listView, int i11) {
            return listView.canScrollList(i11);
        }

        @DoNotInline
        public static void scrollListBy(ListView listView, int i11) {
            listView.scrollListBy(i11);
        }
    }

    private ListViewCompat() {
    }

    public static boolean canScrollList(@NonNull ListView listView, int i11) {
        return Api19Impl.canScrollList(listView, i11);
    }

    public static void scrollListBy(@NonNull ListView listView, int i11) {
        Api19Impl.scrollListBy(listView, i11);
    }
}
