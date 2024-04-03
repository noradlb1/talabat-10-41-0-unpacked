package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.pool.TypePool;
import org.jetbrains.annotations.NotNull;

public final class SignatureBuildingComponents {
    @NotNull
    public static final SignatureBuildingComponents INSTANCE = new SignatureBuildingComponents();

    private SignatureBuildingComponents() {
    }

    /* access modifiers changed from: private */
    public final String escapeClassName(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return 'L' + str + TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER;
    }

    @NotNull
    public final String[] constructors(@NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "signatures");
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add("<init>(" + str + ")V");
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (String[]) array;
    }

    @NotNull
    public final Set<String> inClass(@NotNull String str, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(str, "internalName");
        Intrinsics.checkNotNullParameter(strArr, "signatures");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (String str2 : strArr) {
            linkedHashSet.add(str + '.' + str2);
        }
        return linkedHashSet;
    }

    @NotNull
    public final Set<String> inJavaLang(@NotNull String str, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(strArr, "signatures");
        return inClass(javaLang(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @NotNull
    public final Set<String> inJavaUtil(@NotNull String str, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(strArr, "signatures");
        return inClass(javaUtil(str), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @NotNull
    public final String javaFunction(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return "java/util/function/" + str;
    }

    @NotNull
    public final String javaLang(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return "java/lang/" + str;
    }

    @NotNull
    public final String javaUtil(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return "java/util/" + str;
    }

    @NotNull
    public final String jvmDescriptor(@NotNull String str, @NotNull List<String> list, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(list, "parameters");
        Intrinsics.checkNotNullParameter(str2, "ret");
        return str + '(' + CollectionsKt___CollectionsKt.joinToString$default(list, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, SignatureBuildingComponents$jvmDescriptor$1.INSTANCE, 30, (Object) null) + ')' + escapeClassName(str2);
    }

    @NotNull
    public final String signature(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "internalName");
        Intrinsics.checkNotNullParameter(str2, "jvmDescriptor");
        return str + '.' + str2;
    }
}
