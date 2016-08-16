package peter.j.cadastrousuario.controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import peter.j.cadastrousuario.model.dao.UsuarioDao;
import peter.j.cadastrousuario.model.domain.Usuario;

/**
 *
 * @author Peterson
 */

public class UsuarioController {
    
    private UsuarioDao dao;
    private Usuario usuarioManipulado;
    private List<Usuario> lista;

    public UsuarioController() {
        this.dao = new UsuarioDao();
        this.usuarioManipulado = new Usuario();
        this.lista = new ArrayList<Usuario>();
    }
    
    
    public void pesquisar () {
     this.lista = dao.listar();
    }
    
    public void novo () {
        this.usuarioManipulado = new Usuario ();
    }
    
    public void excluir () {
            this.dao.excluir(this.usuarioManipulado);
        }
    
    
    public void salvar () {
        this.dao.salvar(this.usuarioManipulado);
    }
    
    public void editar () {
        
    }

    public Usuario getUsuarioManipulado() {
        return usuarioManipulado;
    }

    public void setUsuarioManipulado(Usuario usuarioManipulado) {
        this.usuarioManipulado = usuarioManipulado;
    }

    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }
    
}
