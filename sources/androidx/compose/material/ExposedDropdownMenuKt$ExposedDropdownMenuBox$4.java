package androidx.compose.material;

import androidx.compose.ui.focus.FocusRequester;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$4 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f4542g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ FocusRequester f4543h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuKt$ExposedDropdownMenuBox$4(boolean z11, FocusRequester focusRequester) {
        super(0);
        this.f4542g = z11;
        this.f4543h = focusRequester;
    }

    public final void invoke() {
        if (this.f4542g) {
            this.f4543h.requestFocus();
        }
    }
}
