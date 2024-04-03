package library.talabat.gemengine;

import android.content.Context;

public interface GemView {
    Context getGemContext();

    String getGemScreenType();

    void showGemDialog();

    void showInAppReminder(int i11);

    void showTimeOutDialog();

    void showTimerView(boolean z11, String str);

    void stopLoading();
}
