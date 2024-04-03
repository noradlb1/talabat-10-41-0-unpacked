package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
interface FilteredSetMultimap<K, V> extends FilteredMultimap<K, V>, SetMultimap<K, V> {
    /* bridge */ /* synthetic */ Multimap unfiltered();

    SetMultimap<K, V> unfiltered();
}
