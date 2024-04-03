package androidx.compose.foundation.text.selection;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.TextSelectionMouseDetectorKt", f = "TextSelectionMouseDetector.kt", i = {0}, l = {127}, m = "awaitMouseEventDown", n = {"$this$awaitMouseEventDown"}, s = {"L$0"})
public final class TextSelectionMouseDetectorKt$awaitMouseEventDown$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f3766h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f3767i;

    /* renamed from: j  reason: collision with root package name */
    public int f3768j;

    public TextSelectionMouseDetectorKt$awaitMouseEventDown$1(Continuation<? super TextSelectionMouseDetectorKt$awaitMouseEventDown$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f3767i = obj;
        this.f3768j |= Integer.MIN_VALUE;
        return TextSelectionMouseDetectorKt.awaitMouseEventDown((AwaitPointerEventScope) null, this);
    }
}
