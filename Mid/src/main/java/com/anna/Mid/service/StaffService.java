package com.anna.Mid.service;

        import com.anna.Mid.dao.StaffDao;
        import com.anna.Mid.entity.Staff;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;

        import java.util.Date;

@Component
public class StaffService {

    private StaffDao staffDAO;

    @Autowired
    public StaffService(StaffDao staffDAO){
        this.staffDAO = staffDAO;
    }

    public void getAllStaffMembers(){
        for (Staff staff: staffDAO.getAllStaff()) {
            System.out.println("Id: " + staff.getId());
            System.out.println("First name: " + staff.getName());
            System.out.println("Age: " + staff.getAge());
            System.out.println("Position: " + staff.getPosition().getTitle());
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
        }
    }

    public void deleteStaffMember(Long id) {
        int affectedRows = staffDAO.deleteStaffMember(id);
        System.out.println("Affected rows: " + affectedRows);
    }

    public void createStaffMember(Staff staff) {
        int affectedRows = staffDAO.createStaffMember(staff);
        System.out.println("Affected rows: " + affectedRows);
    }

    //Print staff member's info and his salary
    public void calculateStaffMemberSalary(Date date, Long id){
        for (Staff staff: staffDAO.calculateSalary(id, date)) {
            System.out.println("Id: " + staff.getId());
            System.out.println("First name: " + staff.getName());
            System.out.println("Salary: " + staff.getSalary());
        }
    }
}