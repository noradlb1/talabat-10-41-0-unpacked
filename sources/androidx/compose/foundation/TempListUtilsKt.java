package androidx.compose.foundation;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\u0003\u001aA\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00050\u0004H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001ac\u0010\u0006\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\b\u001a\u0002H\u00072'\u0010\t\u001a#\u0012\u0013\u0012\u0011H\u0007¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00070\nH\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010\u000e\u001a^\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00020\u00012)\u0010\u0010\u001a%\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00070\nH\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aR\u0010\u0013\u001a\u0004\u0018\u0001H\u0007\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u0014*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00070\u0004H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010\u0016\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0017"}, d2 = {"fastFilter", "", "T", "predicate", "Lkotlin/Function1;", "", "fastFold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "acc", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "fastMapIndexedNotNull", "transform", "", "index", "fastMaxOfOrNull", "", "selector", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "foundation_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TempListUtilsKt {
    @NotNull
    public static final <T> List<T> fastFilter(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            if (function1.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Object, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2<? super R, ? super T, ? extends R>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, R> R fastFold(@org.jetbrains.annotations.NotNull java.util.List<? extends T> r3, R r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super R, ? super T, ? extends R> r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            int r0 = r3.size()
            r1 = 0
        L_0x000f:
            if (r1 >= r0) goto L_0x001c
            java.lang.Object r2 = r3.get(r1)
            java.lang.Object r4 = r5.invoke(r4, r2)
            int r1 = r1 + 1
            goto L_0x000f
        L_0x001c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.TempListUtilsKt.fastFold(java.util.List, java.lang.Object, kotlin.jvm.functions.Function2):java.lang.Object");
    }

    @NotNull
    public static final <T, R> List<R> fastMapIndexedNotNull(@NotNull List<? extends T> list, @NotNull Function2<? super Integer, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function2, "transform");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            Object invoke = function2.invoke(Integer.valueOf(i11), list.get(i11));
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    @Nullable
    public static final <T, R extends Comparable<? super R>> R fastMaxOfOrNull(@NotNull List<? extends T> list, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (list.isEmpty()) {
            return null;
        }
        R r11 = (Comparable) function1.invoke(list.get(0));
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
        int i11 = 1;
        if (1 <= lastIndex) {
            while (true) {
                R r12 = (Comparable) function1.invoke(list.get(i11));
                if (r12.compareTo(r11) > 0) {
                    r11 = r12;
                }
                if (i11 == lastIndex) {
                    break;
                }
                i11++;
            }
        }
        return r11;
    }
}
