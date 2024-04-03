package com.talabat.fluid.theme;

import android.content.Context;
import com.deliveryhero.fluid.expression.reference.providers.ValueProvider;
import com.deliveryhero.fluid.widgets.image.ImageLocator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u0002*\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/talabat/fluid/theme/MarshmallowDrawableProvider;", "Lcom/deliveryhero/fluid/expression/reference/providers/ValueProvider;", "Lcom/deliveryhero/fluid/widgets/image/ImageLocator$Local;", "context", "Landroid/content/Context;", "base", "(Landroid/content/Context;Lcom/deliveryhero/fluid/expression/reference/providers/ValueProvider;)V", "toDrawableToken", "", "getToDrawableToken", "(Ljava/lang/String;)Lcom/deliveryhero/fluid/widgets/image/ImageLocator$Local;", "get", "name", "com_talabat_ThirdPartyLibs_Fluid_Fluid"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MarshmallowDrawableProvider implements ValueProvider<ImageLocator.Local> {
    @NotNull
    private final ValueProvider<ImageLocator.Local> base;
    @NotNull
    private final Context context;

    public MarshmallowDrawableProvider(@NotNull Context context2, @NotNull ValueProvider<ImageLocator.Local> valueProvider) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(valueProvider, TtmlNode.RUBY_BASE);
        this.context = context2;
        this.base = valueProvider;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.deliveryhero.fluid.widgets.image.ImageLocator.Local getToDrawableToken(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 0
            switch(r0) {
                case -2135490561: goto L_0x0ad4;
                case -2121515527: goto L_0x0ac4;
                case -2107585474: goto L_0x0ab4;
                case -2034800409: goto L_0x0aa4;
                case -1923491369: goto L_0x0a94;
                case -1917567863: goto L_0x0a84;
                case -1810149313: goto L_0x0a72;
                case -1718426098: goto L_0x0a60;
                case -1699275698: goto L_0x0a4e;
                case -1682325765: goto L_0x0a3c;
                case -1665818795: goto L_0x0a2a;
                case -1620218815: goto L_0x0a18;
                case -1572025121: goto L_0x0a06;
                case -1566054532: goto L_0x09f4;
                case -1556405954: goto L_0x09e2;
                case -1530312324: goto L_0x09d0;
                case -1468604053: goto L_0x09be;
                case -1387721937: goto L_0x09ac;
                case -1343343961: goto L_0x099a;
                case -1322919848: goto L_0x0988;
                case -1322919593: goto L_0x0976;
                case -1322909268: goto L_0x0964;
                case -1275642071: goto L_0x0952;
                case -1171897602: goto L_0x0940;
                case -1146998324: goto L_0x092e;
                case -1143201585: goto L_0x091c;
                case -857829019: goto L_0x090a;
                case -857164713: goto L_0x08f8;
                case -789711258: goto L_0x08e6;
                case -774041676: goto L_0x08d4;
                case -731661246: goto L_0x08c2;
                case -729799032: goto L_0x08b0;
                case -729798861: goto L_0x089e;
                case -718334645: goto L_0x088c;
                case -700165781: goto L_0x087a;
                case -693274167: goto L_0x0868;
                case -683481326: goto L_0x0856;
                case -636899499: goto L_0x0844;
                case -625839859: goto L_0x0832;
                case -620178248: goto L_0x0820;
                case -551157613: goto L_0x080e;
                case -534342909: goto L_0x07fc;
                case -530449219: goto L_0x07ea;
                case -518532882: goto L_0x07d8;
                case -464612909: goto L_0x07c6;
                case -438342002: goto L_0x07b4;
                case -377240214: goto L_0x07a2;
                case -363115224: goto L_0x0790;
                case -328867863: goto L_0x077e;
                case -322459283: goto L_0x076c;
                case -289697106: goto L_0x075a;
                case -271752080: goto L_0x0748;
                case -266177944: goto L_0x0736;
                case -186075974: goto L_0x0724;
                case -157478318: goto L_0x0712;
                case -137186668: goto L_0x0700;
                case -93424933: goto L_0x06ee;
                case -58910313: goto L_0x06dc;
                case -22949665: goto L_0x06ca;
                case -16248404: goto L_0x06b8;
                case -16118870: goto L_0x06a6;
                case -14521000: goto L_0x0694;
                case -14391736: goto L_0x0682;
                case -12528660: goto L_0x0670;
                case -8834645: goto L_0x065e;
                case -5246784: goto L_0x064c;
                case -2505282: goto L_0x063a;
                case -2207393: goto L_0x0628;
                case 251951: goto L_0x0616;
                case 5039960: goto L_0x0604;
                case 22056718: goto L_0x05f2;
                case 76920956: goto L_0x05e0;
                case 91301624: goto L_0x05ce;
                case 93251850: goto L_0x05bc;
                case 98871886: goto L_0x05aa;
                case 116184489: goto L_0x0598;
                case 156921974: goto L_0x0586;
                case 164222229: goto L_0x0574;
                case 222403321: goto L_0x0562;
                case 260185019: goto L_0x0550;
                case 342605913: goto L_0x053e;
                case 362699026: goto L_0x052c;
                case 432300244: goto L_0x051a;
                case 549482799: goto L_0x0508;
                case 596553155: goto L_0x04f6;
                case 597822112: goto L_0x04e4;
                case 629001039: goto L_0x04d2;
                case 641317042: goto L_0x04c0;
                case 676301030: goto L_0x04ae;
                case 685724278: goto L_0x049c;
                case 710582092: goto L_0x048a;
                case 725587813: goto L_0x0478;
                case 731701314: goto L_0x0466;
                case 759361866: goto L_0x0454;
                case 893305105: goto L_0x0442;
                case 894327323: goto L_0x0430;
                case 894400982: goto L_0x041e;
                case 913376923: goto L_0x040c;
                case 938877059: goto L_0x03fa;
                case 948195740: goto L_0x03e8;
                case 992397459: goto L_0x03d6;
                case 1007971272: goto L_0x03c4;
                case 1014136314: goto L_0x03b2;
                case 1065596911: goto L_0x03a0;
                case 1094422995: goto L_0x038e;
                case 1095954626: goto L_0x037c;
                case 1114428918: goto L_0x036a;
                case 1137571124: goto L_0x0358;
                case 1227477875: goto L_0x0346;
                case 1342800979: goto L_0x0334;
                case 1385172591: goto L_0x0322;
                case 1385406662: goto L_0x0310;
                case 1407080050: goto L_0x02fe;
                case 1420015178: goto L_0x02ec;
                case 1426389686: goto L_0x02da;
                case 1453200228: goto L_0x02c8;
                case 1488457863: goto L_0x02b6;
                case 1514868614: goto L_0x02a4;
                case 1543459122: goto L_0x0292;
                case 1559251021: goto L_0x0280;
                case 1560835429: goto L_0x026e;
                case 1568698387: goto L_0x025c;
                case 1582473134: goto L_0x024a;
                case 1596061971: goto L_0x0238;
                case 1610131972: goto L_0x0226;
                case 1637593646: goto L_0x0214;
                case 1651782350: goto L_0x0202;
                case 1670806965: goto L_0x01f0;
                case 1731789629: goto L_0x01de;
                case 1733676578: goto L_0x01cc;
                case 1805731605: goto L_0x01ba;
                case 1831365744: goto L_0x01a8;
                case 1933689919: goto L_0x0196;
                case 1939139471: goto L_0x0184;
                case 1939187939: goto L_0x0172;
                case 1939340529: goto L_0x0160;
                case 1939344114: goto L_0x014e;
                case 1939350159: goto L_0x013c;
                case 1939438338: goto L_0x012a;
                case 1939489551: goto L_0x0118;
                case 1939499269: goto L_0x0106;
                case 1939585866: goto L_0x00f4;
                case 1939634500: goto L_0x00e2;
                case 1939668280: goto L_0x00d0;
                case 1939671213: goto L_0x00be;
                case 1939682306: goto L_0x00ac;
                case 1939701885: goto L_0x009a;
                case 1939761649: goto L_0x0088;
                case 1939797185: goto L_0x0076;
                case 1960834382: goto L_0x0064;
                case 1963022355: goto L_0x0052;
                case 2016411765: goto L_0x0040;
                case 2042269965: goto L_0x002e;
                case 2042343624: goto L_0x001c;
                case 2093466308: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0ae4
        L_0x000a:
            java.lang.String r0 = "ds_card_view"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0014
            goto L_0x0ae4
        L_0x0014:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_card_view
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x001c:
            java.lang.String r0 = "ds_arrow_down"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0026
            goto L_0x0ae4
        L_0x0026:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_arrow_down
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x002e:
            java.lang.String r0 = "ds_arrow_back"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0038
            goto L_0x0ae4
        L_0x0038:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_arrow_back
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0040:
            java.lang.String r0 = "ds_checkbox_enabled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x004a
            goto L_0x0ae4
        L_0x004a:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_checkbox_enabled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0052:
            java.lang.String r0 = "ds_category_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x005c
            goto L_0x0ae4
        L_0x005c:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_category_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0064:
            java.lang.String r0 = "ds_settings_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x006e
            goto L_0x0ae4
        L_0x006e:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_settings_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0076:
            java.lang.String r0 = "ds_work"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0080
            goto L_0x0ae4
        L_0x0080:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_work
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0088:
            java.lang.String r0 = "ds_visa"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0092
            goto L_0x0ae4
        L_0x0092:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_visa
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x009a:
            java.lang.String r0 = "ds_time"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00a4
            goto L_0x0ae4
        L_0x00a4:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_time
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x00ac:
            java.lang.String r0 = "ds_star"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00b6
            goto L_0x0ae4
        L_0x00b6:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_star
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x00be:
            java.lang.String r0 = "ds_show"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00c8
            goto L_0x0ae4
        L_0x00c8:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_show
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x00d0:
            java.lang.String r0 = "ds_send"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00da
            goto L_0x0ae4
        L_0x00da:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_send
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x00e2:
            java.lang.String r0 = "ds_rain"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00ec
            goto L_0x0ae4
        L_0x00ec:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_rain
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x00f4:
            java.lang.String r0 = "ds_plus"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x00fe
            goto L_0x0ae4
        L_0x00fe:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_plus
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0106:
            java.lang.String r0 = "ds_more"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0110
            goto L_0x0ae4
        L_0x0110:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_more
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0118:
            java.lang.String r0 = "ds_menu"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0122
            goto L_0x0ae4
        L_0x0122:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_menu
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x012a:
            java.lang.String r0 = "ds_knet"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0134
            goto L_0x0ae4
        L_0x0134:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_knet
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x013c:
            java.lang.String r0 = "ds_home"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0146
            goto L_0x0ae4
        L_0x0146:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_home
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x014e:
            java.lang.String r0 = "ds_hide"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0158
            goto L_0x0ae4
        L_0x0158:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_hide
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0160:
            java.lang.String r0 = "ds_help"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x016a
            goto L_0x0ae4
        L_0x016a:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_help
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0172:
            java.lang.String r0 = "ds_cash"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x017c
            goto L_0x0ae4
        L_0x017c:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_cash
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0184:
            java.lang.String r0 = "ds_amex"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x018e
            goto L_0x0ae4
        L_0x018e:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_amex
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0196:
            java.lang.String r0 = "ds_radiobutton_enabled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x01a0
            goto L_0x0ae4
        L_0x01a0:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_radiobutton_enabled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x01a8:
            java.lang.String r0 = "ds_help_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x01b2
            goto L_0x0ae4
        L_0x01b2:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_help_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x01ba:
            java.lang.String r0 = "ds_forward"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x01c4
            goto L_0x0ae4
        L_0x01c4:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_forward
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x01cc:
            java.lang.String r0 = "ds_mastercard"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x01d6
            goto L_0x0ae4
        L_0x01d6:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_mastercard
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x01de:
            java.lang.String r0 = "ds_card_view_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x01e8
            goto L_0x0ae4
        L_0x01e8:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_card_view_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x01f0:
            java.lang.String r0 = "ds_favorite_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x01fa
            goto L_0x0ae4
        L_0x01fa:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_favorite_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0202:
            java.lang.String r0 = "ds_tooltip_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x020c
            goto L_0x0ae4
        L_0x020c:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_tooltip_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0214:
            java.lang.String r0 = "ds_rating_very_bad"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x021e
            goto L_0x0ae4
        L_0x021e:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_rating_very_bad
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0226:
            java.lang.String r0 = "ds_button_shape"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0230
            goto L_0x0ae4
        L_0x0230:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_button_shape
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0238:
            java.lang.String r0 = "ds_custom_location"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0242
            goto L_0x0ae4
        L_0x0242:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_custom_location
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x024a:
            java.lang.String r0 = "ds_food_bowl_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0254
            goto L_0x0ae4
        L_0x0254:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_food_bowl_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x025c:
            java.lang.String r0 = "ds_rating_bad"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0266
            goto L_0x0ae4
        L_0x0266:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_rating_bad
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x026e:
            java.lang.String r0 = "ds_location"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0278
            goto L_0x0ae4
        L_0x0278:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_location
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0280:
            java.lang.String r0 = "ds_rating_very_good_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x028a
            goto L_0x0ae4
        L_0x028a:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_rating_very_good_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0292:
            java.lang.String r0 = "ds_rating_good_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x029c
            goto L_0x0ae4
        L_0x029c:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_rating_good_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x02a4:
            java.lang.String r0 = "ds_notification_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x02ae
            goto L_0x0ae4
        L_0x02ae:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_notification_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x02b6:
            java.lang.String r0 = "ds_locked_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x02c0
            goto L_0x0ae4
        L_0x02c0:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_locked_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x02c8:
            java.lang.String r0 = "ds_time_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x02d2
            goto L_0x0ae4
        L_0x02d2:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_time_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x02da:
            java.lang.String r0 = "ds_current_location_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x02e4
            goto L_0x0ae4
        L_0x02e4:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_current_location_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x02ec:
            java.lang.String r0 = "ds_message_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x02f6
            goto L_0x0ae4
        L_0x02f6:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_message_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x02fe:
            java.lang.String r0 = "ds_minus_circle_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0308
            goto L_0x0ae4
        L_0x0308:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_minus_circle_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0310:
            java.lang.String r0 = "ds_rating_okay"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x031a
            goto L_0x0ae4
        L_0x031a:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_rating_okay
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0322:
            java.lang.String r0 = "ds_rating_good"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x032c
            goto L_0x0ae4
        L_0x032c:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_rating_good
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0334:
            java.lang.String r0 = "ds_tooltip"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x033e
            goto L_0x0ae4
        L_0x033e:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_tooltip
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0346:
            java.lang.String r0 = "ds_food_bowl"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0350
            goto L_0x0ae4
        L_0x0350:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_food_bowl
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0358:
            java.lang.String r0 = "ds_show_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0362
            goto L_0x0ae4
        L_0x0362:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_show_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x036a:
            java.lang.String r0 = "ds_list_view"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0374
            goto L_0x0ae4
        L_0x0374:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_list_view
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x037c:
            java.lang.String r0 = "ds_reward_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0386
            goto L_0x0ae4
        L_0x0386:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_reward_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x038e:
            java.lang.String r0 = "ds_settings"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0398
            goto L_0x0ae4
        L_0x0398:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_settings
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x03a0:
            java.lang.String r0 = "ds_mobile_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x03aa
            goto L_0x0ae4
        L_0x03aa:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_mobile_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x03b2:
            java.lang.String r0 = "ds_close_circle_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x03bc
            goto L_0x0ae4
        L_0x03bc:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_close_circle_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x03c4:
            java.lang.String r0 = "ds_checkbox_disabled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x03ce
            goto L_0x0ae4
        L_0x03ce:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_checkbox_disabled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x03d6:
            java.lang.String r0 = "ds_rating_very_bad_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x03e0
            goto L_0x0ae4
        L_0x03e0:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_rating_very_bad_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x03e8:
            java.lang.String r0 = "ds_delivery_bike"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x03f2
            goto L_0x0ae4
        L_0x03f2:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_delivery_bike
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x03fa:
            java.lang.String r0 = "ds_talabat"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0404
            goto L_0x0ae4
        L_0x0404:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_talabat
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x040c:
            java.lang.String r0 = "ds_notification"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0416
            goto L_0x0ae4
        L_0x0416:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_notification
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x041e:
            java.lang.String r0 = "ds_chevron_down"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0428
            goto L_0x0ae4
        L_0x0428:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_chevron_down
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0430:
            java.lang.String r0 = "ds_chevron_back"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x043a
            goto L_0x0ae4
        L_0x043a:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_chevron_back
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0442:
            java.lang.String r0 = "ds_chevron_forward"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x044c
            goto L_0x0ae4
        L_0x044c:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_chevron_forward
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0454:
            java.lang.String r0 = "ds_bin_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x045e
            goto L_0x0ae4
        L_0x045e:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_bin_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0466:
            java.lang.String r0 = "ds_promo_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0470
            goto L_0x0ae4
        L_0x0470:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_promo_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0478:
            java.lang.String r0 = "ds_plus_circle"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0482
            goto L_0x0ae4
        L_0x0482:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_plus_circle
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x048a:
            java.lang.String r0 = "ds_favorite"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0494
            goto L_0x0ae4
        L_0x0494:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_favorite
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x049c:
            java.lang.String r0 = "ds_image_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x04a6
            goto L_0x0ae4
        L_0x04a6:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_image_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x04ae:
            java.lang.String r0 = "ds_credit_card"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x04b8
            goto L_0x0ae4
        L_0x04b8:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_credit_card
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x04c0:
            java.lang.String r0 = "ds_header_icon_background"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x04ca
            goto L_0x0ae4
        L_0x04ca:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_header_icon_background
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x04d2:
            java.lang.String r0 = "ds_hide_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x04dc
            goto L_0x0ae4
        L_0x04dc:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_hide_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x04e4:
            java.lang.String r0 = "ds_work_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x04ee
            goto L_0x0ae4
        L_0x04ee:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_work_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x04f6:
            java.lang.String r0 = "ds_voucher_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0500
            goto L_0x0ae4
        L_0x0500:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_voucher_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0508:
            java.lang.String r0 = "ds_minus_circle"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0512
            goto L_0x0ae4
        L_0x0512:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_minus_circle
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x051a:
            java.lang.String r0 = "ds_thumbs_up_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0524
            goto L_0x0ae4
        L_0x0524:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_thumbs_up_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x052c:
            java.lang.String r0 = "ds_home_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0536
            goto L_0x0ae4
        L_0x0536:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_home_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x053e:
            java.lang.String r0 = "ds_filter_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0548
            goto L_0x0ae4
        L_0x0548:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_filter_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0550:
            java.lang.String r0 = "ds_location_pin"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x055a
            goto L_0x0ae4
        L_0x055a:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_location_pin
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0562:
            java.lang.String r0 = "ds_receipt_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x056c
            goto L_0x0ae4
        L_0x056c:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_receipt_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0574:
            java.lang.String r0 = "ds_email_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x057e
            goto L_0x0ae4
        L_0x057e:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_email_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0586:
            java.lang.String r0 = "ds_facebook"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0590
            goto L_0x0ae4
        L_0x0590:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_facebook
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0598:
            java.lang.String r0 = "ds_wallet"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x05a2
            goto L_0x0ae4
        L_0x05a2:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_wallet
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x05aa:
            java.lang.String r0 = "ds_scanner"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x05b4
            goto L_0x0ae4
        L_0x05b4:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_scanner
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x05bc:
            java.lang.String r0 = "ds_check_circle_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x05c6
            goto L_0x0ae4
        L_0x05c6:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_check_circle_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x05ce:
            java.lang.String r0 = "ds_vendor"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x05d8
            goto L_0x0ae4
        L_0x05d8:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_vendor
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x05e0:
            java.lang.String r0 = "ds_maximize"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x05ea
            goto L_0x0ae4
        L_0x05ea:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_maximize
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x05f2:
            java.lang.String r0 = "ds_rating_bad_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x05fc
            goto L_0x0ae4
        L_0x05fc:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_rating_bad_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0604:
            java.lang.String r0 = "ds_search"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x060e
            goto L_0x0ae4
        L_0x060e:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_search
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0616:
            java.lang.String r0 = "ds_share"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0620
            goto L_0x0ae4
        L_0x0620:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_share
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0628:
            java.lang.String r0 = "ds_promo"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0632
            goto L_0x0ae4
        L_0x0632:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_promo
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x063a:
            java.lang.String r0 = "ds_phone"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0644
            goto L_0x0ae4
        L_0x0644:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_phone
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x064c:
            java.lang.String r0 = "ds_minus"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0656
            goto L_0x0ae4
        L_0x0656:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_minus
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x065e:
            java.lang.String r0 = "ds_image"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0668
            goto L_0x0ae4
        L_0x0668:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_image
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0670:
            java.lang.String r0 = "ds_email"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x067a
            goto L_0x0ae4
        L_0x067a:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_email
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0682:
            java.lang.String r0 = "ds_close"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x068c
            goto L_0x0ae4
        L_0x068c:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_close
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0694:
            java.lang.String r0 = "ds_check"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x069e
            goto L_0x0ae4
        L_0x069e:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_check
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x06a6:
            java.lang.String r0 = "ds_apple"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x06b0
            goto L_0x0ae4
        L_0x06b0:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_apple
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x06b8:
            java.lang.String r0 = "ds_alert"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x06c2
            goto L_0x0ae4
        L_0x06c2:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_alert
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x06ca:
            java.lang.String r0 = "ds_reward"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x06d4
            goto L_0x0ae4
        L_0x06d4:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_reward
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x06dc:
            java.lang.String r0 = "ds_check_circle"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x06e6
            goto L_0x0ae4
        L_0x06e6:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_check_circle
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x06ee:
            java.lang.String r0 = "ds_credit_card_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x06f8
            goto L_0x0ae4
        L_0x06f8:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_credit_card_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0700:
            java.lang.String r0 = "ds_thumbs_down"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x070a
            goto L_0x0ae4
        L_0x070a:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_thumbs_down
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0712:
            java.lang.String r0 = "ds_mobile"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x071c
            goto L_0x0ae4
        L_0x071c:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_mobile
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0724:
            java.lang.String r0 = "ds_locked"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x072e
            goto L_0x0ae4
        L_0x072e:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_locked
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0736:
            java.lang.String r0 = "ds_profile_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0740
            goto L_0x0ae4
        L_0x0740:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_profile_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0748:
            java.lang.String r0 = "ds_bottom_sheet_icon_background"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0752
            goto L_0x0ae4
        L_0x0752:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_bottom_sheet_icon_background
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x075a:
            java.lang.String r0 = "ds_category"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0764
            goto L_0x0ae4
        L_0x0764:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_category
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x076c:
            java.lang.String r0 = "ds_thumbs_down_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0776
            goto L_0x0ae4
        L_0x0776:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_thumbs_down_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x077e:
            java.lang.String r0 = "ds_google"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0788
            goto L_0x0ae4
        L_0x0788:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_google
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0790:
            java.lang.String r0 = "ds_filter"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x079a
            goto L_0x0ae4
        L_0x079a:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_filter
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x07a2:
            java.lang.String r0 = "ds_contactless_delivery"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x07ac
            goto L_0x0ae4
        L_0x07ac:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_contactless_delivery
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x07b4:
            java.lang.String r0 = "ds_unlocked_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x07be
            goto L_0x0ae4
        L_0x07be:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_unlocked_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x07c6:
            java.lang.String r0 = "ds_calendar_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x07d0
            goto L_0x0ae4
        L_0x07d0:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_calendar_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x07d8:
            java.lang.String r0 = "ds_calendar"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x07e2
            goto L_0x0ae4
        L_0x07e2:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_calendar
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x07ea:
            java.lang.String r0 = "ds_rain_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x07f4
            goto L_0x0ae4
        L_0x07f4:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_rain_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x07fc:
            java.lang.String r0 = "ds_phone_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0806
            goto L_0x0ae4
        L_0x0806:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_phone_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x080e:
            java.lang.String r0 = "ds_unlocked"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0818
            goto L_0x0ae4
        L_0x0818:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_unlocked
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0820:
            java.lang.String r0 = "ds_wallet_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x082a
            goto L_0x0ae4
        L_0x082a:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_wallet_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0832:
            java.lang.String r0 = "ds_thumbs_up"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x083c
            goto L_0x0ae4
        L_0x083c:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_thumbs_up
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0844:
            java.lang.String r0 = "ds_map_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x084e
            goto L_0x0ae4
        L_0x084e:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_map_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0856:
            java.lang.String r0 = "ds_cutlery"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0860
            goto L_0x0ae4
        L_0x0860:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_cutlery
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0868:
            java.lang.String r0 = "ds_walking"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0872
            goto L_0x0ae4
        L_0x0872:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_walking
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x087a:
            java.lang.String r0 = "ds_current_location"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0884
            goto L_0x0ae4
        L_0x0884:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_current_location
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x088c:
            java.lang.String r0 = "ds_reorder"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0896
            goto L_0x0ae4
        L_0x0896:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_reorder
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x089e:
            java.lang.String r0 = "ds_receive"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x08a8
            goto L_0x0ae4
        L_0x08a8:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_receive
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x08b0:
            java.lang.String r0 = "ds_receipt"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x08ba
            goto L_0x0ae4
        L_0x08ba:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_receipt
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x08c2:
            java.lang.String r0 = "ds_light_bulb"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x08cc
            goto L_0x0ae4
        L_0x08cc:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_light_bulb
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x08d4:
            java.lang.String r0 = "ds_rating_very_good"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x08de
            goto L_0x0ae4
        L_0x08de:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_rating_very_good
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x08e6:
            java.lang.String r0 = "ds_location_pin_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x08f0
            goto L_0x0ae4
        L_0x08f0:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_location_pin_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x08f8:
            java.lang.String r0 = "ds_message"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0902
            goto L_0x0ae4
        L_0x0902:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_message
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x090a:
            java.lang.String r0 = "ds_delivery_bike_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0914
            goto L_0x0ae4
        L_0x0914:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_delivery_bike_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x091c:
            java.lang.String r0 = "ds_chevron_up"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0926
            goto L_0x0ae4
        L_0x0926:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_chevron_up
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x092e:
            java.lang.String r0 = "ds_forward_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0938
            goto L_0x0ae4
        L_0x0938:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_forward_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0940:
            java.lang.String r0 = "ds_voucher"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x094a
            goto L_0x0ae4
        L_0x094a:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_voucher
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0952:
            java.lang.String r0 = "ds_bag_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x095c
            goto L_0x0ae4
        L_0x095c:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_bag_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0964:
            java.lang.String r0 = "ds_map"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x096e
            goto L_0x0ae4
        L_0x096e:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_map
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0976:
            java.lang.String r0 = "ds_bin"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0980
            goto L_0x0ae4
        L_0x0980:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_bin
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0988:
            java.lang.String r0 = "ds_bag"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0992
            goto L_0x0ae4
        L_0x0992:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_bag
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x099a:
            java.lang.String r0 = "ds_close_circle"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x09a4
            goto L_0x0ae4
        L_0x09a4:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_close_circle
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x09ac:
            java.lang.String r0 = "ds_cutlery_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x09b6
            goto L_0x0ae4
        L_0x09b6:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_cutlery_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x09be:
            java.lang.String r0 = "ds_rating_amazing"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x09c8
            goto L_0x0ae4
        L_0x09c8:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_rating_amazing
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x09d0:
            java.lang.String r0 = "ds_location_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x09da
            goto L_0x0ae4
        L_0x09da:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_location_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x09e2:
            java.lang.String r0 = "ds_radiobutton_disabled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x09ec
            goto L_0x0ae4
        L_0x09ec:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_radiobutton_disabled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x09f4:
            java.lang.String r0 = "ds_plus_circle_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x09fe
            goto L_0x0ae4
        L_0x09fe:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_plus_circle_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0a06:
            java.lang.String r0 = "ds_arrow_forward"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0a10
            goto L_0x0ae4
        L_0x0a10:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_arrow_forward
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0a18:
            java.lang.String r0 = "ds_arrow_up"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0a22
            goto L_0x0ae4
        L_0x0a22:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_arrow_up
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0a2a:
            java.lang.String r0 = "ds_alert_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0a34
            goto L_0x0ae4
        L_0x0a34:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_alert_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0a3c:
            java.lang.String r0 = "ds_rating_okay_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0a46
            goto L_0x0ae4
        L_0x0a46:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_rating_okay_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0a4e:
            java.lang.String r0 = "ds_minimize"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0a58
            goto L_0x0ae4
        L_0x0a58:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_minimize
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0a60:
            java.lang.String r0 = "ds_custom_location_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0a6a
            goto L_0x0ae4
        L_0x0a6a:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_custom_location_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0a72:
            java.lang.String r0 = "ds_star_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0a7c
            goto L_0x0ae4
        L_0x0a7c:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_star_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0a84:
            java.lang.String r0 = "ds_vendor_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0a8d
            goto L_0x0ae4
        L_0x0a8d:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_vendor_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0a94:
            java.lang.String r0 = "ds_contactless_delivery_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0a9d
            goto L_0x0ae4
        L_0x0a9d:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_contactless_delivery_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0aa4:
            java.lang.String r0 = "ds_benefit"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0aad
            goto L_0x0ae4
        L_0x0aad:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_benefit
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0ab4:
            java.lang.String r0 = "ds_cash_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0abd
            goto L_0x0ae4
        L_0x0abd:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_cash_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0ac4:
            java.lang.String r0 = "ds_profile"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0acd
            goto L_0x0ae4
        L_0x0acd:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_profile
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0ad4:
            java.lang.String r0 = "ds_light_bulb_filled"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L_0x0add
            goto L_0x0ae4
        L_0x0add:
            int r0 = com.designsystem.marshmallow.R.drawable.ds_light_bulb_filled
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0ae5
        L_0x0ae4:
            r0 = r1
        L_0x0ae5:
            if (r0 == 0) goto L_0x0afb
            int r0 = r0.intValue()
            com.deliveryhero.fluid.widgets.image.ImageLocator$Local r1 = new com.deliveryhero.fluid.widgets.image.ImageLocator$Local
            com.deliveryhero.fluid.widgets.image.ImageAsset r2 = new com.deliveryhero.fluid.widgets.image.ImageAsset
            android.content.Context r3 = r4.context
            android.graphics.drawable.Drawable r5 = com.deliveryhero.fluid.utils.ResourcesUtilsKt.getDrawableCompat(r3, r0, r5)
            r2.<init>(r5)
            r1.<init>(r2)
        L_0x0afb:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.theme.MarshmallowDrawableProvider.getToDrawableToken(java.lang.String):com.deliveryhero.fluid.widgets.image.ImageLocator$Local");
    }

    @NotNull
    public ImageLocator.Local get(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        ImageLocator.Local toDrawableToken = getToDrawableToken(str);
        return toDrawableToken == null ? this.base.get(str) : toDrawableToken;
    }
}
