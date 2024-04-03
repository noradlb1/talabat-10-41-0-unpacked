package kotlin.jvm.internal;

import kotlin.SinceKotlin;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int i11, KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(i11, CallableReference.NO_RECEIVER, ((ClassBasedDeclarationContainer) kDeclarationContainer).getJClass(), str, str2, (kDeclarationContainer instanceof KClass) ^ true ? 1 : 0);
    }

    @SinceKotlin(version = "1.4")
    public FunctionReferenceImpl(int i11, Class cls, String str, String str2, int i12) {
        super(i11, CallableReference.NO_RECEIVER, cls, str, str2, i12);
    }

    @SinceKotlin(version = "1.4")
    public FunctionReferenceImpl(int i11, Object obj, Class cls, String str, String str2, int i12) {
        super(i11, obj, cls, str, str2, i12);
    }
}
