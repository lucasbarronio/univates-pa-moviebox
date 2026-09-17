/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.moviebox.controller;

import br.univates.moviebox.exceptions.PersistenciaException;
import br.univates.moviebox.models.Genero;
import java.util.ArrayList;
import br.univates.moviebox.models.DAO.GenerosDAO;
import br.univates.moviebox.utils.CONTROLLER_I;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mateus
 */
public class GenerosController implements CONTROLLER_I<Genero> {

    private static final Logger LOGGER = Logger.getLogger(GenerosController.class.getName());
    private GenerosDAO generosDAO = new GenerosDAO();

    @Override
    public boolean salvar(Genero genero) {
        try {
            generosDAO.salvar(genero);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao salvar gênero id=" + genero.getId(), ex);
            throw new PersistenciaException("Não foi possível salvar o gênero", ex);
        }
    }

    @Override
    public boolean editar(Genero genero) {
        try {
            generosDAO.editar(genero);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao editar gênero id=" + genero.getId(), ex);
            throw new PersistenciaException("Não foi possível editar o gênero", ex);
        }

    }

    @Override
    public boolean excluir(int idGenero) {
        try {
            generosDAO.excluir(idGenero);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao excluir gênero id=" + idGenero, ex);
            throw new PersistenciaException("Não foi possível excluir o gênero", ex);
        }
    }

    @Override
    public Genero recuperaUm(int idGenero) {
        try {
            return generosDAO.recuperaUm(idGenero);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao recuperar gênero id=" + idGenero, ex);
            throw new PersistenciaException("Não foi possível recuperar o gênero", ex);
        }
    }

    @Override
    public ArrayList<Genero> recuperarTodos(String termoBusca) {
        try {
            return generosDAO.recuperarTodos(termoBusca);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao recuperar gêneros", ex);
            throw new PersistenciaException("Não foi possível recuperar os gêneros", ex);
        }
    }

}
