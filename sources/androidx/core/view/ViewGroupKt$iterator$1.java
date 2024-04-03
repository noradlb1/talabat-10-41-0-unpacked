package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0002J\t\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"androidx/core/view/ViewGroupKt$iterator$1", "", "Landroid/view/View;", "index", "", "hasNext", "", "next", "remove", "", "core-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ViewGroupKt$iterator$1 implements Iterator<View>, KMutableIterator, j$.util.Iterator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f11484b;
    private int index;

    public ViewGroupKt$iterator$1(ViewGroup viewGroup) {
        this.f11484b = viewGroup;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public boolean hasNext() {
        return this.index < this.f11484b.getChildCount();
    }

    public void remove() {
        ViewGroup viewGroup = this.f11484b;
        int i11 = this.index - 1;
        this.index = i11;
        viewGroup.removeViewAt(i11);
    }

    @NotNull
    public View next() {
        ViewGroup viewGroup = this.f11484b;
        int i11 = this.index;
        this.index = i11 + 1;
        View childAt = viewGroup.getChildAt(i11);
        if (childAt != null) {
            return childAt;
        }
        throw new IndexOutOfBoundsException();
    }
}
