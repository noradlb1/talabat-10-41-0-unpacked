package org.mockito.kotlin;

import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0015\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lorg/mockito/kotlin/UseConstructor;", "", "args", "", "([Ljava/lang/Object;)V", "getArgs", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "Companion", "mockito-kotlin"}, k = 1, mv = {1, 1, 15})
public final class UseConstructor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final Object[] args;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u001f\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0007\"\u00020\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lorg/mockito/kotlin/UseConstructor$Companion;", "", "()V", "parameterless", "Lorg/mockito/kotlin/UseConstructor;", "withArguments", "arguments", "", "([Ljava/lang/Object;)Lorg/mockito/kotlin/UseConstructor;", "mockito-kotlin"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final UseConstructor parameterless() {
            return new UseConstructor(new Object[0], (DefaultConstructorMarker) null);
        }

        @NotNull
        public final UseConstructor withArguments(@NotNull Object... objArr) {
            Intrinsics.checkParameterIsNotNull(objArr, Constant.PARAM_SQL_ARGUMENTS);
            Object[] array = ArraysKt___ArraysJvmKt.asList((T[]) objArr).toArray(new Object[0]);
            if (array != null) {
                return new UseConstructor(array, (DefaultConstructorMarker) null);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    private UseConstructor(Object[] objArr) {
        this.args = objArr;
    }

    @NotNull
    public final Object[] getArgs() {
        return this.args;
    }

    public /* synthetic */ UseConstructor(Object[] objArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(objArr);
    }
}
