/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.moviebox.controller;

import br.univates.moviebox.exceptions.PersistenciaException;
import br.univates.moviebox.models.Filme;
import java.util.ArrayList;
import br.univates.moviebox.models.DAO.FilmesDAO;
import br.univates.moviebox.utils.CONTROLLER_I;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mateus
 */
public class FilmesController implements CONTROLLER_I<Filme> {

    private static final Logger LOGGER = Logger.getLogger(FilmesController.class.getName());
    private FilmesDAO filmesDAO = new FilmesDAO();

    @Override
    public boolean salvar(Filme o) {
        try {
            filmesDAO.salvar(o);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao salvar filme id=" + o.getId(), ex);
            throw new PersistenciaException("Não foi possível salvar o filme", ex);
        }
    }

    @Override
    public boolean editar(Filme o) {
        try {
            filmesDAO.editar(o);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao editar filme id=" + o.getId(), ex);
            throw new PersistenciaException("Não foi possível editar o filme", ex);
        }

    }

    @Override
    public boolean excluir(int codigo) {
        try {
            filmesDAO.excluir(codigo);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao excluir filme id=" + codigo, ex);
            throw new PersistenciaException("Não foi possível excluir o filme", ex);
        }
    }

    @Override
    public Filme recuperaUm(int codigo) {
        try {
            return filmesDAO.recuperaUm(codigo);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao recuperar filme id=" + codigo, ex);
            throw new PersistenciaException("Não foi possível recuperar o filme", ex);
        }
    }

    @Override
    public ArrayList<Filme> recuperarTodos(String criterio) {
        try {
            return filmesDAO.recuperarTodos(criterio);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao recuperar filmes", ex);
            throw new PersistenciaException("Não foi possível recuperar os filmes", ex);
        }
    }

}
