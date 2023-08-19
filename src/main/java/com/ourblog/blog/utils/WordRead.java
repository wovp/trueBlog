package com.ourblog.blog.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 * word读取工具类
 * @author Administrator
 *
 */
public class WordRead {

    public static void main(String[] args) {
        try {
            List<String> result = readWord2("F:\\Code\\CodeSource\\JavaCode\\test\\ceshi.docx");
            System.out.println(result);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * 方式一：读取word中的文本内容（段落、表格统计获取）--- doc\docx 都可
     */
    public static String readWordText(){
        String result ="";
        String filePath = "e:\\w1.doc";
        String suffixName = filePath.substring(filePath.lastIndexOf("."));//从最后一个.开始截取。截取fileName的后缀名
        try {
            File file = new File(filePath);
            FileInputStream fs = new FileInputStream(file);
            if(suffixName.equalsIgnoreCase(".doc")){//doc
                StringBuilder result2 = new StringBuilder();
                WordExtractor re = new WordExtractor(fs);
                result2.append(re.getText());//获取word中的文本内容
                re.close();
                result = result2.toString();
            }else{//docx
                XWPFDocument doc = new XWPFDocument(fs);
                XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
                String text = extractor.getText();//获取word中的文本内容
                extractor.close();
                fs.close();
                result = text;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 方式2：读取word中的文本内容（段落、表格分开处理）   docx后缀名的Word
     * @throws IOException
     */
    public static String readWord() throws IOException{
        XWPFDocument document = new XWPFDocument(new FileInputStream("F:\\Code\\CodeSource\\JavaCode\\test\\ceshi.docx"));
        String htmlText="";
        try {
            // 获取word中的所有段落与表格
            List<IBodyElement> elements = document.getBodyElements();
            for (IBodyElement element : elements) {
                // 段落
                if (element instanceof XWPFParagraph) {
                    htmlText+=getParagraphText((XWPFParagraph) element);
                    break;
                }
                // 表格
                else if (element instanceof XWPFTable) {
                    htmlText+=getTabelText((XWPFTable) element);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            document.close();
        }
        return htmlText;
    }

    /**
     * 方式2：读取word中的文本内容（段落、表格分开处理） docx后缀名的Word
     * @param filePath 文件路径
     * @throws IOException
     */
    public static List<String> readWord2(String filePath) throws IOException{
        XWPFDocument document = new XWPFDocument(new FileInputStream(filePath));
        List<String> result = new ArrayList<>();
        try {
            List<XWPFParagraph> paragraphs = document.getParagraphs();
            for(int i = 0; i < paragraphs.size(); i++){
                result.add(paragraphs.get(i).getText());
            }
            // 获取word中的所有段落与表格
            // List<IBodyElement> elements = document.getBodyElements();
//            for (IBodyElement element : elements) {
//                // 段落
//                if (element instanceof XWPFParagraph) {
//                    htmlText+=getParagraphText((XWPFParagraph) element);
//                }
//                // 表格
//                else if (element instanceof XWPFTable) {
//                    htmlText+=getTabelText((XWPFTable) element);
//                }
//            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            document.close();
        }

        return result;
    }

    /**
     * 方式2：读取word中的文本内容（段落、表格分开处理） docx后缀名的Word
     * @param fs 文件流
     * @throws IOException
     */
    public static String readWord3(FileInputStream fs) throws IOException{
        XWPFDocument document = new XWPFDocument(fs);
        String htmlText="";
        try {
            // 获取word中的所有段落与表格
            List<IBodyElement> elements = document.getBodyElements();
            for (IBodyElement element : elements) {
                // 段落
                if (element instanceof XWPFParagraph) {
                    htmlText+=getParagraphText((XWPFParagraph) element);
                }
                // 表格
                else if (element instanceof XWPFTable) {
                    htmlText+=getTabelText((XWPFTable) element);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            document.close();
        }
        return htmlText;
    }

    /**
     * 获取段落内容（ docx后缀名的Word）
     * @param paragraph
     */
    private static String getParagraphText(XWPFParagraph paragraph) {
        // 获取段落中所有内容
        List<XWPFRun> runs = paragraph.getRuns();
        if (runs.size() == 0) {
            //System.out.println("按了回车（新段落）");
            return "";
        }
        StringBuffer runText = new StringBuffer();
        for (XWPFRun run : runs) {
            runText.append(run.text());
        }
//		if (runText.length() > 0) {
//			runText.append("，对齐方式：").append(paragraph.getAlignment().name());
//			System.out.println(runText);
//		}
        return runText.toString();
    }

    /**
     * 获取表格内容（ docx后缀名的Word）
     * @param table
     */
    private static String getTabelText(XWPFTable table) {
        String result="";
        //获取表格数据行
        List<XWPFTableRow> rows = table.getRows();
        if(rows.size()>0){
            //遍历
            for (int i=0;i<rows.size();i++) {
                XWPFTableRow row = rows.get(i);
                //获取每行的数据列
                List<XWPFTableCell> cells = row.getTableCells();
                for (XWPFTableCell cell : cells) {
                    String cellText="";
                    // 简单获取内容（简单方式是不能获取字体对齐方式的）
                    // System.out.println(cell.getText());
                    // 一个单元格可以理解为一个word文档，单元格里也可以加段落与表格
                    List<XWPFParagraph> paragraphs = cell.getParagraphs();
                    for (XWPFParagraph paragraph : paragraphs) {
                        cellText+=getParagraphText(paragraph);
                    }
                    result+=cellText;
                }
            }
        }
        return result;
    }


    /**
     * 读取word中的文本内容（段落、表格分开处理）转HTML docx后缀名的Word
     * @param filePath 文件路径
     * @throws IOException
     */
    public static String readWordToHtml(String filePath) throws IOException{
        XWPFDocument document = new XWPFDocument(new FileInputStream(filePath));
        String htmlText="";
        try {
            // 获取word中的所有段落与表格
            List<IBodyElement> elements = document.getBodyElements();
            for (IBodyElement element : elements) {
                // 段落
                if (element instanceof XWPFParagraph) {
                    htmlText+=getParagraphHtmlText((XWPFParagraph) element);
                }
                // 表格
                else if (element instanceof XWPFTable) {
                    htmlText+=getTabelHtmlText((XWPFTable) element);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            document.close();
        }
        return htmlText;
    }

    /**
     * 获取段落内容并组装段落HTML
     * @param paragraph
     */
    private static String getParagraphHtmlText(XWPFParagraph paragraph) {
        // 获取段落中所有内容
        List<XWPFRun> runs = paragraph.getRuns();
        if (runs.size() == 0) {
            //System.out.println("按了回车（新段落）");
            return "";
        }
        StringBuffer runText = new StringBuffer();
        for (XWPFRun run : runs) {
            runText.append(run.text());
        }
        return "<p style='margin:unset;text-align:"+paragraph.getAlignment().name()+"'>"+runText.toString()+"</p>";
    }

    /**
     * 获取表格内容并组装表格HTML
     * @param table
     */
    private static String getTabelHtmlText(XWPFTable table) {
        String result="";
        //获取表格数据行
        List<XWPFTableRow> rows = table.getRows();
        if(rows.size()>0){
            result+="<table border='1' cellspacing=0 style='border-collapse: collapse;'>";
            //遍历
            for (int i=0;i<rows.size();i++) {
                XWPFTableRow row = rows.get(i);
                result+="<tr style='font-weight: bold;'>";
                //获取每行的数据列
                List<XWPFTableCell> cells = row.getTableCells();
                for (XWPFTableCell cell : cells) {
                    result+="<td valign=center style='text-align: center;vertical-align: middle;'>";
                    String cellText="";
                    // 简单获取内容（简单方式是不能获取字体对齐方式的）
                    // System.out.println(cell.getText());
                    // 一个单元格可以理解为一个word文档，单元格里也可以加段落与表格
                    List<XWPFParagraph> paragraphs = cell.getParagraphs();
                    for (XWPFParagraph paragraph : paragraphs) {
                        cellText+="<p style='margin: unset;text-align:"+paragraph.getAlignment().name()+"'>"+getParagraphText(paragraph)+"</p>";
                    }
                    result+=cellText;
                    result+="</td>";
                }

                result+="</tr>";
            }
            result+="</table>";
        }
        return result;
    }

    /**
     * 通过XWPFWordExtractor读取word(后缀名为docx的文件)
     * @return
     */
    public static String readWordDocx1(){
        String result ="";
        String filePath = "e:\\w1.doc";
        try {
            File file = new File(filePath);
            FileInputStream fs = new FileInputStream(file);

            XWPFDocument doc = new XWPFDocument(fs);
            XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
            String text = extractor.getText();//获取word中的文本内容
            extractor.close();
            fs.close();
            result = text;

        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 通过XWPFDocument读取word(后缀名为docx的文件)
     * @return
     */
    public static String readWordDocx2(){
        String result ="";
        String filePath = "e:\\w1.doc";
        try {
            File file = new File(filePath);
            FileInputStream fs = new FileInputStream(file);

            XWPFDocument doc = new XWPFDocument(fs);
            XWPFWordExtractor extractor = new XWPFWordExtractor(doc);
            String text = extractor.getText();//获取word中的文本内容
            extractor.close();
            fs.close();
            result = text;

        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}