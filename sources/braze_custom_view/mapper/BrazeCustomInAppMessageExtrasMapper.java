package braze_custom_view.mapper;

import braze_custom_view.model.LayoutGravity;
import com.google.android.material.badge.BadgeDrawable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0002J\u001c\u0010\u000b\u001a\u00020\f2\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u001c\u0010\r\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006J\u001c\u0010\u000e\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¨\u0006\u000f"}, d2 = {"Lbraze_custom_view/mapper/BrazeCustomInAppMessageExtrasMapper;", "", "()V", "mapTOLayoutGravity", "", "extras", "", "", "mapToAndroidGravity", "gravityRaw", "Lbraze_custom_view/model/LayoutGravity;", "mapToCustomBehaviour", "", "mapToHeightInDP", "mapToWidthInDP", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BrazeCustomInAppMessageExtrasMapper {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutGravity.values().length];
            iArr[LayoutGravity.TOP.ordinal()] = 1;
            iArr[LayoutGravity.BOTTOM.ordinal()] = 2;
            iArr[LayoutGravity.LEFT.ordinal()] = 3;
            iArr[LayoutGravity.RIGHT.ordinal()] = 4;
            iArr[LayoutGravity.BOTTOM_LEFT.ordinal()] = 5;
            iArr[LayoutGravity.BOTTOM_RIGHT.ordinal()] = 6;
            iArr[LayoutGravity.TOP_LEFT.ordinal()] = 7;
            iArr[LayoutGravity.TOP_RIGHT.ordinal()] = 8;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final int mapToAndroidGravity(LayoutGravity layoutGravity) {
        switch (WhenMappings.$EnumSwitchMapping$0[layoutGravity.ordinal()]) {
            case 1:
                return 65;
            case 2:
                return 81;
            case 3:
                return 8388628;
            case 4:
                return 8388629;
            case 5:
                return BadgeDrawable.BOTTOM_START;
            case 6:
                return BadgeDrawable.BOTTOM_END;
            case 7:
                return BadgeDrawable.TOP_START;
            case 8:
                return BadgeDrawable.TOP_END;
            default:
                return 17;
        }
    }

    public final int mapTOLayoutGravity(@Nullable Map<String, String> map) {
        String str;
        if (map == null || (str = map.get("layoutPosition")) == null) {
            str = "CENTER";
        }
        return mapToAndroidGravity(LayoutGravity.valueOf(str));
    }

    public final boolean mapToCustomBehaviour(@Nullable Map<String, String> map) {
        String str;
        if (map != null) {
            str = map.get("customBehaviourEnabled");
        } else {
            str = null;
        }
        return Intrinsics.areEqual((Object) str, (Object) "true");
    }

    public final int mapToHeightInDP(@Nullable Map<String, String> map) {
        String str;
        if (map == null || (str = map.get("androidHeightInDP")) == null) {
            return 400;
        }
        return Integer.parseInt(str);
    }

    public final int mapToWidthInDP(@Nullable Map<String, String> map) {
        String str;
        if (map == null || (str = map.get("androidWidthInDP")) == null) {
            return 400;
        }
        return Integer.parseInt(str);
    }
}
