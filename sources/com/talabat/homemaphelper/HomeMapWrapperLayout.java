package com.talabat.homemaphelper;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.talabat.HomeScreenMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/homemaphelper/HomeMapWrapperLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "SCROLL_TIME", "", "lastTouched", "updateMapAfterUserInterection", "Lcom/talabat/homemaphelper/HomeMapWrapperLayout$UpdateMapAfterUserInterection;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "UpdateMapAfterUserInterection", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HomeMapWrapperLayout extends FrameLayout {
    private final long SCROLL_TIME;
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private long lastTouched;
    @Nullable
    private UpdateMapAfterUserInterection updateMapAfterUserInterection;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/talabat/homemaphelper/HomeMapWrapperLayout$UpdateMapAfterUserInterection;", "", "dragFinished", "", "isDraging", "", "mapDraging", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface UpdateMapAfterUserInterection {
        void dragFinished(boolean z11);

        void mapDraging(boolean z11);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeMapWrapperLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.SCROLL_TIME = 200;
        try {
            this.updateMapAfterUserInterection = (HomeScreenMap) context;
        } catch (ClassCastException unused) {
            throw new ClassCastException(context + " must implement UpdateMapAfterUserInterection");
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public boolean dispatchTouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "ev");
        int action = motionEvent.getAction();
        if (action == 0) {
            UpdateMapAfterUserInterection updateMapAfterUserInterection2 = this.updateMapAfterUserInterection;
            if (updateMapAfterUserInterection2 != null) {
                updateMapAfterUserInterection2.mapDraging(true);
            }
            this.lastTouched = SystemClock.uptimeMillis();
        } else if (action == 1) {
            SystemClock.uptimeMillis();
            UpdateMapAfterUserInterection updateMapAfterUserInterection3 = this.updateMapAfterUserInterection;
            if (updateMapAfterUserInterection3 != null) {
                updateMapAfterUserInterection3.dragFinished(true);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
