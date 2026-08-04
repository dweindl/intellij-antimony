package com.github.dweindl.intellijAntimony;

import com.github.dweindl.intellijAntimony.psi.AntimonyFile;
import com.github.dweindl.intellijAntimony.psi.AntimonyIdentifier;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiFileFactory;
import com.intellij.testFramework.ParsingTestCase;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;

import java.io.IOException;
import java.util.List;

import static com.github.dweindl.intellijAntimony.AntimonyUtil.findIdentifiers;

public class AntimonyParsingTest extends BasePlatformTestCase {

    public void testParsingAntimonyFile() throws IOException {
        String testDataDir = "src/test/testData";
        String fileName = "test2.ant";

        String antimonyCode = ParsingTestCase.loadFileDefault(testDataDir, fileName);

        PsiFile file = PsiFileFactory.getInstance(getProject()).createFileFromText(fileName, AntimonyFileType.INSTANCE, antimonyCode);
        assertTrue(file instanceof AntimonyFile);

        List<AntimonyIdentifier> ids = findIdentifiers((AntimonyFile) file, "not there");
        assertEquals(0, ids.size());

        ids = findIdentifiers((AntimonyFile) file, "k1");
        assertEquals(2, ids.size());

        ids = findIdentifiers((AntimonyFile) file, "S1");
        assertEquals(3, ids.size());
    }
}
