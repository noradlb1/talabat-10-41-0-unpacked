package org.mockito.kotlin;

import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mockito.Incubating;
import org.mockito.MockSettings;
import org.mockito.Mockito;
import org.mockito.listeners.InvocationListener;
import org.mockito.mock.SerializableMode;
import org.mockito.stubbing.Answer;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a¾\u0001\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u001a\b\u0002\u0010\u0003\u001a\u0014\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00042\b\b\u0002\u0010\u0012\u001a\u00020\f2\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u0016\u001a\u00020\fH\b¢\u0006\u0002\u0010\u0017\u001aã\u0001\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u001a\b\u0002\u0010\u0003\u001a\u0014\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00042\b\b\u0002\u0010\u0012\u001a\u00020\f2\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u0016\u001a\u00020\f2#\u0010\u0018\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u001a\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u001b0\u0019¢\u0006\u0002\b\u001cH\b¢\u0006\u0002\u0010\u001d\u001a\"\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0007H\b¢\u0006\u0002\u0010\u001f\u001a\"\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u001e\u001a\u00020 H\b¢\u0006\u0002\u0010!\u001a(\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020\nH\b¢\u0006\u0002\u0010#\u001a¯\u0001\u0010$\u001a\u00020 2\u001a\b\u0002\u0010\u0003\u001a\u0014\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0005\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\f2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00042\b\b\u0002\u0010\u0012\u001a\u00020\f2\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00022\b\b\u0003\u0010\u0016\u001a\u00020\f¢\u0006\u0002\u0010%¨\u0006&"}, d2 = {"mock", "T", "", "extraInterfaces", "", "Lkotlin/reflect/KClass;", "name", "", "spiedInstance", "defaultAnswer", "Lorg/mockito/stubbing/Answer;", "serializable", "", "serializableMode", "Lorg/mockito/mock/SerializableMode;", "verboseLogging", "invocationListeners", "Lorg/mockito/listeners/InvocationListener;", "stubOnly", "useConstructor", "Lorg/mockito/kotlin/UseConstructor;", "outerInstance", "lenient", "([Lkotlin/reflect/KClass;Ljava/lang/String;Ljava/lang/Object;Lorg/mockito/stubbing/Answer;ZLorg/mockito/mock/SerializableMode;Z[Lorg/mockito/listeners/InvocationListener;ZLorg/mockito/kotlin/UseConstructor;Ljava/lang/Object;Z)Ljava/lang/Object;", "stubbing", "Lkotlin/Function2;", "Lorg/mockito/kotlin/KStubbing;", "", "Lkotlin/ExtensionFunctionType;", "([Lkotlin/reflect/KClass;Ljava/lang/String;Ljava/lang/Object;Lorg/mockito/stubbing/Answer;ZLorg/mockito/mock/SerializableMode;Z[Lorg/mockito/listeners/InvocationListener;ZLorg/mockito/kotlin/UseConstructor;Ljava/lang/Object;ZLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "s", "(Ljava/lang/String;)Ljava/lang/Object;", "Lorg/mockito/MockSettings;", "(Lorg/mockito/MockSettings;)Ljava/lang/Object;", "a", "(Lorg/mockito/stubbing/Answer;)Ljava/lang/Object;", "withSettings", "([Lkotlin/reflect/KClass;Ljava/lang/String;Ljava/lang/Object;Lorg/mockito/stubbing/Answer;ZLorg/mockito/mock/SerializableMode;Z[Lorg/mockito/listeners/InvocationListener;ZLorg/mockito/kotlin/UseConstructor;Ljava/lang/Object;Z)Lorg/mockito/MockSettings;", "mockito-kotlin"}, k = 2, mv = {1, 1, 15})
public final class MockingKt {
    @NotNull
    public static final /* synthetic */ <T> T mock(@Nullable KClass<? extends Object>[] kClassArr, @Nullable String str, @Nullable Object obj, @Nullable Answer<Object> answer, boolean z11, @Nullable SerializableMode serializableMode, boolean z12, @Nullable InvocationListener[] invocationListenerArr, boolean z13, @Incubating @Nullable UseConstructor useConstructor, @Incubating @Nullable Object obj2, @Incubating boolean z14) {
        Intrinsics.reifiedOperationMarker(4, "T");
        T mock = Mockito.mock(Object.class, withSettings(kClassArr, str, obj, answer, z11, serializableMode, z12, invocationListenerArr, z13, useConstructor, obj2, z14));
        if (mock == null) {
            Intrinsics.throwNpe();
        }
        return mock;
    }

