package com.talabat.helpers;

import java.util.Arrays;
import java.util.List;

public class ColorGenerator {
    public static ColorGenerator DEFAULT = create(Arrays.asList(new Integer[]{-957596, -686759, -416706, -1784274, -9977996, -10902850, -14642227, -5414233, -8366207}));
    public static ColorGenerator MATERIAL = create(Arrays.asList(new Integer[]{-2818048, -3862174, -5635841, -10354454, -13611010, -14064897, -16739862, -16729900, -16728155, -16725933, -10167017, -5314048, -10752, -37632, -2282496, -12703965}));
    public static ColorGenerator MATERIAL_BG = create(Arrays.asList(new Integer[]{-12846, -476208, -1982745, -3029783, -3814679, -4464901, -4987396, -5051406, -5054501, -3610935, -2298424, -985917, -1596, -8014, -13124, -2634552}));
    private final List<Integer> mColors;

    private ColorGenerator(List<Integer> list) {
        this.mColors = list;
    }

    public static ColorGenerator create(List<Integer> list) {
        return new ColorGenerator(list);
    }

    public int getColor(Object obj) {
        return this.mColors.get(Math.abs(obj.hashCode()) % this.mColors.size()).intValue();
    }
}
