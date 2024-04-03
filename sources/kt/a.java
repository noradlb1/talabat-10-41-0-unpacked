package kt;

import com.talabat.restaurants.v2.data.swimlane.SwimlaneRepository;
import com.talabat.restaurants.v2.data.swimlane.SwimlaneRepositoryImpl;
import io.reactivex.functions.Consumer;
import library.talabat.com.talabatlib.SwimlaneResponse;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwimlaneRepositoryImpl f62222b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SwimlaneRepository.SwimlaneData f62223c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f62224d;

    public /* synthetic */ a(SwimlaneRepositoryImpl swimlaneRepositoryImpl, SwimlaneRepository.SwimlaneData swimlaneData, String str) {
        this.f62222b = swimlaneRepositoryImpl;
        this.f62223c = swimlaneData;
        this.f62224d = str;
    }

    public final void accept(Object obj) {
        SwimlaneRepositoryImpl.m10733getSwimlanes$lambda1$lambda0(this.f62222b, this.f62223c, this.f62224d, (SwimlaneResponse) obj);
    }
}
