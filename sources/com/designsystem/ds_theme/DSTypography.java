package com.designsystem.ds_theme;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.text.TextStyle;
import com.google.android.exoplayer2.C;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b`\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001Bý\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\u0003¢\u0006\u0002\u0010\"J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0003HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\t\u0010a\u001a\u00020\u0003HÆ\u0003J¿\u0002\u0010b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0003HÆ\u0001J\u0013\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010f\u001a\u00020gHÖ\u0001J\t\u0010h\u001a\u00020iHÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010$R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0011\u0010\u0019\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010$R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010$R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010$R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010$R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010$R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010$R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010$R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010$R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010$R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010$R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010$R\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010$R\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010$R\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010$R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010$R\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010$R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010$R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010$R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010$R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010$R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010$R\u0011\u0010\u0018\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010$R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010$¨\u0006j"}, d2 = {"Lcom/designsystem/ds_theme/DSTypography;", "", "dsHeading0", "Landroidx/compose/ui/text/TextStyle;", "dsHeading1", "dsHeading2", "dsSubheading1", "dsSubheading2", "dsBody0", "dsBody0Bold", "dsBody1", "dsBody1Bold", "dsBody1Compact", "dsLink", "dsButton", "dsCaption", "dsTag", "dsHeadingXXLarge", "dsHeadingXLarge", "dsHeadingLarge", "dsHeadingMedium", "dsSubheadingLarge", "dsSubheadingMedium", "dsSubheadingSmall", "dsSubheadingXSmall", "dsBodyMedium", "dsBodyMediumCompact", "dsBodySmall", "dsBodySmallCompact", "dsBodyXSmall", "dsLinkMedium", "dsLinkMediumCompact", "dsLinkSmall", "dsLinkXSmall", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;)V", "getDsBody0", "()Landroidx/compose/ui/text/TextStyle;", "getDsBody0Bold", "getDsBody1", "getDsBody1Bold", "getDsBody1Compact", "getDsBodyMedium", "getDsBodyMediumCompact", "getDsBodySmall", "getDsBodySmallCompact", "getDsBodyXSmall", "getDsButton", "getDsCaption", "getDsHeading0", "getDsHeading1", "getDsHeading2", "getDsHeadingLarge", "getDsHeadingMedium", "getDsHeadingXLarge", "getDsHeadingXXLarge", "getDsLink", "getDsLinkMedium", "getDsLinkMediumCompact", "getDsLinkSmall", "getDsLinkXSmall", "getDsSubheading1", "getDsSubheading2", "getDsSubheadingLarge", "getDsSubheadingMedium", "getDsSubheadingSmall", "getDsSubheadingXSmall", "getDsTag", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSTypography {
    @NotNull
    private final TextStyle dsBody0;
    @NotNull
    private final TextStyle dsBody0Bold;
    @NotNull
    private final TextStyle dsBody1;
    @NotNull
    private final TextStyle dsBody1Bold;
    @NotNull
    private final TextStyle dsBody1Compact;
    @NotNull
    private final TextStyle dsBodyMedium;
    @NotNull
    private final TextStyle dsBodyMediumCompact;
    @NotNull
    private final TextStyle dsBodySmall;
    @NotNull
    private final TextStyle dsBodySmallCompact;
    @NotNull
    private final TextStyle dsBodyXSmall;
    @NotNull
    private final TextStyle dsButton;
    @NotNull
    private final TextStyle dsCaption;
    @NotNull
    private final TextStyle dsHeading0;
    @NotNull
    private final TextStyle dsHeading1;
    @NotNull
    private final TextStyle dsHeading2;
    @NotNull
    private final TextStyle dsHeadingLarge;
    @NotNull
    private final TextStyle dsHeadingMedium;
    @NotNull
    private final TextStyle dsHeadingXLarge;
    @NotNull
    private final TextStyle dsHeadingXXLarge;
    @NotNull
    private final TextStyle dsLink;
    @NotNull
    private final TextStyle dsLinkMedium;
    @NotNull
    private final TextStyle dsLinkMediumCompact;
    @NotNull
    private final TextStyle dsLinkSmall;
    @NotNull
    private final TextStyle dsLinkXSmall;
    @NotNull
    private final TextStyle dsSubheading1;
    @NotNull
    private final TextStyle dsSubheading2;
    @NotNull
    private final TextStyle dsSubheadingLarge;
    @NotNull
    private final TextStyle dsSubheadingMedium;
    @NotNull
    private final TextStyle dsSubheadingSmall;
    @NotNull
    private final TextStyle dsSubheadingXSmall;
    @NotNull
    private final TextStyle dsTag;

    public DSTypography(@NotNull TextStyle textStyle, @NotNull TextStyle textStyle2, @NotNull TextStyle textStyle3, @NotNull TextStyle textStyle4, @NotNull TextStyle textStyle5, @NotNull TextStyle textStyle6, @NotNull TextStyle textStyle7, @NotNull TextStyle textStyle8, @NotNull TextStyle textStyle9, @NotNull TextStyle textStyle10, @NotNull TextStyle textStyle11, @NotNull TextStyle textStyle12, @NotNull TextStyle textStyle13, @NotNull TextStyle textStyle14, @NotNull TextStyle textStyle15, @NotNull TextStyle textStyle16, @NotNull TextStyle textStyle17, @NotNull TextStyle textStyle18, @NotNull TextStyle textStyle19, @NotNull TextStyle textStyle20, @NotNull TextStyle textStyle21, @NotNull TextStyle textStyle22, @NotNull TextStyle textStyle23, @NotNull TextStyle textStyle24, @NotNull TextStyle textStyle25, @NotNull TextStyle textStyle26, @NotNull TextStyle textStyle27, @NotNull TextStyle textStyle28, @NotNull TextStyle textStyle29, @NotNull TextStyle textStyle30, @NotNull TextStyle textStyle31) {
        TextStyle textStyle32 = textStyle;
        TextStyle textStyle33 = textStyle2;
        TextStyle textStyle34 = textStyle3;
        TextStyle textStyle35 = textStyle4;
        TextStyle textStyle36 = textStyle5;
        TextStyle textStyle37 = textStyle6;
        TextStyle textStyle38 = textStyle7;
        TextStyle textStyle39 = textStyle8;
        TextStyle textStyle40 = textStyle9;
        TextStyle textStyle41 = textStyle10;
        TextStyle textStyle42 = textStyle11;
        TextStyle textStyle43 = textStyle12;
        TextStyle textStyle44 = textStyle13;
        TextStyle textStyle45 = textStyle14;
        TextStyle textStyle46 = textStyle16;
        Intrinsics.checkNotNullParameter(textStyle32, "dsHeading0");
        Intrinsics.checkNotNullParameter(textStyle33, "dsHeading1");
        Intrinsics.checkNotNullParameter(textStyle34, "dsHeading2");
        Intrinsics.checkNotNullParameter(textStyle35, "dsSubheading1");
        Intrinsics.checkNotNullParameter(textStyle36, "dsSubheading2");
        Intrinsics.checkNotNullParameter(textStyle37, "dsBody0");
        Intrinsics.checkNotNullParameter(textStyle38, "dsBody0Bold");
        Intrinsics.checkNotNullParameter(textStyle39, "dsBody1");
        Intrinsics.checkNotNullParameter(textStyle40, "dsBody1Bold");
        Intrinsics.checkNotNullParameter(textStyle41, "dsBody1Compact");
        Intrinsics.checkNotNullParameter(textStyle42, "dsLink");
        Intrinsics.checkNotNullParameter(textStyle43, "dsButton");
        Intrinsics.checkNotNullParameter(textStyle44, "dsCaption");
        Intrinsics.checkNotNullParameter(textStyle45, "dsTag");
        Intrinsics.checkNotNullParameter(textStyle15, "dsHeadingXXLarge");
        Intrinsics.checkNotNullParameter(textStyle16, "dsHeadingXLarge");
        Intrinsics.checkNotNullParameter(textStyle17, "dsHeadingLarge");
        Intrinsics.checkNotNullParameter(textStyle18, "dsHeadingMedium");
        Intrinsics.checkNotNullParameter(textStyle19, "dsSubheadingLarge");
        Intrinsics.checkNotNullParameter(textStyle20, "dsSubheadingMedium");
        Intrinsics.checkNotNullParameter(textStyle21, "dsSubheadingSmall");
        Intrinsics.checkNotNullParameter(textStyle22, "dsSubheadingXSmall");
        Intrinsics.checkNotNullParameter(textStyle23, "dsBodyMedium");
        Intrinsics.checkNotNullParameter(textStyle24, "dsBodyMediumCompact");
        Intrinsics.checkNotNullParameter(textStyle25, "dsBodySmall");
        Intrinsics.checkNotNullParameter(textStyle26, "dsBodySmallCompact");
        Intrinsics.checkNotNullParameter(textStyle27, "dsBodyXSmall");
        Intrinsics.checkNotNullParameter(textStyle28, "dsLinkMedium");
        Intrinsics.checkNotNullParameter(textStyle29, "dsLinkMediumCompact");
        Intrinsics.checkNotNullParameter(textStyle30, "dsLinkSmall");
        Intrinsics.checkNotNullParameter(textStyle31, "dsLinkXSmall");
        this.dsHeading0 = textStyle32;
        this.dsHeading1 = textStyle33;
        this.dsHeading2 = textStyle34;
        this.dsSubheading1 = textStyle35;
        this.dsSubheading2 = textStyle36;
        this.dsBody0 = textStyle37;
        this.dsBody0Bold = textStyle38;
        this.dsBody1 = textStyle39;
        this.dsBody1Bold = textStyle40;
        this.dsBody1Compact = textStyle41;
        this.dsLink = textStyle42;
        this.dsButton = textStyle43;
        this.dsCaption = textStyle44;
        this.dsTag = textStyle45;
        this.dsHeadingXXLarge = textStyle15;
        this.dsHeadingXLarge = textStyle16;
        this.dsHeadingLarge = textStyle17;
        this.dsHeadingMedium = textStyle18;
        this.dsSubheadingLarge = textStyle19;
        this.dsSubheadingMedium = textStyle20;
        this.dsSubheadingSmall = textStyle21;
        this.dsSubheadingXSmall = textStyle22;
        this.dsBodyMedium = textStyle23;
        this.dsBodyMediumCompact = textStyle24;
        this.dsBodySmall = textStyle25;
        this.dsBodySmallCompact = textStyle26;
        this.dsBodyXSmall = textStyle27;
        this.dsLinkMedium = textStyle28;
        this.dsLinkMediumCompact = textStyle29;
        this.dsLinkSmall = textStyle30;
        this.dsLinkXSmall = textStyle31;
    }

    public static /* synthetic */ DSTypography copy$default(DSTypography dSTypography, TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13, TextStyle textStyle14, TextStyle textStyle15, TextStyle textStyle16, TextStyle textStyle17, TextStyle textStyle18, TextStyle textStyle19, TextStyle textStyle20, TextStyle textStyle21, TextStyle textStyle22, TextStyle textStyle23, TextStyle textStyle24, TextStyle textStyle25, TextStyle textStyle26, TextStyle textStyle27, TextStyle textStyle28, TextStyle textStyle29, TextStyle textStyle30, TextStyle textStyle31, int i11, Object obj) {
        DSTypography dSTypography2 = dSTypography;
        int i12 = i11;
        return dSTypography.copy((i12 & 1) != 0 ? dSTypography2.dsHeading0 : textStyle, (i12 & 2) != 0 ? dSTypography2.dsHeading1 : textStyle2, (i12 & 4) != 0 ? dSTypography2.dsHeading2 : textStyle3, (i12 & 8) != 0 ? dSTypography2.dsSubheading1 : textStyle4, (i12 & 16) != 0 ? dSTypography2.dsSubheading2 : textStyle5, (i12 & 32) != 0 ? dSTypography2.dsBody0 : textStyle6, (i12 & 64) != 0 ? dSTypography2.dsBody0Bold : textStyle7, (i12 & 128) != 0 ? dSTypography2.dsBody1 : textStyle8, (i12 & 256) != 0 ? dSTypography2.dsBody1Bold : textStyle9, (i12 & 512) != 0 ? dSTypography2.dsBody1Compact : textStyle10, (i12 & 1024) != 0 ? dSTypography2.dsLink : textStyle11, (i12 & 2048) != 0 ? dSTypography2.dsButton : textStyle12, (i12 & 4096) != 0 ? dSTypography2.dsCaption : textStyle13, (i12 & 8192) != 0 ? dSTypography2.dsTag : textStyle14, (i12 & 16384) != 0 ? dSTypography2.dsHeadingXXLarge : textStyle15, (i12 & 32768) != 0 ? dSTypography2.dsHeadingXLarge : textStyle16, (i12 & 65536) != 0 ? dSTypography2.dsHeadingLarge : textStyle17, (i12 & 131072) != 0 ? dSTypography2.dsHeadingMedium : textStyle18, (i12 & 262144) != 0 ? dSTypography2.dsSubheadingLarge : textStyle19, (i12 & 524288) != 0 ? dSTypography2.dsSubheadingMedium : textStyle20, (i12 & 1048576) != 0 ? dSTypography2.dsSubheadingSmall : textStyle21, (i12 & 2097152) != 0 ? dSTypography2.dsSubheadingXSmall : textStyle22, (i12 & 4194304) != 0 ? dSTypography2.dsBodyMedium : textStyle23, (i12 & 8388608) != 0 ? dSTypography2.dsBodyMediumCompact : textStyle24, (i12 & 16777216) != 0 ? dSTypography2.dsBodySmall : textStyle25, (i12 & 33554432) != 0 ? dSTypography2.dsBodySmallCompact : textStyle26, (i12 & 67108864) != 0 ? dSTypography2.dsBodyXSmall : textStyle27, (i12 & C.BUFFER_FLAG_FIRST_SAMPLE) != 0 ? dSTypography2.dsLinkMedium : textStyle28, (i12 & 268435456) != 0 ? dSTypography2.dsLinkMediumCompact : textStyle29, (i12 & 536870912) != 0 ? dSTypography2.dsLinkSmall : textStyle30, (i12 & 1073741824) != 0 ? dSTypography2.dsLinkXSmall : textStyle31);
    }

    @NotNull
    public final TextStyle component1() {
        return this.dsHeading0;
    }

    @NotNull
    public final TextStyle component10() {
        return this.dsBody1Compact;
    }

    @NotNull
    public final TextStyle component11() {
        return this.dsLink;
    }

    @NotNull
    public final TextStyle component12() {
        return this.dsButton;
    }

    @NotNull
    public final TextStyle component13() {
        return this.dsCaption;
    }

    @NotNull
    public final TextStyle component14() {
        return this.dsTag;
    }

    @NotNull
    public final TextStyle component15() {
        return this.dsHeadingXXLarge;
    }

    @NotNull
    public final TextStyle component16() {
        return this.dsHeadingXLarge;
    }

    @NotNull
    public final TextStyle component17() {
        return this.dsHeadingLarge;
    }

    @NotNull
    public final TextStyle component18() {
        return this.dsHeadingMedium;
    }

    @NotNull
    public final TextStyle component19() {
        return this.dsSubheadingLarge;
    }

    @NotNull
    public final TextStyle component2() {
        return this.dsHeading1;
    }

    @NotNull
    public final TextStyle component20() {
        return this.dsSubheadingMedium;
    }

    @NotNull
    public final TextStyle component21() {
        return this.dsSubheadingSmall;
    }

    @NotNull
    public final TextStyle component22() {
        return this.dsSubheadingXSmall;
    }

    @NotNull
    public final TextStyle component23() {
        return this.dsBodyMedium;
    }

    @NotNull
    public final TextStyle component24() {
        return this.dsBodyMediumCompact;
    }

    @NotNull
    public final TextStyle component25() {
        return this.dsBodySmall;
    }

    @NotNull
    public final TextStyle component26() {
        return this.dsBodySmallCompact;
    }

    @NotNull
    public final TextStyle component27() {
        return this.dsBodyXSmall;
    }

    @NotNull
    public final TextStyle component28() {
        return this.dsLinkMedium;
    }

    @NotNull
    public final TextStyle component29() {
        return this.dsLinkMediumCompact;
    }

    @NotNull
    public final TextStyle component3() {
        return this.dsHeading2;
    }

    @NotNull
    public final TextStyle component30() {
        return this.dsLinkSmall;
    }

    @NotNull
    public final TextStyle component31() {
        return this.dsLinkXSmall;
    }

    @NotNull
    public final TextStyle component4() {
        return this.dsSubheading1;
    }

    @NotNull
    public final TextStyle component5() {
        return this.dsSubheading2;
    }

    @NotNull
    public final TextStyle component6() {
        return this.dsBody0;
    }

    @NotNull
    public final TextStyle component7() {
        return this.dsBody0Bold;
    }

    @NotNull
    public final TextStyle component8() {
        return this.dsBody1;
    }

    @NotNull
    public final TextStyle component9() {
        return this.dsBody1Bold;
    }

    @NotNull
    public final DSTypography copy(@NotNull TextStyle textStyle, @NotNull TextStyle textStyle2, @NotNull TextStyle textStyle3, @NotNull TextStyle textStyle4, @NotNull TextStyle textStyle5, @NotNull TextStyle textStyle6, @NotNull TextStyle textStyle7, @NotNull TextStyle textStyle8, @NotNull TextStyle textStyle9, @NotNull TextStyle textStyle10, @NotNull TextStyle textStyle11, @NotNull TextStyle textStyle12, @NotNull TextStyle textStyle13, @NotNull TextStyle textStyle14, @NotNull TextStyle textStyle15, @NotNull TextStyle textStyle16, @NotNull TextStyle textStyle17, @NotNull TextStyle textStyle18, @NotNull TextStyle textStyle19, @NotNull TextStyle textStyle20, @NotNull TextStyle textStyle21, @NotNull TextStyle textStyle22, @NotNull TextStyle textStyle23, @NotNull TextStyle textStyle24, @NotNull TextStyle textStyle25, @NotNull TextStyle textStyle26, @NotNull TextStyle textStyle27, @NotNull TextStyle textStyle28, @NotNull TextStyle textStyle29, @NotNull TextStyle textStyle30, @NotNull TextStyle textStyle31) {
        TextStyle textStyle32 = textStyle;
        Intrinsics.checkNotNullParameter(textStyle32, "dsHeading0");
        Intrinsics.checkNotNullParameter(textStyle2, "dsHeading1");
        Intrinsics.checkNotNullParameter(textStyle3, "dsHeading2");
        Intrinsics.checkNotNullParameter(textStyle4, "dsSubheading1");
        Intrinsics.checkNotNullParameter(textStyle5, "dsSubheading2");
        Intrinsics.checkNotNullParameter(textStyle6, "dsBody0");
        Intrinsics.checkNotNullParameter(textStyle7, "dsBody0Bold");
        Intrinsics.checkNotNullParameter(textStyle8, "dsBody1");
        Intrinsics.checkNotNullParameter(textStyle9, "dsBody1Bold");
        Intrinsics.checkNotNullParameter(textStyle10, "dsBody1Compact");
        Intrinsics.checkNotNullParameter(textStyle11, "dsLink");
        Intrinsics.checkNotNullParameter(textStyle12, "dsButton");
        Intrinsics.checkNotNullParameter(textStyle13, "dsCaption");
        Intrinsics.checkNotNullParameter(textStyle14, "dsTag");
        Intrinsics.checkNotNullParameter(textStyle15, "dsHeadingXXLarge");
        Intrinsics.checkNotNullParameter(textStyle16, "dsHeadingXLarge");
        Intrinsics.checkNotNullParameter(textStyle17, "dsHeadingLarge");
        Intrinsics.checkNotNullParameter(textStyle18, "dsHeadingMedium");
        Intrinsics.checkNotNullParameter(textStyle19, "dsSubheadingLarge");
        Intrinsics.checkNotNullParameter(textStyle20, "dsSubheadingMedium");
        Intrinsics.checkNotNullParameter(textStyle21, "dsSubheadingSmall");
        Intrinsics.checkNotNullParameter(textStyle22, "dsSubheadingXSmall");
        Intrinsics.checkNotNullParameter(textStyle23, "dsBodyMedium");
        Intrinsics.checkNotNullParameter(textStyle24, "dsBodyMediumCompact");
        Intrinsics.checkNotNullParameter(textStyle25, "dsBodySmall");
        Intrinsics.checkNotNullParameter(textStyle26, "dsBodySmallCompact");
        Intrinsics.checkNotNullParameter(textStyle27, "dsBodyXSmall");
        Intrinsics.checkNotNullParameter(textStyle28, "dsLinkMedium");
        Intrinsics.checkNotNullParameter(textStyle29, "dsLinkMediumCompact");
        Intrinsics.checkNotNullParameter(textStyle30, "dsLinkSmall");
        Intrinsics.checkNotNullParameter(textStyle31, "dsLinkXSmall");
        return new DSTypography(textStyle32, textStyle2, textStyle3, textStyle4, textStyle5, textStyle6, textStyle7, textStyle8, textStyle9, textStyle10, textStyle11, textStyle12, textStyle13, textStyle14, textStyle15, textStyle16, textStyle17, textStyle18, textStyle19, textStyle20, textStyle21, textStyle22, textStyle23, textStyle24, textStyle25, textStyle26, textStyle27, textStyle28, textStyle29, textStyle30, textStyle31);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DSTypography)) {
            return false;
        }
        DSTypography dSTypography = (DSTypography) obj;
        return Intrinsics.areEqual((Object) this.dsHeading0, (Object) dSTypography.dsHeading0) && Intrinsics.areEqual((Object) this.dsHeading1, (Object) dSTypography.dsHeading1) && Intrinsics.areEqual((Object) this.dsHeading2, (Object) dSTypography.dsHeading2) && Intrinsics.areEqual((Object) this.dsSubheading1, (Object) dSTypography.dsSubheading1) && Intrinsics.areEqual((Object) this.dsSubheading2, (Object) dSTypography.dsSubheading2) && Intrinsics.areEqual((Object) this.dsBody0, (Object) dSTypography.dsBody0) && Intrinsics.areEqual((Object) this.dsBody0Bold, (Object) dSTypography.dsBody0Bold) && Intrinsics.areEqual((Object) this.dsBody1, (Object) dSTypography.dsBody1) && Intrinsics.areEqual((Object) this.dsBody1Bold, (Object) dSTypography.dsBody1Bold) && Intrinsics.areEqual((Object) this.dsBody1Compact, (Object) dSTypography.dsBody1Compact) && Intrinsics.areEqual((Object) this.dsLink, (Object) dSTypography.dsLink) && Intrinsics.areEqual((Object) this.dsButton, (Object) dSTypography.dsButton) && Intrinsics.areEqual((Object) this.dsCaption, (Object) dSTypography.dsCaption) && Intrinsics.areEqual((Object) this.dsTag, (Object) dSTypography.dsTag) && Intrinsics.areEqual((Object) this.dsHeadingXXLarge, (Object) dSTypography.dsHeadingXXLarge) && Intrinsics.areEqual((Object) this.dsHeadingXLarge, (Object) dSTypography.dsHeadingXLarge) && Intrinsics.areEqual((Object) this.dsHeadingLarge, (Object) dSTypography.dsHeadingLarge) && Intrinsics.areEqual((Object) this.dsHeadingMedium, (Object) dSTypography.dsHeadingMedium) && Intrinsics.areEqual((Object) this.dsSubheadingLarge, (Object) dSTypography.dsSubheadingLarge) && Intrinsics.areEqual((Object) this.dsSubheadingMedium, (Object) dSTypography.dsSubheadingMedium) && Intrinsics.areEqual((Object) this.dsSubheadingSmall, (Object) dSTypography.dsSubheadingSmall) && Intrinsics.areEqual((Object) this.dsSubheadingXSmall, (Object) dSTypography.dsSubheadingXSmall) && Intrinsics.areEqual((Object) this.dsBodyMedium, (Object) dSTypography.dsBodyMedium) && Intrinsics.areEqual((Object) this.dsBodyMediumCompact, (Object) dSTypography.dsBodyMediumCompact) && Intrinsics.areEqual((Object) this.dsBodySmall, (Object) dSTypography.dsBodySmall) && Intrinsics.areEqual((Object) this.dsBodySmallCompact, (Object) dSTypography.dsBodySmallCompact) && Intrinsics.areEqual((Object) this.dsBodyXSmall, (Object) dSTypography.dsBodyXSmall) && Intrinsics.areEqual((Object) this.dsLinkMedium, (Object) dSTypography.dsLinkMedium) && Intrinsics.areEqual((Object) this.dsLinkMediumCompact, (Object) dSTypography.dsLinkMediumCompact) && Intrinsics.areEqual((Object) this.dsLinkSmall, (Object) dSTypography.dsLinkSmall) && Intrinsics.areEqual((Object) this.dsLinkXSmall, (Object) dSTypography.dsLinkXSmall);
    }

    @NotNull
    public final TextStyle getDsBody0() {
        return this.dsBody0;
    }

    @NotNull
    public final TextStyle getDsBody0Bold() {
        return this.dsBody0Bold;
    }

    @NotNull
    public final TextStyle getDsBody1() {
        return this.dsBody1;
    }

    @NotNull
    public final TextStyle getDsBody1Bold() {
        return this.dsBody1Bold;
    }

    @NotNull
    public final TextStyle getDsBody1Compact() {
        return this.dsBody1Compact;
    }

    @NotNull
    public final TextStyle getDsBodyMedium() {
        return this.dsBodyMedium;
    }

    @NotNull
    public final TextStyle getDsBodyMediumCompact() {
        return this.dsBodyMediumCompact;
    }

    @NotNull
    public final TextStyle getDsBodySmall() {
        return this.dsBodySmall;
    }

    @NotNull
    public final TextStyle getDsBodySmallCompact() {
        return this.dsBodySmallCompact;
    }

    @NotNull
    public final TextStyle getDsBodyXSmall() {
        return this.dsBodyXSmall;
    }

    @NotNull
    public final TextStyle getDsButton() {
        return this.dsButton;
    }

    @NotNull
    public final TextStyle getDsCaption() {
        return this.dsCaption;
    }

    @NotNull
    public final TextStyle getDsHeading0() {
        return this.dsHeading0;
    }

    @NotNull
    public final TextStyle getDsHeading1() {
        return this.dsHeading1;
    }

    @NotNull
    public final TextStyle getDsHeading2() {
        return this.dsHeading2;
    }

    @NotNull
    public final TextStyle getDsHeadingLarge() {
        return this.dsHeadingLarge;
    }

    @NotNull
    public final TextStyle getDsHeadingMedium() {
        return this.dsHeadingMedium;
    }

    @NotNull
    public final TextStyle getDsHeadingXLarge() {
        return this.dsHeadingXLarge;
    }

    @NotNull
    public final TextStyle getDsHeadingXXLarge() {
        return this.dsHeadingXXLarge;
    }

    @NotNull
    public final TextStyle getDsLink() {
        return this.dsLink;
    }

    @NotNull
    public final TextStyle getDsLinkMedium() {
        return this.dsLinkMedium;
    }

    @NotNull
    public final TextStyle getDsLinkMediumCompact() {
        return this.dsLinkMediumCompact;
    }

    @NotNull
    public final TextStyle getDsLinkSmall() {
        return this.dsLinkSmall;
    }

    @NotNull
    public final TextStyle getDsLinkXSmall() {
        return this.dsLinkXSmall;
    }

    @NotNull
    public final TextStyle getDsSubheading1() {
        return this.dsSubheading1;
    }

    @NotNull
    public final TextStyle getDsSubheading2() {
        return this.dsSubheading2;
    }

    @NotNull
    public final TextStyle getDsSubheadingLarge() {
        return this.dsSubheadingLarge;
    }

    @NotNull
    public final TextStyle getDsSubheadingMedium() {
        return this.dsSubheadingMedium;
    }

    @NotNull
    public final TextStyle getDsSubheadingSmall() {
        return this.dsSubheadingSmall;
    }

    @NotNull
    public final TextStyle getDsSubheadingXSmall() {
        return this.dsSubheadingXSmall;
    }

    @NotNull
    public final TextStyle getDsTag() {
        return this.dsTag;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.dsHeading0.hashCode() * 31) + this.dsHeading1.hashCode()) * 31) + this.dsHeading2.hashCode()) * 31) + this.dsSubheading1.hashCode()) * 31) + this.dsSubheading2.hashCode()) * 31) + this.dsBody0.hashCode()) * 31) + this.dsBody0Bold.hashCode()) * 31) + this.dsBody1.hashCode()) * 31) + this.dsBody1Bold.hashCode()) * 31) + this.dsBody1Compact.hashCode()) * 31) + this.dsLink.hashCode()) * 31) + this.dsButton.hashCode()) * 31) + this.dsCaption.hashCode()) * 31) + this.dsTag.hashCode()) * 31) + this.dsHeadingXXLarge.hashCode()) * 31) + this.dsHeadingXLarge.hashCode()) * 31) + this.dsHeadingLarge.hashCode()) * 31) + this.dsHeadingMedium.hashCode()) * 31) + this.dsSubheadingLarge.hashCode()) * 31) + this.dsSubheadingMedium.hashCode()) * 31) + this.dsSubheadingSmall.hashCode()) * 31) + this.dsSubheadingXSmall.hashCode()) * 31) + this.dsBodyMedium.hashCode()) * 31) + this.dsBodyMediumCompact.hashCode()) * 31) + this.dsBodySmall.hashCode()) * 31) + this.dsBodySmallCompact.hashCode()) * 31) + this.dsBodyXSmall.hashCode()) * 31) + this.dsLinkMedium.hashCode()) * 31) + this.dsLinkMediumCompact.hashCode()) * 31) + this.dsLinkSmall.hashCode()) * 31) + this.dsLinkXSmall.hashCode();
    }

    @NotNull
    public String toString() {
        return "DSTypography(dsHeading0=" + this.dsHeading0 + ", dsHeading1=" + this.dsHeading1 + ", dsHeading2=" + this.dsHeading2 + ", dsSubheading1=" + this.dsSubheading1 + ", dsSubheading2=" + this.dsSubheading2 + ", dsBody0=" + this.dsBody0 + ", dsBody0Bold=" + this.dsBody0Bold + ", dsBody1=" + this.dsBody1 + ", dsBody1Bold=" + this.dsBody1Bold + ", dsBody1Compact=" + this.dsBody1Compact + ", dsLink=" + this.dsLink + ", dsButton=" + this.dsButton + ", dsCaption=" + this.dsCaption + ", dsTag=" + this.dsTag + ", dsHeadingXXLarge=" + this.dsHeadingXXLarge + ", dsHeadingXLarge=" + this.dsHeadingXLarge + ", dsHeadingLarge=" + this.dsHeadingLarge + ", dsHeadingMedium=" + this.dsHeadingMedium + ", dsSubheadingLarge=" + this.dsSubheadingLarge + ", dsSubheadingMedium=" + this.dsSubheadingMedium + ", dsSubheadingSmall=" + this.dsSubheadingSmall + ", dsSubheadingXSmall=" + this.dsSubheadingXSmall + ", dsBodyMedium=" + this.dsBodyMedium + ", dsBodyMediumCompact=" + this.dsBodyMediumCompact + ", dsBodySmall=" + this.dsBodySmall + ", dsBodySmallCompact=" + this.dsBodySmallCompact + ", dsBodyXSmall=" + this.dsBodyXSmall + ", dsLinkMedium=" + this.dsLinkMedium + ", dsLinkMediumCompact=" + this.dsLinkMediumCompact + ", dsLinkSmall=" + this.dsLinkSmall + ", dsLinkXSmall=" + this.dsLinkXSmall + ')';
    }
}
