/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.caldav;

import org.apache.jackrabbit.webdav.DavException;
import org.apache.jackrabbit.webdav.DavResource;
import org.apache.jackrabbit.webdav.version.DeltaVConstants;
import org.apache.jackrabbit.webdav.version.report.Report;
import org.apache.jackrabbit.webdav.version.report.ReportInfo;
import org.apache.jackrabbit.webdav.version.report.ReportType;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author ricky
 */
public class CalendarMultiGetReport implements Report, DeltaVConstants {

    public static final ReportType CALENDAR_MULTI_GET = ReportType.register(
            CalDavConstants.CALDAV_XML_CALENDAR_MULTI_GET,
            CalDavConstants.CALDAV_NAMESPACE,
            CalendarMultiGetReport.class);

    public ReportType getType() {
        return CALENDAR_MULTI_GET;
    }

    public boolean isMultiStatusReport() {
        return true;
    }

    public void init(DavResource dr, ReportInfo ri) throws DavException {
    }

    public Element toXml(Document dcmnt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    

}
