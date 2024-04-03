package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragLogic", f = "Draggable.kt", i = {0, 0}, l = {400, 403}, m = "processDragCancel", n = {"this", "$this$processDragCancel"}, s = {"L$0", "L$1"})
public final class DragLogic$processDragCancel$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f2018h;

    /* renamed from: i  reason: collision with root package name */
    public Object f2019i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f2020j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ DragLogic f2021k;

    /* renamed from: l  reason: collision with root package name */
    public int f2022l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DragLogic$processDragCancel$1(DragLogic dragLogic, Continuation<? super DragLogic$processDragCancel$1> continuation) {
        super(continuation);
        this.f2021k = dragLogic;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f2020j = obj;
        this.f2022l |= Integer.MIN_VALUE;
        return this.f2021k.processDragCancel((CoroutineScope) null, this);
    }
}
