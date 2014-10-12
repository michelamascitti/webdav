/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sample.caldav.xml;

import org.apache.jackrabbit.webdav.xml.DomUtil;
import org.apache.jackrabbit.webdav.xml.XmlSerializable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import sample.caldav.CalDavConstants;

/**
 * <!ELEMENT prop EMPTY>
 * <!ATTLIST prop name CDATA #REQUIRED
 *                novalue (yes | no) "no">
 *
 * @author ricky
 */
public class Prop implements XmlSerializable {

    protected String name;
    protected String novalue = "no";

    public Prop(String name) {
        this.name = name;
        this.novalue = "no";
    }

    public void Prop(String name, boolean novalue) {
        this.name = name;
        this.novalue = (novalue)? "yes":"no";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNovalue() {
        return "yes".equals(novalue);
    }

    public void setNoValue(boolean novalue) {
        this.novalue = (novalue)? "yes":"no";
    }

    public void setNovalueToNo() {
        this.novalue = "no";
    }

    public void setNovalueToYes() {
        this.novalue = "yes";
    }

    public Element toXml(Document factory) {
        Element e = DomUtil.createElement(factory, CalDavConstants.CALDAV_XML_PROP, CalDavConstants.CALDAV_NAMESPACE);
        e.setAttribute(CalDavConstants.CALDAV_XML_PROP_NAME, name);
        if (isNovalue()) {
            // default "no" is not set
            e.setAttribute(CalDavConstants.CALDAV_XML_PROP_NOVALUE, novalue);
        }
        // return
        return e;
    }
    
}
