package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import androidx.exifinterface.media.ExifInterface;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import net.bytebuddy.pool.TypePool;
import org.jetbrains.annotations.NotNull;

public final class ClassMapperLite {
    @NotNull
    public static final ClassMapperLite INSTANCE = new ClassMapperLite();
    @NotNull

    /* renamed from: kotlin  reason: collision with root package name */
    private static final String f24741kotlin = CollectionsKt___CollectionsKt.joinToString$default(CollectionsKt__CollectionsKt.listOf('k', 'o', Character.valueOf(Advice.OffsetMapping.ForOrigin.Renderer.ForTypeName.SYMBOL), 'l', 'i', 'n'), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    @NotNull
    private static final Map<String, String> map;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List listOf = CollectionsKt__CollectionsKt.listOf("Boolean", "Z", "Char", "C", "Byte", "B", "Short", ExifInterface.LATITUDE_SOUTH, "Int", "I", "Float", "F", "Long", "J", "Double", "D");
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, listOf.size() - 1, 2);
        if (progressionLastElement >= 0) {
            int i11 = 0;
            while (true) {
                StringBuilder sb2 = new StringBuilder();
                String str = f24741kotlin;
                sb2.append(str);
                sb2.append('/');
                sb2.append((String) listOf.get(i11));
                int i12 = i11 + 1;
                linkedHashMap.put(sb2.toString(), listOf.get(i12));
                linkedHashMap.put(str + '/' + ((String) listOf.get(i11)) + "Array", '[' + ((String) listOf.get(i12)));
                if (i11 == progressionLastElement) {
                    break;
                }
                i11 += 2;
            }
        }
        linkedHashMap.put(f24741kotlin + "/Unit", ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        m7568map$lambda0$add(linkedHashMap, "Any", TypeProxy.SilentConstruction.Appender.JAVA_LANG_OBJECT_INTERNAL_NAME);
        m7568map$lambda0$add(linkedHashMap, "Nothing", "java/lang/Void");
        m7568map$lambda0$add(linkedHashMap, "Annotation", "java/lang/annotation/Annotation");
        for (String str2 : CollectionsKt__CollectionsKt.listOf("String", "CharSequence", "Throwable", "Cloneable", "Number", "Comparable", "Enum")) {
            m7568map$lambda0$add(linkedHashMap, str2, "java/lang/" + str2);
        }
        for (String str3 : CollectionsKt__CollectionsKt.listOf("Iterator", "Collection", "List", "Set", "Map", "ListIterator")) {
            m7568map$lambda0$add(linkedHashMap, "collections/" + str3, "java/util/" + str3);
            m7568map$lambda0$add(linkedHashMap, "collections/Mutable" + str3, "java/util/" + str3);
        }
        m7568map$lambda0$add(linkedHashMap, "collections/Iterable", "java/lang/Iterable");
        m7568map$lambda0$add(linkedHashMap, "collections/MutableIterable", "java/lang/Iterable");
        m7568map$lambda0$add(linkedHashMap, "collections/Map.Entry", "java/util/Map$Entry");
        m7568map$lambda0$add(linkedHashMap, "collections/MutableMap.MutableEntry", "java/util/Map$Entry");
        for (int i13 = 0; i13 < 23; i13++) {
            StringBuilder sb3 = new StringBuilder();
            String str4 = f24741kotlin;
            sb3.append(str4);
            sb3.append("/jvm/functions/Function");
            sb3.append(i13);
            m7568map$lambda0$add(linkedHashMap, "Function" + i13, sb3.toString());
            m7568map$lambda0$add(linkedHashMap, "reflect/KFunction" + i13, str4 + "/reflect/KFunction");
        }
        for (String str5 : CollectionsKt__CollectionsKt.listOf("Char", "Byte", "Short", "Int", "Float", "Long", "Double", "String", "Enum")) {
            m7568map$lambda0$add(linkedHashMap, str5 + ".Companion", f24741kotlin + "/jvm/internal/" + str5 + "CompanionObject");
        }
        map = linkedHashMap;
    }

    private ClassMapperLite() {
    }

    /* renamed from: map$lambda-0$add  reason: not valid java name */
    private static final void m7568map$lambda0$add(Map<String, String> map2, String str, String str2) {
        map2.put(f24741kotlin + '/' + str, 'L' + str2 + TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER);
    }

    @JvmStatic
    @NotNull
    public static final String mapClass(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "classId");
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        return 'L' + StringsKt__StringsJVMKt.replace$default(str, '.', '$', false, 4, (Object) null) + TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER;
    }
}
