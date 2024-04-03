package com.talabat.fluid.theme;

import com.deliveryhero.fluid.expression.reference.providers.ValueProvider;
import com.deliveryhero.fluid.widgets.text.ResourceTextStyle;
import com.deliveryhero.fluid.widgets.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0011\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/talabat/fluid/theme/MarshmallowFontProvider;", "Lcom/deliveryhero/fluid/expression/reference/providers/ValueProvider;", "Lcom/deliveryhero/fluid/widgets/text/TextStyle;", "base", "(Lcom/deliveryhero/fluid/expression/reference/providers/ValueProvider;)V", "toTextStyleToken", "Lcom/deliveryhero/fluid/widgets/text/ResourceTextStyle;", "", "getToTextStyleToken", "(Ljava/lang/String;)Lcom/deliveryhero/fluid/widgets/text/ResourceTextStyle;", "get", "name", "com_talabat_ThirdPartyLibs_Fluid_Fluid"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MarshmallowFontProvider implements ValueProvider<TextStyle> {
    @NotNull
    private final ValueProvider<TextStyle> base;

    public MarshmallowFontProvider(@NotNull ValueProvider<TextStyle> valueProvider) {
        Intrinsics.checkNotNullParameter(valueProvider, TtmlNode.RUBY_BASE);
        this.base = valueProvider;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0062, code lost:
        if (r3.equals("body2") == false) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
        r3 = java.lang.Integer.valueOf(com.designsystem.marshmallow.R.style.DSTextAppearance_Caption);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0116, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0117, code lost:
        if (r3 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return new com.deliveryhero.fluid.widgets.text.ResourceTextStyle(r3.intValue());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        if (r3.equals(com.facebook.share.internal.ShareConstants.FEED_CAPTION_PARAM) == false) goto L_0x0116;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.deliveryhero.fluid.widgets.text.ResourceTextStyle getToTextStyleToken(java.lang.String r3) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            r1 = 0
            switch(r0) {
                case -2144542380: goto L_0x0106;
                case -2077740602: goto L_0x00f6;
                case -1377687758: goto L_0x00e6;
                case -1115143570: goto L_0x00d6;
                case -1115143569: goto L_0x00c6;
                case -1115143568: goto L_0x00b6;
                case 114586: goto L_0x00a4;
                case 3321850: goto L_0x0092;
                case 93911758: goto L_0x0080;
                case 93911759: goto L_0x006e;
                case 93911760: goto L_0x005c;
                case 134725807: goto L_0x004a;
                case 134725808: goto L_0x0038;
                case 552573414: goto L_0x002e;
                case 1208128115: goto L_0x001c;
                case 1209051636: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0116
        L_0x000a:
            java.lang.String r0 = "body1Bold"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0014
            goto L_0x0116
        L_0x0014:
            int r3 = com.designsystem.marshmallow.R.style.DSTextAppearance_Body1Bold
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0117
        L_0x001c:
            java.lang.String r0 = "body0Bold"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0026
            goto L_0x0116
        L_0x0026:
            int r3 = com.designsystem.marshmallow.R.style.DSTextAppearance_Body0Bold
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0117
        L_0x002e:
            java.lang.String r0 = "caption"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0066
            goto L_0x0116
        L_0x0038:
            java.lang.String r0 = "subheading2"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0042
            goto L_0x0116
        L_0x0042:
            int r3 = com.designsystem.marshmallow.R.style.DSTextAppearance_Subheading2
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0117
        L_0x004a:
            java.lang.String r0 = "subheading1"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0054
            goto L_0x0116
        L_0x0054:
            int r3 = com.designsystem.marshmallow.R.style.DSTextAppearance_Subheading1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0117
        L_0x005c:
            java.lang.String r0 = "body2"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0066
            goto L_0x0116
        L_0x0066:
            int r3 = com.designsystem.marshmallow.R.style.DSTextAppearance_Caption
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0117
        L_0x006e:
            java.lang.String r0 = "body1"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0078
            goto L_0x0116
        L_0x0078:
            int r3 = com.designsystem.marshmallow.R.style.DSTextAppearance_Body1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0117
        L_0x0080:
            java.lang.String r0 = "body0"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x008a
            goto L_0x0116
        L_0x008a:
            int r3 = com.designsystem.marshmallow.R.style.DSTextAppearance_Body0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0117
        L_0x0092:
            java.lang.String r0 = "link"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x009c
            goto L_0x0116
        L_0x009c:
            int r3 = com.designsystem.marshmallow.R.style.DSTextAppearance_Link
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0117
        L_0x00a4:
            java.lang.String r0 = "tag"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x00ae
            goto L_0x0116
        L_0x00ae:
            int r3 = com.designsystem.marshmallow.R.style.DSTextAppearance_Tag
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0117
        L_0x00b6:
            java.lang.String r0 = "heading2"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x00bf
            goto L_0x0116
        L_0x00bf:
            int r3 = com.designsystem.marshmallow.R.style.DSTextAppearance_Heading2
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0117
        L_0x00c6:
            java.lang.String r0 = "heading1"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x00cf
            goto L_0x0116
        L_0x00cf:
            int r3 = com.designsystem.marshmallow.R.style.DSTextAppearance_Heading1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0117
        L_0x00d6:
            java.lang.String r0 = "heading0"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x00df
            goto L_0x0116
        L_0x00df:
            int r3 = com.designsystem.marshmallow.R.style.DSTextAppearance_Heading0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0117
        L_0x00e6:
            java.lang.String r0 = "button"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x00ef
            goto L_0x0116
        L_0x00ef:
            int r3 = com.designsystem.marshmallow.R.style.DSTextAppearance_Button
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0117
        L_0x00f6:
            java.lang.String r0 = "Caption"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x00ff
            goto L_0x0116
        L_0x00ff:
            int r3 = com.designsystem.marshmallow.R.style.DSTextAppearance_Caption
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0117
        L_0x0106:
            java.lang.String r0 = "body1Compact"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x010f
            goto L_0x0116
        L_0x010f:
            int r3 = com.designsystem.marshmallow.R.style.DSTextAppearance_Body1Compact
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x0117
        L_0x0116:
            r3 = r1
        L_0x0117:
            if (r3 == 0) goto L_0x0122
            int r3 = r3.intValue()
            com.deliveryhero.fluid.widgets.text.ResourceTextStyle r1 = new com.deliveryhero.fluid.widgets.text.ResourceTextStyle
            r1.<init>(r3)
        L_0x0122:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.theme.MarshmallowFontProvider.getToTextStyleToken(java.lang.String):com.deliveryhero.fluid.widgets.text.ResourceTextStyle");
    }

    @NotNull
    public TextStyle get(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        ResourceTextStyle toTextStyleToken = getToTextStyleToken(str);
        return toTextStyleToken != null ? toTextStyleToken : this.base.get(str);
    }
}
