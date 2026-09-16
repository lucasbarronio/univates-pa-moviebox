/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.moviebox.controller;

import br.univates.moviebox.models.Diretor;
import java.util.ArrayList;
import br.univates.moviebox.models.DAO.DiretoresDAO;
import br.univates.moviebox.utils.CONTROLLER_I;

/**
 *
 * @author mateus
 */
public class DiretoresController implements CONTROLLER_I<Diretor> {

    private DiretoresDAO diretoresDAO = new DiretoresDAO();


    @Override
    public boolean salvar(Diretor o) {
        try {
            diretoresDAO.salvar(o);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    @Override
    public boolean editar(Diretor o) {
        try {
            diretoresDAO.editar(o);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }

    }

    @Override
    public boolean excluir(int codigo) {
        try {
            diretoresDAO.excluir(codigo);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    @Override
    public Diretor recuperaUm(int codigo) {
        try {
            return diretoresDAO.recuperaUm(codigo);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    @Override
    public ArrayList<Diretor> recuperarTodos(String criterio) {
        try {
            return diretoresDAO.recuperarTodos(criterio);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }


}
