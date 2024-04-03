package org.junit.jupiter.api;

import j$.time.Duration;
import j$.util.Collection;
import j$.util.function.Supplier;
import j$.util.stream.Stream;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.apiguardian.api.API;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.api.function.ThrowingSupplier;

@Metadata(d1 = {"\u0000F\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0011\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\b\n\u001a\u001c\u0010\u0005\u001a\u00020\u00042\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\u0006\u001a\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u001a@\u0010\f\u001a&\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n \u000b*\u0012\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n\u0018\u00010\u00070\u0007*\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00060\u0007j\u0002`\tH\u0002\u001a\u001e\u0010\u000e\u001a\u00020\b2\u0016\u0010\r\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00060\u0007j\u0002`\t\u001a(\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00002\u0016\u0010\r\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00060\u0007j\u0002`\t\u001a\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\u0012*\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00060\u0010j\u0002`\u0011H\u0002\u001a\u001e\u0010\u000e\u001a\u00020\b2\u0016\u0010\r\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00060\u0010j\u0002`\u0011\u001a(\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00002\u0016\u0010\r\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00060\u0010j\u0002`\u0011\u001a-\u0010\u000e\u001a\u00020\b2\u001e\u0010\r\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\b0\u00060\u0013\"\b\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u000e\u0010\u0014\u001a7\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00002\u001e\u0010\r\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\b0\u00060\u0013\"\b\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u000e\u0010\u0015\u001a*\u0010\u0018\u001a\u00028\u0000\"\n\b\u0000\u0010\u0016\u0018\u0001*\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0006H\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a2\u0010\u0018\u001a\u00028\u0000\"\n\b\u0000\u0010\u0016\u0018\u0001*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0006H\b¢\u0006\u0004\b\u0018\u0010\u001a\u001a:\u0010\u0018\u001a\u00028\u0000\"\n\b\u0000\u0010\u0016\u0018\u0001*\u00020\u00022\u000e\b\b\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0006H\b¢\u0006\u0004\b\u0018\u0010\u001b\u001a$\u0010\u001d\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001c2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a,\u0010\u001d\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001c2\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\b¢\u0006\u0004\b\u001d\u0010\u001f\u001a4\u0010\u001d\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001c2\u000e\b\b\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\b¢\u0006\u0004\b\u001d\u0010 \u001a#\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!\"\u0004\b\u0000\u0010\u001c2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\b\u001a+\u0010%\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001c2\u0006\u0010$\u001a\u00020#2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0007¢\u0006\u0004\b%\u0010&\u001a3\u0010%\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001c2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0007¢\u0006\u0004\b%\u0010'\u001a9\u0010%\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001c2\u0006\u0010$\u001a\u00020#2\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0007¢\u0006\u0004\b%\u0010(\u001a+\u0010)\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001c2\u0006\u0010$\u001a\u00020#2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0007¢\u0006\u0004\b)\u0010&\u001a3\u0010)\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001c2\u0006\u0010$\u001a\u00020#2\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0007¢\u0006\u0004\b)\u0010'\u001a9\u0010)\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001c2\u0006\u0010$\u001a\u00020#2\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0007¢\u0006\u0004\b)\u0010(*$\b\u0002\u0010*\"\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00060\u00102\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00060\u0010*$\b\u0002\u0010+\"\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00060\u00072\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00060\u0007¨\u0006,"}, d2 = {"", "message", "", "throwable", "", "fail", "Lkotlin/Function0;", "j$/util/stream/Stream", "", "Lorg/junit/jupiter/api/ExecutableStream;", "Lorg/junit/jupiter/api/function/Executable;", "kotlin.jvm.PlatformType", "convert", "executables", "assertAll", "heading", "", "Lorg/junit/jupiter/api/ExecutableCollection;", "", "", "([Lkotlin/jvm/functions/Function0;)V", "(Ljava/lang/String;[Lkotlin/jvm/functions/Function0;)V", "T", "executable", "assertThrows", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Throwable;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Throwable;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Throwable;", "R", "assertDoesNotThrow", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lorg/junit/jupiter/api/function/ThrowingSupplier;", "evaluateAndWrap", "j$/time/Duration", "timeout", "assertTimeout", "(Lj$/time/Duration;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "(Lj$/time/Duration;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "(Lj$/time/Duration;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "assertTimeoutPreemptively", "ExecutableCollection", "ExecutableStream", "junit-jupiter-api"}, k = 2, mv = {1, 4, 0})
@API(since = "5.7", status = API.Status.STABLE)
public final class AssertionsKt {
    public static final void assertAll(@NotNull Stream<Function0<Unit>> stream) {
        Intrinsics.checkParameterIsNotNull(stream, "executables");
        Assertions.assertAll(convert(stream));
    }

    @API(since = "5.5", status = API.Status.EXPERIMENTAL)
    public static final <R> R assertDoesNotThrow(@NotNull String str, @NotNull Function0<? extends R> function0) {
        ThrowingSupplier throwingSupplier;
        Intrinsics.checkParameterIsNotNull(str, "message");
        Intrinsics.checkParameterIsNotNull(function0, "executable");
        AssertionsKt$assertDoesNotThrow$1 assertionsKt$assertDoesNotThrow$1 = new AssertionsKt$assertDoesNotThrow$1(str);
        try {
            throwingSupplier = new AssertionsKt$evaluateAndWrap$1(function0.invoke());
        } catch (Throwable th2) {
            throwingSupplier = new AssertionsKt$evaluateAndWrap$2(th2);
        }
        return Assertions.assertDoesNotThrow(throwingSupplier, (Supplier<String>) new AssertionsKt$sam$i$java_util_function_Supplier$0(assertionsKt$assertDoesNotThrow$1));
    }

    public static final /* synthetic */ <T extends Throwable> T assertThrows(Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "executable");
        try {
            th = function0.invoke();
        } catch (Throwable th2) {
            th = th2;
        }
        if (!(th instanceof Throwable)) {
            th = null;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        T assertThrows = Assertions.assertThrows(Throwable.class, new AssertionsKt$assertThrows$1((Throwable) th));
        Intrinsics.checkExpressionValueIsNotNull(assertThrows, "Assertions.assertThrows(…throwable\n        }\n    }");
        return assertThrows;
    }

    @API(since = "5.5", status = API.Status.EXPERIMENTAL)
    public static final <R> R assertTimeout(@NotNull Duration duration, @NotNull Function0<? extends R> function0) {
        Intrinsics.checkParameterIsNotNull(duration, "timeout");
        Intrinsics.checkParameterIsNotNull(function0, "executable");
        return Assertions.assertTimeout(duration, new AssertionsKt$sam$org_junit_jupiter_api_function_ThrowingSupplier$0(function0));
    }

    @API(since = "5.5", status = API.Status.EXPERIMENTAL)
    public static final <R> R assertTimeoutPreemptively(@NotNull Duration duration, @NotNull Function0<? extends R> function0) {
        Intrinsics.checkParameterIsNotNull(duration, "timeout");
        Intrinsics.checkParameterIsNotNull(function0, "executable");
        return Assertions.assertTimeoutPreemptively(duration, new AssertionsKt$sam$org_junit_jupiter_api_function_ThrowingSupplier$0(function0));
    }

    private static final Stream<Executable> convert(Stream<Function0<Unit>> stream) {
        return stream.map(AssertionsKt$convert$1.INSTANCE);
    }

    @NotNull
    @PublishedApi
    public static final <R> ThrowingSupplier<R> evaluateAndWrap(@NotNull Function0<? extends R> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "executable");
        try {
            return new AssertionsKt$evaluateAndWrap$1(function0.invoke());
        } catch (Throwable th2) {
            return new AssertionsKt$evaluateAndWrap$2(th2);
        }
    }

    @NotNull
    public static final Void fail(@Nullable String str, @Nullable Throwable th2) {
        Object fail = Assertions.fail(str, th2);
        Intrinsics.checkExpressionValueIsNotNull(fail, "Assertions.fail<Nothing>(message, throwable)");
        return (Void) fail;
    }

    public static /* synthetic */ Void fail$default(String str, Throwable th2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            th2 = null;
        }
        return fail(str, th2);
    }

    public static final void assertAll(@Nullable String str, @NotNull Stream<Function0<Unit>> stream) {
        Intrinsics.checkParameterIsNotNull(stream, "executables");
        Assertions.assertAll(str, convert(stream));
    }

    @API(since = "5.5", status = API.Status.EXPERIMENTAL)
    public static final <R> R assertTimeout(@NotNull Duration duration, @NotNull String str, @NotNull Function0<? extends R> function0) {
        Intrinsics.checkParameterIsNotNull(duration, "timeout");
        Intrinsics.checkParameterIsNotNull(str, "message");
        Intrinsics.checkParameterIsNotNull(function0, "executable");
        return Assertions.assertTimeout(duration, new AssertionsKt$sam$org_junit_jupiter_api_function_ThrowingSupplier$0(function0), str);
    }

    @API(since = "5.5", status = API.Status.EXPERIMENTAL)
    public static final <R> R assertTimeoutPreemptively(@NotNull Duration duration, @NotNull String str, @NotNull Function0<? extends R> function0) {
        Intrinsics.checkParameterIsNotNull(duration, "timeout");
        Intrinsics.checkParameterIsNotNull(str, "message");
        Intrinsics.checkParameterIsNotNull(function0, "executable");
        return Assertions.assertTimeoutPreemptively(duration, new AssertionsKt$sam$org_junit_jupiter_api_function_ThrowingSupplier$0(function0), str);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [org.junit.jupiter.api.AssertionsKt$sam$org_junit_jupiter_api_function_Executable$0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.util.List<org.junit.jupiter.api.function.Executable> convert(java.util.Collection<? extends kotlin.jvm.functions.Function0<kotlin.Unit>> r3) {
        /*
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r3, r1)
            r0.<init>(r1)
            java.util.Iterator r3 = r3.iterator()
        L_0x0011:
            boolean r1 = r3.hasNext()
            if (r1 == 0) goto L_0x002b
            java.lang.Object r1 = r3.next()
            kotlin.jvm.functions.Function0 r1 = (kotlin.jvm.functions.Function0) r1
            if (r1 == 0) goto L_0x0025
            org.junit.jupiter.api.AssertionsKt$sam$org_junit_jupiter_api_function_Executable$0 r2 = new org.junit.jupiter.api.AssertionsKt$sam$org_junit_jupiter_api_function_Executable$0
            r2.<init>(r1)
            r1 = r2
        L_0x0025:
            org.junit.jupiter.api.function.Executable r1 = (org.junit.jupiter.api.function.Executable) r1
            r0.add(r1)
            goto L_0x0011
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.api.AssertionsKt.convert(java.util.Collection):java.util.List");
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [org.junit.jupiter.api.AssertionsKt$sam$java_util_function_Supplier$0] */
    /* JADX WARNING: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Void fail(@org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<java.lang.String> r1) {
        /*
            if (r1 == 0) goto L_0x0008
            org.junit.jupiter.api.AssertionsKt$sam$java_util_function_Supplier$0 r0 = new org.junit.jupiter.api.AssertionsKt$sam$java_util_function_Supplier$0
            r0.<init>(r1)
            r1 = r0
        L_0x0008:
            j$.util.function.Supplier r1 = (j$.util.function.Supplier) r1
            java.lang.Object r1 = org.junit.jupiter.api.Assertions.fail((j$.util.function.Supplier<java.lang.String>) r1)
            java.lang.String r0 = "Assertions.fail<Nothing>(message)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r0)
            java.lang.Void r1 = (java.lang.Void) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.api.AssertionsKt.fail(kotlin.jvm.functions.Function0):java.lang.Void");
    }

    public static final void assertAll(@NotNull Collection<? extends Function0<Unit>> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "executables");
        Assertions.assertAll((Collection<Executable>) convert(collection));
    }

    @API(since = "5.5", status = API.Status.EXPERIMENTAL)
    public static final <R> R assertTimeout(@NotNull Duration duration, @NotNull Function0<String> function0, @NotNull Function0<? extends R> function02) {
        Intrinsics.checkParameterIsNotNull(duration, "timeout");
        Intrinsics.checkParameterIsNotNull(function0, "message");
        Intrinsics.checkParameterIsNotNull(function02, "executable");
        return Assertions.assertTimeout(duration, new AssertionsKt$sam$org_junit_jupiter_api_function_ThrowingSupplier$0(function02), (Supplier<String>) new AssertionsKt$sam$java_util_function_Supplier$0(function0));
    }

    @API(since = "5.5", status = API.Status.EXPERIMENTAL)
    public static final <R> R assertTimeoutPreemptively(@NotNull Duration duration, @NotNull Function0<String> function0, @NotNull Function0<? extends R> function02) {
        Intrinsics.checkParameterIsNotNull(duration, "timeout");
        Intrinsics.checkParameterIsNotNull(function0, "message");
        Intrinsics.checkParameterIsNotNull(function02, "executable");
        return Assertions.assertTimeoutPreemptively(duration, new AssertionsKt$sam$org_junit_jupiter_api_function_ThrowingSupplier$0(function02), (Supplier<String>) new AssertionsKt$sam$java_util_function_Supplier$0(function0));
    }

    @NotNull
    public static final Void fail(@Nullable Throwable th2) {
        Object fail = Assertions.fail(th2);
        Intrinsics.checkExpressionValueIsNotNull(fail, "Assertions.fail<Nothing>(throwable)");
        return (Void) fail;
    }

    public static final void assertAll(@Nullable String str, @NotNull Collection<? extends Function0<Unit>> collection) {
        Intrinsics.checkParameterIsNotNull(collection, "executables");
        Assertions.assertAll(str, (Collection<Executable>) convert(collection));
    }

    public static final /* synthetic */ <T extends Throwable> T assertThrows(String str, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        Intrinsics.checkParameterIsNotNull(function0, "executable");
        AssertionsKt$assertThrows$2 assertionsKt$assertThrows$2 = new AssertionsKt$assertThrows$2(str);
        try {
            th = function0.invoke();
        } catch (Throwable th2) {
            th = th2;
        }
        if (!(th instanceof Throwable)) {
            th = null;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        T assertThrows = Assertions.assertThrows(Throwable.class, (Executable) new AssertionsKt$assertThrows$3((Throwable) th), (Supplier<String>) new AssertionsKt$sam$i$java_util_function_Supplier$0(assertionsKt$assertThrows$2));
        Intrinsics.checkExpressionValueIsNotNull(assertThrows, "Assertions.assertThrows(…  Supplier(message)\n    )");
        return assertThrows;
    }

    public static final void assertAll(@NotNull Function0<Unit>... function0Arr) {
        Intrinsics.checkParameterIsNotNull(function0Arr, "executables");
        Stream stream = Collection.EL.stream(ArraysKt___ArraysKt.toList((T[]) function0Arr));
        Intrinsics.checkExpressionValueIsNotNull(stream, "executables.toList().stream()");
        assertAll((Stream<Function0<Unit>>) stream);
    }

    public static final void assertAll(@Nullable String str, @NotNull Function0<Unit>... function0Arr) {
        Intrinsics.checkParameterIsNotNull(function0Arr, "executables");
        Stream stream = Collection.EL.stream(ArraysKt___ArraysKt.toList((T[]) function0Arr));
        Intrinsics.checkExpressionValueIsNotNull(stream, "executables.toList().stream()");
        assertAll(str, (Stream<Function0<Unit>>) stream);
    }

    @API(since = "5.5", status = API.Status.EXPERIMENTAL)
    public static final <R> R assertDoesNotThrow(@NotNull Function0<? extends R> function0) {
        ThrowingSupplier throwingSupplier;
        Intrinsics.checkParameterIsNotNull(function0, "executable");
        try {
            throwingSupplier = new AssertionsKt$evaluateAndWrap$1(function0.invoke());
        } catch (Throwable th2) {
            throwingSupplier = new AssertionsKt$evaluateAndWrap$2(th2);
        }
        return Assertions.assertDoesNotThrow(throwingSupplier);
    }

    @API(since = "5.5", status = API.Status.EXPERIMENTAL)
    public static final <R> R assertDoesNotThrow(@NotNull Function0<String> function0, @NotNull Function0<? extends R> function02) {
        ThrowingSupplier throwingSupplier;
        Intrinsics.checkParameterIsNotNull(function0, "message");
        Intrinsics.checkParameterIsNotNull(function02, "executable");
        try {
            throwingSupplier = new AssertionsKt$evaluateAndWrap$1(function02.invoke());
        } catch (Throwable th2) {
            throwingSupplier = new AssertionsKt$evaluateAndWrap$2(th2);
        }
        return Assertions.assertDoesNotThrow(throwingSupplier, (Supplier<String>) new AssertionsKt$sam$i$java_util_function_Supplier$0(function0));
    }

    public static final /* synthetic */ <T extends Throwable> T assertThrows(Function0<String> function0, Function0<Unit> function02) {
        Intrinsics.checkParameterIsNotNull(function0, "message");
        Intrinsics.checkParameterIsNotNull(function02, "executable");
        try {
            th = function02.invoke();
        } catch (Throwable th2) {
            th = th2;
        }
        if (!(th instanceof Throwable)) {
            th = null;
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        T assertThrows = Assertions.assertThrows(Throwable.class, (Executable) new AssertionsKt$assertThrows$3((Throwable) th), (Supplier<String>) new AssertionsKt$sam$i$java_util_function_Supplier$0(function0));
        Intrinsics.checkExpressionValueIsNotNull(assertThrows, "Assertions.assertThrows(…  Supplier(message)\n    )");
        return assertThrows;
    }
}
