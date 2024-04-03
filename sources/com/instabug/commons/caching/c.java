package com.instabug.commons.caching;

import java.io.File;
import java.util.Comparator;
import kotlin.Pair;

public final class c implements Comparator {
    public final int compare(Object obj, Object obj2) {
        Long l11;
        String name2;
        String removeSuffix;
        String name3;
        String removeSuffix2;
        File file = (File) ((Pair) obj2).component2();
        Long l12 = null;
        if (file == null || (name3 = file.getName()) == null || (removeSuffix2 = StringsKt__StringsKt.removeSuffix(name3, (CharSequence) "-sst")) == null) {
            l11 = null;
        } else {
            l11 = Long.valueOf(Long.parseLong(removeSuffix2));
        }
        File file2 = (File) ((Pair) obj).component2();
        if (!(file2 == null || (name2 = file2.getName()) == null || (removeSuffix = StringsKt__StringsKt.removeSuffix(name2, (CharSequence) "-sst")) == null)) {
            l12 = Long.valueOf(Long.parseLong(removeSuffix));
        }
        return ComparisonsKt__ComparisonsKt.compareValues(l11, l12);
    }
}
