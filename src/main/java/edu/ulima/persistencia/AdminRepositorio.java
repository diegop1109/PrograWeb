/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ulima.persistencia;


import edu.ulima.entidad.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepositorio extends JpaRepository<Admin,String> {
    public Admin findByUser(String usr);
}
