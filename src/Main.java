import apr.Apr;
import apr.JavaApr;
import apr.Type;
import attendance.AttendanceList;
import classroom.Classroom;
import converter.IConverter;
import converter.impl.AprConverter;
import dto.AprDto;
import factory.AprFactory;
import session.OnsiteSession;
import session.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        // Factory
        AprFactory aprFactory = new AprFactory();
        AprDto aprDto = new AprDto("Hamza", "Hamza", 2001, Type.JAVA);

        IConverter converter1 = new AprConverter();
        Apr aprEntity = converter1.toEntity(aprDto);
        Apr apr1 = aprFactory.getInstance(aprEntity);




        //Java students list
        ArrayList<AprDto> javaStudents = new ArrayList<>(
                List.of(
                        new AprDto("Hamid", "Hamid", 2001, Type.JAVA),
                        new AprDto("Ayman", "Ayman", 2002, Type.JAVA),
                        new AprDto("Redwan", "Redwan", 1995, Type.JAVA)
                )
        );

        //Dotnet students list
        ArrayList<AprDto> dotnetStudents = new ArrayList<>(
                List.of(
                        new AprDto("Fatima", "Fatima", 2001, Type.DONTNET),
                        new AprDto("Walid", "Walid", 2002, Type.DONTNET),
                        new AprDto("Youssef", "Youssef", 1995, Type.DONTNET)
                )
        );

        IConverter converter = new AprConverter();
        //List<Apr> javaStudentsEntities = javaStudents.
          //      stream().
             //   map(converter::toEntity).   // map(aprDto -> converter.toEntity(aprDto)).
             //   toList();

        ArrayList<Apr> javaStudentsEntities = new ArrayList<>();
        for (AprDto javaStudent : javaStudents) {
            Apr apr = converter.toEntity(javaStudent);
            javaStudentsEntities.add(apr);
        }
        ArrayList<Apr> dotNetStudentsEntities = new ArrayList<>();
        for (AprDto dotNetStudent : dotnetStudents) {
            Apr apr = converter.toEntity(dotNetStudent);
            dotNetStudentsEntities.add(apr);
        }





        //  USER transformator (DTO)
        //Creating attendance lists
        AttendanceList javaAttendanceList = new AttendanceList(javaStudentsEntities);
        AttendanceList dotnetAttendanceList = new AttendanceList(dotNetStudentsEntities);

        //Creating session
        Session javaSession = new OnsiteSession("Java EE", "05/02/2024", javaAttendanceList);
        Session dotnetSession = new OnsiteSession("Entity Framework", "16/01/2025", dotnetAttendanceList);

        Classroom amphi4 = new Classroom(4, 5, 20, javaSession);
        Classroom amphi2 = new Classroom(2, 10, 40, dotnetSession);

        ArrayList<Classroom> classrooms = new ArrayList<>(List.of(
                amphi2, amphi4
        ));


        boolean exit = false;
        Scanner s = new Scanner(System.in);

        System.out.println("*******************************************");
        String exitAttendanceList = "";

        System.out.println("Java Students, sign your attendance:");
        while (!exitAttendanceList.toLowerCase().equals("e")) {

            String ref = s.next();
            amphi4.getSession().getAttendanceList().sign(ref);
            System.out.println("Enter 'E' to exit or C to continue");
            exitAttendanceList = s.next();
            System.out.println("Next:");
        }

        System.out.println("*******************************************");
        exitAttendanceList = "";

        System.out.println("Dotnet Students, sign your attendance:");
        while (!exitAttendanceList.toLowerCase().equals("e")) {
            String ref = s.next();
            amphi2.getSession().getAttendanceList().sign(ref);
            System.out.println("Enter 'E' to exit or C to continue");
            exitAttendanceList = s.next();
            System.out.println("Next:");
        }

        classrooms.forEach(c -> {
            try {
                c.getSession().getAttendanceList().printAttendanceList();
            } catch (Exception e) {
                System.out.println("");
            }
        });


    }
}