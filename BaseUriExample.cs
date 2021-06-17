using iText.Html2pdf;
using iText.Html2pdf.Attach.Impl;
using iText.Html2pdf.Css.Apply.Impl;
using iText.Html2pdf.Resolver.Font;
using iText.Kernel.Pdf;
using iText.StyledXmlParser.Css.Media;
using System;
using System.IO;

namespace BaseUriExample
{
    class Program
    {
        public static void Main(String[] args)
       {
          ConverterProperties properties = new ConverterProperties();
          SetBaseUri(properties);
          FileStream htmlSource = File.Open("input.html", FileMode.Open);
          FileStream pdfDest = File.Open("output.pdf", FileMode.OpenOrCreate);
          HtmlConverter.ConvertToPdf(htmlSource,pdfDest,properties);
       }

    public static void SetBaseUri(ConverterProperties properties)
    {
        properties.SetBaseUri("\\Example\\main\\Resources\\HtmlResources\\");
    }
 }
}
