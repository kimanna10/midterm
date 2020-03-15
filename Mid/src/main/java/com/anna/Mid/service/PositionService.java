package com.anna.Mid.service;

        import com.anna.Mid.dao.PositionDao;
        import com.anna.Mid.entity.Position;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;

@Component
public class PositionService {

    private PositionDao positionDAO;

    @Autowired
    public PositionService(PositionDao positionDAO) {
        this.positionDAO = positionDAO;
    }

    //Method which calling dao method for creating new position
    public void createPosition(Position position){
        int affectedRows = positionDAO.createPosition(position);
        System.out.println("Affected rows: " + affectedRows);
    }

    //Method which passes id in the dao method for deleting position
    public void deletePosition(Long id){
        int affectedRows = positionDAO.deletePosition(id);
        System.out.println("Affected rows: " + affectedRows);
    }

    //Method which receives list of categories to print all categories
    public void getAllPositions(){
        for (Position position: positionDAO.getAllPositions()){
            System.out.println(position.getId() + ". " + position.getTitle());
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - -");
    }

}