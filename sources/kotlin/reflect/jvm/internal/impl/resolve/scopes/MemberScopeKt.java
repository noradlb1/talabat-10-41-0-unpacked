package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.HashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class MemberScopeKt {
    @Nullable
    public static final Set<Name> flatMapClassifierNamesOrNull(@NotNull Iterable<? extends MemberScope> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        HashSet hashSet = new HashSet();
        for (MemberScope classifierNames : iterable) {
            Set<Name> classifierNames2 = classifierNames.getClassifierNames();
            if (classifierNames2 == null) {
                return null;
            }
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(hashSet, classifierNames2);
        }
        return hashSet;
    }
}
