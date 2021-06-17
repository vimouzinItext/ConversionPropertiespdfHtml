package ReusingHtml;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.attach.impl.DefaultTagWorkerFactory;
import com.itextpdf.html2pdf.attach.impl.OutlineHandler;
import com.itextpdf.html2pdf.css.apply.impl.DefaultCssApplierFactory;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.styledxmlparser.css.media.MediaDeviceDescription;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ConverterProperties properties = new ConverterProperties();
        setConversionProperties(properties);
        for (int i = 0; i < 20; i ++){
            HtmlConverter.convertToPdf(new FileInputStream("inputHtml.html"),new PdfWriter("out"+i+".pdf"),properties);
        }
    }

    public static void setConversionProperties(ConverterProperties properties){
        properties.setBaseUri(".")
                .setCreateAcroForm(false)
                .setCssApplierFactory(new DefaultCssApplierFactory())
                .setFontProvider(new DefaultFontProvider())
                .setMediaDeviceDescription(MediaDeviceDescription.createDefault())
                .setOutlineHandler(new OutlineHandler())
                .setTagWorkerFactory(new DefaultTagWorkerFactory());
    }
}
