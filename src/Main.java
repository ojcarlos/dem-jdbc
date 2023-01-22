import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller seller = sellerDao.findById(3);
        System.out.println("=================== find by id ===========================");
        System.out.println(seller);

        System.out.println("=================== find by department ===========================");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);

        for (Seller obj : list) {
            System.out.println(obj);
        }

        Date date = new Date();
        Seller seller1 = new Seller(16,"Teste3", "teste3@teste.gmail.com" , date, 2400.00, department);
        sellerDao.insert(seller1);
        System.out.println("=================== find All===========================");
        System.out.println(seller1);
        List<Seller> list2= sellerDao.findAll();
        for (Seller obj : list2) {
            System.out.println(obj);
        }
        Seller seller2 = new Seller(1,"TesteBob", "teste3@teste.gmail.com" , date, 2400.00, department);
        sellerDao.update(seller2);
        System.out.println("=================== UPDATE ===========================");

        List<Seller> list3 = sellerDao.findAll();
        for (Seller obj : list3) {
            System.out.println(obj);
        }

    }
}