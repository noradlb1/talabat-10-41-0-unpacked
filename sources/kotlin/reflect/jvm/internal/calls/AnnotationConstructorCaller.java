package kotlin.reflect.jvm.internal.calls;

import com.braze.ui.actions.brazeactions.steps.StepData;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002 !B?\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\u0002\u0010\u000eJ\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00102\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0016¢\u0006\u0002\u0010\u001fR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0006X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "jClass", "Ljava/lang/Class;", "parameterNames", "", "", "callMode", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "origin", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "methods", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "defaultValues", "", "erasedParameterTypes", "member", "getMember", "()Ljava/lang/Void;", "parameterTypes", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "CallMode", "Origin", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AnnotationConstructorCaller implements Caller {
    @NotNull
    private final CallMode callMode;
    @NotNull
    private final List<Object> defaultValues;
    @NotNull
    private final List<Class<?>> erasedParameterTypes;
    @NotNull
    private final Class<?> jClass;
    @NotNull
    private final List<Method> methods;
    @NotNull
    private final List<String> parameterNames;
    @NotNull
    private final List<Type> parameterTypes;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "", "(Ljava/lang/String;I)V", "CALL_BY_NAME", "POSITIONAL_CALL", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum CallMode {
        CALL_BY_NAME,
        POSITIONAL_CALL
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "", "(Ljava/lang/String;I)V", "JAVA", "KOTLIN", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum Origin {
        JAVA,
        KOTLIN
    }

    public AnnotationConstructorCaller(@NotNull Class<?> cls, @NotNull List<String> list, @NotNull CallMode callMode2, @NotNull Origin origin, @NotNull List<Method> list2) {
        Intrinsics.checkNotNullParameter(cls, "jClass");
        Intrinsics.checkNotNullParameter(list, "parameterNames");
        Intrinsics.checkNotNullParameter(callMode2, "callMode");
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(list2, "methods");
        this.jClass = cls;
        this.parameterNames = list;
        this.callMode = callMode2;
        this.methods = list2;
        Iterable<Method> iterable = list2;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (Method genericReturnType : iterable) {
            arrayList.add(genericReturnType.getGenericReturnType());
        }
        this.parameterTypes = arrayList;
        Iterable<Method> iterable2 = this.methods;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
        for (Method returnType : iterable2) {
            Class<?> returnType2 = returnType.getReturnType();
            Intrinsics.checkNotNullExpressionValue(returnType2, "it");
            Class<?> wrapperByPrimitive = ReflectClassUtilKt.getWrapperByPrimitive(returnType2);
            if (wrapperByPrimitive != null) {
                returnType2 = wrapperByPrimitive;
            }
            arrayList2.add(returnType2);
        }
        this.erasedParameterTypes = arrayList2;
        Iterable<Method> iterable3 = this.methods;
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable3, 10));
        for (Method defaultValue : iterable3) {
            arrayList3.add(defaultValue.getDefaultValue());
        }
        this.defaultValues = arrayList3;
        if (this.callMode == CallMode.POSITIONAL_CALL && origin == Origin.JAVA && (!CollectionsKt___CollectionsKt.minus(this.parameterNames, "value").isEmpty())) {
            throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
        }
    }

    @Nullable
    public Object call(@NotNull Object[] objArr) {
        Object obj;
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        checkArguments(objArr);
        ArrayList arrayList = new ArrayList(objArr.length);
        int length = objArr.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            Object obj2 = objArr[i11];
            int i13 = i12 + 1;
            if (obj2 == null && this.callMode == CallMode.CALL_BY_NAME) {
                obj = this.defaultValues.get(i12);
            } else {
                obj = AnnotationConstructorCallerKt.transformKotlinToJvm(obj2, this.erasedParameterTypes.get(i12));
            }
            if (obj != null) {
                arrayList.add(obj);
                i11++;
                i12 = i13;
            } else {
                Void unused = AnnotationConstructorCallerKt.throwIllegalArgumentType(i12, this.parameterNames.get(i12), this.erasedParameterTypes.get(i12));
                throw null;
            }
        }
        return AnnotationConstructorCallerKt.createAnnotationInstance(this.jClass, MapsKt__MapsKt.toMap(CollectionsKt___CollectionsKt.zip(this.parameterNames, arrayList)), this.methods);
    }

    public void checkArguments(@NotNull Object[] objArr) {
        Caller.DefaultImpls.checkArguments(this, objArr);
    }

    @Nullable
    public Void getMember() {
        return null;
    }

    @NotNull
    public List<Type> getParameterTypes() {
        return this.parameterTypes;
    }

    @NotNull
    public Type getReturnType() {
        return this.jClass;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AnnotationConstructorCaller(java.lang.Class r7, java.util.List r8, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.CallMode r9, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.Origin r10, java.util.List r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r12 = r12 & 16
            if (r12 == 0) goto L_0x002f
            r11 = r8
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.util.ArrayList r12 = new java.util.ArrayList
            r13 = 10
            int r13 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r11, r13)
            r12.<init>(r13)
            java.util.Iterator r11 = r11.iterator()
        L_0x0016:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto L_0x002d
            java.lang.Object r13 = r11.next()
            java.lang.String r13 = (java.lang.String) r13
            r0 = 0
            java.lang.Class[] r0 = new java.lang.Class[r0]
            java.lang.reflect.Method r13 = r7.getDeclaredMethod(r13, r0)
            r12.add(r13)
            goto L_0x0016
        L_0x002d:
            r5 = r12
            goto L_0x0030
        L_0x002f:
            r5 = r11
        L_0x0030:
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.<init>(java.lang.Class, java.util.List, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller$CallMode, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller$Origin, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
