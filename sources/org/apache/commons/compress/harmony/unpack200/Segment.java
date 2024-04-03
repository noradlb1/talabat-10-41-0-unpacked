package org.apache.commons.compress.harmony.unpack200;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TimeZone;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.zip.CRC32;
import org.apache.commons.compress.harmony.pack200.Pack200Exception;
import org.apache.commons.compress.harmony.unpack200.bytecode.Attribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPClass;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPField;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPMethod;
import org.apache.commons.compress.harmony.unpack200.bytecode.CPUTF8;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassConstantPool;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFile;
import org.apache.commons.compress.harmony.unpack200.bytecode.ClassFileEntry;
import org.apache.commons.compress.harmony.unpack200.bytecode.InnerClassesAttribute;
import org.apache.commons.compress.harmony.unpack200.bytecode.SourceFileAttribute;

public class Segment {
    public static final int LOG_LEVEL_QUIET = 0;
    public static final int LOG_LEVEL_STANDARD = 1;
    public static final int LOG_LEVEL_VERBOSE = 2;
    private AttrDefinitionBands attrDefinitionBands;
    private BcBands bcBands;
    private ClassBands classBands;
    private byte[][] classFilesContents;
    private CpBands cpBands;
    private boolean deflateHint;
    private boolean doPreRead;
    private FileBands fileBands;
    private boolean[] fileDeflate;
    private boolean[] fileIsClass;
    private SegmentHeader header;
    private IcBands icBands;
    private InputStream internalBuffer;
    private int logLevel;
    private PrintWriter logStream;
    private boolean overrideDeflateHint;

