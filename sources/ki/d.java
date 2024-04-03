package ki;

import com.talabat.darkstores.data.repository.DarkstoresRepositoryImpl;
import datamodels.Restaurant;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DarkstoresRepositoryImpl f56974b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Restaurant f56975c;

    public /* synthetic */ d(DarkstoresRepositoryImpl darkstoresRepositoryImpl, Restaurant restaurant) {
        this.f56974b = darkstoresRepositoryImpl;
        this.f56975c = restaurant;
    }

    public final void run() {
        DarkstoresRepositoryImpl.m9732putLastVisitedVendor$lambda3(this.f56974b, this.f56975c);
    }
}
