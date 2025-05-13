package singletonPattern;

import java.io.Serializable;

public class JavaSingleton implements Serializable,Cloneable {
    private static JavaSingleton instance;
    private JavaSingleton(){
        // Prevent reflection API to create object of the class directly
        if(instance!=null){
            throw new RuntimeException("Cannot create the object of the class - TestAutomationSingleton");
        }
    }
    public static JavaSingleton getInstanceOfJavaSingletonClass(){
        synchronized (JavaSingleton.class) {
            if (instance == null) {
                instance = new JavaSingleton();
            }
        }
        return instance;
    }
    public void getHascodeMessage(){
        System.out.println("Used an instance of JavaSingleton class " +
                "to call the getHascodeMessage() method : "+ instance.hashCode());
    }
    // Prevents serializable interface to create new instance of this class
    protected Object readResolve(){
        return getInstanceOfJavaSingletonClass();
    }
    // Prevents cloneable interface to create new instance of this class
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("JavaSingleton cannot be cloned");
    }
}
