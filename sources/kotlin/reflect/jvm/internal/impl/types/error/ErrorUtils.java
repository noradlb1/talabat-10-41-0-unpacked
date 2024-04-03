package kotlin.reflect.jvm.internal.impl.types.error;

import com.tekartik.sqflite.Constant;
import fwfd.com.fwfsdk.constant.FWFConstants;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ErrorUtils {
    @NotNull
    public static final ErrorUtils INSTANCE = new ErrorUtils();
    @NotNull
    private static final ErrorClassDescriptor errorClass;
    @NotNull
    private static final ModuleDescriptor errorModule = ErrorModuleDescriptor.INSTANCE;
    @NotNull
    private static final PropertyDescriptor errorProperty;
    @NotNull
    private static final Set<PropertyDescriptor> errorPropertyGroup;
    @NotNull
    private static final KotlinType errorPropertyType = createErrorType(ErrorTypeKind.ERROR_PROPERTY_TYPE, new String[0]);
    @NotNull
    private static final KotlinType errorTypeForLoopInSupertypes = createErrorType(ErrorTypeKind.CYCLIC_SUPERTYPES, new String[0]);

    static {
        String format = String.format(ErrorEntity.ERROR_CLASS.getDebugText(), Arrays.copyOf(new Object[]{"unknown class"}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        Name special = Name.special(format);
        Intrinsics.checkNotNullExpressionValue(special, "special(ErrorEntity.ERRO….format(\"unknown class\"))");
        errorClass = new ErrorClassDescriptor(special);
        ErrorPropertyDescriptor errorPropertyDescriptor = new ErrorPropertyDescriptor();
        errorProperty = errorPropertyDescriptor;
        errorPropertyGroup = SetsKt__SetsJVMKt.setOf(errorPropertyDescriptor);
    }

    private ErrorUtils() {
    }

    @JvmStatic
    @NotNull
    public static final ErrorScope createErrorScope(@NotNull ErrorScopeKind errorScopeKind, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(errorScopeKind, FWFConstants.EXPLANATION_TYPE_KIND);
        Intrinsics.checkNotNullParameter(strArr, "formatParams");
        return createErrorScope(errorScopeKind, false, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @JvmStatic
    @NotNull
    public static final ErrorType createErrorType(@NotNull ErrorTypeKind errorTypeKind, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(errorTypeKind, FWFConstants.EXPLANATION_TYPE_KIND);
        Intrinsics.checkNotNullParameter(strArr, "formatParams");
        return INSTANCE.createErrorTypeWithArguments(errorTypeKind, CollectionsKt__CollectionsKt.emptyList(), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @JvmStatic
    public static final boolean isError(@Nullable DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor != null) {
            ErrorUtils errorUtils = INSTANCE;
            if (errorUtils.isErrorClass(declarationDescriptor) || errorUtils.isErrorClass(declarationDescriptor.getContainingDeclaration()) || declarationDescriptor == errorModule) {
                return true;
            }
        }
        return false;
    }

    private final boolean isErrorClass(DeclarationDescriptor declarationDescriptor) {
        return declarationDescriptor instanceof ErrorClassDescriptor;
    }

    @JvmStatic
    public static final boolean isUninferredTypeVariable(@Nullable KotlinType kotlinType) {
        if (kotlinType == null) {
            return false;
        }
        TypeConstructor constructor = kotlinType.getConstructor();
        if (!(constructor instanceof ErrorTypeConstructor) || ((ErrorTypeConstructor) constructor).getKind() != ErrorTypeKind.UNINFERRED_TYPE_VARIABLE) {
            return false;
        }
        return true;
    }

    @NotNull
    public final ErrorTypeConstructor createErrorTypeConstructor(@NotNull ErrorTypeKind errorTypeKind, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(errorTypeKind, FWFConstants.EXPLANATION_TYPE_KIND);
        Intrinsics.checkNotNullParameter(strArr, "formatParams");
        return new ErrorTypeConstructor(errorTypeKind, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @NotNull
    public final ErrorType createErrorTypeWithArguments(@NotNull ErrorTypeKind errorTypeKind, @NotNull List<? extends TypeProjection> list, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(errorTypeKind, FWFConstants.EXPLANATION_TYPE_KIND);
        Intrinsics.checkNotNullParameter(list, Constant.PARAM_SQL_ARGUMENTS);
        Intrinsics.checkNotNullParameter(strArr, "formatParams");
        return createErrorTypeWithArguments(errorTypeKind, list, createErrorTypeConstructor(errorTypeKind, (String[]) Arrays.copyOf(strArr, strArr.length)), (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @NotNull
    public final ErrorClassDescriptor getErrorClass() {
        return errorClass;
    }

    @NotNull
    public final ModuleDescriptor getErrorModule() {
        return errorModule;
    }

    @NotNull
    public final Set<PropertyDescriptor> getErrorPropertyGroup() {
        return errorPropertyGroup;
    }

    @NotNull
    public final KotlinType getErrorPropertyType() {
        return errorPropertyType;
    }

    @NotNull
    public final KotlinType getErrorTypeForLoopInSupertypes() {
        return errorTypeForLoopInSupertypes;
    }

    @JvmStatic
    @NotNull
    public static final ErrorScope createErrorScope(@NotNull ErrorScopeKind errorScopeKind, boolean z11, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(errorScopeKind, FWFConstants.EXPLANATION_TYPE_KIND);
        Intrinsics.checkNotNullParameter(strArr, "formatParams");
        return z11 ? new ThrowingScope(errorScopeKind, (String[]) Arrays.copyOf(strArr, strArr.length)) : new ErrorScope(errorScopeKind, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @NotNull
    public final ErrorType createErrorType(@NotNull ErrorTypeKind errorTypeKind, @NotNull TypeConstructor typeConstructor, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(errorTypeKind, FWFConstants.EXPLANATION_TYPE_KIND);
        Intrinsics.checkNotNullParameter(typeConstructor, "typeConstructor");
        Intrinsics.checkNotNullParameter(strArr, "formatParams");
        return createErrorTypeWithArguments(errorTypeKind, CollectionsKt__CollectionsKt.emptyList(), typeConstructor, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @NotNull
    public final ErrorType createErrorTypeWithArguments(@NotNull ErrorTypeKind errorTypeKind, @NotNull List<? extends TypeProjection> list, @NotNull TypeConstructor typeConstructor, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(errorTypeKind, FWFConstants.EXPLANATION_TYPE_KIND);
        Intrinsics.checkNotNullParameter(list, Constant.PARAM_SQL_ARGUMENTS);
        Intrinsics.checkNotNullParameter(typeConstructor, "typeConstructor");
        Intrinsics.checkNotNullParameter(strArr, "formatParams");
        return new ErrorType(typeConstructor, createErrorScope(ErrorScopeKind.ERROR_TYPE_SCOPE, typeConstructor.toString()), errorTypeKind, list, false, (String[]) Arrays.copyOf(strArr, strArr.length));
    }
}
