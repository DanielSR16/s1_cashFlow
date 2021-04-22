package Model;

import DB.Connector;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Informe {
    public Informe() {
    }

    public void informe(String jasper) {

        Connector conector = new Connector();
        JasperPrint jasperPrintWindow;
        try {
            jasperPrintWindow = JasperFillManager.fillReport(
                    "Reportes/"+jasper+".jasper", null, conector.getConnectionMySql());
            JasperExportManager.exportReportToPdfFile(jasperPrintWindow, "Informes/"+jasper+".pdf");
            JasperViewer.viewReport(jasperPrintWindow, false);
        } catch (JRException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
//    }
    }
}
