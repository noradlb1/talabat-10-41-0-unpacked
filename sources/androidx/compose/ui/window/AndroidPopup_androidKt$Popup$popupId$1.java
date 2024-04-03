package androidx.compose.ui.window;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidPopup_androidKt$Popup$popupId$1 extends Lambda implements Function0<UUID> {
    public static final AndroidPopup_androidKt$Popup$popupId$1 INSTANCE = new AndroidPopup_androidKt$Popup$popupId$1();

    public AndroidPopup_androidKt$Popup$popupId$1() {
        super(0);
    }

    public final UUID invoke() {
        return UUID.randomUUID();
    }
}
