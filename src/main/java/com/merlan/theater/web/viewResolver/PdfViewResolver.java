package com.merlan.theater.web.viewResolver;

import com.merlan.theater.web.view.PdfView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;


public class PdfViewResolver implements ViewResolver {
    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        PdfView view = new PdfView();
        return view;
    }
}
