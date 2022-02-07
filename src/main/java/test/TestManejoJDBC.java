
package test;

import data.UserDAO;

public class TestManejoJDBC {

    public static void main(String[] args) {
        
        UserDAO userDao = new UserDAO();
        
        // ------- Read DB ------
        
        /* List<User> users = userDao.select();
        
        for(User user: users){
            System.out.println("Usuario: " + user);
        } */
        
        // -------------------------------------
        
        // ------- Create record DB -------
        
        /*
        
        User createUser = new User("Test 1", "1234");
        userDao.insert(createUser);
        
        List<User> users = userDao.select();
        
        users.forEach(user -> {
            System.out.println("Usuario = " + user);
        });
        
        */
        
        // -------------------------------------
        
        // ------- Update record DB ------
        
        /* User userModify = new User(2, "UserTestUpdate", "1234");
        userDao.update(userModify);
        
        List<User> users = userDao.select();
        
        users.forEach(user -> {
            System.out.println("Usuario = " + user);
        }); */
        
        // -------------------------------------
        
        // ------- Delete record DB -------
        
        /* User deleteUser = new User(1);
        userDao.delete(deleteUser);
        
        List<User> users = userDao.select();
        
        users.forEach(user -> {
            System.out.println("Usuario = " + user);
        }); */
        
        // -------------------------------------
        
    }
    
}
