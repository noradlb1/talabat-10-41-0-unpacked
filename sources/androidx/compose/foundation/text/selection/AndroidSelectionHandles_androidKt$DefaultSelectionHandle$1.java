package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidSelectionHandles_androidKt$DefaultSelectionHandle$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f3625g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ boolean f3626h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ResolvedTextDirection f3627i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f3628j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f3629k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidSelectionHandles_androidKt$DefaultSelectionHandle$1(Modifier modifier, boolean z11, ResolvedTextDirection resolvedTextDirection, boolean z12, int i11) {
        super(2);
        this.f3625g = modifier;
        this.f3626h = z11;
        this.f3627i = resolvedTextDirection;
        this.f3628j = z12;
        this.f3629k = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AndroidSelectionHandles_androidKt.DefaultSelectionHandle(this.f3625g, this.f3626h, this.f3627i, this.f3628j, composer, this.f3629k | 1);
    }
}
