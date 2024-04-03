package com.rd.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.rd.animation.data.Value;
import com.rd.draw.controller.AttributeController;
import com.rd.draw.controller.DrawController;
import com.rd.draw.controller.MeasureController;
import com.rd.draw.data.Indicator;

public class DrawManager {
    private AttributeController attributeController = new AttributeController(this.indicator);
    private DrawController drawController;
    private Indicator indicator;
    private MeasureController measureController = new MeasureController();

    public DrawManager() {
        Indicator indicator2 = new Indicator();
        this.indicator = indicator2;
        this.drawController = new DrawController(indicator2);
    }

    public void draw(@NonNull Canvas canvas) {
        this.drawController.draw(canvas);
    }

    @NonNull
    public Indicator indicator() {
        if (this.indicator == null) {
            this.indicator = new Indicator();
        }
        return this.indicator;
    }

    public void initAttributes(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this.attributeController.init(context, attributeSet);
    }

    public Pair<Integer, Integer> measureViewSize(int i11, int i12) {
        return this.measureController.measureViewSize(this.indicator, i11, i12);
    }

    public void setClickListener(@Nullable DrawController.ClickListener clickListener) {
        this.drawController.setClickListener(clickListener);
    }

    public void touch(@Nullable MotionEvent motionEvent) {
        this.drawController.touch(motionEvent);
    }

    public void updateValue(@Nullable Value value) {
        this.drawController.updateValue(value);
    }
}
