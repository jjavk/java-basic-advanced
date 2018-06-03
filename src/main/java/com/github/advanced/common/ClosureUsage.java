package com.github.advanced.common;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class ClosureUsage {
    public static void main(String[] args) {
        demoClosureUsage();
    }

    public static void demoClosureUsage() {
        System.out.println(StringUtils.center( " demoClosureUsage " , 40, "=" ));
        // data setup
        Employee[] employees = new Employee[] {
                new Employee( "Tony" ,26, new Date(), "E4" , 2000),
                new Employee( "Michelle" ,24, new Date(), "E4" , 2000),
                new Employee( "Jack" ,28, new Date(), "E5" , 3000)
        };

        Collection empColl = Arrays.asList(employees);
        printColl( "Beforesalary increase:" , empColl);

        // closure setup
        Closure salaryIncreaseClosure = new Closure() {
            public void execute(Object obj) {
                Employee emp = (Employee) obj;
                emp.setSalary(emp.getSalary() *1.20);
            }
        };

        // salary increase
        CollectionUtils.forAllDo(empColl,salaryIncreaseClosure);
        printColl( "Aftersalary increase:" , empColl);
        System.out.println(StringUtils.repeat( "=" , 40));
    }

    public static void printColl(String label, Collection c) {
        if (StringUtils.isNotBlank(label)) {
            System.out.println(label);
        }
        Iterator iter = c.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public static class Employee {
        private String name;
        private int age;
        private Date dateJoined;
        private String grade;
        private double salary;
        public Employee() {
        }

        public Employee(String name, int age, Date dateJoined, String grade, double salary) {
            this .name = name;
            this .age = age;
            this .dateJoined = dateJoined;
            this .grade = grade;
            this .salary = salary;
        }

        public String toString() {
            return new ToStringBuilder( this , ToStringStyle.SHORT_PREFIX_STYLE)
                    .append( "name" ,name)
                    .append( "age" ,age)
                    .append( "dateJoined" , DateFormatUtils.format(dateJoined, "yyyy-MM-dd" ))
                    .append( "grade" ,grade)
                    .append( "salary" ,salary)
                    .toString();
        }

        public int getAge() {
            return age;
        }

        public void setAge( int age) {
            this .age = age;
        }

        public Date getDateJoined() {
            return dateJoined;
        }

        public void setDateJoined(Date dateJoined) {
            this .dateJoined = dateJoined;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this .grade = grade;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this .name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary( double salary) {
            this .salary = salary;
        }

    }
}
