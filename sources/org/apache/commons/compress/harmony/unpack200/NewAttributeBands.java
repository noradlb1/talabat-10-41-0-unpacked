package org.apache.commons.compress.harmony.unpack200;

import androidx.exifinterface.media.ExifInterface;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import net.bytebuddy.utility.JavaConstant;
import org.apache.commons.compress.harmony.pack200.BHSDCodec;
import org.apache.commons.compress.harmony.pack200.Codec;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.unpack200.bytecode.Attribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPClass;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPDouble;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPFieldRef;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPFloat;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPInteger;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPInterfaceMethodRef;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPLong;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPMethodRef;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPNameAndType;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPString;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import org.apache.commons.compress.harmony.unpack200.bytecode.NewAttribute;

public class NewAttributeBands extends BandSet {
    /* access modifiers changed from: private */
    public final AttributeLayout attributeLayout;
    protected List attributeLayoutElements;
    private int backwardsCallCount;

    public interface AttributeLayoutElement {
        void addToAttribute(int i11, NewAttribute newAttribute);

        void readBands(InputStream inputStream, int i11) throws IOException, Pack200Exception;
    }

    public class Call extends LayoutElement {
        private Callable callable;
        /* access modifiers changed from: private */
        public final int callableIndex;

        public Call(int i11) {
            super();
            this.callableIndex = i11;
        }

        public void addToAttribute(int i11, NewAttribute newAttribute) {
            this.callable.addNextToAttribute(newAttribute);
        }

        public Callable getCallable() {
            return this.callable;
        }

        public int getCallableIndex() {
            return this.callableIndex;
        }

        public void readBands(InputStream inputStream, int i11) {
            if (this.callableIndex > 0) {
                this.callable.addCount(i11);
            }
        }

        public void setCallable(Callable callable2) {
            this.callable = callable2;
            if (this.callableIndex < 1) {
                callable2.setBackwardsCallable();
            }
        }
    }

    public static class Callable implements AttributeLayoutElement {
        /* access modifiers changed from: private */
        public final List body;
        private int count;
        private int index;
        private boolean isBackwardsCallable;
        private boolean isFirstCallable;

        public Callable(List list) throws IOException {
            this.body = list;
        }

        public void addCount(int i11) {
            this.count += i11;
        }

        public void addNextToAttribute(NewAttribute newAttribute) {
            for (int i11 = 0; i11 < this.body.size(); i11++) {
                ((LayoutElement) this.body.get(i11)).addToAttribute(this.index, newAttribute);
            }
            this.index++;
        }

        public void addToAttribute(int i11, NewAttribute newAttribute) {
            if (this.isFirstCallable) {
                for (int i12 = 0; i12 < this.body.size(); i12++) {
                    ((LayoutElement) this.body.get(i12)).addToAttribute(this.index, newAttribute);
                }
                this.index++;
            }
        }

        public List getBody() {
            return this.body;
        }

        public boolean isBackwardsCallable() {
            return this.isBackwardsCallable;
        }

        public void readBands(InputStream inputStream, int i11) throws IOException, Pack200Exception {
            int i12;
            if (this.isFirstCallable) {
                i12 = i11 + this.count;
            } else {
                i12 = this.count;
            }
            for (int i13 = 0; i13 < this.body.size(); i13++) {
                ((LayoutElement) this.body.get(i13)).readBands(inputStream, i12);
            }
        }

        public void setBackwardsCallable() {
            this.isBackwardsCallable = true;
        }

        public void setFirstCallable(boolean z11) {
            this.isFirstCallable = z11;
        }
    }

    public class Integral extends LayoutElement {
        /* access modifiers changed from: private */
        public int[] band;
        private final String tag;

        public Integral(String str) {
            super();
            this.tag = str;
        }

