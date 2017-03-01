package com.example.haohoang.camera.database;

import com.example.haohoang.camera.database.classlist.ClassItem;
import com.example.haohoang.camera.models.Student;

import java.util.List;
import java.util.Vector;

/**
 * Created by haohoang on 2/28/17.
 */

public class DbContext {
    public static final DbContext instance=new DbContext();
    private List<ClassItem> classList;

    private DbContext() {
        this.classList = new Vector<>();
        classList.add(new ClassItem(45,"N01","301 A2"));
        classList.add(new ClassItem(45,"N01","301 A2"));
        classList.add(new ClassItem(45,"N01","301 A2"));
        classList.add(new ClassItem(45,"N01","301 A2"));
        classList.add(new ClassItem(45,"N01","301 A2"));
        classList.add(new ClassItem(45,"N01","301 A2"));
        classList.add(new ClassItem(45,"N01","301 A2"));
        classList.add(new ClassItem(45,"N01","301 A2"));
        classList.add(new ClassItem(45,"N01","301 A2"));
        classList.add(new ClassItem(45,"N01","301 A2"));
        classList.add(new ClassItem(45,"N01","301 A2"));
        classList.add(new ClassItem(45,"N01","301 A2"));
        classList.add(new ClassItem(45,"N01","301 A2"));
        classList.add(new ClassItem(45,"N01","301 A2"));
    }
    public void addClass(ClassItem c){
        classList.add(c);
    }
    public void removeClass(ClassItem c){
        classList.remove(c);
    }

    public List<ClassItem> allClass() {
        return classList;
    }
}
