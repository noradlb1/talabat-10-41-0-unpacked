package androidx.paging;

import androidx.paging.ViewportHint;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\b\u0018\u0000 &*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001&B\u001d\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007B3\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\fJ\t\u0010\u0014\u001a\u00020\tHÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0004HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006HÆ\u0003JE\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\b\b\u0002\u0010\n\u001a\u00020\u00042\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J.\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0004R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006'"}, d2 = {"Landroidx/paging/TransformablePage;", "T", "", "originalPageOffset", "", "data", "", "(ILjava/util/List;)V", "originalPageOffsets", "", "hintOriginalPageOffset", "hintOriginalIndices", "([ILjava/util/List;ILjava/util/List;)V", "getData", "()Ljava/util/List;", "getHintOriginalIndices", "getHintOriginalPageOffset", "()I", "getOriginalPageOffsets", "()[I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "viewportHintFor", "Landroidx/paging/ViewportHint$Access;", "index", "presentedItemsBefore", "presentedItemsAfter", "originalPageOffsetFirst", "originalPageOffsetLast", "Companion", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class TransformablePage<T> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final TransformablePage<Object> EMPTY_INITIAL_PAGE = new TransformablePage<>(0, CollectionsKt__CollectionsKt.emptyList());
    @NotNull
    private final List<T> data;
    @Nullable
    private final List<Integer> hintOriginalIndices;
    private final int hintOriginalPageOffset;
    @NotNull
    private final int[] originalPageOffsets;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004\"\b\b\u0001\u0010\b*\u00020\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Landroidx/paging/TransformablePage$Companion;", "", "()V", "EMPTY_INITIAL_PAGE", "Landroidx/paging/TransformablePage;", "getEMPTY_INITIAL_PAGE", "()Landroidx/paging/TransformablePage;", "empty", "T", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final <T> TransformablePage<T> empty() {
            TransformablePage<Object> empty_initial_page = getEMPTY_INITIAL_PAGE();
            if (empty_initial_page != null) {
                return empty_initial_page;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.paging.TransformablePage<T>");
        }

        @NotNull
        public final TransformablePage<Object> getEMPTY_INITIAL_PAGE() {
            return TransformablePage.EMPTY_INITIAL_PAGE;
        }
    }

    public TransformablePage(@NotNull int[] iArr, @NotNull List<? extends T> list, int i11, @Nullable List<Integer> list2) {
        Intrinsics.checkNotNullParameter(iArr, "originalPageOffsets");
        Intrinsics.checkNotNullParameter(list, "data");
        this.originalPageOffsets = iArr;
        this.data = list;
        this.hintOriginalPageOffset = i11;
        this.hintOriginalIndices = list2;
        boolean z11 = false;
        if (!(iArr.length == 0)) {
            if (!((list2 == null || list2.size() == list.size()) ? true : z11)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("If originalIndices (size = ");
                Intrinsics.checkNotNull(list2);
                sb2.append(list2.size());
                sb2.append(") is provided,");
                sb2.append(" it must be same length as data (size = ");
                sb2.append(list.size());
                sb2.append(')');
                throw new IllegalArgumentException(sb2.toString().toString());
            }
            return;
        }
        throw new IllegalArgumentException("originalPageOffsets cannot be empty when constructing TransformablePage".toString());
    }

    public static /* synthetic */ TransformablePage copy$default(TransformablePage transformablePage, int[] iArr, List<T> list, int i11, List<Integer> list2, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            iArr = transformablePage.originalPageOffsets;
        }
        if ((i12 & 2) != 0) {
            list = transformablePage.data;
        }
        if ((i12 & 4) != 0) {
            i11 = transformablePage.hintOriginalPageOffset;
        }
        if ((i12 & 8) != 0) {
            list2 = transformablePage.hintOriginalIndices;
        }
        return transformablePage.copy(iArr, list, i11, list2);
    }

    @NotNull
    public final int[] component1() {
        return this.originalPageOffsets;
    }

    @NotNull
    public final List<T> component2() {
        return this.data;
    }

    public final int component3() {
        return this.hintOriginalPageOffset;
    }

    @Nullable
    public final List<Integer> component4() {
        return this.hintOriginalIndices;
    }

    @NotNull
    public final TransformablePage<T> copy(@NotNull int[] iArr, @NotNull List<? extends T> list, int i11, @Nullable List<Integer> list2) {
        Intrinsics.checkNotNullParameter(iArr, "originalPageOffsets");
        Intrinsics.checkNotNullParameter(list, "data");
        return new TransformablePage<>(iArr, list, i11, list2);
    }

    public boolean equals(@Nullable Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        Class<TransformablePage> cls2 = TransformablePage.class;
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual((Object) cls2, (Object) cls)) {
            return false;
        }
        if (obj != null) {
            TransformablePage transformablePage = (TransformablePage) obj;
            if (Arrays.equals(this.originalPageOffsets, transformablePage.originalPageOffsets) && !(!Intrinsics.areEqual((Object) this.data, (Object) transformablePage.data)) && this.hintOriginalPageOffset == transformablePage.hintOriginalPageOffset && !(!Intrinsics.areEqual((Object) this.hintOriginalIndices, (Object) transformablePage.hintOriginalIndices))) {
                return true;
            }
            return false;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.paging.TransformablePage<*>");
    }

    @NotNull
    public final List<T> getData() {
        return this.data;
    }

    @Nullable
    public final List<Integer> getHintOriginalIndices() {
        return this.hintOriginalIndices;
    }

    public final int getHintOriginalPageOffset() {
        return this.hintOriginalPageOffset;
    }

    @NotNull
    public final int[] getOriginalPageOffsets() {
        return this.originalPageOffsets;
    }

    public int hashCode() {
        int i11;
        int hashCode = ((((Arrays.hashCode(this.originalPageOffsets) * 31) + this.data.hashCode()) * 31) + this.hintOriginalPageOffset) * 31;
        List<Integer> list = this.hintOriginalIndices;
        if (list != null) {
            i11 = list.hashCode();
        } else {
            i11 = 0;
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        return "TransformablePage(originalPageOffsets=" + Arrays.toString(this.originalPageOffsets) + ", data=" + this.data + ", hintOriginalPageOffset=" + this.hintOriginalPageOffset + ", hintOriginalIndices=" + this.hintOriginalIndices + ")";
    }

    @NotNull
    public final ViewportHint.Access viewportHintFor(int i11, int i12, int i13, int i14, int i15) {
        IntRange indices;
        int i16 = this.hintOriginalPageOffset;
        List<Integer> list = this.hintOriginalIndices;
        if (!(list == null || (indices = CollectionsKt__CollectionsKt.getIndices(list)) == null || !indices.contains(i11))) {
            i11 = this.hintOriginalIndices.get(i11).intValue();
        }
        return new ViewportHint.Access(i16, i11, i12, i13, i14, i15);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TransformablePage(int i11, @NotNull List<? extends T> list) {
        this(new int[]{i11}, list, i11, (List<Integer>) null);
        Intrinsics.checkNotNullParameter(list, "data");
    }
}
