package com.talabat.riderinfo.presentation.flutter.ports;

import android.app.Activity;
import com.talabat.riderinfo.presentation.flutter.dto.RiderChatMethodCallArguments;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/talabat/riderinfo/presentation/flutter/ports/RiderInfoFlutterNavigatorPort;", "", "navigateToRiderChatScreen", "", "activity", "Landroid/app/Activity;", "args", "Lcom/talabat/riderinfo/presentation/flutter/dto/RiderChatMethodCallArguments;", "com_talabat_NewArchi_RiderInfo_RiderInfo"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RiderInfoFlutterNavigatorPort {
    void navigateToRiderChatScreen(@NotNull Activity activity, @NotNull RiderChatMethodCallArguments riderChatMethodCallArguments);
}
