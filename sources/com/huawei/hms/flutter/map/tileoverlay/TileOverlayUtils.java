package com.huawei.hms.flutter.map.tileoverlay;

import android.app.Application;
import com.huawei.hms.flutter.map.constants.Method;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.hms.flutter.map.logger.HMSLogger;
import com.huawei.hms.flutter.map.utils.Convert;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.model.TileOverlay;
import com.huawei.hms.maps.model.TileOverlayOptions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TileOverlayUtils {
    private HuaweiMap huaweiMap;
    private final Map<String, String> ids = new HashMap();
    private final Map<String, TileOverlayController> idsOnMap = new HashMap();
    private final HMSLogger logger;

    public TileOverlayUtils(Application application) {
        this.logger = HMSLogger.getInstance(application);
    }

    private static String getId(HashMap<String, Object> hashMap) {
        return (String) hashMap.get(Param.TILE_OVERLAY_ID);
    }

    private void update(HashMap<String, Object> hashMap) {
        TileOverlayController tileOverlayController;
        if (hashMap != null && (tileOverlayController = this.idsOnMap.get(getId(hashMap))) != null) {
            Convert.processTileOverlayOptions(hashMap, tileOverlayController);
        }
    }

    public void clearTileCache(String str) {
        TileOverlayController tileOverlayController = this.idsOnMap.get(str);
        if (tileOverlayController != null) {
            this.logger.startMethodExecutionTimer(Method.CLEAR_TILE_CACHE);
            tileOverlayController.clearTileCache();
            this.logger.sendSingleEvent(Method.CLEAR_TILE_CACHE);
        }
    }

    public void deleteMulti(List<String> list) {
        TileOverlayController remove;
        if (list != null) {
            for (String next : list) {
                if (!(next == null || (remove = this.idsOnMap.remove(next)) == null)) {
                    this.logger.startMethodExecutionTimer("removeTileOverlay");
                    remove.delete();
                    this.logger.sendSingleEvent("removeTileOverlay");
                    this.ids.remove(remove.getMapTileOverlayId());
                }
            }
        }
    }

    public void insert(HashMap<String, Object> hashMap) {
        if (this.huaweiMap != null && hashMap != null) {
            TileOverlayBuilder tileOverlayBuilder = new TileOverlayBuilder();
            String processTileOverlayOptions = Convert.processTileOverlayOptions(hashMap, tileOverlayBuilder);
            TileOverlayOptions build = tileOverlayBuilder.build();
            this.logger.startMethodExecutionTimer("addTileOverlay");
            TileOverlay addTileOverlay = this.huaweiMap.addTileOverlay(build);
            this.logger.sendSingleEvent("addTileOverlay");
            this.idsOnMap.put(processTileOverlayOptions, new TileOverlayController(addTileOverlay));
            this.ids.put(addTileOverlay.getId(), processTileOverlayOptions);
        }
    }

    public void insertMulti(List<HashMap<String, Object>> list) {
        if (list != null) {
            for (HashMap<String, Object> insert : list) {
                insert(insert);
            }
        }
    }

    public void setMap(HuaweiMap huaweiMap2) {
        this.huaweiMap = huaweiMap2;
    }

    public void updateMulti(List<HashMap<String, Object>> list) {
        if (list != null) {
            for (HashMap<String, Object> update : list) {
                update(update);
            }
        }
    }
}
