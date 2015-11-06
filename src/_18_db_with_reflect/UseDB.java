package _18_db_with_reflect;

public class UseDB {

    public static void main(String[] args) {

        String id = "1";

        Student savedStudent = new Student();
        savedStudent.setId(id);
        savedStudent.setName("Alex");
        savedStudent.setStip("1000");
        DBManager.save(Student.class, savedStudent);

        Student loadedStudent = DBManager.get(Student.class, id);
        if (loadedStudent != null) {
            System.out.println(loadedStudent.getId());
            System.out.println(loadedStudent.getName());
            System.out.println(loadedStudent.getStip());
        }
    }
}