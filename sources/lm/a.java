package lm;

import com.talabat.feature.darkstoresflutter.data.repository.DarkstoresCartFlutterRepositoryImpl;
import io.reactivex.functions.Function;
import kotlin.Pair;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartFlutterRepositoryImpl f62241b;

    public /* synthetic */ a(DarkstoresCartFlutterRepositoryImpl darkstoresCartFlutterRepositoryImpl) {
        this.f62241b = darkstoresCartFlutterRepositoryImpl;
    }

    public final Object apply(Object obj) {
        return DarkstoresCartFlutterRepositoryImpl.m10203observeCartChanges$lambda5(this.f62241b, (Pair) obj);
    }
}
