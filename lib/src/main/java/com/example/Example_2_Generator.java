package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.objectweb.asm.ClassAdapter;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;



public class Example_2_Generator {

    public static void main(String[] args){
        try {
            ClassReader cr = new ClassReader("com.example/MyClass");
            ClassWriter cw = new ClassWriter(true);
            ClassAdapter classAdapter = new AddTimeClassAdapter(cw);

            cr.accept(classAdapter, true);
            byte[] data = cw.toByteArray();
            File file = new File(System.getProperty("user.dir") + "\\lib\\build\\classes\\main\\com\\example\\MyClass2.class");
            FileOutputStream fout = new FileOutputStream(file);
            fout.write(data);
            fout.close();
            System.out.println("success!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}