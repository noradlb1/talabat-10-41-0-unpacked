package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.annotation.RestrictTo;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AnimationUtilsCompat {
    private AnimationUtilsCompat() {
    }

    private static Interpolator createInterpolatorFromXml(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Interpolator pathInterpolatorCompat;
        int depth = xmlPullParser.getDepth();
        Interpolator interpolator = null;
        while (true) {
            int next = xmlPullParser.next();
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next == 2) {
                    AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
                    String name2 = xmlPullParser.getName();
                    if (name2.equals("linearInterpolator")) {
                        interpolator = new LinearInterpolator();
                    } else {
                        if (name2.equals("accelerateInterpolator")) {
                            pathInterpolatorCompat = new AccelerateInterpolator(context, asAttributeSet);
                        } else if (name2.equals("decelerateInterpolator")) {
                            pathInterpolatorCompat = new DecelerateInterpolator(context, asAttributeSet);
                        } else if (name2.equals("accelerateDecelerateInterpolator")) {
                            interpolator = new AccelerateDecelerateInterpolator();
                        } else if (name2.equals("cycleInterpolator")) {
                            pathInterpolatorCompat = new CycleInterpolator(context, asAttributeSet);
                        } else if (name2.equals("anticipateInterpolator")) {
                            pathInterpolatorCompat = new AnticipateInterpolator(context, asAttributeSet);
                        } else if (name2.equals("overshootInterpolator")) {
                            pathInterpolatorCompat = new OvershootInterpolator(context, asAttributeSet);
                        } else if (name2.equals("anticipateOvershootInterpolator")) {
                            pathInterpolatorCompat = new AnticipateOvershootInterpolator(context, asAttributeSet);
                        } else if (name2.equals("bounceInterpolator")) {
                            interpolator = new BounceInterpolator();
                        } else if (name2.equals("pathInterpolator")) {
                            pathInterpolatorCompat = new PathInterpolatorCompat(context, asAttributeSet, xmlPullParser);
                        } else {
                            throw new RuntimeException("Unknown interpolator name: " + xmlPullParser.getName());
                        }
                        interpolator = pathInterpolatorCompat;
                    }
                }
            }
        }
        return interpolator;
    }

    public static Interpolator loadInterpolator(Context context, int i11) throws Resources.NotFoundException {
        return AnimationUtils.loadInterpolator(context, i11);
    }
}
