package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SelectionContainerKt$DisableSelection$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3664g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f3665h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectionContainerKt$DisableSelection$1(Function2<? super Composer, ? super Integer, Unit> function2, int i11) {
        super(2);
        this.f3664g = function2;
        this.f3665h = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SelectionContainerKt.DisableSelection(this.f3664g, composer, this.f3665h | 1);
    }
}
