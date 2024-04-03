package kotlin.reflect.jvm.internal;

import com.braze.ui.actions.brazeactions.steps.StepData;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KParameter;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.reflect.full.IllegalCallableAccessException;
import kotlin.reflect.jvm.KTypesJvm;
import kotlin.reflect.jvm.ReflectJvmMapping;
import kotlin.reflect.jvm.internal.ReflectProperties;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0003B\u0007¢\u0006\u0004\bI\u0010JJ%\u0010\b\u001a\u00028\u00002\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J'\u0010\u0010\u001a\u00028\u00002\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u000f\"\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0012\u001a\u00028\u00002\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\tJ3\u0010\u0017\u001a\u00028\u00002\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00042\f\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0013H\u0000¢\u0006\u0004\b\u0015\u0010\u0016R.\u0010\u001c\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001a \u001b*\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00190\u00190\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR.\u0010\u001f\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005 \u001b*\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001e0\u001e0\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\"\u0010!\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010 0 0\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001dR.\u0010#\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\" \u001b*\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00190\u00190\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001dR\u0018\u0010'\u001a\u0006\u0012\u0002\b\u00030$8&X¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001a\u0010)\u001a\b\u0012\u0002\b\u0003\u0018\u00010$8&X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010&R\u0014\u0010-\u001a\u00020*8&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010/\u001a\u00020.8&X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020\u00050\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b4\u00102R\u0014\u00108\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u0002090\u00198VX\u0004¢\u0006\u0006\u001a\u0004\b:\u00102R\u0016\u0010?\u001a\u0004\u0018\u00010<8VX\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010@\u001a\u00020.8VX\u0004¢\u0006\u0006\u001a\u0004\b@\u00100R\u0014\u0010A\u001a\u00020.8VX\u0004¢\u0006\u0006\u001a\u0004\bA\u00100R\u0014\u0010B\u001a\u00020.8VX\u0004¢\u0006\u0006\u001a\u0004\bB\u00100R\u0014\u0010D\u001a\u00020.8DX\u0004¢\u0006\u0006\u001a\u0004\bC\u00100R\u0014\u0010H\u001a\u00020E8&X¦\u0004¢\u0006\u0006\u001a\u0004\bF\u0010G¨\u0006K"}, d2 = {"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "", "Lkotlin/reflect/KParameter;", "", "args", "callAnnotationConstructor", "(Ljava/util/Map;)Ljava/lang/Object;", "Lkotlin/reflect/KType;", "type", "defaultEmptyArray", "Ljava/lang/reflect/Type;", "extractContinuationArgument", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "callBy", "Lkotlin/coroutines/Continuation;", "continuationArgument", "callDefaultMethod$kotlin_reflection", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callDefaultMethod", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "Ljava/util/ArrayList;", "_parameters", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "_typeParameters", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller", "getDefaultCaller", "defaultCaller", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "", "isBound", "()Z", "getAnnotations", "()Ljava/util/List;", "annotations", "getParameters", "parameters", "getReturnType", "()Lkotlin/reflect/KType;", "returnType", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "typeParameters", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "visibility", "isFinal", "isOpen", "isAbstract", "a", "isAnnotationConstructor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "descriptor", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 7, 1})
public abstract class KCallableImpl<R> implements KCallable<R>, KTypeParameterOwnerImpl {
    @NotNull
    private final ReflectProperties.LazySoftVal<List<Annotation>> _annotations;
    @NotNull
    private final ReflectProperties.LazySoftVal<ArrayList<KParameter>> _parameters;
    @NotNull
    private final ReflectProperties.LazySoftVal<KTypeImpl> _returnType;
    @NotNull
    private final ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> _typeParameters;

