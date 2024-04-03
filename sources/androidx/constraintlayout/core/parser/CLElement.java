package androidx.constraintlayout.core.parser;

import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.io.PrintStream;

public class CLElement {

    /* renamed from: e  reason: collision with root package name */
    public static int f10660e = 80;

    /* renamed from: f  reason: collision with root package name */
    public static int f10661f = 2;

    /* renamed from: b  reason: collision with root package name */
    public long f10662b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f10663c = Long.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    public CLContainer f10664d;
    private int line;
    private final char[] mContent;

    public CLElement(char[] cArr) {
        this.mContent = cArr;
    }

    public void a(StringBuilder sb2, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            sb2.append(' ');
        }
    }

    public String b() {
        if (!CLParser.f10669a) {
            return "";
        }
        return c() + " -> ";
    }

    public String c() {
        String cls = getClass().toString();
        return cls.substring(cls.lastIndexOf(46) + 1);
    }

    public String content() {
        String str = new String(this.mContent);
        long j11 = this.f10663c;
        if (j11 != Long.MAX_VALUE) {
            long j12 = this.f10662b;
            if (j11 >= j12) {
                return str.substring((int) j12, ((int) j11) + 1);
            }
        }
        long j13 = this.f10662b;
        return str.substring((int) j13, ((int) j13) + 1);
    }

    public CLElement getContainer() {
        return this.f10664d;
    }

    public long getEnd() {
        return this.f10663c;
    }

    public float getFloat() {
        if (this instanceof CLNumber) {
            return ((CLNumber) this).getFloat();
        }
        return Float.NaN;
    }

    public int getInt() {
        if (this instanceof CLNumber) {
            return ((CLNumber) this).getInt();
        }
        return 0;
    }

    public int getLine() {
        return this.line;
    }

    public long getStart() {
        return this.f10662b;
    }

    public boolean isDone() {
        return this.f10663c != Long.MAX_VALUE;
    }

    public boolean isStarted() {
        return this.f10662b > -1;
    }

    public boolean notStarted() {
        return this.f10662b == -1;
    }

    public void setContainer(CLContainer cLContainer) {
        this.f10664d = cLContainer;
    }

    public void setEnd(long j11) {
        if (this.f10663c == Long.MAX_VALUE) {
            this.f10663c = j11;
            if (CLParser.f10669a) {
                PrintStream printStream = System.out;
                printStream.println("closing " + hashCode() + " -> " + this);
            }
            CLContainer cLContainer = this.f10664d;
            if (cLContainer != null) {
                cLContainer.add(this);
            }
        }
    }

    public void setLine(int i11) {
        this.line = i11;
    }

    public void setStart(long j11) {
        this.f10662b = j11;
    }

    public String toFormattedJSON(int i11, int i12) {
        return "";
    }

    public String toJSON() {
        return "";
    }

    public String toString() {
        long j11 = this.f10662b;
        long j12 = this.f10663c;
        if (j11 > j12 || j12 == Long.MAX_VALUE) {
            return getClass() + " (INVALID, " + this.f10662b + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + this.f10663c + ")";
        }
        String substring = new String(this.mContent).substring((int) this.f10662b, ((int) this.f10663c) + 1);
        return c() + " (" + this.f10662b + " : " + this.f10663c + ") <<" + substring + ">>";
    }
}
