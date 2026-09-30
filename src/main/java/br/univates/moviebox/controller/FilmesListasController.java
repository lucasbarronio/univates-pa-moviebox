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
    public boolean salvar(FilmeLista filmeLista) {
        try {
            filmesListasDAO.salvar(filmeLista);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao salvar relação entre filme id=" + filmeLista.getFilme().getId() + " e lista id=" + filmeLista.getLista().getId(), ex);
            throw new PersistenciaException("Não foi possível salvar a relação entre o filme e a lista", ex);
        }
    }

    @Override
    public boolean existe(FilmeLista filmeLista) {
        try {
            return filmesListasDAO.existe(filmeLista);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao verificar relação entre filme id=" + filmeLista.getFilme().getId() + " e lista id=" + filmeLista.getLista().getId(), ex);
            throw new PersistenciaException("Não foi possível verificar a relação entre o filme e a lista", ex);
        }
    }

    @Override
    public boolean excluir(int idFilme, int idLista) {
        try {
            filmesListasDAO.excluir(idFilme, idLista);
            return true;
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao excluir relação entre filme id=" + idFilme + " e lista id=" + idLista, ex);
            throw new PersistenciaException("Não foi possível excluir a relação entre o filme e a lista", ex);
        }
    }

    @Override
    public ArrayList<FilmeLista> recuperaPorFilme(int idFilme) {
        try {
            return filmesListasDAO.recuperaPorFilme(idFilme);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao recuperar listas relacionadas ao filme id=" + idFilme, ex);
            throw new PersistenciaException("Não foi possível recuperar as listas relacionadas ao filme", ex);
        }
    }

    @Override
    public ArrayList<FilmeLista> recuperaPorLista(int idLista) {
        try {
            return filmesListasDAO.recuperaPorLista(idLista);
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao recuperar filmes relacionados à lista id=" + idLista, ex);
            throw new PersistenciaException("Não foi possível recuperar os filmes relacionados à lista", ex);
        }
    }

    @Override
    public ArrayList<FilmeLista> recuperarTodos() {
        try {
            return filmesListasDAO.recuperarTodos();
        } catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Falha ao recuperar as relações entre filmes e listas", ex);
            throw new PersistenciaException("Não foi possível recuperar as relações entre filmes e listas", ex);
        }
    }

}
