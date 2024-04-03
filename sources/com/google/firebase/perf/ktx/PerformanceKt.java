package com.google.firebase.perf.ktx;

import com.google.firebase.ktx.Firebase;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.metrics.HttpMetric;
import com.google.firebase.perf.metrics.Trace;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a8\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b2\u0006\u0010\t\u001a\u00020\u00012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\b0\u000b¢\u0006\u0002\b\rH\bø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a)\u0010\u0007\u001a\u00020\u000f*\u00020\u00102\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000f0\u000b¢\u0006\u0002\b\rH\bø\u0001\u0000\u001a4\u0010\u0007\u001a\u0002H\b\"\u0004\b\u0000\u0010\b*\u00020\f2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\b0\u000b¢\u0006\u0002\b\rH\bø\u0001\u0000¢\u0006\u0002\u0010\u0011\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0012"}, d2 = {"LIBRARY_NAME", "", "performance", "Lcom/google/firebase/perf/FirebasePerformance;", "Lcom/google/firebase/ktx/Firebase;", "getPerformance", "(Lcom/google/firebase/ktx/Firebase;)Lcom/google/firebase/perf/FirebasePerformance;", "trace", "T", "name", "block", "Lkotlin/Function1;", "Lcom/google/firebase/perf/metrics/Trace;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "", "Lcom/google/firebase/perf/metrics/HttpMetric;", "(Lcom/google/firebase/perf/metrics/Trace;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "com.google.firebase-firebase-perf-ktx"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PerformanceKt {
    @NotNull
    public static final String LIBRARY_NAME = "fire-perf-ktx";

    @NotNull
    public static final FirebasePerformance getPerformance(@NotNull Firebase firebase2) {
        Intrinsics.checkNotNullParameter(firebase2, "<this>");
        FirebasePerformance instance = FirebasePerformance.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }

    public static final void trace(@NotNull HttpMetric httpMetric, @NotNull Function1<? super HttpMetric, Unit> function1) {
        Intrinsics.checkNotNullParameter(httpMetric, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        httpMetric.start();
        try {
            function1.invoke(httpMetric);
        } finally {
            InlineMarker.finallyStart(1);
            httpMetric.stop();
            InlineMarker.finallyEnd(1);
        }
    }

    public static final <T> T trace(@NotNull Trace trace, @NotNull Function1<? super Trace, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(trace, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        trace.start();
        try {
            return function1.invoke(trace);
        } finally {
            InlineMarker.finallyStart(1);
            trace.stop();
            InlineMarker.finallyEnd(1);
        }
    }

    public static final <T> T trace(@NotNull String str, @NotNull Function1<? super Trace, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function1, "block");
        Trace create = Trace.create(str);
        Intrinsics.checkNotNullExpressionValue(create, "create(name)");
        create.start();
        try {
            return function1.invoke(create);
        } finally {
            InlineMarker.finallyStart(1);
            create.stop();
            InlineMarker.finallyEnd(1);
        }
    }
}
