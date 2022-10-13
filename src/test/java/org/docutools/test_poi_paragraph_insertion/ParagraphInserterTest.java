package org.docutools.test_poi_paragraph_insertion;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.junit.jupiter.api.Test;

class ParagraphInserterTest {

  @Test
  void insertParagraphDirectlyIntoBody() throws IOException {
    XWPFDocument document = new XWPFDocument(new FileInputStream("src/test/resources/template.docx"));
    XWPFParagraph paragraph = document.getParagraphArray(0);
    ParagraphInserter.insertParagraph(paragraph, document);
    assertEquals("Hello", document.getParagraphArray(0).getText());
    assertEquals("World", document.getParagraphArray(1).getText());
  }

  @Test
  void insertParagraphIntoTable() throws IOException {
    XWPFDocument document = new XWPFDocument(new FileInputStream("src/test/resources/template.docx"));
    XWPFTableCell cell = document.getTableArray(0).getRow(0).getCell(0);
    XWPFParagraph paragraph = cell.getParagraphArray(0);
    ParagraphInserter.insertParagraph(paragraph, document);
    assertEquals("Hello", cell.getParagraphArray(0).getText());
    assertEquals("World", cell.getParagraphArray(1).getText());
  }
}