package tests;

public class studyMateFrontEnd {
    public static void main(String[] args) {
        studyMate_practice codewise = new studyMate_practice();
        System.out.println(codewise.getGroups());
        codewise.createGroup("Index Zero");
        codewise.createGroup("Brain Tech");
        codewise.createGroup("Bug Hunters");
        System.out.println(codewise.getGroups());
        codewise.editGroup("Index Zero", "Index Hundred");
        System.out.println(codewise.getGroups());


        //Group entities:
        String groupName;
        String description;
        String graduationDate;
        String image; 
    }

}
