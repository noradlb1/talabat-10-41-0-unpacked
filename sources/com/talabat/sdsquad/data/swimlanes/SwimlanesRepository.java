package com.talabat.sdsquad.data.swimlanes;

import com.talabat.sdsquad.data.swimlanes.responses.SwimLane;
import com.talabat.sdsquad.data.swimlanes.responses.SwimlanesResponse;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&J6\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH&¨\u0006\u000f"}, d2 = {"Lcom/talabat/sdsquad/data/swimlanes/SwimlanesRepository;", "", "getSwimlanes", "", "Lcom/talabat/sdsquad/data/swimlanes/responses/SwimLane;", "getSwimlanesResponse", "Lio/reactivex/Flowable;", "Lcom/talabat/sdsquad/data/swimlanes/responses/SwimlanesResponse;", "isForceUpdate", "", "latitude", "", "longitude", "areaId", "countryCode", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SwimlanesRepository {
    @Nullable
    List<SwimLane> getSwimlanes();

    @NotNull
    Flowable<SwimlanesResponse> getSwimlanesResponse(boolean z11, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4);
}
