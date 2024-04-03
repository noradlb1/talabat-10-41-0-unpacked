package lm;

import com.talabat.feature.darkstorescart.data.model.CartResponse;
import com.talabat.feature.darkstoresflutter.data.repository.DarkstoresCartFlutterRepositoryImpl;
import io.reactivex.functions.Function;
import java.util.List;

public final /* synthetic */ class f implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartFlutterRepositoryImpl f62248b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CartResponse f62249c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f62250d;

    public /* synthetic */ f(DarkstoresCartFlutterRepositoryImpl darkstoresCartFlutterRepositoryImpl, CartResponse cartResponse, boolean z11) {
        this.f62248b = darkstoresCartFlutterRepositoryImpl;
        this.f62249c = cartResponse;
        this.f62250d = z11;
    }

    public final Object apply(Object obj) {
        return DarkstoresCartFlutterRepositoryImpl.m10204observeCartChanges$lambda5$lambda4(this.f62248b, this.f62249c, this.f62250d, (List) obj);
    }
}
