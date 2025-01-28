package com.mandeepa.sms_backend.util;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JasperReportUtil {

    public static <T> byte[] generateReport(
            List<T> data,
            String templatePath,
            Map<String, Object> parameters
    ) throws JRException, IOException {
        JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(templatePath);
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);

        if(parameters == null) {
            parameters = new HashMap<>();
        }

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        try(ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()){
            JasperExportManager.exportReportToPdfStream(jasperPrint, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
    }
}
