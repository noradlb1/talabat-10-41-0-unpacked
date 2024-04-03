package kotlin.reflect.jvm.internal.impl.util.collectionUtils;

import com.talabat.gem.integration.GemAccessor;
import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ScopeUtilsKt {
    @Nullable
    public static final <T> Collection<T> concat(@Nullable Collection<? extends T> collection, @NotNull Collection<? extends T> collection2) {
        Intrinsics.checkNotNullParameter(collection2, GemAccessor.COMPONENT_COLLECTION);
        if (collection2.isEmpty()) {
            return collection;
        }
        if (collection == null) {
            return collection2;
        }
        if (collection instanceof LinkedHashSet) {
            ((LinkedHashSet) collection).addAll(collection2);
            return collection;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        linkedHashSet.addAll(collection2);
        return linkedHashSet;
    }

    @NotNull
    public static final SmartList<MemberScope> listOfNonEmptyScopes(@NotNull Iterable<? extends MemberScope> iterable) {
        boolean z11;
        Intrinsics.checkNotNullParameter(iterable, "scopes");
        SmartList<MemberScope> smartList = new SmartList<>();
        for (Object next : iterable) {
            MemberScope memberScope = (MemberScope) next;
            if (memberScope == null || memberScope == MemberScope.Empty.INSTANCE) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                smartList.add(next);
            }
        }
        return smartList;
    }
}
