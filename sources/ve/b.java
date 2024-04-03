package ve;

import buisnessmodels.GEMEngine;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class b implements Consumer {
    public final void accept(Object obj) {
        ((GEMEngine) obj).stopListeners();
    }
}
