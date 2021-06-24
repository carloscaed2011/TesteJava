/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author CARLOS
 */
public class Pokemon {        
    
    private String num;
    private String name;
    private ArrayList<String> tipos;
    private String pre_evolution;
    private String next_evolution;

    public Pokemon(String num, String name, ArrayList<String> tipos, String pre_evolution, String next_evolution) {
        this.num = num;
        this.name = name;
        this.tipos = tipos;
        this.pre_evolution = pre_evolution;
        this.next_evolution = next_evolution;
    }

    public Pokemon() {}

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getTipos() {
        return tipos;
    }

    public void setTipos(ArrayList<String> tipos) {
        this.tipos = tipos;
    }

    public String getPre_evolution() {
        return pre_evolution;
    }

    public void setPre_evolution(String pre_evolution) {
        this.pre_evolution = pre_evolution;
    }

    public String getNext_evolution() {
        return next_evolution;
    }

    public void setNext_evolution(String next_evolution) {
        this.next_evolution = next_evolution;
    }
    
    
}
