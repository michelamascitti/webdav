/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.caldav.xml;

import java.util.Date;
import sample.caldav.CalDavConstants;

/**
 * <!ELEMENT time-range EMPTY>
 * <!ATTLIST time-range start CDATA #IMPLIED
 *                      end   CDATA #IMPLIED>
 *
 * Although it is IMPLIED instead of REQUIRED it will be used as
 * start and end were compulsory.
 *
 * @author ricky
 */
public class TimeRange extends StartEndRequiredData {

    public TimeRange(Date start, Date end) {
        super(CalDavConstants.CALDAV_XML_TIME_RANGE, start, end);
    }

}
