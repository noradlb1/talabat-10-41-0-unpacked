package com.talabat.fluid.theme;

import android.content.Context;
import com.deliveryhero.fluid.expression.reference.providers.ValueProvider;
import com.deliveryhero.fluid.values.Color;
import com.designsystem.marshmallow.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u0002*\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/talabat/fluid/theme/MarshmallowColorProvider;", "Lcom/deliveryhero/fluid/expression/reference/providers/ValueProvider;", "Lcom/deliveryhero/fluid/values/Color;", "context", "Landroid/content/Context;", "base", "(Landroid/content/Context;Lcom/deliveryhero/fluid/expression/reference/providers/ValueProvider;)V", "toColorToken", "", "getToColorToken", "(Ljava/lang/String;)Lcom/deliveryhero/fluid/values/Color;", "get", "name", "com_talabat_ThirdPartyLibs_Fluid_Fluid"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MarshmallowColorProvider implements ValueProvider<Color> {
    @NotNull
    private final ValueProvider<Color> base;
    @NotNull
    private final Context context;

    public MarshmallowColorProvider(@NotNull Context context2, @NotNull ValueProvider<Color> valueProvider) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(valueProvider, TtmlNode.RUBY_BASE);
        this.context = context2;
        this.base = valueProvider;
    }

    private final Color getToColorToken(String str) {
        switch (str.hashCode()) {
            case -2047688559:
                if (str.equals("success4")) {
                    return new Color(this.context.getColor(R.color.ds_success_4));
                }
                break;
            case -1842242655:
                if (str.equals("primary10")) {
                    return new Color(this.context.getColor(R.color.ds_primary_10));
                }
                break;
            case -1842242593:
                if (str.equals("primary30")) {
                    return new Color(this.context.getColor(R.color.ds_primary_30));
                }
                break;
            case -1842242495:
                if (str.equals("primary65")) {
                    return new Color(this.context.getColor(R.color.ds_primary_65));
                }
                break;
            case -1428304346:
                if (str.equals("neutral10")) {
                    return new Color(this.context.getColor(R.color.ds_neutral_10));
                }
                break;
            case -1428304315:
                if (str.equals("neutral20")) {
                    return new Color(this.context.getColor(R.color.ds_neutral_20));
                }
                break;
            case -1428304284:
                if (str.equals("neutral30")) {
                    return new Color(this.context.getColor(R.color.ds_neutral_30));
                }
                break;
            case -1428304279:
                if (str.equals("neutral35")) {
                    return new Color(this.context.getColor(R.color.ds_neutral_35));
                }
                break;
            case -1428304253:
                if (str.equals("neutral40")) {
                    return new Color(this.context.getColor(R.color.ds_neutral_40));
                }
                break;
            case -1428304222:
                if (str.equals("neutral50")) {
                    return new Color(this.context.getColor(R.color.ds_neutral_50));
                }
                break;
            case -1428304217:
                if (str.equals("neutral55")) {
                    return new Color(this.context.getColor(R.color.ds_neutral_55));
                }
                break;
            case -1428304191:
                if (str.equals("neutral60")) {
                    return new Color(this.context.getColor(R.color.ds_neutral_60));
                }
                break;
            case -1428304160:
                if (str.equals("neutral70")) {
                    return new Color(this.context.getColor(R.color.ds_neutral_70));
                }
                break;
            case -1428304129:
                if (str.equals("neutral80")) {
                    return new Color(this.context.getColor(R.color.ds_neutral_80));
                }
                break;
            case -1415077288:
                if (str.equals("alert4")) {
                    return new Color(this.context.getColor(R.color.ds_alert_4));
                }
                break;
            case -1385986055:
                if (str.equals("blue10")) {
                    return new Color(this.context.getColor(R.color.ds_blue_10));
                }
                break;
            case -1385986024:
                if (str.equals("blue20")) {
                    return new Color(this.context.getColor(R.color.ds_blue_20));
                }
                break;
            case -1385985993:
                if (str.equals("blue30")) {
                    return new Color(this.context.getColor(R.color.ds_blue_30));
                }
                break;
            case -1385985962:
                if (str.equals("blue40")) {
                    return new Color(this.context.getColor(R.color.ds_blue_40));
                }
                break;
            case -1385985931:
                if (str.equals("blue50")) {
                    return new Color(this.context.getColor(R.color.ds_blue_50));
                }
                break;
            case -1385985900:
                if (str.equals("blue60")) {
                    return new Color(this.context.getColor(R.color.ds_blue_60));
                }
                break;
            case -1385985869:
                if (str.equals("blue70")) {
                    return new Color(this.context.getColor(R.color.ds_blue_70));
                }
                break;
            case -1385985838:
                if (str.equals("blue80")) {
                    return new Color(this.context.getColor(R.color.ds_blue_80));
                }
                break;
            case -1327761718:
                if (str.equals("neutral100")) {
                    return new Color(this.context.getColor(R.color.ds_neutral_100));
                }
                break;
            case -1327756663:
                if (str.equals("neutral4v2")) {
                    return new Color(this.context.getColor(R.color.ds_neutral_4_v2));
                }
                break;
            case -1274947409:
                if (str.equals("primary100")) {
                    return new Color(this.context.getColor(R.color.ds_primary_100));
                }
                break;
            case -1229644397:
                if (str.equals("yellow10")) {
                    return new Color(this.context.getColor(R.color.ds_yellow_10));
                }
                break;
            case -1229644366:
                if (str.equals("yellow20")) {
                    return new Color(this.context.getColor(R.color.ds_yellow_20));
                }
                break;
            case -1229644335:
                if (str.equals("yellow30")) {
                    return new Color(this.context.getColor(R.color.ds_yellow_30));
                }
                break;
            case -1229644304:
                if (str.equals("yellow40")) {
                    return new Color(this.context.getColor(R.color.ds_yellow_40));
                }
                break;
            case -1229644273:
                if (str.equals("yellow50")) {
                    return new Color(this.context.getColor(R.color.ds_yellow_50));
                }
                break;
            case -1229644242:
                if (str.equals("yellow60")) {
                    return new Color(this.context.getColor(R.color.ds_yellow_60));
                }
                break;
            case -1229644211:
                if (str.equals("yellow70")) {
                    return new Color(this.context.getColor(R.color.ds_yellow_70));
                }
                break;
            case -1229644180:
                if (str.equals("yellow80")) {
                    return new Color(this.context.getColor(R.color.ds_yellow_80));
                }
                break;
            case -1216229138:
                if (str.equals("danger100")) {
                    return new Color(this.context.getColor(R.color.ds_danger_100));
                }
                break;
            case -1167805838:
                if (str.equals("primary4")) {
                    return new Color(this.context.getColor(R.color.ds_primary_4));
                }
                break;
            case -995678590:
                if (str.equals("promo100")) {
                    return new Color(this.context.getColor(R.color.ds_promo_100));
                }
                break;
            case -988151275:
                if (str.equals("pink10")) {
                    return new Color(this.context.getColor(R.color.ds_pink_10));
                }
                break;
            case -988151244:
                if (str.equals("pink20")) {
                    return new Color(this.context.getColor(R.color.ds_pink_20));
                }
                break;
            case -988151213:
                if (str.equals("pink30")) {
                    return new Color(this.context.getColor(R.color.ds_pink_30));
                }
                break;
            case -988151182:
                if (str.equals("pink40")) {
                    return new Color(this.context.getColor(R.color.ds_pink_40));
                }
                break;
            case -988151151:
                if (str.equals("pink50")) {
                    return new Color(this.context.getColor(R.color.ds_pink_50));
                }
                break;
            case -988151120:
                if (str.equals("pink60")) {
                    return new Color(this.context.getColor(R.color.ds_pink_60));
                }
                break;
            case -988151089:
                if (str.equals("pink70")) {
                    return new Color(this.context.getColor(R.color.ds_pink_70));
                }
                break;
            case -988151058:
                if (str.equals("pink80")) {
                    return new Color(this.context.getColor(R.color.ds_pink_80));
                }
                break;
            case -979805947:
                if (str.equals("promo4")) {
                    return new Color(this.context.getColor(R.color.ds_promo_4));
                }
                break;
            case -917723013:
                if (str.equals("alert10")) {
                    return new Color(this.context.getColor(R.color.ds_alert_10));
                }
                break;
            case -917722951:
                if (str.equals("alert30")) {
                    return new Color(this.context.getColor(R.color.ds_alert_30));
                }
                break;
            case -733684978:
                if (str.equals("success100")) {
                    return new Color(this.context.getColor(R.color.ds_success_100));
                }
                break;
            case -336903518:
                if (str.equals("neutralWhite")) {
                    return new Color(this.context.getColor(R.color.ds_neutral_white));
                }
                break;
            case -309213330:
                if (str.equals("promo10")) {
                    return new Color(this.context.getColor(R.color.ds_promo_10));
                }
                break;
            case -309213268:
                if (str.equals("promo30")) {
                    return new Color(this.context.getColor(R.color.ds_promo_35));
                }
                break;
            case -305174531:
                if (str.equals("secondary100")) {
                    return new Color(this.context.getColor(R.color.ds_secondary_100));
                }
                break;
            case 108387952:
                if (str.equals("red10")) {
                    return new Color(this.context.getColor(R.color.ds_red_10));
                }
                break;
            case 108387983:
                if (str.equals("red20")) {
                    return new Color(this.context.getColor(R.color.ds_red_20));
                }
                break;
            case 108388014:
                if (str.equals("red30")) {
                    return new Color(this.context.getColor(R.color.ds_red_30));
                }
                break;
            case 108388045:
                if (str.equals("red40")) {
                    return new Color(this.context.getColor(R.color.ds_red_40));
                }
                break;
            case 108388076:
                if (str.equals("red50")) {
                    return new Color(this.context.getColor(R.color.ds_red_50));
                }
                break;
            case 108388107:
                if (str.equals("red60")) {
                    return new Color(this.context.getColor(R.color.ds_red_60));
                }
                break;
            case 108388138:
                if (str.equals("red70")) {
                    return new Color(this.context.getColor(R.color.ds_red_70));
                }
                break;
            case 108388169:
                if (str.equals("red80")) {
                    return new Color(this.context.getColor(R.color.ds_red_80));
                }
                break;
            case 113101865:
                if (str.equals("white")) {
                    return new Color(this.context.getColor(R.color.ds_white));
                }
                break;
            case 267250323:
                if (str.equals("secondary10")) {
                    return new Color(this.context.getColor(R.color.ds_secondary_10));
                }
                break;
            case 267250385:
                if (str.equals("secondary30")) {
                    return new Color(this.context.getColor(R.color.ds_secondary_30));
                }
                break;
            case 283713634:
                if (str.equals("green10")) {
                    return new Color(this.context.getColor(R.color.ds_green_10));
                }
                break;
            case 283713665:
                if (str.equals("green20")) {
                    return new Color(this.context.getColor(R.color.ds_green_20));
                }
                break;
            case 283713696:
                if (str.equals("green30")) {
                    return new Color(this.context.getColor(R.color.ds_green_30));
                }
                break;
            case 283713727:
                if (str.equals("green40")) {
                    return new Color(this.context.getColor(R.color.ds_green_40));
                }
                break;
            case 283713758:
                if (str.equals("green50")) {
                    return new Color(this.context.getColor(R.color.ds_green_50));
                }
                break;
            case 283713789:
                if (str.equals("green60")) {
                    return new Color(this.context.getColor(R.color.ds_green_60));
                }
                break;
            case 283713820:
                if (str.equals("green70")) {
                    return new Color(this.context.getColor(R.color.ds_green_70));
                }
                break;
            case 283713851:
                if (str.equals("green80")) {
                    return new Color(this.context.getColor(R.color.ds_green_80));
                }
                break;
            case 424262976:
                if (str.equals("secondary4")) {
                    return new Color(this.context.getColor(R.color.ds_secondary_4));
                }
                break;
            case 946164066:
                if (str.equals("success10")) {
                    return new Color(this.context.getColor(R.color.ds_success_10));
                }
                break;
            case 946164128:
                if (str.equals("success30")) {
                    return new Color(this.context.getColor(R.color.ds_success_30));
                }
                break;
            case 1156405453:
                if (str.equals("orange10")) {
                    return new Color(this.context.getColor(R.color.ds_orange_10));
                }
                break;
            case 1156405484:
                if (str.equals("orange20")) {
                    return new Color(this.context.getColor(R.color.ds_orange_20));
                }
                break;
            case 1156405515:
                if (str.equals("orange30")) {
                    return new Color(this.context.getColor(R.color.ds_orange_30));
                }
                break;
            case 1156405546:
                if (str.equals("orange40")) {
                    return new Color(this.context.getColor(R.color.ds_orange_40));
                }
                break;
            case 1156405577:
                if (str.equals("orange50")) {
                    return new Color(this.context.getColor(R.color.ds_orange_50));
                }
                break;
            case 1156405608:
                if (str.equals("orange60")) {
                    return new Color(this.context.getColor(R.color.ds_orange_60));
                }
                break;
            case 1156405639:
                if (str.equals("orange70")) {
                    return new Color(this.context.getColor(R.color.ds_orange_70));
                }
                break;
            case 1156405670:
                if (str.equals("orange80")) {
                    return new Color(this.context.getColor(R.color.ds_orange_80));
                }
                break;
            case 1339398989:
                if (str.equals("neutral4")) {
                    return new Color(this.context.getColor(R.color.ds_neutral_4));
                }
                break;
            case 1437838961:
                if (str.equals("danger4")) {
                    return new Color(this.context.getColor(R.color.ds_danger_4));
                }
                break;
            case 1615357717:
                if (str.equals("alert100")) {
                    return new Color(this.context.getColor(R.color.ds_alert_100));
                }
                break;
            case 1623334786:
                if (str.equals("danger10")) {
                    return new Color(this.context.getColor(R.color.ds_danger_10));
                }
                break;
            case 1623334848:
                if (str.equals("danger30")) {
                    return new Color(this.context.getColor(R.color.ds_danger_30));
                }
                break;
            case 1789061922:
                if (str.equals("neutral10v2")) {
                    return new Color(this.context.getColor(R.color.ds_neutral_10_v2));
                }
                break;
            case 1789240668:
                if (str.equals("neutral70v2")) {
                    return new Color(this.context.getColor(R.color.ds_neutral_70_v2));
                }
                break;
        }
        return null;
    }

    @NotNull
    public Color get(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        Color toColorToken = getToColorToken(str);
        return toColorToken == null ? this.base.get(str) : toColorToken;
    }
}
