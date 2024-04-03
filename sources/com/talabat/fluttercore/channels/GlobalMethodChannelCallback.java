package com.talabat.fluttercore.channels;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/talabat/fluttercore/channels/GlobalMethodChannelCallback;", "", "onBackPressedFromFlutter", "", "withArgs", "onSetBottomNavigation", "boolean", "", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GlobalMethodChannelCallback {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onBackPressedFromFlutter(@NotNull GlobalMethodChannelCallback globalMethodChannelCallback, @NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "withArgs");
        }

        public static void onSetBottomNavigation(@NotNull GlobalMethodChannelCallback globalMethodChannelCallback, boolean z11) {
        }
    }

    void onBackPressedFromFlutter();

    void onBackPressedFromFlutter(@NotNull Object obj);

    void onSetBottomNavigation(boolean z11);
}
