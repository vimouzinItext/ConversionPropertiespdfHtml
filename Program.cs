using iText.Html2pdf;
using iText.Html2pdf.Attach.Impl;
using iText.Html2pdf.Css.Apply.Impl;
using iText.Html2pdf.Resolver.Font;
using iText.Kernel.Pdf;
using iText.StyledXmlParser.Css.Media;
using System;
using System.IO;

namespace ConversionProperties
{
    class Program
    {
        static void Main(string[] args)
        {
            ConverterProperties properties = new ConverterProperties();
            SetConversionProperties(properties);
            for (int i = 0; i < 15; i++)
            {
                FileStream htmlSource = File.Open("input.html", FileMode.Open);
                FileStream pdfDest = File.Open("output.pdf", FileMode.OpenOrCreate);
                HtmlConverter.ConvertToPdf(htmlSource, pdfDest, properties);
                htmlSource.Close();
                pdfDest.Close();
            }
        }

        public static void SetConversionProperties(ConverterProperties properties)
        {
            properties.SetBaseUri(".")
                    .SetCreateAcroForm(false)
                    .SetCssApplierFactory(new DefaultCssApplierFactory())
                    .SetFontProvider(new DefaultFontProvider())
                    .SetMediaDeviceDescription(MediaDeviceDescription.CreateDefault())
                    .SetOutlineHandler(new OutlineHandler())
                    .SetTagWorkerFactory(new DefaultTagWorkerFactory());
        }
    }
}
