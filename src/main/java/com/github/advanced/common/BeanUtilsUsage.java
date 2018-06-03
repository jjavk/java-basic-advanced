package com.github.advanced.common;

import org.apache.commons.beanutils.*;
import org.apache.commons.lang3.StringUtils;

public class BeanUtilsUsage {
    public static void main(String[] args) throws Exception {

        demoNormalJavaBeans();

        demoDynaBeans();

    }

    public static void demoNormalJavaBeans() throws Exception {

        System.out.println(StringUtils.center(" demoNormalJavaBeans ", 40, "="));
        // data setup
        Address addr1 = new Address("CA1234", "xxx", "Los Angeles", "USA");
        Address addr2 = new Address("100000", "xxx", "Beijing", "China");
        Address[] addrs = new Address[2];
        addrs[0] = addr1;
        addrs[1] = addr2;
        Customer cust = new Customer(123, "John Smith", addrs);
        // accessing the city of first address
        String cityPattern = "addresses[0].city";
        String name = (String) PropertyUtils.getSimpleProperty(cust, "name");
        String city = (String) PropertyUtils.getProperty(cust, cityPattern);
        Object[] rawOutput1 = new Object[]{"The city of customer ", name,
                "'sfirst address is ", city, "."};
        System.out.println(StringUtils.join(rawOutput1));
        // setting the zipcode of customer'ssecond address
        String zipPattern = "addresses[1].zipCode";
        if (PropertyUtils.isWriteable(cust, zipPattern)) {
            System.out.println("Setting zipcode ...");
            PropertyUtils.setProperty(cust, zipPattern, "200000");
        }
        String zip = (String) PropertyUtils.getProperty(cust, zipPattern);
        Object[] rawOutput2 = new Object[]{"The zipcode of customer ", name,
                "'ssecond address is now ", zip, "."};
        System.out.println(StringUtils.join(rawOutput2));
        System.out.println();
    }

    public static void demoDynaBeans() throws Exception {
        System.out.println(StringUtils.center(" demoDynaBeans ", 40, "="));
        // creating a DynaBean
        DynaProperty[] dynaBeanProperties = new DynaProperty[]{
                new DynaProperty("name", String.class),
                new DynaProperty("inPrice", Double.class),
                new DynaProperty("outPrice", Double.class),
        };

        BasicDynaClass cargoClass = new BasicDynaClass("Cargo", BasicDynaBean.class, dynaBeanProperties);
        DynaBean cargo = cargoClass.newInstance();
        // accessing a DynaBean
        cargo.set("name", "Instant Noodles");
        cargo.set("inPrice", new Double(21.3));
        cargo.set("outPrice", new Double(23.8));
        System.out.println("name: " + cargo.get("name"));
        System.out.println("inPrice: " + cargo.get("inPrice"));
        System.out.println("outPrice: " + cargo.get("outPrice"));
        System.out.println();
    }

    public static class Customer {
        private long id;
        private String name;
        private Address[] addresses;

        public Customer() {
        }

        public Customer(long id, String name, Address[] addresses) {
            this.id = id;
            this.name = name;
            this.addresses = addresses;
        }

        public Address[] getAddresses() {
            return addresses;
        }

        public void setAddresses(Address[] addresses) {
            this.addresses = addresses;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Address {

        private String zipCode;
        private String addr;
        private String city;
        private String country;
        public Address() {
        }

        public Address(String zipCode, String addr, String city, String country) {
            this.zipCode = zipCode;
            this.addr = addr;
            this.city = city;
            this.country = country;
        }

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getZipCode() {
            return zipCode;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }
    }
}