        public void addToAttribute(int i11, NewAttribute newAttribute) {
            int i12;
            long j11 = (long) this.band[i11];
            if (this.tag.equals("B") || this.tag.equals("FB")) {
                newAttribute.addInteger(1, j11);
            } else if (this.tag.equals("SB")) {
                newAttribute.addInteger(1, (long) ((byte) ((int) j11)));
            } else if (this.tag.equals("H") || this.tag.equals("FH")) {
                newAttribute.addInteger(2, j11);
            } else if (this.tag.equals("SH")) {
                newAttribute.addInteger(2, (long) ((short) ((int) j11)));
            } else if (this.tag.equals("I") || this.tag.equals("FI")) {
                newAttribute.addInteger(4, j11);
            } else if (this.tag.equals("SI")) {
                newAttribute.addInteger(4, (long) ((int) j11));
            } else if (!this.tag.equals(ExifInterface.GPS_MEASUREMENT_INTERRUPTED) && !this.tag.equals("FV") && !this.tag.equals("SV")) {
                if (this.tag.startsWith("PO")) {
                    newAttribute.addBCOffset(getLength(this.tag.substring(2).toCharArray()[0]), (int) j11);
                } else if (this.tag.startsWith("P")) {
                    newAttribute.addBCIndex(getLength(this.tag.substring(1).toCharArray()[0]), (int) j11);
                } else if (this.tag.startsWith("OS")) {
                    int length = getLength(this.tag.substring(2).toCharArray()[0]);
                    if (length == 1) {
                        i12 = (byte) ((int) j11);
                    } else if (length == 2) {
                        i12 = (short) ((int) j11);
                    } else {
                        if (length == 4) {
                            i12 = (int) j11;
                        }
                        newAttribute.addBCLength(length, (int) j11);
                    }
                    j11 = (long) i12;
                    newAttribute.addBCLength(length, (int) j11);
                } else if (this.tag.startsWith("O")) {
                    newAttribute.addBCLength(getLength(this.tag.substring(1).toCharArray()[0]), (int) j11);
                }
            }
        }

        public String getTag() {
            return this.tag;
        }

        public long getValue(int i11) {
            return (long) this.band[i11];
        }

        public void readBands(InputStream inputStream, int i11) throws IOException, Pack200Exception {
            NewAttributeBands newAttributeBands = NewAttributeBands.this;
            this.band = newAttributeBands.decodeBandInt(NewAttributeBands.this.attributeLayout.getName() + JavaConstant.Dynamic.DEFAULT_NAME + this.tag, inputStream, NewAttributeBands.this.getCodec(this.tag), i11);
        }
    }

    public abstract class LayoutElement implements AttributeLayoutElement {
        private LayoutElement() {
        }

        public int getLength(char c11) {
            if (c11 == 'B') {
                return 1;
            }
            if (c11 == 'V') {
                return 0;
            }
            if (c11 != 'H') {
                return c11 != 'I' ? 0 : 4;
            }
            return 2;
        }
    }

    public class Reference extends LayoutElement {
        private Object band;
        private final int length;
        private final String tag;

        public Reference(String str) {
            super();
            this.tag = str;
            this.length = getLength(str.charAt(str.length() - 1));
        }

        public void addToAttribute(int i11, NewAttribute newAttribute) {
            if (this.tag.startsWith("KI")) {
                newAttribute.addToBody(this.length, ((CPInteger[]) this.band)[i11]);
            } else if (this.tag.startsWith("KJ")) {
                newAttribute.addToBody(this.length, ((CPLong[]) this.band)[i11]);
            } else if (this.tag.startsWith("KF")) {
                newAttribute.addToBody(this.length, ((CPFloat[]) this.band)[i11]);
            } else if (this.tag.startsWith("KD")) {
                newAttribute.addToBody(this.length, ((CPDouble[]) this.band)[i11]);
            } else if (this.tag.startsWith("KS")) {
                newAttribute.addToBody(this.length, ((CPString[]) this.band)[i11]);
            } else if (this.tag.startsWith("RC")) {
                newAttribute.addToBody(this.length, ((CPClass[]) this.band)[i11]);
            } else if (this.tag.startsWith("RS")) {
                newAttribute.addToBody(this.length, ((CPUTF8[]) this.band)[i11]);
            } else if (this.tag.startsWith("RD")) {
                newAttribute.addToBody(this.length, ((CPNameAndType[]) this.band)[i11]);
            } else if (this.tag.startsWith("RF")) {
                newAttribute.addToBody(this.length, ((CPFieldRef[]) this.band)[i11]);
            } else if (this.tag.startsWith("RM")) {
                newAttribute.addToBody(this.length, ((CPMethodRef[]) this.band)[i11]);
            } else if (this.tag.startsWith("RI")) {
                newAttribute.addToBody(this.length, ((CPInterfaceMethodRef[]) this.band)[i11]);
            } else if (this.tag.startsWith("RU")) {
                newAttribute.addToBody(this.length, ((CPUTF8[]) this.band)[i11]);
            }
        }

