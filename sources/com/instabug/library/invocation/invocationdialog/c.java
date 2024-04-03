package com.instabug.library.invocation.invocationdialog;

import androidx.annotation.AnimRes;
import com.instabug.library.core.ui.BaseContract;
import java.util.ArrayList;

public interface c extends BaseContract.View {
    @AnimRes
    int getFadeInAnimation();

    @AnimRes
    int getSlidInLeftAnimation();

    @AnimRes
    int getSlidInRightAnimation();

    @AnimRes
    int getSlidOutLeftAnimation();

    @AnimRes
    int getSlidOutRightAnimation();

    void onInitialScreenShotNotRequired();

    void setContent(String str, boolean z11, ArrayList arrayList);
}
