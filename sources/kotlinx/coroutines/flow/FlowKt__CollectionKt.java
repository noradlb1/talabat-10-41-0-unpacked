package kotlinx.coroutines.flow;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010#\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0010\b\u0001\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a7\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a7\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"toCollection", "C", "T", "", "Lkotlinx/coroutines/flow/Flow;", "destination", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toList", "", "", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSet", "", "", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final /* synthetic */ class FlowKt__CollectionKt {
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, C extends java.util.Collection<? super T>> java.lang.Object toCollection(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.Flow<? extends T> r4, @org.jetbrains.annotations.NotNull C r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super C> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1 r0 = (kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1) r0
            int r1 = r0.f25513j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25513j = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1 r0 = new kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.f25512i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f25513j
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r4 = r0.f25511h
            r5 = r4
            java.util.Collection r5 = (java.util.Collection) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0049
        L_0x002e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$2 r6 = new kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$2
            r6.<init>(r5)
            r0.f25511h = r5
            r0.f25513j = r3
            java.lang.Object r4 = r4.collect(r6, r0)
            if (r4 != r1) goto L_0x0049
            return r1
        L_0x0049:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__CollectionKt.toCollection(kotlinx.coroutines.flow.Flow, java.util.Collection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public static final <T> Object toList(@NotNull Flow<? extends T> flow, @NotNull List<T> list, @NotNull Continuation<? super List<? extends T>> continuation) {
        return FlowKt.toCollection(flow, list, continuation);
    }

    public static /* synthetic */ Object toList$default(Flow flow, List list, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = new ArrayList();
        }
        return FlowKt.toList(flow, list, continuation);
    }

    @Nullable
    public static final <T> Object toSet(@NotNull Flow<? extends T> flow, @NotNull Set<T> set, @NotNull Continuation<? super Set<? extends T>> continuation) {
        return FlowKt.toCollection(flow, set, continuation);
    }

    public static /* synthetic */ Object toSet$default(Flow flow, Set set, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            set = new LinkedHashSet();
        }
        return FlowKt.toSet(flow, set, continuation);
    }
}
