package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KFunctionImpl$caller$2 extends Lambda implements Function0<Caller<? extends Member>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KFunctionImpl f24397g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KFunctionImpl$caller$2(KFunctionImpl kFunctionImpl) {
        super(0);
        this.f24397g = kFunctionImpl;
    }

    public final Caller<Member> invoke() {
        Object obj;
        Caller caller;
        JvmFunctionSignature mapSignature = RuntimeTypeMapper.INSTANCE.mapSignature(this.f24397g.getDescriptor());
        if (mapSignature instanceof JvmFunctionSignature.KotlinConstructor) {
            if (this.f24397g.a()) {
                Class<?> jClass = this.f24397g.getContainer().getJClass();
                Iterable<KParameter> parameters = this.f24397g.getParameters();
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(parameters, 10));
                for (KParameter name2 : parameters) {
                    String name3 = name2.getName();
                    Intrinsics.checkNotNull(name3);
                    arrayList.add(name3);
                }
                return new AnnotationConstructorCaller(jClass, arrayList, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.KOTLIN, (List) null, 16, (DefaultConstructorMarker) null);
            }
            obj = this.f24397g.getContainer().findConstructorBySignature(((JvmFunctionSignature.KotlinConstructor) mapSignature).getConstructorDesc());
        } else if (mapSignature instanceof JvmFunctionSignature.KotlinFunction) {
            JvmFunctionSignature.KotlinFunction kotlinFunction = (JvmFunctionSignature.KotlinFunction) mapSignature;
            obj = this.f24397g.getContainer().findMethodBySignature(kotlinFunction.getMethodName(), kotlinFunction.getMethodDesc());
        } else if (mapSignature instanceof JvmFunctionSignature.JavaMethod) {
            obj = ((JvmFunctionSignature.JavaMethod) mapSignature).getMethod();
        } else if (mapSignature instanceof JvmFunctionSignature.JavaConstructor) {
            obj = ((JvmFunctionSignature.JavaConstructor) mapSignature).getConstructor();
        } else if (mapSignature instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor) {
            List<Method> methods = ((JvmFunctionSignature.FakeJavaAnnotationConstructor) mapSignature).getMethods();
            Class<?> jClass2 = this.f24397g.getContainer().getJClass();
            Iterable<Method> iterable = methods;
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (Method name4 : iterable) {
                arrayList2.add(name4.getName());
            }
            return new AnnotationConstructorCaller(jClass2, arrayList2, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.JAVA, methods);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (obj instanceof Constructor) {
            KFunctionImpl kFunctionImpl = this.f24397g;
            caller = kFunctionImpl.createConstructorCaller((Constructor) obj, kFunctionImpl.getDescriptor(), false);
        } else if (obj instanceof Method) {
            Method method = (Method) obj;
            if (!Modifier.isStatic(method.getModifiers())) {
                caller = this.f24397g.createInstanceMethodCaller(method);
            } else if (this.f24397g.getDescriptor().getAnnotations().findAnnotation(UtilKt.getJVM_STATIC()) != null) {
                caller = this.f24397g.createJvmStaticInObjectCaller(method);
            } else {
                caller = this.f24397g.createStaticMethodCaller(method);
            }
        } else {
            throw new KotlinReflectionInternalError("Could not compute caller for function: " + this.f24397g.getDescriptor() + " (member = " + obj + ')');
        }
        return InlineClassAwareCallerKt.createInlineClassAwareCallerIfNeeded$default(caller, this.f24397g.getDescriptor(), false, 2, (Object) null);
    }
}
