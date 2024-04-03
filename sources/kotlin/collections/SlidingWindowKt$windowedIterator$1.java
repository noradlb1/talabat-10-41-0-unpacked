package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H@"}, d2 = {"T", "Lkotlin/sequences/SequenceScope;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 2, 2, 3, 3}, l = {34, 40, 49, 55, 58}, m = "invokeSuspend", n = {"$this$iterator", "buffer", "gap", "$this$iterator", "buffer", "$this$iterator", "buffer"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$0", "L$1"})
public final class SlidingWindowKt$windowedIterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f23808h;

    /* renamed from: i  reason: collision with root package name */
    public Object f23809i;

    /* renamed from: j  reason: collision with root package name */
    public int f23810j;

    /* renamed from: k  reason: collision with root package name */
    public int f23811k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f23812l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ int f23813m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ Iterator<T> f23814n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f23815o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ boolean f23816p;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SlidingWindowKt$windowedIterator$1(int i11, int i12, Iterator<? extends T> it, boolean z11, boolean z12, Continuation<? super SlidingWindowKt$windowedIterator$1> continuation) {
        super(2, continuation);
        this.f23812l = i11;
        this.f23813m = i12;
        this.f23814n = it;
        this.f23815o = z11;
        this.f23816p = z12;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.f23812l, this.f23813m, this.f23814n, this.f23815o, this.f23816p, continuation);
        slidingWindowKt$windowedIterator$1.L$0 = obj;
        return slidingWindowKt$windowedIterator$1;
    }

    @Nullable
    public final Object invoke(@NotNull SequenceScope<? super List<? extends T>> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SlidingWindowKt$windowedIterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0126 A[SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.f23811k
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r1 == 0) goto L_0x005a
            if (r1 == r6) goto L_0x0046
            if (r1 == r5) goto L_0x0041
            if (r1 == r4) goto L_0x002f
            if (r1 == r3) goto L_0x0021
            if (r1 != r2) goto L_0x0019
            goto L_0x0041
        L_0x0019:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0021:
            java.lang.Object r1 = r11.f23808h
            kotlin.collections.RingBuffer r1 = (kotlin.collections.RingBuffer) r1
            java.lang.Object r4 = r11.L$0
            kotlin.sequences.SequenceScope r4 = (kotlin.sequences.SequenceScope) r4
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r11
            goto L_0x014e
        L_0x002f:
            java.lang.Object r1 = r11.f23809i
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r5 = r11.f23808h
            kotlin.collections.RingBuffer r5 = (kotlin.collections.RingBuffer) r5
            java.lang.Object r8 = r11.L$0
            kotlin.sequences.SequenceScope r8 = (kotlin.sequences.SequenceScope) r8
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r11
            goto L_0x0120
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x016a
        L_0x0046:
            int r1 = r11.f23810j
            java.lang.Object r2 = r11.f23809i
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r3 = r11.f23808h
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            java.lang.Object r4 = r11.L$0
            kotlin.sequences.SequenceScope r4 = (kotlin.sequences.SequenceScope) r4
            kotlin.ResultKt.throwOnFailure(r12)
            r8 = r11
        L_0x0058:
            r12 = r1
            goto L_0x00a9
        L_0x005a:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            kotlin.sequences.SequenceScope r12 = (kotlin.sequences.SequenceScope) r12
            int r1 = r11.f23812l
            r8 = 1024(0x400, float:1.435E-42)
            int r1 = kotlin.ranges.RangesKt___RangesKt.coerceAtMost((int) r1, (int) r8)
            int r8 = r11.f23813m
            int r9 = r11.f23812l
            int r8 = r8 - r9
            if (r8 < 0) goto L_0x00dd
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r1)
            java.util.Iterator<T> r1 = r11.f23814n
            r3 = 0
            r4 = r12
            r12 = r3
            r3 = r2
            r2 = r1
            r1 = r8
            r8 = r11
        L_0x007e:
            boolean r9 = r2.hasNext()
            if (r9 == 0) goto L_0x00bb
            java.lang.Object r9 = r2.next()
            if (r12 <= 0) goto L_0x008d
            int r12 = r12 + -1
            goto L_0x007e
        L_0x008d:
            r3.add(r9)
            int r9 = r3.size()
            int r10 = r8.f23812l
            if (r9 != r10) goto L_0x007e
            r8.L$0 = r4
            r8.f23808h = r3
            r8.f23809i = r2
            r8.f23810j = r1
            r8.f23811k = r6
            java.lang.Object r12 = r4.yield(r3, r8)
            if (r12 != r0) goto L_0x0058
            return r0
        L_0x00a9:
            boolean r1 = r8.f23815o
            if (r1 == 0) goto L_0x00b1
            r3.clear()
            goto L_0x00b9
        L_0x00b1:
            java.util.ArrayList r1 = new java.util.ArrayList
            int r3 = r8.f23812l
            r1.<init>(r3)
            r3 = r1
        L_0x00b9:
            r1 = r12
            goto L_0x007e
        L_0x00bb:
            boolean r12 = r3.isEmpty()
            r12 = r12 ^ r6
            if (r12 == 0) goto L_0x016a
            boolean r12 = r8.f23816p
            if (r12 != 0) goto L_0x00ce
            int r12 = r3.size()
            int r1 = r8.f23812l
            if (r12 != r1) goto L_0x016a
        L_0x00ce:
            r8.L$0 = r7
            r8.f23808h = r7
            r8.f23809i = r7
            r8.f23811k = r5
            java.lang.Object r12 = r4.yield(r3, r8)
            if (r12 != r0) goto L_0x016a
            return r0
        L_0x00dd:
            kotlin.collections.RingBuffer r5 = new kotlin.collections.RingBuffer
            r5.<init>(r1)
            java.util.Iterator<T> r1 = r11.f23814n
            r8 = r12
            r12 = r11
        L_0x00e6:
            boolean r9 = r1.hasNext()
            if (r9 == 0) goto L_0x0126
            java.lang.Object r9 = r1.next()
            r5.add(r9)
            boolean r9 = r5.isFull()
            if (r9 == 0) goto L_0x00e6
            int r9 = r5.size()
            int r10 = r12.f23812l
            if (r9 >= r10) goto L_0x0106
            kotlin.collections.RingBuffer r5 = r5.expanded(r10)
            goto L_0x00e6
        L_0x0106:
            boolean r9 = r12.f23815o
            if (r9 == 0) goto L_0x010c
            r9 = r5
            goto L_0x0111
        L_0x010c:
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>(r5)
        L_0x0111:
            r12.L$0 = r8
            r12.f23808h = r5
            r12.f23809i = r1
            r12.f23811k = r4
            java.lang.Object r9 = r8.yield(r9, r12)
            if (r9 != r0) goto L_0x0120
            return r0
        L_0x0120:
            int r9 = r12.f23813m
            r5.removeFirst(r9)
            goto L_0x00e6
        L_0x0126:
            boolean r1 = r12.f23816p
            if (r1 == 0) goto L_0x016a
            r1 = r5
            r4 = r8
        L_0x012c:
            int r5 = r1.size()
            int r8 = r12.f23813m
            if (r5 <= r8) goto L_0x0154
            boolean r5 = r12.f23815o
            if (r5 == 0) goto L_0x013a
            r5 = r1
            goto L_0x013f
        L_0x013a:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>(r1)
        L_0x013f:
            r12.L$0 = r4
            r12.f23808h = r1
            r12.f23809i = r7
            r12.f23811k = r3
            java.lang.Object r5 = r4.yield(r5, r12)
            if (r5 != r0) goto L_0x014e
            return r0
        L_0x014e:
            int r5 = r12.f23813m
            r1.removeFirst(r5)
            goto L_0x012c
        L_0x0154:
            boolean r3 = r1.isEmpty()
            r3 = r3 ^ r6
            if (r3 == 0) goto L_0x016a
            r12.L$0 = r7
            r12.f23808h = r7
            r12.f23809i = r7
            r12.f23811k = r2
            java.lang.Object r12 = r4.yield(r1, r12)
            if (r12 != r0) goto L_0x016a
            return r0
        L_0x016a:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.collections.SlidingWindowKt$windowedIterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
