package singletonPatternTest;

import singletonPattern.JavaSingleton;

public class JavaSingletonTest {
    public static void main(String[] args) {
        JavaSingleton instance1= JavaSingleton.getInstanceOfJavaSingletonClass();
        instance1.getHascodeMessage();
        JavaSingleton instance2= JavaSingleton.getInstanceOfJavaSingletonClass();
        instance2.getHascodeMessage();
    }
}
