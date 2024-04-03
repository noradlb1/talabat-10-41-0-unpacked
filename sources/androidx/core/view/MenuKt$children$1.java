package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0002¨\u0006\u0005"}, d2 = {"androidx/core/view/MenuKt$children$1", "Lkotlin/sequences/Sequence;", "Landroid/view/MenuItem;", "iterator", "", "core-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MenuKt$children$1 implements Sequence<MenuItem> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Menu f11472a;

    public MenuKt$children$1(Menu menu) {
        this.f11472a = menu;
    }

    @NotNull
    public Iterator<MenuItem> iterator() {
        return MenuKt.iterator(this.f11472a);
    }
}
