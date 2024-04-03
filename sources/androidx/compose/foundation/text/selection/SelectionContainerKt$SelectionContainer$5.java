package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class SelectionContainerKt$SelectionContainer$5 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f3686g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Selection f3687h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Selection, Unit> f3688i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<Composer, Integer, Unit> f3689j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f3690k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f3691l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectionContainerKt$SelectionContainer$5(Modifier modifier, Selection selection, Function1<? super Selection, Unit> function1, Function2<? super Composer, ? super Integer, Unit> function2, int i11, int i12) {
        super(2);
        this.f3686g = modifier;
        this.f3687h = selection;
        this.f3688i = function1;
        this.f3689j = function2;
        this.f3690k = i11;
        this.f3691l = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        SelectionContainerKt.SelectionContainer(this.f3686g, this.f3687h, this.f3688i, this.f3689j, composer, this.f3690k | 1, this.f3691l);
    }
}
