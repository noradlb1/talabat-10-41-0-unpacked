package coil.util;

import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010&\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a7\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00050\u0004H\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a?\u0010\u0007\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\b0\u00022\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u0002H\b\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0004H\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001aI\u0010\n\u001a\u0002H\b\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0006\u0010\u000b\u001a\u0002H\b2\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\b0\rH\bø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a0\u0010\u000f\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00100\u0004H\bø\u0001\u0000\u001a<\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0002\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\b0\u00022\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00010\u0004H\bø\u0001\u0000\u001a`\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\b0\u0014\"\u0004\b\u0000\u0010\u0015\"\u0004\b\u0001\u0010\u0016\"\b\b\u0002\u0010\b*\u00020\u0017*\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00160\u00142 \u0010\t\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002H\u00160\u0018\u0012\u0006\u0012\u0004\u0018\u0001H\b0\u0004H\bø\u0001\u0000\u001a0\u0010\u0019\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u001a2\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00050\u0004H\bø\u0001\u0000*<\b\u0000\u0010\u001b\u001a\u0004\b\u0000\u0010\b\u001a\u0004\b\u0001\u0010\u0001\"\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00010\u001c0\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00010\u001c0\u0002*<\b\u0000\u0010\u001d\u001a\u0004\b\u0000\u0010\b\u001a\u0004\b\u0001\u0010\u0001\"\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00010\u001c0\u001a2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\u00010\u001c0\u001a\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001e"}, d2 = {"findIndices", "T", "", "predicate", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "firstNotNullIndices", "R", "transform", "foldIndices", "initial", "operation", "Lkotlin/Function2;", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "forEachIndices", "", "action", "mapIndices", "mapNotNullValues", "", "K", "V", "", "", "removeIfIndices", "", "MultiList", "Lkotlin/Pair;", "MultiMutableList", "coil-base_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
@JvmName(name = "-Collections")
/* renamed from: coil.util.-Collections  reason: invalid class name */
public final class Collections {
    @Nullable
    public static final <T> T findIndices(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int size = list.size() - 1;
        if (size < 0) {
            return null;
        }
        int i11 = 0;
        while (true) {
            int i12 = i11 + 1;
            T t11 = list.get(i11);
            if (function1.invoke(t11).booleanValue()) {
                return t11;
            }
            if (i12 > size) {
                return null;
            }
            i11 = i12;
        }
    }

    @Nullable
    public static final <R, T> T firstNotNullIndices(@NotNull List<? extends R> list, @NotNull Function1<? super R, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        int size = list.size() - 1;
        if (size < 0) {
            return null;
        }
        int i11 = 0;
        while (true) {
            int i12 = i11 + 1;
            T invoke = function1.invoke(list.get(i11));
            if (invoke != null) {
                return invoke;
            }
            if (i12 > size) {
                return null;
            }
            i11 = i12;
        }
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Object, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2<? super R, ? super T, ? extends R>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T, R> R foldIndices(@org.jetbrains.annotations.NotNull java.util.List<? extends T> r3, R r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super R, ? super T, ? extends R> r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "operation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            int r0 = r3.size()
            int r0 = r0 + -1
            if (r0 < 0) goto L_0x0022
            r1 = 0
        L_0x0013:
            int r2 = r1 + 1
            java.lang.Object r1 = r3.get(r1)
            java.lang.Object r4 = r5.invoke(r4, r1)
            if (r2 <= r0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r1 = r2
            goto L_0x0013
        L_0x0022:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.util.Collections.foldIndices(java.util.List, java.lang.Object, kotlin.jvm.functions.Function2):java.lang.Object");
    }

    public static final <T> void forEachIndices(@NotNull List<? extends T> list, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, NativeProtocol.WEB_DIALOG_ACTION);
        int size = list.size() - 1;
        if (size >= 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                function1.invoke(list.get(i11));
                if (i12 <= size) {
                    i11 = i12;
                } else {
                    return;
                }
            }
        }
    }

    @NotNull
    public static final <R, T> List<T> mapIndices(@NotNull List<? extends R> list, @NotNull Function1<? super R, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size() - 1;
        if (size >= 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                arrayList.add(function1.invoke(list.get(i11)));
                if (i12 > size) {
                    break;
                }
                i11 = i12;
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <K, V, R> Map<K, R> mapNotNullValues(@NotNull Map<K, ? extends V> map, @NotNull Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            Object invoke = function1.invoke(next);
            if (invoke != null) {
                linkedHashMap.put(next.getKey(), invoke);
            }
        }
        return linkedHashMap;
    }

    public static final <T> void removeIfIndices(@NotNull List<T> list, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int size = list.size() - 1;
        if (size >= 0) {
            int i11 = 0;
            int i12 = 0;
            while (true) {
                int i13 = i11 + 1;
                int i14 = i11 - i12;
                if (function1.invoke(list.get(i14)).booleanValue()) {
                    list.remove(i14);
                    i12++;
                }
                if (i13 <= size) {
                    i11 = i13;
                } else {
                    return;
                }
            }
        }
    }
}
