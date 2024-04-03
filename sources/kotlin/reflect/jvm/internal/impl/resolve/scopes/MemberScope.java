package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface MemberScope extends ResolutionScope {
    @NotNull
    public static final Companion Companion = Companion.f24818a;

    public static final class Companion {
        @NotNull
        private static final Function1<Name, Boolean> ALL_NAME_FILTER = MemberScope$Companion$ALL_NAME_FILTER$1.INSTANCE;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f24818a = new Companion();

        private Companion() {
        }

        @NotNull
        public final Function1<Name, Boolean> getALL_NAME_FILTER() {
            return ALL_NAME_FILTER;
        }
    }

    public static final class DefaultImpls {
        public static void recordLookup(@NotNull MemberScope memberScope, @NotNull Name name2, @NotNull LookupLocation lookupLocation) {
            Intrinsics.checkNotNullParameter(name2, "name");
            Intrinsics.checkNotNullParameter(lookupLocation, "location");
            ResolutionScope.DefaultImpls.recordLookup(memberScope, name2, lookupLocation);
        }
    }

    public static final class Empty extends MemberScopeImpl {
        @NotNull
        public static final Empty INSTANCE = new Empty();

        private Empty() {
        }

        @NotNull
        public Set<Name> getClassifierNames() {
            return SetsKt__SetsKt.emptySet();
        }

        @NotNull
        public Set<Name> getFunctionNames() {
            return SetsKt__SetsKt.emptySet();
        }

        @NotNull
        public Set<Name> getVariableNames() {
            return SetsKt__SetsKt.emptySet();
        }
    }

    @Nullable
    Set<Name> getClassifierNames();

    @NotNull
    Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation lookupLocation);

    @NotNull
    Collection<? extends PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation lookupLocation);

    @NotNull
    Set<Name> getFunctionNames();

    @NotNull
    Set<Name> getVariableNames();
}
