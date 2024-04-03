package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\n\u0018\u00002\u00020\u0001BH\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0019\u0010\u001a\u001a\u00020\r2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H\u0002ø\u0001\u0000J\u0019\u0010\u001b\u001a\u00020\u00132\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002ø\u0001\u0000R\u0011\u0010\b\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/graphics/Vertices;", "", "vertexMode", "Landroidx/compose/ui/graphics/VertexMode;", "positions", "", "Landroidx/compose/ui/geometry/Offset;", "textureCoordinates", "colors", "Landroidx/compose/ui/graphics/Color;", "indices", "", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "getColors", "()[I", "", "getIndices", "()[S", "", "getPositions", "()[F", "getTextureCoordinates", "getVertexMode-c2xauaI", "()I", "I", "encodeColorList", "encodePointList", "points", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Vertices {
    @NotNull
    private final int[] colors;
    @NotNull
    private final short[] indices;
    @NotNull
    private final float[] positions;
    @NotNull
    private final float[] textureCoordinates;
    private final int vertexMode;

    private Vertices(int i11, List<Offset> list, List<Offset> list2, List<Color> list3, List<Integer> list4) {
        boolean z11;
        this.vertexMode = i11;
        Vertices$outOfBounds$1 vertices$outOfBounds$1 = new Vertices$outOfBounds$1(list);
        if (list2.size() != list.size()) {
            throw new IllegalArgumentException("positions and textureCoordinates lengths must match.");
        } else if (list3.size() == list.size()) {
            int size = list4.size();
            int i12 = 0;
            while (true) {
                if (i12 >= size) {
                    z11 = false;
                    break;
                } else if (((Boolean) vertices$outOfBounds$1.invoke(list4.get(i12))).booleanValue()) {
                    z11 = true;
                    break;
                } else {
                    i12++;
                }
            }
            if (!z11) {
                this.positions = encodePointList(list);
                this.textureCoordinates = encodePointList(list2);
                this.colors = encodeColorList(list3);
                int size2 = list4.size();
                short[] sArr = new short[size2];
                for (int i13 = 0; i13 < size2; i13++) {
                    sArr[i13] = (short) list4.get(i13).intValue();
                }
                this.indices = sArr;
                return;
            }
            throw new IllegalArgumentException("indices values must be valid indices in the positions list.");
        } else {
            throw new IllegalArgumentException("positions and colors lengths must match.");
        }
    }

    public /* synthetic */ Vertices(int i11, List list, List list2, List list3, List list4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, list, list2, list3, list4);
    }

    private final int[] encodeColorList(List<Color> list) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr[i11] = ColorKt.m2974toArgb8_81llA(list.get(i11).m2929unboximpl());
        }
        return iArr;
    }

    private final float[] encodePointList(List<Offset> list) {
        float f11;
        int size = list.size() * 2;
        float[] fArr = new float[size];
        for (int i11 = 0; i11 < size; i11++) {
            long r32 = list.get(i11 / 2).m2686unboximpl();
            if (i11 % 2 == 0) {
                f11 = Offset.m2676getXimpl(r32);
            } else {
                f11 = Offset.m2677getYimpl(r32);
            }
            fArr[i11] = f11;
        }
        return fArr;
    }

    @NotNull
    public final int[] getColors() {
        return this.colors;
    }

    @NotNull
    public final short[] getIndices() {
        return this.indices;
    }

    @NotNull
    public final float[] getPositions() {
        return this.positions;
    }

    @NotNull
    public final float[] getTextureCoordinates() {
        return this.textureCoordinates;
    }

    /* renamed from: getVertexMode-c2xauaI  reason: not valid java name */
    public final int m3303getVertexModec2xauaI() {
        return this.vertexMode;
    }
}
