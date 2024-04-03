package kotlin.text;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0002\b\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0002\b\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\b¢\u0006\u0002\b\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u001a\f\u0010\u0013\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0016\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002H\u0007¨\u0006\u0015"}, d2 = {"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__IndentKt extends StringsKt__AppendableKt {
    private static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(String str) {
        boolean z11;
        if (str.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return StringsKt__IndentKt$getIndentFunction$1.INSTANCE;
        }
        return new StringsKt__IndentKt$getIndentFunction$2(str);
    }

    private static final int indentWidth$StringsKt__IndentKt(String str) {
        int length = str.length();
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                i11 = -1;
                break;
            } else if (!CharsKt__CharJVMKt.isWhitespace(str.charAt(i11))) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 == -1) {
            return str.length();
        }
        return i11;
    }

    @NotNull
    public static final String prependIndent(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "indent");
        return SequencesKt___SequencesKt.joinToString$default(SequencesKt___SequencesKt.map(StringsKt__StringsKt.lineSequence(str), new StringsKt__IndentKt$prependIndent$1(str2)), StringUtils.LF, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public static /* synthetic */ String prependIndent$default(String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str2 = "    ";
        }
        return prependIndent(str, str2);
    }

    private static final String reindent$StringsKt__IndentKt(List<String> list, int i11, Function1<? super String, String> function1, Function1<? super String, String> function12) {
        String invoke;
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
        ArrayList arrayList = new ArrayList();
        int i12 = 0;
        for (Object next : list) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str = (String) next;
            if ((i12 == 0 || i12 == lastIndex) && StringsKt__StringsJVMKt.isBlank(str)) {
                str = null;
            } else {
                String invoke2 = function12.invoke(str);
                if (!(invoke2 == null || (invoke = function1.invoke(invoke2)) == null)) {
                    str = invoke;
                }
            }
            if (str != null) {
                arrayList.add(str);
            }
            i12 = i13;
        }
        String sb2 = ((StringBuilder) CollectionsKt___CollectionsKt.joinTo$default(arrayList, new StringBuilder(i11), StringUtils.LF, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null)).toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb2;
    }

    @NotNull
    public static final String replaceIndent(@NotNull String str, @NotNull String str2) {
        int i11;
        String invoke;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "newIndent");
        List<String> lines = StringsKt__StringsKt.lines(str);
        ArrayList<String> arrayList = new ArrayList<>();
        for (Object next : lines) {
            if (!StringsKt__StringsJVMKt.isBlank((String) next)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (String indentWidth$StringsKt__IndentKt : arrayList) {
            arrayList2.add(Integer.valueOf(indentWidth$StringsKt__IndentKt(indentWidth$StringsKt__IndentKt)));
        }
        Integer num = (Integer) CollectionsKt.minOrNull((Iterable) arrayList2);
        int i12 = 0;
        if (num != null) {
            i11 = num.intValue();
        } else {
            i11 = 0;
        }
        int length = str.length() + (str2.length() * lines.size());
        Function1<String, String> indentFunction$StringsKt__IndentKt = getIndentFunction$StringsKt__IndentKt(str2);
        int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(lines);
        ArrayList arrayList3 = new ArrayList();
        for (Object next2 : lines) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str3 = (String) next2;
            if ((i12 == 0 || i12 == lastIndex) && StringsKt__StringsJVMKt.isBlank(str3)) {
                str3 = null;
            } else {
                String drop = StringsKt___StringsKt.drop(str3, i11);
                if (!(drop == null || (invoke = indentFunction$StringsKt__IndentKt.invoke(drop)) == null)) {
                    str3 = invoke;
                }
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i12 = i13;
        }
        String sb2 = ((StringBuilder) CollectionsKt___CollectionsKt.joinTo$default(arrayList3, new StringBuilder(length), StringUtils.LF, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null)).toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb2;
    }

    public static /* synthetic */ String replaceIndent$default(String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str2 = "";
        }
        return replaceIndent(str, str2);
    }

    @NotNull
    public static final String replaceIndentByMargin(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        int i11;
        String invoke;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "newIndent");
        Intrinsics.checkNotNullParameter(str3, "marginPrefix");
        if (!StringsKt__StringsJVMKt.isBlank(str3)) {
            List<String> lines = StringsKt__StringsKt.lines(str);
            int length = str.length() + (str2.length() * lines.size());
            Function1<String, String> indentFunction$StringsKt__IndentKt = getIndentFunction$StringsKt__IndentKt(str2);
            int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(lines);
            ArrayList arrayList = new ArrayList();
            int i12 = 0;
            for (Object next : lines) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                String str4 = (String) next;
                String str5 = null;
                if ((i12 == 0 || i12 == lastIndex) && StringsKt__StringsJVMKt.isBlank(str4)) {
                    str4 = null;
                } else {
                    int length2 = str4.length();
                    int i14 = 0;
                    while (true) {
                        if (i14 >= length2) {
                            i11 = -1;
                            break;
                        } else if (!CharsKt__CharJVMKt.isWhitespace(str4.charAt(i14))) {
                            i11 = i14;
                            break;
                        } else {
                            i14++;
                        }
                    }
                    if (i11 != -1) {
                        int i15 = i11;
                        if (StringsKt__StringsJVMKt.startsWith$default(str4, str3, i11, false, 4, (Object) null)) {
                            Intrinsics.checkNotNull(str4, "null cannot be cast to non-null type java.lang.String");
                            str5 = str4.substring(i15 + str3.length());
                            Intrinsics.checkNotNullExpressionValue(str5, "this as java.lang.String).substring(startIndex)");
                        }
                    }
                    if (!(str5 == null || (invoke = indentFunction$StringsKt__IndentKt.invoke(str5)) == null)) {
                        str4 = invoke;
                    }
                }
                if (str4 != null) {
                    arrayList.add(str4);
                }
                i12 = i13;
            }
            String sb2 = ((StringBuilder) CollectionsKt___CollectionsKt.joinTo$default(arrayList, new StringBuilder(length), StringUtils.LF, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 124, (Object) null)).toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
            return sb2;
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static /* synthetic */ String replaceIndentByMargin$default(String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str2 = "";
        }
        if ((i11 & 2) != 0) {
            str3 = "|";
        }
        return replaceIndentByMargin(str, str2, str3);
    }

    @NotNull
    @IntrinsicConstEvaluation
    public static String trimIndent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return replaceIndent(str, "");
    }

    @NotNull
    @IntrinsicConstEvaluation
    public static final String trimMargin(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "marginPrefix");
        return replaceIndentByMargin(str, "", str2);
    }

    public static /* synthetic */ String trimMargin$default(String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str2 = "|";
        }
        return trimMargin(str, str2);
    }
}