        public String getTag() {
            return this.tag;
        }

        public void readBands(InputStream inputStream, int i11) throws IOException, Pack200Exception {
            if (this.tag.startsWith("KI")) {
                NewAttributeBands newAttributeBands = NewAttributeBands.this;
                this.band = newAttributeBands.parseCPIntReferences(newAttributeBands.attributeLayout.getName(), inputStream, Codec.UNSIGNED5, i11);
            } else if (this.tag.startsWith("KJ")) {
                NewAttributeBands newAttributeBands2 = NewAttributeBands.this;
                this.band = newAttributeBands2.parseCPLongReferences(newAttributeBands2.attributeLayout.getName(), inputStream, Codec.UNSIGNED5, i11);
            } else if (this.tag.startsWith("KF")) {
                NewAttributeBands newAttributeBands3 = NewAttributeBands.this;
                this.band = newAttributeBands3.parseCPFloatReferences(newAttributeBands3.attributeLayout.getName(), inputStream, Codec.UNSIGNED5, i11);
            } else if (this.tag.startsWith("KD")) {
                NewAttributeBands newAttributeBands4 = NewAttributeBands.this;
                this.band = newAttributeBands4.parseCPDoubleReferences(newAttributeBands4.attributeLayout.getName(), inputStream, Codec.UNSIGNED5, i11);
            } else if (this.tag.startsWith("KS")) {
                NewAttributeBands newAttributeBands5 = NewAttributeBands.this;
                this.band = newAttributeBands5.parseCPStringReferences(newAttributeBands5.attributeLayout.getName(), inputStream, Codec.UNSIGNED5, i11);
            } else if (this.tag.startsWith("RC")) {
                NewAttributeBands newAttributeBands6 = NewAttributeBands.this;
                this.band = newAttributeBands6.parseCPClassReferences(newAttributeBands6.attributeLayout.getName(), inputStream, Codec.UNSIGNED5, i11);
            } else if (this.tag.startsWith("RS")) {
                NewAttributeBands newAttributeBands7 = NewAttributeBands.this;
                this.band = newAttributeBands7.parseCPSignatureReferences(newAttributeBands7.attributeLayout.getName(), inputStream, Codec.UNSIGNED5, i11);
            } else if (this.tag.startsWith("RD")) {
                NewAttributeBands newAttributeBands8 = NewAttributeBands.this;
                this.band = newAttributeBands8.parseCPDescriptorReferences(newAttributeBands8.attributeLayout.getName(), inputStream, Codec.UNSIGNED5, i11);
            } else if (this.tag.startsWith("RF")) {
                NewAttributeBands newAttributeBands9 = NewAttributeBands.this;
                this.band = newAttributeBands9.parseCPFieldRefReferences(newAttributeBands9.attributeLayout.getName(), inputStream, Codec.UNSIGNED5, i11);
            } else if (this.tag.startsWith("RM")) {
                NewAttributeBands newAttributeBands10 = NewAttributeBands.this;
                this.band = newAttributeBands10.parseCPMethodRefReferences(newAttributeBands10.attributeLayout.getName(), inputStream, Codec.UNSIGNED5, i11);
            } else if (this.tag.startsWith("RI")) {
                NewAttributeBands newAttributeBands11 = NewAttributeBands.this;
                this.band = newAttributeBands11.parseCPInterfaceMethodRefReferences(newAttributeBands11.attributeLayout.getName(), inputStream, Codec.UNSIGNED5, i11);
            } else if (this.tag.startsWith("RU")) {
                NewAttributeBands newAttributeBands12 = NewAttributeBands.this;
                this.band = newAttributeBands12.parseCPUTF8References(newAttributeBands12.attributeLayout.getName(), inputStream, Codec.UNSIGNED5, i11);
            }
        }
    }

    public class Replication extends LayoutElement {
        private final Integral countElement;
        /* access modifiers changed from: private */
        public final List layoutElements = new ArrayList();

        public Replication(String str, String str2) throws IOException {
            super();
            this.countElement = new Integral(str);
            StringReader stringReader = new StringReader(str2);
            while (true) {
                LayoutElement access$500 = NewAttributeBands.this.readNextLayoutElement(stringReader);
                if (access$500 != null) {
                    this.layoutElements.add(access$500);
                } else {
                    return;
                }
            }
        }

