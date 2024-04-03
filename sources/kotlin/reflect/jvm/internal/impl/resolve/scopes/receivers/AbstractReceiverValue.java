package kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers;

import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractReceiverValue implements ReceiverValue {

    /* renamed from: a  reason: collision with root package name */
    public final KotlinType f24822a;
    private final ReceiverValue original;

    private static /* synthetic */ void $$$reportNull$$$0(int i11) {
        String str = (i11 == 1 || i11 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[((i11 == 1 || i11 == 2) ? 2 : 3)];
        if (i11 == 1 || i11 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[0] = "receiverType";
        }
        if (i11 == 1) {
            objArr[1] = "getType";
        } else if (i11 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[1] = "getOriginal";
        }
        if (!(i11 == 1 || i11 == 2)) {
            objArr[2] = MethodDescription.CONSTRUCTOR_INTERNAL_NAME;
        }
        String format = String.format(str, objArr);
        throw ((i11 == 1 || i11 == 2) ? new IllegalStateException(format) : new IllegalArgumentException(format));
    }

    public AbstractReceiverValue(@NotNull KotlinType kotlinType, @Nullable ReceiverValue receiverValue) {
        if (kotlinType == null) {
            $$$reportNull$$$0(0);
        }
        this.f24822a = kotlinType;
        this.original = receiverValue == null ? this : receiverValue;
    }

    @NotNull
    public KotlinType getType() {
        KotlinType kotlinType = this.f24822a;
        if (kotlinType == null) {
            $$$reportNull$$$0(1);
        }
        return kotlinType;
    }
}
