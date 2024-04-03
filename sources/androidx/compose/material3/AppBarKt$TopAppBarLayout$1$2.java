package androidx.compose.material3;

import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AppBarKt$TopAppBarLayout$1$2 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {
    public static final AppBarKt$TopAppBarLayout$1$2 INSTANCE = new AppBarKt$TopAppBarLayout$1$2();

    public AppBarKt$TopAppBarLayout$1$2() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$clearAndSetSemantics");
    }
}
