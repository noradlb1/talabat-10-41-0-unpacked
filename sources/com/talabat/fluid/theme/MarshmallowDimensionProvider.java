package com.talabat.fluid.theme;

import android.content.Context;
import com.deliveryhero.fluid.expression.reference.providers.ValueProvider;
import com.deliveryhero.fluid.values.LogicalPixel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u0002*\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/talabat/fluid/theme/MarshmallowDimensionProvider;", "Lcom/deliveryhero/fluid/expression/reference/providers/ValueProvider;", "Lcom/deliveryhero/fluid/values/LogicalPixel;", "context", "Landroid/content/Context;", "base", "(Landroid/content/Context;Lcom/deliveryhero/fluid/expression/reference/providers/ValueProvider;)V", "toDimensionToken", "", "getToDimensionToken", "(Ljava/lang/String;)Lcom/deliveryhero/fluid/values/LogicalPixel;", "get", "name", "com_talabat_ThirdPartyLibs_Fluid_Fluid"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MarshmallowDimensionProvider implements ValueProvider<LogicalPixel> {
    @NotNull
    private final ValueProvider<LogicalPixel> base;
    @NotNull
    private final Context context;

    public MarshmallowDimensionProvider(@NotNull Context context2, @NotNull ValueProvider<LogicalPixel> valueProvider) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(valueProvider, TtmlNode.RUBY_BASE);
        this.context = context2;
        this.base = valueProvider;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.deliveryhero.fluid.values.LogicalPixel getToDimensionToken(java.lang.String r3) {
        /*
            r2 = this;
            int r0 = r3.hashCode()
            r1 = 0
            switch(r0) {
                case 108: goto L_0x00a9;
                case 109: goto L_0x0099;
                case 115: goto L_0x0089;
                case 3828: goto L_0x0078;
                case 3835: goto L_0x0067;
                case 119148: goto L_0x0056;
                case 119155: goto L_0x0043;
                case 3694068: goto L_0x0030;
                case 3694075: goto L_0x001d;
                case 3735208: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x00b9
        L_0x000a:
            java.lang.String r0 = "zero"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0015
            goto L_0x00b9
        L_0x0015:
            int r3 = com.designsystem.marshmallow.R.dimen.ds_zero
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x00ba
        L_0x001d:
            java.lang.String r0 = "xxxs"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0028
            goto L_0x00b9
        L_0x0028:
            int r3 = com.designsystem.marshmallow.R.dimen.ds_xxxs
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x00ba
        L_0x0030:
            java.lang.String r0 = "xxxl"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x003b
            goto L_0x00b9
        L_0x003b:
            int r3 = com.designsystem.marshmallow.R.dimen.ds_xxxl
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x00ba
        L_0x0043:
            java.lang.String r0 = "xxs"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x004e
            goto L_0x00b9
        L_0x004e:
            int r3 = com.designsystem.marshmallow.R.dimen.ds_xxs
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x00ba
        L_0x0056:
            java.lang.String r0 = "xxl"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0060
            goto L_0x00b9
        L_0x0060:
            int r3 = com.designsystem.marshmallow.R.dimen.ds_xxl
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x00ba
        L_0x0067:
            java.lang.String r0 = "xs"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0071
            goto L_0x00b9
        L_0x0071:
            int r3 = com.designsystem.marshmallow.R.dimen.ds_xs
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x00ba
        L_0x0078:
            java.lang.String r0 = "xl"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0082
            goto L_0x00b9
        L_0x0082:
            int r3 = com.designsystem.marshmallow.R.dimen.ds_xl
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x00ba
        L_0x0089:
            java.lang.String r0 = "s"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x0092
            goto L_0x00b9
        L_0x0092:
            int r3 = com.designsystem.marshmallow.R.dimen.ds_s
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x00ba
        L_0x0099:
            java.lang.String r0 = "m"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x00a2
            goto L_0x00b9
        L_0x00a2:
            int r3 = com.designsystem.marshmallow.R.dimen.ds_m
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x00ba
        L_0x00a9:
            java.lang.String r0 = "l"
            boolean r3 = r3.equals(r0)
            if (r3 != 0) goto L_0x00b2
            goto L_0x00b9
        L_0x00b2:
            int r3 = com.designsystem.marshmallow.R.dimen.ds_l
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x00ba
        L_0x00b9:
            r3 = r1
        L_0x00ba:
            if (r3 == 0) goto L_0x00da
            int r3 = r3.intValue()
            android.content.Context r0 = r2.context
            android.content.res.Resources r1 = r0.getResources()
            float r3 = r1.getDimension(r3)
            com.deliveryhero.fluid.values.LogicalPixel r1 = new com.deliveryhero.fluid.values.LogicalPixel
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            float r0 = r0.density
            float r3 = r3 / r0
            r1.<init>((float) r3)
        L_0x00da:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.theme.MarshmallowDimensionProvider.getToDimensionToken(java.lang.String):com.deliveryhero.fluid.values.LogicalPixel");
    }

    @NotNull
    public LogicalPixel get(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        LogicalPixel toDimensionToken = getToDimensionToken(str);
        return toDimensionToken == null ? this.base.get(str) : toDimensionToken;
    }
}
