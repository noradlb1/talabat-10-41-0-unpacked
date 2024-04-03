package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0017J\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0019ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001fJ\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020!ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010%\u001a\u00020&J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020*J\u001b\u0010\u0005\u001a\u00020\u00062\u0006\u0010+\u001a\u00020,ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010\nJ\u0006\u0010.\u001a\u00020*J\u0006\u0010/\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00060"}, d2 = {"Landroidx/compose/ui/platform/EncodeHelper;", "", "()V", "parcel", "Landroid/os/Parcel;", "encode", "", "color", "Landroidx/compose/ui/graphics/Color;", "encode-8_81llA", "(J)V", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "encode-nzbMABs", "(I)V", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "encode-6p3vJLY", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "encode-4Dl_Bck", "(F)V", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "textUnit", "Landroidx/compose/ui/unit/TextUnit;", "encode--R2X_6o", "byte", "", "float", "", "int", "", "string", "", "uLong", "Lkotlin/ULong;", "encode-VKZWuLQ", "encodedString", "reset", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class EncodeHelper {
    @NotNull
    private Parcel parcel;

    public EncodeHelper() {
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        this.parcel = obtain;
    }

    public final void encode(@NotNull SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "spanStyle");
        long r02 = spanStyle.m5001getColor0d7_KjU();
        Color.Companion companion = Color.Companion;
        if (!Color.m2920equalsimpl0(r02, companion.m2955getUnspecified0d7_KjU())) {
            encode((byte) 1);
            m4838encode8_81llA(spanStyle.m5001getColor0d7_KjU());
        }
        long r03 = spanStyle.m5002getFontSizeXSAIIZE();
        TextUnit.Companion companion2 = TextUnit.Companion;
        if (!TextUnit.m5656equalsimpl0(r03, companion2.m5670getUnspecifiedXSAIIZE())) {
            encode((byte) 2);
            m4835encodeR2X_6o(spanStyle.m5002getFontSizeXSAIIZE());
        }
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight != null) {
            encode((byte) 3);
            encode(fontWeight);
        }
        FontStyle r04 = spanStyle.m5003getFontStyle4Lr2A7w();
        if (r04 != null) {
            int r05 = r04.m5127unboximpl();
            encode((byte) 4);
            m4840encodenzbMABs(r05);
        }
        FontSynthesis r06 = spanStyle.m5004getFontSynthesisZQGJjVo();
        if (r06 != null) {
            int r07 = r06.m5138unboximpl();
            encode((byte) 5);
            m4837encode6p3vJLY(r07);
        }
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings != null) {
            encode((byte) 6);
            encode(fontFeatureSettings);
        }
        if (!TextUnit.m5656equalsimpl0(spanStyle.m5005getLetterSpacingXSAIIZE(), companion2.m5670getUnspecifiedXSAIIZE())) {
            encode((byte) 7);
            m4835encodeR2X_6o(spanStyle.m5005getLetterSpacingXSAIIZE());
        }
        BaselineShift r08 = spanStyle.m5000getBaselineShift5SSeXJ0();
        if (r08 != null) {
            float r09 = r08.m5280unboximpl();
            encode((byte) 8);
            m4836encode4Dl_Bck(r09);
        }
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform != null) {
            encode((byte) 9);
            encode(textGeometricTransform);
        }
        if (!Color.m2920equalsimpl0(spanStyle.m4999getBackground0d7_KjU(), companion.m2955getUnspecified0d7_KjU())) {
            encode((byte) 10);
            m4838encode8_81llA(spanStyle.m4999getBackground0d7_KjU());
        }
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration != null) {
            encode((byte) 11);
            encode(textDecoration);
        }
        Shadow shadow = spanStyle.getShadow();
        if (shadow != null) {
            encode((byte) 12);
            encode(shadow);
        }
    }

    /* renamed from: encode--R2X_6o  reason: not valid java name */
    public final void m4835encodeR2X_6o(long j11) {
        long r02 = TextUnit.m5658getTypeUIouoOA(j11);
        TextUnitType.Companion companion = TextUnitType.Companion;
        byte b11 = 0;
        if (!TextUnitType.m5687equalsimpl0(r02, companion.m5693getUnspecifiedUIouoOA())) {
            if (TextUnitType.m5687equalsimpl0(r02, companion.m5692getSpUIouoOA())) {
                b11 = 1;
            } else if (TextUnitType.m5687equalsimpl0(r02, companion.m5691getEmUIouoOA())) {
                b11 = 2;
            }
        }
        encode(b11);
        if (!TextUnitType.m5687equalsimpl0(TextUnit.m5658getTypeUIouoOA(j11), companion.m5693getUnspecifiedUIouoOA())) {
            encode(TextUnit.m5659getValueimpl(j11));
        }
    }

    /* renamed from: encode-4Dl_Bck  reason: not valid java name */
    public final void m4836encode4Dl_Bck(float f11) {
        encode(f11);
    }

    /* renamed from: encode-6p3vJLY  reason: not valid java name */
    public final void m4837encode6p3vJLY(int i11) {
        FontSynthesis.Companion companion = FontSynthesis.Companion;
        byte b11 = 0;
        if (!FontSynthesis.m5133equalsimpl0(i11, companion.m5140getNoneGVVA2EU())) {
            if (FontSynthesis.m5133equalsimpl0(i11, companion.m5139getAllGVVA2EU())) {
                b11 = 1;
            } else if (FontSynthesis.m5133equalsimpl0(i11, companion.m5142getWeightGVVA2EU())) {
                b11 = 2;
            } else if (FontSynthesis.m5133equalsimpl0(i11, companion.m5141getStyleGVVA2EU())) {
                b11 = 3;
            }
        }
        encode(b11);
    }

    /* renamed from: encode-8_81llA  reason: not valid java name */
    public final void m4838encode8_81llA(long j11) {
        m4839encodeVKZWuLQ(j11);
    }

    /* renamed from: encode-VKZWuLQ  reason: not valid java name */
    public final void m4839encodeVKZWuLQ(long j11) {
        this.parcel.writeLong(j11);
    }

    /* renamed from: encode-nzbMABs  reason: not valid java name */
    public final void m4840encodenzbMABs(int i11) {
        FontStyle.Companion companion = FontStyle.Companion;
        byte b11 = 0;
        if (!FontStyle.m5124equalsimpl0(i11, companion.m5129getNormal_LCdwA()) && FontStyle.m5124equalsimpl0(i11, companion.m5128getItalic_LCdwA())) {
            b11 = 1;
        }
        encode(b11);
    }

    @NotNull
    public final String encodedString() {
        String encodeToString = Base64.encodeToString(this.parcel.marshall(), 0);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(bytes, Base64.DEFAULT)");
        return encodeToString;
    }

    public final void reset() {
        this.parcel.recycle();
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        this.parcel = obtain;
    }

    public final void encode(@NotNull FontWeight fontWeight) {
        Intrinsics.checkNotNullParameter(fontWeight, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        encode(fontWeight.getWeight());
    }

    public final void encode(@NotNull TextGeometricTransform textGeometricTransform) {
        Intrinsics.checkNotNullParameter(textGeometricTransform, "textGeometricTransform");
        encode(textGeometricTransform.getScaleX());
        encode(textGeometricTransform.getSkewX());
    }

    public final void encode(@NotNull TextDecoration textDecoration) {
        Intrinsics.checkNotNullParameter(textDecoration, TtmlNode.ATTR_TTS_TEXT_DECORATION);
        encode(textDecoration.getMask());
    }

    public final void encode(@NotNull Shadow shadow) {
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        m4838encode8_81llA(shadow.m3230getColor0d7_KjU());
        encode(Offset.m2676getXimpl(shadow.m3231getOffsetF1C5BW0()));
        encode(Offset.m2677getYimpl(shadow.m3231getOffsetF1C5BW0()));
        encode(shadow.getBlurRadius());
    }

    public final void encode(byte b11) {
        this.parcel.writeByte(b11);
    }

    public final void encode(int i11) {
        this.parcel.writeInt(i11);
    }

    public final void encode(float f11) {
        this.parcel.writeFloat(f11);
    }

    public final void encode(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        this.parcel.writeString(str);
    }
}
