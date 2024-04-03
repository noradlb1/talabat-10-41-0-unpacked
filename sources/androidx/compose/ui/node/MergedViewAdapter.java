package androidx.compose.ui.node;

import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J1\u0010\u0012\u001a\u0002H\u0013\"\b\b\u0000\u0010\u0013*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u0015H\bø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/node/MergedViewAdapter;", "Landroidx/compose/ui/node/ViewAdapter;", "()V", "adapters", "", "getAdapters", "()Ljava/util/List;", "id", "", "getId", "()I", "didInsert", "", "view", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "didUpdate", "get", "T", "factory", "Lkotlin/Function0;", "(ILkotlin/jvm/functions/Function0;)Landroidx/compose/ui/node/ViewAdapter;", "willInsert", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MergedViewAdapter implements ViewAdapter {
    @NotNull
    private final List<ViewAdapter> adapters = new ArrayList();

    /* renamed from: id  reason: collision with root package name */
    private final int f9940id;

    public void didInsert(@NotNull View view, @NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        List<ViewAdapter> list = this.adapters;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            list.get(i11).didInsert(view, viewGroup);
        }
    }

    public void didUpdate(@NotNull View view, @NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        List<ViewAdapter> list = this.adapters;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            list.get(i11).didUpdate(view, viewGroup);
        }
    }

    @NotNull
    public final <T extends ViewAdapter> T get(int i11, @NotNull Function0<? extends T> function0) {
        T t11;
        T t12;
        boolean z11;
        Intrinsics.checkNotNullParameter(function0, "factory");
        List<ViewAdapter> adapters2 = getAdapters();
        int size = adapters2.size();
        int i12 = 0;
        while (true) {
            t11 = null;
            if (i12 >= size) {
                t12 = null;
                break;
            }
            t12 = adapters2.get(i12);
            if (((ViewAdapter) t12).getId() == i11) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                break;
            }
            i12++;
        }
        if (t12 instanceof ViewAdapter) {
            t11 = (ViewAdapter) t12;
        }
        if (t11 != null) {
            return t11;
        }
        T t13 = (ViewAdapter) function0.invoke();
        getAdapters().add(t13);
        return t13;
    }

    @NotNull
    public final List<ViewAdapter> getAdapters() {
        return this.adapters;
    }

    public int getId() {
        return this.f9940id;
    }

    public void willInsert(@NotNull View view, @NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        List<ViewAdapter> list = this.adapters;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            list.get(i11).willInsert(view, viewGroup);
        }
    }
}
