package pl;

import com.talabat.feature.bnplcore.domain.usecase.impl.SendNavigationOptionLoadedEventUseCaseImpl;
import io.reactivex.functions.Action;

public final /* synthetic */ class b implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SendNavigationOptionLoadedEventUseCaseImpl f62785b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f62786c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f62787d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f62788e;

    public /* synthetic */ b(SendNavigationOptionLoadedEventUseCaseImpl sendNavigationOptionLoadedEventUseCaseImpl, String str, String str2, String str3) {
        this.f62785b = sendNavigationOptionLoadedEventUseCaseImpl;
        this.f62786c = str;
        this.f62787d = str2;
        this.f62788e = str3;
    }

    public final void run() {
        SendNavigationOptionLoadedEventUseCaseImpl.m10144invoke$lambda1(this.f62785b, this.f62786c, this.f62787d, this.f62788e);
    }
}
