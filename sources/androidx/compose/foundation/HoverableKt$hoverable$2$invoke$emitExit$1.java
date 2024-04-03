package androidx.compose.foundation;

import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.HoverableKt$hoverable$2", f = "Hoverable.kt", i = {0}, l = {70}, m = "invoke$emitExit", n = {"hoverInteraction$delegate"}, s = {"L$0"})
public final class HoverableKt$hoverable$2$invoke$emitExit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f1707h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f1708i;

    /* renamed from: j  reason: collision with root package name */
    public int f1709j;

    public HoverableKt$hoverable$2$invoke$emitExit$1(Continuation<? super HoverableKt$hoverable$2$invoke$emitExit$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f1708i = obj;
        this.f1709j |= Integer.MIN_VALUE;
        return HoverableKt$hoverable$2.invoke$emitExit((MutableState<HoverInteraction.Enter>) null, (MutableInteractionSource) null, this);
    }
}
