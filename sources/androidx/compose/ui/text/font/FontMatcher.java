package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.FontWeight;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\rJ1\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\u000fJ7\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\u0011JF\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\tH\b¢\u0006\u0002\b\u0017\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/text/font/FontMatcher;", "", "()V", "matchFont", "", "Landroidx/compose/ui/text/font/Font;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "matchFont-RetOiIg", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "Landroidx/compose/ui/text/font/FontListFontFamily;", "(Landroidx/compose/ui/text/font/FontListFontFamily;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "fontList", "(Ljava/util/List;Landroidx/compose/ui/text/font/FontWeight;I)Ljava/util/List;", "filterByClosestWeight", "preferBelow", "", "minSearchRange", "maxSearchRange", "filterByClosestWeight$ui_text_release", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FontMatcher {
    public static /* synthetic */ List filterByClosestWeight$ui_text_release$default(FontMatcher fontMatcher, List list, FontWeight fontWeight, boolean z11, FontWeight fontWeight2, FontWeight fontWeight3, int i11, Object obj) {
        FontWeight fontWeight4 = null;
        if ((i11 & 4) != 0) {
            fontWeight2 = null;
        }
        if ((i11 & 8) != 0) {
            fontWeight3 = null;
        }
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(fontWeight, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        int size = list.size();
        int i12 = 0;
        FontWeight fontWeight5 = null;
        while (true) {
            if (i12 >= size) {
                break;
            }
            FontWeight weight = ((Font) list.get(i12)).getWeight();
            if ((fontWeight2 == null || weight.compareTo(fontWeight2) >= 0) && (fontWeight3 == null || weight.compareTo(fontWeight3) <= 0)) {
                if (weight.compareTo(fontWeight) >= 0) {
                    if (weight.compareTo(fontWeight) <= 0) {
                        fontWeight4 = weight;
                        fontWeight5 = fontWeight4;
                        break;
                    } else if (fontWeight5 == null || weight.compareTo(fontWeight5) < 0) {
                        fontWeight5 = weight;
                    }
                } else if (fontWeight4 == null || weight.compareTo(fontWeight4) > 0) {
                    fontWeight4 = weight;
                }
            }
            i12++;
        }
        if (!z11 ? fontWeight5 != null : fontWeight4 == null) {
            fontWeight4 = fontWeight5;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        for (int i13 = 0; i13 < size2; i13++) {
            Object obj2 = list.get(i13);
            if (Intrinsics.areEqual((Object) ((Font) obj2).getWeight(), (Object) fontWeight4)) {
                arrayList.add(obj2);
            }
        }
        return arrayList;
    }

    @NotNull
    public final List<Font> filterByClosestWeight$ui_text_release(@NotNull List<? extends Font> list, @NotNull FontWeight fontWeight, boolean z11, @Nullable FontWeight fontWeight2, @Nullable FontWeight fontWeight3) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(fontWeight, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        int size = list.size();
        FontWeight fontWeight4 = null;
        FontWeight fontWeight5 = null;
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                break;
            }
            FontWeight weight = ((Font) list.get(i11)).getWeight();
            if ((fontWeight2 == null || weight.compareTo(fontWeight2) >= 0) && (fontWeight3 == null || weight.compareTo(fontWeight3) <= 0)) {
                if (weight.compareTo(fontWeight) >= 0) {
                    if (weight.compareTo(fontWeight) <= 0) {
                        fontWeight4 = weight;
                        fontWeight5 = fontWeight4;
                        break;
                    } else if (fontWeight5 == null || weight.compareTo(fontWeight5) < 0) {
                        fontWeight5 = weight;
                    }
                } else if (fontWeight4 == null || weight.compareTo(fontWeight4) > 0) {
                    fontWeight4 = weight;
                }
            }
            i11++;
        }
        if (!z11 ? fontWeight5 != null : fontWeight4 == null) {
            fontWeight4 = fontWeight5;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size2 = list.size();
        for (int i12 = 0; i12 < size2; i12++) {
            Object obj = list.get(i12);
            if (Intrinsics.areEqual((Object) ((Font) obj).getWeight(), (Object) fontWeight4)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    /* renamed from: matchFont-RetOiIg  reason: not valid java name */
    public final List<Font> m5118matchFontRetOiIg(@NotNull FontFamily fontFamily, @NotNull FontWeight fontWeight, int i11) {
        Intrinsics.checkNotNullParameter(fontFamily, TtmlNode.ATTR_TTS_FONT_FAMILY);
        Intrinsics.checkNotNullParameter(fontWeight, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        if (fontFamily instanceof FontListFontFamily) {
            return m5119matchFontRetOiIg((FontListFontFamily) fontFamily, fontWeight, i11);
        }
        throw new IllegalArgumentException("Only FontFamily instances that presents a list of Fonts can be used");
    }

    @NotNull
    /* renamed from: matchFont-RetOiIg  reason: not valid java name */
    public final List<Font> m5119matchFontRetOiIg(@NotNull FontListFontFamily fontListFontFamily, @NotNull FontWeight fontWeight, int i11) {
        Intrinsics.checkNotNullParameter(fontListFontFamily, TtmlNode.ATTR_TTS_FONT_FAMILY);
        Intrinsics.checkNotNullParameter(fontWeight, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        return m5120matchFontRetOiIg((List<? extends Font>) fontListFontFamily.getFonts(), fontWeight, i11);
    }

    @NotNull
    /* renamed from: matchFont-RetOiIg  reason: not valid java name */
    public final List<Font> m5120matchFontRetOiIg(@NotNull List<? extends Font> list, @NotNull FontWeight fontWeight, int i11) {
        Intrinsics.checkNotNullParameter(list, "fontList");
        Intrinsics.checkNotNullParameter(fontWeight, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        int i12 = 0;
        int i13 = 0;
        while (true) {
            boolean z11 = true;
            if (i13 >= size) {
                break;
            }
            Object obj = list.get(i13);
            Font font = (Font) obj;
            if (!Intrinsics.areEqual((Object) font.getWeight(), (Object) fontWeight) || !FontStyle.m5124equalsimpl0(font.m5099getStyle_LCdwA(), i11)) {
                z11 = false;
            }
            if (z11) {
                arrayList.add(obj);
            }
            i13++;
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        Unit unit = Unit.INSTANCE;
        ArrayList arrayList2 = new ArrayList(list.size());
        int size2 = list.size();
        for (int i14 = 0; i14 < size2; i14++) {
            Object obj2 = list.get(i14);
            if (FontStyle.m5124equalsimpl0(((Font) obj2).m5099getStyle_LCdwA(), i11)) {
                arrayList2.add(obj2);
            }
        }
        if (!arrayList2.isEmpty()) {
            list = arrayList2;
        }
        List list2 = list;
        FontWeight.Companion companion = FontWeight.Companion;
        FontWeight fontWeight2 = null;
        if (fontWeight.compareTo(companion.getW400()) < 0) {
            int size3 = list2.size();
            FontWeight fontWeight3 = null;
            int i15 = 0;
            while (true) {
                if (i15 >= size3) {
                    break;
                }
                FontWeight weight = ((Font) list2.get(i15)).getWeight();
                if (weight.compareTo(fontWeight) >= 0) {
                    if (weight.compareTo(fontWeight) <= 0) {
                        fontWeight3 = weight;
                        fontWeight2 = fontWeight3;
                        break;
                    } else if (fontWeight3 == null || weight.compareTo(fontWeight3) < 0) {
                        fontWeight3 = weight;
                    }
                } else if (fontWeight2 == null || weight.compareTo(fontWeight2) > 0) {
                    fontWeight2 = weight;
                }
                i15++;
            }
            if (fontWeight2 != null) {
                fontWeight3 = fontWeight2;
            }
            ArrayList arrayList3 = new ArrayList(list2.size());
            int size4 = list2.size();
            while (i12 < size4) {
                Object obj3 = list2.get(i12);
                if (Intrinsics.areEqual((Object) ((Font) obj3).getWeight(), (Object) fontWeight3)) {
                    arrayList3.add(obj3);
                }
                i12++;
            }
            return arrayList3;
        } else if (fontWeight.compareTo(companion.getW500()) > 0) {
            int size5 = list2.size();
            FontWeight fontWeight4 = null;
            int i16 = 0;
            while (true) {
                if (i16 >= size5) {
                    break;
                }
                FontWeight weight2 = ((Font) list2.get(i16)).getWeight();
                if (weight2.compareTo(fontWeight) >= 0) {
                    if (weight2.compareTo(fontWeight) <= 0) {
                        fontWeight4 = weight2;
                        fontWeight2 = fontWeight4;
                        break;
                    } else if (fontWeight4 == null || weight2.compareTo(fontWeight4) < 0) {
                        fontWeight4 = weight2;
                    }
                } else if (fontWeight2 == null || weight2.compareTo(fontWeight2) > 0) {
                    fontWeight2 = weight2;
                }
                i16++;
            }
            if (fontWeight4 == null) {
                fontWeight4 = fontWeight2;
            }
            ArrayList arrayList4 = new ArrayList(list2.size());
            int size6 = list2.size();
            while (i12 < size6) {
                Object obj4 = list2.get(i12);
                if (Intrinsics.areEqual((Object) ((Font) obj4).getWeight(), (Object) fontWeight4)) {
                    arrayList4.add(obj4);
                }
                i12++;
            }
            return arrayList4;
        } else {
            FontWeight w500 = companion.getW500();
            int size7 = list2.size();
            FontWeight fontWeight5 = null;
            FontWeight fontWeight6 = null;
            int i17 = 0;
            while (true) {
                if (i17 >= size7) {
                    break;
                }
                FontWeight weight3 = ((Font) list2.get(i17)).getWeight();
                if (w500 == null || weight3.compareTo(w500) <= 0) {
                    if (weight3.compareTo(fontWeight) >= 0) {
                        if (weight3.compareTo(fontWeight) <= 0) {
                            fontWeight5 = weight3;
                            fontWeight6 = fontWeight5;
                            break;
                        } else if (fontWeight6 == null || weight3.compareTo(fontWeight6) < 0) {
                            fontWeight6 = weight3;
                        }
                    } else if (fontWeight5 == null || weight3.compareTo(fontWeight5) > 0) {
                        fontWeight5 = weight3;
                    }
                }
                i17++;
            }
            if (fontWeight6 != null) {
                fontWeight5 = fontWeight6;
            }
            ArrayList arrayList5 = new ArrayList(list2.size());
            int size8 = list2.size();
            for (int i18 = 0; i18 < size8; i18++) {
                Object obj5 = list2.get(i18);
                if (Intrinsics.areEqual((Object) ((Font) obj5).getWeight(), (Object) fontWeight5)) {
                    arrayList5.add(obj5);
                }
            }
            if (!arrayList5.isEmpty()) {
                return arrayList5;
            }
            FontWeight w5002 = FontWeight.Companion.getW500();
            int size9 = list2.size();
            FontWeight fontWeight7 = null;
            int i19 = 0;
            while (true) {
                if (i19 >= size9) {
                    break;
                }
                FontWeight weight4 = ((Font) list2.get(i19)).getWeight();
                if (w5002 == null || weight4.compareTo(w5002) >= 0) {
                    if (weight4.compareTo(fontWeight) >= 0) {
                        if (weight4.compareTo(fontWeight) <= 0) {
                            fontWeight2 = weight4;
                            fontWeight7 = fontWeight2;
                            break;
                        } else if (fontWeight7 == null || weight4.compareTo(fontWeight7) < 0) {
                            fontWeight7 = weight4;
                        }
                    } else if (fontWeight2 == null || weight4.compareTo(fontWeight2) > 0) {
                        fontWeight2 = weight4;
                    }
                }
                i19++;
            }
            if (fontWeight7 != null) {
                fontWeight2 = fontWeight7;
            }
            ArrayList arrayList6 = new ArrayList(list2.size());
            int size10 = list2.size();
            while (i12 < size10) {
                Object obj6 = list2.get(i12);
                if (Intrinsics.areEqual((Object) ((Font) obj6).getWeight(), (Object) fontWeight2)) {
                    arrayList6.add(obj6);
                }
                i12++;
            }
            return arrayList6;
        }
    }
}
