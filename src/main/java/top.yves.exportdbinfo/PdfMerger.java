package top.yves.exportdbinfo;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@Slf4j
public class PdfMerger {


    public static String mergePdfs(String inputDir,String outputFile) {

        try{
            File dir = new File(inputDir);
            File[] files = dir.listFiles((d, name) -> name.toLowerCase().endsWith(".pdf"));

            if (files == null || files.length == 0) {
                return "No PDF files found in: " + inputDir;
            }

            Arrays.sort(files); // 可按文件名排序

            PDFMergerUtility merger = new PDFMergerUtility();
            if (outputFile == null || outputFile.trim().isEmpty()){
                outputFile = dir.getAbsolutePath() + File.separator + "merged.pdf";
            }

            merger.setDestinationFileName(outputFile);

            for (File file : files) {
                System.out.println("Merging: " + file.getName());
                merger.addSource(file);
            }

            merger.mergeDocuments(null);
            return "Merged PDF saved as: " + outputFile;
        } catch (IOException e){
            log.error("Error merging PDFs: ", e);
            return "Error merging PDFs";
        }
    }
}

