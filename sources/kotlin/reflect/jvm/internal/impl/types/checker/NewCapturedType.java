package kotlin.reflect.jvm.internal.impl.types.checker;

import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NewCapturedType extends SimpleType implements CapturedTypeMarker {
    @NotNull
    private final TypeAttributes attributes;
    @NotNull
    private final CaptureStatus captureStatus;
    @NotNull
    private final NewCapturedTypeConstructor constructor;
    private final boolean isMarkedNullable;
    private final boolean isProjectionNotNull;
    @Nullable
    private final UnwrappedType lowerType;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NewCapturedType(CaptureStatus captureStatus2, NewCapturedTypeConstructor newCapturedTypeConstructor, UnwrappedType unwrappedType, TypeAttributes typeAttributes, boolean z11, boolean z12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(captureStatus2, newCapturedTypeConstructor, unwrappedType, (i11 & 8) != 0 ? TypeAttributes.Companion.getEmpty() : typeAttributes, (i11 & 16) != 0 ? false : z11, (i11 & 32) != 0 ? false : z12);
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
    public final CaptureStatus getCaptureStatus() {
        return this.captureStatus;
    }

    @Nullable
    public final UnwrappedType getLowerType() {
        return this.lowerType;
    }

    @NotNull
    public MemberScope getMemberScope() {
        return ErrorUtils.createErrorScope(ErrorScopeKind.CAPTURED_TYPE_SCOPE, true, new String[0]);
    }

    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    public final boolean isProjectionNotNull() {
        return this.isProjectionNotNull;
    }

    @NotNull
    public NewCapturedTypeConstructor getConstructor() {
        return this.constructor;
    }

    @NotNull
    public SimpleType replaceAttributes(@NotNull TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeAttributes, "newAttributes");
        return new NewCapturedType(this.captureStatus, getConstructor(), this.lowerType, typeAttributes, isMarkedNullable(), this.isProjectionNotNull);
    }

    public NewCapturedType(@NotNull CaptureStatus captureStatus2, @NotNull NewCapturedTypeConstructor newCapturedTypeConstructor, @Nullable UnwrappedType unwrappedType, @NotNull TypeAttributes typeAttributes, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(captureStatus2, "captureStatus");
        Intrinsics.checkNotNullParameter(newCapturedTypeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(typeAttributes, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        this.captureStatus = captureStatus2;
        this.constructor = newCapturedTypeConstructor;
        this.lowerType = unwrappedType;
        this.attributes = typeAttributes;
        this.isMarkedNullable = z11;
        this.isProjectionNotNull = z12;
    }

    @NotNull
    public NewCapturedType makeNullableAsSpecified(boolean z11) {
        return new NewCapturedType(this.captureStatus, getConstructor(), this.lowerType, getAttributes(), z11, false, 32, (DefaultConstructorMarker) null);
    }

    @NotNull
    public NewCapturedType refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        CaptureStatus captureStatus2 = this.captureStatus;
        NewCapturedTypeConstructor refine = getConstructor().refine(kotlinTypeRefiner);
        UnwrappedType unwrappedType = this.lowerType;
        return new NewCapturedType(captureStatus2, refine, unwrappedType != null ? kotlinTypeRefiner.refineType(unwrappedType).unwrap() : null, getAttributes(), isMarkedNullable(), false, 32, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NewCapturedType(@NotNull CaptureStatus captureStatus2, @Nullable UnwrappedType unwrappedType, @NotNull TypeProjection typeProjection, @NotNull TypeParameterDescriptor typeParameterDescriptor) {
        this(captureStatus2, new NewCapturedTypeConstructor(typeProjection, (Function0) null, (NewCapturedTypeConstructor) null, typeParameterDescriptor, 6, (DefaultConstructorMarker) null), unwrappedType, (TypeAttributes) null, false, false, 56, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(captureStatus2, "captureStatus");
        Intrinsics.checkNotNullParameter(typeProjection, "projection");
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
    }
}
