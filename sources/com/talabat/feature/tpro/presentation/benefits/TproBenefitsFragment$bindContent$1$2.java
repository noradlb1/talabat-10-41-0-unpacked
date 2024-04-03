package com.talabat.feature.tpro.presentation.benefits;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class TproBenefitsFragment$bindContent$1$2 extends FunctionReferenceImpl implements Function2<String, Pair<? extends String, ? extends String>, Unit> {
    public TproBenefitsFragment$bindContent$1$2(Object obj) {
        super(2, obj, TproBenefitsFragment.class, "logEventToGA", "logEventToGA(Ljava/lang/String;Lkotlin/Pair;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (Pair<String, String>) (Pair) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str, @NotNull Pair<String, String> pair) {
        Intrinsics.checkNotNullParameter(str, "p0");
        Intrinsics.checkNotNullParameter(pair, "p1");
        ((TproBenefitsFragment) this.receiver).logEventToGA(str, pair);
    }
}
