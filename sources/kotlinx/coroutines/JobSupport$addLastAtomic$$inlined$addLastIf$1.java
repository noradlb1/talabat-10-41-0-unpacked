package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LockFreeLinkedListKt;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class JobSupport$addLastAtomic$$inlined$addLastIf$1 extends LockFreeLinkedListNode.CondAddOp {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JobSupport f25131a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f25132b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JobSupport$addLastAtomic$$inlined$addLastIf$1(LockFreeLinkedListNode lockFreeLinkedListNode, JobSupport jobSupport, Object obj) {
        super(lockFreeLinkedListNode);
        this.f25131a = jobSupport;
        this.f25132b = obj;
    }

    @Nullable
    public Object prepare(@NotNull LockFreeLinkedListNode lockFreeLinkedListNode) {
        if (this.f25131a.getState$kotlinx_coroutines_core() == this.f25132b) {
            return null;
        }
        return LockFreeLinkedListKt.getCONDITION_FALSE();
    }
}
