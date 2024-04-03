package com.talabat.homemaphelper;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/homemaphelper/OnSwipeMapListener;", "Landroid/view/View$OnTouchListener;", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "gestureDetector", "Landroid/view/GestureDetector;", "onSwipeBottom", "", "onSwipeLeft", "onSwipeRight", "onSwipeTop", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "Companion", "GestureListener", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OnSwipeMapListener implements View.OnTouchListener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int SWIPE_THRESHOLD = 100;
    /* access modifiers changed from: private */
    public static final int SWIPE_VELOCITY_THRESHOLD = 100;
    @NotNull
    private final GestureDetector gestureDetector;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/homemaphelper/OnSwipeMapListener$Companion;", "", "()V", "SWIPE_THRESHOLD", "", "SWIPE_VELOCITY_THRESHOLD", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J(\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/talabat/homemaphelper/OnSwipeMapListener$GestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "(Lcom/talabat/homemaphelper/OnSwipeMapListener;)V", "onDown", "", "e", "Landroid/view/MotionEvent;", "onFling", "e1", "e2", "velocityX", "", "velocityY", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class GestureListener extends GestureDetector.SimpleOnGestureListener {
        public GestureListener() {
        }

        public boolean onDown(@NotNull MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(motionEvent, "e");
            return true;
        }

        public boolean onFling(@NotNull MotionEvent motionEvent, @NotNull MotionEvent motionEvent2, float f11, float f12) {
            Intrinsics.checkNotNullParameter(motionEvent, "e1");
            Intrinsics.checkNotNullParameter(motionEvent2, "e2");
            try {
                float y11 = motionEvent2.getY() - motionEvent.getY();
                float x11 = motionEvent2.getX() - motionEvent.getX();
                if (Math.abs(x11) > Math.abs(y11)) {
                    if (Math.abs(x11) > ((float) OnSwipeMapListener.SWIPE_THRESHOLD) && Math.abs(f11) > ((float) OnSwipeMapListener.SWIPE_VELOCITY_THRESHOLD)) {
                        if (x11 > 0.0f) {
                            OnSwipeMapListener.this.onSwipeRight();
                            return true;
                        }
                        OnSwipeMapListener.this.onSwipeLeft();
                        return true;
                    }
                } else if (Math.abs(y11) > ((float) OnSwipeMapListener.SWIPE_THRESHOLD) && Math.abs(f12) > ((float) OnSwipeMapListener.SWIPE_VELOCITY_THRESHOLD)) {
                    if (y11 > 0.0f) {
                        OnSwipeMapListener.this.onSwipeBottom();
                        return true;
                    }
                    OnSwipeMapListener.this.onSwipeTop();
                    return true;
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            return false;
        }
    }

    public OnSwipeMapListener(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        this.gestureDetector = new GestureDetector(context, new GestureListener());
    }

    public final void onSwipeBottom() {
    }

    public final void onSwipeLeft() {
    }

    public final void onSwipeRight() {
    }

    public final void onSwipeTop() {
    }

    public boolean onTouch(@NotNull View view, @NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(view, "v");
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        return this.gestureDetector.onTouchEvent(motionEvent);
    }
}
