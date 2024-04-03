package androidx.constraintlayout.core.motion.parse;

import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLKey;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import java.io.PrintStream;

public class KeyParser {

    public interface DataType {
        int get(int i11);
    }

    public interface Ids {
        int get(String str);
    }

    public static void main(String[] strArr) {
        parseAttributes("{frame:22,\ntarget:'widget1',\neasing:'easeIn',\ncurveFit:'spline',\nprogress:0.3,\nalpha:0.2,\nelevation:0.7,\nrotationZ:23,\nrotationX:25.0,\nrotationY:27.0,\npivotX:15,\npivotY:17,\npivotTarget:'32',\npathRotate:23,\nscaleX:0.5,\nscaleY:0.7,\ntranslationX:5,\ntranslationY:7,\ntranslationZ:11,\n}");
    }

    private static TypedBundle parse(String str, Ids ids, DataType dataType) {
        TypedBundle typedBundle = new TypedBundle();
        try {
            CLObject parse = CLParser.parse(str);
            int size = parse.size();
            for (int i11 = 0; i11 < size; i11++) {
                CLKey cLKey = (CLKey) parse.get(i11);
                String content = cLKey.content();
                CLElement value = cLKey.getValue();
                int i12 = ids.get(content);
                if (i12 == -1) {
                    PrintStream printStream = System.err;
                    printStream.println("unknown type " + content);
                } else {
                    int i13 = dataType.get(i12);
                    if (i13 == 1) {
                        typedBundle.add(i12, parse.getBoolean(i11));
                    } else if (i13 == 2) {
                        typedBundle.add(i12, value.getInt());
                        PrintStream printStream2 = System.out;
                        printStream2.println("parse " + content + " INT_MASK > " + value.getInt());
                    } else if (i13 == 4) {
                        typedBundle.add(i12, value.getFloat());
                        PrintStream printStream3 = System.out;
                        printStream3.println("parse " + content + " FLOAT_MASK > " + value.getFloat());
                    } else if (i13 == 8) {
                        typedBundle.add(i12, value.content());
                        PrintStream printStream4 = System.out;
                        printStream4.println("parse " + content + " STRING_MASK > " + value.content());
                    }
                }
            }
        } catch (CLParsingException e11) {
            e11.printStackTrace();
        }
        return typedBundle;
    }

    public static TypedBundle parseAttributes(String str) {
        return parse(str, new a(), new b());
    }
}