        public void addToAttribute(int i11, NewAttribute newAttribute) {
            this.countElement.addToAttribute(i11, newAttribute);
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                i12 = (int) (((long) i12) + this.countElement.getValue(i13));
            }
            long value = this.countElement.getValue(i11);
            for (int i14 = i12; ((long) i14) < ((long) i12) + value; i14++) {
                for (int i15 = 0; i15 < this.layoutElements.size(); i15++) {
                    ((LayoutElement) this.layoutElements.get(i15)).addToAttribute(i14, newAttribute);
                }
            }
        }

        public Integral getCountElement() {
            return this.countElement;
        }

        public List getLayoutElements() {
            return this.layoutElements;
        }

        public void readBands(InputStream inputStream, int i11) throws IOException, Pack200Exception {
            this.countElement.readBands(inputStream, i11);
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                i12 = (int) (((long) i12) + this.countElement.getValue(i13));
            }
            for (int i14 = 0; i14 < this.layoutElements.size(); i14++) {
                ((LayoutElement) this.layoutElements.get(i14)).readBands(inputStream, i12);
            }
        }
    }

    public class Union extends LayoutElement {
        private int[] caseCounts;
        private final List defaultCaseBody;
        private int defaultCount;
        private final List unionCases;
        private final Integral unionTag;

        public Union(String str, List list, List list2) {
            super();
            this.unionTag = new Integral(str);
            this.unionCases = list;
            this.defaultCaseBody = list2;
        }

        public void addToAttribute(int i11, NewAttribute newAttribute) {
            this.unionTag.addToAttribute(i11, newAttribute);
            int[] access$600 = this.unionTag.band;
            long value = this.unionTag.getValue(i11);
            int i12 = 0;
            boolean z11 = true;
            for (int i13 = 0; i13 < this.unionCases.size(); i13++) {
                UnionCase unionCase = (UnionCase) this.unionCases.get(i13);
                if (unionCase.hasTag(value)) {
                    for (int i14 = 0; i14 < i11; i14++) {
                        if (unionCase.hasTag((long) access$600[i14])) {
                            i12++;
                        }
                    }
                    unionCase.addToAttribute(i12, newAttribute);
                    z11 = false;
                }
            }
            if (z11) {
                int i15 = 0;
                for (int i16 = 0; i16 < i11; i16++) {
                    boolean z12 = false;
                    for (int i17 = 0; i17 < this.unionCases.size(); i17++) {
                        if (((UnionCase) this.unionCases.get(i17)).hasTag((long) access$600[i16])) {
                            z12 = true;
                        }
                    }
                    if (!z12) {
                        i15++;
                    }
                }
                if (this.defaultCaseBody != null) {
                    for (int i18 = 0; i18 < this.defaultCaseBody.size(); i18++) {
                        ((LayoutElement) this.defaultCaseBody.get(i18)).addToAttribute(i15, newAttribute);
                    }
                }
            }
        }

        public List getDefaultCaseBody() {
            return this.defaultCaseBody;
        }

        public List getUnionCases() {
            return this.unionCases;
        }

        public Integral getUnionTag() {
            return this.unionTag;
        }

        public void readBands(InputStream inputStream, int i11) throws IOException, Pack200Exception {
            this.unionTag.readBands(inputStream, i11);
            int[] access$600 = this.unionTag.band;
            this.caseCounts = new int[this.unionCases.size()];
            for (int i12 = 0; i12 < this.caseCounts.length; i12++) {
                UnionCase unionCase = (UnionCase) this.unionCases.get(i12);
                for (int i13 : access$600) {
                    if (unionCase.hasTag((long) i13)) {
                        int[] iArr = this.caseCounts;
                        iArr[i12] = iArr[i12] + 1;
                    }
                }
                unionCase.readBands(inputStream, this.caseCounts[i12]);
            }
            for (int i14 = 0; i14 < access$600.length; i14++) {
                boolean z11 = false;
                for (int i15 = 0; i15 < this.unionCases.size(); i15++) {
                    if (((UnionCase) this.unionCases.get(i15)).hasTag((long) access$600[i14])) {
                        z11 = true;
                    }
                }
                if (!z11) {
                    this.defaultCount++;
                }
            }
            if (this.defaultCaseBody != null) {
                for (int i16 = 0; i16 < this.defaultCaseBody.size(); i16++) {
                    ((LayoutElement) this.defaultCaseBody.get(i16)).readBands(inputStream, this.defaultCount);
                }
            }
        }
    }

    public NewAttributeBands(Segment segment, AttributeLayout attributeLayout2) throws IOException {
        super(segment);
        this.attributeLayout = attributeLayout2;
        parseLayout();
        attributeLayout2.setBackwardsCallCount(this.backwardsCallCount);
    }

    private Attribute getOneAttribute(int i11, List list) {
        NewAttribute newAttribute = new NewAttribute(this.segment.getCpBands().cpUTF8Value(this.attributeLayout.getName()), this.attributeLayout.getIndex());
        for (int i12 = 0; i12 < list.size(); i12++) {
            ((AttributeLayoutElement) list.get(i12)).addToAttribute(i11, newAttribute);
        }
        return newAttribute;
    }

    private StringReader getStreamUpToMatchingBracket(StringReader stringReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        int i11 = -1;
        while (i11 != 0) {
            char read = (char) stringReader.read();
            if (read == ']') {
                i11++;
            }
            if (read == '[') {
                i11--;
            }
            if (i11 != 0) {
                stringBuffer.append(read);
            }
        }
        return new StringReader(stringBuffer.toString());
    }

    private void parseLayout() throws IOException {
        if (this.attributeLayoutElements == null) {
            this.attributeLayoutElements = new ArrayList();
            StringReader stringReader = new StringReader(this.attributeLayout.getLayout());
            while (true) {
                AttributeLayoutElement readNextAttributeElement = readNextAttributeElement(stringReader);
                if (readNextAttributeElement != null) {
                    this.attributeLayoutElements.add(readNextAttributeElement);
                } else {
                    resolveCalls();
                    return;
                }
            }
        }
    }

    private List readBody(StringReader stringReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (true) {
            LayoutElement readNextLayoutElement = readNextLayoutElement(stringReader);
            if (readNextLayoutElement == null) {
                return arrayList;
            }
            arrayList.add(readNextLayoutElement);
        }
    }

    private AttributeLayoutElement readNextAttributeElement(StringReader stringReader) throws IOException {
        stringReader.mark(1);
        int read = stringReader.read();
        if (read == -1) {
            return null;
        }
        if (read == 91) {
            return new Callable(readBody(getStreamUpToMatchingBracket(stringReader)));
        }
        stringReader.reset();
        return readNextLayoutElement(stringReader);
    }

    /* access modifiers changed from: private */
    public LayoutElement readNextLayoutElement(StringReader stringReader) throws IOException {
        int read = stringReader.read();
        List list = null;
        if (read == -1) {
            return null;
        }
        if (read != 40) {
            if (read != 66) {
                if (read != 70) {
                    if (read != 75) {
                        if (!(read == 86 || read == 72 || read == 73)) {
                            switch (read) {
                                case 78:
                                    stringReader.read();
                                    return new Replication("" + ((char) stringReader.read()), readUpToMatchingBracket(stringReader));
                                case 79:
                                    stringReader.mark(1);
                                    if (stringReader.read() != 83) {
                                        stringReader.reset();
                                        return new Integral("O" + ((char) stringReader.read()));
                                    }
                                    return new Integral("OS" + ((char) stringReader.read()));
                                case 80:
                                    stringReader.mark(1);
                                    if (stringReader.read() != 79) {
                                        stringReader.reset();
                                        return new Integral("P" + ((char) stringReader.read()));
                                    }
                                    return new Integral("PO" + ((char) stringReader.read()));
                                default:
                                    switch (read) {
                                        case 82:
                                            break;
                                        case 83:
                                            break;
                                        case 84:
                                            String str = "" + ((char) stringReader.read());
                                            if (str.equals(ExifInterface.LATITUDE_SOUTH)) {
                                                str = str + ((char) stringReader.read());
                                            }
                                            ArrayList arrayList = new ArrayList();
                                            while (true) {
                                                UnionCase readNextUnionCase = readNextUnionCase(stringReader);
                                                if (readNextUnionCase != null) {
                                                    arrayList.add(readNextUnionCase);
                                                } else {
                                                    stringReader.read();
                                                    stringReader.read();
                                                    stringReader.read();
                                                    stringReader.mark(1);
                                                    if (((char) stringReader.read()) != ']') {
                                                        stringReader.reset();
                                                        list = readBody(getStreamUpToMatchingBracket(stringReader));
                                                    }
                                                    return new Union(str, arrayList, list);
                                                }
                                            }
                                        default:
                                            return null;
                                    }
                                    break;
                            }
                        }
                    }
                    StringBuilder sb2 = new StringBuilder("");
                    sb2.append((char) read);
                    sb2.append((char) stringReader.read());
                    char read2 = (char) stringReader.read();
                    sb2.append(read2);
                    if (read2 == 'N') {
                        sb2.append((char) stringReader.read());
                    }
                    return new Reference(sb2.toString());
                }
                return new Integral(new String(new char[]{(char) read, (char) stringReader.read()}));
            }
            return new Integral(new String(new char[]{(char) read}));
        }
        int intValue = readNumber(stringReader).intValue();
        stringReader.read();
        return new Call(intValue);
    }

    private UnionCase readNextUnionCase(StringReader stringReader) throws IOException {
        Integer readNumber;
        stringReader.mark(2);
        stringReader.read();
        if (((char) stringReader.read()) == ')') {
            stringReader.reset();
            return null;
        }
        stringReader.reset();
        stringReader.read();
        ArrayList arrayList = new ArrayList();
        do {
            readNumber = readNumber(stringReader);
            if (readNumber != null) {
                arrayList.add(readNumber);
                stringReader.read();
                continue;
            }
        } while (readNumber != null);
        stringReader.read();
        stringReader.mark(1);
        if (((char) stringReader.read()) == ']') {
            return new UnionCase(arrayList);
        }
        stringReader.reset();
        return new UnionCase(arrayList, readBody(getStreamUpToMatchingBracket(stringReader)));
    }

    private Integer readNumber(StringReader stringReader) throws IOException {
        String str;
        boolean z11 = true;
        stringReader.mark(1);
        int i11 = 0;
        if (((char) stringReader.read()) != '-') {
            z11 = false;
        }
        if (!z11) {
            stringReader.reset();
        }
        stringReader.mark(100);
        while (true) {
            int read = stringReader.read();
            if (read == -1 || !Character.isDigit((char) read)) {
                stringReader.reset();
            } else {
                i11++;
            }
        }
        stringReader.reset();
        if (i11 == 0) {
            return null;
        }
        char[] cArr = new char[i11];
        if (stringReader.read(cArr) == i11) {
            StringBuilder sb2 = new StringBuilder();
            if (z11) {
                str = SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE;
            } else {
                str = "";
            }
            sb2.append(str);
            sb2.append(new String(cArr));
            return Integer.valueOf(Integer.parseInt(sb2.toString()));
        }
        throw new IOException("Error reading from the input stream");
    }

    private String readUpToMatchingBracket(StringReader stringReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        int i11 = -1;
        while (i11 != 0) {
            char read = (char) stringReader.read();
            if (read == ']') {
                i11++;
            }
            if (read == '[') {
                i11--;
            }
            if (i11 != 0) {
                stringBuffer.append(read);
            }
        }
        return stringBuffer.toString();
    }

    private void resolveCalls() {
        int i11 = 0;
        for (int i12 = 0; i12 < this.attributeLayoutElements.size(); i12++) {
            AttributeLayoutElement attributeLayoutElement = (AttributeLayoutElement) this.attributeLayoutElements.get(i12);
            if (attributeLayoutElement instanceof Callable) {
                Callable callable = (Callable) attributeLayoutElement;
                if (i12 == 0) {
                    callable.setFirstCallable(true);
                }
                List access$000 = callable.body;
                for (int i13 = 0; i13 < access$000.size(); i13++) {
                    i11 += resolveCallsForElement(i12, callable, (LayoutElement) access$000.get(i13));
                }
            }
        }
        this.backwardsCallCount = i11;
    }

    private int resolveCallsForElement(int i11, Callable callable, LayoutElement layoutElement) {
        int i12 = 0;
        if (layoutElement instanceof Call) {
            Call call = (Call) layoutElement;
            int access$100 = call.callableIndex;
            if (access$100 != 0) {
                if (access$100 <= 0) {
                    int i13 = i11 - 1;
                    while (true) {
                        if (i13 < 0) {
                            break;
                        }
                        AttributeLayoutElement attributeLayoutElement = (AttributeLayoutElement) this.attributeLayoutElements.get(i13);
                        if ((attributeLayoutElement instanceof Callable) && (access$100 = access$100 + 1) == 0) {
                            call.setCallable((Callable) attributeLayoutElement);
                            break;
                        }
                        i13--;
                    }
                } else {
                    int i14 = i11 + 1;
                    while (i14 < this.attributeLayoutElements.size()) {
                        AttributeLayoutElement attributeLayoutElement2 = (AttributeLayoutElement) this.attributeLayoutElements.get(i14);
                        if (!(attributeLayoutElement2 instanceof Callable) || access$100 - 1 != 0) {
                            i14++;
                        } else {
                            call.setCallable((Callable) attributeLayoutElement2);
                            return 0;
                        }
                    }
                    return 0;
                }
            } else {
                call.setCallable(callable);
            }
            return 1;
        } else if (!(layoutElement instanceof Replication)) {
            return 0;
        } else {
            for (LayoutElement resolveCallsForElement : ((Replication) layoutElement).layoutElements) {
                i12 += resolveCallsForElement(i11, callable, resolveCallsForElement);
            }
            return i12;
        }
    }

    public int getBackwardsCallCount() {
        return this.backwardsCallCount;
    }

    public BHSDCodec getCodec(String str) {
        if (str.indexOf(79) >= 0) {
            return Codec.BRANCH5;
        }
        if (str.indexOf(80) >= 0) {
            return Codec.BCI5;
        }
        if (str.indexOf(83) >= 0 && str.indexOf("KS") < 0 && str.indexOf("RS") < 0) {
            return Codec.SIGNED5;
        }
        if (str.indexOf(66) >= 0) {
            return Codec.BYTE1;
        }
        return Codec.UNSIGNED5;
    }

    public List parseAttributes(InputStream inputStream, int i11) throws IOException, Pack200Exception {
        for (int i12 = 0; i12 < this.attributeLayoutElements.size(); i12++) {
            ((AttributeLayoutElement) this.attributeLayoutElements.get(i12)).readBands(inputStream, i11);
        }
        ArrayList arrayList = new ArrayList(i11);
        for (int i13 = 0; i13 < i11; i13++) {
            arrayList.add(getOneAttribute(i13, this.attributeLayoutElements));
        }
        return arrayList;
    }

    public void read(InputStream inputStream) throws IOException, Pack200Exception {
    }

    public void setBackwardsCalls(int[] iArr) throws IOException {
        parseLayout();
        int i11 = 0;
        for (int i12 = 0; i12 < this.attributeLayoutElements.size(); i12++) {
            AttributeLayoutElement attributeLayoutElement = (AttributeLayoutElement) this.attributeLayoutElements.get(i12);
            if (attributeLayoutElement instanceof Callable) {
                Callable callable = (Callable) attributeLayoutElement;
                if (callable.isBackwardsCallable()) {
                    callable.addCount(iArr[i11]);
                    i11++;
                }
            }
        }
    }

    public void unpack() throws IOException, Pack200Exception {
    }

    public class UnionCase extends LayoutElement {
        private List body;
        private final List tags;

        public UnionCase(List list) {
            super();
            this.tags = list;
        }

        public void addToAttribute(int i11, NewAttribute newAttribute) {
            if (this.body != null) {
                for (int i12 = 0; i12 < this.body.size(); i12++) {
                    ((LayoutElement) this.body.get(i12)).addToAttribute(i11, newAttribute);
                }
            }
        }

        public List getBody() {
            List list = this.body;
            return list == null ? Collections.EMPTY_LIST : list;
        }

        public boolean hasTag(long j11) {
            return this.tags.contains(Integer.valueOf((int) j11));
        }

        public void readBands(InputStream inputStream, int i11) throws IOException, Pack200Exception {
            if (this.body != null) {
                for (int i12 = 0; i12 < this.body.size(); i12++) {
                    ((LayoutElement) this.body.get(i12)).readBands(inputStream, i11);
                }
            }
        }

        public UnionCase(List list, List list2) throws IOException {
            super();
            this.tags = list;
            this.body = list2;
        }
    }
}
