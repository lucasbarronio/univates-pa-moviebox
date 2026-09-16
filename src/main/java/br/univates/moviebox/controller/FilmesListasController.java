/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.moviebox.controller;

import br.univates.moviebox.models.FilmeLista;
import java.util.ArrayList;
import br.univates.moviebox.models.DAO.FilmesListasDAO;
import br.univates.moviebox.utils.FILMESLISTASCONTROLLER_I;

/**
 *
 * @author mateus
 */
public class FilmesListasController implements FILMESLISTASCONTROLLER_I<FilmeLista> {

    private FilmesListasDAO filmesListasDAO = new FilmesListasDAO();


    @Override
    public boolean salvar(FilmeLista o) {
        try {
            filmesListasDAO.salvar(o);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    @Override
    public boolean editar(FilmeLista o) {
        try {
            filmesListasDAO.editar(o);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }

    }

    @Override
    public boolean excluir(int codigoFilme, int codigoLista) {
        try {
            filmesListasDAO.excluir(codigoFilme, codigoLista);
            return true;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }

    @Override
    public ArrayList<FilmeLista> recuperaPorFilme(int codigo) {
        try {
            return filmesListasDAO.recuperaPorFilme(codigo);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    @Override
    public ArrayList<FilmeLista> recuperaPorLista(int codigo) {
        try {
            return filmesListasDAO.recuperaPorLista(codigo);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }

    @Override
    public ArrayList<FilmeLista> recuperarTodos() {
        try {
            return filmesListasDAO.recuperarTodos();
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    }


}
