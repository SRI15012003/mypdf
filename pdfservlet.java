package com.example.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class PdfServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String file = request.getParameter("file");
        if (file == null) return;

        File pdf = new File(getServletContext().getRealPath("/pdfs/" + file));
        response.setContentType("application/pdf");
        try (FileInputStream in = new FileInputStream(pdf);
             OutputStream out = response.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, len, 0, len);
            }
        }
    }
}
