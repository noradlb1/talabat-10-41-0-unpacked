package com.talabat.userandlocation.choosecountry.presentation;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J;\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/presentation/Extras;", "", "isInitialSelection", "", "isFromLocationWelcomeScreen", "isLoadMapFromWelcome", "isShowMapSearch", "shouldForceLocationSelection", "(ZZZZZ)V", "()Z", "getShouldForceLocationSelection", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Extras {
    private final boolean isFromLocationWelcomeScreen;
    private final boolean isInitialSelection;
    private final boolean isLoadMapFromWelcome;
    private final boolean isShowMapSearch;
    private final boolean shouldForceLocationSelection;

    public Extras() {
        this(false, false, false, false, false, 31, (DefaultConstructorMarker) null);
    }

    public Extras(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        this.isInitialSelection = z11;
        this.isFromLocationWelcomeScreen = z12;
        this.isLoadMapFromWelcome = z13;
        this.isShowMapSearch = z14;
        this.shouldForceLocationSelection = z15;
    }

    public static /* synthetic */ Extras copy$default(Extras extras, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = extras.isInitialSelection;
        }
        if ((i11 & 2) != 0) {
            z12 = extras.isFromLocationWelcomeScreen;
        }
        boolean z16 = z12;
        if ((i11 & 4) != 0) {
            z13 = extras.isLoadMapFromWelcome;
        }
        boolean z17 = z13;
        if ((i11 & 8) != 0) {
            z14 = extras.isShowMapSearch;
        }
        boolean z18 = z14;
        if ((i11 & 16) != 0) {
            z15 = extras.shouldForceLocationSelection;
        }
        return extras.copy(z11, z16, z17, z18, z15);
    }

    public final boolean component1() {
        return this.isInitialSelection;
    }

    public final boolean component2() {
        return this.isFromLocationWelcomeScreen;
    }

    public final boolean component3() {
        return this.isLoadMapFromWelcome;
    }

    public final boolean component4() {
        return this.isShowMapSearch;
    }

    public final boolean component5() {
        return this.shouldForceLocationSelection;
    }

    @NotNull
    public final Extras copy(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        return new Extras(z11, z12, z13, z14, z15);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Extras)) {
            return false;
        }
        Extras extras = (Extras) obj;
        return this.isInitialSelection == extras.isInitialSelection && this.isFromLocationWelcomeScreen == extras.isFromLocationWelcomeScreen && this.isLoadMapFromWelcome == extras.isLoadMapFromWelcome && this.isShowMapSearch == extras.isShowMapSearch && this.shouldForceLocationSelection == extras.shouldForceLocationSelection;
    }

    public final boolean getShouldForceLocationSelection() {
        return this.shouldForceLocationSelection;
    }

    public int hashCode() {
        boolean z11 = this.isInitialSelection;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (z11 ? 1 : 0) * true;
        boolean z13 = this.isFromLocationWelcomeScreen;
        if (z13) {
            z13 = true;
        }
        int i12 = (i11 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.isLoadMapFromWelcome;
        if (z14) {
            z14 = true;
        }
        int i13 = (i12 + (z14 ? 1 : 0)) * 31;
        boolean z15 = this.isShowMapSearch;
        if (z15) {
            z15 = true;
        }
        int i14 = (i13 + (z15 ? 1 : 0)) * 31;
        boolean z16 = this.shouldForceLocationSelection;
        if (!z16) {
            z12 = z16;
        }
        return i14 + (z12 ? 1 : 0);
    }

    public final boolean isFromLocationWelcomeScreen() {
        return this.isFromLocationWelcomeScreen;
    }

    public final boolean isInitialSelection() {
        return this.isInitialSelection;
    }

    public final boolean isLoadMapFromWelcome() {
        return this.isLoadMapFromWelcome;
    }

    public final boolean isShowMapSearch() {
        return this.isShowMapSearch;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.isInitialSelection;
        boolean z12 = this.isFromLocationWelcomeScreen;
        boolean z13 = this.isLoadMapFromWelcome;
        boolean z14 = this.isShowMapSearch;
        boolean z15 = this.shouldForceLocationSelection;
        return "Extras(isInitialSelection=" + z11 + ", isFromLocationWelcomeScreen=" + z12 + ", isLoadMapFromWelcome=" + z13 + ", isShowMapSearch=" + z14 + ", shouldForceLocationSelection=" + z15 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Extras(boolean r5, boolean r6, boolean r7, boolean r8, boolean r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.choosecountry.presentation.Extras.<init>(boolean, boolean, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
