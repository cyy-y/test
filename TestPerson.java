import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by wb-ljt251780 on 2017/4/7.
 */
public class TestPerson {
    private static List<Person> list=new ArrayList<>();
    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        System.out.println("---------------------菜单列表--------------------");
        System.out.println("1、添加信息\n2、查看信息条数\n3、查询信息\n4、打印列表\n5、退出系统");
        System.out.println("------------------------------------------------");
        System.out.println("请输入菜单id：");
        Scanner  sc=new Scanner(System.in);
        int i = sc.nextInt();
        switch (i){
            case 1:
               add();
                break;
            case 2:
                count();
                break;
            case 3:
                serch();
                break;
            case 4:
                list();
                break;
            case 5:
                return;
            default:
                System.out.println("没有对应的菜单项");
                break;
        }
        menu();
    }

    private static void list() {
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getId()-o2.getId();
            }
        });
        for (Person person : list) {
            System.out.println(person);
        }
    }

    private static void serch() {
        System.out.println("请输入要查询的姓名：");
        Scanner scanner=new Scanner(System.in);
        String name = scanner.nextLine();
        for (Person person : list) {
            if(person.getName().equals(name)){
                System.out.println(person);
                return;
            }
        }
        System.out.println("未查找到数据");
    }

    private static void count() {
        System.out.println("数据长度为："+list.size());
    }

    private static void add() {
        System.out.println("请输入用户id:");
        Scanner idScanner=new Scanner(System.in);
        int id = idScanner.nextInt();
        System.out.println("请输入姓名:");
        String name = idScanner.next();
        System.out.println("请输入年龄");
        int age = idScanner.nextInt();
        Person person = new Person(id, name, age);

        System.out.println(person);
        list.add(person);
    }
}
class Person{
    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public String toString() {
        String format = sf.format(new Date());
        return  format+" 序号:" + id +
                ", 姓名:" + name +
                ", 年龄:" + age ;
    }
}