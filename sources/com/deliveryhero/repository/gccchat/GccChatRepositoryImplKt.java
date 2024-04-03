package com.deliveryhero.repository.gccchat;

import com.deliveryhero.chatsdk.domain.model.Location;
import com.deliveryhero.contract.model.LocationData;
import com.deliveryhero.contract.model.Source;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"toSDKLocation", "Lcom/deliveryhero/chatsdk/domain/model/Location;", "Lcom/deliveryhero/contract/model/LocationData;", "toSource", "Lcom/deliveryhero/chatsdk/domain/model/Source;", "Lcom/deliveryhero/contract/model/Source;", "customerchat_basicRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GccChatRepositoryImplKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Source.values().length];
            iArr[Source.CURRENT.ordinal()] = 1;
            iArr[Source.SELECTED.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: private */
    public static final Location toSDKLocation(LocationData locationData) {
        com.deliveryhero.chatsdk.domain.model.Source source;
        double lat = locationData.getLat();
        double lon = locationData.getLon();
        String accuracy = locationData.getAccuracy();
        Source source2 = locationData.getSource();
        if (source2 == null || (source = toSource(source2)) == null) {
            source = com.deliveryhero.chatsdk.domain.model.Source.current;
        }
        return new Location(lat, lon, accuracy, source);
    }

    private static final com.deliveryhero.chatsdk.domain.model.Source toSource(Source source) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[source.ordinal()];
        if (i11 == 1) {
            return com.deliveryhero.chatsdk.domain.model.Source.current;
        }
        if (i11 == 2) {
            return com.deliveryhero.chatsdk.domain.model.Source.selected;
        }
        throw new NoWhenBranchMatchedException();
    }
}
