package androidx.navigation.fragment;

import android.view.View;
import androidx.activity.OnBackPressedCallback;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "core-ktx_release", "androidx/core/view/ViewKt$doOnLayout$$inlined$doOnNextLayout$1"}, k = 1, mv = {1, 6, 0})
public final class AbstractListDetailFragment$onCreateView$$inlined$doOnLayout$1 implements View.OnLayoutChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbstractListDetailFragment f36437b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SlidingPaneLayout f36438c;

    public AbstractListDetailFragment$onCreateView$$inlined$doOnLayout$1(AbstractListDetailFragment abstractListDetailFragment, SlidingPaneLayout slidingPaneLayout) {
        this.f36437b = abstractListDetailFragment;
        this.f36438c = slidingPaneLayout;
    }

    public void onLayoutChange(@NotNull View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        boolean z11;
        Intrinsics.checkParameterIsNotNull(view, "view");
        view.removeOnLayoutChangeListener(this);
        OnBackPressedCallback access$getOnBackPressedCallback$p = this.f36437b.onBackPressedCallback;
        Intrinsics.checkNotNull(access$getOnBackPressedCallback$p);
        if (!this.f36438c.isSlideable() || !this.f36438c.isOpen()) {
            z11 = false;
        } else {
            z11 = true;
        }
        access$getOnBackPressedCallback$p.setEnabled(z11);
    }
}
