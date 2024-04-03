package curtains.internal;

import android.view.View;
import curtains.OnRootViewsChangedListener;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"curtains/internal/RootViewsSpy$delegatingViewList$1", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "add", "", "element", "removeAt", "index", "", "curtains_release"}, k = 1, mv = {1, 4, 1})
public final class RootViewsSpy$delegatingViewList$1 extends ArrayList<View> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RootViewsSpy f13803b;

    public RootViewsSpy$delegatingViewList$1(RootViewsSpy rootViewsSpy) {
        this.f13803b = rootViewsSpy;
    }

    public /* bridge */ boolean contains(View view) {
        return super.contains(view);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ int indexOf(View view) {
        return super.indexOf(view);
    }

    public /* bridge */ int lastIndexOf(View view) {
        return super.lastIndexOf(view);
    }

    public final /* bridge */ View remove(int i11) {
        return remove(i11);
    }

    @NotNull
    /* renamed from: removeAt */
    public View remove(int i11) {
        Object remove = super.remove(i11);
        Intrinsics.checkNotNullExpressionValue(remove, "super.removeAt(index)");
        View view = (View) remove;
        for (OnRootViewsChangedListener onRootViewsChanged : this.f13803b.getListeners()) {
            onRootViewsChanged.onRootViewsChanged(view, false);
        }
        return view;
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public boolean add(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "element");
        for (OnRootViewsChangedListener onRootViewsChanged : this.f13803b.getListeners()) {
            onRootViewsChanged.onRootViewsChanged(view, true);
        }
        return super.add(view);
    }

    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof View) {
            return contains((View) obj);
        }
        return false;
    }

    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof View) {
            return indexOf((View) obj);
        }
        return -1;
    }

    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof View) {
            return lastIndexOf((View) obj);
        }
        return -1;
    }

    public /* bridge */ boolean remove(View view) {
        return super.remove(view);
    }

    public final /* bridge */ boolean remove(Object obj) {
        if (obj instanceof View) {
            return remove((View) obj);
        }
        return false;
    }
}