    public KCallableImpl() {
        ReflectProperties.LazySoftVal<List<Annotation>> lazySoft = ReflectProperties.lazySoft(new KCallableImpl$_annotations$1(this));
        Intrinsics.checkNotNullExpressionValue(lazySoft, "lazySoft { descriptor.computeAnnotations() }");
        this._annotations = lazySoft;
        ReflectProperties.LazySoftVal<ArrayList<KParameter>> lazySoft2 = ReflectProperties.lazySoft(new KCallableImpl$_parameters$1(this));
        Intrinsics.checkNotNullExpressionValue(lazySoft2, "lazySoft {\n        val d…ze()\n        result\n    }");
        this._parameters = lazySoft2;
        ReflectProperties.LazySoftVal<KTypeImpl> lazySoft3 = ReflectProperties.lazySoft(new KCallableImpl$_returnType$1(this));
        Intrinsics.checkNotNullExpressionValue(lazySoft3, "lazySoft {\n        KType…eturnType\n        }\n    }");
        this._returnType = lazySoft3;
        ReflectProperties.LazySoftVal<List<KTypeParameterImpl>> lazySoft4 = ReflectProperties.lazySoft(new KCallableImpl$_typeParameters$1(this));
        Intrinsics.checkNotNullExpressionValue(lazySoft4, "lazySoft {\n        descr…this, descriptor) }\n    }");
        this._typeParameters = lazySoft4;
    }

    private final R callAnnotationConstructor(Map<KParameter, ? extends Object> map) {
        Object obj;
        Iterable<KParameter> parameters = getParameters();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(parameters, 10));
        for (KParameter kParameter : parameters) {
            if (map.containsKey(kParameter)) {
                obj = map.get(kParameter);
                if (obj == null) {
                    throw new IllegalArgumentException("Annotation argument value cannot be null (" + kParameter + ')');
                }
            } else if (kParameter.isOptional()) {
                obj = null;
            } else if (kParameter.isVararg()) {
                obj = defaultEmptyArray(kParameter.getType());
            } else {
                throw new IllegalArgumentException("No argument provided for a required parameter: " + kParameter);
            }
            arrayList.add(obj);
        }
        Caller<?> defaultCaller = getDefaultCaller();
        if (defaultCaller != null) {
            try {
                Object[] array = arrayList.toArray(new Object[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                return defaultCaller.call(array);
            } catch (IllegalAccessException e11) {
                throw new IllegalCallableAccessException(e11);
            }
        } else {
            throw new KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
        }
    }

    private final Object defaultEmptyArray(KType kType) {
        Class<?> javaClass = JvmClassMappingKt.getJavaClass(KTypesJvm.getJvmErasure(kType));
        if (javaClass.isArray()) {
            Object newInstance = Array.newInstance(javaClass.getComponentType(), 0);
            Intrinsics.checkNotNullExpressionValue(newInstance, "type.jvmErasure.java.run…\"\n            )\n        }");
            return newInstance;
        }
        throw new KotlinReflectionInternalError("Cannot instantiate the default empty array of type " + javaClass.getSimpleName() + ", because it is not an array type");
    }

    /* access modifiers changed from: private */
    public final Type extractContinuationArgument() {
        FunctionDescriptor functionDescriptor;
        ParameterizedType parameterizedType;
        Type type;
        WildcardType wildcardType;
        Type[] lowerBounds;
        CallableMemberDescriptor descriptor = getDescriptor();
        if (descriptor instanceof FunctionDescriptor) {
            functionDescriptor = (FunctionDescriptor) descriptor;
        } else {
            functionDescriptor = null;
        }
        boolean z11 = false;
        if (functionDescriptor != null && functionDescriptor.isSuspend()) {
            z11 = true;
        }
        if (!z11) {
            return null;
        }
        Object lastOrNull = CollectionsKt___CollectionsKt.lastOrNull(getCaller().getParameterTypes());
        if (lastOrNull instanceof ParameterizedType) {
            parameterizedType = (ParameterizedType) lastOrNull;
        } else {
            parameterizedType = null;
        }
        if (parameterizedType != null) {
            type = parameterizedType.getRawType();
        } else {
            type = null;
        }
        if (!Intrinsics.areEqual((Object) type, (Object) Continuation.class)) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Intrinsics.checkNotNullExpressionValue(actualTypeArguments, "continuationType.actualTypeArguments");
        Object single = ArraysKt___ArraysKt.single((T[]) actualTypeArguments);
        if (single instanceof WildcardType) {
            wildcardType = (WildcardType) single;
        } else {
            wildcardType = null;
        }
        if (wildcardType == null || (lowerBounds = wildcardType.getLowerBounds()) == null) {
            return null;
        }
        return (Type) ArraysKt___ArraysKt.first((T[]) lowerBounds);
    }

    public final boolean a() {
        return Intrinsics.areEqual((Object) getName(), (Object) MethodDescription.CONSTRUCTOR_INTERNAL_NAME) && getContainer().getJClass().isAnnotation();
    }

    public R call(@NotNull Object... objArr) {
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        try {
            return getCaller().call(objArr);
        } catch (IllegalAccessException e11) {
            throw new IllegalCallableAccessException(e11);
        }
    }

    public R callBy(@NotNull Map<KParameter, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, StepData.ARGS);
        if (a()) {
            return callAnnotationConstructor(map);
        }
        return callDefaultMethod$kotlin_reflection(map, (Continuation<?>) null);
    }

