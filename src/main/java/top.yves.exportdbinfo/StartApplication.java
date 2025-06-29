package top.yves.exportdbinfo;


/**
 * @author HeBo
 * @date 2025/6/9
 * @description
 */
public class StartApplication {
    public static void main(String[] args) {
        String inputDir = "C:\\Users\\Administrator\\Desktop\\报销\\六月报销发票"; // PDF 文件夹路径
//        String outputFile = "merged.pdf"; // 合并后文件名

        String result = PdfMerger.mergePdfs(inputDir, null);
        System.out.println(result);
    }
}
