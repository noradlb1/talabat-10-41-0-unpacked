package androidx.compose.material;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class MaterialTheme_androidKt$PlatformMaterialTheme$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f4668g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f4669h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MaterialTheme_androidKt$PlatformMaterialTheme$1(Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f4668g = function2;
        this.f4669h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        MaterialTheme_androidKt.PlatformMaterialTheme(this.f4668g, composer, this.f4669h | 1);
    }
}
