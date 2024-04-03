package io.flutter.plugin.mouse;

import android.annotation.TargetApi;
import android.view.PointerIcon;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.deliveryhero.customerchat.BuildConfig;
import com.huawei.hms.flutter.map.constants.Param;
import io.flutter.embedding.engine.systemchannels.MouseCursorChannel;
import j$.util.Map;
import java.util.HashMap;

@RequiresApi(24)
@TargetApi(24)
public class MouseCursorPlugin {
    @NonNull
    private static HashMap<String, Integer> systemCursorConstants;
    /* access modifiers changed from: private */
    @NonNull
    public final MouseCursorViewDelegate mView;
    @NonNull
    private final MouseCursorChannel mouseCursorChannel;

    public interface MouseCursorViewDelegate {
        @NonNull
        PointerIcon getSystemPointerIcon(int i11);

        void setPointerIcon(@NonNull PointerIcon pointerIcon);
    }

    public MouseCursorPlugin(@NonNull MouseCursorViewDelegate mouseCursorViewDelegate, @NonNull MouseCursorChannel mouseCursorChannel2) {
        this.mView = mouseCursorViewDelegate;
        this.mouseCursorChannel = mouseCursorChannel2;
        mouseCursorChannel2.setMethodHandler(new MouseCursorChannel.MouseCursorMethodHandler() {
            public void activateSystemCursor(@NonNull String str) {
                MouseCursorPlugin.this.mView.setPointerIcon(MouseCursorPlugin.this.resolveSystemCursor(str));
            }
        });
    }

    /* access modifiers changed from: private */
    public PointerIcon resolveSystemCursor(@NonNull String str) {
        if (systemCursorConstants == null) {
            systemCursorConstants = new HashMap<String, Integer>() {
                private static final long serialVersionUID = 1;

                {
                    put("alias", 1010);
                    put("allScroll", 1013);
                    put(BuildConfig.FLAVOR, 1000);
                    put("cell", 1006);
                    put("click", 1002);
                    put("contextMenu", 1001);
                    put("copy", 1011);
                    put("forbidden", 1012);
                    put("grab", 1020);
                    put("grabbing", 1021);
                    put("help", 1003);
                    put("move", 1013);
                    put("none", 0);
                    put("noDrop", 1012);
                    put("precise", 1007);
                    put("text", 1008);
                    put("resizeColumn", 1014);
                    put("resizeDown", 1015);
                    put("resizeUpLeft", 1016);
                    put("resizeDownRight", 1017);
                    put("resizeLeft", 1014);
                    put("resizeLeftRight", 1014);
                    put("resizeRight", 1014);
                    put("resizeRow", 1015);
                    put("resizeUp", 1015);
                    put("resizeUpDown", 1015);
                    put("resizeUpLeft", 1017);
                    put("resizeUpRight", 1016);
                    put("resizeUpLeftDownRight", 1017);
                    put("resizeUpRightDownLeft", 1016);
                    put("verticalText", 1009);
                    put("wait", 1004);
                    put(Param.ZOOM_IN, 1018);
                    put(Param.ZOOM_OUT, 1019);
                }
            };
        }
        return this.mView.getSystemPointerIcon(((Integer) Map.EL.getOrDefault(systemCursorConstants, str, 1000)).intValue());
    }

    public void destroy() {
        this.mouseCursorChannel.setMethodHandler((MouseCursorChannel.MouseCursorMethodHandler) null);
    }
}