    private ClassFile buildClassFile(int i11) throws Pack200Exception {
        boolean z11;
        CPClass cPClass;
        CPUTF8 cputf8;
        CPClass cPClass2;
        String str;
        ClassFile classFile = new ClassFile();
        int[] classVersionMajor = this.classBands.getClassVersionMajor();
        int[] classVersionMinor = this.classBands.getClassVersionMinor();
        if (classVersionMajor != null) {
            classFile.major = classVersionMajor[i11];
            classFile.minor = classVersionMinor[i11];
        } else {
            classFile.major = this.header.getDefaultClassMajorVersion();
            classFile.minor = this.header.getDefaultClassMinorVersion();
        }
        ClassConstantPool classConstantPool = classFile.pool;
        int i12 = this.classBands.getClassThisInts()[i11];
        String str2 = this.cpBands.getCpClass()[i12];
        int lastIndexOf = str2.lastIndexOf("/") + 1;
        ArrayList arrayList = this.classBands.getClassAttributes()[i11];
        SourceFileAttribute sourceFileAttribute = null;
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            if (((Attribute) arrayList.get(i13)).isSourceFileAttribute()) {
                sourceFileAttribute = (SourceFileAttribute) arrayList.get(i13);
            }
        }
        if (sourceFileAttribute != null) {
            classFile.attributes = new Attribute[]{(Attribute) classConstantPool.add(sourceFileAttribute)};
        } else if (this.attrDefinitionBands.getAttributeDefinitionMap().getAttributeLayout(AttributeLayout.ATTRIBUTE_SOURCE_FILE, 0).matches(this.classBands.getRawClassFlags()[i11])) {
            int i14 = -1;
            for (int i15 = 0; i15 < str2.length(); i15++) {
                if (str2.charAt(i15) <= '$') {
                    i14 = i15;
                }
            }
            if (i14 <= -1 || lastIndexOf > i14) {
                str = str2.substring(lastIndexOf) + ".java";
            } else {
                str = str2.substring(lastIndexOf, i14) + ".java";
            }
            classFile.attributes = new Attribute[]{(Attribute) classConstantPool.add(new SourceFileAttribute(this.cpBands.cpUTF8Value(str, false)))};
        } else {
            classFile.attributes = new Attribute[0];
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i16 = 0; i16 < arrayList.size(); i16++) {
            Attribute attribute = (Attribute) arrayList.get(i16);
            if (!attribute.isSourceFileAttribute()) {
                arrayList2.add(attribute);
            }
        }
        Attribute[] attributeArr = classFile.attributes;
        Attribute[] attributeArr2 = new Attribute[(attributeArr.length + arrayList2.size())];
        classFile.attributes = attributeArr2;
        System.arraycopy(attributeArr, 0, attributeArr2, 0, attributeArr.length);
        for (int i17 = 0; i17 < arrayList2.size(); i17++) {
            Attribute attribute2 = (Attribute) arrayList2.get(i17);
            classConstantPool.add(attribute2);
            classFile.attributes[attributeArr.length + i17] = attribute2;
        }
        ClassFileEntry add = classConstantPool.add(this.cpBands.cpClassValue(i12));
        ClassFileEntry add2 = classConstantPool.add(this.cpBands.cpClassValue(this.classBands.getClassSuperInts()[i11]));
        int length = this.classBands.getClassInterfacesInts()[i11].length;
        ClassFileEntry[] classFileEntryArr = new ClassFileEntry[length];
        for (int i18 = 0; i18 < length; i18++) {
            classFileEntryArr[i18] = classConstantPool.add(this.cpBands.cpClassValue(this.classBands.getClassInterfacesInts()[i11][i18]));
        }
        int i19 = this.classBands.getClassFieldCount()[i11];
        ClassFileEntry[] classFileEntryArr2 = new ClassFileEntry[i19];
        for (int i21 = 0; i21 < i19; i21++) {
            int i22 = this.classBands.getFieldDescrInts()[i11][i21];
            classFileEntryArr2[i21] = classConstantPool.add(new CPField(this.cpBands.cpUTF8Value(this.cpBands.getCpDescriptorNameInts()[i22]), this.cpBands.cpSignatureValue(this.cpBands.getCpDescriptorTypeInts()[i22]), this.classBands.getFieldFlags()[i11][i21], this.classBands.getFieldAttributes()[i11][i21]));
        }
        int i23 = this.classBands.getClassMethodCount()[i11];
        ClassFileEntry[] classFileEntryArr3 = new ClassFileEntry[i23];
        for (int i24 = 0; i24 < i23; i24++) {
            int i25 = this.classBands.getMethodDescrInts()[i11][i24];
            classFileEntryArr3[i24] = classConstantPool.add(new CPMethod(this.cpBands.cpUTF8Value(this.cpBands.getCpDescriptorNameInts()[i25]), this.cpBands.cpSignatureValue(this.cpBands.getCpDescriptorTypeInts()[i25]), this.classBands.getMethodFlags()[i11][i24], this.classBands.getMethodAttributes()[i11][i24]));
        }
        classConstantPool.addNestedEntries();
        IcTuple[] icTupleArr = getClassBands().getIcLocal()[i11];
        if (icTupleArr != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        InnerClassesAttribute innerClassesAttribute = new InnerClassesAttribute(AttributeLayout.ATTRIBUTE_INNER_CLASSES);
        IcTuple[] relevantIcTuples = getIcBands().getRelevantIcTuples(str2, classConstantPool);
        List computeIcStored = computeIcStored(icTupleArr, relevantIcTuples);
        int i26 = 0;
        boolean z12 = false;
        while (i26 < computeIcStored.size()) {
            IcTuple icTuple = (IcTuple) computeIcStored.get(i26);
            List list = computeIcStored;
            int thisClassIndex = icTuple.thisClassIndex();
            ClassFileEntry[] classFileEntryArr4 = classFileEntryArr3;
            int outerClassIndex = icTuple.outerClassIndex();
            ClassFileEntry[] classFileEntryArr5 = classFileEntryArr2;
            int simpleClassNameIndex = icTuple.simpleClassNameIndex();
            ClassFileEntry[] classFileEntryArr6 = classFileEntryArr;
            String thisClassString = icTuple.thisClassString();
            int i27 = length;
            String outerClassString = icTuple.outerClassString();
            ClassFileEntry classFileEntry = add2;
            String simpleClassName = icTuple.simpleClassName();
            ClassFileEntry classFileEntry2 = add;
            if (thisClassIndex != -1) {
                cPClass = this.cpBands.cpClassValue(thisClassIndex);
            } else {
                cPClass = this.cpBands.cpClassValue(thisClassString);
            }
            if (icTuple.isAnonymous()) {
                cputf8 = null;
            } else if (simpleClassNameIndex != -1) {
                cputf8 = this.cpBands.cpUTF8Value(simpleClassNameIndex);
            } else {
                cputf8 = this.cpBands.cpUTF8Value(simpleClassName);
            }
            if (!icTuple.isMember()) {
                cPClass2 = null;
            } else if (outerClassIndex != -1) {
                cPClass2 = this.cpBands.cpClassValue(outerClassIndex);
            } else {
                cPClass2 = this.cpBands.cpClassValue(outerClassString);
            }
            innerClassesAttribute.addInnerClassesEntry(cPClass, cPClass2, cputf8, icTuple.F);
            i26++;
            computeIcStored = list;
            classFileEntryArr3 = classFileEntryArr4;
            classFileEntryArr2 = classFileEntryArr5;
            classFileEntryArr = classFileEntryArr6;
            length = i27;
            add2 = classFileEntry;
            add = classFileEntry2;
            z12 = true;
        }
        ClassFileEntry classFileEntry3 = add;
        ClassFileEntry classFileEntry4 = add2;
        int i28 = length;
        ClassFileEntry[] classFileEntryArr7 = classFileEntryArr3;
        ClassFileEntry[] classFileEntryArr8 = classFileEntryArr;
        ClassFileEntry[] classFileEntryArr9 = classFileEntryArr2;
        if (z11 && icTupleArr.length == 0) {
            z12 = false;
        }
        if (!z11 && relevantIcTuples.length == 0) {
            z12 = false;
        }
        if (z12) {
            Attribute[] attributeArr3 = classFile.attributes;
            int length2 = attributeArr3.length + 1;
            Attribute[] attributeArr4 = new Attribute[length2];
            for (int i29 = 0; i29 < attributeArr3.length; i29++) {
                attributeArr4[i29] = attributeArr3[i29];
            }
            attributeArr4[length2 - 1] = innerClassesAttribute;
            classFile.attributes = attributeArr4;
            classConstantPool.addWithNestedEntries(innerClassesAttribute);
        }
        classConstantPool.resolve(this);
        classFile.accessFlags = (int) this.classBands.getClassFlags()[i11];
        classFile.thisClass = classConstantPool.indexOf(classFileEntry3);
        classFile.superClass = classConstantPool.indexOf(classFileEntry4);
        int i31 = i28;
        classFile.interfaces = new int[i31];
        for (int i32 = 0; i32 < i31; i32++) {
            classFile.interfaces[i32] = classConstantPool.indexOf(classFileEntryArr8[i32]);
        }
        classFile.fields = classFileEntryArr9;
        classFile.methods = classFileEntryArr7;
        return classFile;
    }

