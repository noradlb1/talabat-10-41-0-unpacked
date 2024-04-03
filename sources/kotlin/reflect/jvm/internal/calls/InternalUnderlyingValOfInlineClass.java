package kotlin.reflect.jvm.internal.calls;

import com.braze.ui.actions.brazeactions.steps.StepData;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002\u001a\u001bB\u001f\b\u0004\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0001\u0002\u001c\u001d¨\u0006\u001e"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Method;", "", "instance", "", "args", "a", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "unboxMethod", "Ljava/lang/reflect/Method;", "", "Ljava/lang/reflect/Type;", "parameterTypes", "Ljava/util/List;", "getParameterTypes", "()Ljava/util/List;", "returnType", "Ljava/lang/reflect/Type;", "getReturnType", "()Ljava/lang/reflect/Type;", "getMember", "()Ljava/lang/reflect/Method;", "member", "<init>", "(Ljava/lang/reflect/Method;Ljava/util/List;)V", "Bound", "Unbound", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Bound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Unbound;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1})
public abstract class InternalUnderlyingValOfInlineClass implements Caller<Method> {
    @NotNull
    private final List<Type> parameterTypes;
    @NotNull
    private final Type returnType;
    @NotNull
    private final Method unboxMethod;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0016¢\u0006\u0002\u0010\u000bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Bound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "unboxMethod", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Bound extends InternalUnderlyingValOfInlineClass implements BoundCaller {
        @Nullable
        private final Object boundReceiver;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Bound(@NotNull Method method, @Nullable Object obj) {
            super(method, CollectionsKt__CollectionsKt.emptyList(), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(method, "unboxMethod");
            this.boundReceiver = obj;
        }

        @Nullable
        public Object call(@NotNull Object[] objArr) {
            Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
            checkArguments(objArr);
            return a(this.boundReceiver, objArr);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass$Unbound;", "Lkotlin/reflect/jvm/internal/calls/InternalUnderlyingValOfInlineClass;", "unboxMethod", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Unbound extends InternalUnderlyingValOfInlineClass {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Unbound(@NotNull Method method) {
            super(method, CollectionsKt__CollectionsJVMKt.listOf(method.getDeclaringClass()), (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(method, "unboxMethod");
        }

        @Nullable
        public Object call(@NotNull Object[] objArr) {
            Object[] objArr2;
            Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
            checkArguments(objArr);
            Object obj = objArr[0];
            CallerImpl.Companion companion = CallerImpl.Companion;
            if (objArr.length <= 1) {
                objArr2 = new Object[0];
            } else {
                objArr2 = ArraysKt___ArraysJvmKt.copyOfRange((T[]) objArr, 1, objArr.length);
                Intrinsics.checkNotNull(objArr2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.reflect.jvm.internal.calls.CallerImpl.Companion.dropFirst>");
            }
            return a(obj, objArr2);
        }
    }

    private InternalUnderlyingValOfInlineClass(Method method, List<? extends Type> list) {
        this.unboxMethod = method;
        this.parameterTypes = list;
        Class<?> returnType2 = method.getReturnType();
        Intrinsics.checkNotNullExpressionValue(returnType2, "unboxMethod.returnType");
        this.returnType = returnType2;
    }

    public /* synthetic */ InternalUnderlyingValOfInlineClass(Method method, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(method, list);
    }

    @Nullable
    public final Object a(@Nullable Object obj, @NotNull Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        return this.unboxMethod.invoke(obj, Arrays.copyOf(objArr, objArr.length));
    }

    public void checkArguments(@NotNull Object[] objArr) {
        Caller.DefaultImpls.checkArguments(this, objArr);
    }

    @Nullable
    public final Method getMember() {
        return null;
    }

    @NotNull
    public final List<Type> getParameterTypes() {
        return this.parameterTypes;
    }

    @NotNull
    public final Type getReturnType() {
        return this.returnType;
    }
}
