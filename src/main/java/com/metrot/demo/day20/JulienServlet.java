package com.metrot.demo.day20;

import com.metrot.project.utilities.Helpers;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "measureConverter", urlPatterns = {"/julien_measure_converter"})
public class JulienServlet extends HttpServlet {

    Map<String, String> results = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/day20/julien_measure_converter.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String conversion = req.getParameter("conversion");
        String measurement = req.getParameter("measurement");
        results.clear();
        results.put("conversion", conversion);
        results.put("measurement", measurement);
        convertMeasure(conversion, measurement);
        req.setAttribute("results", results);
        req.getRequestDispatcher("WEB-INF/day20/julien_measure_converter.jsp").forward(req, resp);
    }

    public void convertMeasure(String conversion, String measurement) {
        if (conversion == null || !conversion.equals("meters") && !conversion.equals("miles") && !conversion.equals("kilometers")) {
            results.put("conversionError", "Select a conversion type");
        }
        if (!Helpers.isANumber(measurement)) {
            results.put("measurementError", "Please input a valid measurement");
        }
        if (!results.containsKey("conversionError") && !results.containsKey("measurementError")) {
            double measureDouble = Double.parseDouble(measurement);
            if (conversion.equals("meters")) {
                double convertedValue = measureDouble * 0.000621371;
                results.put("convertedMeasurement", String.format("%s meters = %.2f miles", measurement, convertedValue));
            }
            if (conversion.equals("miles")) {
                double convertedValue = measureDouble * 1609.34;
                results.put("convertedMeasurement", String.format("%s miles = %.2f meters", measurement, convertedValue));
            }
            if (conversion.equals("kilometers")) {
                double convertedValue = measureDouble * 0.621371;
                results.put("convertedMeasurement", String.format("%s kilometers = %.2f miles", measurement, convertedValue));
            }
        }
    }
}