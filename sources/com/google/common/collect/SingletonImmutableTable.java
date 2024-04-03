package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;
import java.util.Map;

@GwtCompatible
@ElementTypesAreNonnullByDefault
class SingletonImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {
    final C singleColumnKey;
    final R singleRowKey;
    final V singleValue;

    public SingletonImmutableTable(R r11, C c11, V v11) {
        this.singleRowKey = Preconditions.checkNotNull(r11);
        this.singleColumnKey = Preconditions.checkNotNull(c11);
        this.singleValue = Preconditions.checkNotNull(v11);
    }

    public ImmutableTable.SerializedForm createSerializedForm() {
        return ImmutableTable.SerializedForm.create(this, new int[]{0}, new int[]{0});
    }

    public int size() {
        return 1;
    }

    public ImmutableMap<R, V> column(C c11) {
        Preconditions.checkNotNull(c11);
        if (containsColumn(c11)) {
            return ImmutableMap.of(this.singleRowKey, this.singleValue);
        }
        return ImmutableMap.of();
    }

    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.of(this.singleColumnKey, ImmutableMap.of(this.singleRowKey, this.singleValue));
    }

    public ImmutableSet<Table.Cell<R, C, V>> createCellSet() {
        return ImmutableSet.of(ImmutableTable.cellOf(this.singleRowKey, this.singleColumnKey, this.singleValue));
    }

    public ImmutableCollection<V> createValues() {
        return ImmutableSet.of(this.singleValue);
    }

    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.of(this.singleRowKey, ImmutableMap.of(this.singleColumnKey, this.singleValue));
    }

    public SingletonImmutableTable(Table.Cell<R, C, V> cell) {
        this(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
    }
}
