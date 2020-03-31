package Service;
import entity.Administrator;
import repository.AdministratorRepo;

import javax.persistence.*;

public class AdministratorService {

    private AdministratorRepo adminRepo = new AdministratorRepo();

    public void insertAdministratorByName(String name, String password) {
        adminRepo.insertNewAdministratorByName(name, password);
    }

    public Administrator insertAdministrator(String name, String password) {
        return adminRepo.insertNewAdministratorByName(name, password);
    }

    public Administrator findAdminByName(String username) {
        return adminRepo.getAdminByUsername(username);
    }

    public boolean isAdminExistent(String username, String password) {
        return adminRepo.isAdminCorrect(username, password);
    }




}
