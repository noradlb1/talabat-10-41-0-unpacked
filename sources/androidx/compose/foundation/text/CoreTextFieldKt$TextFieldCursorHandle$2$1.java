package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionHandleInfo;
import androidx.compose.foundation.text.selection.SelectionHandlesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class CoreTextFieldKt$TextFieldCursorHandle$2$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f3495g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoreTextFieldKt$TextFieldCursorHandle$2$1(long j11) {
        super(1);
        this.f3495g = j11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        semanticsPropertyReceiver.set(SelectionHandlesKt.getSelectionHandleInfoKey(), new SelectionHandleInfo(Handle.Cursor, this.f3495g, (DefaultConstructorMarker) null));
    }
}
