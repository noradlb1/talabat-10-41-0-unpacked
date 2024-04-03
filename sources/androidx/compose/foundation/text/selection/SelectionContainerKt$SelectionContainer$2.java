package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SelectionContainerKt$SelectionContainer$2 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f3667g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3668h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ int f3669i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f3670j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectionContainerKt$SelectionContainer$2(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f3667g = modifier;
        this.f3668h = function2;
        this.f3669i = i11;
        this.f3670j = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SelectionContainerKt.SelectionContainer(this.f3667g, this.f3668h, composer, this.f3669i | 1, this.f3670j);
    }
}
