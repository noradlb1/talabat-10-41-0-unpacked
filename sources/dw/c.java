package dw;

import com.talabat.talabatcore.adapters.FunctionalAdaptersKt;
import com.talabat.talabatcore.adapters.UpdatableAdapter;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.jvm.functions.Function2;

public final /* synthetic */ class c implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function2 f13905b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ UpdatableAdapter f13906c;

    public /* synthetic */ c(Function2 function2, UpdatableAdapter updatableAdapter) {
        this.f13905b = function2;
        this.f13906c = updatableAdapter;
    }

    public final void accept(Object obj) {
        FunctionalAdaptersKt.m5826withAdapter$lambda4(this.f13905b, this.f13906c, (List) obj);
    }
}
