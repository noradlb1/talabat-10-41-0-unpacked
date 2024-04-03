package kotlin.reflect.jvm.internal.impl.types.error;

import com.tekartik.sqflite.Constant;
import fwfd.com.fwfsdk.constant.FWFConstants;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public final class ErrorType extends SimpleType {
    @NotNull
    private final List<TypeProjection> arguments;
    @NotNull
    private final TypeConstructor constructor;
    @NotNull
    private final String debugMessage;
    @NotNull
    private final String[] formatParams;
    private final boolean isMarkedNullable;
    @NotNull
    private final ErrorTypeKind kind;
    @NotNull
    private final MemberScope memberScope;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ErrorType(TypeConstructor typeConstructor, MemberScope memberScope2, ErrorTypeKind errorTypeKind, List list, boolean z11, String[] strArr, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeConstructor, memberScope2, errorTypeKind, (i11 & 8) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i11 & 16) != 0 ? false : z11, strArr);
    }

    @NotNull
    public List<TypeProjection> getArguments() {
        return this.arguments;
    }

    @NotNull
    public TypeAttributes getAttributes() {
        return TypeAttributes.Companion.getEmpty();
    }

    @NotNull
    public TypeConstructor getConstructor() {
        return this.constructor;
    }

    @NotNull
    public final String getDebugMessage() {
        return this.debugMessage;
    }

    @NotNull
    public final ErrorTypeKind getKind() {
        return this.kind;
    }

    @NotNull
    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    @NotNull
    public ErrorType refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @NotNull
    public SimpleType replaceAttributes(@NotNull TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeAttributes, "newAttributes");
        return this;
    }

    @NotNull
    public SimpleType makeNullableAsSpecified(boolean z11) {
        TypeConstructor constructor2 = getConstructor();
        MemberScope memberScope2 = getMemberScope();
        ErrorTypeKind errorTypeKind = this.kind;
        List<TypeProjection> arguments2 = getArguments();
        String[] strArr = this.formatParams;
        return new ErrorType(constructor2, memberScope2, errorTypeKind, arguments2, z11, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    @JvmOverloads
    public ErrorType(@NotNull TypeConstructor typeConstructor, @NotNull MemberScope memberScope2, @NotNull ErrorTypeKind errorTypeKind, @NotNull List<? extends TypeProjection> list, boolean z11, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(memberScope2, "memberScope");
        Intrinsics.checkNotNullParameter(errorTypeKind, FWFConstants.EXPLANATION_TYPE_KIND);
        Intrinsics.checkNotNullParameter(list, Constant.PARAM_SQL_ARGUMENTS);
        Intrinsics.checkNotNullParameter(strArr, "formatParams");
        this.constructor = typeConstructor;
        this.memberScope = memberScope2;
        this.kind = errorTypeKind;
        this.arguments = list;
        this.isMarkedNullable = z11;
        this.formatParams = strArr;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String debugMessage2 = errorTypeKind.getDebugMessage();
        Object[] copyOf = Arrays.copyOf(strArr, strArr.length);
        String format = String.format(debugMessage2, Arrays.copyOf(copyOf, copyOf.length));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        this.debugMessage = format;
    }
}
