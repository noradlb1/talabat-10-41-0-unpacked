package com.checkout.frames.component.cvv;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public /* synthetic */ class CvvComponentKt$CvvComponent$2 extends FunctionReferenceImpl implements Function1<String, Unit> {
    public CvvComponentKt$CvvComponent$2(Object obj) {
        super(1, obj, CvvViewModel.class, "onCvvChange", "onCvvChange(Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "p0");
        ((CvvViewModel) this.receiver).onCvvChange(str);
    }
}
