package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.JvmFunctionSignature;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class KFunctionImpl$defaultCaller$2 extends Lambda implements Function0<Caller<? extends Member>> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ KFunctionImpl f24398g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KFunctionImpl$defaultCaller$2(KFunctionImpl kFunctionImpl) {
        super(0);
        this.f24398g = kFunctionImpl;
    }

    @Nullable
    public final Caller<Member> invoke() {
        Object obj;
        Caller caller;
        JvmFunctionSignature mapSignature = RuntimeTypeMapper.INSTANCE.mapSignature(this.f24398g.getDescriptor());
        if (mapSignature instanceof JvmFunctionSignature.KotlinFunction) {
            KDeclarationContainerImpl container = this.f24398g.getContainer();
            JvmFunctionSignature.KotlinFunction kotlinFunction = (JvmFunctionSignature.KotlinFunction) mapSignature;
            String methodName = kotlinFunction.getMethodName();
            String methodDesc = kotlinFunction.getMethodDesc();
            Member member = this.f24398g.getCaller().getMember();
            Intrinsics.checkNotNull(member);
            obj = container.findDefaultMethod(methodName, methodDesc, !Modifier.isStatic(member.getModifiers()));
        } else if (mapSignature instanceof JvmFunctionSignature.KotlinConstructor) {
            if (this.f24398g.a()) {
                Class<?> jClass = this.f24398g.getContainer().getJClass();
                Iterable<KParameter> parameters = this.f24398g.getParameters();
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(parameters, 10));
                for (KParameter name2 : parameters) {
                    String name3 = name2.getName();
                    Intrinsics.checkNotNull(name3);
                    arrayList.add(name3);
                }
                return new AnnotationConstructorCaller(jClass, arrayList, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.KOTLIN, (List) null, 16, (DefaultConstructorMarker) null);
            }
            obj = this.f24398g.getContainer().findDefaultConstructor(((JvmFunctionSignature.KotlinConstructor) mapSignature).getConstructorDesc());
        } else if (mapSignature instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor) {
            List<Method> methods = ((JvmFunctionSignature.FakeJavaAnnotationConstructor) mapSignature).getMethods();
            Class<?> jClass2 = this.f24398g.getContainer().getJClass();
            Iterable<Method> iterable = methods;
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (Method name4 : iterable) {
                arrayList2.add(name4.getName());
            }
            return new AnnotationConstructorCaller(jClass2, arrayList2, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.JAVA, methods);
        } else {
            obj = null;
        }
        if (obj instanceof Constructor) {
            KFunctionImpl kFunctionImpl = this.f24398g;
            caller = kFunctionImpl.createConstructorCaller((Constructor) obj, kFunctionImpl.getDescriptor(), true);
        } else if (obj instanceof Method) {
            if (this.f24398g.getDescriptor().getAnnotations().findAnnotation(UtilKt.getJVM_STATIC()) != null) {
                DeclarationDescriptor containingDeclaration = this.f24398g.getDescriptor().getContainingDeclaration();
                Intrinsics.checkNotNull(containingDeclaration, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                if (!((ClassDescriptor) containingDeclaration).isCompanionObject()) {
                    caller = this.f24398g.createJvmStaticInObjectCaller((Method) obj);
                }
            }
            caller = this.f24398g.createStaticMethodCaller((Method) obj);
        } else {
            caller = null;
        }
        if (caller != null) {
            return InlineClassAwareCallerKt.createInlineClassAwareCallerIfNeeded(caller, this.f24398g.getDescriptor(), true);
        }
        return null;
    }
}
