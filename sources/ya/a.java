package ya;

import com.huawei.hms.flutter.map.utils.Convert;
import com.huawei.hms.maps.model.Tile;
import com.huawei.hms.maps.model.TileProvider;
import java.util.HashMap;

public final /* synthetic */ class a implements TileProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HashMap f50805a;

    public /* synthetic */ a(HashMap hashMap) {
        this.f50805a = hashMap;
    }

    public final Tile getTile(int i11, int i12, int i13) {
        return Convert.lambda$toTileProvider$0(this.f50805a, i11, i12, i13);
    }
}
