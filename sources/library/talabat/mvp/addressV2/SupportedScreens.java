package library.talabat.mvp.addressV2;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;
import tracking.ScreenNames;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Llibrary/talabat/mvp/addressV2/SupportedScreens;", "", "screenName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getScreenName", "()Ljava/lang/String;", "formType", "ADD_ADDRESS", "EDIT_ADDRESS", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
enum SupportedScreens {
    ADD_ADDRESS(ScreenNames.ADD_ADDRESS),
    EDIT_ADDRESS(ScreenNames.EDIT_ADDRESS);
    
    @NotNull
    private final String screenName;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] iArr = new int[SupportedScreens.values().length];
            iArr[SupportedScreens.ADD_ADDRESS.ordinal()] = 1;
            iArr[SupportedScreens.EDIT_ADDRESS.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private SupportedScreens(String str) {
        this.screenName = str;
    }

    @NotNull
    public final String formType() {
        int i11 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i11 == 1) {
            return "New Address";
        }
        if (i11 == 2) {
            return "Existing Address";
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final String getScreenName() {
        return this.screenName;
    }
}
