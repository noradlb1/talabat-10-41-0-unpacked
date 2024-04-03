package com.talabat.talabatcommon.extentions;

import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class CoroutinesKt$returnHandling$1 extends FunctionReferenceImpl implements Function1<Throwable, Unit> {
    public static final CoroutinesKt$returnHandling$1 INSTANCE = new CoroutinesKt$returnHandling$1();

    public CoroutinesKt$returnHandling$1() {
        super(1, ThrowablesKt.class, LogWriteConstants.LOG_TYPE, "log(Ljava/lang/Throwable;)V", 1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "p0");
        ThrowablesKt.log(th2);
    }
}
