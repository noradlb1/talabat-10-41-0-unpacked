package com.rd;

import androidx.annotation.Nullable;
import com.rd.animation.AnimationManager;
import com.rd.animation.controller.ValueController;
import com.rd.animation.data.Value;
import com.rd.draw.DrawManager;
import com.rd.draw.data.Indicator;

public class IndicatorManager implements ValueController.UpdateListener {
    private AnimationManager animationManager;
    private DrawManager drawManager;
    private Listener listener;

    public interface Listener {
        void onIndicatorUpdated();
    }

    public IndicatorManager(@Nullable Listener listener2) {
        this.listener = listener2;
        DrawManager drawManager2 = new DrawManager();
        this.drawManager = drawManager2;
        this.animationManager = new AnimationManager(drawManager2.indicator(), this);
    }

    public AnimationManager animate() {
        return this.animationManager;
    }

    public DrawManager drawer() {
        return this.drawManager;
    }

    public Indicator indicator() {
        return this.drawManager.indicator();
    }

    public void onValueUpdated(@Nullable Value value) {
        this.drawManager.updateValue(value);
        Listener listener2 = this.listener;
        if (listener2 != null) {
            listener2.onIndicatorUpdated();
        }
    }
}
