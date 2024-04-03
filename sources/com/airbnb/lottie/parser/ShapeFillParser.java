package com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import com.apptimize.c;
import java.io.IOException;
import java.util.Collections;

class ShapeFillParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("nm", c.f41585a, "o", "fillEnabled", "r", "hd");

    private ShapeFillParser() {
    }

    public static ShapeFill a(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        Path.FillType fillType;
        AnimatableIntegerValue animatableIntegerValue = null;
        String str = null;
        AnimatableColorValue animatableColorValue = null;
        boolean z11 = false;
        boolean z12 = false;
        int i11 = 1;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                animatableColorValue = AnimatableValueParser.a(jsonReader, lottieComposition);
            } else if (selectName == 2) {
                animatableIntegerValue = AnimatableValueParser.d(jsonReader, lottieComposition);
            } else if (selectName == 3) {
                z11 = jsonReader.nextBoolean();
            } else if (selectName == 4) {
                i11 = jsonReader.nextInt();
            } else if (selectName != 5) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                z12 = jsonReader.nextBoolean();
            }
        }
        if (animatableIntegerValue == null) {
            animatableIntegerValue = new AnimatableIntegerValue(Collections.singletonList(new Keyframe(100)));
        }
        AnimatableIntegerValue animatableIntegerValue2 = animatableIntegerValue;
        if (i11 == 1) {
            fillType = Path.FillType.WINDING;
        } else {
            fillType = Path.FillType.EVEN_ODD;
        }
        return new ShapeFill(str, z11, fillType, animatableColorValue, animatableIntegerValue2, z12);
    }
}
