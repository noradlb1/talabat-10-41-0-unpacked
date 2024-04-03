package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.SinceKotlin;
import kotlin.reflect.KDeclarationContainer;

@SinceKotlin(version = "1.4")
public class AdaptedFunctionReference implements FunctionBase, Serializable {
    private final int arity;

    /* renamed from: b  reason: collision with root package name */
    public final Object f23889b;
    private final int flags;
    private final boolean isTopLevel;

    /* renamed from: name  reason: collision with root package name */
    private final String f23890name;
    private final Class owner;
    private final String signature;

    public AdaptedFunctionReference(int i11, Class cls, String str, String str2, int i12) {
        this(i11, CallableReference.NO_RECEIVER, cls, str, str2, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdaptedFunctionReference)) {
            return false;
        }
        AdaptedFunctionReference adaptedFunctionReference = (AdaptedFunctionReference) obj;
        if (this.isTopLevel != adaptedFunctionReference.isTopLevel || this.arity != adaptedFunctionReference.arity || this.flags != adaptedFunctionReference.flags || !Intrinsics.areEqual(this.f23889b, adaptedFunctionReference.f23889b) || !Intrinsics.areEqual((Object) this.owner, (Object) adaptedFunctionReference.owner) || !this.f23890name.equals(adaptedFunctionReference.f23890name) || !this.signature.equals(adaptedFunctionReference.signature)) {
            return false;
        }
        return true;
    }

    public int getArity() {
        return this.arity;
    }

    public KDeclarationContainer getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? Reflection.getOrCreateKotlinPackage(cls) : Reflection.getOrCreateKotlinClass(cls);
    }

    public int hashCode() {
        int i11;
        int i12;
        Object obj = this.f23889b;
        int i13 = 0;
        if (obj != null) {
            i11 = obj.hashCode();
        } else {
            i11 = 0;
        }
        int i14 = i11 * 31;
        Class cls = this.owner;
        if (cls != null) {
            i13 = cls.hashCode();
        }
        int hashCode = (((((i14 + i13) * 31) + this.f23890name.hashCode()) * 31) + this.signature.hashCode()) * 31;
        if (this.isTopLevel) {
            i12 = 1231;
        } else {
            i12 = 1237;
        }
        return ((((hashCode + i12) * 31) + this.arity) * 31) + this.flags;
    }

    public String toString() {
        return Reflection.renderLambdaToString((FunctionBase) this);
    }

    public AdaptedFunctionReference(int i11, Object obj, Class cls, String str, String str2, int i12) {
        this.f23889b = obj;
        this.owner = cls;
        this.f23890name = str;
        this.signature = str2;
        this.isTopLevel = (i12 & 1) == 1;
        this.arity = i11;
        this.flags = i12 >> 1;
    }
}
