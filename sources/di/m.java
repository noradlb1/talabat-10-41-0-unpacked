package di;

import com.talabat.darkstores.data.darkstores.DarkstoresRepo;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class m implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepo f56710b;

    public /* synthetic */ m(DarkstoresRepo darkstoresRepo) {
        this.f56710b = darkstoresRepo;
    }

    public final void accept(Object obj) {
        DarkstoresRepo.m9658generateVoucher$lambda24(this.f56710b, (Throwable) obj);
    }
}
