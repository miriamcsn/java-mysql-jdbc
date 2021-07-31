package model.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import db.DataBaseConfiguration;
import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDao createSellerDao() throws FileNotFoundException, IOException {
        return new SellerDaoJDBC(DataBaseConfiguration.getConnection());
    }

    public static DepartmentDao createDepartmentDao() throws FileNotFoundException, IOException {
        return new DepartmentDaoJDBC(DataBaseConfiguration.getConnection());
    }
}
