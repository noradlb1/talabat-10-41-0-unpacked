package androidx.compose.ui.window;

import androidx.compose.runtime.DisposableEffectResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"androidx/compose/runtime/DisposableEffectScope$onDispose$1", "Landroidx/compose/runtime/DisposableEffectResult;", "dispose", "", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidPopup_androidKt$Popup$2$invoke$$inlined$onDispose$1 implements DisposableEffectResult {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PopupLayout f10356a;

    public AndroidPopup_androidKt$Popup$2$invoke$$inlined$onDispose$1(PopupLayout popupLayout) {
        this.f10356a = popupLayout;
    }

    public void dispose() {
        this.f10356a.disposeComposition();
        this.f10356a.dismiss();
    }
}
