package androidx.paging;

import androidx.annotation.IntRange;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\f\u0018\u0000*\u0004\b\u0000\u0010\u00012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0002B'\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0010\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0012R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\f¨\u0006\u0013"}, d2 = {"Landroidx/paging/ItemSnapshotList;", "T", "Lkotlin/collections/AbstractList;", "placeholdersBefore", "", "placeholdersAfter", "items", "", "(IILjava/util/List;)V", "getItems", "()Ljava/util/List;", "getPlaceholdersAfter", "()I", "getPlaceholdersBefore", "size", "getSize", "get", "index", "(I)Ljava/lang/Object;", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class ItemSnapshotList<T> extends AbstractList<T> {
    @NotNull
    private final List<T> items;
    private final int placeholdersAfter;
    private final int placeholdersBefore;

    public ItemSnapshotList(@IntRange(from = 0) int i11, @IntRange(from = 0) int i12, @NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        this.placeholdersBefore = i11;
        this.placeholdersAfter = i12;
        this.items = list;
    }

    @Nullable
    public T get(int i11) {
        int i12 = this.placeholdersBefore;
        if (i11 >= 0 && i12 > i11) {
            return null;
        }
        int size = this.items.size() + i12;
        if (i12 <= i11 && size > i11) {
            return this.items.get(i11 - this.placeholdersBefore);
        }
        int size2 = this.placeholdersBefore + this.items.size();
        int size3 = size();
        if (size2 <= i11 && size3 > i11) {
            return null;
        }
        throw new IndexOutOfBoundsException("Illegal attempt to access index " + i11 + " in ItemSnapshotList of size " + size());
    }

    @NotNull
    public final List<T> getItems() {
        return this.items;
    }

    public final int getPlaceholdersAfter() {
        return this.placeholdersAfter;
    }

    public final int getPlaceholdersBefore() {
        return this.placeholdersBefore;
    }

    public int getSize() {
        return this.placeholdersBefore + this.items.size() + this.placeholdersAfter;
    }
}
