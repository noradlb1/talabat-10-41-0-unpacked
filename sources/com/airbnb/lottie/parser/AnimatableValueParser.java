package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableScaleValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.animatable.AnimatableTextFrame;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.ScaleXY;
import java.io.IOException;
import java.util.List;

public class AnimatableValueParser {
    private AnimatableValueParser() {
    }

    public static AnimatableColorValue a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableColorValue(parse(jsonReader, lottieComposition, ColorParser.INSTANCE));
    }

    public static AnimatableTextFrame b(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableTextFrame(parse(jsonReader, lottieComposition, DocumentDataParser.INSTANCE));
    }

    public static AnimatableGradientColorValue c(JsonReader jsonReader, LottieComposition lottieComposition, int i11) throws IOException {
        return new AnimatableGradientColorValue(parse(jsonReader, lottieComposition, new GradientColorParser(i11)));
    }

    public static AnimatableIntegerValue d(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableIntegerValue(parse(jsonReader, lottieComposition, IntegerParser.INSTANCE));
    }

    public static AnimatablePointValue e(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatablePointValue(KeyframesParser.a(jsonReader, lottieComposition, Utils.dpScale(), PointFParser.INSTANCE, true));
    }

    public static AnimatableScaleValue f(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableScaleValue((List<Keyframe<ScaleXY>>) parse(jsonReader, lottieComposition, ScaleXYParser.INSTANCE));
    }

    public static AnimatableShapeValue g(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return new AnimatableShapeValue(parse(jsonReader, Utils.dpScale(), lottieComposition, ShapeDataParser.INSTANCE));
    }

    private static <T> List<Keyframe<T>> parse(JsonReader jsonReader, LottieComposition lottieComposition, ValueParser<T> valueParser) throws IOException {
        return KeyframesParser.a(jsonReader, lottieComposition, 1.0f, valueParser, false);
    }

    public static AnimatableFloatValue parseFloat(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        return parseFloat(jsonReader, lottieComposition, true);
    }

    private static <T> List<Keyframe<T>> parse(JsonReader jsonReader, float f11, LottieComposition lottieComposition, ValueParser<T> valueParser) throws IOException {
        return KeyframesParser.a(jsonReader, lottieComposition, f11, valueParser, false);
    }

    public static AnimatableFloatValue parseFloat(JsonReader jsonReader, LottieComposition lottieComposition, boolean z11) throws IOException {
        return new AnimatableFloatValue(parse(jsonReader, z11 ? Utils.dpScale() : 1.0f, lottieComposition, FloatParser.INSTANCE));
    }
}
