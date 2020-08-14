package com.example.project;

public class vision {
    public String statement1;
    public String statement2;
    public String statement3;
    public String statement4;

    public vision(String statement1, String statement2, String statement3, String statement4) {
        this.statement1 = statement1;
        this.statement2 = statement2;
        this.statement3 = statement3;
        this.statement4 = statement4;
    }

    public vision() {
    }

    public String getStatement1() {
        return statement1;
    }

    public void setStatement1(String statement1) {
        this.statement1 = statement1;
    }

    public String getStatement2() {
        return statement2;
    }

    public void setStatement2(String statement2) {
        this.statement2 = statement2;
    }

    public String getStatement3() {
        return statement3;
    }

    public void setStatement3(String statement3) {
        this.statement3 = statement3;
    }

    public String getStatement4() {
        return statement4;
    }

    public void setStatement4(String statement4) {
        this.statement4 = statement4;
    }


    public String toString() {
        return this.statement1 + ","  + statement2 + " , " + statement3+" , "+ statement4;
    }
}
