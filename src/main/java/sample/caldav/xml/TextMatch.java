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
 * <!ELEMENT text-match (#PCDATA)>
 * <!ATTLIST text-match collation CDATA "i;ascii-casemap"
 *                      negate-condition (yes | no) "no">
 *
 * @author ricky
 */
public class TextMatch implements XmlSerializable {

    private String collation = "i;ascii-casemap";
    private String negateCondition = "no";
    private String value;

    public TextMatch(String value) {
        this.value = value;
    }

    public TextMatch(String value, boolean negateCondition) {
        this.value = value;
        this.negateCondition = negateCondition? "yes":"no";
    }

    public String getCollation() {
        return collation;
    }

    public void setCollation(String collation) {
        this.collation = collation;
    }

    public boolean isNegateCondition() {
        return "yes".equals(negateCondition);
    }

    public void setNegateCondition(boolean negateCondition) {
        this.negateCondition = negateCondition? "yes":"no";
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Element toXml(Document factory) {
        Element e = DomUtil.createElement(factory,
                CalDavConstants.CALDAV_XML_TEXT_MATCH, CalDavConstants.CALDAV_NAMESPACE);
        // collation
        e.setAttribute(CalDavConstants.CALDAV_XML_COLLATION, collation);
        // negate-condition
        if (isNegateCondition()) {
            // ony if yes
            e.setAttribute(CalDavConstants.CALDAV_XML_NEGATE_CONDITION, collation);
        }
        // set the value
        e.setTextContent(value);
        return e;
    }

}
