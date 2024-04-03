package lm;

import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstoresflutter.data.repository.DarkstoresCartFlutterRepositoryImpl;
import io.reactivex.functions.Function;

public final /* synthetic */ class c implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartFlutterRepositoryImpl f62244b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f62245c;

    public /* synthetic */ c(DarkstoresCartFlutterRepositoryImpl darkstoresCartFlutterRepositoryImpl, String str) {
        this.f62244b = darkstoresCartFlutterRepositoryImpl;
        this.f62245c = str;
    }

    public final Object apply(Object obj) {
        return DarkstoresCartFlutterRepositoryImpl.m10201addProductToCart$lambda1(this.f62244b, this.f62245c, (Product) obj);
    }
}
