package com.nineoldandroids.animation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.animation.AnimationUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatorInflater {
    private static final int[] Animator = {16843073, 16843160, 16843198, 16843199, 16843200, 16843486, 16843487, 16843488};
    private static final int[] AnimatorSet = {16843490};
    private static final int AnimatorSet_ordering = 0;
    private static final int Animator_duration = 1;
    private static final int Animator_interpolator = 0;
    private static final int Animator_repeatCount = 3;
    private static final int Animator_repeatMode = 4;
    private static final int Animator_startOffset = 2;
    private static final int Animator_valueFrom = 5;
    private static final int Animator_valueTo = 6;
    private static final int Animator_valueType = 7;
    private static final int[] PropertyAnimator = {16843489};
    private static final int PropertyAnimator_propertyName = 0;
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_FLOAT = 0;

    private static Animator createAnimatorFromXml(Context context, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return createAnimatorFromXml(context, xmlPullParser, Xml.asAttributeSet(xmlPullParser), (AnimatorSet) null, 0);
    }

    public static Animator loadAnimator(Context context, int i11) throws Resources.NotFoundException {
        XmlResourceParser xmlResourceParser = null;
        try {
            XmlResourceParser animation = context.getResources().getAnimation(i11);
            Animator createAnimatorFromXml = createAnimatorFromXml(context, animation);
            if (animation != null) {
                animation.close();
            }
            return createAnimatorFromXml;
        } catch (XmlPullParserException e11) {
            Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i11));
            notFoundException.initCause(e11);
            throw notFoundException;
        } catch (IOException e12) {
            Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i11));
            notFoundException2.initCause(e12);
            throw notFoundException2;
        } catch (Throwable th2) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th2;
        }
    }

    private static ObjectAnimator loadObjectAnimator(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        loadAnimator(context, attributeSet, objectAnimator);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, PropertyAnimator);
        objectAnimator.setPropertyName(obtainStyledAttributes.getString(0));
        obtainStyledAttributes.recycle();
        return objectAnimator;
    }

    private static Animator createAnimatorFromXml(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i11) throws XmlPullParserException, IOException {
        int i12;
        Animator animator;
        ObjectAnimator objectAnimator;
        int depth = xmlPullParser.getDepth();
        ArrayList arrayList = null;
        Animator animator2 = null;
        while (true) {
            int next = xmlPullParser.next();
            i12 = 0;
            if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                if (next != 2) {
                    animator = animator2;
                } else {
                    String name2 = xmlPullParser.getName();
                    if (name2.equals("objectAnimator")) {
                        objectAnimator = loadObjectAnimator(context, attributeSet);
                    } else if (name2.equals("animator")) {
                        objectAnimator = loadAnimator(context, attributeSet, (ValueAnimator) null);
                    } else if (name2.equals("set")) {
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AnimatorSet);
                        TypedValue typedValue = new TypedValue();
                        obtainStyledAttributes.getValue(0, typedValue);
                        if (typedValue.type == 16) {
                            i12 = typedValue.data;
                        }
                        createAnimatorFromXml(context, xmlPullParser, attributeSet, animatorSet2, i12);
                        obtainStyledAttributes.recycle();
                        objectAnimator = animatorSet2;
                    } else {
                        throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                    }
                    if (animatorSet == null) {
                        animator = objectAnimator;
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(objectAnimator);
                        animator = objectAnimator;
                    }
                }
                animator2 = animator;
            }
        }
        if (!(animatorSet == null || arrayList == null)) {
            Animator[] animatorArr = new Animator[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                animatorArr[i12] = (Animator) it.next();
                i12++;
            }
            if (i11 == 0) {
                animatorSet.playTogether(animatorArr);
            } else {
                animatorSet.playSequentially(animatorArr);
            }
        }
        return animator2;
    }

    private static ValueAnimator loadAnimator(Context context, AttributeSet attributeSet, ValueAnimator valueAnimator) throws Resources.NotFoundException {
        int i11;
        int i12;
        int i13;
        int i14;
        float f11;
        float f12;
        float f13;
        Context context2 = context;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, Animator);
        long j11 = (long) obtainStyledAttributes.getInt(1, 0);
        long j12 = (long) obtainStyledAttributes.getInt(2, 0);
        int i15 = obtainStyledAttributes.getInt(7, 0);
        ValueAnimator valueAnimator2 = valueAnimator == null ? new ValueAnimator() : valueAnimator;
        boolean z11 = i15 == 0;
        TypedValue peekValue = obtainStyledAttributes.peekValue(5);
        boolean z12 = peekValue != null;
        int i16 = z12 ? peekValue.type : 0;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(6);
        boolean z13 = peekValue2 != null;
        int i17 = z13 ? peekValue2.type : 0;
        if ((z12 && i16 >= 28 && i16 <= 31) || (z13 && i17 >= 28 && i17 <= 31)) {
            valueAnimator2.setEvaluator(new ArgbEvaluator());
            z11 = false;
        }
        if (!z11) {
            i11 = 0;
            if (z12) {
                if (i16 == 5) {
                    i13 = (int) obtainStyledAttributes.getDimension(5, 0.0f);
                } else if (i16 < 28 || i16 > 31) {
                    i13 = obtainStyledAttributes.getInt(5, 0);
                } else {
                    i13 = obtainStyledAttributes.getColor(5, 0);
                }
                if (z13) {
                    if (i17 == 5) {
                        i14 = (int) obtainStyledAttributes.getDimension(6, 0.0f);
                    } else if (i17 < 28 || i17 > 31) {
                        i14 = obtainStyledAttributes.getInt(6, 0);
                    } else {
                        i14 = obtainStyledAttributes.getColor(6, 0);
                    }
                    valueAnimator2.setIntValues(i13, i14);
                } else {
                    valueAnimator2.setIntValues(i13);
                }
            } else if (z13) {
                if (i17 == 5) {
                    i12 = (int) obtainStyledAttributes.getDimension(6, 0.0f);
                } else if (i17 < 28 || i17 > 31) {
                    i12 = obtainStyledAttributes.getInt(6, 0);
                } else {
                    i12 = obtainStyledAttributes.getColor(6, 0);
                }
                valueAnimator2.setIntValues(i12);
            }
        } else if (z12) {
            if (i16 == 5) {
                f12 = obtainStyledAttributes.getDimension(5, 0.0f);
            } else {
                f12 = obtainStyledAttributes.getFloat(5, 0.0f);
            }
            if (z13) {
                if (i17 == 5) {
                    f13 = obtainStyledAttributes.getDimension(6, 0.0f);
                } else {
                    f13 = obtainStyledAttributes.getFloat(6, 0.0f);
                }
                i11 = 0;
                valueAnimator2.setFloatValues(f12, f13);
            } else {
                i11 = 0;
                valueAnimator2.setFloatValues(f12);
            }
        } else {
            i11 = 0;
            if (i17 == 5) {
                f11 = obtainStyledAttributes.getDimension(6, 0.0f);
            } else {
                f11 = obtainStyledAttributes.getFloat(6, 0.0f);
            }
            valueAnimator2.setFloatValues(f11);
        }
        valueAnimator2.setDuration(j11);
        valueAnimator2.setStartDelay(j12);
        if (obtainStyledAttributes.hasValue(3)) {
            valueAnimator2.setRepeatCount(obtainStyledAttributes.getInt(3, i11));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            valueAnimator2.setRepeatMode(obtainStyledAttributes.getInt(4, 1));
        }
        int resourceId = obtainStyledAttributes.getResourceId(i11, i11);
        if (resourceId > 0) {
            valueAnimator2.setInterpolator(AnimationUtils.loadInterpolator(context2, resourceId));
        }
        obtainStyledAttributes.recycle();
        return valueAnimator2;
    }
}
