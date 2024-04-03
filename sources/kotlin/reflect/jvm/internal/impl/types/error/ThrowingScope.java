package kotlin.reflect.jvm.internal.impl.types.error;

import fwfd.com.fwfsdk.constant.FWFConstants;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;

public final class ThrowingScope extends ErrorScope {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThrowingScope(@NotNull ErrorScopeKind errorScopeKind, @NotNull String... strArr) {
        super(errorScopeKind, (String[]) Arrays.copyOf(strArr, strArr.length));
        Intrinsics.checkNotNullParameter(errorScopeKind, FWFConstants.EXPLANATION_TYPE_KIND);
        Intrinsics.checkNotNullParameter(strArr, "formatParams");
    }

    @NotNull
    public Set<Name> getClassifierNames() {
        throw new IllegalStateException();
    }

    @NotNull
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        throw new IllegalStateException(a() + ", required name: " + name2);
    }

    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        throw new IllegalStateException(a());
    }

    @NotNull
    public Set<Name> getFunctionNames() {
        throw new IllegalStateException();
    }

    @NotNull
    public Set<Name> getVariableNames() {
        throw new IllegalStateException();
    }

    @NotNull
    public String toString() {
        return "ThrowingScope{" + a() + AbstractJsonLexerKt.END_OBJ;
    }

    @NotNull
    public Set<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        throw new IllegalStateException(a() + ", required name: " + name2);
    }

    @NotNull
    public Set<PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        throw new IllegalStateException(a() + ", required name: " + name2);
    }

    @NotNull
    public Void recordLookup(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        throw new IllegalStateException();
    }
}
