package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

public final class ReflectJavaClass$methods$1 extends Lambda implements Function1<Method, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ReflectJavaClass f24564g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReflectJavaClass$methods$1(ReflectJavaClass reflectJavaClass) {
        super(1);
        this.f24564g = reflectJavaClass;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001c, code lost:
        if (r0.isEnumValuesOrValueOf(r5) == false) goto L_0x001e;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean invoke(java.lang.reflect.Method r5) {
        /*
            r4 = this;
            boolean r0 = r5.isSynthetic()
            r1 = 0
            if (r0 == 0) goto L_0x0008
            goto L_0x001f
        L_0x0008:
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass r0 = r4.f24564g
            boolean r0 = r0.isEnum()
            r2 = 1
            if (r0 == 0) goto L_0x001e
            kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass r0 = r4.f24564g
            java.lang.String r3 = "method"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
            boolean r5 = r0.isEnumValuesOrValueOf(r5)
            if (r5 != 0) goto L_0x001f
        L_0x001e:
            r1 = r2
        L_0x001f:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectJavaClass$methods$1.invoke(java.lang.reflect.Method):java.lang.Boolean");
    }
}
