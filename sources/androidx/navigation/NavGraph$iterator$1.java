package androidx.navigation;

import androidx.collection.SparseArrayCompat;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u0002J\t\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"androidx/navigation/NavGraph$iterator$1", "", "Landroidx/navigation/NavDestination;", "index", "", "wentToNext", "", "hasNext", "next", "remove", "", "navigation-common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NavGraph$iterator$1 implements Iterator<NavDestination>, KMutableIterator, j$.util.Iterator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NavGraph f36333b;
    private int index = -1;
    private boolean wentToNext;

    public NavGraph$iterator$1(NavGraph navGraph) {
        this.f36333b = navGraph;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public boolean hasNext() {
        return this.index + 1 < this.f36333b.getNodes().size();
    }

    public void remove() {
        if (this.wentToNext) {
            SparseArrayCompat<NavDestination> nodes = this.f36333b.getNodes();
            nodes.valueAt(this.index).setParent((NavGraph) null);
            nodes.removeAt(this.index);
            this.index--;
            this.wentToNext = false;
            return;
        }
        throw new IllegalStateException("You must call next() before you can remove an element".toString());
    }

    @NotNull
    public NavDestination next() {
        if (hasNext()) {
            this.wentToNext = true;
            SparseArrayCompat<NavDestination> nodes = this.f36333b.getNodes();
            int i11 = this.index + 1;
            this.index = i11;
            NavDestination valueAt = nodes.valueAt(i11);
            Intrinsics.checkNotNullExpressionValue(valueAt, "nodes.valueAt(++index)");
            return valueAt;
        }
        throw new NoSuchElementException();
    }
}
