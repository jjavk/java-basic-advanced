package com.github.advanced.common;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.SwitchTransformer;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.*;

public class TransformerUsage {
    public static void main(String[] args) {
        demoTransformerUsage();
    }

    public static void demoTransformerUsage() {
        System.out.println(StringUtils.center( " demoTransformerUsage " , 40, "=" ));
        // data setup
        Applicant[] applicants = new Applicant[] {
                new Applicant( "Tony" ,26, "Developer" ),
                new Applicant( "Michelle" ,24, "Tester" ),
                new Applicant( "Jack" ,28, "Project Manager" )
        };

        List appList = Arrays.asList(applicants);
        // predicate setup
        Predicate isDeveloper = new Predicate() {
            public boolean evaluate(Object obj) {
                Applicant app = (Applicant) obj;
                return "Developer" .equalsIgnoreCase(app.getApplyFor());
            }
        };

        Predicate isTester = new Predicate() {
            public boolean evaluate(Object obj) {
                Applicant app = (Applicant) obj;
                return "Tester" .equalsIgnoreCase(app.getApplyFor());
            }
        };

        Predicate isPM = new Predicate() {
            public boolean evaluate(Object obj) {
                Applicant app = (Applicant) obj;
                return "ProjectManager" .equalsIgnoreCase(app.getApplyFor());
            }
        };

        Predicate[] checkApplyFor = new Predicate[] {
                isDeveloper,
                isTester,
                isPM
        };

        // transformer setup
        Transformer developerTransformer = new Transformer() {
            public Object transform(Object obj) {
                Applicant app = (Applicant) obj;
                return new Employee(
                        app.getName(), app.getAge(), new Date(), "E4" , 2000
                );
            }

        };

        Transformer testerTransformer = new Transformer() {
            public Object transform(Object obj) {
                Applicant app = (Applicant) obj;
                return new Employee(
                        app.getName(), app.getAge(), new Date(), "E4" , 2000
                );
            }
        };

        Transformer pmTransformer = new Transformer() {
            public Object transform(Object obj) {
                Applicant app = (Applicant) obj;
                return new Employee(
                        app.getName(), app.getAge(), new Date(), "E5" , 3000
                );
            }
        };

        Transformer[] transformers = new Transformer[] {
                developerTransformer,
                testerTransformer,
                pmTransformer
        };

        // transform
        Transformer employTransformer = new SwitchTransformer(
                checkApplyFor, transformers, null
        );

        Collection employed = CollectionUtils.collect(appList, employTransformer);
        // output
        System.out.println( "Applicants: " );
        Iterator iter1 = appList.iterator();
        while (iter1.hasNext()) {
            System.out.println(iter1.next());
        }
        System.out.println( "Employed: " );
        Iterator iter2 = employed.iterator();
        while (iter2.hasNext()) {
            System.out.println(iter2.next());
        }
        System.out.println(StringUtils.repeat( "=" , 40));
    }

    public static class Applicant {
        private String name;
        private int age;
        private String applyFor;
        public Applicant() {
        }

        public Applicant(String name, int age, String applyFor) {
            this .name = name;
            this .age = age;
            this .applyFor = applyFor;
        }

        public String toString() {
            return new ToStringBuilder( this , ToStringStyle.SHORT_PREFIX_STYLE)
                    .append( "name" ,name)
                    .append( "age" ,age)
                    .append( "applyFor" ,applyFor)
                    .toString();
        }

        public int getAge() {
            return age;
        }

        public void setAge( int age) {
            this .age = age;
        }

        public String getApplyFor() {
            return applyFor;
        }

        public void setApplyFor(String applyFor) {
            this .applyFor = applyFor;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this .name = name;
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