    public final R callDefaultMethod$kotlin_reflection(@NotNull Map<KParameter, ? extends Object> map, @Nullable Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(map, StepData.ARGS);
        List<KParameter> parameters = getParameters();
        ArrayList arrayList = new ArrayList(parameters.size());
        ArrayList arrayList2 = new ArrayList(1);
        Iterator<KParameter> it = parameters.iterator();
        int i11 = 0;
        boolean z11 = false;
        int i12 = 0;
        while (true) {
            Object obj = null;
            if (it.hasNext()) {
                KParameter next = it.next();
                if (i11 != 0 && i11 % 32 == 0) {
                    arrayList2.add(Integer.valueOf(i12));
                    i12 = 0;
                }
                if (map.containsKey(next)) {
                    arrayList.add(map.get(next));
                } else if (next.isOptional()) {
                    if (!UtilKt.isInlineClassType(next.getType())) {
                        obj = UtilKt.defaultPrimitiveValue(ReflectJvmMapping.getJavaType(next.getType()));
                    }
                    arrayList.add(obj);
                    i12 = (1 << (i11 % 32)) | i12;
                    z11 = true;
                } else if (next.isVararg()) {
                    arrayList.add(defaultEmptyArray(next.getType()));
                } else {
                    throw new IllegalArgumentException("No argument provided for a required parameter: " + next);
                }
                if (next.getKind() == KParameter.Kind.VALUE) {
                    i11++;
                }
            } else {
                if (continuation != null) {
                    arrayList.add(continuation);
                }
                if (!z11) {
                    Object[] array = arrayList.toArray(new Object[0]);
                    Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    return call(Arrays.copyOf(array, array.length));
                }
                arrayList2.add(Integer.valueOf(i12));
                Caller<?> defaultCaller = getDefaultCaller();
                if (defaultCaller != null) {
                    arrayList.addAll(arrayList2);
                    arrayList.add((Object) null);
                    try {
                        Object[] array2 = arrayList.toArray(new Object[0]);
                        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        return defaultCaller.call(array2);
                    } catch (IllegalAccessException e11) {
                        throw new IllegalCallableAccessException(e11);
                    }
                } else {
                    throw new KotlinReflectionInternalError("This callable does not support a default call: " + getDescriptor());
                }
            }
        }
    }

    @NotNull
    public List<Annotation> getAnnotations() {
        List<Annotation> invoke = this._annotations.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "_annotations()");
        return invoke;
    }

    @NotNull
    public abstract Caller<?> getCaller();

    @NotNull
    public abstract KDeclarationContainerImpl getContainer();

    @Nullable
    public abstract Caller<?> getDefaultCaller();

    @NotNull
    public abstract CallableMemberDescriptor getDescriptor();

    @NotNull
    public List<KParameter> getParameters() {
        ArrayList<KParameter> invoke = this._parameters.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "_parameters()");
        return invoke;
    }

    @NotNull
    public KType getReturnType() {
        KTypeImpl invoke = this._returnType.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "_returnType()");
        return invoke;
    }

    @NotNull
    public List<KTypeParameter> getTypeParameters() {
        List<KTypeParameterImpl> invoke = this._typeParameters.invoke();
        Intrinsics.checkNotNullExpressionValue(invoke, "_typeParameters()");
        return invoke;
    }

    @Nullable
    public KVisibility getVisibility() {
        DescriptorVisibility visibility = getDescriptor().getVisibility();
        Intrinsics.checkNotNullExpressionValue(visibility, "descriptor.visibility");
        return UtilKt.toKVisibility(visibility);
    }

    public boolean isAbstract() {
        return getDescriptor().getModality() == Modality.ABSTRACT;
    }

    public abstract boolean isBound();

    public boolean isFinal() {
        return getDescriptor().getModality() == Modality.FINAL;
    }

    public boolean isOpen() {
        return getDescriptor().getModality() == Modality.OPEN;
    }
}
