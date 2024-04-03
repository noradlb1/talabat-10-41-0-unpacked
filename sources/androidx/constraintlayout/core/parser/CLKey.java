package androidx.constraintlayout.core.parser;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;

public class CLKey extends CLContainer {
    private static ArrayList<String> sections;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        sections = arrayList;
        arrayList.add("ConstraintSets");
        sections.add("Variables");
        sections.add("Generate");
        sections.add(TypedValues.TransitionType.NAME);
        sections.add("KeyFrames");
        sections.add(TypedValues.AttributesType.NAME);
        sections.add("KeyPositions");
        sections.add("KeyCycles");
    }

    public CLKey(char[] cArr) {
        super(cArr);
    }

    public static CLElement allocate(char[] cArr) {
        return new CLKey(cArr);
    }

    public String getName() {
        return content();
    }

    public CLElement getValue() {
        if (this.f10659g.size() > 0) {
            return this.f10659g.get(0);
        }
        return null;
    }

    public void set(CLElement cLElement) {
        if (this.f10659g.size() > 0) {
            this.f10659g.set(0, cLElement);
        } else {
            this.f10659g.add(cLElement);
        }
    }

    public String toFormattedJSON(int i11, int i12) {
        StringBuilder sb2 = new StringBuilder(b());
        a(sb2, i11);
        String content = content();
        if (this.f10659g.size() > 0) {
            sb2.append(content);
            sb2.append(": ");
            if (sections.contains(content)) {
                i12 = 3;
            }
            if (i12 > 0) {
                sb2.append(this.f10659g.get(0).toFormattedJSON(i11, i12 - 1));
            } else {
                String json = this.f10659g.get(0).toJSON();
                if (json.length() + i11 < CLElement.f10660e) {
                    sb2.append(json);
                } else {
                    sb2.append(this.f10659g.get(0).toFormattedJSON(i11, i12 - 1));
                }
            }
            return sb2.toString();
        }
        return content + ": <> ";
    }

    public String toJSON() {
        if (this.f10659g.size() > 0) {
            return b() + content() + ": " + this.f10659g.get(0).toJSON();
        }
        return b() + content() + ": <> ";
    }

    public static CLElement allocate(String str, CLElement cLElement) {
        CLKey cLKey = new CLKey(str.toCharArray());
        cLKey.setStart(0);
        cLKey.setEnd((long) (str.length() - 1));
        cLKey.set(cLElement);
        return cLKey;
    }
}
