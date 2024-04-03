package androidx.compose.material3;

import androidx.compose.foundation.interaction.Interaction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MappedInteractionSource$special$$inlined$map$1 implements Flow<Interaction> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Flow f7305b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MappedInteractionSource f7306c;

    public MappedInteractionSource$special$$inlined$map$1(Flow flow, MappedInteractionSource mappedInteractionSource) {
        this.f7305b = flow;
        this.f7306c = mappedInteractionSource;
    }

    @Nullable
    public Object collect(@NotNull final FlowCollector flowCollector, @NotNull Continuation continuation) {
        Flow flow = this.f7305b;
        final MappedInteractionSource mappedInteractionSource = this.f7306c;
        Object collect = flow.collect(new FlowCollector() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            @org.jetbrains.annotations.Nullable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r7
                    androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1$2$1 r0 = (androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.f7310i
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f7310i = r1
                    goto L_0x0018
                L_0x0013:
                    androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1$2$1 r0 = new androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1$2$1
                    r0.<init>(r5, r7)
                L_0x0018:
                    java.lang.Object r7 = r0.f7309h
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.f7310i
                    r3 = 1
                    if (r2 == 0) goto L_0x0032
                    if (r2 != r3) goto L_0x002a
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L_0x0097
                L_0x002a:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L_0x0032:
                    kotlin.ResultKt.throwOnFailure(r7)
                    kotlinx.coroutines.flow.FlowCollector r7 = r4
                    androidx.compose.foundation.interaction.Interaction r6 = (androidx.compose.foundation.interaction.Interaction) r6
                    boolean r2 = r6 instanceof androidx.compose.foundation.interaction.PressInteraction.Press
                    if (r2 == 0) goto L_0x0051
                    androidx.compose.material3.MappedInteractionSource r2 = r2
                    r4 = r6
                    androidx.compose.foundation.interaction.PressInteraction$Press r4 = (androidx.compose.foundation.interaction.PressInteraction.Press) r4
                    androidx.compose.foundation.interaction.PressInteraction$Press r2 = r2.mapPress(r4)
                    androidx.compose.material3.MappedInteractionSource r4 = r2
                    java.util.Map r4 = r4.mappedPresses
                    r4.put(r6, r2)
                    r6 = r2
                    goto L_0x008e
                L_0x0051:
                    boolean r2 = r6 instanceof androidx.compose.foundation.interaction.PressInteraction.Cancel
                    if (r2 == 0) goto L_0x0070
                    androidx.compose.material3.MappedInteractionSource r2 = r2
                    java.util.Map r2 = r2.mappedPresses
                    androidx.compose.foundation.interaction.PressInteraction$Cancel r6 = (androidx.compose.foundation.interaction.PressInteraction.Cancel) r6
                    androidx.compose.foundation.interaction.PressInteraction$Press r4 = r6.getPress()
                    java.lang.Object r2 = r2.remove(r4)
                    androidx.compose.foundation.interaction.PressInteraction$Press r2 = (androidx.compose.foundation.interaction.PressInteraction.Press) r2
                    if (r2 != 0) goto L_0x006a
                    goto L_0x008e
                L_0x006a:
                    androidx.compose.foundation.interaction.PressInteraction$Cancel r6 = new androidx.compose.foundation.interaction.PressInteraction$Cancel
                    r6.<init>(r2)
                    goto L_0x008e
                L_0x0070:
                    boolean r2 = r6 instanceof androidx.compose.foundation.interaction.PressInteraction.Release
                    if (r2 == 0) goto L_0x008e
                    androidx.compose.material3.MappedInteractionSource r2 = r2
                    java.util.Map r2 = r2.mappedPresses
                    androidx.compose.foundation.interaction.PressInteraction$Release r6 = (androidx.compose.foundation.interaction.PressInteraction.Release) r6
                    androidx.compose.foundation.interaction.PressInteraction$Press r4 = r6.getPress()
                    java.lang.Object r2 = r2.remove(r4)
                    androidx.compose.foundation.interaction.PressInteraction$Press r2 = (androidx.compose.foundation.interaction.PressInteraction.Press) r2
                    if (r2 != 0) goto L_0x0089
                    goto L_0x008e
                L_0x0089:
                    androidx.compose.foundation.interaction.PressInteraction$Release r6 = new androidx.compose.foundation.interaction.PressInteraction$Release
                    r6.<init>(r2)
                L_0x008e:
                    r0.f7310i = r3
                    java.lang.Object r6 = r7.emit(r6, r0)
                    if (r6 != r1) goto L_0x0097
                    return r1
                L_0x0097:
                    kotlin.Unit r6 = kotlin.Unit.INSTANCE
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.MappedInteractionSource$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
