/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */
package com.bpe.spring.boot.poi.data.jpa.word;


import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Writer;


public final class Word2Forrest
{
  Writer _out;
  HWPFDocument _doc;


  public Word2Forrest(HWPFDocument doc, OutputStream stream) throws Exception {
    //Blank Document
    XWPFDocument document= new XWPFDocument();

    //Write the Document in file system
    FileOutputStream out = new FileOutputStream(
            new File("applyingborder.docx"));

    //create paragraph
    XWPFParagraph paragraph = document.createParagraph();

    //Set bottom border to paragraph
    paragraph.setBorderBottom(Borders.BASIC_BLACK_DASHES);

    //Set left border to paragraph
    paragraph.setBorderLeft(Borders.BASIC_BLACK_DASHES);

    //Set right border to paragraph
    paragraph.setBorderRight(Borders.BASIC_BLACK_DASHES);

    //Set top border to paragraph
    paragraph.setBorderTop(Borders.BASIC_BLACK_DASHES);

    XWPFRun run=paragraph.createRun();
    run.setText("At tutorialspoint.com, we strive hard to " +
            "provide quality tutorials for self-learning " +
            "purpose in the domains of Academics, Information " +
            "Technology, Management and Computer Programming " +
            "Languages.");

    document.write(out);
    out.close();
    System.out.println("applyingborder.docx written successully");
  }
}
