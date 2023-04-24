package tests.studymateTests;

import java.util.ArrayList;
import java.util.List;

public class StudyMateBackEnd {
    private List<Group> groups = new ArrayList<>();
    private List<Student> students = new ArrayList<>();


    //CRUD for group:
    public void createGroup(Group group){
        if(group.groupName.isEmpty()){
            System.out.println("Status: Denied");
            System.out.println("Group name cannot be empty!");
        }else{
            System.out.println("Status: Success");
            System.out.println("Group is created!");
            groups.add(group);
        }
    }

    public List <Group> getGroups(){
        System.out.println("Status: Success");
        return groups;
    }

    public void updateGroup(Group existing, Group newGroup ){
        if(newGroup.groupName.isEmpty()){
            System.out.println("Status: Denied");
            System.out.println("Group name cannot be empty!");
        }else{
            System.out.println("Status: Success");
            System.out.println("Group is updated!");
            int index = groups.indexOf(existing);
            groups.remove(existing);
            groups.add(index, newGroup );
        }
    }

    public void deleteGroup(Group group){
        groups.remove(group);
        System.out.println("Status: Success");
        System.out.println("The group " + group + " was deleted");
    }

}
