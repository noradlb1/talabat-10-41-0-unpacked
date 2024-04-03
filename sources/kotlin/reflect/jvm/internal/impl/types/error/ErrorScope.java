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
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;

public class ErrorScope implements MemberScope {
    @NotNull
    private final String debugMessage;
    @NotNull
    private final ErrorScopeKind kind;

    public ErrorScope(@NotNull ErrorScopeKind errorScopeKind, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(errorScopeKind, FWFConstants.EXPLANATION_TYPE_KIND);
        Intrinsics.checkNotNullParameter(strArr, "formatParams");
        this.kind = errorScopeKind;
        String debugMessage2 = errorScopeKind.getDebugMessage();
        Object[] copyOf = Arrays.copyOf(strArr, strArr.length);
        String format = String.format(debugMessage2, Arrays.copyOf(copyOf, copyOf.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        this.debugMessage = format;
    }

    @NotNull
    public final String a() {
        return this.debugMessage;
    }

    @NotNull
    public Set<Name> getClassifierNames() {
        return SetsKt__SetsKt.emptySet();
    }

    @NotNull
    public ClassifierDescriptor getContributedClassifier(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        String format = String.format(ErrorEntity.ERROR_CLASS.getDebugText(), Arrays.copyOf(new Object[]{name2}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        Name special = Name.special(format);
        Intrinsics.checkNotNullExpressionValue(special, "special(ErrorEntity.ERRO…S.debugText.format(name))");
        return new ErrorClassDescriptor(special);
    }

    @NotNull
    public Collection<DeclarationDescriptor> getContributedDescriptors(@NotNull DescriptorKindFilter descriptorKindFilter, @NotNull Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public Set<Name> getFunctionNames() {
        return SetsKt__SetsKt.emptySet();
    }

    @NotNull
    public Set<Name> getVariableNames() {
        return SetsKt__SetsKt.emptySet();
    }

    public void recordLookup(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
    }

    @NotNull
    public String toString() {
        return "ErrorScope{" + this.debugMessage + AbstractJsonLexerKt.END_OBJ;
    }

    @NotNull
    public Set<SimpleFunctionDescriptor> getContributedFunctions(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return SetsKt__SetsJVMKt.setOf(new ErrorFunctionDescriptor(ErrorUtils.INSTANCE.getErrorClass()));
    }

    @NotNull
    public Set<PropertyDescriptor> getContributedVariables(@NotNull Name name2, @NotNull LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name2, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, "location");
        return ErrorUtils.INSTANCE.getErrorPropertyGroup();
    }
}
