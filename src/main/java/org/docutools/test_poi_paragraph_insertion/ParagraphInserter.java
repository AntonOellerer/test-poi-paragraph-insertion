package org.docutools.test_poi_paragraph_insertion;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.xmlbeans.XmlCursor;

public class ParagraphInserter {
  public static void insertParagraph(XWPFParagraph xwpfParagraph, XWPFDocument document) {
    XmlCursor xmlCursor = xwpfParagraph.getCTP().newCursor();
    XWPFParagraph xwpfParagraph2 = document.insertNewParagraph(xmlCursor);
    xwpfParagraph2.createRun().setText("Hello");
  }
}
