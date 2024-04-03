package ya;

import com.huawei.hms.flutter.map.utils.Convert;
import com.huawei.hms.maps.model.Tile;
import com.huawei.hms.maps.model.TileProvider;
import java.util.List;

public final /* synthetic */ class b implements TileProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f50806a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ byte[] f50807b;

    public /* synthetic */ b(List list, byte[] bArr) {
        this.f50806a = list;
        this.f50807b = bArr;
    }

    public final Tile getTile(int i11, int i12, int i13) {
        return Convert.lambda$toTileProvider$1(this.f50806a, this.f50807b, i11, i12, i13);
    }
}
