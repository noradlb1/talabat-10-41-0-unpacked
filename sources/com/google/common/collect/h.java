package com.google.common.collect;

import com.google.common.collect.Table;
import java.util.Comparator;

public final /* synthetic */ class h implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Comparator f44647b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Comparator f44648c;

    public /* synthetic */ h(Comparator comparator, Comparator comparator2) {
        this.f44647b = comparator;
        this.f44648c = comparator2;
    }

    public final int compare(Object obj, Object obj2) {
        return RegularImmutableTable.lambda$forCells$0(this.f44647b, this.f44648c, (Table.Cell) obj, (Table.Cell) obj2);
    }
}
