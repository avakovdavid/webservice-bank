/**
 * Currency.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.restfulwebservices.www.DataContracts._2008._01;

public class Currency  implements java.io.Serializable {
    private net.restfulwebservices.www.DataContracts._2008._01.CurrencyCode fromCurrency;

    private net.restfulwebservices.www.DataContracts._2008._01.CurrencyCode toCurrency;

    private java.lang.Double rate;

    public Currency() {
    }

    public Currency(
           net.restfulwebservices.www.DataContracts._2008._01.CurrencyCode fromCurrency,
           net.restfulwebservices.www.DataContracts._2008._01.CurrencyCode toCurrency,
           java.lang.Double rate) {
           this.fromCurrency = fromCurrency;
           this.toCurrency = toCurrency;
           this.rate = rate;
    }


    /**
     * Gets the fromCurrency value for this Currency.
     * 
     * @return fromCurrency
     */
    public net.restfulwebservices.www.DataContracts._2008._01.CurrencyCode getFromCurrency() {
        return fromCurrency;
    }


    /**
     * Sets the fromCurrency value for this Currency.
     * 
     * @param fromCurrency
     */
    public void setFromCurrency(net.restfulwebservices.www.DataContracts._2008._01.CurrencyCode fromCurrency) {
        this.fromCurrency = fromCurrency;
    }


    /**
     * Gets the toCurrency value for this Currency.
     * 
     * @return toCurrency
     */
    public net.restfulwebservices.www.DataContracts._2008._01.CurrencyCode getToCurrency() {
        return toCurrency;
    }


    /**
     * Sets the toCurrency value for this Currency.
     * 
     * @param toCurrency
     */
    public void setToCurrency(net.restfulwebservices.www.DataContracts._2008._01.CurrencyCode toCurrency) {
        this.toCurrency = toCurrency;
    }


    /**
     * Gets the rate value for this Currency.
     * 
     * @return rate
     */
    public java.lang.Double getRate() {
        return rate;
    }


    /**
     * Sets the rate value for this Currency.
     * 
     * @param rate
     */
    public void setRate(java.lang.Double rate) {
        this.rate = rate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Currency)) return false;
        Currency other = (Currency) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fromCurrency==null && other.getFromCurrency()==null) || 
             (this.fromCurrency!=null &&
              this.fromCurrency.equals(other.getFromCurrency()))) &&
            ((this.toCurrency==null && other.getToCurrency()==null) || 
             (this.toCurrency!=null &&
              this.toCurrency.equals(other.getToCurrency()))) &&
            ((this.rate==null && other.getRate()==null) || 
             (this.rate!=null &&
              this.rate.equals(other.getRate())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getFromCurrency() != null) {
            _hashCode += getFromCurrency().hashCode();
        }
        if (getToCurrency() != null) {
            _hashCode += getToCurrency().hashCode();
        }
        if (getRate() != null) {
            _hashCode += getRate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Currency.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.restfulwebservices.net/DataContracts/2008/01", "Currency"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fromCurrency");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.restfulwebservices.net/DataContracts/2008/01", "FromCurrency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.restfulwebservices.net/DataContracts/2008/01", "CurrencyCode"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("toCurrency");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.restfulwebservices.net/DataContracts/2008/01", "ToCurrency"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.restfulwebservices.net/DataContracts/2008/01", "CurrencyCode"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.restfulwebservices.net/DataContracts/2008/01", "Rate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
