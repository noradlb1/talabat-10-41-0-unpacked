package io.reactivex.rxkotlin;

import io.reactivex.Observable;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.annotations.SchedulerSupport;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JJ\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\u00050\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0004H\u0007Je\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\n0\fH\bJh\u0010\u0003\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e0\r0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0004H\u0007J\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042 \b\u0004\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\n0\u0010H\bJ¡\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042&\b\u0004\u0010\u000b\u001a \u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\n0\u0013H\bJ¿\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042,\b\u0004\u0010\u000b\u001a&\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\n0\u0016H\bJÝ\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\u0017*\u00020\u0001\"\b\b\u0006\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u000422\b\u0004\u0010\u000b\u001a,\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\n0\u0019H\bJû\u0001\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\u0017*\u00020\u0001\"\b\b\u0006\u0010\u001a*\u00020\u0001\"\b\b\u0007\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u000428\b\u0004\u0010\u000b\u001a2\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\n0\u001cH\bJ\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\u0017*\u00020\u0001\"\b\b\u0006\u0010\u001a*\u00020\u0001\"\b\b\u0007\u0010\u001d*\u00020\u0001\"\b\b\b\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00042>\b\u0004\u0010\u000b\u001a8\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\n0\u001fH\bJ·\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\u0017*\u00020\u0001\"\b\b\u0006\u0010\u001a*\u00020\u0001\"\b\b\u0007\u0010\u001d*\u00020\u0001\"\b\b\b\u0010 *\u00020\u0001\"\b\b\t\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\u00042D\b\u0004\u0010\u000b\u001a>\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\n0\"H\bJJ\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00070\u00050\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0004H\u0007Je\u0010#\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\u001a\b\u0004\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\n0\fH\bJh\u0010#\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e0\r0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0004H\u0007J\u0001\u0010#\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042 \b\u0004\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\n0\u0010H\bJ¡\u0001\u0010#\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042&\b\u0004\u0010\u000b\u001a \u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\n0\u0013H\bJ¿\u0001\u0010#\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042,\b\u0004\u0010\u000b\u001a&\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\n0\u0016H\bJÝ\u0001\u0010#\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\u0017*\u00020\u0001\"\b\b\u0006\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u000422\b\u0004\u0010\u000b\u001a,\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\n0\u0019H\bJû\u0001\u0010#\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\u0017*\u00020\u0001\"\b\b\u0006\u0010\u001a*\u00020\u0001\"\b\b\u0007\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u000428\b\u0004\u0010\u000b\u001a2\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\n0\u001cH\bJ\u0002\u0010#\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\u0017*\u00020\u0001\"\b\b\u0006\u0010\u001a*\u00020\u0001\"\b\b\u0007\u0010\u001d*\u00020\u0001\"\b\b\b\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00042>\b\u0004\u0010\u000b\u001a8\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\n0\u001fH\bJ·\u0002\u0010#\u001a\b\u0012\u0004\u0012\u0002H\n0\u0004\"\b\b\u0000\u0010\u0006*\u00020\u0001\"\b\b\u0001\u0010\u0007*\u00020\u0001\"\b\b\u0002\u0010\u000e*\u00020\u0001\"\b\b\u0003\u0010\u0011*\u00020\u0001\"\b\b\u0004\u0010\u0014*\u00020\u0001\"\b\b\u0005\u0010\u0017*\u00020\u0001\"\b\b\u0006\u0010\u001a*\u00020\u0001\"\b\b\u0007\u0010\u001d*\u00020\u0001\"\b\b\b\u0010 *\u00020\u0001\"\b\b\t\u0010\n*\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00042\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00042\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00140\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00170\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00042\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H 0\u00042D\b\u0004\u0010\u000b\u001a>\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u001a\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\n0\"H\b¨\u0006$"}, d2 = {"Lio/reactivex/rxkotlin/Observables;", "", "()V", "combineLatest", "Lio/reactivex/Observable;", "Lkotlin/Pair;", "T1", "T2", "source1", "source2", "R", "combineFunction", "Lkotlin/Function2;", "Lkotlin/Triple;", "T3", "source3", "Lkotlin/Function3;", "T4", "source4", "Lkotlin/Function4;", "T5", "source5", "Lkotlin/Function5;", "T6", "source6", "Lkotlin/Function6;", "T7", "source7", "Lkotlin/Function7;", "T8", "source8", "Lkotlin/Function8;", "T9", "source9", "Lkotlin/Function9;", "zip", "rxkotlin"}, k = 1, mv = {1, 1, 15})
public final class Observables {
    public static final Observables INSTANCE = new Observables();

