package androidx.compose.foundation.text;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidCursorHandle_androidKt$DefaultCursorHandle$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f3265g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f3266h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidCursorHandle_androidKt$DefaultCursorHandle$1(Modifier modifier, int i11) {
        super(2);
        this.f3265g = modifier;
        this.f3266h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        AndroidCursorHandle_androidKt.DefaultCursorHandle(this.f3265g, composer, this.f3266h | 1);
    }
}
