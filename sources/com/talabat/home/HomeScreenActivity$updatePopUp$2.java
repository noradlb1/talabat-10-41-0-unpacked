package com.talabat.home;

import android.content.DialogInterface;
import com.talabat.helpers.GlobalConstants;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/talabat/home/HomeScreenActivity$updatePopUp$2", "Landroid/content/DialogInterface$OnClickListener;", "onClick", "", "dialog", "Landroid/content/DialogInterface;", "which", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenActivity$updatePopUp$2 implements DialogInterface.OnClickListener {
    public void onClick(@Nullable DialogInterface dialogInterface, int i11) {
        GlobalConstants.NormalUpdate.IS_NORMAL_UPDATE = false;
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }
}
