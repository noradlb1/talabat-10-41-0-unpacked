package androidx.compose.ui;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\t\u001a_\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r0\u000b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\f\"\u0004\b\u0002\u0010\r*\b\u0012\u0004\u0012\u0002H\u00020\u000e2\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\r0\u000f0\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a}\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u0002\"\f\b\u0001\u0010\u0011*\u00060\u0003j\u0002`\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u000e2\u0006\u0010\u0012\u001a\u0002H\u00112\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\b2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\u0019\u001ab\u0010\u001a\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000e2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\b2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0000\u001aI\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u001d*\b\u0012\u0004\u0012\u0002H\u00020\u000e2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u001d0\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a_\u0010\u001e\u001a\u0002H\u001f\"\u0004\b\u0000\u0010\u001f\"\b\b\u0001\u0010\u0002*\u0002H\u001f*\b\u0012\u0004\u0012\u0002H\u00020\u000e2'\u0010 \u001a#\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u001f0!H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0002\u0010%\u001a\u0010&\u001a\b\u0012\u0004\u0012\u0002H\r0\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u001d\"\u0004\b\u0002\u0010\r*\b\u0012\u0004\u0012\u0002H\u00020\u000e2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u000e26\u0010\u0006\u001a2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b((\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b()\u0012\u0004\u0012\u0002H\r0!H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002\u001aM\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u001d*\b\u0012\u0004\u0012\u0002H\u00020\u000e2\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u001d0!H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u0002\u0007\n\u0005\b20\u0001¨\u0006+"}, d2 = {"appendElement", "", "T", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "element", "transform", "Lkotlin/Function1;", "", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "fastAssociate", "", "K", "V", "", "Lkotlin/Pair;", "fastJoinTo", "A", "buffer", "separator", "prefix", "postfix", "limit", "", "truncated", "(Ljava/util/List;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "fastJoinToString", "", "fastMapNotNull", "R", "fastReduce", "S", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "acc", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "fastZip", "other", "a", "b", "fastZipWithNext", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
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
    public static final <T, K, V> Map<K, V> fastAssociate(@NotNull List<? extends T> list, @NotNull Function1<? super T, ? extends Pair<? extends K, ? extends V>> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            Pair pair = (Pair) function1.invoke(list.get(i11));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
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

    @NotNull
    public static final <T, R> List<R> fastMapNotNull(@NotNull List<? extends T> list, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            Object invoke = function1.invoke(list.get(i11));
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    public static final <S, T extends S> S fastReduce(@NotNull List<? extends T> list, @NotNull Function2<? super S, ? super T, ? extends S> function2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function2, "operation");
        if (!list.isEmpty()) {
            S first = CollectionsKt___CollectionsKt.first(list);
            int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
            int i11 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    first = function2.invoke(first, list.get(i11));
                    if (i11 == lastIndex) {
                        break;
                    }
                    i11++;
                }
            }
            return first;
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    @NotNull
    public static final <T, R, V> List<V> fastZip(@NotNull List<? extends T> list, @NotNull List<? extends R> list2, @NotNull Function2<? super T, ? super R, ? extends V> function2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(list2, "other");
        Intrinsics.checkNotNullParameter(function2, "transform");
        int min = Math.min(list.size(), list2.size());
        ArrayList arrayList = new ArrayList(min);
        for (int i11 = 0; i11 < min; i11++) {
            arrayList.add(function2.invoke(list.get(i11), list2.get(i11)));
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> List<R> fastZipWithNext(@NotNull List<? extends T> list, @NotNull Function2<? super T, ? super T, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function2, "transform");
        if (list.size() == 0 || list.size() == 1) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        Object obj = list.get(0);
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
        while (i11 < lastIndex) {
            i11++;
            Object obj2 = list.get(i11);
            arrayList.add(function2.invoke(obj, obj2));
            obj = obj2;
        }
        return arrayList;
    }
}
