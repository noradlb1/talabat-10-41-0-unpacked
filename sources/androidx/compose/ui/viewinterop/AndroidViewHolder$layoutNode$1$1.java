package androidx.compose.ui.viewinterop;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/Modifier;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidViewHolder$layoutNode$1$1 extends Lambda implements Function1<Modifier, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LayoutNode f10285g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Modifier f10286h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidViewHolder$layoutNode$1$1(LayoutNode layoutNode, Modifier modifier) {
        super(1);
        this.f10285g = layoutNode;
        this.f10286h = modifier;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Modifier) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Modifier modifier) {
        Intrinsics.checkNotNullParameter(modifier, "it");
        this.f10285g.setModifier(modifier.then(this.f10286h));
    }
}
