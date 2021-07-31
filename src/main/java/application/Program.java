package application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

    public static void main(String[] args) throws FileNotFoundException, IOException {

//		Department obj = new Department(1, "Books");
//		Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
//		System.out.println(obj);

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== CLASS SELLER TESTS ===");


        System.out.println("=== TEST 1: seller findById ===");

        Seller seller1 = sellerDao.findById(3);

        System.out.println(seller1);



        System.out.println("=== TEST 2: seller findByDepartment ===");

        Department department = new Department(2, null);

        List<Seller> listSeller = sellerDao.findByDepartment(department);

        listSeller.forEach(System.out::println); // chamei um consumer aqui :)



        System.out.println("=== TEST 3: seller findAll ===");

        List<Seller> listSeller2 = sellerDao.findAll(); // poderia reaproveitar a lista de cima tb!

        listSeller2.forEach(System.out::println);



        System.out.println("=== TEST 4: seller insert ===");

        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);

        System.out.println("Inserted! ID: " + newSeller.getId());

        System.out.println(newSeller);



        System.out.println("=== TEST 5: seller update ===");

        newSeller = sellerDao.findById(1);
        newSeller.setName("Martha Waine");
        sellerDao.update(newSeller);

        System.out.println("Update completed.");


        System.out.println("=== TEST 6: seller delete ===");

        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed");




        System.out.println("=== CLASS DEPARTMENT TESTS ===");


        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: findById =======");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println("\n=== TEST 2: findAll =======");
        List<Department> list = departmentDao.findAll();
        for (Department d : list) {
            System.out.println(d);
        }

        System.out.println("\n=== TEST 3: insert =======");
        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());

        System.out.println("\n=== TEST 4: update =======");
        Department dep2 = departmentDao.findById(1);
        dep2.setName("Food");
        departmentDao.update(dep2);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 5: delete =======");
        System.out.print("Enter id for delete test: ");
        int id2 = sc.nextInt();
        departmentDao.deleteById(id2);
        System.out.println("Delete completed");

        sc.close();

    }
}