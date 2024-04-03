package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010\u0015\u001a\u00020\u0016ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u001aø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u001b\u0010\u0018J\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\bH\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\u0006\u0010!\u001a\u00020\"J\n\u0010#\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020'H\u0002J\u0016\u0010(\u001a\u00020)ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b*\u0010\u0012J\u0018\u0010+\u001a\u00020,H\u0002ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b-\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006."}, d2 = {"Landroidx/compose/ui/platform/DecodeHelper;", "", "string", "", "(Ljava/lang/String;)V", "parcel", "Landroid/os/Parcel;", "dataAvailable", "", "decodeBaselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "decodeBaselineShift-y9eOQZs", "()F", "decodeByte", "", "decodeColor", "Landroidx/compose/ui/graphics/Color;", "decodeColor-0d7_KjU", "()J", "decodeFloat", "", "decodeFontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "decodeFontStyle-_-LCdwA", "()I", "decodeFontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "decodeFontSynthesis-GVVA2EU", "decodeFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "decodeInt", "decodeShadow", "Landroidx/compose/ui/graphics/Shadow;", "decodeSpanStyle", "Landroidx/compose/ui/text/SpanStyle;", "decodeString", "decodeTextDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "decodeTextGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "decodeTextUnit", "Landroidx/compose/ui/unit/TextUnit;", "decodeTextUnit-XSAIIZE", "decodeULong", "Lkotlin/ULong;", "decodeULong-s-VKNKU", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DecodeHelper {
    @NotNull
    private final Parcel parcel;

    public DecodeHelper(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, TypedValues.Custom.S_STRING);
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        this.parcel = obtain;
        byte[] decode = Base64.decode(str, 0);
        obtain.unmarshall(decode, 0, decode.length);
        obtain.setDataPosition(0);
    }

    private final int dataAvailable() {
        return this.parcel.dataAvail();
    }

    /* renamed from: decodeBaselineShift-y9eOQZs  reason: not valid java name */
    private final float m4829decodeBaselineShifty9eOQZs() {
        return BaselineShift.m5275constructorimpl(decodeFloat());
    }

    private final byte decodeByte() {
        return this.parcel.readByte();
    }

    private final float decodeFloat() {
        return this.parcel.readFloat();
    }

    private final int decodeInt() {
        return this.parcel.readInt();
    }

    private final Shadow decodeShadow() {
        return new Shadow(m4831decodeColor0d7_KjU(), OffsetKt.Offset(decodeFloat(), decodeFloat()), decodeFloat(), (DefaultConstructorMarker) null);
    }

    private final String decodeString() {
        return this.parcel.readString();
    }

    private final TextDecoration decodeTextDecoration() {
        boolean z11;
        boolean z12;
        int decodeInt = decodeInt();
        TextDecoration.Companion companion = TextDecoration.Companion;
        if ((companion.getLineThrough().getMask() & decodeInt) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if ((decodeInt & companion.getUnderline().getMask()) != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 && z12) {
            return companion.combine(CollectionsKt__CollectionsKt.listOf(companion.getLineThrough(), companion.getUnderline()));
        } else if (z11) {
            return companion.getLineThrough();
        } else {
            if (z12) {
                return companion.getUnderline();
            }
            return companion.getNone();
        }
    }

    private final TextGeometricTransform decodeTextGeometricTransform() {
        return new TextGeometricTransform(decodeFloat(), decodeFloat());
    }

    /* renamed from: decodeULong-s-VKNKU  reason: not valid java name */
    private final long m4830decodeULongsVKNKU() {
        return ULong.m6501constructorimpl(this.parcel.readLong());
    }

    /* renamed from: decodeColor-0d7_KjU  reason: not valid java name */
    public final long m4831decodeColor0d7_KjU() {
        return Color.m2915constructorimpl(m4830decodeULongsVKNKU());
    }

    /* renamed from: decodeFontStyle-_-LCdwA  reason: not valid java name */
    public final int m4832decodeFontStyle_LCdwA() {
        byte decodeByte = decodeByte();
        if (decodeByte == 0) {
            return FontStyle.Companion.m5129getNormal_LCdwA();
        }
        if (decodeByte == 1) {
            return FontStyle.Companion.m5128getItalic_LCdwA();
        }
        return FontStyle.Companion.m5129getNormal_LCdwA();
    }

    /* renamed from: decodeFontSynthesis-GVVA2EU  reason: not valid java name */
    public final int m4833decodeFontSynthesisGVVA2EU() {
        byte decodeByte = decodeByte();
        if (decodeByte == 0) {
            return FontSynthesis.Companion.m5140getNoneGVVA2EU();
        }
        if (decodeByte == 1) {
            return FontSynthesis.Companion.m5139getAllGVVA2EU();
        }
        if (decodeByte == 3) {
            return FontSynthesis.Companion.m5141getStyleGVVA2EU();
        }
        if (decodeByte == 2) {
            return FontSynthesis.Companion.m5142getWeightGVVA2EU();
        }
        return FontSynthesis.Companion.m5140getNoneGVVA2EU();
    }

    @NotNull
    public final FontWeight decodeFontWeight() {
        return new FontWeight(decodeInt());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0112, code lost:
        r4 = r21;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.compose.ui.text.SpanStyle decodeSpanStyle() {
        /*
            r22 = this;
            androidx.compose.ui.platform.MutableSpanStyle r15 = new androidx.compose.ui.platform.MutableSpanStyle
            r0 = r15
            r1 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            r21 = r15
            r15 = r16
            r17 = 0
            r18 = 0
            r19 = 16383(0x3fff, float:2.2957E-41)
            r20 = 0
            r0.<init>(r1, r3, r5, r6, r7, r8, r9, r10, r12, r13, r14, r15, r17, r18, r19, r20)
            r0 = r22
        L_0x0024:
            android.os.Parcel r1 = r0.parcel
            int r1 = r1.dataAvail()
            r2 = 1
            if (r1 <= r2) goto L_0x0112
            byte r1 = r22.decodeByte()
            r3 = 8
            if (r1 != r2) goto L_0x0045
            int r1 = r22.dataAvailable()
            if (r1 < r3) goto L_0x0112
            long r1 = r22.m4831decodeColor0d7_KjU()
            r4 = r21
            r4.m4854setColor8_81llA(r1)
            goto L_0x0024
        L_0x0045:
            r4 = r21
            r5 = 2
            r6 = 5
            if (r1 != r5) goto L_0x005b
            int r1 = r22.dataAvailable()
            if (r1 < r6) goto L_0x0114
            long r1 = r22.m4834decodeTextUnitXSAIIZE()
            r4.m4855setFontSizeR2X_6o(r1)
        L_0x0058:
            r21 = r4
            goto L_0x0024
        L_0x005b:
            r5 = 3
            r7 = 4
            if (r1 != r5) goto L_0x006d
            int r1 = r22.dataAvailable()
            if (r1 < r7) goto L_0x0114
            androidx.compose.ui.text.font.FontWeight r1 = r22.decodeFontWeight()
            r4.setFontWeight(r1)
            goto L_0x0058
        L_0x006d:
            if (r1 != r7) goto L_0x0081
            int r1 = r22.dataAvailable()
            if (r1 < r2) goto L_0x0114
            int r1 = r22.m4832decodeFontStyle_LCdwA()
            androidx.compose.ui.text.font.FontStyle r1 = androidx.compose.ui.text.font.FontStyle.m5121boximpl(r1)
            r4.m4856setFontStylemLjRB2g(r1)
            goto L_0x0058
        L_0x0081:
            if (r1 != r6) goto L_0x0095
            int r1 = r22.dataAvailable()
            if (r1 < r2) goto L_0x0114
            int r1 = r22.m4833decodeFontSynthesisGVVA2EU()
            androidx.compose.ui.text.font.FontSynthesis r1 = androidx.compose.ui.text.font.FontSynthesis.m5130boximpl(r1)
            r4.m4857setFontSynthesistDdu0R4(r1)
            goto L_0x0058
        L_0x0095:
            r2 = 6
            if (r1 != r2) goto L_0x00a0
            java.lang.String r1 = r22.decodeString()
            r4.setFontFeatureSettings(r1)
            goto L_0x0058
        L_0x00a0:
            r2 = 7
            if (r1 != r2) goto L_0x00b1
            int r1 = r22.dataAvailable()
            if (r1 < r6) goto L_0x0114
            long r1 = r22.m4834decodeTextUnitXSAIIZE()
            r4.m4858setLetterSpacingR2X_6o(r1)
            goto L_0x0058
        L_0x00b1:
            if (r1 != r3) goto L_0x00c5
            int r1 = r22.dataAvailable()
            if (r1 < r7) goto L_0x0114
            float r1 = r22.m4829decodeBaselineShifty9eOQZs()
            androidx.compose.ui.text.style.BaselineShift r1 = androidx.compose.ui.text.style.BaselineShift.m5274boximpl(r1)
            r4.m4853setBaselineShift_isdbwI(r1)
            goto L_0x0058
        L_0x00c5:
            r2 = 9
            if (r1 != r2) goto L_0x00d7
            int r1 = r22.dataAvailable()
            if (r1 < r3) goto L_0x0114
            androidx.compose.ui.text.style.TextGeometricTransform r1 = r22.decodeTextGeometricTransform()
            r4.setTextGeometricTransform(r1)
            goto L_0x0058
        L_0x00d7:
            r2 = 10
            if (r1 != r2) goto L_0x00ea
            int r1 = r22.dataAvailable()
            if (r1 < r3) goto L_0x0114
            long r1 = r22.m4831decodeColor0d7_KjU()
            r4.m4852setBackground8_81llA(r1)
            goto L_0x0058
        L_0x00ea:
            r2 = 11
            if (r1 != r2) goto L_0x00fd
            int r1 = r22.dataAvailable()
            if (r1 < r7) goto L_0x0114
            androidx.compose.ui.text.style.TextDecoration r1 = r22.decodeTextDecoration()
            r4.setTextDecoration(r1)
            goto L_0x0058
        L_0x00fd:
            r2 = 12
            if (r1 != r2) goto L_0x0058
            int r1 = r22.dataAvailable()
            r2 = 20
            if (r1 < r2) goto L_0x0114
            androidx.compose.ui.graphics.Shadow r1 = r22.decodeShadow()
            r4.setShadow(r1)
            goto L_0x0058
        L_0x0112:
            r4 = r21
        L_0x0114:
            androidx.compose.ui.text.SpanStyle r1 = r4.toSpanStyle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.DecodeHelper.decodeSpanStyle():androidx.compose.ui.text.SpanStyle");
    }

    /* renamed from: decodeTextUnit-XSAIIZE  reason: not valid java name */
    public final long m4834decodeTextUnitXSAIIZE() {
        long j11;
        byte decodeByte = decodeByte();
        if (decodeByte == 1) {
            j11 = TextUnitType.Companion.m5692getSpUIouoOA();
        } else if (decodeByte == 2) {
            j11 = TextUnitType.Companion.m5691getEmUIouoOA();
        } else {
            j11 = TextUnitType.Companion.m5693getUnspecifiedUIouoOA();
        }
        if (TextUnitType.m5687equalsimpl0(j11, TextUnitType.Companion.m5693getUnspecifiedUIouoOA())) {
            return TextUnit.Companion.m5670getUnspecifiedXSAIIZE();
        }
        return TextUnitKt.m5671TextUnitanM5pPY(decodeFloat(), j11);
    }
}
