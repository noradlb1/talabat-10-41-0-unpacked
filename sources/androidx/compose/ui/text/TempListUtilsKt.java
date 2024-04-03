package androidx.compose.ui.text;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000f\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\t\u001aG\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\f0\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a&\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001aA\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00130\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aA\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00130\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a$\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b\"\b\b\u0000\u0010\u0002*\u00020\u0016*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000bH\u0000\u001aM\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00180\u000b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0018*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00190\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001ac\u0010\u001a\u001a\u0002H\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0018*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0006\u0010\u001b\u001a\u0002H\u00182'\u0010\u001c\u001a#\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00180\u001dH\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002¢\u0006\u0002\u0010!\u001a}\u0010\"\u001a\u0002H#\"\u0004\b\u0000\u0010\u0002\"\f\b\u0001\u0010#*\u00060\u0003j\u0002`\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0006\u0010$\u001a\u0002H#2\b\b\u0002\u0010%\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\b2\b\b\u0002\u0010'\u001a\u00020\b2\b\b\u0002\u0010(\u001a\u00020\u00102\b\b\u0002\u0010)\u001a\u00020\b2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010*\u001ab\u0010+\u001a\u00020,\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020\b2\b\b\u0002\u0010&\u001a\u00020\b2\b\b\u0002\u0010'\u001a\u00020\b2\b\b\u0002\u0010(\u001a\u00020\u00102\b\b\u0002\u0010)\u001a\u00020\b2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0000\u001aR\u0010-\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u0002\"\u000e\b\u0001\u0010\u0018*\b\u0012\u0004\u0012\u0002H\u00180.*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00180\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010/\u001aA\u00100\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000b2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00130\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u0002\u0007\n\u0005\b20\u0001¨\u00061"}, d2 = {"appendElement", "", "T", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "element", "transform", "Lkotlin/Function1;", "", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "fastDistinctBy", "", "K", "selector", "fastDrop", "n", "", "fastFilter", "predicate", "", "fastFilterNot", "fastFilterNotNull", "", "fastFlatMap", "R", "", "fastFold", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "acc", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "fastJoinTo", "A", "buffer", "separator", "prefix", "postfix", "limit", "truncated", "(Ljava/util/List;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "fastJoinToString", "", "fastMinByOrNull", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "fastTakeWhile", "ui-text_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TempListUtilsKt {
    private static final <T> void appendElement(Appendable appendable, T t11, Function1<? super T, ? extends CharSequence> function1) {
        boolean z11;
        if (function1 != null) {
            appendable.append((CharSequence) function1.invoke(t11));
            return;
        }
        if (t11 == null) {
            z11 = true;
        } else {
            z11 = t11 instanceof CharSequence;
        }
        if (z11) {
            appendable.append((CharSequence) t11);
        } else if (t11 instanceof Character) {
            appendable.append(((Character) t11).charValue());
        } else {
            appendable.append(String.valueOf(t11));
        }
    }

    @NotNull
    public static final <T, K> List<T> fastDistinctBy(@NotNull List<? extends T> list, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        HashSet hashSet = new HashSet(list.size());
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            if (hashSet.add(function1.invoke(obj))) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> fastDrop(@NotNull List<? extends T> list, int i11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            throw new IllegalArgumentException(("Requested element count " + i11 + " is less than zero.").toString());
        } else if (i11 == 0) {
            return list;
        } else {
            int size = list.size() - i11;
            if (size <= 0) {
                return CollectionsKt__CollectionsKt.emptyList();
            }
            if (size == 1) {
                return CollectionsKt__CollectionsJVMKt.listOf(CollectionsKt___CollectionsKt.last(list));
            }
            ArrayList arrayList = new ArrayList(size);
            int size2 = list.size();
            while (i11 < size2) {
                arrayList.add(list.get(i11));
                i11++;
            }
            return arrayList;
        }
    }

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

    @NotNull
    public static final <T> List<T> fastFilterNot(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            if (!function1.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T> List<T> fastFilterNotNull(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> List<R> fastFlatMap(@NotNull List<? extends T> list, @NotNull Function1<? super T, ? extends Iterable<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, (Iterable) function1.invoke(list.get(i11)));
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TempListUtilsKt.fastFold(java.util.List, java.lang.Object, kotlin.jvm.functions.Function2):java.lang.Object");
    }

    private static final <T, A extends Appendable> A fastJoinTo(List<? extends T> list, A a11, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, Function1<? super T, ? extends CharSequence> function1) {
        a11.append(charSequence2);
        int size = list.size();
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            Object obj = list.get(i13);
            i12++;
            if (i12 > 1) {
                a11.append(charSequence);
            }
            if (i11 >= 0 && i12 > i11) {
                break;
            }
            appendElement(a11, obj, function1);
        }
        if (i11 >= 0 && i12 > i11) {
            a11.append(charSequence4);
        }
        a11.append(charSequence3);
        return a11;
    }

    @NotNull
    public static final <T> String fastJoinToString(@NotNull List<? extends T> list, @NotNull CharSequence charSequence, @NotNull CharSequence charSequence2, @NotNull CharSequence charSequence3, int i11, @NotNull CharSequence charSequence4, @Nullable Function1<? super T, ? extends CharSequence> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "separator");
        Intrinsics.checkNotNullParameter(charSequence2, "prefix");
        Intrinsics.checkNotNullParameter(charSequence3, "postfix");
        Intrinsics.checkNotNullParameter(charSequence4, "truncated");
        String sb2 = ((StringBuilder) fastJoinTo(list, new StringBuilder(), charSequence, charSequence2, charSequence3, i11, charSequence4, function1)).toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "fastJoinTo(StringBuilder…form)\n        .toString()");
        return sb2;
    }

    public static /* synthetic */ String fastJoinToString$default(List list, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, Function1 function1, int i12, Object obj) {
        CharSequence charSequence5;
        if ((i12 & 1) != 0) {
            charSequence = IndicativeSentencesGeneration.DEFAULT_SEPARATOR;
        }
        CharSequence charSequence6 = "";
        if ((i12 & 2) != 0) {
            charSequence5 = charSequence6;
        } else {
            charSequence5 = charSequence2;
        }
        if ((i12 & 4) == 0) {
            charSequence6 = charSequence3;
        }
        if ((i12 & 8) != 0) {
            i11 = -1;
        }
        int i13 = i11;
        if ((i12 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i12 & 32) != 0) {
            function1 = null;
        }
        return fastJoinToString(list, charSequence, charSequence5, charSequence6, i13, charSequence7, function1);
    }

    @Nullable
    public static final <T, R extends Comparable<? super R>> T fastMinByOrNull(@NotNull List<? extends T> list, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        if (list.isEmpty()) {
            return null;
        }
        T t11 = list.get(0);
        Comparable comparable = (Comparable) function1.invoke(t11);
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
        int i11 = 1;
        if (1 <= lastIndex) {
            while (true) {
                T t12 = list.get(i11);
                Comparable comparable2 = (Comparable) function1.invoke(t12);
                if (comparable.compareTo(comparable2) > 0) {
                    t11 = t12;
                    comparable = comparable2;
                }
                if (i11 == lastIndex) {
                    break;
                }
                i11++;
            }
        }
        return t11;
    }

    @NotNull
    public static final <T> List<T> fastTakeWhile(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            if (!function1.invoke(obj).booleanValue()) {
                break;
            }
            arrayList.add(obj);
        }
        return arrayList;
    }
}
