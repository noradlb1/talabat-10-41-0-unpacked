package androidx.compose.ui.platform;

import androidx.savedstate.SavedStateRegistry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f10030g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SavedStateRegistry f10031h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f10032i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$1(boolean z11, SavedStateRegistry savedStateRegistry, String str) {
        super(0);
        this.f10030g = z11;
        this.f10031h = savedStateRegistry;
        this.f10032i = str;
    }

    public final void invoke() {
        if (this.f10030g) {
            this.f10031h.unregisterSavedStateProvider(this.f10032i);
        }
    }
}
