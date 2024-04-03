package kotlin.text;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\t\u0010\u0019\u001a\u00020\u001aH\u0002J\t\u0010\u001b\u001a\u00020\u0002H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006\u001c"}, d2 = {"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DelimitedRangesSequence$iterator$1 implements Iterator<IntRange>, KMappedMarker, j$.util.Iterator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DelimitedRangesSequence f25073b;
    private int counter;
    private int currentStartIndex;
    @Nullable
    private IntRange nextItem;
    private int nextSearchIndex;
    private int nextState = -1;

    public DelimitedRangesSequence$iterator$1(DelimitedRangesSequence delimitedRangesSequence) {
        this.f25073b = delimitedRangesSequence;
        int coerceIn = RangesKt___RangesKt.coerceIn(delimitedRangesSequence.startIndex, 0, delimitedRangesSequence.input.length());
        this.currentStartIndex = coerceIn;
        this.nextSearchIndex = coerceIn;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0021, code lost:
        if (r0 < r6.f25073b.limit) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void calcNext() {
        /*
            r6 = this;
            int r0 = r6.nextSearchIndex
            r1 = 0
            if (r0 >= 0) goto L_0x000c
            r6.nextState = r1
            r0 = 0
            r6.nextItem = r0
            goto L_0x009e
        L_0x000c:
            kotlin.text.DelimitedRangesSequence r0 = r6.f25073b
            int r0 = r0.limit
            r2 = -1
            r3 = 1
            if (r0 <= 0) goto L_0x0023
            int r0 = r6.counter
            int r0 = r0 + r3
            r6.counter = r0
            kotlin.text.DelimitedRangesSequence r4 = r6.f25073b
            int r4 = r4.limit
            if (r0 >= r4) goto L_0x0031
        L_0x0023:
            int r0 = r6.nextSearchIndex
            kotlin.text.DelimitedRangesSequence r4 = r6.f25073b
            java.lang.CharSequence r4 = r4.input
            int r4 = r4.length()
            if (r0 <= r4) goto L_0x0047
        L_0x0031:
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r1 = r6.currentStartIndex
            kotlin.text.DelimitedRangesSequence r4 = r6.f25073b
            java.lang.CharSequence r4 = r4.input
            int r4 = kotlin.text.StringsKt__StringsKt.getLastIndex(r4)
            r0.<init>(r1, r4)
            r6.nextItem = r0
            r6.nextSearchIndex = r2
            goto L_0x009c
        L_0x0047:
            kotlin.text.DelimitedRangesSequence r0 = r6.f25073b
            kotlin.jvm.functions.Function2 r0 = r0.getNextMatch
            kotlin.text.DelimitedRangesSequence r4 = r6.f25073b
            java.lang.CharSequence r4 = r4.input
            int r5 = r6.nextSearchIndex
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object r0 = r0.invoke(r4, r5)
            kotlin.Pair r0 = (kotlin.Pair) r0
            if (r0 != 0) goto L_0x0077
            kotlin.ranges.IntRange r0 = new kotlin.ranges.IntRange
            int r1 = r6.currentStartIndex
            kotlin.text.DelimitedRangesSequence r4 = r6.f25073b
            java.lang.CharSequence r4 = r4.input
            int r4 = kotlin.text.StringsKt__StringsKt.getLastIndex(r4)
            r0.<init>(r1, r4)
            r6.nextItem = r0
            r6.nextSearchIndex = r2
            goto L_0x009c
        L_0x0077:
            java.lang.Object r2 = r0.component1()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.component2()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r4 = r6.currentStartIndex
            kotlin.ranges.IntRange r4 = kotlin.ranges.RangesKt___RangesKt.until((int) r4, (int) r2)
            r6.nextItem = r4
            int r2 = r2 + r0
            r6.currentStartIndex = r2
            if (r0 != 0) goto L_0x0099
            r1 = r3
        L_0x0099:
            int r2 = r2 + r1
            r6.nextSearchIndex = r2
        L_0x009c:
            r6.nextState = r3
        L_0x009e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.DelimitedRangesSequence$iterator$1.calcNext():void");
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final int getCounter() {
        return this.counter;
    }

    public final int getCurrentStartIndex() {
        return this.currentStartIndex;
    }

    @Nullable
    public final IntRange getNextItem() {
        return this.nextItem;
    }

    public final int getNextSearchIndex() {
        return this.nextSearchIndex;
    }

    public final int getNextState() {
        return this.nextState;
    }

    public boolean hasNext() {
        if (this.nextState == -1) {
            calcNext();
        }
        if (this.nextState == 1) {
            return true;
        }
        return false;
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setCounter(int i11) {
        this.counter = i11;
    }

    public final void setCurrentStartIndex(int i11) {
        this.currentStartIndex = i11;
    }

    public final void setNextItem(@Nullable IntRange intRange) {
        this.nextItem = intRange;
    }

    public final void setNextSearchIndex(int i11) {
        this.nextSearchIndex = i11;
    }

    public final void setNextState(int i11) {
        this.nextState = i11;
    }

    @NotNull
    public IntRange next() {
        if (this.nextState == -1) {
            calcNext();
        }
        if (this.nextState != 0) {
            IntRange intRange = this.nextItem;
            Intrinsics.checkNotNull(intRange, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.nextItem = null;
            this.nextState = -1;
            return intRange;
        }
        throw new NoSuchElementException();
    }
}
