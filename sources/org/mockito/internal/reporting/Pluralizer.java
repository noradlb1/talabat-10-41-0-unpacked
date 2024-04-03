package org.mockito.internal.reporting;

public final class Pluralizer {
    private Pluralizer() {
    }

    public static String pluralize(int i11) {
        if (i11 == 1) {
            return "1 time";
        }
        return i11 + " times";
    }

    public static String were_exactly_x_interactions(int i11) {
        if (i11 == 1) {
            return "was exactly 1 interaction";
        }
        return "were exactly " + i11 + " interactions";
    }
}