    private List computeIcStored(IcTuple[] icTupleArr, IcTuple[] icTupleArr2) {
        ArrayList arrayList = new ArrayList(icTupleArr2.length);
        ArrayList arrayList2 = new ArrayList(icTupleArr2.length);
        HashSet hashSet = new HashSet(icTupleArr2.length);
        if (icTupleArr != null) {
            for (int i11 = 0; i11 < icTupleArr.length; i11++) {
                if (hashSet.add(icTupleArr[i11])) {
                    arrayList.add(icTupleArr[i11]);
                }
            }
        }
        for (int i12 = 0; i12 < icTupleArr2.length; i12++) {
            if (hashSet.add(icTupleArr2[i12])) {
                arrayList.add(icTupleArr2[i12]);
            } else {
                arrayList2.add(icTupleArr2[i12]);
            }
        }
        for (int i13 = 0; i13 < arrayList2.size(); i13++) {
            arrayList.remove((IcTuple) arrayList2.get(i13));
        }
        return arrayList;
    }

    private void parseSegment() throws IOException, Pack200Exception {
        boolean z11;
        boolean z12;
        this.header.unpack();
        this.cpBands.unpack();
        this.attrDefinitionBands.unpack();
        this.icBands.unpack();
        this.classBands.unpack();
        this.bcBands.unpack();
        this.fileBands.unpack();
        int numberOfFiles = this.header.getNumberOfFiles();
        String[] fileName = this.fileBands.getFileName();
        int[] fileOptions = this.fileBands.getFileOptions();
        SegmentOptions options = this.header.getOptions();
        this.classFilesContents = new byte[numberOfFiles][];
        this.fileDeflate = new boolean[numberOfFiles];
        this.fileIsClass = new boolean[numberOfFiles];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        int i11 = 0;
        for (int i12 = 0; i12 < numberOfFiles; i12++) {
            String str = fileName[i12];
            boolean z13 = true;
            if (str == null || str.equals("")) {
                z11 = true;
            } else {
                z11 = false;
            }
            if ((fileOptions[i12] & 2) == 2 || z11) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12 && z11) {
                fileName[i12] = this.cpBands.getCpClass()[this.classBands.getClassThisInts()[i11]] + ".class";
            }
            if (!this.overrideDeflateHint) {
                boolean[] zArr = this.fileDeflate;
                if ((fileOptions[i12] & 1) != 1 && !options.shouldDeflate()) {
                    z13 = false;
                }
                zArr[i12] = z13;
            } else {
                this.fileDeflate[i12] = this.deflateHint;
            }
            this.fileIsClass[i12] = z12;
            if (z12) {
                buildClassFile(i11).write(dataOutputStream);
                dataOutputStream.flush();
                this.classFilesContents[i11] = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.reset();
                i11++;
            }
        }
    }

    private void readSegment(InputStream inputStream) throws IOException, Pack200Exception {
        log(2, "-------");
        CpBands cpBands2 = new CpBands(this);
        this.cpBands = cpBands2;
        cpBands2.read(inputStream);
        AttrDefinitionBands attrDefinitionBands2 = new AttrDefinitionBands(this);
        this.attrDefinitionBands = attrDefinitionBands2;
        attrDefinitionBands2.read(inputStream);
        IcBands icBands2 = new IcBands(this);
        this.icBands = icBands2;
        icBands2.read(inputStream);
        ClassBands classBands2 = new ClassBands(this);
        this.classBands = classBands2;
        classBands2.read(inputStream);
        BcBands bcBands2 = new BcBands(this);
        this.bcBands = bcBands2;
        bcBands2.read(inputStream);
        FileBands fileBands2 = new FileBands(this);
        this.fileBands = fileBands2;
        fileBands2.read(inputStream);
        this.fileBands.processFileBits();
    }

    public AttrDefinitionBands getAttrDefinitionBands() {
        return this.attrDefinitionBands;
    }

    public ClassBands getClassBands() {
        return this.classBands;
    }

    public SegmentConstantPool getConstantPool() {
        return this.cpBands.getConstantPool();
    }

    public CpBands getCpBands() {
        return this.cpBands;
    }

    public IcBands getIcBands() {
        return this.icBands;
    }

    public SegmentHeader getSegmentHeader() {
        return this.header;
    }

    public void log(int i11, String str) {
        if (this.logLevel >= i11) {
            this.logStream.println(str);
        }
    }

    public void overrideDeflateHint(boolean z11) {
        this.overrideDeflateHint = true;
        this.deflateHint = z11;
    }

    public void setLogLevel(int i11) {
        this.logLevel = i11;
    }

    public void setLogStream(OutputStream outputStream) {
        this.logStream = new PrintWriter(outputStream);
    }

    public void setPreRead(boolean z11) {
        this.doPreRead = z11;
    }

    public void unpack(InputStream inputStream, JarOutputStream jarOutputStream) throws IOException, Pack200Exception {
        unpackRead(inputStream);
        unpackProcess();
        unpackWrite(jarOutputStream);
    }

    public void unpackProcess() throws IOException, Pack200Exception {
        InputStream inputStream = this.internalBuffer;
        if (inputStream != null) {
            readSegment(inputStream);
        }
        parseSegment();
    }

    public void unpackRead(InputStream inputStream) throws IOException, Pack200Exception {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream);
        }
        SegmentHeader segmentHeader = new SegmentHeader(this);
        this.header = segmentHeader;
        segmentHeader.read(inputStream);
        int archiveSize = ((int) this.header.getArchiveSize()) - this.header.getArchiveSizeOffset();
        if (!this.doPreRead || this.header.getArchiveSize() == 0) {
            readSegment(inputStream);
            return;
        }
        byte[] bArr = new byte[archiveSize];
        inputStream.read(bArr);
        this.internalBuffer = new BufferedInputStream(new ByteArrayInputStream(bArr));
    }

    public void unpackWrite(JarOutputStream jarOutputStream) throws IOException, Pack200Exception {
        writeJar(jarOutputStream);
        PrintWriter printWriter = this.logStream;
        if (printWriter != null) {
            printWriter.close();
        }
    }

    public void writeJar(JarOutputStream jarOutputStream) throws IOException, Pack200Exception {
        int[] iArr;
        String[] strArr;
        JarOutputStream jarOutputStream2 = jarOutputStream;
        String[] fileName = this.fileBands.getFileName();
        int[] fileModtime = this.fileBands.getFileModtime();
        long[] fileSize = this.fileBands.getFileSize();
        byte[][] fileBits = this.fileBands.getFileBits();
        int numberOfFiles = this.header.getNumberOfFiles();
        long archiveModtime = this.header.getArchiveModtime();
        int i11 = 0;
        int i12 = 0;
        while (i11 < numberOfFiles) {
            String str = fileName[i11];
            long j11 = (((long) fileModtime[i11]) + archiveModtime) * 1000;
            boolean z11 = this.fileDeflate[i11];
            JarEntry jarEntry = new JarEntry(str);
            if (z11) {
                jarEntry.setMethod(8);
                strArr = fileName;
                iArr = fileModtime;
            } else {
                jarEntry.setMethod(0);
                CRC32 crc32 = new CRC32();
                if (this.fileIsClass[i11]) {
                    crc32.update(this.classFilesContents[i12]);
                    strArr = fileName;
                    iArr = fileModtime;
                    jarEntry.setSize((long) this.classFilesContents[i12].length);
                } else {
                    strArr = fileName;
                    iArr = fileModtime;
                    crc32.update(fileBits[i11]);
                    jarEntry.setSize(fileSize[i11]);
                }
                jarEntry.setCrc(crc32.getValue());
            }
            jarEntry.setTime(j11 - ((long) TimeZone.getDefault().getRawOffset()));
            jarOutputStream2.putNextEntry(jarEntry);
            if (this.fileIsClass[i11]) {
                jarEntry.setSize((long) this.classFilesContents[i12].length);
                jarOutputStream2.write(this.classFilesContents[i12]);
                i12++;
            } else {
                jarEntry.setSize(fileSize[i11]);
                jarOutputStream2.write(fileBits[i11]);
            }
            i11++;
            fileName = strArr;
            fileModtime = iArr;
        }
    }
}
