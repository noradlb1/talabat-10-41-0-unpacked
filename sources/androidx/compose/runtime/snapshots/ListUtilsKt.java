package androidx.compose.runtime.snapshots;

import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\u001a9\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010\t\u001a;\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a;\u0010\u000e\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aV\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2'\u0010\r\u001a#\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u000b0\u0010H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a;\u0010\u0015\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aA\u0010\u0017\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\u0010H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aS\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u0002H\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f0\u0019\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u001a*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u001a0\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a}\u0010\u001c\u001a\u0002H\u001d\"\u0004\b\u0000\u0010\u0002\"\f\b\u0001\u0010\u001d*\u00060\u0003j\u0002`\u0004*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0006\u0010\u001e\u001a\u0002H\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020\b2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010$\u001ab\u0010%\u001a\u00020&\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\f2\b\b\u0002\u0010\u001f\u001a\u00020\b2\b\b\u0002\u0010 \u001a\u00020\b2\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020\b2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0000\u001aG\u0010'\u001a\b\u0012\u0004\u0012\u0002H(0\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010(*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H(0\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001aI\u0010)\u001a\b\u0012\u0004\u0012\u0002H(0\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010(*\b\u0012\u0004\u0012\u0002H\u00020\f2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H(0\u0007H\bø\u0001\u0000\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001\u001a\u001e\u0010*\u001a\b\u0012\u0004\u0012\u0002H\u00020+\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\fH\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006,"}, d2 = {"appendElement", "", "T", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "element", "transform", "Lkotlin/Function1;", "", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "fastAll", "", "", "predicate", "fastAny", "fastFilterIndexed", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "index", "fastForEach", "action", "fastForEachIndexed", "fastGroupBy", "", "K", "keySelector", "fastJoinTo", "A", "buffer", "separator", "prefix", "postfix", "limit", "truncated", "(Ljava/util/List;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "fastJoinToString", "", "fastMap", "R", "fastMapNotNull", "fastToSet", "", "runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ListUtilsKt {
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

    public static final <T> boolean fastAll(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (!function1.invoke(list.get(i11)).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <T> boolean fastAny(@NotNull List<? extends T> list, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (function1.invoke(list.get(i11)).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public static final <T> List<T> fastFilterIndexed(@NotNull List<? extends T> list, @NotNull Function2<? super Integer, ? super T, Boolean> function2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function2, "predicate");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            if (function2.invoke(Integer.valueOf(i11), obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static final <T> void fastForEach(@NotNull List<? extends T> list, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, NativeProtocol.WEB_DIALOG_ACTION);
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            function1.invoke(list.get(i11));
        }
    }

    public static final <T> void fastForEachIndexed(@NotNull List<? extends T> list, @NotNull Function2<? super Integer, ? super T, Unit> function2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function2, NativeProtocol.WEB_DIALOG_ACTION);
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            function2.invoke(Integer.valueOf(i11), list.get(i11));
        }
    }

    @NotNull
    public static final <T, K> Map<K, List<T>> fastGroupBy(@NotNull List<? extends T> list, @NotNull Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "keySelector");
        HashMap hashMap = new HashMap(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            Object obj = list.get(i11);
            Object invoke = function1.invoke(obj);
            Object obj2 = hashMap.get(invoke);
            if (obj2 == null) {
                obj2 = new ArrayList();
                hashMap.put(invoke, obj2);
            }
            ((ArrayList) obj2).add(obj);
        }
        return hashMap;
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
    public static final <T, R> List<R> fastMap(@NotNull List<? extends T> list, @NotNull Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(function1, "transform");
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(function1.invoke(list.get(i11)));
        }
        return arrayList;
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

    @NotNull
    public static final <T> Set<T> fastToSet(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        HashSet hashSet = new HashSet(list.size());
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            hashSet.add(list.get(i11));
        }
        return hashSet;
    }
}
