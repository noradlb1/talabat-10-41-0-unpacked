package com.designsystem.ds_text_link;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.text.TextStyle;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/designsystem/ds_text_link/DSTextLinkText;", "", "text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "AlternativeLink", "Link", "Normal", "Lcom/designsystem/ds_text_link/DSTextLinkText$Normal;", "Lcom/designsystem/ds_text_link/DSTextLinkText$Link;", "Lcom/designsystem/ds_text_link/DSTextLinkText$AlternativeLink;", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class DSTextLinkText {
    public static final int $stable = 0;
    @NotNull
    private final String text;

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u0011\u001a\u00020\u0012H\u0017ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J-\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\fR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"Lcom/designsystem/ds_text_link/DSTextLinkText$AlternativeLink;", "Lcom/designsystem/ds_text_link/DSTextLinkText;", "Lcom/designsystem/ds_text_link/Tappable;", "Lcom/designsystem/ds_text_link/Colored;", "text", "", "isEnabled", "", "onTap", "Lkotlin/Function0;", "", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "()Z", "getOnTap", "()Lkotlin/jvm/functions/Function0;", "getText", "()Ljava/lang/String;", "color", "Landroidx/compose/ui/graphics/Color;", "color-WaAFU9c", "(Landroidx/compose/runtime/Composer;I)J", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class AlternativeLink extends DSTextLinkText implements Tappable, Colored {
        public static final int $stable = 0;
        private final boolean isEnabled;
        @NotNull
        private final Function0<Unit> onTap;
        @NotNull
        private final String text;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ AlternativeLink(String str, boolean z11, Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i11 & 2) != 0 ? true : z11, function0);
        }

        public static /* synthetic */ AlternativeLink copy$default(AlternativeLink alternativeLink, String str, boolean z11, Function0<Unit> function0, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = alternativeLink.getText();
            }
            if ((i11 & 2) != 0) {
                z11 = alternativeLink.isEnabled();
            }
            if ((i11 & 4) != 0) {
                function0 = alternativeLink.getOnTap();
            }
            return alternativeLink.copy(str, z11, function0);
        }

        @Composable
        /* renamed from: color-WaAFU9c  reason: not valid java name */
        public long m8638colorWaAFU9c(@Nullable Composer composer, int i11) {
            composer.startReplaceableGroup(-2068812736);
            long r02 = DSTextLinkDefaults.INSTANCE.alternativeTextLinkTheme(composer, 0).color(isEnabled(), composer, 0).getValue().m2929unboximpl();
            composer.endReplaceableGroup();
            return r02;
        }

        @NotNull
        public final String component1() {
            return getText();
        }

        public final boolean component2() {
            return isEnabled();
        }

        @NotNull
        public final Function0<Unit> component3() {
            return getOnTap();
        }

        @NotNull
        public final AlternativeLink copy(@NotNull String str, boolean z11, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(function0, "onTap");
            return new AlternativeLink(str, z11, function0);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AlternativeLink)) {
                return false;
            }
            AlternativeLink alternativeLink = (AlternativeLink) obj;
            return Intrinsics.areEqual((Object) getText(), (Object) alternativeLink.getText()) && isEnabled() == alternativeLink.isEnabled() && Intrinsics.areEqual((Object) getOnTap(), (Object) alternativeLink.getOnTap());
        }

        @NotNull
        public Function0<Unit> getOnTap() {
            return this.onTap;
        }

        @NotNull
        public String getText() {
            return this.text;
        }

        public int hashCode() {
            int hashCode = getText().hashCode() * 31;
            boolean isEnabled2 = isEnabled();
            if (isEnabled2) {
                isEnabled2 = true;
            }
            return ((hashCode + (isEnabled2 ? 1 : 0)) * 31) + getOnTap().hashCode();
        }

        public boolean isEnabled() {
            return this.isEnabled;
        }

        @NotNull
        public String toString() {
            return "AlternativeLink(text=" + getText() + ", isEnabled=" + isEnabled() + ", onTap=" + getOnTap() + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AlternativeLink(@NotNull String str, boolean z11, @NotNull Function0<Unit> function0) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(function0, "onTap");
            this.text = str;
            this.isEnabled = z11;
            this.onTap = function0;
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u0011\u001a\u00020\u0012H\u0017ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J-\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\fR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006\u001f"}, d2 = {"Lcom/designsystem/ds_text_link/DSTextLinkText$Link;", "Lcom/designsystem/ds_text_link/DSTextLinkText;", "Lcom/designsystem/ds_text_link/Tappable;", "Lcom/designsystem/ds_text_link/Colored;", "text", "", "isEnabled", "", "onTap", "Lkotlin/Function0;", "", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;)V", "()Z", "getOnTap", "()Lkotlin/jvm/functions/Function0;", "getText", "()Ljava/lang/String;", "color", "Landroidx/compose/ui/graphics/Color;", "color-WaAFU9c", "(Landroidx/compose/runtime/Composer;I)J", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Link extends DSTextLinkText implements Tappable, Colored {
        public static final int $stable = 0;
        private final boolean isEnabled;
        @NotNull
        private final Function0<Unit> onTap;
        @NotNull
        private final String text;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Link(String str, boolean z11, Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i11 & 2) != 0 ? true : z11, function0);
        }

        public static /* synthetic */ Link copy$default(Link link, String str, boolean z11, Function0<Unit> function0, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = link.getText();
            }
            if ((i11 & 2) != 0) {
                z11 = link.isEnabled();
            }
            if ((i11 & 4) != 0) {
                function0 = link.getOnTap();
            }
            return link.copy(str, z11, function0);
        }

        @Composable
        /* renamed from: color-WaAFU9c  reason: not valid java name */
        public long m8639colorWaAFU9c(@Nullable Composer composer, int i11) {
            composer.startReplaceableGroup(-2068483115);
            long r02 = DSTextLinkDefaults.INSTANCE.textLinkTheme(composer, 0).color(isEnabled(), composer, 0).getValue().m2929unboximpl();
            composer.endReplaceableGroup();
            return r02;
        }

        @NotNull
        public final String component1() {
            return getText();
        }

        public final boolean component2() {
            return isEnabled();
        }

        @NotNull
        public final Function0<Unit> component3() {
            return getOnTap();
        }

        @NotNull
        public final Link copy(@NotNull String str, boolean z11, @NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(function0, "onTap");
            return new Link(str, z11, function0);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Link)) {
                return false;
            }
            Link link = (Link) obj;
            return Intrinsics.areEqual((Object) getText(), (Object) link.getText()) && isEnabled() == link.isEnabled() && Intrinsics.areEqual((Object) getOnTap(), (Object) link.getOnTap());
        }

        @NotNull
        public Function0<Unit> getOnTap() {
            return this.onTap;
        }

        @NotNull
        public String getText() {
            return this.text;
        }

        public int hashCode() {
            int hashCode = getText().hashCode() * 31;
            boolean isEnabled2 = isEnabled();
            if (isEnabled2) {
                isEnabled2 = true;
            }
            return ((hashCode + (isEnabled2 ? 1 : 0)) * 31) + getOnTap().hashCode();
        }

        public boolean isEnabled() {
            return this.isEnabled;
        }

        @NotNull
        public String toString() {
            return "Link(text=" + getText() + ", isEnabled=" + isEnabled() + ", onTap=" + getOnTap() + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Link(@NotNull String str, boolean z11, @NotNull Function0<Unit> function0) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(function0, "onTap");
            this.text = str;
            this.isEnabled = z11;
            this.onTap = function0;
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0014J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/designsystem/ds_text_link/DSTextLinkText$Normal;", "Lcom/designsystem/ds_text_link/DSTextLinkText;", "text", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "(Ljava/lang/String;Landroidx/compose/ui/text/TextStyle;)V", "getText", "()Ljava/lang/String;", "getTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextStyle;", "toString", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Normal extends DSTextLinkText {
        public static final int $stable = 0;
        @NotNull
        private final String text;
        @Nullable
        private final TextStyle textStyle;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Normal(String str, TextStyle textStyle2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i11 & 2) != 0 ? null : textStyle2);
        }

        public static /* synthetic */ Normal copy$default(Normal normal, String str, TextStyle textStyle2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = normal.getText();
            }
            if ((i11 & 2) != 0) {
                textStyle2 = normal.textStyle;
            }
            return normal.copy(str, textStyle2);
        }

        @NotNull
        public final String component1() {
            return getText();
        }

        @Nullable
        public final TextStyle component2() {
            return this.textStyle;
        }

        @NotNull
        public final Normal copy(@NotNull String str, @Nullable TextStyle textStyle2) {
            Intrinsics.checkNotNullParameter(str, "text");
            return new Normal(str, textStyle2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Normal)) {
                return false;
            }
            Normal normal = (Normal) obj;
            return Intrinsics.areEqual((Object) getText(), (Object) normal.getText()) && Intrinsics.areEqual((Object) this.textStyle, (Object) normal.textStyle);
        }

        @NotNull
        public String getText() {
            return this.text;
        }

        @Nullable
        public final TextStyle getTextStyle() {
            return this.textStyle;
        }

        public int hashCode() {
            int hashCode = getText().hashCode() * 31;
            TextStyle textStyle2 = this.textStyle;
            return hashCode + (textStyle2 == null ? 0 : textStyle2.hashCode());
        }

        @NotNull
        @Composable
        public final TextStyle textStyle(@Nullable Composer composer, int i11) {
            composer.startReplaceableGroup(-2117598899);
            TextStyle textStyle2 = this.textStyle;
            if (textStyle2 == null) {
                composer.startReplaceableGroup(-2117598849);
                textStyle2 = DSTheme.INSTANCE.getTypography(composer, 0).getDsBody1();
            } else {
                composer.startReplaceableGroup(-2117598881);
            }
            composer.endReplaceableGroup();
            composer.endReplaceableGroup();
            return textStyle2;
        }

        @NotNull
        public String toString() {
            return "Normal(text=" + getText() + ", textStyle=" + this.textStyle + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Normal(@NotNull String str, @Nullable TextStyle textStyle2) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "text");
            this.text = str;
            this.textStyle = textStyle2;
        }
    }

    private DSTextLinkText(String str) {
        this.text = str;
    }

    public /* synthetic */ DSTextLinkText(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    @NotNull
    public String getText() {
        return this.text;
    }
}
