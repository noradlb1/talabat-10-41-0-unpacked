package com.talabat.talabatcommon.views.darkstores.lookingGlass;

import com.talabat.talabatcore.exception.Failure;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class LookingGlassView$observatory$4 extends FunctionReferenceImpl implements Function1<Failure, Unit> {
    public LookingGlassView$observatory$4(Object obj) {
        super(1, obj, LookingGlassView.class, "failureHere", "failureHere(Lcom/talabat/talabatcore/exception/Failure;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Failure) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Failure failure) {
        ((LookingGlassView) this.receiver).failureHere(failure);
    }
}
