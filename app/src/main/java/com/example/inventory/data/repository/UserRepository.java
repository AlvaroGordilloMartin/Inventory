package com.example.inventory.data.repository;

import com.example.inventory.data.model.TypeUser;
import com.example.inventory.data.model.User;

import java.util.ArrayList;

/**
 * Esta clase será accesible desde cualquier punto de la aplicacion
 * Se accedera mediante el metodo estatico getInstance)= que devuelve
 * la instancia del repositorio que siempre se inicializa en un bloque
 * estatico
 */
public class UserRepository {
    private static UserRepository repository;
    private ArrayList<User> users;
    private int id = 4;

    /**
     * Se inicializa las propiedades estáticas del repositorio
     * en el bloque static
     */
    static {
        repository=new UserRepository();
    }

    //Constructor privado donde se incicializaran las variables de objeto.
    private UserRepository(){
        users = new ArrayList<>();
        initialice();
    }

    /**
     * Inicializa lista de usuarios
     */
    private void initialice(){
        users.add(new User(0, "alvaro", "Alvarooo1", "Alvaro", "alvaro@iesportada.org", "/img/angela", TypeUser.ADMIN));
        users.add(new User(0, "alvaro2", "Alvarooo12", "Alvaro", "alvaro@iesportada.org", "/img/angela", TypeUser.ADMIN));


    }

    /**
     * Añade usuario a la lista
     * @param user
     */
    private void add(User user){
        users.add(user);
    }

    

    public static UserRepository getInstance(){
        //No es necesario comprobar si es null porque se ha inicializado
        //en el bloque static
        return repository;
    }

    public boolean validateCredentials(String useraux, String password) {
        for (User user:users){
            if(user.getUser().equals(useraux) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }

    /**
     * Metodo que añade un usuario con solo 3 campos
     * @param useraux
     * @param password
     * @param email
     */
    public void add(String useraux, String password, String email) {
        User user=new User(id++,useraux,password,useraux,email,"/img/"+useraux,TypeUser.TECHNICAL);
        add(user);
    }

    /**
     * Metodo que comprueba si un usuario esta en el sistema
     * @param useraux
     * @return
     */
    public boolean userExists(String useraux) {
        //for User no se que
        for (User user:users){
            if(user.getUser().equals(useraux))
                return true;
        }
        return false;
    }
}
