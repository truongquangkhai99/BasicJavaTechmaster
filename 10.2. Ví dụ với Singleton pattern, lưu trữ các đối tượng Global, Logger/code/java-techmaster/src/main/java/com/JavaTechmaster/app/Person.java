/*
 * Khoá học Java căn bản + nâng cao, Techmaster Vietnam
 * https://techmaster.vn
 * Author: Mr Nguyen Duc Hoang
 * */
package com.JavaTechmaster.app;

public class Person {
    private String name;
    Person(String name) {
        this.name = name;
    }
    void talkToMe(Integer times) {
        if(times > 100) {
            Logger.getInstance().show("You talk too much", Logger.WARNING);
        } else if(times <= 100 && times >= 0) {
            Logger.getInstance().show("You talk to me "+times+" times", Logger.INFO);
        } else {
            Logger.getInstance().show("Times must be >= 0", Logger.ERROR);
        }
    }
}
