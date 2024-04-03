package kotlin.reflect.jvm.internal.impl.types;

import com.talabat.fluttercore.channels.AnalyticsMethodChannel;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.implementation.MethodDelegation;
import org.jetbrains.annotations.NotNull;

final class SimpleTypeWithAttributes extends DelegatingSimpleTypeImpl {
    @NotNull
    private final TypeAttributes attributes;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleTypeWithAttributes(@NotNull SimpleType simpleType, @NotNull TypeAttributes typeAttributes) {
        super(simpleType);
        Intrinsics.checkNotNullParameter(simpleType, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        Intrinsics.checkNotNullParameter(typeAttributes, AnalyticsMethodChannel.EVENT_ATTRIBUTES_KEY);
        this.attributes = typeAttributes;
    }

    @NotNull
    public TypeAttributes getAttributes() {
        return this.attributes;
    }

    @NotNull
    public SimpleTypeWithAttributes replaceDelegate(@NotNull SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX);
        return new SimpleTypeWithAttributes(simpleType, getAttributes());
    }
}
