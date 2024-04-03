package com.instabug.apm.cache.handler.experiment.mapping;

import com.instabug.library.map.TwoWayMapper;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

public final class c implements TwoWayMapper {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f45130a = new a((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Regex f45131b = new Regex("((?<!\\\\),)|((?<=\\\\/\\\\),)");

    @JvmStatic
    @NotNull
    public static final TwoWayMapper a() {
        return f45130a.a();
    }

    /* access modifiers changed from: private */
    public final String a(String str) {
        return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(str, "\\", "\\/\\", false, 4, (Object) null), ",", "\\,", false, 4, (Object) null);
    }

    private final String b(String str) {
        return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(str, "\\,", ",", false, 4, (Object) null), "\\/\\", "\\", false, 4, (Object) null);
    }

    @NotNull
    /* renamed from: a */
    public List mapBackwards(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "type2");
        if (bArr.length == 0) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        List<String> split = f45131b.split(new String(bArr, Charsets.UTF_8), 0);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(split, 10));
        for (String b11 : split) {
            arrayList.add(b(b11));
        }
        return arrayList;
    }

    @NotNull
    /* renamed from: a */
    public byte[] mapForwards(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "type1");
        byte[] bytes = CollectionsKt___CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new b(this), 30, (Object) null).getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }
}
