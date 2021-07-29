package com.imbharatteja.collectionDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HEqualsHashCodeClass {
    public static void main(String[] args) {

        EmployeeDetails ed1 = new EmployeeDetails(1, 11121990);
        EmployeeDetails ed2 = new EmployeeDetails(2, 21021995);
        EmployeeDetails ed3 = new EmployeeDetails(3, 15061980);
        EmployeeDetails ed4 = new EmployeeDetails(4, 31031985);

        Map<EmployeeDetails, String> cache = new HashMap<>();
        cache.put(ed1, "Bharat");
        cache.put(ed2, "Bhanu");
        cache.put(ed3, "Chandu");
        cache.put(ed4, "Srik");

        EmployeeDetails lookup = new EmployeeDetails(2, 21021995);

        System.out.println(cache.get(lookup));
        // Any Objects which are equal should have equal hashcode
        // While dealing with hash based collections, if we are overriding equals, we should override  hashcode contract as well
        /*If object1 and object2 are equal according to their equals() method, they must also have the same hash code.
                If object1 and object2 have the same hash code, they do NOT have to be equal too.
        In shorter words:

        If equal, then same hash codes too.
        Same hash codes no guarantee of being equal.*/
    }
}

class EmployeeDetails {

    int empid;
    int dob;

    public EmployeeDetails(int empid, int dob) {
        this.empid = empid;
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeDetails)) return false;
        EmployeeDetails that = (EmployeeDetails) o;
        return empid == that.empid && dob == that.dob;
    }

    @Override
    public int hashCode() {
        return Objects.hash(empid, dob);
    }
}