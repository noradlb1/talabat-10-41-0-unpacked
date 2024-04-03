package com.checkout.eventlogger;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0001*\u00028\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/checkout/eventlogger/CheckoutEventLoggerExtensions;", "T", "Lkotlin/Function1;", "", "loggingBlock", "log", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "<init>", "()V", "logger_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class CheckoutEventLoggerExtensions {
    @NotNull
    public static final CheckoutEventLoggerExtensions INSTANCE = new CheckoutEventLoggerExtensions();

    public final /* synthetic */ <T> T log(T t11, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "loggingBlock");
        try {
            function1.invoke(t11);
        } catch (Exception unused) {
        }
        return t11;
    }
}
