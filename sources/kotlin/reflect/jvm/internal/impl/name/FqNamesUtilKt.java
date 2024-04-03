package kotlin.reflect.jvm.internal.impl.name;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class FqNamesUtilKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            iArr[State.BEGINNING.ordinal()] = 1;
            iArr[State.AFTER_DOT.ordinal()] = 2;
            iArr[State.MIDDLE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Nullable
    public static final <V> V findValueForMostSpecificFqname(@NotNull FqName fqName, @NotNull Map<FqName, ? extends V> map) {
        Object obj;
        Intrinsics.checkNotNullParameter(fqName, "<this>");
        Intrinsics.checkNotNullParameter(map, "values");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<FqName, ? extends V>> it = map.entrySet().iterator();
        while (true) {
            boolean z11 = true;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry next = it.next();
            FqName fqName2 = (FqName) next.getKey();
            if (!Intrinsics.areEqual((Object) fqName, (Object) fqName2) && !isChildOf(fqName, fqName2)) {
                z11 = false;
            }
            if (z11) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        if (!(!linkedHashMap.isEmpty())) {
            linkedHashMap = null;
        }
        if (linkedHashMap == null) {
            return null;
        }
        Iterator it2 = linkedHashMap.entrySet().iterator();
        if (!it2.hasNext()) {
            obj = null;
        } else {
            obj = it2.next();
            if (it2.hasNext()) {
                int length = tail((FqName) ((Map.Entry) obj).getKey(), fqName).asString().length();
                do {
                    Object next2 = it2.next();
                    int length2 = tail((FqName) ((Map.Entry) next2).getKey(), fqName).asString().length();
                    if (length > length2) {
                        obj = next2;
                        length = length2;
                    }
                } while (it2.hasNext());
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry != null) {
            return entry.getValue();
        }
        return null;
    }

    public static final boolean isChildOf(@NotNull FqName fqName, @NotNull FqName fqName2) {
        Intrinsics.checkNotNullParameter(fqName, "<this>");
        Intrinsics.checkNotNullParameter(fqName2, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        return Intrinsics.areEqual((Object) parentOrNull(fqName), (Object) fqName2);
    }

    public static final boolean isSubpackageOf(@NotNull FqName fqName, @NotNull FqName fqName2) {
        Intrinsics.checkNotNullParameter(fqName, "<this>");
        Intrinsics.checkNotNullParameter(fqName2, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        if (Intrinsics.areEqual((Object) fqName, (Object) fqName2) || fqName2.isRoot()) {
            return true;
        }
        String asString = fqName.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "this.asString()");
        String asString2 = fqName2.asString();
        Intrinsics.checkNotNullExpressionValue(asString2, "packageName.asString()");
        return isSubpackageOf(asString, asString2);
    }

    public static final boolean isValidJavaFqName(@Nullable String str) {
        if (str == null) {
            return false;
        }
        State state = State.BEGINNING;
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            int i12 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i12 == 1 || i12 == 2) {
                if (!Character.isJavaIdentifierPart(charAt)) {
                    return false;
                }
                state = State.MIDDLE;
            } else if (i12 != 3) {
                continue;
            } else if (charAt == '.') {
                state = State.AFTER_DOT;
            } else if (!Character.isJavaIdentifierPart(charAt)) {
                return false;
            }
        }
        if (state != State.AFTER_DOT) {
            return true;
        }
        return false;
    }

    @Nullable
    public static final FqName parentOrNull(@NotNull FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "<this>");
        if (fqName.isRoot()) {
            return null;
        }
        return fqName.parent();
    }

    @NotNull
    public static final FqName tail(@NotNull FqName fqName, @NotNull FqName fqName2) {
        Intrinsics.checkNotNullParameter(fqName, "<this>");
        Intrinsics.checkNotNullParameter(fqName2, "prefix");
        if (!isSubpackageOf(fqName, fqName2) || fqName2.isRoot()) {
            return fqName;
        }
        if (Intrinsics.areEqual((Object) fqName, (Object) fqName2)) {
            FqName fqName3 = FqName.ROOT;
            Intrinsics.checkNotNullExpressionValue(fqName3, "ROOT");
            return fqName3;
        }
        String asString = fqName.asString();
        Intrinsics.checkNotNullExpressionValue(asString, "asString()");
        String substring = asString.substring(fqName2.asString().length() + 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return new FqName(substring);
    }

    private static final boolean isSubpackageOf(String str, String str2) {
        return StringsKt__StringsJVMKt.startsWith$default(str, str2, false, 2, (Object) null) && str.charAt(str2.length()) == '.';
    }
}
