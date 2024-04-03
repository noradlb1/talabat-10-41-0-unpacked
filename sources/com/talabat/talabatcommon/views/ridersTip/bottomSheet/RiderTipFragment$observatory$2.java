package com.talabat.talabatcommon.views.ridersTip.bottomSheet;

import com.talabat.talabatcommon.views.ridersTip.model.RidersTipSuggestionsDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class RiderTipFragment$observatory$2 extends FunctionReferenceImpl implements Function1<RidersTipSuggestionsDisplayModel, Unit> {
    public RiderTipFragment$observatory$2(Object obj) {
        super(1, obj, RiderTipFragment.class, "updateTipSuggestions", "updateTipSuggestions(Lcom/talabat/talabatcommon/views/ridersTip/model/RidersTipSuggestionsDisplayModel;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RidersTipSuggestionsDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable RidersTipSuggestionsDisplayModel ridersTipSuggestionsDisplayModel) {
        ((RiderTipFragment) this.receiver).updateTipSuggestions(ridersTipSuggestionsDisplayModel);
    }
}
