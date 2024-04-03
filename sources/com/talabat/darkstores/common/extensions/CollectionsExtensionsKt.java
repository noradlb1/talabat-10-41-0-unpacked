package com.talabat.darkstores.common.extensions;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u0002H\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\bø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0002\u0007\n\u0005\b20\u0001¨\u0006\b"}, d2 = {"plusIf", "", "Type", "element", "predicate", "Lkotlin/Function0;", "", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/util/List;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CollectionsExtensionsKt {
    @NotNull
    public static final <Type> List<Type> plusIf(@NotNull List<? extends Type> list, Type type, @NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function0, "predicate");
        if (function0.invoke().booleanValue()) {
            return CollectionsKt___CollectionsKt.plus(list, type);
        }
        return list;
    }
}
