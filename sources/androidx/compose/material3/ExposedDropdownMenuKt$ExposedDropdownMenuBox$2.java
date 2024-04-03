package androidx.compose.material3;

import androidx.compose.ui.focus.FocusRequester;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$2 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f6994g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ FocusRequester f6995h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExposedDropdownMenuKt$ExposedDropdownMenuBox$2(boolean z11, FocusRequester focusRequester) {
        super(0);
        this.f6994g = z11;
        this.f6995h = focusRequester;
    }

    public final void invoke() {
        if (this.f6994g) {
            this.f6995h.requestFocus();
        }
    }
}
