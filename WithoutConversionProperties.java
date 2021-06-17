package ReusingHtml;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfWriter;
import java.io.FileInputStream;
import java.io.IOException;

public class WithoutConversionProperties {

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 20; i ++){
            HtmlConverter.convertToPdf(new FileInputStream("inputHtml.html"),new PdfWriter("out"+i+".pdf"));
        }
    }
}
