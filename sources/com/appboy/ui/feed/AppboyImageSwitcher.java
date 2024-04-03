package com.appboy.ui.feed;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageSwitcher;
import androidx.annotation.VisibleForTesting;
import com.appboy.ui.R;
import com.braze.support.BrazeLogger;

public class AppboyImageSwitcher extends ImageSwitcher {
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) AppboyImageSwitcher.class);
    private Drawable mReadIcon;
    private Drawable mUnReadIcon;

    public AppboyImageSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Drawable drawable;
        try {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.com_appboy_ui_feed_AppboyImageSwitcher);
            for (int i11 = 0; i11 < obtainStyledAttributes.getIndexCount(); i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R.styleable.com_appboy_ui_feed_AppboyImageSwitcher_appboyFeedCustomReadIcon) {
                    Drawable drawable2 = obtainStyledAttributes.getDrawable(index);
                    if (drawable2 != null) {
                        this.mReadIcon = drawable2;
                    }
                } else if (obtainStyledAttributes.getIndex(i11) == R.styleable.com_appboy_ui_feed_AppboyImageSwitcher_appboyFeedCustomUnReadIcon && (drawable = obtainStyledAttributes.getDrawable(index)) != null) {
                    this.mUnReadIcon = drawable;
                }
            }
            obtainStyledAttributes.recycle();
        } catch (Exception e11) {
            BrazeLogger.w(TAG, "Error while checking for custom drawable.", e11);
        }
    }

    public Drawable getReadIcon() {
        return this.mReadIcon;
    }

    public Drawable getUnReadIcon() {
        return this.mUnReadIcon;
    }

    @VisibleForTesting
    public void setReadIcon(Drawable drawable) {
        this.mReadIcon = drawable;
    }

    @VisibleForTesting
    public void setUnReadIcon(Drawable drawable) {
        this.mUnReadIcon = drawable;
    }
}
