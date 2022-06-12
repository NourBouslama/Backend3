package com.backend.caisse.RestController;
import com.backend.caisse.service.AdminService;
import com.backend.caisse.service.CaissierService;
import com.backend.caisse.entities.Admin;
import com.backend.caisse.entities.Caissier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminRestController {

    @Autowired
    AdminService adminService;
    
    @RequestMapping(path = "/modifierAdmin",method = RequestMethod.PUT)
    public ResponseEntity<Object> modifierCaissier(@RequestBody Admin admin) {
        try{
            return new ResponseEntity<Object>(adminService.modifierAdmin(admin),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
