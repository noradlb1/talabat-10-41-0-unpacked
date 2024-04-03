package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;
import java.io.IOException;

public class AnimatableTransformParser {
    private static final JsonReader.Options ANIMATABLE_NAMES = JsonReader.Options.of("k");
    private static final JsonReader.Options NAMES = JsonReader.Options.of("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");

    private AnimatableTransformParser() {
    }

    private static boolean isAnchorPointIdentity(AnimatablePathValue animatablePathValue) {
        return animatablePathValue == null || (animatablePathValue.isStatic() && ((PointF) animatablePathValue.getKeyframes().get(0).startValue).equals(0.0f, 0.0f));
    }

    private static boolean isPositionIdentity(AnimatableValue<PointF, PointF> animatableValue) {
        if (animatableValue == null || (!(animatableValue instanceof AnimatableSplitDimensionPathValue) && animatableValue.isStatic() && ((PointF) animatableValue.getKeyframes().get(0).startValue).equals(0.0f, 0.0f))) {
            return true;
        }
        return false;
    }

    private static boolean isRotationIdentity(AnimatableFloatValue animatableFloatValue) {
        return animatableFloatValue == null || (animatableFloatValue.isStatic() && ((Float) ((Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue).floatValue() == 0.0f);
    }

    private static boolean isScaleIdentity(AnimatableScaleValue animatableScaleValue) {
        return animatableScaleValue == null || (animatableScaleValue.isStatic() && ((ScaleXY) ((Keyframe) animatableScaleValue.getKeyframes().get(0)).startValue).equals(1.0f, 1.0f));
    }

    private static boolean isSkewAngleIdentity(AnimatableFloatValue animatableFloatValue) {
        return animatableFloatValue == null || (animatableFloatValue.isStatic() && ((Float) ((Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue).floatValue() == 0.0f);
    }

    private static boolean isSkewIdentity(AnimatableFloatValue animatableFloatValue) {
        return animatableFloatValue == null || (animatableFloatValue.isStatic() && ((Float) ((Keyframe) animatableFloatValue.getKeyframes().get(0)).startValue).floatValue() == 0.0f);
    }

    public static AnimatableTransform parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        boolean z11;
        AnimatablePathValue animatablePathValue;
        AnimatableValue<PointF, PointF> animatableValue;
        AnimatableFloatValue animatableFloatValue;
        AnimatableFloatValue animatableFloatValue2;
        AnimatableFloatValue animatableFloatValue3;
        boolean z12;
        JsonReader jsonReader2 = jsonReader;
        LottieComposition lottieComposition2 = lottieComposition;
        boolean z13 = false;
        if (jsonReader.peek() == JsonReader.Token.BEGIN_OBJECT) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            jsonReader.beginObject();
        }
        AnimatableFloatValue animatableFloatValue4 = null;
        AnimatablePathValue animatablePathValue2 = null;
        AnimatableValue<PointF, PointF> animatableValue2 = null;
        AnimatableScaleValue animatableScaleValue = null;
        AnimatableFloatValue animatableFloatValue5 = null;
        AnimatableFloatValue animatableFloatValue6 = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        AnimatableFloatValue animatableFloatValue7 = null;
        AnimatableFloatValue animatableFloatValue8 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(NAMES)) {
                case 0:
                    boolean z14 = z13;
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        if (jsonReader2.selectName(ANIMATABLE_NAMES) != 0) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                        } else {
                            animatablePathValue2 = AnimatablePathValueParser.parse(jsonReader, lottieComposition);
                        }
                    }
                    jsonReader.endObject();
                    z13 = z14;
                    continue;
                case 1:
                    boolean z15 = z13;
                    animatableValue2 = AnimatablePathValueParser.a(jsonReader, lottieComposition);
                    continue;
                case 2:
                    boolean z16 = z13;
                    animatableScaleValue = AnimatableValueParser.f(jsonReader, lottieComposition);
                    continue;
                case 3:
                    lottieComposition2.addWarning("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    animatableIntegerValue = AnimatableValueParser.d(jsonReader, lottieComposition);
                    continue;
                case 6:
                    animatableFloatValue7 = AnimatableValueParser.parseFloat(jsonReader2, lottieComposition2, z13);
                    continue;
                case 7:
                    animatableFloatValue8 = AnimatableValueParser.parseFloat(jsonReader2, lottieComposition2, z13);
                    continue;
                case 8:
                    animatableFloatValue5 = AnimatableValueParser.parseFloat(jsonReader2, lottieComposition2, z13);
                    continue;
                case 9:
                    animatableFloatValue6 = AnimatableValueParser.parseFloat(jsonReader2, lottieComposition2, z13);
                    continue;
                default:
                    boolean z17 = z13;
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    continue;
            }
            AnimatableFloatValue parseFloat = AnimatableValueParser.parseFloat(jsonReader2, lottieComposition2, z13);
            if (parseFloat.getKeyframes().isEmpty()) {
                Keyframe keyframe = r1;
                Keyframe keyframe2 = new Keyframe(lottieComposition, Float.valueOf(0.0f), Float.valueOf(0.0f), (Interpolator) null, 0.0f, Float.valueOf(lottieComposition.getEndFrame()));
                parseFloat.getKeyframes().add(keyframe);
            } else if (((Keyframe) parseFloat.getKeyframes().get(0)).startValue == null) {
                z12 = false;
                parseFloat.getKeyframes().set(0, new Keyframe(lottieComposition, Float.valueOf(0.0f), Float.valueOf(0.0f), (Interpolator) null, 0.0f, Float.valueOf(lottieComposition.getEndFrame())));
                z13 = z12;
                animatableFloatValue4 = parseFloat;
            }
            z12 = false;
            z13 = z12;
            animatableFloatValue4 = parseFloat;
        }
        if (z11) {
            jsonReader.endObject();
        }
        if (isAnchorPointIdentity(animatablePathValue2)) {
            animatablePathValue = null;
        } else {
            animatablePathValue = animatablePathValue2;
        }
        if (isPositionIdentity(animatableValue2)) {
            animatableValue = null;
        } else {
            animatableValue = animatableValue2;
        }
        if (isRotationIdentity(animatableFloatValue4)) {
            animatableFloatValue = null;
        } else {
            animatableFloatValue = animatableFloatValue4;
        }
        if (isScaleIdentity(animatableScaleValue)) {
            animatableScaleValue = null;
        }
        if (isSkewIdentity(animatableFloatValue5)) {
            animatableFloatValue2 = null;
        } else {
            animatableFloatValue2 = animatableFloatValue5;
        }
        if (isSkewAngleIdentity(animatableFloatValue6)) {
            animatableFloatValue3 = null;
        } else {
            animatableFloatValue3 = animatableFloatValue6;
        }
        return new AnimatableTransform(animatablePathValue, animatableValue, animatableScaleValue, animatableFloatValue, animatableIntegerValue, animatableFloatValue7, animatableFloatValue8, animatableFloatValue2, animatableFloatValue3);
    }
}
