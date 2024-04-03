package androidx.navigation.compose;

import androidx.navigation.NavBackStackEntry;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: androidx.navigation.compose.NavHostKt$NavHost$lambda-4$$inlined$map$1  reason: invalid class name */
public final class NavHostKt$NavHost$lambda4$$inlined$map$1 implements Flow<List<? extends NavBackStackEntry>> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Flow f36399b;

    public NavHostKt$NavHost$lambda4$$inlined$map$1(Flow flow) {
        this.f36399b = flow;
    }

    @Nullable
    public Object collect(@NotNull final FlowCollector flowCollector, @NotNull Continuation continuation) {
        Object collect = this.f36399b.collect(new Object() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            @org.jetbrains.annotations.Nullable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof androidx.navigation.compose.NavHostKt$NavHost$lambda4$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r9
                    androidx.navigation.compose.NavHostKt$NavHost$lambda-4$$inlined$map$1$2$1 r0 = (androidx.navigation.compose.NavHostKt$NavHost$lambda4$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.f36402i
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.f36402i = r1
                    goto L_0x0018
                L_0x0013:
                    androidx.navigation.compose.NavHostKt$NavHost$lambda-4$$inlined$map$1$2$1 r0 = new androidx.navigation.compose.NavHostKt$NavHost$lambda-4$$inlined$map$1$2$1
                    r0.<init>(r7, r9)
                L_0x0018:
                    java.lang.Object r9 = r0.f36401h
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.f36402i
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L_0x006d
                L_0x0029:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L_0x0031:
                    kotlin.ResultKt.throwOnFailure(r9)
                    kotlinx.coroutines.flow.FlowCollector r9 = r3
                    java.util.List r8 = (java.util.List) r8
                    java.lang.Iterable r8 = (java.lang.Iterable) r8
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r2.<init>()
                    java.util.Iterator r8 = r8.iterator()
                L_0x0043:
                    boolean r4 = r8.hasNext()
                    if (r4 == 0) goto L_0x0064
                    java.lang.Object r4 = r8.next()
                    r5 = r4
                    androidx.navigation.NavBackStackEntry r5 = (androidx.navigation.NavBackStackEntry) r5
                    androidx.navigation.NavDestination r5 = r5.getDestination()
                    java.lang.String r5 = r5.getNavigatorName()
                    java.lang.String r6 = "composable"
                    boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
                    if (r5 == 0) goto L_0x0043
                    r2.add(r4)
                    goto L_0x0043
                L_0x0064:
                    r0.f36402i = r3
                    java.lang.Object r8 = r9.emit(r2, r0)
                    if (r8 != r1) goto L_0x006d
                    return r1
                L_0x006d:
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt$NavHost$lambda4$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
