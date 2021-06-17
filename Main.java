package UsingPdfHtml;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfWriter;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ConverterProperties properties = new ConverterProperties();
        setBaseUri(properties);
        HtmlConverter.convertToPdf(new FileInputStream("inputHtml.html"),new PdfWriter("output.pdf"),properties);
    }

    public static void setBaseUri(ConverterProperties properties){
        properties.setBaseUri("\\Example\\main\\Resources\\HtmlResources");
    }
}
