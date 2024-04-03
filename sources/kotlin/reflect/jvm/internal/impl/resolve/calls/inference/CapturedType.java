package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import net.bytebuddy.description.type.TypeDescription;
import org.jetbrains.annotations.NotNull;

public final class CapturedType extends SimpleType implements CapturedTypeMarker {
    @NotNull
    private final TypeAttributes attributes;
    @NotNull
    private final CapturedTypeConstructor constructor;
    private final boolean isMarkedNullable;
    @NotNull
    private final TypeProjection typeProjection;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CapturedType(TypeProjection typeProjection2, CapturedTypeConstructor capturedTypeConstructor, boolean z11, TypeAttributes typeAttributes, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeProjection2, (i11 & 2) != 0 ? new CapturedTypeConstructorImpl(typeProjection2) : capturedTypeConstructor, (i11 & 4) != 0 ? false : z11, (i11 & 8) != 0 ? TypeAttributes.Companion.getEmpty() : typeAttributes);
    }

    @NotNull
    public List<TypeProjection> getArguments() {
        return CollectionsKt__CollectionsKt.emptyList();
    }

    @NotNull
    public TypeAttributes getAttributes() {
        return this.attributes;
    }

    @NotNull
    public MemberScope getMemberScope() {
        return ErrorUtils.createErrorScope(ErrorScopeKind.CAPTURED_TYPE_SCOPE, true, new String[0]);
    }

    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    @NotNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Captured(");
        sb2.append(this.typeProjection);
        sb2.append(')');
        sb2.append(isMarkedNullable() ? TypeDescription.Generic.OfWildcardType.SYMBOL : "");
        return sb2.toString();
    }

    @NotNull
    public CapturedTypeConstructor getConstructor() {
        return this.constructor;
    }

    @NotNull
    public SimpleType replaceAttributes(@NotNull TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeAttributes, "newAttributes");
        return new CapturedType(this.typeProjection, getConstructor(), isMarkedNullable(), typeAttributes);
    }

    @NotNull
    public CapturedType makeNullableAsSpecified(boolean z11) {
        if (z11 == isMarkedNullable()) {
            return this;
        }
        return new CapturedType(this.typeProjection, getConstructor(), z11, getAttributes());
    }

    @NotNull
    public CapturedType refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        TypeProjection refine = this.typeProjection.refine(kotlinTypeRefiner);
        Intrinsics.checkNotNullExpressionValue(refine, "typeProjection.refine(kotlinTypeRefiner)");
        return new CapturedType(refine, getConstructor(), isMarkedNullable(), getAttributes());
    }

    public CapturedType(@NotNull TypeProjection typeProjection2, @NotNull CapturedTypeConstructor capturedTypeConstructor, boolean z11, @NotNull TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeProjection2, "typeProjection");
        Intrinsics.checkNotNullParameter(capturedTypeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(typeAttributes, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        this.typeProjection = typeProjection2;
        this.constructor = capturedTypeConstructor;
        this.isMarkedNullable = z11;
        this.attributes = typeAttributes;
    }
}
