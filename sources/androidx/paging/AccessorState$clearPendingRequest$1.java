package androidx.paging;

import androidx.paging.AccessorState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u00032\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "Key", "", "Value", "it", "Landroidx/paging/AccessorState$PendingRequest;", "invoke"}, k = 3, mv = {1, 4, 2})
public final class AccessorState$clearPendingRequest$1 extends Lambda implements Function1<AccessorState.PendingRequest<Key, Value>, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LoadType f36448g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AccessorState$clearPendingRequest$1(LoadType loadType) {
        super(1);
        this.f36448g = loadType;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((AccessorState.PendingRequest) obj));
    }

    public final boolean invoke(@NotNull AccessorState.PendingRequest<Key, Value> pendingRequest) {
        Intrinsics.checkNotNullParameter(pendingRequest, "it");
        return pendingRequest.getLoadType() == this.f36448g;
    }
}
