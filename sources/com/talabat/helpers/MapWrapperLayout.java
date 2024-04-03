package com.talabat.helpers;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.talabat.MapsActivity;

public class MapWrapperLayout extends FrameLayout {
    private UpdateMapAfterUserInterection updateMapAfterUserInterection;

    public interface UpdateMapAfterUserInterection {
        void onUpdateMapAfterUserInterection(boolean z11);
    }

    public MapWrapperLayout(Context context) {
        super(context);
        try {
            this.updateMapAfterUserInterection = (MapsActivity) context;
        } catch (ClassCastException unused) {
            throw new ClassCastException(context.toString() + " must implement UpdateMapAfterUserInterection");
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.updateMapAfterUserInterection.onUpdateMapAfterUserInterection(true);
        } else if (action == 1) {
            SystemClock.uptimeMillis();
            this.updateMapAfterUserInterection.onUpdateMapAfterUserInterection(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
