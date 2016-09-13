package peter.j.cadastrousuario.controller;

import java.util.ArrayList;
import java.util.List;
import peter.j.cadastrousuario.model.dao.MarcaDao;
import peter.j.cadastrousuario.model.domain.Marca;

/**
 *
 * @author Peterson
 */
public class MarcaController {
    
    private MarcaDao dao;
    private Marca marcaManipulado;
    private List<Marca> lista;

    public MarcaController() {
        this.dao = new MarcaDao();
        this.marcaManipulado = null;
        this.lista = new ArrayList<Marca>();
    }
    
    public void pesquisar () {
     this.lista = dao.listar();
    }
    
    public void novo () {
        this.marcaManipulado = new Marca ();
    }
    
    public void excluir () {
            this.dao.excluir(this.marcaManipulado);
        }
    
    
    public void salvar () {
        this.dao.salvar(this.marcaManipulado);
    }
    
    
    public Marca getMarcaManipulado() {
        return marcaManipulado;
    }

    public void setMarcaManipulado(Marca marcaManipulado) {
        this.marcaManipulado = marcaManipulado;
    }

    public List<Marca> getLista() {
        return lista;
    }

    public void setLista(List<Marca> lista) {
        this.lista = lista;
    }
    
}
