package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import net.bytebuddy.asm.Advice;
import org.jetbrains.annotations.NotNull;

public class JvmNameResolverBase implements NameResolver {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final List<String> PREDEFINED_STRINGS;
    @NotNull
    private static final Map<String, Integer> PREDEFINED_STRINGS_MAP;
    @NotNull

    /* renamed from: kotlin  reason: collision with root package name */
    private static final String f24744kotlin;
    @NotNull
    private final Set<Integer> localNameIndices;
    @NotNull
    private final List<JvmProtoBuf.StringTableTypes.Record> records;
    @NotNull
    private final String[] strings;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[JvmProtoBuf.StringTableTypes.Record.Operation.values().length];
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.NONE.ordinal()] = 1;
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            iArr[JvmProtoBuf.StringTableTypes.Record.Operation.DESC_TO_CLASS_ID.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        String joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt__CollectionsKt.listOf('k', 'o', Character.valueOf(Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL), 'l', 'i', 'n'), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        f24744kotlin = joinToString$default;
        List<String> listOf = CollectionsKt__CollectionsKt.listOf(joinToString$default + "/Any", joinToString$default + "/Nothing", joinToString$default + "/Unit", joinToString$default + "/Throwable", joinToString$default + "/Number", joinToString$default + "/Byte", joinToString$default + "/Double", joinToString$default + "/Float", joinToString$default + "/Int", joinToString$default + "/Long", joinToString$default + "/Short", joinToString$default + "/Boolean", joinToString$default + "/Char", joinToString$default + "/CharSequence", joinToString$default + "/String", joinToString$default + "/Comparable", joinToString$default + "/Enum", joinToString$default + "/Array", joinToString$default + "/ByteArray", joinToString$default + "/DoubleArray", joinToString$default + "/FloatArray", joinToString$default + "/IntArray", joinToString$default + "/LongArray", joinToString$default + "/ShortArray", joinToString$default + "/BooleanArray", joinToString$default + "/CharArray", joinToString$default + "/Cloneable", joinToString$default + "/Annotation", joinToString$default + "/collections/Iterable", joinToString$default + "/collections/MutableIterable", joinToString$default + "/collections/Collection", joinToString$default + "/collections/MutableCollection", joinToString$default + "/collections/List", joinToString$default + "/collections/MutableList", joinToString$default + "/collections/Set", joinToString$default + "/collections/MutableSet", joinToString$default + "/collections/Map", joinToString$default + "/collections/MutableMap", joinToString$default + "/collections/Map.Entry", joinToString$default + "/collections/MutableMap.MutableEntry", joinToString$default + "/collections/Iterator", joinToString$default + "/collections/MutableIterator", joinToString$default + "/collections/ListIterator", joinToString$default + "/collections/MutableListIterator");
        PREDEFINED_STRINGS = listOf;
        Iterable<IndexedValue> withIndex = CollectionsKt___CollectionsKt.withIndex(listOf);
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.coerceAtLeast(MapsKt__MapsJVMKt.mapCapacity(CollectionsKt__IterablesKt.collectionSizeOrDefault(withIndex, 10)), 16));
        for (IndexedValue indexedValue : withIndex) {
            linkedHashMap.put((String) indexedValue.getValue(), Integer.valueOf(indexedValue.getIndex()));
        }
        PREDEFINED_STRINGS_MAP = linkedHashMap;
    }

    public JvmNameResolverBase(@NotNull String[] strArr, @NotNull Set<Integer> set, @NotNull List<JvmProtoBuf.StringTableTypes.Record> list) {
        Intrinsics.checkNotNullParameter(strArr, "strings");
        Intrinsics.checkNotNullParameter(set, "localNameIndices");
        Intrinsics.checkNotNullParameter(list, "records");
        this.strings = strArr;
        this.localNameIndices = set;
        this.records = list;
    }

    @NotNull
    public String getQualifiedClassName(int i11) {
        return getString(i11);
    }

    @NotNull
    public String getString(int i11) {
        String str;
        boolean z11;
        int i12 = i11;
        JvmProtoBuf.StringTableTypes.Record record = this.records.get(i12);
        if (record.hasString()) {
            str = record.getString();
        } else {
            if (record.hasPredefinedIndex()) {
                List<String> list = PREDEFINED_STRINGS;
                int size = list.size();
                int predefinedIndex = record.getPredefinedIndex();
                if (predefinedIndex < 0 || predefinedIndex >= size) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (z11) {
                    str = list.get(record.getPredefinedIndex());
                }
            }
            str = this.strings[i12];
        }
        if (record.getSubstringIndexCount() >= 2) {
            List<Integer> substringIndexList = record.getSubstringIndexList();
            Intrinsics.checkNotNullExpressionValue(substringIndexList, "substringIndexList");
            Integer num = substringIndexList.get(0);
            Integer num2 = substringIndexList.get(1);
            Intrinsics.checkNotNullExpressionValue(num, "begin");
            if (num.intValue() >= 0) {
                int intValue = num.intValue();
                Intrinsics.checkNotNullExpressionValue(num2, TtmlNode.END);
                if (intValue <= num2.intValue() && num2.intValue() <= str.length()) {
                    Intrinsics.checkNotNullExpressionValue(str, TypedValues.Custom.S_STRING);
                    str = str.substring(num.intValue(), num2.intValue());
                    Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String…ing(startIndex, endIndex)");
                }
            }
        }
        String str2 = str;
        if (record.getReplaceCharCount() >= 2) {
            List<Integer> replaceCharList = record.getReplaceCharList();
            Intrinsics.checkNotNullExpressionValue(replaceCharList, "replaceCharList");
            Intrinsics.checkNotNullExpressionValue(str2, TypedValues.Custom.S_STRING);
            str2 = StringsKt__StringsJVMKt.replace$default(str2, (char) replaceCharList.get(0).intValue(), (char) replaceCharList.get(1).intValue(), false, 4, (Object) null);
        }
        String str3 = str2;
        JvmProtoBuf.StringTableTypes.Record.Operation operation = record.getOperation();
        if (operation == null) {
            operation = JvmProtoBuf.StringTableTypes.Record.Operation.NONE;
        }
        int i13 = WhenMappings.$EnumSwitchMapping$0[operation.ordinal()];
        if (i13 == 2) {
            Intrinsics.checkNotNullExpressionValue(str3, TypedValues.Custom.S_STRING);
            str3 = StringsKt__StringsJVMKt.replace$default(str3, '$', '.', false, 4, (Object) null);
        } else if (i13 == 3) {
            if (str3.length() >= 2) {
                Intrinsics.checkNotNullExpressionValue(str3, TypedValues.Custom.S_STRING);
                str3 = str3.substring(1, str3.length() - 1);
                Intrinsics.checkNotNullExpressionValue(str3, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            String str4 = str3;
            Intrinsics.checkNotNullExpressionValue(str4, TypedValues.Custom.S_STRING);
            str3 = StringsKt__StringsJVMKt.replace$default(str4, '$', '.', false, 4, (Object) null);
        }
        Intrinsics.checkNotNullExpressionValue(str3, TypedValues.Custom.S_STRING);
        return str3;
    }

    public boolean isLocalClassName(int i11) {
        return this.localNameIndices.contains(Integer.valueOf(i11));
    }
}
