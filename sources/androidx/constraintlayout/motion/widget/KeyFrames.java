package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class KeyFrames {
    private static final String CUSTOM_ATTRIBUTE = "CustomAttribute";
    private static final String CUSTOM_METHOD = "CustomMethod";
    private static final String TAG = "KeyFrames";
    public static final int UNSET = -1;

    /* renamed from: a  reason: collision with root package name */
    public static HashMap<String, Constructor<? extends Key>> f10876a;
    private HashMap<Integer, ArrayList<Key>> mFramesMap = new HashMap<>();

    static {
        HashMap<String, Constructor<? extends Key>> hashMap = new HashMap<>();
        f10876a = hashMap;
        try {
            hashMap.put("KeyAttribute", KeyAttributes.class.getConstructor(new Class[0]));
            f10876a.put(TypedValues.PositionType.NAME, KeyPosition.class.getConstructor(new Class[0]));
            f10876a.put(TypedValues.CycleType.NAME, KeyCycle.class.getConstructor(new Class[0]));
            f10876a.put("KeyTimeCycle", KeyTimeCycle.class.getConstructor(new Class[0]));
            f10876a.put(TypedValues.TriggerType.NAME, KeyTrigger.class.getConstructor(new Class[0]));
        } catch (NoSuchMethodException e11) {
            Log.e(TAG, "unable to load", e11);
        }
    }

    public KeyFrames() {
    }

    public void addAllFrames(MotionController motionController) {
        ArrayList arrayList = this.mFramesMap.get(-1);
        if (arrayList != null) {
            motionController.a(arrayList);
        }
    }

    public void addFrames(MotionController motionController) {
        ArrayList arrayList = this.mFramesMap.get(Integer.valueOf(motionController.f10906c));
        if (arrayList != null) {
            motionController.a(arrayList);
        }
        ArrayList arrayList2 = this.mFramesMap.get(-1);
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Key key = (Key) it.next();
                if (key.a(((ConstraintLayout.LayoutParams) motionController.f10905b.getLayoutParams()).constraintTag)) {
                    motionController.addKey(key);
                }
            }
        }
    }

    public void addKey(Key key) {
        if (!this.mFramesMap.containsKey(Integer.valueOf(key.f10872b))) {
            this.mFramesMap.put(Integer.valueOf(key.f10872b), new ArrayList());
        }
        ArrayList arrayList = this.mFramesMap.get(Integer.valueOf(key.f10872b));
        if (arrayList != null) {
            arrayList.add(key);
        }
    }

    public ArrayList<Key> getKeyFramesForView(int i11) {
        return this.mFramesMap.get(Integer.valueOf(i11));
    }

    public Set<Integer> getKeys() {
        return this.mFramesMap.keySet();
    }

    public KeyFrames(Context context, XmlPullParser xmlPullParser) {
        HashMap<String, ConstraintAttribute> hashMap;
        HashMap<String, ConstraintAttribute> hashMap2;
        Key key;
        Exception e11;
        try {
            int eventType = xmlPullParser.getEventType();
            Key key2 = null;
            while (eventType != 1) {
                if (eventType == 2) {
                    String name2 = xmlPullParser.getName();
                    if (f10876a.containsKey(name2)) {
                        try {
                            Constructor constructor = f10876a.get(name2);
                            if (constructor != null) {
                                key = (Key) constructor.newInstance(new Object[0]);
                                try {
                                    key.load(context, Xml.asAttributeSet(xmlPullParser));
                                    addKey(key);
                                } catch (Exception e12) {
                                    e11 = e12;
                                }
                                key2 = key;
                            } else {
                                throw new NullPointerException("Keymaker for " + name2 + " not found");
                            }
                        } catch (Exception e13) {
                            Key key3 = key2;
                            e11 = e13;
                            key = key3;
                            Log.e(TAG, "unable to create ", e11);
                            key2 = key;
                            eventType = xmlPullParser.next();
                        }
                    } else if (name2.equalsIgnoreCase("CustomAttribute")) {
                        if (!(key2 == null || (hashMap2 = key2.f10875e) == null)) {
                            ConstraintAttribute.parse(context, xmlPullParser, hashMap2);
                        }
                    } else if (!(!name2.equalsIgnoreCase("CustomMethod") || key2 == null || (hashMap = key2.f10875e) == null)) {
                        ConstraintAttribute.parse(context, xmlPullParser, hashMap);
                    }
                } else if (eventType == 3) {
                    if (ViewTransition.KEY_FRAME_SET_TAG.equals(xmlPullParser.getName())) {
                        return;
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (XmlPullParserException e14) {
            e14.printStackTrace();
        } catch (IOException e15) {
            e15.printStackTrace();
        }
    }
}
