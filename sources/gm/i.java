package gm;

import com.talabat.feature.darkstorescart.data.repository.DarkstoresCartRepository;
import io.reactivex.functions.Function;
import kotlin.Unit;

public final /* synthetic */ class i implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresCartRepository f62101b;

    public /* synthetic */ i(DarkstoresCartRepository darkstoresCartRepository) {
        this.f62101b = darkstoresCartRepository;
    }

    public final Object apply(Object obj) {
        return DarkstoresCartRepository.m10172clearCartIfDifferentVendor$lambda17(this.f62101b, (Unit) obj);
    }
}
