package com.talabat.talabatcore.extensions;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001aQ\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u0001H\u00032\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"guardNotNull", "Lkotlin/properties/ReadWriteProperty;", "Any", "T", "Lkotlin/properties/Delegates;", "throwable", "", "defaultValue", "crashIf", "Lkotlin/Function1;", "", "(Lkotlin/properties/Delegates;Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/properties/ReadWriteProperty;", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class DelegatesKt {
    @NotNull
    public static final <Any, T> ReadWriteProperty<Any, T> guardNotNull(@NotNull Delegates delegates, @NotNull Throwable th2, @Nullable T t11, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(delegates, "<this>");
        Intrinsics.checkNotNullParameter(th2, "throwable");
        Intrinsics.checkNotNullParameter(function1, "crashIf");
        return new DelegatesKt$guardNotNull$2(t11, function1, th2);
    }

    public static /* synthetic */ ReadWriteProperty guardNotNull$default(Delegates delegates, Throwable th2, Object obj, Function1 function1, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            obj = null;
        }
        if ((i11 & 4) != 0) {
            function1 = DelegatesKt$guardNotNull$1.INSTANCE;
        }
        return guardNotNull(delegates, th2, obj, function1);
    }
}
