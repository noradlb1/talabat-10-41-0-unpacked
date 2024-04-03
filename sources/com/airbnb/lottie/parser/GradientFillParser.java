package com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.io.IOException;
import java.util.Collections;

class GradientFillParser {
    private static final JsonReader.Options GRADIENT_NAMES = JsonReader.Options.of("p", "k");
    private static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "g", "o", "t", "s", "e", "r", "hd");

    private GradientFillParser() {
    }

    public static GradientFill a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        AnimatableIntegerValue animatableIntegerValue;
        GradientType gradientType;
        Path.FillType fillType;
        AnimatableIntegerValue animatableIntegerValue2 = null;
        Path.FillType fillType2 = Path.FillType.WINDING;
        String str = null;
        GradientType gradientType2 = null;
        AnimatableGradientColorValue animatableGradientColorValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatablePointValue animatablePointValue2 = null;
        boolean z11 = false;
        while (jsonReader.hasNext()) {
            switch (jsonReader.selectName(NAMES)) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    jsonReader.beginObject();
                    int i11 = -1;
                    while (jsonReader.hasNext()) {
                        int selectName = jsonReader.selectName(GRADIENT_NAMES);
                        if (selectName == 0) {
                            i11 = jsonReader.nextInt();
                        } else if (selectName != 1) {
                            jsonReader.skipName();
                            jsonReader.skipValue();
                        } else {
                            animatableGradientColorValue = AnimatableValueParser.c(jsonReader, lottieComposition, i11);
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 2:
                    animatableIntegerValue2 = AnimatableValueParser.d(jsonReader, lottieComposition);
                    break;
                case 3:
                    if (jsonReader.nextInt() == 1) {
                        gradientType = GradientType.LINEAR;
                    } else {
                        gradientType = GradientType.RADIAL;
                    }
                    gradientType2 = gradientType;
                    break;
                case 4:
                    animatablePointValue = AnimatableValueParser.e(jsonReader, lottieComposition);
                    break;
                case 5:
                    animatablePointValue2 = AnimatableValueParser.e(jsonReader, lottieComposition);
                    break;
                case 6:
                    if (jsonReader.nextInt() == 1) {
                        fillType = Path.FillType.WINDING;
                    } else {
                        fillType = Path.FillType.EVEN_ODD;
                    }
                    fillType2 = fillType;
                    break;
                case 7:
                    z11 = jsonReader.nextBoolean();
                    break;
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
            }
        }
        if (animatableIntegerValue2 == null) {
            animatableIntegerValue = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100)));
        } else {
            animatableIntegerValue = animatableIntegerValue2;
        }
        return new GradientFill(str, gradientType2, fillType2, animatableGradientColorValue, animatableIntegerValue, animatablePointValue, animatablePointValue2, (AnimatableFloatValue) null, (AnimatableFloatValue) null, z11);
    }
}
