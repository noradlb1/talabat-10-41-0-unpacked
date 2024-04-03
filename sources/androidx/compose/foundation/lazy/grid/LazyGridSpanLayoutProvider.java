package androidx.compose.foundation.lazy.grid;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0003+,-B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u001e\u001a\u00020\u0006H\u0002ø\u0001\u0000J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0006J\u001e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\b\u0010'\u001a\u00020(H\u0002J\u0018\u0010)\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\u0006H\u0002R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u000eø\u0001\u0000¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\b\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006."}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;", "(Landroidx/compose/foundation/lazy/grid/LazyGridItemProvider;)V", "bucketSize", "", "getBucketSize", "()I", "buckets", "Ljava/util/ArrayList;", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$Bucket;", "Lkotlin/collections/ArrayList;", "cachedBucket", "", "cachedBucketIndex", "lastLineIndex", "lastLineStartItemIndex", "lastLineStartKnownSpan", "previousDefaultSpans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "value", "slotsPerLine", "getSlotsPerLine", "setSlotsPerLine", "(I)V", "totalSize", "getTotalSize", "getDefaultSpans", "currentSlotsPerLine", "getLineConfiguration", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LineConfiguration;", "lineIndex", "getLineIndexOfItem", "Landroidx/compose/foundation/lazy/grid/LineIndex;", "itemIndex", "getLineIndexOfItem--_Ze7BM", "(I)I", "invalidateCache", "", "spanOf", "maxSpan", "Bucket", "LazyGridItemSpanScopeImpl", "LineConfiguration", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LazyGridSpanLayoutProvider {
    @NotNull
    private final ArrayList<Bucket> buckets;
    @NotNull
    private final List<Integer> cachedBucket = new ArrayList();
    private int cachedBucketIndex = -1;
    @NotNull
    private final LazyGridItemProvider itemProvider;
    private int lastLineIndex;
    private int lastLineStartItemIndex;
    private int lastLineStartKnownSpan;
    @NotNull
    private List<GridItemSpan> previousDefaultSpans = CollectionsKt__CollectionsKt.emptyList();
    private int slotsPerLine;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LazyGridItemSpanScopeImpl;", "Landroidx/compose/foundation/lazy/grid/LazyGridItemSpanScope;", "()V", "maxCurrentLineSpan", "", "getMaxCurrentLineSpan", "()I", "setMaxCurrentLineSpan", "(I)V", "maxLineSpan", "getMaxLineSpan", "setMaxLineSpan", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class LazyGridItemSpanScopeImpl implements LazyGridItemSpanScope {
        @NotNull
        public static final LazyGridItemSpanScopeImpl INSTANCE = new LazyGridItemSpanScopeImpl();
        private static int maxCurrentLineSpan;
        private static int maxLineSpan;

        private LazyGridItemSpanScopeImpl() {
        }

        public int getMaxCurrentLineSpan() {
            return maxCurrentLineSpan;
        }

        public int getMaxLineSpan() {
            return maxLineSpan;
        }

        public void setMaxCurrentLineSpan(int i11) {
            maxCurrentLineSpan = i11;
        }

        public void setMaxLineSpan(int i11) {
            maxLineSpan = i11;
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001e\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$LineConfiguration;", "", "firstItemIndex", "", "spans", "", "Landroidx/compose/foundation/lazy/grid/GridItemSpan;", "(ILjava/util/List;)V", "getFirstItemIndex", "()I", "getSpans", "()Ljava/util/List;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class LineConfiguration {
        public static final int $stable = 8;
        private final int firstItemIndex;
        @NotNull
        private final List<GridItemSpan> spans;

        public LineConfiguration(int i11, @NotNull List<GridItemSpan> list) {
            Intrinsics.checkNotNullParameter(list, "spans");
            this.firstItemIndex = i11;
            this.spans = list;
        }

        public final int getFirstItemIndex() {
            return this.firstItemIndex;
        }

        @NotNull
        public final List<GridItemSpan> getSpans() {
            return this.spans;
        }
    }

    public LazyGridSpanLayoutProvider(@NotNull LazyGridItemProvider lazyGridItemProvider) {
        Intrinsics.checkNotNullParameter(lazyGridItemProvider, "itemProvider");
        this.itemProvider = lazyGridItemProvider;
        ArrayList<Bucket> arrayList = new ArrayList<>();
        arrayList.add(new Bucket(0, 0, 2, (DefaultConstructorMarker) null));
        this.buckets = arrayList;
    }

    private final int getBucketSize() {
        return ((int) Math.sqrt((((double) getTotalSize()) * 1.0d) / ((double) this.slotsPerLine))) + 1;
    }

    private final List<GridItemSpan> getDefaultSpans(int i11) {
        if (i11 == this.previousDefaultSpans.size()) {
            return this.previousDefaultSpans;
        }
        ArrayList arrayList = new ArrayList(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            arrayList.add(GridItemSpan.m656boximpl(LazyGridSpanKt.GridItemSpan(1)));
        }
        this.previousDefaultSpans = arrayList;
        return arrayList;
    }

    private final void invalidateCache() {
        this.buckets.clear();
        this.buckets.add(new Bucket(0, 0, 2, (DefaultConstructorMarker) null));
        this.lastLineIndex = 0;
        this.lastLineStartItemIndex = 0;
        this.cachedBucketIndex = -1;
        this.cachedBucket.clear();
    }

    private final int spanOf(int i11, int i12) {
        LazyGridItemProvider lazyGridItemProvider = this.itemProvider;
        LazyGridItemSpanScopeImpl lazyGridItemSpanScopeImpl = LazyGridItemSpanScopeImpl.INSTANCE;
        lazyGridItemSpanScopeImpl.setMaxCurrentLineSpan(i12);
        lazyGridItemSpanScopeImpl.setMaxLineSpan(this.slotsPerLine);
        return RangesKt___RangesKt.coerceIn(GridItemSpan.m660getCurrentLineSpanimpl(lazyGridItemProvider.m691getSpan_orMbw(lazyGridItemSpanScopeImpl, i11)), 1, this.slotsPerLine);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ae A[LOOP:0: B:33:0x00ae->B:76:0x00ae, LOOP_START, PHI: r2 r4 r5 
      PHI: (r2v6 int) = (r2v5 int), (r2v10 int) binds: [B:32:0x00ac, B:76:0x00ae] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r4v5 int) = (r4v4 int), (r4v6 int) binds: [B:32:0x00ac, B:76:0x00ae] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r5v5 int) = (r5v4 int), (r5v13 int) binds: [B:32:0x00ac, B:76:0x00ae] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x015b  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider.LineConfiguration getLineConfiguration(int r12) {
        /*
            r11 = this;
            androidx.compose.foundation.lazy.grid.LazyGridItemProvider r0 = r11.itemProvider
            boolean r0 = r0.getHasCustomSpans()
            r1 = 0
            if (r0 != 0) goto L_0x0025
            int r0 = r11.slotsPerLine
            int r12 = r12 * r0
            androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$LineConfiguration r0 = new androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$LineConfiguration
            int r2 = r11.slotsPerLine
            int r3 = r11.getTotalSize()
            int r3 = r3 - r12
            int r2 = kotlin.ranges.RangesKt___RangesKt.coerceAtMost((int) r2, (int) r3)
            int r1 = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast((int) r2, (int) r1)
            java.util.List r1 = r11.getDefaultSpans(r1)
            r0.<init>(r12, r1)
            return r0
        L_0x0025:
            int r0 = r11.getBucketSize()
            int r0 = r12 / r0
            java.util.ArrayList<androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket> r2 = r11.buckets
            int r2 = r2.size()
            r3 = 1
            int r2 = r2 - r3
            int r0 = java.lang.Math.min(r0, r2)
            int r2 = r11.getBucketSize()
            int r2 = r2 * r0
            java.util.ArrayList<androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket> r4 = r11.buckets
            java.lang.Object r4 = r4.get(r0)
            androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket r4 = (androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider.Bucket) r4
            int r4 = r4.getFirstItemIndex()
            java.util.ArrayList<androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket> r5 = r11.buckets
            java.lang.Object r5 = r5.get(r0)
            androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket r5 = (androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider.Bucket) r5
            int r5 = r5.getFirstItemKnownSpan()
            int r6 = r11.lastLineIndex
            if (r2 > r6) goto L_0x005c
            if (r6 > r12) goto L_0x005c
            r7 = r3
            goto L_0x005d
        L_0x005c:
            r7 = r1
        L_0x005d:
            if (r7 == 0) goto L_0x0065
            int r4 = r11.lastLineStartItemIndex
            int r5 = r11.lastLineStartKnownSpan
            r2 = r6
            goto L_0x0081
        L_0x0065:
            int r6 = r11.cachedBucketIndex
            if (r0 != r6) goto L_0x0081
            int r6 = r12 - r2
            java.util.List<java.lang.Integer> r7 = r11.cachedBucket
            int r7 = r7.size()
            if (r6 >= r7) goto L_0x0081
            java.util.List<java.lang.Integer> r2 = r11.cachedBucket
            java.lang.Object r2 = r2.get(r6)
            java.lang.Number r2 = (java.lang.Number) r2
            int r4 = r2.intValue()
            r2 = r12
            r5 = r1
        L_0x0081:
            int r6 = r11.getBucketSize()
            int r6 = r2 % r6
            if (r6 != 0) goto L_0x009b
            int r6 = r11.getBucketSize()
            int r7 = r12 - r2
            r8 = 2
            if (r8 > r7) goto L_0x0096
            if (r7 >= r6) goto L_0x0096
            r6 = r3
            goto L_0x0097
        L_0x0096:
            r6 = r1
        L_0x0097:
            if (r6 == 0) goto L_0x009b
            r6 = r3
            goto L_0x009c
        L_0x009b:
            r6 = r1
        L_0x009c:
            if (r6 == 0) goto L_0x00a5
            r11.cachedBucketIndex = r0
            java.util.List<java.lang.Integer> r0 = r11.cachedBucket
            r0.clear()
        L_0x00a5:
            if (r2 > r12) goto L_0x00a9
            r0 = r3
            goto L_0x00aa
        L_0x00a9:
            r0 = r1
        L_0x00aa:
            java.lang.String r7 = "Check failed."
            if (r0 == 0) goto L_0x015b
        L_0x00ae:
            if (r2 >= r12) goto L_0x011c
            int r0 = r11.getTotalSize()
            if (r4 >= r0) goto L_0x011c
            if (r6 == 0) goto L_0x00c1
            java.util.List<java.lang.Integer> r0 = r11.cachedBucket
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)
            r0.add(r8)
        L_0x00c1:
            r0 = r1
        L_0x00c2:
            int r8 = r11.slotsPerLine
            if (r0 >= r8) goto L_0x00e4
            int r8 = r11.getTotalSize()
            if (r4 >= r8) goto L_0x00e4
            if (r5 != 0) goto L_0x00d9
            int r8 = r11.slotsPerLine
            int r8 = r8 - r0
            int r8 = r11.spanOf(r4, r8)
            r10 = r8
            r8 = r5
            r5 = r10
            goto L_0x00da
        L_0x00d9:
            r8 = r1
        L_0x00da:
            int r0 = r0 + r5
            int r9 = r11.slotsPerLine
            if (r0 <= r9) goto L_0x00e0
            goto L_0x00e4
        L_0x00e0:
            int r4 = r4 + 1
            r5 = r8
            goto L_0x00c2
        L_0x00e4:
            int r2 = r2 + 1
            int r0 = r11.getBucketSize()
            int r0 = r2 % r0
            if (r0 != 0) goto L_0x00ae
            int r0 = r11.getTotalSize()
            if (r4 >= r0) goto L_0x00ae
            int r0 = r11.getBucketSize()
            int r0 = r2 / r0
            java.util.ArrayList<androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket> r8 = r11.buckets
            int r8 = r8.size()
            if (r8 != r0) goto L_0x0104
            r0 = r3
            goto L_0x0105
        L_0x0104:
            r0 = r1
        L_0x0105:
            if (r0 == 0) goto L_0x0112
            java.util.ArrayList<androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket> r0 = r11.buckets
            androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket r8 = new androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$Bucket
            r8.<init>(r4, r5)
            r0.add(r8)
            goto L_0x00ae
        L_0x0112:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = r7.toString()
            r12.<init>(r0)
            throw r12
        L_0x011c:
            r11.lastLineIndex = r12
            r11.lastLineStartItemIndex = r4
            r11.lastLineStartKnownSpan = r5
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            r0 = r1
            r2 = r4
        L_0x0129:
            int r3 = r11.slotsPerLine
            if (r0 >= r3) goto L_0x0155
            int r3 = r11.getTotalSize()
            if (r2 >= r3) goto L_0x0155
            if (r5 != 0) goto L_0x0140
            int r3 = r11.slotsPerLine
            int r3 = r3 - r0
            int r3 = r11.spanOf(r2, r3)
            r10 = r5
            r5 = r3
            r3 = r10
            goto L_0x0141
        L_0x0140:
            r3 = r1
        L_0x0141:
            int r0 = r0 + r5
            int r6 = r11.slotsPerLine
            if (r0 > r6) goto L_0x0155
            int r2 = r2 + 1
            long r5 = androidx.compose.foundation.lazy.grid.LazyGridSpanKt.GridItemSpan(r5)
            androidx.compose.foundation.lazy.grid.GridItemSpan r5 = androidx.compose.foundation.lazy.grid.GridItemSpan.m656boximpl(r5)
            r12.add(r5)
            r5 = r3
            goto L_0x0129
        L_0x0155:
            androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$LineConfiguration r0 = new androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$LineConfiguration
            r0.<init>(r4, r12)
            return r0
        L_0x015b:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = r7.toString()
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider.getLineConfiguration(int):androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider$LineConfiguration");
    }

    /* renamed from: getLineIndexOfItem--_Ze7BM  reason: not valid java name */
    public final int m712getLineIndexOfItem_Ze7BM(int i11) {
        boolean z11;
        boolean z12;
        int i12;
        if (getTotalSize() <= 0) {
            return LineIndex.m722constructorimpl(0);
        }
        if (i11 < getTotalSize()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!this.itemProvider.getHasCustomSpans()) {
            return LineIndex.m722constructorimpl(i11 / this.slotsPerLine);
        } else {
            int binarySearch$default = CollectionsKt__CollectionsKt.binarySearch$default((List) this.buckets, 0, 0, (Function1) new LazyGridSpanLayoutProvider$getLineIndexOfItem$lowerBoundBucket$1(i11), 3, (Object) null);
            if (binarySearch$default < 0) {
                binarySearch$default = (-binarySearch$default) - 2;
            }
            int bucketSize = getBucketSize() * binarySearch$default;
            int firstItemIndex = this.buckets.get(binarySearch$default).getFirstItemIndex();
            if (firstItemIndex <= i11) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                int i13 = 0;
                while (firstItemIndex < i11) {
                    int i14 = firstItemIndex + 1;
                    int spanOf = spanOf(firstItemIndex, this.slotsPerLine - i13);
                    i13 += spanOf;
                    int i15 = this.slotsPerLine;
                    if (i13 >= i15) {
                        if (i13 == i15) {
                            bucketSize++;
                            i13 = 0;
                        } else {
                            bucketSize++;
                            i13 = spanOf;
                        }
                    }
                    if (bucketSize % getBucketSize() == 0 && bucketSize / getBucketSize() >= this.buckets.size()) {
                        ArrayList<Bucket> arrayList = this.buckets;
                        if (i13 > 0) {
                            i12 = 1;
                        } else {
                            i12 = 0;
                        }
                        arrayList.add(new Bucket(i14 - i12, 0, 2, (DefaultConstructorMarker) null));
                    }
                    firstItemIndex = i14;
                }
                if (i13 + spanOf(i11, this.slotsPerLine - i13) > this.slotsPerLine) {
                    bucketSize++;
                }
                return LineIndex.m722constructorimpl(bucketSize);
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public final int getSlotsPerLine() {
        return this.slotsPerLine;
    }

    public final int getTotalSize() {
        return this.itemProvider.getItemCount();
    }

    public final void setSlotsPerLine(int i11) {
        if (i11 != this.slotsPerLine) {
            this.slotsPerLine = i11;
            invalidateCache();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider$Bucket;", "", "firstItemIndex", "", "firstItemKnownSpan", "(II)V", "getFirstItemIndex", "()I", "getFirstItemKnownSpan", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Bucket {
        private final int firstItemIndex;
        private final int firstItemKnownSpan;

        public Bucket(int i11, int i12) {
            this.firstItemIndex = i11;
            this.firstItemKnownSpan = i12;
        }

        public final int getFirstItemIndex() {
            return this.firstItemIndex;
        }

        public final int getFirstItemKnownSpan() {
            return this.firstItemKnownSpan;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Bucket(int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
            this(i11, (i13 & 2) != 0 ? 0 : i12);
        }
    }
}
