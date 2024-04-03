package androidx.compose.ui.viewinterop;

import android.os.Parcelable;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.ui.node.Ref;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidView_androidKt$AndroidView$3$valueProvider$1 extends Lambda implements Function0<SparseArray<Parcelable>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref<ViewFactoryHolder<T>> f10329g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidView_androidKt$AndroidView$3$valueProvider$1(Ref<ViewFactoryHolder<T>> ref) {
        super(0);
        this.f10329g = ref;
    }

    @NotNull
    public final SparseArray<Parcelable> invoke() {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ViewFactoryHolder<T> value = this.f10329g.getValue();
        Intrinsics.checkNotNull(value);
        View typedView$ui_release = value.getTypedView$ui_release();
        if (typedView$ui_release != null) {
            typedView$ui_release.saveHierarchyState(sparseArray);
        }
        return sparseArray;
    }
}
