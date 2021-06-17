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

public class ConversionProperties {

    public static void main(String[] args) throws IOException {
        ConverterProperties converterProperties = new ConverterProperties();
        setUpConversionProperties(converterProperties);
        for (int i = 0; i < 20; i ++){
            HtmlConverter.convertToPdf(new FileInputStream("inputHtml.html"),new PdfWriter("out"+i+".pdf"),converterProperties);
        }
    }
    
    public static void setUpConversionProperties(ConverterProperties properties){
                properties.setBaseUri(".")
                .setCreateAcroForm(false)
                .setCssApplierFactory(new DefaultCssApplierFactory())
                .setFontProvider(new DefaultFontProvider())
                .setMediaDeviceDescription(MediaDeviceDescription.createDefault())
                .setOutlineHandler(new OutlineHandler())
                .setTagWorkerFactory(new DefaultTagWorkerFactory());
    }
}
