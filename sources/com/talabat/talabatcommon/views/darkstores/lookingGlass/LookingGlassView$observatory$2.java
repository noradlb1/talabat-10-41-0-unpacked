package com.talabat.talabatcommon.views.darkstores.lookingGlass;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class LookingGlassView$observatory$2 extends FunctionReferenceImpl implements Function1<Pair<? extends String, ? extends Map<String, ? extends String>>, Unit> {
    public LookingGlassView$observatory$2(Object obj) {
        super(1, obj, LookingGlassView.class, "sendAnalyticEvent", "sendAnalyticEvent(Lkotlin/Pair;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Pair<String, ? extends Map<String, String>>) (Pair) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Pair<String, ? extends Map<String, String>> pair) {
        ((LookingGlassView) this.receiver).sendAnalyticEvent(pair);
    }
}