    public static /* synthetic */ Object mock$default(KClass[] kClassArr, String str, Object obj, Answer answer, boolean z11, SerializableMode serializableMode, boolean z12, InvocationListener[] invocationListenerArr, boolean z13, UseConstructor useConstructor, Object obj2, boolean z14, Function2 function2, int i11, Object obj3) {
        Function2 function22 = function2;
        int i12 = i11;
        Object obj4 = null;
        KClass[] kClassArr2 = (i12 & 1) != 0 ? null : kClassArr;
        String str2 = (i12 & 2) != 0 ? null : str;
        Object obj5 = (i12 & 4) != 0 ? null : obj;
        Answer answer2 = (i12 & 8) != 0 ? null : answer;
        boolean z15 = false;
        boolean z16 = (i12 & 16) != 0 ? false : z11;
        SerializableMode serializableMode2 = (i12 & 32) != 0 ? null : serializableMode;
        boolean z17 = (i12 & 64) != 0 ? false : z12;
        InvocationListener[] invocationListenerArr2 = (i12 & 128) != 0 ? null : invocationListenerArr;
        boolean z18 = (i12 & 256) != 0 ? false : z13;
        UseConstructor useConstructor2 = (i12 & 512) != 0 ? null : useConstructor;
        if ((i12 & 1024) == 0) {
            obj4 = obj2;
        }
        if ((i12 & 2048) == 0) {
            z15 = z14;
        }
        Intrinsics.checkParameterIsNotNull(function22, "stubbing");
        Intrinsics.reifiedOperationMarker(4, "T");
        Object mock = Mockito.mock(Object.class, withSettings(kClassArr2, str2, obj5, answer2, z16, serializableMode2, z17, invocationListenerArr2, z18, useConstructor2, obj4, z15));
        KStubbing kStubbing = new KStubbing(mock);
        Intrinsics.checkExpressionValueIsNotNull(mock, "this");
        function22.invoke(kStubbing, mock);
        if (mock == null) {
            Intrinsics.throwNpe();
        }
        return mock;
    }

