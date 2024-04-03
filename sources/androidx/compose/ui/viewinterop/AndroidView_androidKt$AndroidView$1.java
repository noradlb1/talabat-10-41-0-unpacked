package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Ref;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidView_androidKt$AndroidView$1 extends Lambda implements Function0<LayoutNode> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Context f10313g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CompositionContext f10314h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ NestedScrollDispatcher f10315i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<Context, T> f10316j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ SaveableStateRegistry f10317k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f10318l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Ref<ViewFactoryHolder<T>> f10319m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidView_androidKt$AndroidView$1(Context context, CompositionContext compositionContext, NestedScrollDispatcher nestedScrollDispatcher, Function1<? super Context, ? extends T> function1, SaveableStateRegistry saveableStateRegistry, String str, Ref<ViewFactoryHolder<T>> ref) {
        super(0);
        this.f10313g = context;
        this.f10314h = compositionContext;
        this.f10315i = nestedScrollDispatcher;
        this.f10316j = function1;
        this.f10317k = saveableStateRegistry;
        this.f10318l = str;
        this.f10319m = ref;
    }

    @NotNull
    public final LayoutNode invoke() {
        View typedView$ui_release;
        ViewFactoryHolder viewFactoryHolder = new ViewFactoryHolder(this.f10313g, this.f10314h, this.f10315i);
        viewFactoryHolder.setFactory(this.f10316j);
        SaveableStateRegistry saveableStateRegistry = this.f10317k;
        SparseArray sparseArray = null;
        Object consumeRestored = saveableStateRegistry != null ? saveableStateRegistry.consumeRestored(this.f10318l) : null;
        if (consumeRestored instanceof SparseArray) {
            sparseArray = (SparseArray) consumeRestored;
        }
        if (!(sparseArray == null || (typedView$ui_release = viewFactoryHolder.getTypedView$ui_release()) == null)) {
            typedView$ui_release.restoreHierarchyState(sparseArray);
        }
        this.f10319m.setValue(viewFactoryHolder);
        return viewFactoryHolder.getLayoutNode();
    }
}
