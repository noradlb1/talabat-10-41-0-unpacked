package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ShapeData {
    private boolean closed;
    private final List<CubicCurveData> curves;
    private PointF initialPoint;

    public ShapeData(PointF pointF, boolean z11, List<CubicCurveData> list) {
        this.initialPoint = pointF;
        this.closed = z11;
        this.curves = new ArrayList(list);
    }

    public List<CubicCurveData> getCurves() {
        return this.curves;
    }

    public PointF getInitialPoint() {
        return this.initialPoint;
    }

    public void interpolateBetween(ShapeData shapeData, ShapeData shapeData2, @FloatRange(from = 0.0d, to = 1.0d) float f11) {
        boolean z11;
        if (this.initialPoint == null) {
            this.initialPoint = new PointF();
        }
        if (shapeData.isClosed() || shapeData2.isClosed()) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.closed = z11;
        if (shapeData.getCurves().size() != shapeData2.getCurves().size()) {
            Logger.warning("Curves must have the same number of control points. Shape 1: " + shapeData.getCurves().size() + "\tShape 2: " + shapeData2.getCurves().size());
        }
        int min = Math.min(shapeData.getCurves().size(), shapeData2.getCurves().size());
        if (this.curves.size() < min) {
            for (int size = this.curves.size(); size < min; size++) {
                this.curves.add(new CubicCurveData());
            }
        } else if (this.curves.size() > min) {
            for (int size2 = this.curves.size() - 1; size2 >= min; size2--) {
                List<CubicCurveData> list = this.curves;
                list.remove(list.size() - 1);
            }
        }
        PointF initialPoint2 = shapeData.getInitialPoint();
        PointF initialPoint3 = shapeData2.getInitialPoint();
        setInitialPoint(MiscUtils.lerp(initialPoint2.x, initialPoint3.x, f11), MiscUtils.lerp(initialPoint2.y, initialPoint3.y, f11));
        for (int size3 = this.curves.size() - 1; size3 >= 0; size3--) {
            CubicCurveData cubicCurveData = shapeData.getCurves().get(size3);
            CubicCurveData cubicCurveData2 = shapeData2.getCurves().get(size3);
            PointF controlPoint1 = cubicCurveData.getControlPoint1();
            PointF controlPoint2 = cubicCurveData.getControlPoint2();
            PointF vertex = cubicCurveData.getVertex();
            PointF controlPoint12 = cubicCurveData2.getControlPoint1();
            PointF controlPoint22 = cubicCurveData2.getControlPoint2();
            PointF vertex2 = cubicCurveData2.getVertex();
            this.curves.get(size3).setControlPoint1(MiscUtils.lerp(controlPoint1.x, controlPoint12.x, f11), MiscUtils.lerp(controlPoint1.y, controlPoint12.y, f11));
            this.curves.get(size3).setControlPoint2(MiscUtils.lerp(controlPoint2.x, controlPoint22.x, f11), MiscUtils.lerp(controlPoint2.y, controlPoint22.y, f11));
            this.curves.get(size3).setVertex(MiscUtils.lerp(vertex.x, vertex2.x, f11), MiscUtils.lerp(vertex.y, vertex2.y, f11));
        }
    }

    public boolean isClosed() {
        return this.closed;
    }

    public void setClosed(boolean z11) {
        this.closed = z11;
    }

    public void setInitialPoint(float f11, float f12) {
        if (this.initialPoint == null) {
            this.initialPoint = new PointF();
        }
        this.initialPoint.set(f11, f12);
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.curves.size() + "closed=" + this.closed + AbstractJsonLexerKt.END_OBJ;
    }

    public ShapeData() {
        this.curves = new ArrayList();
    }
}
