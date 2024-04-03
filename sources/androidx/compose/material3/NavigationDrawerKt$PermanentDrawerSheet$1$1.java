package androidx.compose.material3;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class NavigationDrawerKt$PermanentDrawerSheet$1$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f7525g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavigationDrawerKt$PermanentDrawerSheet$1$1(String str) {
        super(1);
        this.f7525g = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertiesKt.setPaneTitle(semanticsPropertyReceiver, this.f7525g);
    }
}
