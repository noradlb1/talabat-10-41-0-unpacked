package te;

import androidx.palette.graphics.Palette;
import com.skydoves.landscapist.palette.BitmapPalette;

public final /* synthetic */ class a implements Palette.PaletteAsyncListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BitmapPalette f57414a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f57415b;

    public /* synthetic */ a(BitmapPalette bitmapPalette, Object obj) {
        this.f57414a = bitmapPalette;
        this.f57415b = obj;
    }

    public final void onGenerated(Palette palette) {
        BitmapPalette.m9407generate$lambda1(this.f57414a, this.f57415b, palette);
    }
}