    @NotNull
    public static final MockSettings withSettings(@Nullable KClass<? extends Object>[] kClassArr, @Nullable String str, @Nullable Object obj, @Nullable Answer<Object> answer, boolean z11, @Nullable SerializableMode serializableMode, boolean z12, @Nullable InvocationListener[] invocationListenerArr, boolean z13, @Incubating @Nullable UseConstructor useConstructor, @Incubating @Nullable Object obj2, @Incubating boolean z14) {
        KClass<? extends Object>[] kClassArr2 = kClassArr;
        String str2 = str;
        Object obj3 = obj;
        Answer<Object> answer2 = answer;
        SerializableMode serializableMode2 = serializableMode;
        InvocationListener[] invocationListenerArr2 = invocationListenerArr;
        Object obj4 = obj2;
        MockSettings withSettings = Mockito.withSettings();
        if (kClassArr2 != null) {
            ArrayList arrayList = new ArrayList(kClassArr2.length);
            for (KClass<? extends Object> javaClass : kClassArr2) {
                arrayList.add(JvmClassMappingKt.getJavaClass(javaClass));
            }
            Object[] array = arrayList.toArray(new Class[0]);
            if (array != null) {
                Class[] clsArr = (Class[]) array;
                withSettings.extraInterfaces((Class[]) Arrays.copyOf(clsArr, clsArr.length));
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        if (str2 != null) {
            withSettings.name(str);
        }
        if (obj3 != null) {
            withSettings.spiedInstance(obj);
        }
        if (answer2 != null) {
            withSettings.defaultAnswer(answer2);
        }
        if (z11) {
            withSettings.serializable();
        }
        if (serializableMode2 != null) {
            withSettings.serializable(serializableMode2);
        }
        if (z12) {
            withSettings.verboseLogging();
        }
        if (invocationListenerArr2 != null) {
            withSettings.invocationListeners((InvocationListener[]) Arrays.copyOf(invocationListenerArr2, invocationListenerArr2.length));
        }
        if (z13) {
            withSettings.stubOnly();
        }
        if (useConstructor != null) {
            Object[] args = useConstructor.getArgs();
            withSettings.useConstructor(Arrays.copyOf(args, args.length));
        }
        if (obj4 != null) {
            withSettings.outerInstance(obj4);
        }
        if (z14) {
            withSettings.lenient();
        }
        Intrinsics.checkExpressionValueIsNotNull(withSettings, "Mockito.withSettings().a… if (lenient) lenient()\n}");
        return withSettings;
    }

    public static /* synthetic */ MockSettings withSettings$default(KClass[] kClassArr, String str, Object obj, Answer answer, boolean z11, SerializableMode serializableMode, boolean z12, InvocationListener[] invocationListenerArr, boolean z13, UseConstructor useConstructor, Object obj2, boolean z14, int i11, Object obj3) {
        if ((i11 & 1) != 0) {
            kClassArr = null;
        }
        if ((i11 & 2) != 0) {
            str = null;
        }
        if ((i11 & 4) != 0) {
            obj = null;
        }
        if ((i11 & 8) != 0) {
            answer = null;
        }
        if ((i11 & 16) != 0) {
            z11 = false;
        }
        if ((i11 & 32) != 0) {
            serializableMode = null;
        }
        if ((i11 & 64) != 0) {
            z12 = false;
        }
        if ((i11 & 128) != 0) {
            invocationListenerArr = null;
        }
        if ((i11 & 256) != 0) {
            z13 = false;
        }
        if ((i11 & 512) != 0) {
            useConstructor = null;
        }
        if ((i11 & 1024) != 0) {
            obj2 = null;
        }
        if ((i11 & 2048) != 0) {
            z14 = false;
        }
        return withSettings(kClassArr, str, obj, answer, z11, serializableMode, z12, invocationListenerArr, z13, useConstructor, obj2, z14);
    }

    @NotNull
    public static final /* synthetic */ <T> T mock(@Nullable KClass<? extends Object>[] kClassArr, @Nullable String str, @Nullable Object obj, @Nullable Answer<Object> answer, boolean z11, @Nullable SerializableMode serializableMode, boolean z12, @Nullable InvocationListener[] invocationListenerArr, boolean z13, @Incubating @Nullable UseConstructor useConstructor, @Incubating @Nullable Object obj2, @Incubating boolean z14, @NotNull Function2<? super KStubbing<? extends T>, ? super T, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(function2, "stubbing");
        Intrinsics.reifiedOperationMarker(4, "T");
        T mock = Mockito.mock(Object.class, withSettings(kClassArr, str, obj, answer, z11, serializableMode, z12, invocationListenerArr, z13, useConstructor, obj2, z14));
        KStubbing kStubbing = new KStubbing(mock);
        Intrinsics.checkExpressionValueIsNotNull(mock, "this");
        function2.invoke(kStubbing, mock);
        if (mock == null) {
            Intrinsics.throwNpe();
        }
        return mock;
    }

    public static /* synthetic */ Object mock$default(KClass[] kClassArr, String str, Object obj, Answer answer, boolean z11, SerializableMode serializableMode, boolean z12, InvocationListener[] invocationListenerArr, boolean z13, UseConstructor useConstructor, Object obj2, boolean z14, int i11, Object obj3) {
        if ((i11 & 1) != 0) {
            kClassArr = null;
        }
        if ((i11 & 2) != 0) {
            str = null;
        }
        if ((i11 & 4) != 0) {
            obj = null;
        }
        if ((i11 & 8) != 0) {
            answer = null;
        }
        if ((i11 & 16) != 0) {
            z11 = false;
        }
        if ((i11 & 32) != 0) {
            serializableMode = null;
        }
        if ((i11 & 64) != 0) {
            z12 = false;
        }
        if ((i11 & 128) != 0) {
            invocationListenerArr = null;
        }
        if ((i11 & 256) != 0) {
            z13 = false;
        }
        if ((i11 & 512) != 0) {
            useConstructor = null;
        }
        if ((i11 & 1024) != 0) {
            obj2 = null;
        }
        if ((i11 & 2048) != 0) {
            z14 = false;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        Object mock = Mockito.mock(Object.class, withSettings(kClassArr, str, obj, answer, z11, serializableMode, z12, invocationListenerArr, z13, useConstructor, obj2, z14));
        if (mock == null) {
            Intrinsics.throwNpe();
        }
        return mock;
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use mock() with optional arguments instead.")
    public static final /* synthetic */ <T> T mock(@NotNull MockSettings mockSettings) {
        Intrinsics.checkParameterIsNotNull(mockSettings, "s");
        Intrinsics.reifiedOperationMarker(4, "T");
        T mock = Mockito.mock(Object.class, mockSettings);
        if (mock == null) {
            Intrinsics.throwNpe();
        }
        return mock;
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use mock() with optional arguments instead.", replaceWith = @ReplaceWith(expression = "mock<T>(defaultAnswer = a)", imports = {}))
    public static final /* synthetic */ <T> T mock(@NotNull Answer<Object> answer) {
        Intrinsics.checkParameterIsNotNull(answer, "a");
        Intrinsics.reifiedOperationMarker(4, "T");
        T mock = Mockito.mock(Object.class, withSettings((KClass<? extends Object>[]) null, (String) null, (Object) null, answer, false, (SerializableMode) null, false, (InvocationListener[]) null, false, (UseConstructor) null, (Object) null, false));
        if (mock == null) {
            Intrinsics.throwNpe();
        }
        return mock;
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use mock() with optional arguments instead.", replaceWith = @ReplaceWith(expression = "mock<T>(name = s)", imports = {}))
    public static final /* synthetic */ <T> T mock(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "s");
        Intrinsics.reifiedOperationMarker(4, "T");
        T mock = Mockito.mock(Object.class, withSettings((KClass<? extends Object>[]) null, str, (Object) null, (Answer<Object>) null, false, (SerializableMode) null, false, (InvocationListener[]) null, false, (UseConstructor) null, (Object) null, false));
        if (mock == null) {
            Intrinsics.throwNpe();
        }
        return mock;
    }
}
