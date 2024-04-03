package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidSelectionHandles_androidKt$SelectionHandle$1$1$1 extends Lambda implements Function1<SemanticsPropertyReceiver, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f3641g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f3642h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidSelectionHandles_androidKt$SelectionHandle$1$1$1(boolean z11, long j11) {
        super(1);
        this.f3641g = z11;
        this.f3642h = j11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SemanticsPropertyReceiver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        Handle handle;
        Intrinsics.checkNotNullParameter(semanticsPropertyReceiver, "$this$semantics");
        SemanticsPropertyKey<SelectionHandleInfo> selectionHandleInfoKey = SelectionHandlesKt.getSelectionHandleInfoKey();
        if (this.f3641g) {
            handle = Handle.SelectionStart;
        } else {
            handle = Handle.SelectionEnd;
        }
        semanticsPropertyReceiver.set(selectionHandleInfoKey, new SelectionHandleInfo(handle, this.f3642h, (DefaultConstructorMarker) null));
    }
}
