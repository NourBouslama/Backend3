package com.backend.caisse;

import javax.annotation.PostConstruct;

import com.backend.caisse.entities.Admin;
import com.backend.caisse.entities.Role;
import com.backend.caisse.service.AdminService;
import com.backend.caisse.service.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CaisseApplication {
	public static void main(String[] args) {
		SpringApplication.run(CaisseApplication.class, args);
	}

	/*@PostConstruct
void init_users() {
//ajouter les rôles
//Caissier c=new Caissier();
//ajouter les users
Role c=new Role(null,"admin",null);
adminService.ajouterAdmin(new Admin(null,"mat1","bouslama","jalel","jalel@gmail.com","tunis","","123",null,null));
//userService.AjouterUtilisateur(new Utilisateur(null,"mat8","ben noureddine","manar","manar@gmail.com","menzel tmim","","123",null));
//ajouter les rôles aux users
userService.AjouterRoleUtilisateur("henda@gmail.com", "admin");
//userService.AjouterPosteaUtilisateur("manar", "caissier");
}*/

	@Bean
	BCryptPasswordEncoder getBCE() {
	return new BCryptPasswordEncoder();
}


}
