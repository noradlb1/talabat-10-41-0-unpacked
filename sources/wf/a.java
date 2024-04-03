package wf;

import com.talabat.collectiondetails.ui.quickfilter.QuickFilterBEFiltrationInteractor;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.functions.Function1;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function1 f57918b;

    public /* synthetic */ a(Function1 function1) {
        this.f57918b = function1;
    }

    public final void accept(Object obj) {
        QuickFilterBEFiltrationInteractor.m9546handleFiltering$lambda6(this.f57918b, (List) obj);
    }
}
