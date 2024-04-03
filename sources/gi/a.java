package gi;

import com.talabat.darkstores.data.mission.control.MissionControlProductRepository;
import com.talabat.darkstores.data.search.model.SearchResultsResponse;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MissionControlProductRepository f56844b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f56845c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f56846d;

    public /* synthetic */ a(MissionControlProductRepository missionControlProductRepository, String str, String str2) {
        this.f56844b = missionControlProductRepository;
        this.f56845c = str;
        this.f56846d = str2;
    }

    public final void accept(Object obj) {
        MissionControlProductRepository.m9723getDeprecatedMissionControlProducts$lambda2$lambda1(this.f56844b, this.f56845c, this.f56846d, (SearchResultsResponse) obj);
    }
}
