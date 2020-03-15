
package com.anna.Mid.service;

        import com.anna.Mid.dao.ClientDao;
        import com.anna.Mid.entity.Client;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;

        import java.util.Date;

@Component
public class ClientService {

    private ClientDao clientDAO;

    @Autowired
    public ClientService(ClientDao staffDAO){
        this.clientDAO = staffDAO;
    }

    public void getAllClientMembers(){
        for (Client client: clientDAO.getAllClient()) {
            System.out.println("Id: " + client.getId());
            System.out.println("First name: " + client.getName());
            System.out.println("Age: " + client.getAge());
            System.out.println("Position: " + client.getGroup().getTitle());
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - -");
        }
    }

    public void deleteClientMember(Long id) {
        int affectedRows = clientDAO.deleteClientMember(id);
        System.out.println("Affected rows: " + affectedRows);
    }

    public void createStaffMember(Client client) {
        int affectedRows = clientDAO.createClientMember(client);
        System.out.println("Affected rows: " + affectedRows);
    }

}