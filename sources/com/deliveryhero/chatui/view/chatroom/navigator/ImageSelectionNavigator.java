package com.deliveryhero.chatui.view.chatroom.navigator;

import android.content.Context;
import android.net.Uri;
import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/navigator/ImageSelectionNavigator;", "", "getImageResult", "Landroidx/lifecycle/LiveData;", "Lkotlin/Pair;", "", "Landroid/net/Uri;", "openActivity", "", "context", "Landroid/content/Context;", "type", "Lcom/deliveryhero/chatui/view/chatroom/navigator/ImageSelectionType;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ImageSelectionNavigator {
    @NotNull
    LiveData<Pair<Integer, Uri>> getImageResult();

    void openActivity(@NotNull Context context, @NotNull ImageSelectionType imageSelectionType);
}
