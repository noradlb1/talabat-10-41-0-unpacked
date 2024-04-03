package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class PolystarShapeParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "sy", "pt", "p", "r", "or", "os", "ir", "is", "hd", "d");

    private PolystarShapeParser() {
    }

    public static PolystarShape a(JsonReader jsonReader, LottieComposition lottieComposition, int i11) throws IOException {
        boolean z11;
        JsonReader jsonReader2 = jsonReader;
        LottieComposition lottieComposition2 = lottieComposition;
        if (i11 == 3) {
            z11 = true;
        } else {
            z11 = false;
        }
        boolean z12 = false;
        boolean z13 = z11;
        String str = null;
        PolystarShape.Type type = null;
        AnimatableFloatValue animatableFloatValue = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatableFloatValue animatableFloatValue2 = null;
        AnimatableFloatValue animatableFloatValue3 = null;
        AnimatableFloatValue animatableFloatValue4 = null;
        AnimatableFloatValue animatableFloatValue5 = null;
        AnimatableFloatValue animatableFloatValue6 = null;
        while (jsonReader.hasNext()) {
            switch (jsonReader2.selectName(NAMES)) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    type = PolystarShape.Type.forValue(jsonReader.nextInt());
                    break;
                case 2:
                    animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader2, lottieComposition2, false);
                    break;
                case 3:
                    animatableValue = AnimatablePathValueParser.a(jsonReader, lottieComposition);
                    break;
                case 4:
                    animatableFloatValue2 = AnimatableValueParser.parseFloat(jsonReader2, lottieComposition2, false);
                    break;
                case 5:
                    animatableFloatValue4 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                    break;
                case 6:
                    animatableFloatValue6 = AnimatableValueParser.parseFloat(jsonReader2, lottieComposition2, false);
                    break;
                case 7:
                    animatableFloatValue3 = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
                    break;
                case 8:
                    animatableFloatValue5 = AnimatableValueParser.parseFloat(jsonReader2, lottieComposition2, false);
                    break;
                case 9:
                    z12 = jsonReader.nextBoolean();
                    break;
                case 10:
                    if (jsonReader.nextInt() != 3) {
                        z13 = false;
                        break;
                    } else {
                        z13 = true;
                        break;
                    }
                default:
                    jsonReader.skipName();
                    jsonReader.skipValue();
                    break;
            }
        }
        return new PolystarShape(str, type, animatableFloatValue, animatableValue, animatableFloatValue2, animatableFloatValue3, animatableFloatValue4, animatableFloatValue5, animatableFloatValue6, z12, z13);
    }
}
