
public class Main extends Thread {

  public static void main(String[] args) {

    Main t1 = new Main();
    Main t2 = new Main();
    System.out.println("thread1 id: "+t1.getId());
    System.out.println("thread2 id: "+t2.getId());
    t1.start();
    t2.start();

  }

  @Override
  public void run() {
    fun();
    System.out.println("This code is running in a thread");
  }

  static void fun() {
    Person a = Person.getInstance();
    Person b = Person.getInstance();
    System.out.println((a == b) + ": thread:" +currentThread().getId());
    a.setAge(10);
    System.out.println("a:"+a.getAge() + " b:"+b.getAge());
  }

}

class Person {

  private static Person instance = null;
  private int age;

  private Person() {
    age = 5;
  }

  static synchronized Person getInstance() {
    if (instance == null) {
      instance = new Person();
      return instance;
    }
    return instance;
  }

  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }

}
