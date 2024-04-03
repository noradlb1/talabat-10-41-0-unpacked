package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import net.bytebuddy.description.method.MethodDescription;

public class FunctionReference extends CallableReference implements FunctionBase, KFunction {
    private final int arity;
    @SinceKotlin(version = "1.4")
    private final int flags;

    public FunctionReference(int i11) {
        this(i11, CallableReference.NO_RECEIVER, (Class) null, (String) null, (String) null, 0);
    }

    @SinceKotlin(version = "1.1")
    public KCallable computeReflected() {
        return Reflection.function(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            if (!getName().equals(functionReference.getName()) || !getSignature().equals(functionReference.getSignature()) || this.flags != functionReference.flags || this.arity != functionReference.arity || !Intrinsics.areEqual(getBoundReceiver(), functionReference.getBoundReceiver()) || !Intrinsics.areEqual((Object) getOwner(), (Object) functionReference.getOwner())) {
                return false;
            }
            return true;
        } else if (obj instanceof KFunction) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public int getArity() {
        return this.arity;
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @SinceKotlin(version = "1.1")
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @SinceKotlin(version = "1.1")
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @SinceKotlin(version = "1.1")
    public boolean isInline() {
        return getReflected().isInline();
    }

    @SinceKotlin(version = "1.1")
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @SinceKotlin(version = "1.1")
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        KCallable compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        if (MethodDescription.CONSTRUCTOR_INTERNAL_NAME.equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    @SinceKotlin(version = "1.1")
    public FunctionReference(int i11, Object obj) {
        this(i11, obj, (Class) null, (String) null, (String) null, 0);
    }

    @SinceKotlin(version = "1.1")
    public KFunction getReflected() {
        return (KFunction) super.getReflected();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @SinceKotlin(version = "1.4")
    public FunctionReference(int i11, Object obj, Class cls, String str, String str2, int i12) {
        super(obj, cls, str, str2, (i12 & 1) == 1);
        this.arity = i11;
        this.flags = i12 >> 1;
    }
}
