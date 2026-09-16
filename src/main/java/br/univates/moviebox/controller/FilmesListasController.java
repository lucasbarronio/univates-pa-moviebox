/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.univates.moviebox.controller;

import br.univates.moviebox.exceptions.PersistenciaException;
import br.univates.moviebox.models.FilmeLista;
import java.util.ArrayList;
import br.univates.moviebox.models.DAO.FilmesListasDAO;
import br.univates.moviebox.utils.FILMESLISTASCONTROLLER_I;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mateus
 */
public class FilmesListasController implements FILMESLISTASCONTROLLER_I<FilmeLista> {

    private static final Logger LOGGER = Logger.getLogger(FilmesListasController.class.getName());
    private FilmesListasDAO filmesListasDAO = new FilmesListasDAO();

    @Override
    public boolean salvar(FilmeLista o) {
        try {
            filmesListasDAO.salvar(o);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao salvar relação filme id=" + o.getFilme().getId() + ", lista id=" + o.getLista().getId(), ex);
            throw new PersistenciaException("Não foi possível salvar a relação filme e lista", ex);
        }
    }

    @Override
    public boolean editar(FilmeLista o) {
        try {
            filmesListasDAO.editar(o);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao editar relação filme id=" + o.getFilme().getId() + ", lista id=" + o.getLista().getId(), ex);
            throw new PersistenciaException("Não foi possível editar a relação filme e lista", ex);
        }

    }

    @Override
    public boolean excluir(int codigoFilme, int codigoLista) {
        try {
            filmesListasDAO.excluir(codigoFilme, codigoLista);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao excluir relação filme id=" + codigoFilme + ", lista id=" + codigoLista, ex);
            throw new PersistenciaException("Não foi possível excluir a relação filme e lista", ex);
        }
    }

    @Override
    public ArrayList<FilmeLista> recuperaPorFilme(int codigo) {
        try {
            return filmesListasDAO.recuperaPorFilme(codigo);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao recuperar listas do filme id=" + codigo, ex);
            throw new PersistenciaException("Não foi possível recuperar as listas do filme", ex);
        }
    }

    @Override
    public ArrayList<FilmeLista> recuperaPorLista(int codigo) {
        try {
            return filmesListasDAO.recuperaPorLista(codigo);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao recuperar filmes da lista id=" + codigo, ex);
            throw new PersistenciaException("Não foi possível recuperar os filmes da lista", ex);
        }
    }

    @Override
    public ArrayList<FilmeLista> recuperarTodos() {
        try {
            return filmesListasDAO.recuperarTodos();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao recuperar relação de filmes e listas", ex);
            throw new PersistenciaException("Não foi possível recuperar relação de filmes e listas", ex);
        }
    }

}
