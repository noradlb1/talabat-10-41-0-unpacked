package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u00012\u000e\u0010\u0004\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00060\u00062,\u0010\u0007\u001a(\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\b0\bH\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "T", "<anonymous parameter 0>", "method", "Ljava/lang/reflect/Method;", "args", "", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class AnnotationConstructorCallerKt$createAnnotationInstance$result$1 implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Class<T> f24443a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map<String, Object> f24444b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Lazy<String> f24445c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Lazy<Integer> f24446d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ List<Method> f24447e;

    public AnnotationConstructorCallerKt$createAnnotationInstance$result$1(Class<T> cls, Map<String, ? extends Object> map, Lazy<String> lazy, Lazy<Integer> lazy2, List<Method> list) {
        this.f24443a = cls;
        this.f24444b = map;
        this.f24445c = lazy;
        this.f24446d = lazy2;
        this.f24447e = list;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0057, code lost:
        if (r6.length == 1) goto L_0x005b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(java.lang.Object r4, java.lang.reflect.Method r5, java.lang.Object[] r6) {
        /*
            r3 = this;
            java.lang.String r4 = r5.getName()
            if (r4 == 0) goto L_0x004a
            int r0 = r4.hashCode()
            r1 = -1776922004(0xffffffff9616526c, float:-1.2142911E-25)
            if (r0 == r1) goto L_0x003a
            r1 = 147696667(0x8cdac1b, float:1.23784505E-33)
            if (r0 == r1) goto L_0x0026
            r1 = 1444986633(0x5620bf09, float:4.4185588E13)
            if (r0 == r1) goto L_0x001a
            goto L_0x004a
        L_0x001a:
            java.lang.String r0 = "annotationType"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L_0x0023
            goto L_0x004a
        L_0x0023:
            java.lang.Class<T> r4 = r3.f24443a
            goto L_0x0083
        L_0x0026:
            java.lang.String r0 = "hashCode"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L_0x002f
            goto L_0x004a
        L_0x002f:
            kotlin.Lazy<java.lang.Integer> r4 = r3.f24446d
            int r4 = kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.m7566createAnnotationInstance$lambda2(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x0083
        L_0x003a:
            java.lang.String r0 = "toString"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L_0x0043
            goto L_0x004a
        L_0x0043:
            kotlin.Lazy<java.lang.String> r4 = r3.f24445c
            java.lang.String r4 = kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.m7567createAnnotationInstance$lambda3(r4)
            goto L_0x0083
        L_0x004a:
            java.lang.String r0 = "equals"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r0)
            r1 = 0
            if (r0 == 0) goto L_0x0075
            if (r6 == 0) goto L_0x005a
            int r0 = r6.length
            r2 = 1
            if (r0 != r2) goto L_0x005a
            goto L_0x005b
        L_0x005a:
            r2 = r1
        L_0x005b:
            if (r2 == 0) goto L_0x0075
            java.lang.Class<T> r4 = r3.f24443a
            java.util.List<java.lang.reflect.Method> r5 = r3.f24447e
            java.util.Map<java.lang.String, java.lang.Object> r0 = r3.f24444b
            java.lang.String r1 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r1)
            java.lang.Object r6 = kotlin.collections.ArraysKt___ArraysKt.single((T[]) r6)
            boolean r4 = kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance$equals(r4, r5, r0, r6)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            goto L_0x0083
        L_0x0075:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r3.f24444b
            boolean r0 = r0.containsKey(r4)
            if (r0 == 0) goto L_0x0084
            java.util.Map<java.lang.String, java.lang.Object> r5 = r3.f24444b
            java.lang.Object r4 = r5.get(r4)
        L_0x0083:
            return r4
        L_0x0084:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r4 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "Method is not supported: "
            r0.append(r2)
            r0.append(r5)
            java.lang.String r5 = " (args: "
            r0.append(r5)
            if (r6 != 0) goto L_0x009c
            java.lang.Object[] r6 = new java.lang.Object[r1]
        L_0x009c:
            java.util.List r5 = kotlin.collections.ArraysKt___ArraysKt.toList((T[]) r6)
            r0.append(r5)
            r5 = 41
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt$createAnnotationInstance$result$1.invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):java.lang.Object");
    }
}