    private Observables() {
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(function2, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(observable, observable2, new Observables$combineLatest$1(function2));
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…ombineFunction(t1, t2) })");
        return combineLatest;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Function2<? super T1, ? super T2, ? extends R> function2) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(function2, "combineFunction");
        Observable<R> zip = Observable.zip(observable, observable2, new Observables$zip$1(function2));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(source1, …ombineFunction(t1, t2) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2> Observable<Pair<T1, T2>> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Observable<Pair<T1, T2>> combineLatest = Observable.combineLatest(observable, observable2, Observables$combineLatest$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…> { t1, t2 -> t1 to t2 })");
        return combineLatest;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2> Observable<Pair<T1, T2>> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Observable<Pair<T1, T2>> zip = Observable.zip(observable, observable2, Observables$zip$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(source1, …> { t1, t2 -> t1 to t2 })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(function3, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(observable, observable2, observable3, new Observables$combineLatest$3(function3));
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…neFunction(t1, t2, t3) })");
        return combineLatest;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Function3<? super T1, ? super T2, ? super T3, ? extends R> function3) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(function3, "combineFunction");
        Observable<R> zip = Observable.zip(observable, observable2, observable3, new Observables$zip$3(function3));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(source1, …neFunction(t1, t2, t3) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3> Observable<Triple<T1, T2, T3>> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Observable<Triple<T1, T2, T3>> combineLatest = Observable.combineLatest(observable, observable2, observable3, Observables$combineLatest$4.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest… -> Triple(t1, t2, t3) })");
        return combineLatest;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3> Observable<Triple<T1, T2, T3>> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Observable<Triple<T1, T2, T3>> zip = Observable.zip(observable, observable2, observable3, Observables$zip$4.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(source1, … -> Triple(t1, t2, t3) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(function4, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(observable, observable2, observable3, observable4, new Observables$combineLatest$5(function4));
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…nction(t1, t2, t3, t4) })");
        return combineLatest;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Function4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> function4) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(function4, "combineFunction");
        Observable<R> zip = Observable.zip(observable, observable2, observable3, observable4, new Observables$zip$5(function4));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(source1, …nction(t1, t2, t3, t4) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(function5, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(observable, observable2, observable3, observable4, observable5, new Observables$combineLatest$6(function5));
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…on(t1, t2, t3, t4, t5) })");
        return combineLatest;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> function5) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(function5, "combineFunction");
        Observable<R> zip = Observable.zip(observable, observable2, observable3, observable4, observable5, new Observables$zip$6(function5));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(source1, …on(t1, t2, t3, t4, t5) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(function6, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(observable, observable2, observable3, observable4, observable5, observable6, new Observables$combineLatest$7(function6));
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…1, t2, t3, t4, t5, t6) })");
        return combineLatest;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, T6, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> function6) {
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Intrinsics.checkParameterIsNotNull(observable6, "source6");
        Intrinsics.checkParameterIsNotNull(function6, "combineFunction");
        Observable<R> zip = Observable.zip(observable, observable2, observable3, observable4, observable5, observable6, new Observables$zip$7(function6));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(source1, …1, t2, t3, t4, t5, t6) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Observable<T7> observable7, @NotNull Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function72 = function7;
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Observable<T6> observable8 = observable6;
        Intrinsics.checkParameterIsNotNull(observable8, "source6");
        Observable<T7> observable9 = observable7;
        Intrinsics.checkParameterIsNotNull(observable9, "source7");
        Intrinsics.checkParameterIsNotNull(function72, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(observable, observable2, observable3, observable4, observable5, observable8, observable9, new Observables$combineLatest$8(function72));
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…2, t3, t4, t5, t6, t7) })");
        return combineLatest;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Observable<T7> observable7, @NotNull Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function7) {
        Function7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> function72 = function7;
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Intrinsics.checkParameterIsNotNull(observable5, "source5");
        Observable<T6> observable8 = observable6;
        Intrinsics.checkParameterIsNotNull(observable8, "source6");
        Observable<T7> observable9 = observable7;
        Intrinsics.checkParameterIsNotNull(observable9, "source7");
        Intrinsics.checkParameterIsNotNull(function72, "combineFunction");
        Observable<R> zip = Observable.zip(observable, observable2, observable3, observable4, observable5, observable8, observable9, new Observables$zip$8(function72));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(source1, …2, t3, t4, t5, t6, t7) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Observable<T7> observable7, @NotNull Observable<T8> observable8, @NotNull Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function82 = function8;
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Observable<T5> observable9 = observable5;
        Intrinsics.checkParameterIsNotNull(observable9, "source5");
        Observable<T6> observable10 = observable6;
        Intrinsics.checkParameterIsNotNull(observable10, "source6");
        Observable<T7> observable11 = observable7;
        Intrinsics.checkParameterIsNotNull(observable11, "source7");
        Observable<T8> observable12 = observable8;
        Intrinsics.checkParameterIsNotNull(observable12, "source8");
        Intrinsics.checkParameterIsNotNull(function82, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(observable, observable2, observable3, observable4, observable9, observable10, observable11, observable12, new Observables$combineLatest$9(function82));
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…3, t4, t5, t6, t7, t8) })");
        return combineLatest;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Observable<T7> observable7, @NotNull Observable<T8> observable8, @NotNull Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function8) {
        Function8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> function82 = function8;
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Intrinsics.checkParameterIsNotNull(observable4, "source4");
        Observable<T5> observable9 = observable5;
        Intrinsics.checkParameterIsNotNull(observable9, "source5");
        Observable<T6> observable10 = observable6;
        Intrinsics.checkParameterIsNotNull(observable10, "source6");
        Observable<T7> observable11 = observable7;
        Intrinsics.checkParameterIsNotNull(observable11, "source7");
        Observable<T8> observable12 = observable8;
        Intrinsics.checkParameterIsNotNull(observable12, "source8");
        Intrinsics.checkParameterIsNotNull(function82, "combineFunction");
        Observable<R> zip = Observable.zip(observable, observable2, observable3, observable4, observable9, observable10, observable11, observable12, new Observables$zip$9(function82));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(source1, …3, t4, t5, t6, t7, t8) })");
        return zip;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> combineLatest(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Observable<T7> observable7, @NotNull Observable<T8> observable8, @NotNull Observable<T9> observable9, @NotNull Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function92 = function9;
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Observable<T4> observable10 = observable4;
        Intrinsics.checkParameterIsNotNull(observable10, "source4");
        Observable<T5> observable11 = observable5;
        Intrinsics.checkParameterIsNotNull(observable11, "source5");
        Observable<T6> observable12 = observable6;
        Intrinsics.checkParameterIsNotNull(observable12, "source6");
        Observable<T7> observable13 = observable7;
        Intrinsics.checkParameterIsNotNull(observable13, "source7");
        Observable<T8> observable14 = observable8;
        Intrinsics.checkParameterIsNotNull(observable14, "source8");
        Observable<T9> observable15 = observable9;
        Intrinsics.checkParameterIsNotNull(observable15, "source9");
        Intrinsics.checkParameterIsNotNull(function92, "combineFunction");
        Observable<R> combineLatest = Observable.combineLatest(observable, observable2, observable3, observable10, observable11, observable12, observable13, observable14, observable15, new Observables$combineLatest$10(function92));
        Intrinsics.checkExpressionValueIsNotNull(combineLatest, "Observable.combineLatest…4, t5, t6, t7, t8, t9) })");
        return combineLatest;
    }

    @CheckReturnValue
    @NotNull
    @SchedulerSupport("none")
    public final <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> zip(@NotNull Observable<T1> observable, @NotNull Observable<T2> observable2, @NotNull Observable<T3> observable3, @NotNull Observable<T4> observable4, @NotNull Observable<T5> observable5, @NotNull Observable<T6> observable6, @NotNull Observable<T7> observable7, @NotNull Observable<T8> observable8, @NotNull Observable<T9> observable9, @NotNull Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function9) {
        Function9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> function92 = function9;
        Intrinsics.checkParameterIsNotNull(observable, "source1");
        Intrinsics.checkParameterIsNotNull(observable2, "source2");
        Intrinsics.checkParameterIsNotNull(observable3, "source3");
        Observable<T4> observable10 = observable4;
        Intrinsics.checkParameterIsNotNull(observable10, "source4");
        Observable<T5> observable11 = observable5;
        Intrinsics.checkParameterIsNotNull(observable11, "source5");
        Observable<T6> observable12 = observable6;
        Intrinsics.checkParameterIsNotNull(observable12, "source6");
        Observable<T7> observable13 = observable7;
        Intrinsics.checkParameterIsNotNull(observable13, "source7");
        Observable<T8> observable14 = observable8;
        Intrinsics.checkParameterIsNotNull(observable14, "source8");
        Observable<T9> observable15 = observable9;
        Intrinsics.checkParameterIsNotNull(observable15, "source9");
        Intrinsics.checkParameterIsNotNull(function92, "combineFunction");
        Observable<R> zip = Observable.zip(observable, observable2, observable3, observable10, observable11, observable12, observable13, observable14, observable15, new Observables$zip$10(function92));
        Intrinsics.checkExpressionValueIsNotNull(zip, "Observable.zip(source1, …4, t5, t6, t7, t8, t9) })");
        return zip;
    }
}
