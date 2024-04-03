package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;

public class AppCompatSeekBar extends SeekBar {
    private final AppCompatSeekBarHelper mAppCompatSeekBarHelper;

    public AppCompatSeekBar(@NonNull Context context) {
        this(context, (AttributeSet) null);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.mAppCompatSeekBarHelper.e();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.mAppCompatSeekBarHelper.f();
    }

    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mAppCompatSeekBarHelper.d(canvas);
    }

    public AppCompatSeekBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.seekBarStyle);
    }

    public AppCompatSeekBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatSeekBarHelper appCompatSeekBarHelper = new AppCompatSeekBarHelper(this);
        this.mAppCompatSeekBarHelper = appCompatSeekBarHelper;
        appCompatSeekBarHelper.b(attributeSet, i11);
    }
}
