package com.instabug.library.model.v3Session;

import com.instabug.library.map.TwoWayMapper;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

public final class b implements TwoWayMapper {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final b f51592a = new b();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Regex f51593b = new Regex("((?<!\\\\),)|((?<=\\\\/\\\\),)");

    private b() {
    }

    private final String c(String str) {
        return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(str, "\\,", ",", false, 4, (Object) null), "\\/\\", "\\", false, 4, (Object) null);
    }

    @NotNull
    /* renamed from: b */
    public List mapBackwards(@NotNull String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "type2");
        if (str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<String> split = f51593b.split(str, 0);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(split, 10));
        for (String c11 : split) {
            arrayList.add(c(c11));
        }
        return arrayList;
    }

    @NotNull
    /* renamed from: a */
    public String mapForwards(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "type1");
        return CollectionsKt___CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new a(this), 30, (Object) null);
    }

    /* access modifiers changed from: private */
    public final String a(String str) {
        return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(str, "\\", "\\/\\", false, 4, (Object) null), ",", "\\,", false, 4, (Object) null);
    }
}
