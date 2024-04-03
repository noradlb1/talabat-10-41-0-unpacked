package androidx.compose.foundation.text.selection;

import androidx.compose.ui.input.key.KeyEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/input/key/KeyEvent;", "invoke-ZmokQxo", "(Landroid/view/KeyEvent;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SelectionManager$modifier$4 extends Lambda implements Function1<KeyEvent, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ SelectionManager f3723g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectionManager$modifier$4(SelectionManager selectionManager) {
        super(1);
        this.f3723g = selectionManager;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m1019invokeZmokQxo(((KeyEvent) obj).m4172unboximpl());
    }

    @NotNull
    /* renamed from: invoke-ZmokQxo  reason: not valid java name */
    public final Boolean m1019invokeZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
        boolean z11;
        Intrinsics.checkNotNullParameter(keyEvent, "it");
        if (SelectionManager_androidKt.m1023isCopyKeyEventZmokQxo(keyEvent)) {
            this.f3723g.copy$foundation_release();
            z11 = true;
        } else {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }
}
