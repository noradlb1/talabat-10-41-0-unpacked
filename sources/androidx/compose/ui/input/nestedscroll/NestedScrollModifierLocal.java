package androidx.compose.ui.input.nestedscroll;

import a0.a;
import a0.b;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J)\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b&\u0010'J-\u0010(\u001a\u00020)2\u0006\u0010$\u001a\u00020)2\u0006\u0010%\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-J!\u0010.\u001a\u00020#2\u0006\u0010%\u001a\u00020#H@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b/\u00100J%\u00101\u001a\u00020)2\u0006\u0010%\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R/\u0010\u0015\u001a\u0004\u0018\u00010\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u00008B@BX\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00064"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollModifierLocal;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "connection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "getConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getDispatcher", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "nestedCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getNestedCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "<set-?>", "parent", "getParent", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollModifierLocal;", "setParent", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollModifierLocal;)V", "parent$delegate", "Landroidx/compose/runtime/MutableState;", "value", "getValue", "onModifierLocalsUpdated", "", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NestedScrollModifierLocal implements ModifierLocalConsumer, ModifierLocalProvider<NestedScrollModifierLocal>, NestedScrollConnection {
    @NotNull
    private final NestedScrollConnection connection;
    @NotNull
    private final NestedScrollDispatcher dispatcher;
    @NotNull
    private final MutableState parent$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);

    public NestedScrollModifierLocal(@NotNull NestedScrollDispatcher nestedScrollDispatcher, @NotNull NestedScrollConnection nestedScrollConnection) {
        Intrinsics.checkNotNullParameter(nestedScrollDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(nestedScrollConnection, "connection");
        this.dispatcher = nestedScrollDispatcher;
        this.connection = nestedScrollConnection;
        nestedScrollDispatcher.setCalculateNestedScrollScope$ui_release(new Function0<CoroutineScope>(this) {

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ NestedScrollModifierLocal f9761g;

            {
                this.f9761g = r1;
            }

            @NotNull
            public final CoroutineScope invoke() {
                return this.f9761g.getNestedCoroutineScope();
            }
        });
    }

    /* access modifiers changed from: private */
    public final CoroutineScope getNestedCoroutineScope() {
        CoroutineScope coroutineScope;
        NestedScrollModifierLocal parent = getParent();
        if ((parent != null && (coroutineScope = parent.getNestedCoroutineScope()) != null) || (coroutineScope = this.dispatcher.getOriginNestedScrollScope$ui_release()) != null) {
            return coroutineScope;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    private final NestedScrollModifierLocal getParent() {
        return (NestedScrollModifierLocal) this.parent$delegate.getValue();
    }

    private final void setParent(NestedScrollModifierLocal nestedScrollModifierLocal) {
        this.parent$delegate.setValue(nestedScrollModifierLocal);
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return b.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return b.d(this, obj, function2);
    }

    @NotNull
    public final NestedScrollConnection getConnection() {
        return this.connection;
    }

    @NotNull
    public final NestedScrollDispatcher getDispatcher() {
        return this.dispatcher;
    }

    @NotNull
    public ProvidableModifierLocal<NestedScrollModifierLocal> getKey() {
        return NestedScrollModifierLocalKt.getModifierLocalNestedScroll();
    }

    @NotNull
    public NestedScrollModifierLocal getValue() {
        return this;
    }

    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope modifierLocalReadScope) {
        Intrinsics.checkNotNullParameter(modifierLocalReadScope, "scope");
        setParent((NestedScrollModifierLocal) modifierLocalReadScope.getCurrent(NestedScrollModifierLocalKt.getModifierLocalNestedScroll()));
        this.dispatcher.setParent$ui_release(getParent());
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: onPostFling-RZ2iAVY  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m4206onPostFlingRZ2iAVY(long r16, long r18, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r20) {
        /*
            r15 = this;
            r0 = r15
            r1 = r20
            boolean r2 = r1 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal$onPostFling$1
            if (r2 == 0) goto L_0x0016
            r2 = r1
            androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal$onPostFling$1 r2 = (androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal$onPostFling$1) r2
            int r3 = r2.f9767m
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0016
            int r3 = r3 - r4
            r2.f9767m = r3
            goto L_0x001b
        L_0x0016:
            androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal$onPostFling$1 r2 = new androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal$onPostFling$1
            r2.<init>(r15, r1)
        L_0x001b:
            java.lang.Object r1 = r2.f9765k
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.f9767m
            r10 = 2
            r4 = 1
            if (r3 == 0) goto L_0x0047
            if (r3 == r4) goto L_0x0039
            if (r3 != r10) goto L_0x0031
            long r2 = r2.f9763i
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x008c
        L_0x0031:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0039:
            long r3 = r2.f9764j
            long r5 = r2.f9763i
            java.lang.Object r7 = r2.f9762h
            androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal r7 = (androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal) r7
            kotlin.ResultKt.throwOnFailure(r1)
            r13 = r3
            r11 = r5
            goto L_0x0065
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r1)
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r3 = r0.connection
            r2.f9762h = r0
            r11 = r16
            r2.f9763i = r11
            r13 = r18
            r2.f9764j = r13
            r2.f9767m = r4
            r4 = r16
            r6 = r18
            r8 = r2
            java.lang.Object r1 = r3.m4194onPostFlingRZ2iAVY(r4, r6, r8)
            if (r1 != r9) goto L_0x0064
            return r9
        L_0x0064:
            r7 = r0
        L_0x0065:
            androidx.compose.ui.unit.Velocity r1 = (androidx.compose.ui.unit.Velocity) r1
            long r4 = r1.m5712unboximpl()
            androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal r3 = r7.getParent()
            if (r3 == 0) goto L_0x0094
            long r6 = androidx.compose.ui.unit.Velocity.m5707plusAH228Gc(r11, r4)
            long r11 = androidx.compose.ui.unit.Velocity.m5706minusAH228Gc(r13, r4)
            r1 = 0
            r2.f9762h = r1
            r2.f9763i = r4
            r2.f9767m = r10
            r13 = r4
            r4 = r6
            r6 = r11
            r8 = r2
            java.lang.Object r1 = r3.m4206onPostFlingRZ2iAVY(r4, r6, r8)
            if (r1 != r9) goto L_0x008b
            return r9
        L_0x008b:
            r2 = r13
        L_0x008c:
            androidx.compose.ui.unit.Velocity r1 = (androidx.compose.ui.unit.Velocity) r1
            long r4 = r1.m5712unboximpl()
            r13 = r2
            goto L_0x009b
        L_0x0094:
            r13 = r4
            androidx.compose.ui.unit.Velocity$Companion r1 = androidx.compose.ui.unit.Velocity.Companion
            long r4 = r1.m5714getZero9UxMQ8M()
        L_0x009b:
            long r1 = androidx.compose.ui.unit.Velocity.m5707plusAH228Gc(r13, r4)
            androidx.compose.ui.unit.Velocity r1 = androidx.compose.ui.unit.Velocity.m5694boximpl(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal.m4206onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: onPostScroll-DzOQY0M  reason: not valid java name */
    public long m4207onPostScrollDzOQY0M(long j11, long j12, int i11) {
        long j13;
        long r02 = this.connection.m4195onPostScrollDzOQY0M(j11, j12, i11);
        NestedScrollModifierLocal parent = getParent();
        if (parent != null) {
            j13 = parent.m4207onPostScrollDzOQY0M(Offset.m2681plusMKHz9U(j11, r02), Offset.m2680minusMKHz9U(j12, r02), i11);
        } else {
            j13 = Offset.Companion.m2692getZeroF1C5BW0();
        }
        return Offset.m2681plusMKHz9U(r02, j13);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: onPreFling-QWom1Mo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object m4208onPreFlingQWom1Mo(long r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal$onPreFling$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal$onPreFling$1 r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal$onPreFling$1) r0
            int r1 = r0.f9772l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f9772l = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal$onPreFling$1 r0 = new androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal$onPreFling$1
            r0.<init>(r8, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f9770j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f9772l
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r4) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            long r9 = r0.f9769i
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x007c
        L_0x002e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0036:
            long r9 = r0.f9769i
            java.lang.Object r2 = r0.f9768h
            androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal r2 = (androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0057
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r11)
            androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal r11 = r8.getParent()
            if (r11 == 0) goto L_0x005e
            r0.f9768h = r8
            r0.f9769i = r9
            r0.f9772l = r4
            java.lang.Object r11 = r11.m4208onPreFlingQWom1Mo(r9, r0)
            if (r11 != r1) goto L_0x0056
            return r1
        L_0x0056:
            r2 = r8
        L_0x0057:
            androidx.compose.ui.unit.Velocity r11 = (androidx.compose.ui.unit.Velocity) r11
            long r4 = r11.m5712unboximpl()
            goto L_0x0065
        L_0x005e:
            androidx.compose.ui.unit.Velocity$Companion r11 = androidx.compose.ui.unit.Velocity.Companion
            long r4 = r11.m5714getZero9UxMQ8M()
            r2 = r8
        L_0x0065:
            r6 = r9
            r9 = r4
            r4 = r6
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r11 = r2.connection
            long r4 = androidx.compose.ui.unit.Velocity.m5706minusAH228Gc(r4, r9)
            r2 = 0
            r0.f9768h = r2
            r0.f9769i = r9
            r0.f9772l = r3
            java.lang.Object r11 = r11.m4196onPreFlingQWom1Mo(r4, r0)
            if (r11 != r1) goto L_0x007c
            return r1
        L_0x007c:
            androidx.compose.ui.unit.Velocity r11 = (androidx.compose.ui.unit.Velocity) r11
            long r0 = r11.m5712unboximpl()
            long r9 = androidx.compose.ui.unit.Velocity.m5707plusAH228Gc(r9, r0)
            androidx.compose.ui.unit.Velocity r9 = androidx.compose.ui.unit.Velocity.m5694boximpl(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal.m4208onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: onPreScroll-OzD1aCk  reason: not valid java name */
    public long m4209onPreScrollOzD1aCk(long j11, int i11) {
        long j12;
        NestedScrollModifierLocal parent = getParent();
        if (parent != null) {
            j12 = parent.m4209onPreScrollOzD1aCk(j11, i11);
        } else {
            j12 = Offset.Companion.m2692getZeroF1C5BW0();
        }
        return Offset.m2681plusMKHz9U(j12, this.connection.m4197onPreScrollOzD1aCk(Offset.m2680minusMKHz9U(j11, j12), i11));
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }
}
