package Service;

import entity.Adress;
import entity.User;
import repository.AdressRepo;

import java.util.List;
import java.util.Set;

public class AdressService {



    AdressRepo adressRepo = new AdressRepo();

    public List<Adress> getAllAdresses()
    {
        return adressRepo.getAllAdresses();
    }

    public void deleteById(String id)
    {
        adressRepo.deleteRequestById(id);
    }

    public void insertAdress(Adress adress)
    {  adressRepo.insertNewAdress(adress);

    }

    public  void getUserAdresses( String id)
    { //return adressRepo.getUserAdresses();
    }


    public List<Adress> getAdressesByUser(User user)
    {
        return adressRepo.getAllAdressesByUser(user);
    }
}
